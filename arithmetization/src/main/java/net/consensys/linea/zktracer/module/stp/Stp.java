/*
 * Copyright Consensys Software Inc.
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

package net.consensys.linea.zktracer.module.stp;

import static java.lang.Long.max;
import static net.consensys.linea.zktracer.types.AddressUtils.getDeploymentAddress;
import static net.consensys.linea.zktracer.types.Conversions.booleanToBigInteger;
import static net.consensys.linea.zktracer.types.Conversions.longToBytes32;
import static net.consensys.linea.zktracer.types.OpCodeUtils.isCreate;

import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.util.List;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import net.consensys.linea.zktracer.ColumnHeader;
import net.consensys.linea.zktracer.container.stacked.set.StackedSet;
import net.consensys.linea.zktracer.module.Module;
import net.consensys.linea.zktracer.module.hub.Hub;
import net.consensys.linea.zktracer.module.mod.Mod;
import net.consensys.linea.zktracer.module.wcp.Wcp;
import net.consensys.linea.zktracer.opcode.OpCode;
import net.consensys.linea.zktracer.opcode.gas.GasConstants;
import net.consensys.linea.zktracer.types.UnsignedByte;
import org.apache.tuweni.bytes.Bytes32;
import org.hyperledger.besu.datatypes.Address;
import org.hyperledger.besu.evm.frame.MessageFrame;
import org.hyperledger.besu.evm.internal.Words;

@RequiredArgsConstructor
public class Stp implements Module {
  private final Hub hub;
  private final Wcp wcp;
  private final Mod mod;

  @Override
  public String jsonKey() {
    return "stp";
  }

  private final StackedSet<StpChunk> chunks = new StackedSet<>();

  @Override
  public void enterTransaction() {
    this.chunks.enter();
  }

  @Override
  public void popTransaction() {
    this.chunks.pop();
  }

  @Override
  public int lineCount() {
    int traceRowSize = 0;
    for (StpChunk chunk : this.chunks) {
      traceRowSize += ctMax(chunk) + 1;
    }
    return traceRowSize;
  }

  @Override
  public List<ColumnHeader> columnsHeaders() {
    return Trace.headers(this.lineCount());
  }

  @Override
  public void tracePreOpcode(final MessageFrame frame) {
    OpCode opCode = hub.opCode();

    switch (opCode) {
      case CREATE, CREATE2 -> {
        final StpChunk chunk = getCreateData(frame);
        this.chunks.add(chunk);
        this.wcp.callLT(longToBytes32(chunk.gasActual()), Bytes32.ZERO);
        this.wcp.callLT(longToBytes32(chunk.gasActual()), longToBytes32(chunk.gasPrelim()));
        if (!chunk.oogx()) {
          this.mod.callDiv(longToBytes32(getGDiff(chunk)), longToBytes32(64L));
        }
      }
      case CALL, CALLCODE, DELEGATECALL, STATICCALL -> {
        final StpChunk chunk = getCallData(frame);
        this.chunks.add(chunk);
        this.wcp.callLT(longToBytes32(chunk.gasActual()), Bytes32.ZERO);
        if (cctv(chunk.opCode())) {
          this.wcp.callISZERO(Bytes32.leftPad(chunk.value()));
        }
        this.wcp.callLT(longToBytes32(chunk.gasActual()), longToBytes32(chunk.gasPrelim()));
        if (!chunk.oogx()) {
          this.mod.callDiv(longToBytes32(getGDiff(chunk)), longToBytes32(64L));
          this.wcp.callLT(chunk.gas().orElseThrow(), longToBytes32(get63of64GDiff(chunk)));
        }
      }
    }
  }

  private StpChunk getCreateData(final MessageFrame frame) {
    final Address to = getDeploymentAddress(frame);
    final Long gasRemaining = frame.getRemainingGas();
    final Long gasMxp = getGasMxpCreate(frame);
    final Long gasPrelim = GasConstants.G_CREATE.cost() + gasMxp;
    return new StpChunk(
        OpCode.of(frame.getCurrentOperation().getOpcode()),
        gasRemaining,
        gasPrelim,
        gasRemaining < gasPrelim,
        gasMxp,
        frame.getWorldUpdater().get(frame.getContractAddress()).getBalance(),
        to,
        Bytes32.leftPad(frame.getStackItem(0)));
  }

  private StpChunk getCallData(final MessageFrame frame) {
    final OpCode opcode = OpCode.of(frame.getCurrentOperation().getOpcode());
    final long gasActual = frame.getRemainingGas();
    final Bytes32 value = cctv(opcode) ? Bytes32.leftPad(frame.getStackItem(2)) : Bytes32.ZERO;
    final Address to = Words.toAddress(frame.getStackItem(1));
    final Long gasMxp = getGasMxpCall(frame);
    final boolean toWarm = frame.isAddressWarm(to);
    final boolean toExists =
        opcode == OpCode.CALLCODE
            || (frame.getWorldUpdater().get(to) != null
                && !frame.getWorldUpdater().get(to).isEmpty());

    long gasPrelim = gasMxp;
    if (!value.isZero() && cctv(opcode)) {
      gasPrelim += GasConstants.G_CALL_VALUE.cost();
    }
    if (toWarm) {
      gasPrelim += GasConstants.G_WARM_ACCESS.cost();
    } else {
      gasPrelim += GasConstants.G_COLD_ACCOUNT_ACCESS.cost();
    }
    if (!toExists) {
      gasPrelim += GasConstants.G_NEW_ACCOUNT.cost();
    }
    final boolean oogx = gasActual < gasPrelim;
    return new StpChunk(
        opcode,
        gasActual,
        gasPrelim,
        oogx,
        gasMxp,
        frame.getWorldUpdater().get(frame.getContractAddress()).getBalance(),
        to,
        value,
        toExists,
        toWarm,
        Bytes32.leftPad(frame.getStackItem(0)));
  }

  private boolean cctv(OpCode opCode) {
    return (opCode == OpCode.CALL) || (opCode == OpCode.CALLCODE);
  }

  // TODO get from Hub.GasProjector
  private Long getGasMxpCreate(final MessageFrame frame) {
    long gasMxp = 0;
    long offset = Words.clampedToLong(frame.getStackItem(1));
    long length = Words.clampedToLong(frame.getStackItem(2));
    long currentMemorySizeInWords = frame.memoryWordSize();
    long updatedMemorySizeInWords = frame.calculateMemoryExpansion(offset, length);
    if (currentMemorySizeInWords < updatedMemorySizeInWords) {
      // computing the "linear" portion of CREATE2 memory expansion cost
      long G_mem = GasConstants.G_MEMORY.cost();
      long squareCurrent = (currentMemorySizeInWords * currentMemorySizeInWords) >> 9;
      long squareUpdated = (updatedMemorySizeInWords * updatedMemorySizeInWords) >> 9;
      gasMxp +=
          G_mem * (updatedMemorySizeInWords - currentMemorySizeInWords)
              + (squareUpdated - squareCurrent);
    }
    if (OpCode.of(frame.getCurrentOperation().getOpcode()) == OpCode.CREATE2) {
      long lengthInWords = (length + 31) >> 5; // ⌈ length / 32 ⌉
      gasMxp += lengthInWords * GasConstants.G_KECCAK_256_WORD.cost();
    }
    return gasMxp;
  }

  // TODO get from Hub.GasProjector
  private Long getGasMxpCall(final MessageFrame frame) {
    long gasMxp = 0;

    int offset = cctv(OpCode.of(frame.getCurrentOperation().getOpcode())) ? 1 : 0;
    long cdo = Words.clampedToLong(frame.getStackItem(2 + offset)); // call data offset
    long cds = Words.clampedToLong(frame.getStackItem(3 + offset)); // call data size
    long rdo = Words.clampedToLong(frame.getStackItem(4 + offset)); // return data offset
    long rdl = Words.clampedToLong(frame.getStackItem(5 + offset)); // return data size

    long memSize = frame.memoryWordSize();
    long memSizeCallData = frame.calculateMemoryExpansion(cdo, cds);
    long memSizeReturnData = frame.calculateMemoryExpansion(rdo, rdl);
    long maybeNewMemSize = max(memSizeReturnData, memSizeCallData);

    if (memSize < maybeNewMemSize) {
      // computing the "linear" portion of CREATE2 memory expansion cost
      long G_mem = GasConstants.G_MEMORY.cost();
      long squareCurrent = (memSize * memSize) >> 9;
      long squareUpdated = (maybeNewMemSize * maybeNewMemSize) >> 9;
      gasMxp += G_mem * (maybeNewMemSize - memSize) + (squareUpdated - squareCurrent);
    }
    return gasMxp;
  }

  private void traceChunks(StpChunk chunk, int stamp, Trace trace) {
    if (isCreate(chunk.opCode())) {
      traceCreate(chunk, stamp, trace);
    } else {
      traceCall(chunk, stamp, trace);
    }
  }

  private long getGDiff(StpChunk chunk) {
    Preconditions.checkArgument(!chunk.oogx());
    return chunk.gasActual() - chunk.gasPrelim();
  }

  private long getGDiffOver64(StpChunk chunk) {
    return getGDiff(chunk) / 64;
  }

  private long get63of64GDiff(StpChunk chunk) {
    return getGDiff(chunk) - getGDiffOver64(chunk);
  }

  private void traceCreate(StpChunk chunk, int stamp, Trace trace) {
    final int ctMax = ctMax(chunk);
    final long gasOopkt = chunk.oogx() ? 0 : get63of64GDiff(chunk);

    for (int ct = 0; ct <= ctMax; ct++) {
      trace
          .stamp(BigInteger.valueOf(stamp))
          .ct(BigInteger.valueOf(ct))
          .ctMax(BigInteger.valueOf(ctMax))
          .instruction(UnsignedByte.of(chunk.opCode().byteValue()))
          .isCreate(chunk.opCode() == OpCode.CREATE)
          .isCreate2(chunk.opCode() == OpCode.CREATE2)
          .isCall(false)
          .isCallcode(false)
          .isDelegatecall(false)
          .isStaticcall(false)
          .gasHi(BigInteger.ZERO)
          .gasLo(BigInteger.ZERO)
          .valHi(chunk.value().slice(0, 16).toUnsignedBigInteger())
          .valLo(chunk.value().slice(16, 16).toUnsignedBigInteger())
          .exists(false) // TODO document this
          .warm(false) // TODO document this
          .outOfGasException(chunk.oogx())
          .gasActual(BigInteger.valueOf(chunk.gasActual()))
          .gasMxp(BigInteger.valueOf(chunk.gasMxp()))
          .gasUpfront(BigInteger.valueOf(chunk.gasPrelim()))
          .gasOopkt(BigInteger.valueOf(gasOopkt))
          .gasStipend(BigInteger.ZERO)
          .arg1Hi(BigInteger.ZERO);

      switch (ct) {
        case 0 -> trace
            .arg1Lo(BigInteger.valueOf(chunk.gasActual()))
            .arg2Lo(BigInteger.ZERO)
            .exogenousModuleInstruction(UnsignedByte.of(OpCode.LT.byteValue()))
            .resLo(BigInteger.ZERO) // we REQUIRE that the currently available gas is nonnegative
            .wcpFlag(true)
            .modFlag(false)
            .validateRow();
        case 1 -> trace
            .arg1Lo(BigInteger.valueOf(chunk.gasActual()))
            .arg2Lo(BigInteger.valueOf(chunk.gasPrelim()))
            .exogenousModuleInstruction(UnsignedByte.of(OpCode.LT.byteValue()))
            .resLo(booleanToBigInteger(chunk.oogx()))
            .wcpFlag(true)
            .modFlag(false)
            .validateRow();
        case 2 -> trace
            .arg1Lo(BigInteger.valueOf(getGDiff(chunk)))
            .arg2Lo(BigInteger.valueOf(64))
            .exogenousModuleInstruction(UnsignedByte.of(OpCode.DIV.byteValue()))
            .resLo(BigInteger.valueOf(getGDiffOver64(chunk)))
            .wcpFlag(false)
            .modFlag(true)
            .validateRow();
        default -> throw new IllegalArgumentException("counter too big, should be <=" + ctMax);
      }
    }
  }

  private void traceCall(StpChunk chunk, int stamp, Trace trace) {
    final int ctMax = ctMax(chunk);
    final long gasStipend =
        (!chunk.oogx() && cctv(chunk.opCode()) && !chunk.value().isZero())
            ? GasConstants.G_CALL_STIPEND.cost()
            : 0;
    final BigInteger gasOopkt =
        chunk.oogx()
            ? BigInteger.ZERO
            : chunk
                .gas()
                .orElseThrow()
                .toUnsignedBigInteger()
                .min(BigInteger.valueOf(get63of64GDiff(chunk)));

    for (int ct = 0; ct <= ctMax; ct++) {
      trace
          .stamp(BigInteger.valueOf(stamp))
          .ct(BigInteger.valueOf(ct))
          .ctMax(BigInteger.valueOf(ctMax))
          .instruction(UnsignedByte.of(chunk.opCode().byteValue()))
          .isCreate(false)
          .isCreate2(false)
          .isCall(chunk.opCode() == OpCode.CALL)
          .isCallcode(chunk.opCode() == OpCode.CALLCODE)
          .isDelegatecall(chunk.opCode() == OpCode.DELEGATECALL)
          .isStaticcall(chunk.opCode() == OpCode.STATICCALL)
          .gasHi(chunk.gas().orElseThrow().slice(0, 16).toUnsignedBigInteger())
          .gasLo(chunk.gas().orElseThrow().slice(16).toUnsignedBigInteger())
          .valHi(chunk.value().slice(0, 16).toUnsignedBigInteger())
          .valLo(chunk.value().slice(16).toUnsignedBigInteger())
          .exists(chunk.toExists().orElseThrow())
          .warm(chunk.toWarm().orElseThrow())
          .outOfGasException(chunk.oogx())
          .gasActual(BigInteger.valueOf(chunk.gasActual()))
          .gasMxp(BigInteger.valueOf(chunk.gasMxp()))
          .gasUpfront(BigInteger.valueOf(chunk.gasPrelim()))
          .gasOopkt(gasOopkt)
          .gasStipend(BigInteger.valueOf(gasStipend));

      switch (ct) {
        case 0 -> trace
            .arg1Hi(BigInteger.ZERO)
            .arg1Lo(BigInteger.valueOf(chunk.gasActual()))
            .arg2Lo(BigInteger.ZERO)
            .exogenousModuleInstruction(UnsignedByte.of(OpCode.LT.byteValue()))
            .resLo(BigInteger.ZERO) // we REQUIRE that the currently available gas is nonnegative
            .wcpFlag(true)
            .modFlag(false)
            .validateRow();
        case 1 -> trace
            .arg1Hi(chunk.value().slice(0, 16).toUnsignedBigInteger())
            .arg1Lo(chunk.value().slice(16, 16).toUnsignedBigInteger())
            .arg2Lo(BigInteger.ZERO)
            .exogenousModuleInstruction(UnsignedByte.of(OpCode.ISZERO.byteValue()))
            .resLo(booleanToBigInteger(chunk.value().isZero()))
            .wcpFlag(cctv(chunk.opCode()))
            .modFlag(false)
            .validateRow();
        case 2 -> trace
            .arg1Hi(BigInteger.ZERO)
            .arg1Lo(BigInteger.valueOf(chunk.gasActual()))
            .arg2Lo(BigInteger.valueOf(chunk.gasPrelim()))
            .exogenousModuleInstruction(UnsignedByte.of(OpCode.LT.byteValue()))
            .resLo(booleanToBigInteger(chunk.oogx()))
            .wcpFlag(true)
            .modFlag(false)
            .validateRow();
          // the following rows are only filled in if no out of gas exception
        case 3 -> trace
            .arg1Hi(BigInteger.ZERO)
            .arg1Lo(BigInteger.valueOf(getGDiff(chunk)))
            .arg2Lo(BigInteger.valueOf(64))
            .exogenousModuleInstruction(UnsignedByte.of(OpCode.DIV.byteValue()))
            .resLo(BigInteger.valueOf(getGDiffOver64(chunk)))
            .wcpFlag(false)
            .modFlag(true)
            .validateRow();
        case 4 -> trace
            .arg1Hi(chunk.gas().orElseThrow().slice(0, 16).toUnsignedBigInteger())
            .arg1Lo(chunk.gas().orElseThrow().slice(16, 16).toUnsignedBigInteger())
            .arg2Lo(BigInteger.valueOf(getGDiff(chunk) - getGDiffOver64(chunk)))
            .exogenousModuleInstruction(UnsignedByte.of(OpCode.LT.byteValue()))
            .resLo(
                booleanToBigInteger(
                    chunk
                            .gas()
                            .orElseThrow()
                            .toUnsignedBigInteger()
                            .compareTo(BigInteger.valueOf(get63of64GDiff(chunk)))
                        < 0))
            .wcpFlag(true)
            .modFlag(false)
            .validateRow();
        default -> throw new IllegalArgumentException("counter too big, should be <=" + ctMax);
      }
    }
  }

  @Override
  public void commit(List<MappedByteBuffer> buffers) {

    final Trace trace = new Trace(buffers);
    int stamp = 0;
    for (StpChunk chunk : chunks) {
      stamp++;
      traceChunks(chunk, stamp, trace);
    }
  }

  private int ctMax(StpChunk chunk) {
    if (chunk.oogx()) {
      if (isCreate(chunk.opCode())) {
        return 1;
      } else {
        return 2;
      }
    } else {
      if (isCreate(chunk.opCode())) {
        return 2;
      } else {
        return 4;
      }
    }
  }
}