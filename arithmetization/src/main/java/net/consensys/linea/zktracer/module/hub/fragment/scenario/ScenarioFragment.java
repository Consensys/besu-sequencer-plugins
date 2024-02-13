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

package net.consensys.linea.zktracer.module.hub.fragment.scenario;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import net.consensys.linea.zktracer.module.hub.Hub;
import net.consensys.linea.zktracer.module.hub.Trace;
import net.consensys.linea.zktracer.module.hub.defer.PostTransactionDefer;
import net.consensys.linea.zktracer.module.hub.fragment.TraceFragment;
import net.consensys.linea.zktracer.module.hub.precompiles.PrecompileInvocation;
import net.consensys.linea.zktracer.types.MemorySpan;
import net.consensys.linea.zktracer.types.Precompile;
import org.apache.tuweni.bytes.Bytes;
import org.hyperledger.besu.datatypes.Transaction;
import org.hyperledger.besu.evm.worldstate.WorldView;

/** This machine generates lines */
@RequiredArgsConstructor
public class ScenarioFragment implements TraceFragment, PostTransactionDefer {
  private enum CallType {
    /** describes a normal call */
    CALL,
    /** describes the second scenario line required by a call to a precompile */
    PRECOMPILE,
    /** describes a call into initcode */
    CREATE,
    /** describes a RETURN from initcode */
    CODE_DEPOSIT;

    boolean isCall() {
      return this == CALL;
    }

    boolean isPrecompile() {
      return this == PRECOMPILE;
    }

    boolean isCreate() {
      return this == CREATE;
    }

    boolean isDeposit() {
      return this == CODE_DEPOSIT;
    }
  }

  private final Optional<PrecompileInvocation> precompileCall;
  private final CallType type;

  /**
   * Is set if: - this is a CALL to an EOA or a precompile - this is a CREATE with an empty initcode
   */
  private final boolean targetHasCode;

  private final int callerId;
  private final int calleeId;
  private final boolean raisedException;
  private final boolean hasAborted;
  private final boolean hasFailed;
  private final boolean raisedInvalidCodePrefix;

  private boolean callerReverts = false;

  MemorySpan callDataSegment;
  MemorySpan requestedReturnDataSegment;

  /**
   * Is set if: - this is a CALL and the callee reverts - this is a CREATE and the creation failed -
   * this is a PRECOMPILE and the call is invalid (wrong arguments, lack of gas, ...)
   */
  private boolean childContextFails = false;

  public static ScenarioFragment forCall(final Hub hub, boolean targetHasCode) {
    return new ScenarioFragment(
        Optional.empty(),
        CallType.CALL,
        targetHasCode,
        hub.currentFrame().id(),
        hub.callStack().futureId(),
        hub.pch().exceptions().any(),
        hub.pch().aborts().any(),
        hub.pch().failures().any(),
        hub.pch().exceptions().invalidCodePrefix());
  }

  public static ScenarioFragment forSmartContractCallSection(int callerFrameId, int calleeFrameId) {
    return new ScenarioFragment(
        Optional.empty(),
        CallType.CALL,
        true,
        callerFrameId,
        calleeFrameId,
        false,
        false,
        false,
        false);
  }

  public static ScenarioFragment forNoCodeCallSection(
      Optional<PrecompileInvocation> precompileCall, int callerId, int calleeId) {
    if (precompileCall.isPresent()) {
      return new ScenarioFragment(
          precompileCall, CallType.CALL, false, callerId, calleeId, false, false, false, false);
    } else {
      return new ScenarioFragment(
          Optional.empty(), CallType.CALL, false, callerId, calleeId, false, false, false, false);
    }
  }

  public static ScenarioFragment forPrecompileEpilogue(
      PrecompileInvocation precompile, int callerId, int calleeId) {
    return new ScenarioFragment(
        Optional.of(precompile),
        CallType.PRECOMPILE,
        false,
        callerId,
        calleeId,
        false,
        false,
        false,
        false);
  }

  private boolean calleeSelfReverts() {
    return this.childContextFails;
  }

  private boolean creationFailed() {
    return this.childContextFails;
  }

  private boolean successfulPrecompileCall() {
    return !this.childContextFails;
  }

  private boolean targetIsPrecompile() {
    return this.precompileCall.isPresent();
  }

  @Override
  public void runPostTx(Hub hub, WorldView state, Transaction tx) {
    this.callerReverts = hub.callStack().get(callerId).hasReverted();
    this.childContextFails = hub.callStack().get(calleeId).hasReverted();

    this.callDataSegment = hub.callStack().get(calleeId).callDataSource();
    this.requestedReturnDataSegment = hub.callStack().get(calleeId).returnDataTarget();
  }

  @Override
  public Trace trace(Trace trace) {
    return trace
        .peekAtScenario(true)
        .pScenarioCallException(type.isCall() && raisedException)
        .pScenarioCallAbort(type.isCall() && hasAborted)
        .pScenarioCallPrcFailure(
            type.isCall()
                && !hasAborted
                && targetIsPrecompile()
                && !callerReverts
                && this.calleeSelfReverts())
        .pScenarioCallPrcSuccessCallerWillRevert(
            type.isCall()
                && !hasAborted
                && targetIsPrecompile()
                && callerReverts
                && !this.calleeSelfReverts())
        .pScenarioCallPrcSuccessCallerWontRevert(
            type.isCall()
                && !hasAborted
                && targetIsPrecompile()
                && !callerReverts
                && !this.calleeSelfReverts())
        .pScenarioCallSmcFailureCallerWillRevert(
            type.isCall()
                && !hasAborted
                && targetHasCode
                && callerReverts
                && this.calleeSelfReverts())
        .pScenarioCallSmcFailureCallerWontRevert(
            type.isCall()
                && !hasAborted
                && targetHasCode
                && !callerReverts
                && this.calleeSelfReverts())
        .pScenarioCallSmcSuccessCallerWontRevert(
            type.isCall()
                && !hasAborted
                && targetHasCode
                && !callerReverts
                && !this.calleeSelfReverts())
        .pScenarioCallSmcSuccessCallerWillRevert(
            type.isCall()
                && !hasAborted
                && targetHasCode
                && callerReverts
                && !this.calleeSelfReverts())
        .pScenarioCallEoaSuccessCallerWontRevert(
            type.isCall()
                && !hasAborted
                && !targetIsPrecompile()
                && !targetHasCode
                && !callerReverts)
        .pScenarioCallEoaSuccessCallerWillRevert(
            type.isCall()
                && !hasAborted
                && !targetIsPrecompile()
                && !targetHasCode
                && callerReverts)
        .pScenarioCreateException(type.isCreate() && raisedException)
        .pScenarioCreateAbort(type.isCreate() && hasAborted)
        .pScenarioCreateFailureConditionWillRevert(type.isCreate() && hasFailed && callerReverts)
        .pScenarioCreateFailureConditionWontRevert(type.isCreate() && hasFailed && !callerReverts)
        .pScenarioCreateEmptyInitCodeWillRevert(type.isCreate() && !targetHasCode && callerReverts)
        .pScenarioCreateEmptyInitCodeWontRevert(type.isCreate() && !targetHasCode && !callerReverts)
        .pScenarioCreateNonemptyInitCodeFailureWillRevert(
            type.isCreate() && targetHasCode && creationFailed() && callerReverts)
        .pScenarioCreateNonemptyInitCodeFailureWontRevert(
            type.isCreate() && targetHasCode && creationFailed() && !callerReverts)
        .pScenarioCreateNonemptyInitCodeSuccessWillRevert(
            type.isCreate() && targetHasCode && !creationFailed() && callerReverts)
        .pScenarioCreateNonemptyInitCodeSuccessWontRevert(
            type.isCreate() && targetHasCode && !creationFailed() && !callerReverts)
        .pScenarioEcrecover(
            precompileCall.map(x -> x.precompile().equals(Precompile.EC_RECOVER)).orElse(false))
        .pScenarioSha2256(
            precompileCall.map(x -> x.precompile().equals(Precompile.SHA2_256)).orElse(false))
        .pScenarioRipemd160(
            precompileCall.map(x -> x.precompile().equals(Precompile.RIPEMD_160)).orElse(false))
        .pScenarioIdentity(
            precompileCall.map(x -> x.precompile().equals(Precompile.IDENTITY)).orElse(false))
        .pScenarioModexp(
            precompileCall.map(x -> x.precompile().equals(Precompile.MODEXP)).orElse(false))
        .pScenarioEcadd(
            precompileCall.map(x -> x.precompile().equals(Precompile.EC_ADD)).orElse(false))
        .pScenarioEcmul(
            precompileCall.map(x -> x.precompile().equals(Precompile.EC_MUL)).orElse(false))
        .pScenarioEcpairing(
            precompileCall.map(x -> x.precompile().equals(Precompile.EC_PAIRING)).orElse(false))
        .pScenarioBlake2F(
            precompileCall.map(x -> x.precompile().equals(Precompile.BLAKE2F)).orElse(false))
        .pScenarioPrcSuccessWillRevert(
            type.isPrecompile() && successfulPrecompileCall() && callerReverts)
        .pScenarioPrcSuccessWontRevert(
            type.isPrecompile() && successfulPrecompileCall() && !callerReverts)
        .pScenarioPrcFailureKnownToHub(
            precompileCall.map(PrecompileInvocation::hubFailure).orElse(false))
        .pScenarioPrcFailureKnownToRam(
            precompileCall.map(PrecompileInvocation::ramFailure).orElse(false))
        .pScenarioPrcCallerGas(
            precompileCall
                .map(s -> Bytes.ofUnsignedLong(s.gasAtCall() - s.opCodeGas()))
                .orElse(Bytes.EMPTY))
        .pScenarioPrcCalleeGas(
            precompileCall.map(s -> Bytes.ofUnsignedLong(s.gasAllowance())).orElse(Bytes.EMPTY))
        .pScenarioPrcReturnGas(
            precompileCall
                .filter(s -> successfulPrecompileCall())
                .map(s -> Bytes.ofUnsignedLong(s.gasAllowance() - s.precompilePrice()))
                .orElse(Bytes.EMPTY))
        .pScenarioPrcCdo(
            type.isPrecompile() ? Bytes.ofUnsignedLong(callDataSegment.offset()) : Bytes.EMPTY)
        .pScenarioPrcCds(
            type.isPrecompile() ? Bytes.ofUnsignedLong(callDataSegment.length()) : Bytes.EMPTY)
        .pScenarioPrcRao(
            type.isPrecompile()
                ? Bytes.ofUnsignedLong(requestedReturnDataSegment.offset())
                : Bytes.EMPTY)
        .pScenarioPrcRac(
            type.isPrecompile()
                ? Bytes.ofUnsignedLong(requestedReturnDataSegment.length())
                : Bytes.EMPTY)
        .pScenarioCodedeposit(type.isDeposit())
        .pScenarioCodedepositInvalidCodePrefix(type.isDeposit() && raisedInvalidCodePrefix)
        .pScenarioCodedepositValidCodePrefix(false) // TODO: @Olivier
        .pScenarioSelfdestruct(false); // TODO: @Olivier
  }
}
