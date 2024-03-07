/*
 * Copyright ConsenSys AG.
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

package net.consensys.linea.zktracer.module.oob;

import static com.google.common.math.BigIntegerMath.log2;
import static java.lang.Byte.toUnsignedInt;
import static java.lang.Math.min;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_BLAKE2F_cds;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_BLAKE2F_params;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_CALL;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_CDL;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_CREATE;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_DEPLOYMENT;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_ECADD;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_ECMUL;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_ECPAIRING;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_ECRECOVER;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_IDENTITY;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_JUMP;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_JUMPI;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_MODEXP_cds;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_MODEXP_extract;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_MODEXP_lead;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_MODEXP_pricing;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_MODEXP_xbs;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_RDC;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_RIPEMD;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_SHA2;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_SSTORE;
import static net.consensys.linea.zktracer.module.oob.Trace.CT_MAX_XCALL;
import static net.consensys.linea.zktracer.module.oob.Trace.G_CALLSTIPEND;
import static net.consensys.linea.zktracer.module.oob.Trace.G_QUADDIVISOR;
import static net.consensys.linea.zktracer.types.AddressUtils.getDeploymentAddress;
import static net.consensys.linea.zktracer.types.Conversions.bigIntegerToBoolean;
import static net.consensys.linea.zktracer.types.Conversions.booleanToBigInteger;
import static net.consensys.linea.zktracer.types.Conversions.booleanToInt;

import java.math.BigInteger;
import java.math.RoundingMode;

import lombok.Getter;
import net.consensys.linea.zktracer.ZkTracer;
import net.consensys.linea.zktracer.container.ModuleOperation;
import net.consensys.linea.zktracer.module.add.Add;
import net.consensys.linea.zktracer.module.hub.Hub;
import net.consensys.linea.zktracer.module.mod.Mod;
import net.consensys.linea.zktracer.module.wcp.Wcp;
import net.consensys.linea.zktracer.opcode.OpCode;
import net.consensys.linea.zktracer.types.EWord;
import net.consensys.linea.zktracer.types.UnsignedByte;
import org.apache.tuweni.bytes.Bytes;
import org.hyperledger.besu.datatypes.Address;
import org.hyperledger.besu.evm.account.Account;
import org.hyperledger.besu.evm.frame.MessageFrame;
import org.hyperledger.besu.evm.internal.Words;

@Getter
public class OobChunk extends ModuleOperation {
  private BigInteger oobInst;

  private boolean isJump;
  private boolean isJumpi;
  private boolean isRdc;
  private boolean isCdl;
  private boolean isXCall;
  private boolean isCall;
  private boolean isCreate;
  private boolean isSstore;
  private boolean isDeployment;

  private boolean isEcRecover;
  private boolean isSha2;
  private boolean isRipemd;
  private boolean isIdentity;
  private boolean isEcadd;
  private boolean isEcmul;
  private boolean isEcpairing;
  private boolean isBlake2FCds;
  private boolean isBlake2FParams;
  private boolean isModexpCds;
  private boolean isModexpXbs;
  private boolean isModexpLead;
  private boolean prcModexpPricing;
  private boolean prcModexpExtract;

  private boolean isModexpBbs;
  private boolean isModexpEbs;
  private boolean isModexpMbs;

  private final boolean[] addFlag;
  private final boolean[] modFlag;
  private final boolean[] wcpFlag;

  private final UnsignedByte[] outgoingInst;

  private final BigInteger[] outgoingData1;
  private final BigInteger[] outgoingData2;
  private final BigInteger[] outgoingData3;
  private final BigInteger[] outgoingData4;

  private final BigInteger[] outgoingResLo;

  private OobParameters oobParameters;

  private BigInteger wghtSum;

  private BigInteger precompileCost;

  // Modules for lookups
  private final Add add;
  private final Mod mod;
  private final Wcp wcp;

  private final Hub hub;

  private int blake2FCallNumber;
  private int modexpCallNumber;

  public OobChunk(
      final MessageFrame frame,
      final Add add,
      final Mod mod,
      final Wcp wcp,
      final Hub hub,
      boolean isPrecompile,
      int blake2FCallNumber,
      int modexpCallNumber) {
    this.add = add;
    this.mod = mod;
    this.wcp = wcp;
    this.hub = hub;

    if (isPrecompile) {
      setPrecomileFlagsAndWghtSumAndIncomingInst(frame);
    } else {
      setOpCodeFlagsAndWghtSumAndIncomingInst(frame);
    }

    this.blake2FCallNumber = blake2FCallNumber;
    this.modexpCallNumber = modexpCallNumber;

    // Init arrays
    int nRows = nRows();
    addFlag = new boolean[nRows];
    modFlag = new boolean[nRows];
    wcpFlag = new boolean[nRows];

    outgoingInst = new UnsignedByte[nRows];
    outgoingData1 = new BigInteger[nRows];
    outgoingData2 = new BigInteger[nRows];
    outgoingData3 = new BigInteger[nRows];
    outgoingData4 = new BigInteger[nRows];
    outgoingResLo = new BigInteger[nRows];

    // TODO: ensure that the nonce update for CREATE is not already done
    populateColumns(frame);
  }

  private void setOpCodeFlagsAndWghtSumAndIncomingInst(MessageFrame frame) {
    OpCode opCode = OpCode.of(frame.getCurrentOperation().getOpcode());
    // In the case of CALLs and CREATEs this value will be replaced
    wghtSum = UnsignedByte.of(opCode.byteValue()).toBigInteger();

    switch (opCode) {
      case JUMP:
        isJump = true;
        break;
      case JUMPI:
        isJumpi = true;
        break;
      case RETURNDATACOPY:
        isRdc = true;
        break;
      case CALLDATALOAD:
        isCdl = true;
        break;
      case CALL, CALLCODE, DELEGATECALL, STATICCALL:
        if (opCode == OpCode.CALL
            && !hub.pch().exceptions().stackUnderflow()
            && hub.pch().exceptions().any()) {
          isXCall = true;
          wghtSum = BigInteger.valueOf(0xCC);
        } else {
          isCall = true;
          wghtSum = BigInteger.valueOf(0xCA);
        }
        break;
      case CREATE, CREATE2:
        isCreate = true;
        wghtSum = BigInteger.valueOf(0xCE);
        break;
      case SSTORE:
        isSstore = true;
        break;
      case RETURN:
        isDeployment = true;
        break;
      default:
        throw new IllegalArgumentException("OpCode not relevant for Oob");
    }
    oobInst = wghtSum;
  }

  private void setPrecomileFlagsAndWghtSumAndIncomingInst(MessageFrame frame) {
    Address target = Words.toAddress(frame.getStackItem(1));

    if (target.equals(Address.ECREC)) {
      isEcRecover = true;
      wghtSum = Bytes.fromHexString("FF01").toUnsignedBigInteger();
    } else if (target.equals(Address.SHA256)) {
      isSha2 = true;
      wghtSum = Bytes.fromHexString("FF02").toUnsignedBigInteger();
    } else if (target.equals(Address.RIPEMD160)) {
      isRipemd = true;
      wghtSum = Bytes.fromHexString("FF03").toUnsignedBigInteger();
    } else if (target.equals(Address.ID)) {
      isIdentity = true;
      wghtSum = Bytes.fromHexString("FF04").toUnsignedBigInteger();
    } else if (target.equals(Address.ALTBN128_ADD)) {
      isEcadd = true;
      wghtSum = Bytes.fromHexString("FF06").toUnsignedBigInteger();
    } else if (target.equals(Address.ALTBN128_MUL)) {
      isEcmul = true;
      wghtSum = Bytes.fromHexString("FF07").toUnsignedBigInteger();
    } else if (target.equals(Address.ALTBN128_PAIRING)) {
      isEcpairing = true;
      wghtSum = Bytes.fromHexString("FF08").toUnsignedBigInteger();
    } else if (target.equals(Address.BLAKE2B_F_COMPRESSION)) {
      if (blake2FCallNumber == 1) {
        isBlake2FCds = true;
        wghtSum = Bytes.fromHexString("FA09").toUnsignedBigInteger();
      } else if (blake2FCallNumber == 2) {
        isBlake2FParams = true;
        wghtSum = Bytes.fromHexString("FB09").toUnsignedBigInteger();
      }
    } else if (target.equals(Address.MODEXP)) {
      switch (modexpCallNumber) {
        case 1:
          isModexpCds = true;
          wghtSum = Bytes.fromHexString("FA05").toUnsignedBigInteger();
        case 2:
          isModexpXbs = true;
          isModexpBbs = true;
          wghtSum = Bytes.fromHexString("FB05").toUnsignedBigInteger();
        case 3:
          isModexpXbs = true;
          isModexpEbs = true;
          wghtSum = Bytes.fromHexString("FB05").toUnsignedBigInteger();
        case 4:
          isModexpXbs = true;
          isModexpMbs = true;
          wghtSum = Bytes.fromHexString("FB05").toUnsignedBigInteger();
        case 5:
          isModexpLead = true;
          wghtSum = Bytes.fromHexString("FC05").toUnsignedBigInteger();
        case 6:
          prcModexpPricing = true;
          wghtSum = Bytes.fromHexString("FD05").toUnsignedBigInteger();
        case 7:
          prcModexpExtract = true;
          wghtSum = Bytes.fromHexString("FE05").toUnsignedBigInteger();
      }
    } else {
      throw new IllegalArgumentException("Precompile not relevant for Oob");
    }
    oobInst = wghtSum;
  }

  public boolean isInst() {
    return isJump
        || isJumpi
        || isRdc
        || isCdl
        || isCall
        || isXCall
        || isCreate
        || isSstore
        || isDeployment;
  }

  public boolean isPrcCommon() {
    return isEcRecover || isSha2 || isRipemd || isIdentity || isEcadd || isEcmul || isEcpairing;
  }

  public boolean isPrcBlake() {
    return isBlake2FCds || isBlake2FParams;
  }

  public boolean isPrcModexp() {
    return isModexpCds || isModexpXbs || isModexpLead || prcModexpPricing || prcModexpExtract;
  }

  public boolean isPrc() {
    return isPrcCommon() || isPrcBlake() || isPrcModexp();
  }

  public int maxCt() {
    return CT_MAX_JUMP * booleanToInt(isJump)
        + CT_MAX_JUMPI * booleanToInt(isJumpi)
        + CT_MAX_RDC * booleanToInt(isRdc)
        + CT_MAX_CDL * booleanToInt(isCdl)
        + CT_MAX_XCALL * booleanToInt(isXCall)
        + CT_MAX_CALL * booleanToInt(isCall)
        + CT_MAX_CREATE * booleanToInt(isCreate)
        + CT_MAX_SSTORE * booleanToInt(isSstore)
        + CT_MAX_DEPLOYMENT * booleanToInt(isDeployment)
        + CT_MAX_ECRECOVER * booleanToInt(isEcRecover)
        + CT_MAX_SHA2 * booleanToInt(isSha2)
        + CT_MAX_RIPEMD * booleanToInt(isRipemd)
        + CT_MAX_IDENTITY * booleanToInt(isIdentity)
        + CT_MAX_ECADD * booleanToInt(isEcadd)
        + CT_MAX_ECMUL * booleanToInt(isEcmul)
        + CT_MAX_ECPAIRING * booleanToInt(isEcpairing)
        + CT_MAX_BLAKE2F_cds * booleanToInt(isBlake2FCds)
        + CT_MAX_BLAKE2F_params * booleanToInt(isBlake2FParams)
        + CT_MAX_MODEXP_cds * booleanToInt(isModexpCds)
        + CT_MAX_MODEXP_xbs * booleanToInt(isModexpXbs)
        + CT_MAX_MODEXP_lead * booleanToInt(isModexpLead)
        + CT_MAX_MODEXP_pricing * booleanToInt(prcModexpPricing)
        + CT_MAX_MODEXP_extract * booleanToInt(prcModexpExtract);
  }

  public int nRows() {
    return maxCt() + 1;
  }

  private void populateColumns(final MessageFrame frame) {
    OpCode opCode = OpCode.of(frame.getCurrentOperation().getOpcode());

    if (isInst()) {
      if (isJump) {
        JumpOobParameters jumpOobParameters =
            new JumpOobParameters(
                EWord.of(frame.getStackItem(0)), BigInteger.valueOf(frame.getCode().getSize()));
        oobParameters = jumpOobParameters;
        setJump(jumpOobParameters);
      } else if (isJumpi) {
        JumpiOobParameters jumpiOobParameters =
            new JumpiOobParameters(
                EWord.of(frame.getStackItem(0)),
                EWord.of(frame.getStackItem(1)),
                BigInteger.valueOf(frame.getCode().getSize()));
        oobParameters = jumpiOobParameters;
        setJumpi(jumpiOobParameters);
      } else if (isRdc) {
        RdcOobParameters rdcOobParameters =
            new RdcOobParameters(
                EWord.of(frame.getStackItem(1)),
                EWord.of(frame.getStackItem(2)),
                BigInteger.valueOf(frame.getReturnData().size()));
        oobParameters = rdcOobParameters;
        setRdc(rdcOobParameters);
      } else if (isCdl) {
        CdlOobParameters cdlOobParameters =
            new CdlOobParameters(
                EWord.of(frame.getStackItem(0)), BigInteger.valueOf(frame.getInputData().size()));
        oobParameters = cdlOobParameters;
        setCdl(cdlOobParameters);
      } else if (isXCall) {
        // CallOobParameters is used since this is a subcase of CALL
        CallOobParameters callOobParameters =
            new CallOobParameters(
                EWord.of(frame.getStackItem(2)),
                BigInteger.ZERO,
                !frame.getStackItem(2).isZero(),
                BigInteger.ZERO);
        oobParameters = callOobParameters;
        setXCall(callOobParameters);
      } else if (isCall) {
        Account callerAccount = frame.getWorldUpdater().get(frame.getRecipientAddress());
        // DELEGATECALL, STATICCALL cases
        EWord val = EWord.of(0);
        boolean nonZeroValue = false;
        // CALL, CALLCODE cases
        if (opCode == OpCode.CALL || opCode == OpCode.CALLCODE) {
          val = EWord.of(frame.getStackItem(2));
          nonZeroValue = !frame.getStackItem(2).isZero();
        }
        CallOobParameters callOobParameters =
            new CallOobParameters(
                val,
                callerAccount.getBalance().toUnsignedBigInteger(), // balance (caller address)
                nonZeroValue,
                BigInteger.valueOf(frame.getDepth()));
        oobParameters = callOobParameters;
        setCall(callOobParameters);
      } else if (isCreate) {
        Account creatorAccount = frame.getWorldUpdater().get(frame.getRecipientAddress());
        Address deploymentAddress = getDeploymentAddress(frame);
        Account deployedAccount = frame.getWorldUpdater().get(deploymentAddress);
        long nonce = 0;
        boolean hasCode = false;
        if (deployedAccount != null) {
          nonce = deployedAccount.getNonce();
          hasCode = deployedAccount.hasCode();
        }
        CreateOobParameters createOobParameters =
            new CreateOobParameters(
                EWord.of(frame.getStackItem(0)),
                creatorAccount.getBalance().toUnsignedBigInteger(), // balance (creator address)
                BigInteger.valueOf(nonce), // nonce (deployment address)
                hasCode, // has_code (deployment address)
                BigInteger.valueOf(frame.getDepth()));
        oobParameters = createOobParameters;
        setCreate(createOobParameters);
      } else if (isSstore) {
        SstoreOobParameters sstoreOobParameters =
            new SstoreOobParameters(BigInteger.valueOf(frame.getRemainingGas()));
        oobParameters = sstoreOobParameters;
        setSstore(sstoreOobParameters);
      } else if (isDeployment) {
        DeploymentOobParameters deploymentOobParameters =
            new DeploymentOobParameters(EWord.of(frame.getStackItem(0)));
        oobParameters = deploymentOobParameters;
        setDeployment(deploymentOobParameters);
      }
    } else if (isPrc()) {
      // DELEGATECALL, STATICCALL cases
      int argsOffset = 2;
      // this corresponds to argsSize on evm.codes
      int cdsIndex = 3;
      // this corresponds to retSize on evm.codes
      int returnAtCapacityIndex = 5;
      // value is not part of the arguments for DELEGATECALL and STATICCALL
      boolean transfersValue = false;
      // CALL, CALLCODE cases
      if (opCode == OpCode.CALL || opCode == OpCode.CALLCODE) {
        argsOffset = 3;
        cdsIndex = 4;
        returnAtCapacityIndex = 6;
        transfersValue = !frame.getStackItem(2).isZero();
      }

      BigInteger callGas =
          BigInteger.valueOf(
              ZkTracer.gasCalculator.gasAvailableForChildCall(
                  frame, Words.clampedToLong(frame.getStackItem(0)), transfersValue));

      BigInteger cds = EWord.of(frame.getStackItem(cdsIndex)).toUnsignedBigInteger();
      // Note that this check will disappear since it will be the MXP module taking care of it
      if (cds.compareTo(EWord.of(frame.getStackItem(cdsIndex)).loBigInt()) > 0) {
        throw new IllegalArgumentException("cds hi part is non-zero");
      }

      BigInteger returnAtCapacity =
          EWord.of(frame.getStackItem(returnAtCapacityIndex)).toUnsignedBigInteger();
      if (isPrcCommon()) {
        PrcCommonOobParameters prcCommonOobParameters =
            new PrcCommonOobParameters(callGas, cds, returnAtCapacity);
        oobParameters = prcCommonOobParameters;
        setPrc(prcCommonOobParameters);
        if (isEcRecover || isEcadd || isEcmul) {
          setPrcEcRecoverPrcEcaddPrcEcmul(prcCommonOobParameters);
        } else if (isSha2 || isRipemd || isIdentity) {
          setPrcSha2PrcRipemdPrcIdentity(prcCommonOobParameters);
        } else if (isEcpairing) {
          setEcpairing(prcCommonOobParameters);
        }
      } else if (isPrcModexp()) {
        Bytes unpaddedCallData = frame.shadowReadMemory(argsOffset, cds.longValue());
        // pad unpaddedCallData to 96
        Bytes paddedCallData =
            cds.intValue() < 96
                ? Bytes.concatenate(unpaddedCallData, Bytes.repeat((byte) 0, 96 - cds.intValue()))
                : unpaddedCallData;

        // cds and the data below can be int when compared (after size check)
        BigInteger bbs = paddedCallData.slice(0, 32).toUnsignedBigInteger();
        BigInteger ebs = paddedCallData.slice(32, 32).toUnsignedBigInteger();
        BigInteger mbs = paddedCallData.slice(64, 32).toUnsignedBigInteger();

        // Check if bbs, ebs and mbs are <= 512
        if (bbs.compareTo(BigInteger.valueOf(512)) > 0
            || ebs.compareTo(BigInteger.valueOf(512)) > 0
            || mbs.compareTo(BigInteger.valueOf(512)) > 0) {
          throw new IllegalArgumentException("byte sizes are too big");
        }

        // pad paddedCallData to 96 + bbs + ebs
        Bytes doublePaddedCallData =
            cds.intValue() < 96 + bbs.intValue() + ebs.intValue()
                ? Bytes.concatenate(
                    paddedCallData,
                    Bytes.repeat((byte) 0, 96 + bbs.intValue() + ebs.intValue() - cds.intValue()))
                : paddedCallData;

        BigInteger leadingBytesOfExponent =
            doublePaddedCallData
                .slice(96 + bbs.intValue(), min(ebs.intValue(), 32))
                .toUnsignedBigInteger();
        BigInteger exponentLog;
        if (ebs.intValue() <= 32 && leadingBytesOfExponent.signum() == 0) {
          exponentLog = BigInteger.ZERO;
        } else if (ebs.intValue() <= 32 && leadingBytesOfExponent.signum() != 0) {
          exponentLog = BigInteger.valueOf(log2(leadingBytesOfExponent, RoundingMode.FLOOR));
        } else if (ebs.intValue() > 32 && leadingBytesOfExponent.signum() != 0) {
          exponentLog =
              BigInteger.valueOf(8)
                  .multiply(ebs.subtract(BigInteger.valueOf(32)))
                  .add(BigInteger.valueOf(log2(leadingBytesOfExponent, RoundingMode.FLOOR)));
        } else {
          exponentLog = BigInteger.valueOf(8).multiply(ebs.subtract(BigInteger.valueOf(32)));
        }
        if (isModexpCds) {
          PrcModexpCdsParameters prcModexpCdsParameters = new PrcModexpCdsParameters(cds);
          oobParameters = prcModexpCdsParameters;
          setModexpCds(prcModexpCdsParameters);
        } else if (isModexpXbs) {
          PrcModexpXbsParameters prcModexpXbsParameters;
          if (isModexpBbs) {
            prcModexpXbsParameters =
                new PrcModexpXbsParameters(
                    EWord.of(bbs).hiBigInt(), EWord.of(bbs).loBigInt(), BigInteger.ZERO, false);
          } else if (isModexpEbs) {
            prcModexpXbsParameters =
                new PrcModexpXbsParameters(
                    EWord.of(ebs).hiBigInt(), EWord.of(ebs).loBigInt(), BigInteger.ZERO, false);
          } else {
            // isModexpMbs
            prcModexpXbsParameters =
                new PrcModexpXbsParameters(
                    EWord.of(mbs).hiBigInt(),
                    EWord.of(mbs).loBigInt(),
                    EWord.of(bbs).loBigInt(),
                    true);
          }
          oobParameters = prcModexpXbsParameters;
          setModexpXbs(prcModexpXbsParameters);
        } else if (isModexpLead) {

          PrcModexpLeadParameters prcModexpLeadParameters =
              new PrcModexpLeadParameters(bbs, cds, ebs);
          oobParameters = prcModexpLeadParameters;
          setModexpLead(prcModexpLeadParameters);
        } else if (prcModexpPricing) {
          int maxXbsYbs = 0; // TODO: get if from the hub
          PrcModexpPricingParameters prcModexpPricingParameters =
              new PrcModexpPricingParameters(callGas, returnAtCapacity, exponentLog, maxXbsYbs);
          oobParameters = prcModexpPricingParameters;
          setPrcModexpPricing(prcModexpPricingParameters);
        } else if (prcModexpExtract) {
          PrcModexpExtractParameters prcModexpExtractParameters =
              new PrcModexpExtractParameters(cds, bbs, ebs, mbs);
          oobParameters = prcModexpExtractParameters;
          setPrcModexpExtract(prcModexpExtractParameters);
        }
      } else if (isPrcBlake()) {
        if (isBlake2FCds) {
          PrcBlake2FCdsParameters prcBlake2FCdsParameters =
              new PrcBlake2FCdsParameters(cds, returnAtCapacity);
          oobParameters = prcBlake2FCdsParameters;
          setBlake2FCds(prcBlake2FCdsParameters);
        } else if (isBlake2FParams) {
          BigInteger blakeR =
              frame
                  .shadowReadMemory(argsOffset, cds.longValue())
                  .slice(0, 4)
                  .toUnsignedBigInteger();

          BigInteger blakeF =
              BigInteger.valueOf(
                  toUnsignedInt(frame.shadowReadMemory(argsOffset, cds.longValue()).get(212)));

          PrcBlake2FParamsParameters prcBlake2FParamsParameters =
              new PrcBlake2FParamsParameters(callGas, blakeR, blakeF);
          oobParameters = prcBlake2FParamsParameters;
          setBlake2FParams(prcBlake2FParamsParameters);
        }
      } else {
        throw new RuntimeException("no opcode or precompile flag was set to true");
      }
    }
  }

  // Constraint systems for populating lookups
  private void callToADD(
      int k, BigInteger arg1Hi, BigInteger arg1Lo, BigInteger arg2Hi, BigInteger arg2Lo) {
    EWord arg1 = EWord.of(arg1Hi, arg1Lo);
    EWord arg2 = EWord.of(arg2Hi, arg2Lo);
    addFlag[k] = true;
    modFlag[k] = false;
    wcpFlag[k] = false;
    outgoingInst[k] = UnsignedByte.of(OpCode.ADD.byteValue());
    outgoingData1[k] = arg1Hi;
    outgoingData2[k] = arg1Lo;
    outgoingData3[k] = arg2Hi;
    outgoingData4[k] = arg2Lo;
    outgoingResLo[k] =
        BigInteger.ZERO; // This value is never used and BigInteger.ZERO is a dummy one

    // lookup
    add.callADD(arg1, arg2);
  }

  private void callToDIV(
      int k, BigInteger arg1Hi, BigInteger arg1Lo, BigInteger arg2Hi, BigInteger arg2Lo) {
    EWord arg1 = EWord.of(arg1Hi, arg1Lo);
    EWord arg2 = EWord.of(arg2Hi, arg2Lo);
    addFlag[k] = false;
    modFlag[k] = true;
    wcpFlag[k] = false;
    outgoingInst[k] = UnsignedByte.of(OpCode.DIV.byteValue());
    outgoingData1[k] = arg1Hi;
    outgoingData2[k] = arg1Lo;
    outgoingData3[k] = arg2Hi;
    outgoingData4[k] = arg2Lo;
    outgoingResLo[k] = arg1.toUnsignedBigInteger().divide(arg2.toUnsignedBigInteger());

    // lookup
    mod.callDIV(arg1, arg2);
  }

  private void callToMOD(
      int k, BigInteger arg1Hi, BigInteger arg1Lo, BigInteger arg2Hi, BigInteger arg2Lo) {
    EWord arg1 = EWord.of(arg1Hi, arg1Lo);
    EWord arg2 = EWord.of(arg2Hi, arg2Lo);
    addFlag[k] = false;
    modFlag[k] = true;
    wcpFlag[k] = false;
    outgoingInst[k] = UnsignedByte.of(OpCode.MOD.byteValue());
    outgoingData1[k] = arg1Hi;
    outgoingData2[k] = arg1Lo;
    outgoingData3[k] = arg2Hi;
    outgoingData4[k] = arg2Lo;
    outgoingResLo[k] = arg1.toUnsignedBigInteger().mod(arg2.toUnsignedBigInteger());

    // lookup
    mod.callMOD(arg1, arg2);
  }

  private void callToLT(
      int k, BigInteger arg1Hi, BigInteger arg1Lo, BigInteger arg2Hi, BigInteger arg2Lo) {
    EWord arg1 = EWord.of(arg1Hi, arg1Lo);
    EWord arg2 = EWord.of(arg2Hi, arg2Lo);
    addFlag[k] = false;
    modFlag[k] = false;
    wcpFlag[k] = true;
    outgoingInst[k] = UnsignedByte.of(OpCode.LT.byteValue());
    outgoingData1[k] = arg1Hi;
    outgoingData2[k] = arg1Lo;
    outgoingData3[k] = arg2Hi;
    outgoingData4[k] = arg2Lo;
    outgoingResLo[k] = booleanToBigInteger(arg1.lessThan(arg2));

    // lookup
    wcp.callLT(arg1, arg2);
  }

  private void callToGT(
      int k, BigInteger arg1Hi, BigInteger arg1Lo, BigInteger arg2Hi, BigInteger arg2Lo) {
    EWord arg1 = EWord.of(arg1Hi, arg1Lo);
    EWord arg2 = EWord.of(arg2Hi, arg2Lo);
    addFlag[k] = false;
    modFlag[k] = false;
    wcpFlag[k] = true;
    outgoingInst[k] = UnsignedByte.of(OpCode.GT.byteValue());
    outgoingData1[k] = arg1Hi;
    outgoingData2[k] = arg1Lo;
    outgoingData3[k] = arg2Hi;
    outgoingData4[k] = arg2Lo;
    outgoingResLo[k] = booleanToBigInteger(arg1.greaterThan(arg2));

    // lookup
    wcp.callGT(arg1, arg2);
  }

  private void callToISZERO(int k, BigInteger arg1Hi, BigInteger arg1Lo) {
    EWord arg1 = EWord.of(arg1Hi, arg1Lo);
    addFlag[k] = false;
    modFlag[k] = false;
    wcpFlag[k] = true;
    outgoingInst[k] = UnsignedByte.of(OpCode.ISZERO.byteValue());
    outgoingData1[k] = arg1Hi;
    outgoingData2[k] = arg1Lo;
    outgoingData3[k] = BigInteger.ZERO;
    outgoingData4[k] = BigInteger.ZERO;
    outgoingResLo[k] = booleanToBigInteger(arg1.isZero());

    // lookup
    wcp.callISZERO(arg1);
  }

  private void callToEQ(
      int k, BigInteger arg1Hi, BigInteger arg1Lo, BigInteger arg2Hi, BigInteger arg2Lo) {
    EWord arg1 = EWord.of(arg1Hi, arg1Lo);
    EWord arg2 = EWord.of(arg2Hi, arg2Lo);
    addFlag[k] = false;
    modFlag[k] = false;
    wcpFlag[k] = true;
    outgoingInst[k] = UnsignedByte.of(OpCode.EQ.byteValue());
    outgoingData1[k] = arg1Hi;
    outgoingData2[k] = arg1Lo;
    outgoingData3[k] = arg2Hi;
    outgoingData4[k] = arg2Lo;
    outgoingResLo[k] = booleanToBigInteger(arg1.equals(arg2));

    // lookup
    wcp.callEQ(arg1, arg2);
  }

  private void noCall(int k) {
    addFlag[k] = false;
    modFlag[k] = false;
    wcpFlag[k] = false;
    outgoingInst[k] = UnsignedByte.of(0);
    outgoingData1[k] = BigInteger.ZERO;
    outgoingData2[k] = BigInteger.ZERO;
    outgoingData3[k] = BigInteger.ZERO;
    outgoingData4[k] = BigInteger.ZERO;
    outgoingResLo[k] = BigInteger.ZERO;
  }

  // Methods to populate columns
  private void setJump(JumpOobParameters jumpOobParameters) {
    // row i
    callToLT(
        0,
        jumpOobParameters.pcNewHi(),
        jumpOobParameters.pcNewLo(),
        BigInteger.ZERO,
        jumpOobParameters.codesize());
    boolean invalidPcNew = !bigIntegerToBoolean(outgoingResLo[0]);
  }

  private void setJumpi(JumpiOobParameters jumpiOobParameters) {
    // row i
    callToLT(
        0,
        jumpiOobParameters.pcNewHi(),
        jumpiOobParameters.pcNewLo(),
        BigInteger.ZERO,
        jumpiOobParameters.codesize());
    boolean invalidPcNew = !bigIntegerToBoolean(outgoingResLo[0]);

    // row i + 1
    callToISZERO(1, jumpiOobParameters.jumpConditionHi(), jumpiOobParameters.jumpConditionLo());
    boolean attemptJump = !bigIntegerToBoolean(outgoingResLo[1]);
  }

  private void setRdc(RdcOobParameters rdcOobParameters) {
    // row i
    callToISZERO(0, rdcOobParameters.offsetHi(), rdcOobParameters.sizeHi());
    boolean rdcRoob = !bigIntegerToBoolean(outgoingResLo[0]);

    // row i + 1
    if (!rdcRoob) {
      callToADD(
          1,
          BigInteger.ZERO,
          rdcOobParameters.offsetLo(),
          BigInteger.ZERO,
          rdcOobParameters.sizeLo());
    } else {
      noCall(1);
    }
    BigInteger sum =
        addFlag[1] ? rdcOobParameters.offsetLo().add(rdcOobParameters.sizeLo()) : BigInteger.ZERO;

    // row i + 2
    if (!rdcRoob) {
      callToGT(
          2,
          EWord.of(sum).hiBigInt(),
          EWord.of(sum).loBigInt(),
          BigInteger.ZERO,
          rdcOobParameters.rds());
    } else {
      noCall(2);
    }
    boolean rdcSoob = bigIntegerToBoolean(outgoingResLo[2]);
  }

  private void setCdl(CdlOobParameters cdlOobParameters) {
    // row i
    callToLT(
        0,
        cdlOobParameters.offsetHi(),
        cdlOobParameters.offsetLo(),
        BigInteger.ZERO,
        cdlOobParameters.cds());
    boolean touchesRam = bigIntegerToBoolean(outgoingResLo[0]);
  }

  private void setXCall(CallOobParameters callOobParameters) {
    // row i
    callToISZERO(0, callOobParameters.valHi(), callOobParameters.valLo());
  }

  private void setCall(CallOobParameters callOobParameters) {
    // row i
    callToLT(
        0,
        BigInteger.ZERO,
        callOobParameters.bal(),
        callOobParameters.valHi(),
        callOobParameters.valLo());
    boolean insufficientBalanceAbort = bigIntegerToBoolean(outgoingResLo[0]);

    // row i + 1
    callToLT(
        1, BigInteger.ZERO, callOobParameters.csd(), BigInteger.ZERO, BigInteger.valueOf(1024));
    boolean callStackDepthAbort = !bigIntegerToBoolean(outgoingResLo[1]);

    // row i + 2
    callToISZERO(2, callOobParameters.valHi(), callOobParameters.valLo());
  }

  private void setCreate(CreateOobParameters createOobParameters) {
    // row i
    callToLT(
        0,
        BigInteger.ZERO,
        createOobParameters.bal(),
        createOobParameters.valHi(),
        createOobParameters.valLo());
    boolean insufficientBalanceAbort = bigIntegerToBoolean(outgoingResLo[0]);

    // row i + 1
    callToLT(
        1, BigInteger.ZERO, createOobParameters.csd(), BigInteger.ZERO, BigInteger.valueOf(1024));
    boolean callStackDepthAbort = !bigIntegerToBoolean(outgoingResLo[1]);

    // row i + 2
    callToISZERO(2, BigInteger.ZERO, createOobParameters.nonce());
    boolean nonZeroNonce = !bigIntegerToBoolean(outgoingResLo[2]);
  }

  private void setSstore(SstoreOobParameters sstoreOobParameters) {
    // row i
    callToLT(
        0,
        BigInteger.ZERO,
        BigInteger.valueOf(G_CALLSTIPEND),
        BigInteger.ZERO,
        sstoreOobParameters.gas());
    boolean sufficientGas = bigIntegerToBoolean(outgoingResLo[0]);
  }

  private void setDeployment(DeploymentOobParameters deploymentOobParameters) {
    // row i
    callToLT(
        0,
        BigInteger.ZERO,
        BigInteger.valueOf(24576),
        deploymentOobParameters.sizeHi(),
        deploymentOobParameters.sizeLo());
    boolean exceedsMaxCodeSize = bigIntegerToBoolean(outgoingResLo[0]);
  }

  private void setPrc(PrcCommonOobParameters prcOobParameters) {
    // row i
    callToISZERO(0, BigInteger.ZERO, prcOobParameters.getCds());
    boolean cdsIsZero = bigIntegerToBoolean(outgoingResLo[0]);

    // row i + 1
    callToISZERO(1, BigInteger.ZERO, prcOobParameters.getReturnAtCapacity());
    boolean returnAtCapacityIsZero = bigIntegerToBoolean(outgoingResLo[1]);

    // Set cdsIsZero
    prcOobParameters.setCdsIsZero(cdsIsZero);

    // Set returnAtCapacityIsZero
    prcOobParameters.setReturnAtCapacityNonZero(!returnAtCapacityIsZero);
  }

  private void setPrcEcRecoverPrcEcaddPrcEcmul(PrcCommonOobParameters prcCommonOobParameters) {
    precompileCost =
        BigInteger.valueOf(
            3000 * booleanToInt(isEcRecover)
                + 150 * booleanToInt(isEcadd)
                + 6000 * booleanToInt(isEcmul));

    // row i + 2
    callToLT(
        2, BigInteger.ZERO, prcCommonOobParameters.getCallGas(), BigInteger.ZERO, precompileCost);
    boolean insufficientGas = bigIntegerToBoolean(outgoingResLo[2]);

    // Set hub success
    boolean hubSuccess = !insufficientGas;
    prcCommonOobParameters.setSuccess(hubSuccess);

    // Set remaining gas
    BigInteger returnGas =
        hubSuccess ? prcCommonOobParameters.getCallGas().subtract(precompileCost) : BigInteger.ZERO;
    prcCommonOobParameters.setReturnGas(returnGas);
  }

  private void setPrcSha2PrcRipemdPrcIdentity(PrcCommonOobParameters prcCommonOobParameters) {
    // row i + 2
    callToDIV(
        2,
        BigInteger.ZERO,
        prcCommonOobParameters.getCds().add(BigInteger.valueOf(31)),
        BigInteger.ZERO,
        BigInteger.valueOf(32));
    BigInteger ceil = outgoingResLo[2];

    precompileCost =
        (BigInteger.valueOf(5).add(ceil))
            .multiply(
                BigInteger.valueOf(
                    12 * booleanToInt(isSha2)
                        + 120 * booleanToInt(isRipemd)
                        + 3 * booleanToInt(isIdentity)));

    // row i + 3
    callToLT(
        3, BigInteger.ZERO, prcCommonOobParameters.getCallGas(), BigInteger.ZERO, precompileCost);
    boolean insufficientGas = bigIntegerToBoolean(outgoingResLo[3]);

    // Set hub success
    boolean hubSuccess = !insufficientGas;
    prcCommonOobParameters.setSuccess(hubSuccess);

    // Set remaining gas
    BigInteger returnGas =
        hubSuccess ? prcCommonOobParameters.getCallGas().subtract(precompileCost) : BigInteger.ZERO;
    prcCommonOobParameters.setReturnGas(returnGas);
  }

  private void setEcpairing(PrcCommonOobParameters prcCommonOobParameters) {
    // row i + 2
    callToMOD(
        2,
        BigInteger.ZERO,
        prcCommonOobParameters.getCds(),
        BigInteger.ZERO,
        BigInteger.valueOf(192));
    BigInteger remainder = outgoingResLo[2];

    // row i + 3
    callToISZERO(3, BigInteger.ZERO, remainder);
    boolean isMultipleOf192 = outgoingResLo[3].equals(BigInteger.ONE);

    precompileCost = BigInteger.ZERO;
    if (isMultipleOf192) {
      precompileCost =
          BigInteger.valueOf(45000)
              .add(
                  BigInteger.valueOf(34000)
                      .multiply(prcCommonOobParameters.getCds().divide(BigInteger.valueOf(192))));
    }

    // row i + 4
    if (isMultipleOf192) {
      callToLT(
          4, BigInteger.ZERO, prcCommonOobParameters.getCallGas(), BigInteger.ZERO, precompileCost);
    } else {
      noCall(4);
    }
    boolean insufficientGas = bigIntegerToBoolean(outgoingResLo[4]);

    // Set hub success
    boolean hubSuccess = isMultipleOf192 && !insufficientGas;
    prcCommonOobParameters.setSuccess(hubSuccess);

    // Set remaining gas
    BigInteger returnGas =
        hubSuccess ? prcCommonOobParameters.getCallGas().subtract(precompileCost) : BigInteger.ZERO;
    prcCommonOobParameters.setReturnGas(returnGas);
  }

  private void setModexpCds(PrcModexpCdsParameters prcModexpCdsParameters) {
    // row i
    callToLT(0, BigInteger.ZERO, prcModexpCdsParameters.getCds(), BigInteger.ZERO, BigInteger.ZERO);
    boolean extractBbs = bigIntegerToBoolean(outgoingResLo[0]);

    // row i + 1
    callToLT(
        1,
        BigInteger.ZERO,
        prcModexpCdsParameters.getCds(),
        BigInteger.ZERO,
        BigInteger.valueOf(32));
    boolean extractEbs = bigIntegerToBoolean(outgoingResLo[1]);

    // row i + 2
    callToLT(
        2,
        BigInteger.ZERO,
        prcModexpCdsParameters.getCds(),
        BigInteger.ZERO,
        BigInteger.valueOf(64));
    boolean extractMbs = bigIntegerToBoolean(outgoingResLo[2]);

    // Set extract bbs
    prcModexpCdsParameters.setExtractBbs(extractBbs);

    // Set extract ebs
    prcModexpCdsParameters.setExtractEbs(extractEbs);

    // Set extract mbs
    prcModexpCdsParameters.setExtractMbs(extractMbs);
  }

  private void setModexpXbs(PrcModexpXbsParameters prcModexpXbsParameters) {
    // row i
    callToLT(
        0,
        prcModexpXbsParameters.getXbsHi(),
        prcModexpXbsParameters.getXbsLo(),
        BigInteger.ZERO,
        BigInteger.valueOf(513));
    boolean compTo512 = bigIntegerToBoolean(outgoingResLo[0]);

    // row i + 1
    callToLT(
        1,
        BigInteger.ZERO,
        prcModexpXbsParameters.getXbsLo(),
        BigInteger.ZERO,
        prcModexpXbsParameters.getYbsLo());
    boolean comp = bigIntegerToBoolean(outgoingResLo[1]);

    // row i + 2
    callToISZERO(2, BigInteger.ZERO, prcModexpXbsParameters.getXbsLo());

    // Set MaxXbsYbs and xbsNonZero
    if (!prcModexpXbsParameters.isComputeMax()) {
      prcModexpXbsParameters.setMaxXbsYbs(BigInteger.ZERO);
      prcModexpXbsParameters.setXbsNonZero(false);
    } else {
      prcModexpXbsParameters.setMaxXbsYbs(
          comp ? prcModexpXbsParameters.getYbsLo() : prcModexpXbsParameters.getXbsLo());
      prcModexpXbsParameters.setXbsNonZero(!bigIntegerToBoolean(outgoingResLo[2]));
    }
  }

  private void setModexpLead(PrcModexpLeadParameters prcModexpLeadParameters) {
    // row i
    callToISZERO(0, BigInteger.ZERO, prcModexpLeadParameters.getEbs());
    boolean ebsIsZero = bigIntegerToBoolean(outgoingResLo[0]);

    // row i + 1
    callToLT(
        1,
        BigInteger.ZERO,
        prcModexpLeadParameters.getEbs(),
        BigInteger.ZERO,
        BigInteger.valueOf(32));
    boolean ebsLessThan32 = bigIntegerToBoolean(outgoingResLo[1]);

    // row i + 2
    callToLT(
        2,
        BigInteger.ZERO,
        BigInteger.valueOf(96).add(prcModexpLeadParameters.getBbs()),
        BigInteger.ZERO,
        prcModexpLeadParameters.getCds());
    boolean callDataContainsExponentBytes = bigIntegerToBoolean(outgoingResLo[2]);

    // row i + 3
    if (callDataContainsExponentBytes) {
      callToLT(
          3,
          BigInteger.ZERO,
          prcModexpLeadParameters
              .getCds()
              .subtract(BigInteger.valueOf(96).add(prcModexpLeadParameters.getBbs())),
          BigInteger.ZERO,
          BigInteger.valueOf(32));
    } else {
      noCall(3);
    }
    boolean comp = bigIntegerToBoolean(outgoingResLo[3]); // TODO: double check usage

    // Set loadLead
    boolean loadLead = callDataContainsExponentBytes && !ebsIsZero;
    prcModexpLeadParameters.setLoadLead(loadLead);

    // Set cdsCutoff
    if (!callDataContainsExponentBytes) {
      prcModexpLeadParameters.setCdsCutoff(0);
    } else {
      prcModexpLeadParameters.setCdsCutoff(
          comp
              ? (prcModexpLeadParameters
                  .getCds()
                  .subtract(BigInteger.valueOf(96).add(prcModexpLeadParameters.getBbs()))
                  .intValue())
              : 32);
    }
    // Set ebsCutoff
    prcModexpLeadParameters.setEbsCutoff(
        ebsLessThan32 ? prcModexpLeadParameters.getEbs().intValue() : 0);

    // Set subEbs32
    prcModexpLeadParameters.setSubEbs32(
        ebsLessThan32 ? 0 : prcModexpLeadParameters.getEbs().intValue() - 32);
  }

  private void setPrcModexpPricing(PrcModexpPricingParameters prcModexpPricingParameters) {
    // row i
    callToISZERO(0, BigInteger.ZERO, prcModexpPricingParameters.getReturnAtCapacity());
    boolean returnAtCapacityIsZero = bigIntegerToBoolean(outgoingResLo[0]);

    // row i + 1
    callToISZERO(1, BigInteger.ZERO, prcModexpPricingParameters.getExponentLog());
    boolean exponentLogIsZero = bigIntegerToBoolean(outgoingResLo[1]);

    // row i + 2
    callToDIV(
        2,
        BigInteger.ZERO,
        BigInteger.valueOf(
            prcModexpPricingParameters.getMaxMbsBbs() * prcModexpPricingParameters.getMaxMbsBbs()
                + 7),
        BigInteger.ZERO,
        BigInteger.valueOf(8));
    BigInteger fOfMax = outgoingResLo[2];

    // row i + 3
    BigInteger bigNumerator;
    if (!exponentLogIsZero) {
      bigNumerator = fOfMax.multiply(prcModexpPricingParameters.getExponentLog());
    } else {
      bigNumerator = fOfMax;
    }
    callToDIV(3, BigInteger.ZERO, bigNumerator, BigInteger.ZERO, BigInteger.valueOf(G_QUADDIVISOR));
    BigInteger bigQuotient = outgoingResLo[3];

    // row i + 4
    callToLT(4, BigInteger.ZERO, bigQuotient, BigInteger.ZERO, BigInteger.valueOf(200));
    boolean bigQuotientLT200 = bigIntegerToBoolean(outgoingResLo[4]);

    // row i + 5
    precompileCost = bigQuotientLT200 ? BigInteger.valueOf(200) : bigQuotient;

    callToLT(
        5,
        BigInteger.ZERO,
        prcModexpPricingParameters.getCallGas(),
        BigInteger.ZERO,
        precompileCost);

    // Set ram success
    boolean ramSuccess = !bigIntegerToBoolean(outgoingResLo[5]);
    prcModexpPricingParameters.setSuccess(ramSuccess);

    // Set remaining gas
    BigInteger returnGas =
        ramSuccess
            ? prcModexpPricingParameters.getCallGas().subtract(precompileCost)
            : BigInteger.ZERO;
    prcModexpPricingParameters.setReturnGas(returnGas);

    // Set returnAtCapacityIsZero
    prcModexpPricingParameters.setReturnAtCapacityNonZero(!returnAtCapacityIsZero);
  }

  private void setPrcModexpExtract(PrcModexpExtractParameters prcModexpExtractParameters) {
    // row i
    callToISZERO(0, BigInteger.ZERO, prcModexpExtractParameters.getBbs());
    boolean bbsIsZero = bigIntegerToBoolean(outgoingResLo[0]);

    // row i + 1
    callToISZERO(1, BigInteger.ZERO, prcModexpExtractParameters.getEbs());
    boolean ebsIsZero = bigIntegerToBoolean(outgoingResLo[1]);

    // row i + 2
    callToISZERO(2, BigInteger.ZERO, prcModexpExtractParameters.getMbs());
    boolean mbsIsZero = bigIntegerToBoolean(outgoingResLo[2]);

    // row i + 3
    callToLT(
        3,
        BigInteger.ZERO,
        BigInteger.valueOf(96)
            .add(prcModexpExtractParameters.getBbs().add(prcModexpExtractParameters.getEbs())),
        BigInteger.ZERO,
        prcModexpExtractParameters.getCds());
    boolean callDataExtendsBeyondExponent = bigIntegerToBoolean(outgoingResLo[3]);

    // Set extractModulus
    boolean extractModulus = callDataExtendsBeyondExponent && !mbsIsZero;
    prcModexpExtractParameters.setExtractModulus(extractModulus);

    // Set extractBase
    boolean extractBase = extractModulus && !bbsIsZero;
    prcModexpExtractParameters.setExtractBase(extractBase);

    // Set extractExponent
    boolean extractExponent = extractModulus && !ebsIsZero;
    prcModexpExtractParameters.setExtractExponent(extractExponent);
  }

  private void setBlake2FCds(PrcBlake2FCdsParameters prcBlake2FCdsParameters) {
    // row i
    callToEQ(
        0,
        BigInteger.ZERO,
        prcBlake2FCdsParameters.getCds(),
        BigInteger.ZERO,
        BigInteger.valueOf(213));
    boolean validCds = bigIntegerToBoolean(outgoingResLo[0]);

    // row i
    callToISZERO(1, BigInteger.ZERO, prcBlake2FCdsParameters.getReturnAtCapacity());
    boolean returnAtCapacityIsZero = bigIntegerToBoolean(outgoingResLo[1]);

    // Set hub success
    prcBlake2FCdsParameters.setSuccess(validCds);

    // Set returnAtCapacityIsZero
    prcBlake2FCdsParameters.setReturnAtCapacityNonZero(!returnAtCapacityIsZero);
  }

  private void setBlake2FParams(PrcBlake2FParamsParameters prcBlake2FParamsParameters) {
    // row i
    callToLT(
        0,
        BigInteger.ZERO,
        prcBlake2FParamsParameters.getCallGas(),
        BigInteger.ZERO,
        prcBlake2FParamsParameters.getBlakeR());
    boolean sufficientGas = !bigIntegerToBoolean(outgoingResLo[0]); // = ramSuccess

    // row i + 1
    callToEQ(
        1,
        BigInteger.ZERO,
        prcBlake2FParamsParameters.getBlakeF(),
        BigInteger.ZERO,
        prcBlake2FParamsParameters.getBlakeF().multiply(prcBlake2FParamsParameters.getBlakeF()));
    boolean fIsABit = bigIntegerToBoolean(outgoingResLo[1]);

    // Set ramSuccess
    boolean ramSuccess = sufficientGas && fIsABit;
    prcBlake2FParamsParameters.setSuccess(ramSuccess);

    // Set returnGas
    BigInteger returnGas =
        ramSuccess
            ? (prcBlake2FParamsParameters
                .getCallGas()
                .subtract(prcBlake2FParamsParameters.getBlakeR()))
            : BigInteger.ZERO;
    prcBlake2FParamsParameters.setReturnGas(returnGas);
  }

  @Override
  protected int computeLineCount() {
    return this.nRows();
  }
}
