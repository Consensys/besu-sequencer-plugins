/*
 * Copyright ConsenSys Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package net.consensys.linea.zktracer.module.blake2fmodexpdata;

import static net.consensys.linea.zktracer.types.Conversions.bigIntegerToBytes;
import static net.consensys.linea.zktracer.types.Conversions.bytesToUnsignedBytes;
import static net.consensys.linea.zktracer.types.Utils.leftPadTo;
import static net.consensys.linea.zktracer.types.Utils.rightPadTo;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.google.common.base.Preconditions;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.consensys.linea.zktracer.container.ModuleOperation;
import net.consensys.linea.zktracer.types.UnsignedByte;
import org.apache.tuweni.bytes.Bytes;
import org.hyperledger.besu.crypto.Hash;

@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Accessors(fluent = true)
public class Blake2fModexpDataOperation extends ModuleOperation {
  private static final int MODEXP_COMPONENT_INT_BYTE_SIZE = 32;
  private static final int MODEXP_COMPONENT_SIZE = 512;
  private static final int MODEXP_LIMB_INT_BYTE_SIZE = 16;
  private static final int BLAKE2f_DATA_SIZE = Trace.INDEX_MAX_BLAKE_DATA + 1;
  private static final int BLAKE2f_RESULT_SIZE = Trace.INDEX_MAX_BLAKE_RESULT + 1;
  private static final int BLAKE2f_PARAMS_SIZE = Trace.INDEX_MAX_BLAKE_PARAMS + 1;
  private static final int BLAKE2f_LIMB_INT_BYTE_SIZE = 16;
  private static final int MODEXP_COMPONENTS_LINE_COUNT = 32 * 4;
  private static final int BLAKE2f_COMPONENTS_LINE_COUNT =
      BLAKE2f_DATA_SIZE + BLAKE2f_RESULT_SIZE + BLAKE2f_PARAMS_SIZE;

  private static final Map<Integer, PhaseInfo> PHASE_INFO_MAP =
      Map.of(
          Trace.PHASE_MODEXP_BASE,
              new PhaseInfo(Trace.PHASE_MODEXP_BASE, Trace.INDEX_MAX_MODEXP_BASE),
          Trace.PHASE_MODEXP_EXPONENT,
              new PhaseInfo(Trace.PHASE_MODEXP_EXPONENT, Trace.INDEX_MAX_MODEXP_EXPONENT),
          Trace.PHASE_MODEXP_MODULUS,
              new PhaseInfo(Trace.PHASE_MODEXP_MODULUS, Trace.INDEX_MAX_MODEXP_MODULUS),
          Trace.PHASE_MODEXP_RESULT,
              new PhaseInfo(Trace.PHASE_MODEXP_RESULT, Trace.INDEX_MAX_MODEXP_RESULT),
          Trace.PHASE_BLAKE_DATA, new PhaseInfo(Trace.PHASE_BLAKE_DATA, Trace.INDEX_MAX_BLAKE_DATA),
          Trace.PHASE_BLAKE_PARAMS,
              new PhaseInfo(Trace.PHASE_BLAKE_PARAMS, Trace.INDEX_MAX_BLAKE_PARAMS),
          Trace.PHASE_BLAKE_RESULT,
              new PhaseInfo(Trace.PHASE_BLAKE_RESULT, Trace.INDEX_MAX_BLAKE_RESULT));

  @EqualsAndHashCode.Include private final int hubStamp;
  @Getter private int prevHubStamp;

  @EqualsAndHashCode.Include private final Optional<ModexpComponents> modexpComponents;
  @EqualsAndHashCode.Include private final Optional<Blake2fComponents> blake2fComponents;

  public Blake2fModexpDataOperation(
      int hubStamp,
      int prevHubStamp,
      ModexpComponents modexpComponents,
      Blake2fComponents blake2fComponents) {
    this.hubStamp = hubStamp;
    this.prevHubStamp = prevHubStamp;
    this.modexpComponents = Optional.ofNullable(modexpComponents);
    this.blake2fComponents = Optional.ofNullable(blake2fComponents);
  }

  @Override
  protected int computeLineCount() {
    return modexpComponents.isPresent() ? MODEXP_COMPONENTS_LINE_COUNT : BLAKE2f_COMPONENTS_LINE_COUNT;
  }

  void trace(Trace trace, int stamp) {
    final UnsignedByte stampByte = UnsignedByte.of(stamp);
    final Bytes currentHubStamp = Bytes.ofUnsignedInt(this.hubStamp + 1);

    final UnsignedByte[] hubStampDiffBytes = getHubStampDiffBytes(currentHubStamp);

    final Bytes modexpComponentsLimb =
        modexpComponents.map(this::buildModexpComponentsLimb).orElse(Bytes.EMPTY);

    final Bytes blake2fResult =
        blake2fComponents.map(c -> computeBlake2fResult(c.rawInput())).orElse(Bytes.EMPTY);

    var tracerBuilder =
        Blake2fModexpTraceHelper.builder()
            .trace(trace)
            .currentHubStamp(currentHubStamp)
            .prevHubStamp(prevHubStamp)
            .phaseInfoMap(PHASE_INFO_MAP)
            .hubStampDiffBytes(hubStampDiffBytes)
            .stampByte(stampByte);

    if (modexpComponents.isPresent()) {
      Blake2fModexpTraceHelper modexpTraceHelper =
          tracerBuilder
              .startPhaseIndex(Trace.PHASE_MODEXP_BASE)
              .endPhaseIndex(Trace.PHASE_MODEXP_RESULT)
              .currentRowIndexFunction(
                  ((phaseInfo, phaseIndex, index) ->
                      phaseInfo.indexMax() * (phaseIndex - 1) + index))
              .traceLimbConsumer(
                  (rowIndex) -> {
                    if (!modexpComponentsLimb.isEmpty()) {
                      trace.limb(
                          modexpComponentsLimb.slice(
                              MODEXP_LIMB_INT_BYTE_SIZE * rowIndex, MODEXP_LIMB_INT_BYTE_SIZE));
                    }
                  })
              .build();

      modexpTraceHelper.trace();

      prevHubStamp = modexpTraceHelper.prevHubStamp();
    }

    if (blake2fComponents.isPresent()) {
      Blake2fComponents components = blake2fComponents.get();
      Blake2fModexpTraceHelper blake2fTraceHelper =
          tracerBuilder
              .startPhaseIndex(Trace.PHASE_BLAKE_DATA)
              .endPhaseIndex(Trace.PHASE_BLAKE_RESULT)
              .currentRowIndexFunction(((phaseInfo, phaseIndex, index) -> index))
              .traceLimbConsumer(
                  (rowIndex) -> {
                    if (rowIndex <= Trace.INDEX_MAX_BLAKE_DATA) {
                      trace.limb(
                          components
                              .data()
                              .slice(
                                  BLAKE2f_LIMB_INT_BYTE_SIZE * rowIndex,
                                  BLAKE2f_LIMB_INT_BYTE_SIZE));
                    } else if (rowIndex
                        <= Trace.INDEX_MAX_BLAKE_DATA + Trace.INDEX_MAX_BLAKE_PARAMS + 1) {
                      trace.limb(components.r());
                      trace.limb(components.f());
                    } else {
                      trace.limb(
                          blake2fResult.slice(
                              BLAKE2f_LIMB_INT_BYTE_SIZE * rowIndex, BLAKE2f_LIMB_INT_BYTE_SIZE));
                    }
                  })
              .build();

      blake2fTraceHelper.trace();

      prevHubStamp = blake2fTraceHelper.prevHubStamp();
    }
  }

  private Bytes buildModexpComponentsLimb(ModexpComponents components) {
    final Bytes result = computeModexpResult(components);
    final Bytes basePadded = leftPadTo(components.base(), MODEXP_COMPONENT_SIZE);
    final Bytes expPadded = leftPadTo(components.exp(), MODEXP_COMPONENT_SIZE);
    final Bytes modPadded = leftPadTo(components.mod(), MODEXP_COMPONENT_SIZE);
    final Bytes resultPadded = leftPadTo(result, MODEXP_COMPONENT_SIZE);

    return Bytes.concatenate(basePadded, expPadded, modPadded, resultPadded);
  }

  private Bytes computeModexpResult(ModexpComponents modexpComponents) {
    final BigInteger baseBigInt = modexpComponents.base().toUnsignedBigInteger();
    final BigInteger expBigInt = modexpComponents.exp().toUnsignedBigInteger();
    final BigInteger modBigInt = modexpComponents.mod().toUnsignedBigInteger();

    if (List.of(baseBigInt, expBigInt, modBigInt).contains(BigInteger.ZERO)) {
      return Bytes.EMPTY;
    }

    return bigIntegerToBytes(baseBigInt.modPow(expBigInt, modBigInt));
  }

  private Bytes computeBlake2fResult(Bytes input) {
    return Hash.blake2bf(input);
  }

  private UnsignedByte[] getHubStampDiffBytes(Bytes currentHubStamp) {
    BigInteger prevHubStampBigInt = BigInteger.valueOf(prevHubStamp);
    BigInteger hubStampBigInt = currentHubStamp.toUnsignedBigInteger();
    BigInteger hubStampDiff = hubStampBigInt.subtract(prevHubStampBigInt).subtract(BigInteger.ONE);

    Preconditions.checkArgument(
        hubStampDiff.compareTo(BigInteger.valueOf(256 ^ 6)) < 0,
        "Hub stamp difference should never exceed 256 ^ 6");

    return bytesToUnsignedBytes(
        rightPadTo(leftPadTo(bigIntegerToBytes(hubStampDiff), 6), 128).toArray());
  }
}
