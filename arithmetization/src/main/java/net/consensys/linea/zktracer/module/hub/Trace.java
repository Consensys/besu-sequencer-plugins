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

package net.consensys.linea.zktracer.module.hub;

import java.nio.MappedByteBuffer;
import java.util.BitSet;
import java.util.List;

import net.consensys.linea.zktracer.ColumnHeader;
import org.apache.tuweni.bytes.Bytes;

/**
 * WARNING: This code is generated automatically.
 *
 * <p>Any modifications to this code may be overwritten and could lead to unexpected behavior.
 * Please DO NOT ATTEMPT TO MODIFY this code directly.
 */
public class Trace {
  public static final long PHASE_BLAKE_DATA = 0x622be6d4b1572927L;
  public static final long PHASE_BLAKE_PARAMETERS = 0x2e80fde96b141758L;
  public static final long PHASE_BLAKE_RESULT = 0x160014673f271430L;
  public static final long PHASE_ECADD_DATA = 0x6c91f926ba9d5411L;
  public static final long PHASE_ECADD_RESULT = 0x68f448e345258b49L;
  public static final long PHASE_ECMUL_DATA = 0x5085e9b2080beb8aL;
  public static final long PHASE_ECMUL_RESULT = 0x744473be8f6b243bL;
  public static final long PHASE_ECRECOVER_DATA = 0x5cca334705d87f45L;
  public static final long PHASE_ECRECOVER_RESULT = 0x11f815bf19ad632dL;
  public static final long PHASE_MODEXP_BASE = 0x45e8c5b591b510bfL;
  public static final long PHASE_MODEXP_EXPONENT = 0x138bcdb54832cea6L;
  public static final long PHASE_MODEXP_MODULUS = 0x223a6d8012de8c97L;
  public static final long PHASE_MODEXP_RESULT = 0x6208e4802a925144L;
  public static final long PHASE_PAIRING_DATA = 0x4c64af76266164e5L;
  public static final long PHASE_PAIRING_RESULT = 0xff4e03954b8449bL;
  public static final long PHASE_RIPEMD_160_DATA = 0x853e4fa950b7671L;
  public static final long PHASE_RIPEMD_160_RESULT = 0x372bdf04e6b5c9c5L;
  public static final long PHASE_SHA2_256_DATA = 0x22ba2e4070d18a69L;
  public static final long PHASE_SHA2_256_RESULT = 0x15115bb4671a9706L;
  public static final int PHASE_TRANSACTION_CALL_DATA = 0x9;

  private final BitSet filled = new BitSet();
  private int currentLine = 0;

  private final MappedByteBuffer absoluteTransactionNumber;
  private final MappedByteBuffer
      addressHiXorAccountAddressHiXorCcrsStampXorAlphaXorAddressHiXorBasefee;
  private final MappedByteBuffer
      addressLoXorAccountAddressLoXorExpData1XorDeltaXorAddressLoXorBatchNum;
  private final MappedByteBuffer
      balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi;
  private final MappedByteBuffer
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize;
  private final MappedByteBuffer batchNumber;
  private final MappedByteBuffer callerContextNumber;
  private final MappedByteBuffer codeAddressHi;
  private final MappedByteBuffer codeAddressLo;
  private final MappedByteBuffer codeDeploymentNumber;
  private final MappedByteBuffer codeDeploymentStatus;
  private final MappedByteBuffer codeFragmentIndex;
  private final MappedByteBuffer
      codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo;
  private final MappedByteBuffer
      codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo;
  private final MappedByteBuffer
      codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi;
  private final MappedByteBuffer
      codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice;
  private final MappedByteBuffer
      codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit;
  private final MappedByteBuffer
      codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas;
  private final MappedByteBuffer
      codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance;
  private final MappedByteBuffer contextGetsReverted;
  private final MappedByteBuffer contextMayChange;
  private final MappedByteBuffer contextNumber;
  private final MappedByteBuffer contextNumberNew;
  private final MappedByteBuffer contextRevertStamp;
  private final MappedByteBuffer contextSelfRevertsFlag;
  private final MappedByteBuffer contextWillRevertFlag;
  private final MappedByteBuffer counterNsr;
  private final MappedByteBuffer counterTli;
  private final MappedByteBuffer createFailureConditionWillRevertXorHashInfoFlag;
  private final MappedByteBuffer createFailureConditionWontRevertXorIcpx;
  private final MappedByteBuffer createNonemptyInitCodeFailureWillRevertXorInvalidFlag;
  private final MappedByteBuffer createNonemptyInitCodeFailureWontRevertXorJumpx;
  private final MappedByteBuffer
      createNonemptyInitCodeSuccessWillRevertXorJumpDestinationVettingRequired;
  private final MappedByteBuffer createNonemptyInitCodeSuccessWontRevertXorJumpFlag;
  private final MappedByteBuffer
      deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas;
  private final MappedByteBuffer
      deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce;
  private final MappedByteBuffer
      deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize;
  private final MappedByteBuffer
      deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment;
  private final MappedByteBuffer
      deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2;
  private final MappedByteBuffer
      deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization;
  private final MappedByteBuffer domStamp;
  private final MappedByteBuffer exceptionAhoy;
  private final MappedByteBuffer
      existsNewXorMxpDeploysXorCallPrcFailureXorCallFlagXorValNextIsOrigXorStatusCode;
  private final MappedByteBuffer
      existsXorMmuSuccessBitXorCallExceptionXorBtcFlagXorValNextIsCurrXorRequiresEvmExecution;
  private final MappedByteBuffer expInstXorPrcCalleeGas;
  private final MappedByteBuffer gasActual;
  private final MappedByteBuffer gasCost;
  private final MappedByteBuffer gasExpected;
  private final MappedByteBuffer gasNext;
  private final MappedByteBuffer
      hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWontRevertXorCopyFlagXorValOrigIsZero;
  private final MappedByteBuffer
      hasCodeXorMxpFlagXorCallPrcSuccessCallerWillRevertXorConFlagXorValNextIsZero;
  private final MappedByteBuffer hashInfoStamp;
  private final MappedByteBuffer hubStamp;
  private final MappedByteBuffer hubStampTransactionEnd;
  private final MappedByteBuffer
      isPrecompileXorOobFlagXorCallSmcFailureCallerWillRevertXorCreateFlagXorWarm;
  private final MappedByteBuffer logInfoStamp;
  private final MappedByteBuffer
      markedForSelfdestructNewXorStpFlagXorCallSmcSuccessCallerWillRevertXorDecFlag2;
  private final MappedByteBuffer
      markedForSelfdestructXorStpExistsXorCallSmcFailureCallerWontRevertXorDecFlag1XorWarmNew;
  private final MappedByteBuffer mmuAuxIdXorPrcCallerGas;
  private final MappedByteBuffer mmuExoSumXorPrcCdo;
  private final MappedByteBuffer mmuInstXorPrcCds;
  private final MappedByteBuffer mmuPhaseXorPrcRac;
  private final MappedByteBuffer mmuRefOffsetXorPrcRao;
  private final MappedByteBuffer mmuRefSizeXorPrcReturnGas;
  private final MappedByteBuffer mmuSize;
  private final MappedByteBuffer mmuSrcId;
  private final MappedByteBuffer mmuStamp;
  private final MappedByteBuffer mmuTgtId;
  private final MappedByteBuffer modexpXorOogx;
  private final MappedByteBuffer mxpStamp;
  private final MappedByteBuffer
      nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity;
  private final MappedByteBuffer nonceXorCallValueXorMxpSize2HiXorStackItemStamp1XorRefundAmount;
  private final MappedByteBuffer numberOfNonStackRows;
  private final MappedByteBuffer oobData2XorStackItemValueLo2;
  private final MappedByteBuffer oobData3XorStackItemValueLo3;
  private final MappedByteBuffer oobData4XorStackItemValueLo4;
  private final MappedByteBuffer oobData5XorStaticGas;
  private final MappedByteBuffer oobData6;
  private final MappedByteBuffer oobData7;
  private final MappedByteBuffer oobData8;
  private final MappedByteBuffer oobInst;
  private final MappedByteBuffer peekAtAccount;
  private final MappedByteBuffer peekAtContext;
  private final MappedByteBuffer peekAtMiscellaneous;
  private final MappedByteBuffer peekAtScenario;
  private final MappedByteBuffer peekAtStack;
  private final MappedByteBuffer peekAtStorage;
  private final MappedByteBuffer peekAtTransaction;
  private final MappedByteBuffer prcFailureKnownToHubXorOpcx;
  private final MappedByteBuffer prcFailureKnownToRamXorPushpopFlag;
  private final MappedByteBuffer prcSuccessWillRevertXorRdcx;
  private final MappedByteBuffer prcSuccessWontRevertXorShfFlag;
  private final MappedByteBuffer programCounter;
  private final MappedByteBuffer programCounterNew;
  private final MappedByteBuffer refgas;
  private final MappedByteBuffer refgasNew;
  private final MappedByteBuffer returnDeploymentEmptyCodeWillRevertXorShfFlag;
  private final MappedByteBuffer returnDeploymentEmptyCodeWontRevertXorSox;
  private final MappedByteBuffer returnDeploymentNonemptyCodeWillRevertXorSstorex;
  private final MappedByteBuffer returnDeploymentNonemptyCodeWontRevertXorStackramFlag;
  private final MappedByteBuffer returnExceptionXorStackItemPop1;
  private final MappedByteBuffer returnMessageCallWillTouchRamXorStackItemPop2;
  private final MappedByteBuffer returnMessageCallWontTouchRamXorStackItemPop3;
  private final MappedByteBuffer
      rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi;
  private final MappedByteBuffer
      rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo;
  private final MappedByteBuffer rlpaddrFlagXorStpOogxXorCallSmcSuccessCallerWontRevertXorDecFlag3;
  private final MappedByteBuffer
      rlpaddrKecHiXorReturnAtOffsetXorOobData2XorStackItemValueHi1XorValue;
  private final MappedByteBuffer rlpaddrKecLoXorReturnDataOffsetXorOobData3XorStackItemValueHi2;
  private final MappedByteBuffer rlpaddrRecipeXorReturnDataSizeXorOobData4XorStackItemValueHi3;
  private final MappedByteBuffer rlpaddrSaltHiXorOobData5XorStackItemValueHi4;
  private final MappedByteBuffer rlpaddrSaltLoXorOobData6XorStackItemValueLo1;
  private final MappedByteBuffer romLexFlagXorStpWarmthXorCreateAbortXorDecFlag4;
  private final MappedByteBuffer stackItemPop4;
  private final MappedByteBuffer staticFlag;
  private final MappedByteBuffer staticx;
  private final MappedByteBuffer stoFlag;
  private final MappedByteBuffer stpGasHi;
  private final MappedByteBuffer stpGasLo;
  private final MappedByteBuffer stpGasPaidOutOfPocket;
  private final MappedByteBuffer stpGasStipend;
  private final MappedByteBuffer stpGasUpfrontGasCost;
  private final MappedByteBuffer stpInst;
  private final MappedByteBuffer stpValHi;
  private final MappedByteBuffer stpValLo;
  private final MappedByteBuffer subStamp;
  private final MappedByteBuffer sux;
  private final MappedByteBuffer swapFlag;
  private final MappedByteBuffer transactionReverts;
  private final MappedByteBuffer trmFlag;
  private final MappedByteBuffer trmFlagXorCreateExceptionXorJumpx;
  private final MappedByteBuffer trmRawAddrHiXorOobData1XorStackItemValueLo1;
  private final MappedByteBuffer twoLineInstruction;
  private final MappedByteBuffer txExec;
  private final MappedByteBuffer txFinl;
  private final MappedByteBuffer txInit;
  private final MappedByteBuffer txSkip;
  private final MappedByteBuffer txWarm;
  private final MappedByteBuffer txnFlag;
  private final MappedByteBuffer warmNewXorCreateFailureConditionWontRevertXorJumpFlag;
  private final MappedByteBuffer
      warmXorCreateFailureConditionWillRevertXorJumpDestinationVettingRequired;
  private final MappedByteBuffer wcpFlag;

  static List<ColumnHeader> headers(int length) {
    return List.of(
        new ColumnHeader("hub_v2.ABSOLUTE_TRANSACTION_NUMBER", 32, length),
        new ColumnHeader(
            "hub_v2.ADDRESS_HI_xor_ACCOUNT_ADDRESS_HI_xor_CCRS_STAMP_xor_ALPHA_xor_ADDRESS_HI_xor_BASEFEE",
            32,
            length),
        new ColumnHeader(
            "hub_v2.ADDRESS_LO_xor_ACCOUNT_ADDRESS_LO_xor_EXP_DATA_1_xor_DELTA_xor_ADDRESS_LO_xor_BATCH_NUM",
            32,
            length),
        new ColumnHeader(
            "hub_v2.BALANCE_NEW_xor_BYTE_CODE_ADDRESS_HI_xor_EXP_DATA_3_xor_HASH_INFO_KEC_LO_xor_STORAGE_KEY_HI_xor_COINBASE_ADDRESS_HI",
            32,
            length),
        new ColumnHeader(
            "hub_v2.BALANCE_xor_ACCOUNT_DEPLOYMENT_NUMBER_xor_EXP_DATA_2_xor_HASH_INFO_KEC_HI_xor_DEPLOYMENT_NUMBER_xor_CALL_DATA_SIZE",
            32,
            length),
        new ColumnHeader("hub_v2.BATCH_NUMBER", 32, length),
        new ColumnHeader("hub_v2.CALLER_CONTEXT_NUMBER", 32, length),
        new ColumnHeader("hub_v2.CODE_ADDRESS_HI", 32, length),
        new ColumnHeader("hub_v2.CODE_ADDRESS_LO", 32, length),
        new ColumnHeader("hub_v2.CODE_DEPLOYMENT_NUMBER", 32, length),
        new ColumnHeader("hub_v2.CODE_DEPLOYMENT_STATUS", 1, length),
        new ColumnHeader("hub_v2.CODE_FRAGMENT_INDEX", 32, length),
        new ColumnHeader(
            "hub_v2.CODE_FRAGMENT_INDEX_xor_BYTE_CODE_ADDRESS_LO_xor_EXP_DATA_4_xor_HASH_INFO_SIZE_xor_STORAGE_KEY_LO_xor_COINBASE_ADDRESS_LO",
            32,
            length),
        new ColumnHeader(
            "hub_v2.CODE_HASH_HI_NEW_xor_BYTE_CODE_DEPLOYMENT_NUMBER_xor_MXP_GAS_MXP_xor_NB_ADDED_xor_VAL_CURR_LO_xor_FROM_ADDRESS_LO",
            32,
            length),
        new ColumnHeader(
            "hub_v2.CODE_HASH_HI_xor_BYTE_CODE_CODE_FRAGMENT_INDEX_xor_EXP_DATA_5_xor_INSTRUCTION_xor_VAL_CURR_HI_xor_FROM_ADDRESS_HI",
            32,
            length),
        new ColumnHeader(
            "hub_v2.CODE_HASH_LO_NEW_xor_CALLER_ADDRESS_HI_xor_MXP_OFFSET_1_HI_xor_PUSH_VALUE_HI_xor_VAL_NEXT_LO_xor_GAS_PRICE",
            32,
            length),
        new ColumnHeader(
            "hub_v2.CODE_HASH_LO_xor_BYTE_CODE_DEPLOYMENT_STATUS_xor_MXP_INST_xor_NB_REMOVED_xor_VAL_NEXT_HI_xor_GAS_LIMIT",
            32,
            length),
        new ColumnHeader(
            "hub_v2.CODE_SIZE_NEW_xor_CALLER_CONTEXT_NUMBER_xor_MXP_OFFSET_2_HI_xor_STACK_ITEM_HEIGHT_1_xor_VAL_ORIG_LO_xor_INITIAL_GAS",
            32,
            length),
        new ColumnHeader(
            "hub_v2.CODE_SIZE_xor_CALLER_ADDRESS_LO_xor_MXP_OFFSET_1_LO_xor_PUSH_VALUE_LO_xor_VAL_ORIG_HI_xor_INITIAL_BALANCE",
            32,
            length),
        new ColumnHeader("hub_v2.CONTEXT_GETS_REVERTED", 1, length),
        new ColumnHeader("hub_v2.CONTEXT_MAY_CHANGE", 1, length),
        new ColumnHeader("hub_v2.CONTEXT_NUMBER", 32, length),
        new ColumnHeader("hub_v2.CONTEXT_NUMBER_NEW", 32, length),
        new ColumnHeader("hub_v2.CONTEXT_REVERT_STAMP", 32, length),
        new ColumnHeader("hub_v2.CONTEXT_SELF_REVERTS_FLAG", 1, length),
        new ColumnHeader("hub_v2.CONTEXT_WILL_REVERT_FLAG", 1, length),
        new ColumnHeader("hub_v2.COUNTER_NSR", 32, length),
        new ColumnHeader("hub_v2.COUNTER_TLI", 1, length),
        new ColumnHeader(
            "hub_v2.CREATE_FAILURE_CONDITION_WILL_REVERT_xor_HASH_INFO_FLAG", 1, length),
        new ColumnHeader("hub_v2.CREATE_FAILURE_CONDITION_WONT_REVERT_xor_ICPX", 1, length),
        new ColumnHeader(
            "hub_v2.CREATE_NONEMPTY_INIT_CODE_FAILURE_WILL_REVERT_xor_INVALID_FLAG", 1, length),
        new ColumnHeader(
            "hub_v2.CREATE_NONEMPTY_INIT_CODE_FAILURE_WONT_REVERT_xor_JUMPX", 1, length),
        new ColumnHeader(
            "hub_v2.CREATE_NONEMPTY_INIT_CODE_SUCCESS_WILL_REVERT_xor_JUMP_DESTINATION_VETTING_REQUIRED",
            1,
            length),
        new ColumnHeader(
            "hub_v2.CREATE_NONEMPTY_INIT_CODE_SUCCESS_WONT_REVERT_xor_JUMP_FLAG", 1, length),
        new ColumnHeader(
            "hub_v2.DEPLOYMENT_NUMBER_INFTY_xor_CALL_DATA_SIZE_xor_MXP_SIZE_1_HI_xor_STACK_ITEM_HEIGHT_3_xor_LEFTOVER_GAS",
            32,
            length),
        new ColumnHeader(
            "hub_v2.DEPLOYMENT_NUMBER_NEW_xor_CALL_STACK_DEPTH_xor_MXP_SIZE_1_LO_xor_STACK_ITEM_HEIGHT_4_xor_NONCE",
            32,
            length),
        new ColumnHeader(
            "hub_v2.DEPLOYMENT_NUMBER_xor_CALL_DATA_OFFSET_xor_MXP_OFFSET_2_LO_xor_STACK_ITEM_HEIGHT_2_xor_INIT_CODE_SIZE",
            32,
            length),
        new ColumnHeader(
            "hub_v2.DEPLOYMENT_STATUS_INFTY_xor_IS_STATIC_xor_EXP_FLAG_xor_CALL_EOA_SUCCESS_CALLER_WILL_REVERT_xor_ADD_FLAG_xor_VAL_CURR_IS_ORIG_xor_IS_DEPLOYMENT",
            1,
            length),
        new ColumnHeader(
            "hub_v2.DEPLOYMENT_STATUS_NEW_xor_UPDATE_xor_MMU_FLAG_xor_CALL_EOA_SUCCESS_CALLER_WONT_REVERT_xor_BIN_FLAG_xor_VAL_CURR_IS_ZERO_xor_IS_TYPE2",
            1,
            length),
        new ColumnHeader(
            "hub_v2.DEPLOYMENT_STATUS_xor_IS_ROOT_xor_CCSR_FLAG_xor_CALL_ABORT_xor_ACC_FLAG_xor_VAL_CURR_CHANGES_xor_COPY_TXCD_AT_INITIALIZATION",
            1,
            length),
        new ColumnHeader("hub_v2.DOM_STAMP", 32, length),
        new ColumnHeader("hub_v2.EXCEPTION_AHOY", 1, length),
        new ColumnHeader(
            "hub_v2.EXISTS_NEW_xor_MXP_DEPLOYS_xor_CALL_PRC_FAILURE_xor_CALL_FLAG_xor_VAL_NEXT_IS_ORIG_xor_STATUS_CODE",
            1,
            length),
        new ColumnHeader(
            "hub_v2.EXISTS_xor_MMU_SUCCESS_BIT_xor_CALL_EXCEPTION_xor_BTC_FLAG_xor_VAL_NEXT_IS_CURR_xor_REQUIRES_EVM_EXECUTION",
            1,
            length),
        new ColumnHeader("hub_v2.EXP_INST_xor_PRC_CALLEE_GAS", 8, length),
        new ColumnHeader("hub_v2.GAS_ACTUAL", 32, length),
        new ColumnHeader("hub_v2.GAS_COST", 32, length),
        new ColumnHeader("hub_v2.GAS_EXPECTED", 32, length),
        new ColumnHeader("hub_v2.GAS_NEXT", 32, length),
        new ColumnHeader(
            "hub_v2.HAS_CODE_NEW_xor_MXP_MXPX_xor_CALL_PRC_SUCCESS_CALLER_WONT_REVERT_xor_COPY_FLAG_xor_VAL_ORIG_IS_ZERO",
            1,
            length),
        new ColumnHeader(
            "hub_v2.HAS_CODE_xor_MXP_FLAG_xor_CALL_PRC_SUCCESS_CALLER_WILL_REVERT_xor_CON_FLAG_xor_VAL_NEXT_IS_ZERO",
            1,
            length),
        new ColumnHeader("hub_v2.HASH_INFO_STAMP", 32, length),
        new ColumnHeader("hub_v2.HUB_STAMP", 32, length),
        new ColumnHeader("hub_v2.HUB_STAMP_TRANSACTION_END", 32, length),
        new ColumnHeader(
            "hub_v2.IS_PRECOMPILE_xor_OOB_FLAG_xor_CALL_SMC_FAILURE_CALLER_WILL_REVERT_xor_CREATE_FLAG_xor_WARM",
            1,
            length),
        new ColumnHeader("hub_v2.LOG_INFO_STAMP", 32, length),
        new ColumnHeader(
            "hub_v2.MARKED_FOR_SELFDESTRUCT_NEW_xor_STP_FLAG_xor_CALL_SMC_SUCCESS_CALLER_WILL_REVERT_xor_DEC_FLAG_2",
            1,
            length),
        new ColumnHeader(
            "hub_v2.MARKED_FOR_SELFDESTRUCT_xor_STP_EXISTS_xor_CALL_SMC_FAILURE_CALLER_WONT_REVERT_xor_DEC_FLAG_1_xor_WARM_NEW",
            1,
            length),
        new ColumnHeader("hub_v2.MMU_AUX_ID_xor_PRC_CALLER_GAS", 8, length),
        new ColumnHeader("hub_v2.MMU_EXO_SUM_xor_PRC_CDO", 8, length),
        new ColumnHeader("hub_v2.MMU_INST_xor_PRC_CDS", 8, length),
        new ColumnHeader("hub_v2.MMU_LIMB_1", 32, length),
        new ColumnHeader("hub_v2.MMU_LIMB_2", 32, length),
        new ColumnHeader("hub_v2.MMU_PHASE_xor_PRC_RAC", 8, length),
        new ColumnHeader("hub_v2.MMU_REF_OFFSET_xor_PRC_RAO", 8, length),
        new ColumnHeader("hub_v2.MMU_REF_SIZE_xor_PRC_RETURN_GAS", 8, length),
        new ColumnHeader("hub_v2.MMU_SIZE", 8, length),
        new ColumnHeader("hub_v2.MMU_SRC_ID", 8, length),
        new ColumnHeader("hub_v2.MMU_SRC_OFFSET_HI", 32, length),
        new ColumnHeader("hub_v2.MMU_SRC_OFFSET_LO", 32, length),
        new ColumnHeader("hub_v2.MMU_STAMP", 32, length),
        new ColumnHeader("hub_v2.MMU___TGT_ID", 8, length),
        new ColumnHeader("hub_v2.MODEXP_xor_OOGX", 1, length),
        new ColumnHeader("hub_v2.MXP_STAMP", 32, length),
        new ColumnHeader(
            "hub_v2.NONCE_NEW_xor_CONTEXT_NUMBER_xor_MXP_SIZE_2_LO_xor_STACK_ITEM_STAMP_2_xor_REFUND_COUNTER_INFINITY",
            32,
            length),
        new ColumnHeader(
            "hub_v2.NONCE_xor_CALL_VALUE_xor_MXP_SIZE_2_HI_xor_STACK_ITEM_STAMP_1_xor_REFUND_AMOUNT",
            32,
            length),
        new ColumnHeader("hub_v2.NUMBER_OF_NON_STACK_ROWS", 32, length),
        new ColumnHeader("hub_v2.OOB____DATA_2_xor_STACK_ITEM_VALUE_LO_2", 32, length),
        new ColumnHeader("hub_v2.OOB____DATA_3_xor_STACK_ITEM_VALUE_LO_3", 32, length),
        new ColumnHeader("hub_v2.OOB____DATA_4_xor_STACK_ITEM_VALUE_LO_4", 32, length),
        new ColumnHeader("hub_v2.OOB____DATA_5_xor_STATIC_GAS", 32, length),
        new ColumnHeader("hub_v2.OOB____DATA_6", 32, length),
        new ColumnHeader("hub_v2.OOB____DATA_7", 32, length),
        new ColumnHeader("hub_v2.OOB____DATA_8", 32, length),
        new ColumnHeader("hub_v2.OOB___INST", 8, length),
        new ColumnHeader("hub_v2.PEEK_AT_ACCOUNT", 1, length),
        new ColumnHeader("hub_v2.PEEK_AT_CONTEXT", 1, length),
        new ColumnHeader("hub_v2.PEEK_AT_MISCELLANEOUS", 1, length),
        new ColumnHeader("hub_v2.PEEK_AT_SCENARIO", 1, length),
        new ColumnHeader("hub_v2.PEEK_AT_STACK", 1, length),
        new ColumnHeader("hub_v2.PEEK_AT_STORAGE", 1, length),
        new ColumnHeader("hub_v2.PEEK_AT_TRANSACTION", 1, length),
        new ColumnHeader("hub_v2.PRC_FAILURE_KNOWN_TO_HUB_xor_OPCX", 1, length),
        new ColumnHeader("hub_v2.PRC_FAILURE_KNOWN_TO_RAM_xor_PUSHPOP_FLAG", 1, length),
        new ColumnHeader("hub_v2.PRC_SUCCESS_WILL_REVERT_xor_RDCX", 1, length),
        new ColumnHeader("hub_v2.PRC_SUCCESS_WONT_REVERT_xor_SHF_FLAG", 1, length),
        new ColumnHeader("hub_v2.PROGRAM_COUNTER", 32, length),
        new ColumnHeader("hub_v2.PROGRAM_COUNTER_NEW", 32, length),
        new ColumnHeader("hub_v2.REFGAS", 32, length),
        new ColumnHeader("hub_v2.REFGAS_NEW", 32, length),
        new ColumnHeader("hub_v2.RETURN_DEPLOYMENT_EMPTY_CODE_WILL_REVERT_xor_SHF_FLAG", 1, length),
        new ColumnHeader("hub_v2.RETURN_DEPLOYMENT_EMPTY_CODE_WONT_REVERT_xor_SOX", 1, length),
        new ColumnHeader(
            "hub_v2.RETURN_DEPLOYMENT_NONEMPTY_CODE_WILL_REVERT_xor_SSTOREX", 1, length),
        new ColumnHeader(
            "hub_v2.RETURN_DEPLOYMENT_NONEMPTY_CODE_WONT_REVERT_xor_STACKRAM_FLAG", 1, length),
        new ColumnHeader("hub_v2.RETURN_EXCEPTION_xor_STACK_ITEM_POP_1", 1, length),
        new ColumnHeader(
            "hub_v2.RETURN_MESSAGE_CALL_WILL_TOUCH_RAM_xor_STACK_ITEM_POP_2", 1, length),
        new ColumnHeader(
            "hub_v2.RETURN_MESSAGE_CALL_WONT_TOUCH_RAM_xor_STACK_ITEM_POP_3", 1, length),
        new ColumnHeader(
            "hub_v2.RLPADDR_DEP_ADDR_HI_xor_RETURNER_CONTEXT_NUMBER_xor_MXP_WORDS_xor_STACK_ITEM_STAMP_3_xor_TO_ADDRESS_HI",
            32,
            length),
        new ColumnHeader(
            "hub_v2.RLPADDR_DEP_ADDR_LO_xor_RETURN_AT_CAPACITY_xor_OOB_DATA_1_xor_STACK_ITEM_STAMP_4_xor_TO_ADDRESS_LO",
            32,
            length),
        new ColumnHeader(
            "hub_v2.RLPADDR_FLAG_xor_STP_OOGX_xor_CALL_SMC_SUCCESS_CALLER_WONT_REVERT_xor_DEC_FLAG_3",
            1,
            length),
        new ColumnHeader(
            "hub_v2.RLPADDR_KEC_HI_xor_RETURN_AT_OFFSET_xor_OOB_DATA_2_xor_STACK_ITEM_VALUE_HI_1_xor_VALUE",
            32,
            length),
        new ColumnHeader(
            "hub_v2.RLPADDR_KEC_LO_xor_RETURN_DATA_OFFSET_xor_OOB_DATA_3_xor_STACK_ITEM_VALUE_HI_2",
            32,
            length),
        new ColumnHeader(
            "hub_v2.RLPADDR_RECIPE_xor_RETURN_DATA_SIZE_xor_OOB_DATA_4_xor_STACK_ITEM_VALUE_HI_3",
            32,
            length),
        new ColumnHeader(
            "hub_v2.RLPADDR_SALT_HI_xor_OOB_DATA_5_xor_STACK_ITEM_VALUE_HI_4", 32, length),
        new ColumnHeader(
            "hub_v2.RLPADDR_SALT_LO_xor_OOB_DATA_6_xor_STACK_ITEM_VALUE_LO_1", 32, length),
        new ColumnHeader(
            "hub_v2.ROM_LEX_FLAG_xor_STP_WARMTH_xor_CREATE_ABORT_xor_DEC_FLAG_4", 1, length),
        new ColumnHeader("hub_v2.STACK_ITEM_POP_4", 1, length),
        new ColumnHeader("hub_v2.STATIC_FLAG", 1, length),
        new ColumnHeader("hub_v2.STATICX", 1, length),
        new ColumnHeader("hub_v2.STO_FLAG", 1, length),
        new ColumnHeader("hub_v2.STP___GAS_HI", 32, length),
        new ColumnHeader("hub_v2.STP___GAS_LO", 32, length),
        new ColumnHeader("hub_v2.STP___GAS_PAID_OUT_OF_POCKET", 32, length),
        new ColumnHeader("hub_v2.STP___GAS_STIPEND", 32, length),
        new ColumnHeader("hub_v2.STP___GAS_UPFRONT_GAS_COST", 32, length),
        new ColumnHeader("hub_v2.STP___INST", 32, length),
        new ColumnHeader("hub_v2.STP___VAL_HI", 32, length),
        new ColumnHeader("hub_v2.STP___VAL_LO", 32, length),
        new ColumnHeader("hub_v2.SUB_STAMP", 32, length),
        new ColumnHeader("hub_v2.SUX", 1, length),
        new ColumnHeader("hub_v2.SWAP_FLAG", 1, length),
        new ColumnHeader("hub_v2.TRANSACTION_REVERTS", 1, length),
        new ColumnHeader(
            "hub_v2.TRM_FLAG_xor_CREATE_EMPTY_INIT_CODE_WILL_REVERT_xor_DUP_FLAG", 1, length),
        new ColumnHeader(
            "hub_v2.TRM_RAW_ADDR_HI_xor_OOB_DATA_7_xor_STACK_ITEM_VALUE_LO_2", 32, length),
        new ColumnHeader("hub_v2.TWO_LINE_INSTRUCTION", 1, length),
        new ColumnHeader("hub_v2.TX_EXEC", 1, length),
        new ColumnHeader("hub_v2.TX_FINL", 1, length),
        new ColumnHeader("hub_v2.TX_INIT", 1, length),
        new ColumnHeader("hub_v2.TX_SKIP", 1, length),
        new ColumnHeader("hub_v2.TX_WARM", 1, length),
        new ColumnHeader("hub_v2.TXN_FLAG", 1, length),
        new ColumnHeader("hub_v2.WARM_NEW_xor_CREATE_EXCEPTION_xor_HALT_FLAG", 1, length),
        new ColumnHeader(
            "hub_v2.WARM_xor_CREATE_EMPTY_INIT_CODE_WONT_REVERT_xor_EXT_FLAG", 1, length),
        new ColumnHeader("hub_v2.WCP_FLAG", 1, length));
  }

  public Trace(List<MappedByteBuffer> buffers) {
    this.absoluteTransactionNumber = buffers.get(0);
    this.addressHiXorAccountAddressHiXorCcrsStampXorAlphaXorAddressHiXorBasefee = buffers.get(1);
    this.addressLoXorAccountAddressLoXorExpData1XorDeltaXorAddressLoXorBatchNum = buffers.get(2);
    this
            .balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi =
        buffers.get(3);
    this
            .balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize =
        buffers.get(4);
    this.batchNumber = buffers.get(5);
    this.callerContextNumber = buffers.get(6);
    this.codeFragmentIndex = buffers.get(7);
    this
            .codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo =
        buffers.get(8);
    this
            .codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo =
        buffers.get(9);
    this
            .codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi =
        buffers.get(10);
    this.codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice =
        buffers.get(11);
    this.codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit =
        buffers.get(12);
    this
            .codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas =
        buffers.get(13);
    this.codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance =
        buffers.get(14);
    this.contextGetsReverted = buffers.get(15);
    this.contextMayChange = buffers.get(16);
    this.contextNumber = buffers.get(17);
    this.contextNumberNew = buffers.get(18);
    this.contextRevertStamp = buffers.get(19);
    this.contextSelfReverts = buffers.get(20);
    this.contextWillRevert = buffers.get(21);
    this.counterNsr = buffers.get(22);
    this.counterTli = buffers.get(23);
    this.createFailureConditionWillRevertXorHashInfoFlag = buffers.get(24);
    this.createFailureConditionWontRevertXorIcpx = buffers.get(25);
    this.createNonemptyInitCodeFailureWillRevertXorInvalidFlag = buffers.get(26);
    this.createNonemptyInitCodeFailureWontRevertXorJumpx = buffers.get(27);
    this.createNonemptyInitCodeSuccessWillRevertXorJumpDestinationVettingRequired = buffers.get(28);
    this.createNonemptyInitCodeSuccessWontRevertXorJumpFlag = buffers.get(29);
    this.deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas =
        buffers.get(30);
    this.deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce =
        buffers.get(31);
    this.deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize =
        buffers.get(32);
    this
            .deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment =
        buffers.get(33);
    this
            .deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2 =
        buffers.get(34);
    this
            .deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization =
        buffers.get(35);
    this.domStamp = buffers.get(36);
    this.exceptionAhoy = buffers.get(37);
    this.existsNewXorMxpDeploysXorCallPrcFailureXorCallFlagXorValNextIsOrigXorStatusCode =
        buffers.get(38);
    this.existsXorMmuSuccessBitXorCallExceptionXorBtcFlagXorValNextIsCurrXorRequiresEvmExecution =
        buffers.get(39);
    this.expInstXorPrcCalleeGas = buffers.get(40);
    this.gasActual = buffers.get(41);
    this.gasCost = buffers.get(42);
    this.gasExpected = buffers.get(43);
    this.gasNext = buffers.get(44);
    this.hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWontRevertXorCopyFlagXorValOrigIsZero =
        buffers.get(45);
    this.hasCodeXorMxpFlagXorCallPrcSuccessCallerWillRevertXorConFlagXorValNextIsZero =
        buffers.get(46);
    this.hashInfoStamp = buffers.get(47);
    this.height = buffers.get(48);
    this.heightNew = buffers.get(49);
    this.hubStamp = buffers.get(50);
    this.hubStampTransactionEnd = buffers.get(51);
    this.isPrecompileXorOobFlagXorCallSmcFailureCallerWillRevertXorCreateFlagXorWarm =
        buffers.get(52);
    this.logInfoStamp = buffers.get(53);
    this.markedForSelfdestructNewXorStpFlagXorCallSmcSuccessCallerWillRevertXorDecFlag2 =
        buffers.get(54);
    this.markedForSelfdestructXorStpExistsXorCallSmcFailureCallerWontRevertXorDecFlag1XorWarmNew =
        buffers.get(55);
    this.mmuAuxIdXorPrcCallerGas = buffers.get(56);
    this.mmuExoSumXorPrcCdo = buffers.get(57);
    this.mmuInstXorPrcCds = buffers.get(58);
    this.mmuLimb1 = buffers.get(59);
    this.mmuLimb2 = buffers.get(60);
    this.mmuPhaseXorPrcRac = buffers.get(61);
    this.mmuRefOffsetXorPrcRao = buffers.get(62);
    this.mmuRefSizeXorPrcReturnGas = buffers.get(63);
    this.mmuSize = buffers.get(64);
    this.mmuSrcId = buffers.get(65);
    this.mmuSrcOffsetHi = buffers.get(66);
    this.mmuSrcOffsetLo = buffers.get(67);
    this.mmuStamp = buffers.get(68);
    this.mmuTgtId = buffers.get(69);
    this.mmuTgtOffsetLo = buffers.get(70);
    this.mxpStamp = buffers.get(71);
    this.nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity =
        buffers.get(72);
    this.nonceXorCallValueXorMxpSize2HiXorStackItemStamp1XorRefundAmount = buffers.get(73);
    this.numberOfNonStackRows = buffers.get(74);
    this.oobData8XorStackItemValueLo3 = buffers.get(75);
    this.oobInst = buffers.get(76);
    this.peekAtAccount = buffers.get(77);
    this.peekAtContext = buffers.get(78);
    this.peekAtMiscellaneous = buffers.get(79);
    this.peekAtScenario = buffers.get(80);
    this.peekAtStack = buffers.get(81);
    this.peekAtStorage = buffers.get(82);
    this.peekAtTransaction = buffers.get(83);
    this.prcBlake2FXorKecFlag = buffers.get(84);
    this.prcEcaddXorLogFlag = buffers.get(85);
    this.prcEcmulXorLogInfoFlag = buffers.get(86);
    this.prcEcpairingXorMachineStateFlag = buffers.get(87);
    this.prcEcrecoverXorMaxcsx = buffers.get(88);
    this.prcFailureKnownToHubXorModFlag = buffers.get(89);
    this.prcFailureKnownToRamXorMulFlag = buffers.get(90);
    this.prcIdentityXorMxpx = buffers.get(91);
    this.prcModexpXorMxpFlag = buffers.get(92);
    this.prcRipemd160XorOogx = buffers.get(93);
    this.prcSha2256XorOpcx = buffers.get(94);
    this.prcSuccessWillRevertXorPushpopFlag = buffers.get(95);
    this.prcSuccessWontRevertXorRdcx = buffers.get(96);
    this.programCounter = buffers.get(97);
    this.programCounterNew = buffers.get(98);
    this.refgas = buffers.get(99);
    this.refgasNew = buffers.get(100);
    this.returnDeploymentEmptyCodeWillRevertXorShfFlag = buffers.get(101);
    this.returnDeploymentEmptyCodeWontRevertXorSox = buffers.get(102);
    this.returnDeploymentNonemptyCodeWillRevertXorSstorex = buffers.get(103);
    this.returnDeploymentNonemptyCodeWontRevertXorStackramFlag = buffers.get(104);
    this.returnExceptionXorStackItemPop1 = buffers.get(105);
    this.returnMessageCallWillTouchRamXorStackItemPop2 = buffers.get(106);
    this.returnMessageCallWontTouchRamXorStackItemPop3 = buffers.get(107);
    this.rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi =
        buffers.get(108);
    this.rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo =
        buffers.get(109);
    this.rlpaddrFlagXorStpOogxXorCallSmcSuccessCallerWontRevertXorDecFlag3 = buffers.get(110);
    this.rlpaddrKecHiXorReturnAtOffsetXorOobData2XorStackItemValueHi1XorValue = buffers.get(111);
    this.rlpaddrKecLoXorReturnDataOffsetXorOobData3XorStackItemValueHi2 = buffers.get(112);
    this.rlpaddrRecipeXorReturnDataSizeXorOobData4XorStackItemValueHi3 = buffers.get(113);
    this.rlpaddrSaltHiXorOobData5XorStackItemValueHi4 = buffers.get(114);
    this.rlpaddrSaltLoXorOobData6XorStackItemValueLo1 = buffers.get(115);
    this.romLexFlagXorStpWarmthXorCreateAbortXorDecFlag4 = buffers.get(116);
    this.stackItemPop4 = buffers.get(117);
    this.staticFlag = buffers.get(118);
    this.staticx = buffers.get(119);
    this.stoFlag = buffers.get(120);
    this.stpGasHiXorStackItemValueLo4 = buffers.get(121);
    this.stpGasLoXorStaticGas = buffers.get(122);
    this.stpGasPaidOutOfPocket = buffers.get(123);
    this.stpGasStipend = buffers.get(124);
    this.stpGasUpfrontGasCost = buffers.get(125);
    this.stpInst = buffers.get(126);
    this.stpValHi = buffers.get(127);
    this.stpValLo = buffers.get(128);
    this.subStamp = buffers.get(129);
    this.sux = buffers.get(130);
    this.swapFlag = buffers.get(131);
    this.transactionReverts = buffers.get(132);
    this.trmFlagXorCreateEmptyInitCodeWillRevertXorDupFlag = buffers.get(133);
    this.trmRawAddrHiXorOobData7XorStackItemValueLo2 = buffers.get(134);
    this.twoLineInstruction = buffers.get(135);
    this.txExec = buffers.get(136);
    this.txFinl = buffers.get(137);
    this.txInit = buffers.get(138);
    this.txSkip = buffers.get(139);
    this.txWarm = buffers.get(140);
    this.txnFlag = buffers.get(141);
    this.warmNewXorCreateExceptionXorHaltFlag = buffers.get(142);
    this.warmXorCreateEmptyInitCodeWontRevertXorExtFlag = buffers.get(143);
    this.wcpFlag = buffers.get(144);
  }

  public int size() {
    if (!filled.isEmpty()) {
      throw new RuntimeException("Cannot measure a trace with a non-validated row.");
    }

    return this.currentLine;
  }

  public Trace absoluteTransactionNumber(final Bytes b) {
    if (filled.get(0)) {
      throw new IllegalStateException("hub_v2.ABSOLUTE_TRANSACTION_NUMBER already set");
    } else {
      filled.set(0);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      absoluteTransactionNumber.put((byte) 0);
    }
    absoluteTransactionNumber.put(b.toArrayUnsafe());

    return this;
  }

  public Trace batchNumber(final Bytes b) {
    if (filled.get(1)) {
      throw new IllegalStateException("hub_v2.BATCH_NUMBER already set");
    } else {
      filled.set(1);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      batchNumber.put((byte) 0);
    }
    batchNumber.put(b.toArrayUnsafe());

    return this;
  }

  public Trace callerContextNumber(final Bytes b) {
    if (filled.get(2)) {
      throw new IllegalStateException("hub_v2.CALLER_CONTEXT_NUMBER already set");
    } else {
      filled.set(2);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      callerContextNumber.put((byte) 0);
    }
    callerContextNumber.put(b.toArrayUnsafe());

    return this;
  }

  public Trace codeAddressHi(final Bytes b) {
    if (filled.get(3)) {
      throw new IllegalStateException("hub_v2.CODE_ADDRESS_HI already set");
    } else {
      filled.set(3);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeAddressHi.put((byte) 0);
    }
    codeAddressHi.put(b.toArrayUnsafe());

    return this;
  }

  public Trace codeAddressLo(final Bytes b) {
    if (filled.get(4)) {
      throw new IllegalStateException("hub_v2.CODE_ADDRESS_LO already set");
    } else {
      filled.set(4);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeAddressLo.put((byte) 0);
    }
    codeAddressLo.put(b.toArrayUnsafe());

    return this;
  }

  public Trace codeDeploymentNumber(final Bytes b) {
    if (filled.get(5)) {
      throw new IllegalStateException("hub_v2.CODE_DEPLOYMENT_NUMBER already set");
    } else {
      filled.set(5);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeDeploymentNumber.put((byte) 0);
    }
    codeDeploymentNumber.put(b.toArrayUnsafe());

    return this;
  }

  public Trace codeDeploymentStatus(final Boolean b) {
    if (filled.get(6)) {
      throw new IllegalStateException("hub_v2.CODE_DEPLOYMENT_STATUS already set");
    } else {
      filled.set(6);
    }

    codeDeploymentStatus.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace codeFragmentIndex(final Bytes b) {
    if (filled.get(7)) {
      throw new IllegalStateException("hub_v2.CODE_FRAGMENT_INDEX already set");
    } else {
      filled.set(7);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeFragmentIndex.put((byte) 0);
    }
    codeFragmentIndex.put(b.toArrayUnsafe());

    return this;
  }

  public Trace contextGetsRevertedFlag(final Boolean b) {
    if (filled.get(8)) {
      throw new IllegalStateException("hub_v2.CONTEXT_GETS_REVERTED_FLAG already set");
    } else {
      filled.set(8);
    }

    contextGetsRevertedFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace contextMayChangeFlag(final Boolean b) {
    if (filled.get(9)) {
      throw new IllegalStateException("hub_v2.CONTEXT_MAY_CHANGE_FLAG already set");
    } else {
      filled.set(9);
    }

    contextMayChangeFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace contextNumber(final Bytes b) {
    if (filled.get(10)) {
      throw new IllegalStateException("hub_v2.CONTEXT_NUMBER already set");
    } else {
      filled.set(10);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      contextNumber.put((byte) 0);
    }
    contextNumber.put(b.toArrayUnsafe());

    return this;
  }

  public Trace contextNumberNew(final Bytes b) {
    if (filled.get(11)) {
      throw new IllegalStateException("hub_v2.CONTEXT_NUMBER_NEW already set");
    } else {
      filled.set(11);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      contextNumberNew.put((byte) 0);
    }
    contextNumberNew.put(b.toArrayUnsafe());

    return this;
  }

  public Trace contextRevertStamp(final Bytes b) {
    if (filled.get(12)) {
      throw new IllegalStateException("hub_v2.CONTEXT_REVERT_STAMP already set");
    } else {
      filled.set(12);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      contextRevertStamp.put((byte) 0);
    }
    contextRevertStamp.put(b.toArrayUnsafe());

    return this;
  }

  public Trace contextSelfRevertsFlag(final Boolean b) {
    if (filled.get(13)) {
      throw new IllegalStateException("hub_v2.CONTEXT_SELF_REVERTS_FLAG already set");
    } else {
      filled.set(13);
    }

    contextSelfRevertsFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace contextWillRevertFlag(final Boolean b) {
    if (filled.get(14)) {
      throw new IllegalStateException("hub_v2.CONTEXT_WILL_REVERT_FLAG already set");
    } else {
      filled.set(14);
    }

    contextWillRevertFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace counterNsr(final Bytes b) {
    if (filled.get(15)) {
      throw new IllegalStateException("hub_v2.COUNTER_NSR already set");
    } else {
      filled.set(15);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      counterNsr.put((byte) 0);
    }
    counterNsr.put(b.toArrayUnsafe());

    return this;
  }

  public Trace counterTli(final Boolean b) {
    if (filled.get(16)) {
      throw new IllegalStateException("hub_v2.COUNTER_TLI already set");
    } else {
      filled.set(16);
    }

    counterTli.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace domStamp(final Bytes b) {
    if (filled.get(17)) {
      throw new IllegalStateException("hub_v2.DOM_STAMP already set");
    } else {
      filled.set(17);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      domStamp.put((byte) 0);
    }
    domStamp.put(b.toArrayUnsafe());

    return this;
  }

  public Trace exceptionAhoyFlag(final Boolean b) {
    if (filled.get(18)) {
      throw new IllegalStateException("hub_v2.EXCEPTION_AHOY_FLAG already set");
    } else {
      filled.set(18);
    }

    exceptionAhoyFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace gasActual(final Bytes b) {
    if (filled.get(19)) {
      throw new IllegalStateException("hub_v2.GAS_ACTUAL already set");
    } else {
      filled.set(19);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      gasActual.put((byte) 0);
    }
    gasActual.put(b.toArrayUnsafe());

    return this;
  }

  public Trace gasCost(final Bytes b) {
    if (filled.get(20)) {
      throw new IllegalStateException("hub_v2.GAS_COST already set");
    } else {
      filled.set(20);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      gasCost.put((byte) 0);
    }
    gasCost.put(b.toArrayUnsafe());

    return this;
  }

  public Trace gasExpected(final Bytes b) {
    if (filled.get(21)) {
      throw new IllegalStateException("hub_v2.GAS_EXPECTED already set");
    } else {
      filled.set(21);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      gasExpected.put((byte) 0);
    }
    gasExpected.put(b.toArrayUnsafe());

    return this;
  }

  public Trace gasNext(final Bytes b) {
    if (filled.get(22)) {
      throw new IllegalStateException("hub_v2.GAS_NEXT already set");
    } else {
      filled.set(22);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      gasNext.put((byte) 0);
    }
    gasNext.put(b.toArrayUnsafe());

    return this;
  }

  public Trace gasRefund(final Bytes b) {
    if (filled.get(23)) {
      throw new IllegalStateException("hub_v2.GAS_REFUND already set");
    } else {
      filled.set(23);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      gasRefund.put((byte) 0);
    }
    gasRefund.put(b.toArrayUnsafe());

    return this;
  }

  public Trace gasRefundNew(final Bytes b) {
    if (filled.get(24)) {
      throw new IllegalStateException("hub_v2.GAS_REFUND_NEW already set");
    } else {
      filled.set(24);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      gasRefundNew.put((byte) 0);
    }
    gasRefundNew.put(b.toArrayUnsafe());

    return this;
  }

  public Trace hashInfoStamp(final Bytes b) {
    if (filled.get(25)) {
      throw new IllegalStateException("hub_v2.HASH_INFO_STAMP already set");
    } else {
      filled.set(25);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      hashInfoStamp.put((byte) 0);
    }
    hashInfoStamp.put(b.toArrayUnsafe());

    return this;
  }

  public Trace hubStamp(final Bytes b) {
    if (filled.get(26)) {
      throw new IllegalStateException("hub_v2.HUB_STAMP already set");
    } else {
      filled.set(26);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      hubStamp.put((byte) 0);
    }
    hubStamp.put(b.toArrayUnsafe());

    return this;
  }

  public Trace hubStampTransactionEnd(final Bytes b) {
    if (filled.get(27)) {
      throw new IllegalStateException("hub_v2.HUB_STAMP_TRANSACTION_END already set");
    } else {
      filled.set(27);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      hubStampTransactionEnd.put((byte) 0);
    }
    hubStampTransactionEnd.put(b.toArrayUnsafe());

    return this;
  }

  public Trace mmuStamp(final Bytes b) {
    if (filled.get(28)) {
      throw new IllegalStateException("hub_v2.MMU_STAMP already set");
    } else {
      filled.set(28);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      mmuStamp.put((byte) 0);
    }
    mmuStamp.put(b.toArrayUnsafe());

    return this;
  }

  public Trace mxpStamp(final Bytes b) {
    if (filled.get(29)) {
      throw new IllegalStateException("hub_v2.MXP_STAMP already set");
    } else {
      filled.set(29);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      mxpStamp.put((byte) 0);
    }
    mxpStamp.put(b.toArrayUnsafe());

    return this;
  }

  public Trace numberOfNonStackRows(final Bytes b) {
    if (filled.get(30)) {
      throw new IllegalStateException("hub_v2.NUMBER_OF_NON_STACK_ROWS already set");
    } else {
      filled.set(30);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      numberOfNonStackRows.put((byte) 0);
    }
    numberOfNonStackRows.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountAddrHi(final Bytes b) {
    if (filled.get(109)) {
      throw new IllegalStateException("hub_v2.account/ADDR_HI already set");
    } else {
      filled.set(109);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.put((byte) 0);
    }
    addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountAddrLo(final Bytes b) {
    if (filled.get(110)) {
      throw new IllegalStateException("hub_v2.account/ADDR_LO already set");
    } else {
      filled.set(110);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.put((byte) 0);
    }
    addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountBalance(final Bytes b) {
    if (filled.get(111)) {
      throw new IllegalStateException("hub_v2.account/BALANCE already set");
    } else {
      filled.set(111);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoSizeXorDeploymentNumberXorCoinbaseAddressHi
          .put((byte) 0);
    }
    balanceXorAccountDeploymentNumberXorExpData2XorHashInfoSizeXorDeploymentNumberXorCoinbaseAddressHi
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountBalanceNew(final Bytes b) {
    if (filled.get(112)) {
      throw new IllegalStateException("hub_v2.account/BALANCE_NEW already set");
    } else {
      filled.set(112);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHeightXorStorageKeyHiXorCoinbaseAddressLo.put(
          (byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHeightXorStorageKeyHiXorCoinbaseAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountCodeHashHi(final Bytes b) {
    if (filled.get(113)) {
      throw new IllegalStateException("hub_v2.account/CODE_HASH_HI already set");
    } else {
      filled.set(113);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.put(
          (byte) 0);
    }
    codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountCodeHashHiNew(final Bytes b) {
    if (filled.get(114)) {
      throw new IllegalStateException("hub_v2.account/CODE_HASH_HI_NEW already set");
    } else {
      filled.set(114);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
          .put((byte) 0);
    }
    balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountCodeHashLo(final Bytes b) {
    if (filled.get(115)) {
      throw new IllegalStateException("hub_v2.account/CODE_HASH_LO already set");
    } else {
      filled.set(115);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
          .put((byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountCodeHashLoNew(final Bytes b) {
    if (filled.get(116)) {
      throw new IllegalStateException("hub_v2.account/CODE_HASH_LO_NEW already set");
    } else {
      filled.set(116);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
          .put((byte) 0);
    }
    codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountCodeSize(final Bytes b) {
    if (filled.get(117)) {
      throw new IllegalStateException("hub_v2.account/CODE_SIZE already set");
    } else {
      filled.set(117);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi
          .put((byte) 0);
    }
    codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountCodeSizeNew(final Bytes b) {
    if (filled.get(118)) {
      throw new IllegalStateException("hub_v2.account/CODE_SIZE_NEW already set");
    } else {
      filled.set(118);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo
          .put((byte) 0);
    }
    codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountCodeHashLo(final Bytes b) {
    if (filled.get(119)) {
      throw new IllegalStateException("hub_v2.account/CODE_HASH_LO already set");
    } else {
      filled.set(119);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
          (byte) 0);
    }
    codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountCodeHashLoNew(final Bytes b) {
    if (filled.get(120)) {
      throw new IllegalStateException("hub_v2.account/DEP_NUM already set");
    } else {
      filled.set(120);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
          (byte) 0);
    }
    codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountDepNumNew(final Bytes b) {
    if (filled.get(121)) {
      throw new IllegalStateException("hub_v2.account/DEP_NUM_NEW already set");
    } else {
      filled.set(121);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
          (byte) 0);
    }
    codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountDepStatus(final Boolean b) {
    if (filled.get(49)) {
      throw new IllegalStateException("hub_v2.account/DEP_STATUS already set");
    } else {
      filled.set(49);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
          .put((byte) 0);
    }
    codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountDepStatusNew(final Boolean b) {
    if (filled.get(50)) {
      throw new IllegalStateException("hub_v2.account/DEP_STATUS_NEW already set");
    } else {
      filled.set(50);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.put(
          (byte) 0);
    }
    deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountDeploymentNumberInfty(final Bytes b) {
    if (filled.get(119)) {
      throw new IllegalStateException("hub_v2.account/DEPLOYMENT_NUMBER_INFTY already set");
    } else {
      filled.set(119);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.put(
          (byte) 0);
    }
    deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountDeploymentNumberNew(final Bytes b) {
    if (filled.get(125)) {
      throw new IllegalStateException("hub_v2.account/DEPLOYMENT_NUMBER_NEW already set");
    } else {
      filled.set(125);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce.put((byte) 0);
    }
    deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountDeploymentStatus(final Boolean b) {
    if (filled.get(47)) {
      throw new IllegalStateException("hub_v2.account/DEPLOYMENT_STATUS already set");
    } else {
      filled.set(47);
    }

    deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountDeploymentStatusInfty(final Boolean b) {
    if (filled.get(48)) {
      throw new IllegalStateException("hub_v2.account/DEPLOYMENT_STATUS_INFTY already set");
    } else {
      filled.set(48);
    }

    deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountDeploymentStatusNew(final Boolean b) {
    if (filled.get(49)) {
      throw new IllegalStateException("hub_v2.account/DEPLOYMENT_STATUS_NEW already set");
    } else {
      filled.set(49);
    }

    deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountExists(final Boolean b) {
    if (filled.get(51)) {
      throw new IllegalStateException("hub_v2.account/EXISTS already set");
    } else {
      filled.set(51);
    }

    existsXorMmuSuccessBitXorCallExceptionXorBtcFlagXorValNextIsCurrXorRequiresEvmExecution.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountExistsNew(final Boolean b) {
    if (filled.get(52)) {
      throw new IllegalStateException("hub_v2.account/EXISTS_NEW already set");
    } else {
      filled.set(52);
    }

    existsNewXorMxpDeploysXorCallPrcFailureXorCallFlagXorValNextIsOrigXorStatusCode.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountHasCode(final Boolean b) {
    if (filled.get(53)) {
      throw new IllegalStateException("hub_v2.account/HAS_CODE already set");
    } else {
      filled.set(53);
    }

    hasCodeXorMxpFlagXorCallPrcSuccessCallerWillRevertXorConFlagXorValNextIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountHasCodeNew(final Boolean b) {
    if (filled.get(54)) {
      throw new IllegalStateException("hub_v2.account/HAS_CODE_NEW already set");
    } else {
      filled.set(54);
    }

    hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWontRevertXorCopyFlagXorValOrigIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountIsPrecompile(final Boolean b) {
    if (filled.get(62)) {
      throw new IllegalStateException("hub_v2.account/IS_PRECOMPILE already set");
    } else {
      filled.set(62);
    }

    isPrecompileXorOobFlagXorCallSmcFailureCallerWillRevertXorCreateFlagXorWarm.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountIsRipemd160(final Boolean b) {
    if (filled.get(63)) {
      throw new IllegalStateException("hub_v2.account/IS_RIPEMD-160 already set");
    } else {
      filled.set(63);
    }

    markedForSelfdestructXorStpExistsXorCallSmcFailureCallerWontRevertXorDecFlag1XorWarmNew.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountIsSha2256(final Boolean b) {
    if (filled.get(64)) {
      throw new IllegalStateException("hub_v2.account/IS_SHA2-256 already set");
    } else {
      filled.set(64);
    }

    markedForSelfdestructNewXorStpFlagXorCallSmcSuccessCallerWillRevertXorDecFlag2.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountNonce(final Bytes b) {
    if (filled.get(126)) {
      throw new IllegalStateException("hub_v2.account/NONCE already set");
    } else {
      filled.set(126);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      nonceXorCallValueXorMxpSize2HiXorStackItemStamp1XorRefundAmount.put((byte) 0);
    }
    nonceXorCallValueXorMxpSize2HiXorStackItemStamp1XorRefundAmount.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountNonceNew(final Bytes b) {
    if (filled.get(127)) {
      throw new IllegalStateException("hub_v2.account/NONCE_NEW already set");
    } else {
      filled.set(127);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity.put((byte) 0);
    }
    nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrDepAddrHi(final Bytes b) {
    if (filled.get(128)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR_DEP_ADDR_HI already set");
    } else {
      filled.set(128);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.put(
          (byte) 0);
    }
    rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrDepAddrLo(final Bytes b) {
    if (filled.get(129)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR_DEP_ADDR_LO already set");
    } else {
      filled.set(129);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo.put((byte) 0);
    }
    rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrFlag(final Boolean b) {
    if (filled.get(57)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR_FLAG already set");
    } else {
      filled.set(57);
    }

    rlpaddrFlagXorStpOogxXorCallSmcSuccessCallerWontRevertXorDecFlag3.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountRlpaddrKecHi(final Bytes b) {
    if (filled.get(130)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR_KEC_HI already set");
    } else {
      filled.set(130);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecHiXorReturnAtOffsetXorOobData2XorStackItemValueHi1XorValue.put((byte) 0);
    }
    rlpaddrKecHiXorReturnAtOffsetXorOobData2XorStackItemValueHi1XorValue.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrKecLo(final Bytes b) {
    if (filled.get(131)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR_KEC_LO already set");
    } else {
      filled.set(131);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecLoXorReturnDataOffsetXorOobData3XorStackItemValueHi2.put((byte) 0);
    }
    rlpaddrKecLoXorReturnDataOffsetXorOobData3XorStackItemValueHi2.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrRecipe(final Bytes b) {
    if (filled.get(132)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR_RECIPE already set");
    } else {
      filled.set(132);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrRecipeXorReturnDataSizeXorOobData4XorStackItemValueHi3.put((byte) 0);
    }
    rlpaddrRecipeXorReturnDataSizeXorOobData4XorStackItemValueHi3.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrSaltHi(final Bytes b) {
    if (filled.get(133)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR_SALT_HI already set");
    } else {
      filled.set(133);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrSaltHiXorOobData5XorStackItemValueHi4.put((byte) 0);
    }
    rlpaddrSaltHiXorOobData5XorStackItemValueHi4.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrSaltLo(final Bytes b) {
    if (filled.get(134)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR_SALT_LO already set");
    } else {
      filled.set(134);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrSaltLoXorOobData6XorStackItemValueLo1.put((byte) 0);
    }
    rlpaddrSaltLoXorOobData6XorStackItemValueLo1.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRomLexFlag(final Boolean b) {
    if (filled.get(58)) {
      throw new IllegalStateException("hub_v2.account/ROM_LEX_FLAG already set");
    } else {
      filled.set(58);
    }

    romLexFlagXorStpWarmthXorCreateAbortXorDecFlag4.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountTrmFlag(final Boolean b) {
    if (filled.get(59)) {
      throw new IllegalStateException("hub_v2.account/TRM_FLAG already set");
    } else {
      filled.set(59);
    }

    trmFlagXorCreateEmptyInitCodeWillRevertXorDupFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountTrmRawAddrHi(final Bytes b) {
    if (filled.get(135)) {
      throw new IllegalStateException("hub_v2.account/TRM_RAW_ADDR_HI already set");
    } else {
      filled.set(135);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      trmRawAddrHiXorOobData7XorStackItemValueLo2.put((byte) 0);
    }
    trmRawAddrHiXorOobData7XorStackItemValueLo2.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountWarm(final Boolean b) {
    if (filled.get(60)) {
      throw new IllegalStateException("hub_v2.account/WARM already set");
    } else {
      filled.set(60);
    }

    warmXorCreateEmptyInitCodeWontRevertXorExtFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountWarmNew(final Boolean b) {
    if (filled.get(61)) {
      throw new IllegalStateException("hub_v2.account/WARM_NEW already set");
    } else {
      filled.set(61);
    }

    warmNewXorCreateExceptionXorHaltFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pContextAccountAddressHi(final Bytes b) {
    if (filled.get(112)) {
      throw new IllegalStateException("hub_v2.context/ACCOUNT_ADDRESS_HI already set");
    } else {
      filled.set(112);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addressHiXorAccountAddressHiXorCcrsStampXorAlphaXorAddressHiXorBasefee.put((byte) 0);
    }
    addressHiXorAccountAddressHiXorCcrsStampXorAlphaXorAddressHiXorBasefee.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextAccountAddressLo(final Bytes b) {
    if (filled.get(113)) {
      throw new IllegalStateException("hub_v2.context/ACCOUNT_ADDRESS_LO already set");
    } else {
      filled.set(113);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addressLoXorAccountAddressLoXorExpData1XorDeltaXorAddressLoXorBatchNum.put((byte) 0);
    }
    addressLoXorAccountAddressLoXorExpData1XorDeltaXorAddressLoXorBatchNum.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextAccountDeploymentNumber(final Bytes b) {
    if (filled.get(114)) {
      throw new IllegalStateException("hub_v2.context/ACCOUNT_DEPLOYMENT_NUMBER already set");
    } else {
      filled.set(114);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
          .put((byte) 0);
    }
    balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextByteCodeAddressHi(final Bytes b) {
    if (filled.get(115)) {
      throw new IllegalStateException("hub_v2.context/BYTE_CODE_ADDRESS_HI already set");
    } else {
      filled.set(115);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
          .put((byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextByteCodeAddressLo(final Bytes b) {
    if (filled.get(116)) {
      throw new IllegalStateException("hub_v2.context/BYTE_CODE_ADDRESS_LO already set");
    } else {
      filled.set(116);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
          .put((byte) 0);
    }
    codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextByteCodeCodeFragmentIndex(final Bytes b) {
    if (filled.get(117)) {
      throw new IllegalStateException("hub_v2.context/BYTE_CODE_CODE_FRAGMENT_INDEX already set");
    } else {
      filled.set(117);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi
          .put((byte) 0);
    }
    codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextByteCodeDeploymentNumber(final Bytes b) {
    if (filled.get(118)) {
      throw new IllegalStateException("hub_v2.context/BYTE_CODE_DEPLOYMENT_NUMBER already set");
    } else {
      filled.set(118);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo
          .put((byte) 0);
    }
    codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextByteCodeDeploymentStatus(final Bytes b) {
    if (filled.get(119)) {
      throw new IllegalStateException("hub_v2.context/BYTE_CODE_DEPLOYMENT_STATUS already set");
    } else {
      filled.set(119);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
          (byte) 0);
    }
    codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallDataOffset(final Bytes b) {
    if (filled.get(123)) {
      throw new IllegalStateException("hub_v2.context/CALL_DATA_OFFSET already set");
    } else {
      filled.set(123);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.put(
          (byte) 0);
    }
    deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallDataSize(final Bytes b) {
    if (filled.get(124)) {
      throw new IllegalStateException("hub_v2.context/CALL_DATA_SIZE already set");
    } else {
      filled.set(124);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.put(
          (byte) 0);
    }
    deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallStackDepth(final Bytes b) {
    if (filled.get(125)) {
      throw new IllegalStateException("hub_v2.context/CALL_STACK_DEPTH already set");
    } else {
      filled.set(125);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce.put((byte) 0);
    }
    deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallValue(final Bytes b) {
    if (filled.get(126)) {
      throw new IllegalStateException("hub_v2.context/CALL_VALUE already set");
    } else {
      filled.set(126);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      nonceXorCallValueXorMxpSize2HiXorStackItemStamp1XorRefundAmount.put((byte) 0);
    }
    nonceXorCallValueXorMxpSize2HiXorStackItemStamp1XorRefundAmount.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallerAddressHi(final Bytes b) {
    if (filled.get(120)) {
      throw new IllegalStateException("hub_v2.context/CALLER_ADDRESS_HI already set");
    } else {
      filled.set(120);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
          (byte) 0);
    }
    codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallerAddressLo(final Bytes b) {
    if (filled.get(121)) {
      throw new IllegalStateException("hub_v2.context/CALLER_ADDRESS_LO already set");
    } else {
      filled.set(121);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
          (byte) 0);
    }
    codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallerContextNumber(final Bytes b) {
    if (filled.get(122)) {
      throw new IllegalStateException("hub_v2.account/NONCE already set");
    } else {
      filled.set(122);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
          .put((byte) 0);
    }
    codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountNonceNew(final Bytes b) {
    if (filled.get(123)) {
      throw new IllegalStateException("hub_v2.account/NONCE_NEW already set");
    } else {
      filled.set(123);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      nonceNewXorContextNumberXorMxpOffset1LoXorStackItemStamp1XorNonce.put((byte) 0);
    }
    nonceNewXorContextNumberXorMxpOffset1LoXorStackItemStamp1XorNonce.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrDepAddrHi(final Bytes b) {
    if (filled.get(124)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR___DEP_ADDR_HI already set");
    } else {
      filled.set(124);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrHiXorIsStaticXorMxpOffset2HiXorStackItemStamp2XorToAddressHi.put((byte) 0);
    }
    rlpaddrDepAddrHiXorIsStaticXorMxpOffset2HiXorStackItemStamp2XorToAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrDepAddrLo(final Bytes b) {
    if (filled.get(125)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR___DEP_ADDR_LO already set");
    } else {
      filled.set(125);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrLoXorReturnerContextNumberXorMxpOffset2LoXorStackItemStamp3XorToAddressLo.put(
          (byte) 0);
    }
    rlpaddrDepAddrLoXorReturnerContextNumberXorMxpOffset2LoXorStackItemStamp3XorToAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrFlag(final Boolean b) {
    if (filled.get(65)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR___FLAG already set");
    } else {
      filled.set(65);
    }

    rlpaddrFlagXorCreateEmptyInitCodeWontRevertXorInvprex.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountRlpaddrKecHi(final Bytes b) {
    if (filled.get(126)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR___KEC_HI already set");
    } else {
      filled.set(126);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecHiXorReturnerIsPrecompileXorMxpSize1HiXorStackItemStamp4XorValue.put((byte) 0);
    }
    rlpaddrKecHiXorReturnerIsPrecompileXorMxpSize1HiXorStackItemStamp4XorValue.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrKecLo(final Bytes b) {
    if (filled.get(127)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR___KEC_LO already set");
    } else {
      filled.set(127);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecLoXorReturnAtOffsetXorMxpSize1LoXorStackItemValueHi1.put((byte) 0);
    }
    nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextIsRoot(final Boolean b) {
    if (filled.get(47)) {
      throw new IllegalStateException("hub_v2.context/IS_ROOT already set");
    } else {
      filled.set(47);
    }

    deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pContextIsStatic(final Boolean b) {
    if (filled.get(48)) {
      throw new IllegalStateException("hub_v2.context/IS_STATIC already set");
    } else {
      filled.set(48);
    }

    deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pContextReturnAtCapacity(final Bytes b) {
    if (filled.get(129)) {
      throw new IllegalStateException("hub_v2.context/RETURN_AT_CAPACITY already set");
    } else {
      filled.set(129);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo.put((byte) 0);
    }
    rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextReturnAtOffset(final Bytes b) {
    if (filled.get(130)) {
      throw new IllegalStateException("hub_v2.context/RETURN_AT_OFFSET already set");
    } else {
      filled.set(130);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecHiXorReturnAtOffsetXorOobData2XorStackItemValueHi1XorValue.put((byte) 0);
    }
    rlpaddrKecHiXorReturnAtOffsetXorOobData2XorStackItemValueHi1XorValue.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextReturnDataOffset(final Bytes b) {
    if (filled.get(131)) {
      throw new IllegalStateException("hub_v2.context/RETURN_DATA_OFFSET already set");
    } else {
      filled.set(131);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecLoXorReturnDataOffsetXorOobData3XorStackItemValueHi2.put((byte) 0);
    }
    rlpaddrKecLoXorReturnDataOffsetXorOobData3XorStackItemValueHi2.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextReturnDataSize(final Bytes b) {
    if (filled.get(132)) {
      throw new IllegalStateException("hub_v2.context/RETURN_DATA_SIZE already set");
    } else {
      filled.set(132);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrRecipeXorReturnDataSizeXorOobData4XorStackItemValueHi3.put((byte) 0);
    }
    rlpaddrRecipeXorReturnDataSizeXorOobData4XorStackItemValueHi3.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextReturnerContextNumber(final Bytes b) {
    if (filled.get(128)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR___RECIPE already set");
    } else {
      filled.set(128);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.put(
          (byte) 0);
    }
    rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountRlpaddrSaltHi(final Bytes b) {
    if (filled.get(129)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR___SALT_HI already set");
    } else {
      filled.set(129);
    }

    deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountRlpaddrSaltLo(final Bytes b) {
    if (filled.get(130)) {
      throw new IllegalStateException("hub_v2.account/RLPADDR___SALT_LO already set");
    } else {
      filled.set(130);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrSaltLoXorReturnDataSizeXorMxpWordsXorStackItemValueHi4.put((byte) 0);
    }
    rlpaddrSaltLoXorReturnDataSizeXorMxpWordsXorStackItemValueHi4.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountTrmFlag(final Boolean b) {
    if (filled.get(66)) {
      throw new IllegalStateException("hub_v2.account/TRM___FLAG already set");
    } else {
      filled.set(66);
    }

    trmFlagXorCreateExceptionXorJumpx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountTrmRawAddrHi(final Bytes b) {
    if (filled.get(131)) {
      throw new IllegalStateException("hub_v2.account/TRM___RAW_ADDR_HI already set");
    } else {
      filled.set(131);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      trmRawAddrHiXorOobData1XorStackItemValueLo1.put((byte) 0);
    }
    trmRawAddrHiXorOobData1XorStackItemValueLo1.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pAccountWarm(final Boolean b) {
    if (filled.get(67)) {
      throw new IllegalStateException("hub_v2.account/WARM already set");
    } else {
      filled.set(67);
    }

    warmXorCreateFailureConditionWillRevertXorJumpDestinationVettingRequired.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pAccountWarmNew(final Boolean b) {
    if (filled.get(68)) {
      throw new IllegalStateException("hub_v2.account/WARM_NEW already set");
    } else {
      filled.set(68);
    }

    warmNewXorCreateFailureConditionWontRevertXorJumpFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pContextAccountAddressHi(final Bytes b) {
    if (filled.get(109)) {
      throw new IllegalStateException("hub_v2.context/ACCOUNT_ADDRESS_HI already set");
    } else {
      filled.set(109);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.put((byte) 0);
    }
    addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextAccountAddressLo(final Bytes b) {
    if (filled.get(110)) {
      throw new IllegalStateException("hub_v2.context/ACCOUNT_ADDRESS_LO already set");
    } else {
      filled.set(110);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.put((byte) 0);
    }
    addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextAccountDeploymentNumber(final Bytes b) {
    if (filled.get(111)) {
      throw new IllegalStateException("hub_v2.context/ACCOUNT_DEPLOYMENT_NUMBER already set");
    } else {
      filled.set(111);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoSizeXorDeploymentNumberXorCoinbaseAddressHi
          .put((byte) 0);
    }
    balanceXorAccountDeploymentNumberXorExpData2XorHashInfoSizeXorDeploymentNumberXorCoinbaseAddressHi
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextByteCodeAddressHi(final Bytes b) {
    if (filled.get(112)) {
      throw new IllegalStateException("hub_v2.context/BYTE_CODE_ADDRESS_HI already set");
    } else {
      filled.set(112);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHeightXorStorageKeyHiXorCoinbaseAddressLo.put(
          (byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHeightXorStorageKeyHiXorCoinbaseAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscCcsrFlag(final Boolean b) {
    if (filled.get(47)) {
      throw new IllegalStateException("hub_v2.misc/CCSR_FLAG already set");
    } else {
      filled.set(47);
    }

    deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscExpData1(final Bytes b) {
    if (filled.get(113)) {
      throw new IllegalStateException("hub_v2.context/BYTE_CODE_ADDRESS_LO already set");
    } else {
      filled.set(113);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.put(
          (byte) 0);
    }
    codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextByteCodeDeploymentNumber(final Bytes b) {
    if (filled.get(114)) {
      throw new IllegalStateException("hub_v2.context/BYTE_CODE_DEPLOYMENT_NUMBER already set");
    } else {
      filled.set(114);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
          .put((byte) 0);
    }
    balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextByteCodeDeploymentStatus(final Bytes b) {
    if (filled.get(115)) {
      throw new IllegalStateException("hub_v2.context/BYTE_CODE_DEPLOYMENT_STATUS already set");
    } else {
      filled.set(115);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
          .put((byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallDataOffset(final Bytes b) {
    if (filled.get(119)) {
      throw new IllegalStateException("hub_v2.context/CALL_DATA_OFFSET already set");
    } else {
      filled.set(119);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberInftyXorCallDataOffsetXorMmuTgtOffsetLoXorStackItemHeight1XorValOrigLoXorInitialBalance
          .put((byte) 0);
    }
    deploymentNumberInftyXorCallDataOffsetXorMmuTgtOffsetLoXorStackItemHeight1XorValOrigLoXorInitialBalance
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallDataSize(final Bytes b) {
    if (filled.get(120)) {
      throw new IllegalStateException("hub_v2.context/CALL_DATA_SIZE already set");
    } else {
      filled.set(120);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      depNumXorCallDataSizeXorMxpGasMxpXorStackItemHeight2XorInitCodeSize.put((byte) 0);
    }
    depNumXorCallDataSizeXorMxpGasMxpXorStackItemHeight2XorInitCodeSize.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallStackDepth(final Bytes b) {
    if (filled.get(121)) {
      throw new IllegalStateException("hub_v2.context/CALL_STACK_DEPTH already set");
    } else {
      filled.set(121);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      depNumNewXorCallStackDepthXorMxpInstXorStackItemHeight3XorInitGas.put((byte) 0);
    }
    depNumNewXorCallStackDepthXorMxpInstXorStackItemHeight3XorInitGas.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallValue(final Bytes b) {
    if (filled.get(122)) {
      throw new IllegalStateException("hub_v2.context/CALL_VALUE already set");
    } else {
      filled.set(122);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      nonceXorCallValueXorMxpOffset1HiXorStackItemHeight4XorLeftoverGas.put((byte) 0);
    }
    nonceXorCallValueXorMxpOffset1HiXorStackItemHeight4XorLeftoverGas.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallerAddressHi(final Bytes b) {
    if (filled.get(116)) {
      throw new IllegalStateException("hub_v2.context/CALLER_ADDRESS_HI already set");
    } else {
      filled.set(116);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
          .put((byte) 0);
    }
    codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallerAddressLo(final Bytes b) {
    if (filled.get(117)) {
      throw new IllegalStateException("hub_v2.context/CALLER_ADDRESS_LO already set");
    } else {
      filled.set(117);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi
          .put((byte) 0);
    }
    codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextCallerContextNumber(final Bytes b) {
    if (filled.get(118)) {
      throw new IllegalStateException("hub_v2.context/CALLER_CONTEXT_NUMBER already set");
    } else {
      filled.set(118);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeNewXorCallerContextNumberXorMmuSrcOffsetLoXorPushValueLoXorValOrigHiXorGasRefundCounterFinal
          .put((byte) 0);
    }
    codeSizeNewXorCallerContextNumberXorMmuSrcOffsetLoXorPushValueLoXorValOrigHiXorGasRefundCounterFinal
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextContextNumber(final Bytes b) {
    if (filled.get(123)) {
      throw new IllegalStateException("hub_v2.context/CONTEXT_NUMBER already set");
    } else {
      filled.set(123);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      nonceNewXorContextNumberXorMxpOffset1LoXorStackItemStamp1XorNonce.put((byte) 0);
    }
    nonceNewXorContextNumberXorMxpOffset1LoXorStackItemStamp1XorNonce.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextIsStatic(final Bytes b) {
    if (filled.get(124)) {
      throw new IllegalStateException("hub_v2.context/IS_STATIC already set");
    } else {
      filled.set(124);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrHiXorIsStaticXorMxpOffset2HiXorStackItemStamp2XorToAddressHi.put((byte) 0);
    }
    rlpaddrDepAddrHiXorIsStaticXorMxpOffset2HiXorStackItemStamp2XorToAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextReturnAtOffset(final Bytes b) {
    if (filled.get(127)) {
      throw new IllegalStateException("hub_v2.context/RETURN_AT_OFFSET already set");
    } else {
      filled.set(127);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecLoXorReturnAtOffsetXorMxpSize1LoXorStackItemValueHi1.put((byte) 0);
    }
    rlpaddrKecLoXorReturnAtOffsetXorMxpSize1LoXorStackItemValueHi1.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextReturnAtSize(final Bytes b) {
    if (filled.get(128)) {
      throw new IllegalStateException("hub_v2.context/RETURN_AT_SIZE already set");
    } else {
      filled.set(128);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrRecipeXorReturnAtSizeXorMxpSize2HiXorStackItemValueHi2.put((byte) 0);
    }
    rlpaddrRecipeXorReturnAtSizeXorMxpSize2HiXorStackItemValueHi2.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextReturnDataOffset(final Bytes b) {
    if (filled.get(129)) {
      throw new IllegalStateException("hub_v2.context/RETURN_DATA_OFFSET already set");
    } else {
      filled.set(129);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrSaltHiXorReturnDataOffsetXorMxpSize2LoXorStackItemValueHi3.put((byte) 0);
    }
    rlpaddrSaltHiXorReturnDataOffsetXorMxpSize2LoXorStackItemValueHi3.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextReturnDataSize(final Bytes b) {
    if (filled.get(130)) {
      throw new IllegalStateException("hub_v2.context/RETURN_DATA_SIZE already set");
    } else {
      filled.set(130);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrSaltLoXorReturnDataSizeXorMxpWordsXorStackItemValueHi4.put((byte) 0);
    }
    rlpaddrSaltLoXorReturnDataSizeXorMxpWordsXorStackItemValueHi4.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pContextReturnerContextNumber(final Bytes b) {
    if (filled.get(125)) {
      throw new IllegalStateException("hub_v2.context/RETURNER_CONTEXT_NUMBER already set");
    } else {
      filled.set(125);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrLoXorReturnerContextNumberXorMxpOffset2LoXorStackItemStamp3XorToAddressLo.put(
          (byte) 0);
    }
    rlpaddrDepAddrLoXorReturnerContextNumberXorMxpOffset2LoXorStackItemStamp3XorToAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextReturnerIsPrecompile(final Bytes b) {
    if (filled.get(126)) {
      throw new IllegalStateException("hub_v2.context/RETURNER_IS_PRECOMPILE already set");
    } else {
      filled.set(126);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecHiXorReturnerIsPrecompileXorMxpSize1HiXorStackItemStamp4XorValue.put((byte) 0);
    }
    rlpaddrKecHiXorReturnerIsPrecompileXorMxpSize1HiXorStackItemStamp4XorValue.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pContextUpdate(final Boolean b) {
    if (filled.get(48)) {
      throw new IllegalStateException("hub_v2.context/UPDATE already set");
    } else {
      filled.set(48);
    }

    deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousCcrsStamp(final Bytes b) {
    if (filled.get(109)) {
      throw new IllegalStateException("hub_v2.miscellaneous/CCRS_STAMP already set");
    } else {
      filled.set(109);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.put((byte) 0);
    }
    addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousCcsrFlag(final Boolean b) {
    if (filled.get(48)) {
      throw new IllegalStateException("hub_v2.miscellaneous/CCSR_FLAG already set");
    } else {
      filled.set(48);
    }

    deploymentStatusInftyXorUpdateXorCcsrFlagXorBlake2FXorAccFlagXorValCurrChangesXorIsDeployment
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousExpData1(final Bytes b) {
    if (filled.get(110)) {
      throw new IllegalStateException("hub_v2.miscellaneous/EXP___DATA_1 already set");
    } else {
      filled.set(110);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.put((byte) 0);
    }
    addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousExpData2(final Bytes b) {
    if (filled.get(111)) {
      throw new IllegalStateException("hub_v2.miscellaneous/EXP___DATA_2 already set");
    } else {
      filled.set(111);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoSizeXorDeploymentNumberXorCoinbaseAddressHi
          .put((byte) 0);
    }
    balanceXorAccountDeploymentNumberXorExpData2XorHashInfoSizeXorDeploymentNumberXorCoinbaseAddressHi
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousExpData3(final Bytes b) {
    if (filled.get(112)) {
      throw new IllegalStateException("hub_v2.miscellaneous/EXP___DATA_3 already set");
    } else {
      filled.set(112);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHeightXorStorageKeyHiXorCoinbaseAddressLo.put(
          (byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHeightXorStorageKeyHiXorCoinbaseAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousExpData4(final Bytes b) {
    if (filled.get(113)) {
      throw new IllegalStateException("hub_v2.miscellaneous/EXP___DATA_4 already set");
    } else {
      filled.set(113);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.put(
          (byte) 0);
    }
    codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousExpData5(final Bytes b) {
    if (filled.get(114)) {
      throw new IllegalStateException("hub_v2.miscellaneous/EXP___DATA_5 already set");
    } else {
      filled.set(114);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiNewXorByteCodeDeploymentNumberXorExpData5XorHeightOverXorValCurrHiXorFromAddressLo
          .put((byte) 0);
    }
    codeHashHiNewXorByteCodeDeploymentNumberXorExpData5XorHeightOverXorValCurrHiXorFromAddressLo
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousExpFlag(final Boolean b) {
    if (filled.get(49)) {
      throw new IllegalStateException("hub_v2.miscellaneous/EXP___FLAG already set");
    } else {
      filled.set(49);
    }

    depStatusXorExpFlagXorCallAbortXorAddFlagXorValCurrIsOrigXorIsEip1559.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousExpInst(final long b) {
    if (filled.get(98)) {
      throw new IllegalStateException("hub_v2.miscellaneous/EXP___INST already set");
    } else {
      filled.set(98);
    }

    expInstXorPrcCalleeGas.putLong(b);

    return this;
  }

  public Trace pMiscellaneousMmuAuxId(final long b) {
    if (filled.get(99)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___AUX_ID already set");
    } else {
      filled.set(99);
    }

    mmuAuxIdXorPrcCallerGas.putLong(b);

    return this;
  }

  public Trace pMiscellaneousMmuExoSum(final long b) {
    if (filled.get(100)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___EXO_SUM already set");
    } else {
      filled.set(100);
    }

    mmuExoSumXorPrcCdo.putLong(b);

    return this;
  }

  public Trace pMiscellaneousMmuFlag(final Boolean b) {
    if (filled.get(50)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___FLAG already set");
    } else {
      filled.set(50);
    }

    deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousMmuInst(final long b) {
    if (filled.get(101)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___INST already set");
    } else {
      filled.set(101);
    }

    mmuInstXorPrcCds.putLong(b);

    return this;
  }

  public Trace pMiscellaneousMmuLimb1(final Bytes b) {
    if (filled.get(115)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___LIMB_1 already set");
    } else {
      filled.set(115);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoXorByteCodeDeploymentStatusXorMmuLimb1XorHeightUnderXorValCurrLoXorGasLimit.put(
          (byte) 0);
    }
    codeHashLoXorByteCodeDeploymentStatusXorMmuLimb1XorHeightUnderXorValCurrLoXorGasLimit.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMmuLimb2(final Bytes b) {
    if (filled.get(116)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___LIMB_2 already set");
    } else {
      filled.set(116);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoNewXorCallerAddressHiXorMmuLimb2XorInstXorValNextHiXorGasPrice.put((byte) 0);
    }
    codeHashLoNewXorCallerAddressHiXorMmuLimb2XorInstXorValNextHiXorGasPrice.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMmuPhase(final long b) {
    if (filled.get(102)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___PHASE already set");
    } else {
      filled.set(102);
    }

    mmuPhaseXorPrcRac.putLong(b);

    return this;
  }

  public Trace pMiscellaneousMmuRefOffset(final long b) {
    if (filled.get(103)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___REF_OFFSET already set");
    } else {
      filled.set(103);
    }

    mmuRefOffsetXorPrcRao.putLong(b);

    return this;
  }

  public Trace pMiscellaneousMmuRefSize(final long b) {
    if (filled.get(104)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___REF_SIZE already set");
    } else {
      filled.set(104);
    }

    mmuRefSizeXorPrcReturnGas.putLong(b);

    return this;
  }

  public Trace pMiscellaneousMmuSize(final long b) {
    if (filled.get(105)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___SIZE already set");
    } else {
      filled.set(105);
    }

    mmuSize.putLong(b);

    return this;
  }

  public Trace pMiscellaneousMmuSrcId(final long b) {
    if (filled.get(106)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___SRC_ID already set");
    } else {
      filled.set(106);
    }

    mmuSrcId.putLong(b);

    return this;
  }

  public Trace pMiscellaneousMmuSrcOffsetHi(final Bytes b) {
    if (filled.get(117)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___SRC_OFFSET_HI already set");
    } else {
      filled.set(117);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeXorCallerAddressLoXorMmuSrcOffsetHiXorPushValueHiXorValNextLoXorGasRefundAmount.put(
          (byte) 0);
    }
    codeSizeXorCallerAddressLoXorMmuSrcOffsetHiXorPushValueHiXorValNextLoXorGasRefundAmount.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMmuSrcOffsetLo(final Bytes b) {
    if (filled.get(118)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___SRC_OFFSET_LO already set");
    } else {
      filled.set(118);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeNewXorCallerContextNumberXorMmuSrcOffsetLoXorPushValueLoXorValOrigHiXorGasRefundCounterFinal
          .put((byte) 0);
    }
    codeSizeNewXorCallerContextNumberXorMmuSrcOffsetLoXorPushValueLoXorValOrigHiXorGasRefundCounterFinal
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMmuSuccessBit(final Boolean b) {
    if (filled.get(51)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___SUCCESS_BIT already set");
    } else {
      filled.set(51);
    }

    existsXorMmuSuccessBitXorCallExceptionXorBtcFlagXorValNextIsCurrXorRequiresEvmExecution.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousMmuTgtId(final long b) {
    if (filled.get(107)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___TGT_ID already set");
    } else {
      filled.set(107);
    }

    mmuTgtId.putLong(b);

    return this;
  }

  public Trace pMiscMmuTgtOffsetLo(final Bytes b) {
    if (filled.get(111)) {
      throw new IllegalStateException("hub_v2.misc/MMU_TGT_OFFSET_LO already set");
    } else {
      filled.set(111);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      mmuTgtOffsetLo.put((byte) 0);
    }
    mmuTgtOffsetLo.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscMxpDeploys(final Boolean b) {
    if (filled.get(51)) {
      throw new IllegalStateException("hub_v2.misc/MXP_DEPLOYS already set");
    } else {
      filled.set(51);
    }

    existsNewXorMxpDeploysXorCallPrcFailureXorCallFlagXorValNextIsOrigXorStatusCode.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscMxpFlag(final Boolean b) {
    if (filled.get(52)) {
      throw new IllegalStateException("hub_v2.misc/MXP_FLAG already set");
    } else {
      filled.set(52);
    }

    hasCodeXorMxpFlagXorCallPrcSuccessCallerWillRevertXorConFlagXorValNextIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscMxpGasMxp(final Bytes b) {
    if (filled.get(118)) {
      throw new IllegalStateException("hub_v2.misc/MXP_GAS_MXP already set");
    } else {
      filled.set(118);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo
          .put((byte) 0);
    }
    codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscMxpInst(final Bytes b) {
    if (filled.get(119)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MMU___TGT_OFFSET_LO already set");
    } else {
      filled.set(119);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
          (byte) 0);
    }
    codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpDeploys(final Boolean b) {
    if (filled.get(52)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___DEPLOYS already set");
    } else {
      filled.set(52);
    }

    existsNewXorMxpDeploysXorCallExceptionXorCallFlagXorValNextIsOrig.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousMxpFlag(final Boolean b) {
    if (filled.get(53)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___FLAG already set");
    } else {
      filled.set(53);
    }

    hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWontRevertXorCopyFlagXorValOrigIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousMxpGasMxp(final Bytes b) {
    if (filled.get(120)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___GAS_MXP already set");
    } else {
      filled.set(120);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
          (byte) 0);
    }
    codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpInst(final Bytes b) {
    if (filled.get(121)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___INST already set");
    } else {
      filled.set(121);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
          (byte) 0);
    }
    codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpMxpx(final Boolean b) {
    if (filled.get(54)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___MXPX already set");
    } else {
      filled.set(54);
    }

    hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWillRevertXorCopyFlagXorValOrigIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousMxpOffset1Hi(final Bytes b) {
    if (filled.get(122)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___OFFSET_1_HI already set");
    } else {
      filled.set(122);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
          .put((byte) 0);
    }
    codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpOffset1Lo(final Bytes b) {
    if (filled.get(123)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___OFFSET_1_LO already set");
    } else {
      filled.set(123);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.put(
          (byte) 0);
    }
    deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpOffset2Hi(final Bytes b) {
    if (filled.get(124)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___OFFSET_2_HI already set");
    } else {
      filled.set(124);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.put(
          (byte) 0);
    }
    deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpOffset2Lo(final Bytes b) {
    if (filled.get(125)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___OFFSET_2_LO already set");
    } else {
      filled.set(125);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrLoXorReturnerContextNumberXorMxpOffset2LoXorStackItemStamp3XorToAddressLo.put(
          (byte) 0);
    }
    deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpSize1Hi(final Bytes b) {
    if (filled.get(126)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___SIZE_1_HI already set");
    } else {
      filled.set(126);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecHiXorReturnerIsPrecompileXorMxpSize1HiXorStackItemStamp4XorValue.put((byte) 0);
    }
    rlpaddrKecHiXorReturnerIsPrecompileXorMxpSize1HiXorStackItemStamp4XorValue.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpSize1Lo(final Bytes b) {
    if (filled.get(127)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___SIZE_1_LO already set");
    } else {
      filled.set(127);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecLoXorReturnAtOffsetXorMxpSize1LoXorStackItemValueHi1.put((byte) 0);
    }
    nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpSize2Hi(final Bytes b) {
    if (filled.get(128)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___SIZE_2_HI already set");
    } else {
      filled.set(128);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.put(
          (byte) 0);
    }
    rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpSize2Lo(final Bytes b) {
    if (filled.get(129)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___SIZE_2_LO already set");
    } else {
      filled.set(129);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrSaltHiXorReturnDataOffsetXorMxpSize2LoXorStackItemValueHi3.put((byte) 0);
    }
    rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousMxpWords(final Bytes b) {
    if (filled.get(130)) {
      throw new IllegalStateException("hub_v2.miscellaneous/MXP___WORDS already set");
    } else {
      filled.set(130);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrSaltLoXorReturnDataSizeXorMxpWordsXorStackItemValueHi4.put((byte) 0);
    }
    rlpaddrSaltLoXorReturnDataSizeXorMxpWordsXorStackItemValueHi4.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousOobData1(final Bytes b) {
    if (filled.get(131)) {
      throw new IllegalStateException("hub_v2.miscellaneous/OOB____DATA_1 already set");
    } else {
      filled.set(131);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      trmRawAddrHiXorOobData1XorStackItemValueLo1.put((byte) 0);
    }
    trmRawAddrHiXorOobData1XorStackItemValueLo1.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousOobData2(final Bytes b) {
    if (filled.get(132)) {
      throw new IllegalStateException("hub_v2.miscellaneous/OOB____DATA_2 already set");
    } else {
      filled.set(132);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      oobData2XorStackItemValueLo2.put((byte) 0);
    }
    oobData2XorStackItemValueLo2.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousOobData3(final Bytes b) {
    if (filled.get(133)) {
      throw new IllegalStateException("hub_v2.miscellaneous/OOB____DATA_3 already set");
    } else {
      filled.set(133);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      oobData3XorStackItemValueLo3.put((byte) 0);
    }
    oobData3XorStackItemValueLo3.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousOobData4(final Bytes b) {
    if (filled.get(134)) {
      throw new IllegalStateException("hub_v2.miscellaneous/OOB____DATA_4 already set");
    } else {
      filled.set(134);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      oobData4XorStackItemValueLo4.put((byte) 0);
    }
    oobData4XorStackItemValueLo4.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousOobData5(final Bytes b) {
    if (filled.get(135)) {
      throw new IllegalStateException("hub_v2.miscellaneous/OOB____DATA_5 already set");
    } else {
      filled.set(135);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      oobData5XorStaticGas.put((byte) 0);
    }
    oobData5XorStaticGas.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousOobData6(final Bytes b) {
    if (filled.get(136)) {
      throw new IllegalStateException("hub_v2.miscellaneous/OOB____DATA_6 already set");
    } else {
      filled.set(136);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      oobData6.put((byte) 0);
    }
    oobData6.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousOobData7(final Bytes b) {
    if (filled.get(137)) {
      throw new IllegalStateException("hub_v2.miscellaneous/OOB____DATA_7 already set");
    } else {
      filled.set(137);
    }

    isPrecompileXorOobFlagXorCallSmcFailureCallerWillRevertXorCreateFlagXorWarm.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousOobData8(final Bytes b) {
    if (filled.get(138)) {
      throw new IllegalStateException("hub_v2.miscellaneous/OOB____DATA_8 already set");
    } else {
      filled.set(138);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      oobData8.put((byte) 0);
    }
    oobData8.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousOobFlag(final Boolean b) {
    if (filled.get(55)) {
      throw new IllegalStateException("hub_v2.miscellaneous/OOB___FLAG already set");
    } else {
      filled.set(55);
    }

    isBlake2FXorOobFlagXorCallPrcSuccessCallerWontRevertXorCreateFlagXorWarm.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousOobInst(final long b) {
    if (filled.get(108)) {
      throw new IllegalStateException("hub_v2.miscellaneous/OOB___INST already set");
    } else {
      filled.set(108);
    }

    oobInst.putLong(b);

    return this;
  }

  public Trace pMiscStpExists(final Boolean b) {
    if (filled.get(55)) {
      throw new IllegalStateException("hub_v2.misc/STP_EXISTS already set");
    } else {
      filled.set(55);
    }

    markedForSelfdestructXorStpExistsXorCallSmcFailureCallerWontRevertXorDecFlag1XorWarmNew.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscStpFlag(final Boolean b) {
    if (filled.get(56)) {
      throw new IllegalStateException("hub_v2.miscellaneous/STP___EXISTS already set");
    } else {
      filled.set(56);
    }

    markedForSelfdestructNewXorStpFlagXorCallSmcSuccessCallerWillRevertXorDecFlag2.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousStpFlag(final Boolean b) {
    if (filled.get(57)) {
      throw new IllegalStateException("hub_v2.miscellaneous/STP___FLAG already set");
    } else {
      filled.set(57);
    }

    isEcmulXorStpFlagXorCallSmcFailureCallerWontRevertXorDecodedFlag2.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousStpGasHi(final Bytes b) {
    if (filled.get(139)) {
      throw new IllegalStateException("hub_v2.miscellaneous/STP___GAS_HI already set");
    } else {
      filled.set(139);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      stpGasHi.put((byte) 0);
    }
    stpGasHi.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousStpGasLo(final Bytes b) {
    if (filled.get(140)) {
      throw new IllegalStateException("hub_v2.miscellaneous/STP___GAS_LO already set");
    } else {
      filled.set(140);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      stpGasLo.put((byte) 0);
    }
    stpGasLo.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousStpGasPaidOutOfPocket(final Bytes b) {
    if (filled.get(141)) {
      throw new IllegalStateException(
          "hub_v2.miscellaneous/STP___GAS_PAID_OUT_OF_POCKET already set");
    } else {
      filled.set(141);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      stpGasPaidOutOfPocket.put((byte) 0);
    }
    stpGasPaidOutOfPocket.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousStpGasStipend(final Bytes b) {
    if (filled.get(142)) {
      throw new IllegalStateException("hub_v2.miscellaneous/STP___GAS_STIPEND already set");
    } else {
      filled.set(142);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      stpGasStipend.put((byte) 0);
    }
    stpGasStipend.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousStpGasUpfrontGasCost(final Bytes b) {
    if (filled.get(143)) {
      throw new IllegalStateException(
          "hub_v2.miscellaneous/STP___GAS_UPFRONT_GAS_COST already set");
    } else {
      filled.set(143);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      stpGasUpfrontGasCost.put((byte) 0);
    }
    stpGasUpfrontGasCost.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousStpInst(final Bytes b) {
    if (filled.get(144)) {
      throw new IllegalStateException("hub_v2.miscellaneous/STP___INST already set");
    } else {
      filled.set(144);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      stpInst.put((byte) 0);
    }
    stpInst.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousStpOogx(final Boolean b) {
    if (filled.get(58)) {
      throw new IllegalStateException("hub_v2.miscellaneous/STP___OOGX already set");
    } else {
      filled.set(58);
    }

    isEcpairingXorStpOogxXorCallSmcSuccessCallerWillRevertXorDecodedFlag3.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pMiscellaneousStpValHi(final Bytes b) {
    if (filled.get(145)) {
      throw new IllegalStateException("hub_v2.miscellaneous/STP___VAL_HI already set");
    } else {
      filled.set(145);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      stpValHi.put((byte) 0);
    }
    stpValHi.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousStpValLo(final Bytes b) {
    if (filled.get(146)) {
      throw new IllegalStateException("hub_v2.miscellaneous/STP___VAL_LO already set");
    } else {
      filled.set(146);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      stpValLo.put((byte) 0);
    }
    stpValLo.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pMiscellaneousStpWarmth(final Boolean b) {
    if (filled.get(59)) {
      throw new IllegalStateException("hub_v2.miscellaneous/STP___WARMTH already set");
    } else {
      filled.set(59);
    }

    isEcrecoverXorStpWarmthXorCallSmcSuccessCallerWontRevertXorDecodedFlag4.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioBlake2F(final Boolean b) {
    if (filled.get(48)) {
      throw new IllegalStateException("hub_v2.scenario/BLAKE2f already set");
    } else {
      filled.set(48);
    }

    deploymentStatusInftyXorUpdateXorCcsrFlagXorBlake2FXorAccFlagXorValCurrChangesXorIsDeployment
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallAbort(final Boolean b) {
    if (filled.get(49)) {
      throw new IllegalStateException("hub_v2.scenario/CALL_ABORT already set");
    } else {
      filled.set(49);
    }

    deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallEoaSuccessCallerWillRevert(final Boolean b) {
    if (filled.get(48)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CALL_EOA_SUCCESS_CALLER_WILL_REVERT already set");
    } else {
      filled.set(50);
    }

    deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallEoaSuccessCallerWontRevert(final Boolean b) {
    if (filled.get(49)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CALL_EOA_SUCCESS_CALLER_WONT_REVERT already set");
    } else {
      filled.set(51);
    }

    deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallException(final Boolean b) {
    if (filled.get(52)) {
      throw new IllegalStateException("hub_v2.scenario/CALL_EXCEPTION already set");
    } else {
      filled.set(52);
    }

    existsXorMmuSuccessBitXorCallExceptionXorBtcFlagXorValNextIsCurrXorRequiresEvmExecution.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallPrcFailure(final Boolean b) {
    if (filled.get(53)) {
      throw new IllegalStateException("hub_v2.scenario/CALL_PRC_FAILURE already set");
    } else {
      filled.set(53);
    }

    existsNewXorMxpDeploysXorCallPrcFailureXorCallFlagXorValNextIsOrigXorStatusCode.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallPrcSuccessCallerWillRevert(final Boolean b) {
    if (filled.get(52)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CALL_PRC_SUCCESS_CALLER_WILL_REVERT already set");
    } else {
      filled.set(54);
    }

    hasCodeXorMxpFlagXorCallPrcSuccessCallerWillRevertXorConFlagXorValNextIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallPrcSuccessCallerWontRevert(final Boolean b) {
    if (filled.get(53)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CALL_PRC_SUCCESS_CALLER_WONT_REVERT already set");
    } else {
      filled.set(55);
    }

    hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWontRevertXorCopyFlagXorValOrigIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallSmcFailureCallerWillRevert(final Boolean b) {
    if (filled.get(54)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CALL_SMC_FAILURE_CALLER_WILL_REVERT already set");
    } else {
      filled.set(56);
    }

    isPrecompileXorOobFlagXorCallSmcFailureCallerWillRevertXorCreateFlagXorWarm.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallSmcFailureCallerWontRevert(final Boolean b) {
    if (filled.get(55)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CALL_SMC_FAILURE_CALLER_WONT_REVERT already set");
    } else {
      filled.set(57);
    }

    markedForSelfdestructXorStpExistsXorCallSmcFailureCallerWontRevertXorDecFlag1XorWarmNew.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallSmcSuccessCallerWillRevert(final Boolean b) {
    if (filled.get(56)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CALL_SMC_SUCCESS_CALLER_WILL_REVERT already set");
    } else {
      filled.set(58);
    }

    markedForSelfdestructNewXorStpFlagXorCallSmcSuccessCallerWillRevertXorDecFlag2.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCallSmcSuccessCallerWontRevert(final Boolean b) {
    if (filled.get(57)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CALL_SMC_SUCCESS_CALLER_WONT_REVERT already set");
    } else {
      filled.set(59);
    }

    isEcrecoverXorStpWarmthXorCallSmcSuccessCallerWontRevertXorDecodedFlag4.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCodedeposit(final Boolean b) {
    if (filled.get(60)) {
      throw new IllegalStateException("hub_v2.scenario/CODEDEPOSIT already set");
    } else {
      filled.set(60);
    }

    isIdentityXorCodedepositXorDupFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCodedepositInvalidCodePrefix(final Boolean b) {
    if (filled.get(61)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CODEDEPOSIT_INVALID_CODE_PREFIX already set");
    } else {
      filled.set(61);
    }

    isModexpXorCodedepositInvalidCodePrefixXorExtFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCodedepositValidCodePrefix(final Boolean b) {
    if (filled.get(62)) {
      throw new IllegalStateException("hub_v2.scenario/CODEDEPOSIT_VALID_CODE_PREFIX already set");
    } else {
      filled.set(62);
    }

    isPrecompileXorCodedepositValidCodePrefixXorHaltFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCreateAbort(final Boolean b) {
    if (filled.get(63)) {
      throw new IllegalStateException("hub_v2.scenario/CREATE_ABORT already set");
    } else {
      filled.set(63);
    }

    isRipemd160XorCreateAbortXorHashInfoFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCreateEmptyInitCodeWillRevert(final Boolean b) {
    if (filled.get(59)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CREATE_EMPTY_INIT_CODE_WILL_REVERT already set");
    } else {
      filled.set(64);
    }

    isSha2256XorCreateEmptyInitCodeWillRevertXorInvalidFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCreateEmptyInitCodeWontRevert(final Boolean b) {
    if (filled.get(60)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CREATE_EMPTY_INIT_CODE_WONT_REVERT already set");
    } else {
      filled.set(65);
    }

    rlpaddrFlagXorCreateEmptyInitCodeWontRevertXorInvprex.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCreateException(final Boolean b) {
    if (filled.get(66)) {
      throw new IllegalStateException("hub_v2.scenario/CREATE_EXCEPTION already set");
    } else {
      filled.set(66);
    }

    trmFlagXorCreateExceptionXorJumpx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCreateFailureConditionWillRevert(final Boolean b) {
    if (filled.get(62)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CREATE_FAILURE_CONDITION_WILL_REVERT already set");
    } else {
      filled.set(67);
    }

    warmXorCreateFailureConditionWillRevertXorJumpDestinationVettingRequired.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCreateFailureConditionWontRevert(final Boolean b) {
    if (filled.get(63)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CREATE_FAILURE_CONDITION_WONT_REVERT already set");
    } else {
      filled.set(68);
    }

    warmNewXorCreateFailureConditionWontRevertXorJumpFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCreateNonemptyInitCodeFailureWillRevert(final Boolean b) {
    if (filled.get(64)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CREATE_NONEMPTY_INIT_CODE_FAILURE_WILL_REVERT already set");
    } else {
      filled.set(69);
    }

    createNonemptyInitCodeFailureWillRevertXorKecFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCreateNonemptyInitCodeFailureWontRevert(final Boolean b) {
    if (filled.get(65)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CREATE_NONEMPTY_INIT_CODE_FAILURE_WONT_REVERT already set");
    } else {
      filled.set(70);
    }

    createNonemptyInitCodeFailureWontRevertXorLogFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCreateNonemptyInitCodeSuccessWillRevert(final Boolean b) {
    if (filled.get(66)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CREATE_NONEMPTY_INIT_CODE_SUCCESS_WILL_REVERT already set");
    } else {
      filled.set(71);
    }

    createNonemptyInitCodeSuccessWillRevertXorJumpDestinationVettingRequired.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioCreateNonemptyInitCodeSuccessWontRevert(final Boolean b) {
    if (filled.get(67)) {
      throw new IllegalStateException(
          "hub_v2.scenario/CREATE_NONEMPTY_INIT_CODE_SUCCESS_WONT_REVERT already set");
    } else {
      filled.set(72);
    }

    createNonemptyInitCodeSuccessWontRevertXorMaxcsx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioEcadd(final Boolean b) {
    if (filled.get(73)) {
      throw new IllegalStateException("hub_v2.scenario/ECADD already set");
    } else {
      filled.set(73);
    }

    ecaddXorModFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioEcmul(final Boolean b) {
    if (filled.get(74)) {
      throw new IllegalStateException("hub_v2.scenario/ECMUL already set");
    } else {
      filled.set(74);
    }

    ecmulXorMulFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioEcpairing(final Boolean b) {
    if (filled.get(75)) {
      throw new IllegalStateException("hub_v2.scenario/ECPAIRING already set");
    } else {
      filled.set(75);
    }

    ecpairingXorMxpx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioEcrecover(final Boolean b) {
    if (filled.get(76)) {
      throw new IllegalStateException("hub_v2.scenario/ECRECOVER already set");
    } else {
      filled.set(76);
    }

    ecrecoverXorMxpFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioIdentity(final Boolean b) {
    if (filled.get(77)) {
      throw new IllegalStateException("hub_v2.scenario/IDENTITY already set");
    } else {
      filled.set(77);
    }

    identityXorOobFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioModexp(final Boolean b) {
    if (filled.get(78)) {
      throw new IllegalStateException("hub_v2.scenario/MODEXP already set");
    } else {
      filled.set(78);
    }

    modexpXorOogx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioPrcCalleeGas(final long b) {
    if (filled.get(98)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_CALLEE_GAS already set");
    } else {
      filled.set(98);
    }

    expInstXorPrcCalleeGas.putLong(b);

    return this;
  }

  public Trace pScenarioPrcCallerGas(final long b) {
    if (filled.get(99)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_CALLER_GAS already set");
    } else {
      filled.set(99);
    }

    mmuAuxIdXorPrcCallerGas.putLong(b);

    return this;
  }

  public Trace pScenarioPrcCdo(final long b) {
    if (filled.get(100)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_CDO already set");
    } else {
      filled.set(100);
    }

    mmuExoSumXorPrcCdo.putLong(b);

    return this;
  }

  public Trace pScenarioPrcCds(final long b) {
    if (filled.get(101)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_CDS already set");
    } else {
      filled.set(101);
    }

    mmuInstXorPrcCds.putLong(b);

    return this;
  }

  public Trace pScenarioPrcFailureKnownToHub(final Boolean b) {
    if (filled.get(79)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_FAILURE_KNOWN_TO_HUB already set");
    } else {
      filled.set(79);
    }

    prcFailureKnownToHubXorOpcx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioPrcFailureKnownToRam(final Boolean b) {
    if (filled.get(80)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_FAILURE_KNOWN_TO_RAM already set");
    } else {
      filled.set(80);
    }

    prcFailureKnownToRamXorPushpopFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioPrcRac(final long b) {
    if (filled.get(102)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_RAC already set");
    } else {
      filled.set(102);
    }

    mmuPhaseXorPrcRac.putLong(b);

    return this;
  }

  public Trace pScenarioPrcRao(final long b) {
    if (filled.get(103)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_RAO already set");
    } else {
      filled.set(103);
    }

    mmuRefOffsetXorPrcRao.putLong(b);

    return this;
  }

  public Trace pScenarioPrcReturnGas(final long b) {
    if (filled.get(104)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_RETURN_GAS already set");
    } else {
      filled.set(104);
    }

    mmuRefSizeXorPrcReturnGas.putLong(b);

    return this;
  }

  public Trace pScenarioPrcSuccessWillRevert(final Boolean b) {
    if (filled.get(81)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_SUCCESS_WILL_REVERT already set");
    } else {
      filled.set(81);
    }

    prcSuccessWillRevertXorRdcx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioPrcSuccessWontRevert(final Boolean b) {
    if (filled.get(80)) {
      throw new IllegalStateException("hub_v2.scenario/PRC_SUCCESS_WONT_REVERT already set");
    } else {
      filled.set(80);
    }

    prcSuccessWontRevertXorRdcx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioReturnDeploymentEmptyCodeWillRevert(final Boolean b) {
    if (filled.get(81)) {
      throw new IllegalStateException(
          "hub_v2.scenario/RETURN_DEPLOYMENT_EMPTY_CODE_WILL_REVERT already set");
    } else {
      filled.set(81);
    }

    returnDeploymentEmptyCodeWillRevertXorShfFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioReturnDeploymentEmptyCodeWontRevert(final Boolean b) {
    if (filled.get(82)) {
      throw new IllegalStateException(
          "hub_v2.scenario/RETURN_DEPLOYMENT_EMPTY_CODE_WONT_REVERT already set");
    } else {
      filled.set(82);
    }

    prcSuccessWontRevertXorShfFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioRipemd160(final Boolean b) {
    if (filled.get(83)) {
      throw new IllegalStateException(
          "hub_v2.scenario/RETURN_DEPLOYMENT_NONEMPTY_CODE_WILL_REVERT already set");
    } else {
      filled.set(83);
    }

    ripemd160XorSox.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioSelfdestruct(final Boolean b) {
    if (filled.get(84)) {
      throw new IllegalStateException(
          "hub_v2.scenario/RETURN_DEPLOYMENT_NONEMPTY_CODE_WONT_REVERT already set");
    } else {
      filled.set(84);
    }

    selfdestructXorSstorex.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioSha2256(final Boolean b) {
    if (filled.get(85)) {
      throw new IllegalStateException("hub_v2.scenario/SHA2-256 already set");
    } else {
      filled.set(85);
    }

    returnExceptionXorStackItemPop1.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioReturnMessageCallWillTouchRam(final Boolean b) {
    if (filled.get(86)) {
      throw new IllegalStateException(
          "hub_v2.scenario/RETURN_MESSAGE_CALL_WILL_TOUCH_RAM already set");
    } else {
      filled.set(86);
    }

    returnMessageCallWillTouchRamXorStackItemPop2.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pScenarioReturnMessageCallWontTouchRam(final Boolean b) {
    if (filled.get(87)) {
      throw new IllegalStateException(
          "hub_v2.scenario/RETURN_MESSAGE_CALL_WONT_TOUCH_RAM already set");
    } else {
      filled.set(87);
    }

    returnMessageCallWontTouchRamXorStackItemPop3.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackAccFlag(final Boolean b) {
    if (filled.get(48)) {
      throw new IllegalStateException("hub_v2.stack/ACC_FLAG already set");
    } else {
      filled.set(48);
    }

    deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackAddFlag(final Boolean b) {
    if (filled.get(49)) {
      throw new IllegalStateException("hub_v2.stack/ADD_FLAG already set");
    } else {
      filled.set(49);
    }

    deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackBinFlag(final Boolean b) {
    if (filled.get(50)) {
      throw new IllegalStateException("hub_v2.stack/BIN_FLAG already set");
    } else {
      filled.set(50);
    }

    depStatusNewXorMmuFlagXorCallEoaSuccessCallerWillRevertXorBinFlagXorValCurrIsZeroXorStatusCode
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackBtcFlag(final Boolean b) {
    if (filled.get(51)) {
      throw new IllegalStateException("hub_v2.stack/BTC_FLAG already set");
    } else {
      filled.set(51);
    }

    existsXorMmuSuccessBitXorCallEoaSuccessCallerWontRevertXorBtcFlagXorValNextIsCurrXorTxnRequiresEvmExecution
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackCallFlag(final Boolean b) {
    if (filled.get(52)) {
      throw new IllegalStateException("hub_v2.stack/CALL_FLAG already set");
    } else {
      filled.set(52);
    }

    existsNewXorMxpDeploysXorCallExceptionXorCallFlagXorValNextIsOrig.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackConFlag(final Boolean b) {
    if (filled.get(53)) {
      throw new IllegalStateException("hub_v2.stack/CON_FLAG already set");
    } else {
      filled.set(53);
    }

    hasCodeXorMxpFlagXorCallPrcFailureXorConFlagXorValNextIsZero.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackCopyFlag(final Boolean b) {
    if (filled.get(54)) {
      throw new IllegalStateException("hub_v2.stack/COPY_FLAG already set");
    } else {
      filled.set(54);
    }

    hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWillRevertXorCopyFlagXorValOrigIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackCreateFlag(final Boolean b) {
    if (filled.get(55)) {
      throw new IllegalStateException("hub_v2.stack/CREATE_FLAG already set");
    } else {
      filled.set(55);
    }

    isBlake2FXorOobFlagXorCallPrcSuccessCallerWontRevertXorCreateFlagXorWarm.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackDecodedFlag1(final Boolean b) {
    if (filled.get(56)) {
      throw new IllegalStateException("hub_v2.stack/DECODED_FLAG_1 already set");
    } else {
      filled.set(56);
    }

    isEcaddXorStpExistsXorCallSmcFailureCallerWillRevertXorDecodedFlag1XorWarmNew.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackDecodedFlag2(final Boolean b) {
    if (filled.get(57)) {
      throw new IllegalStateException("hub_v2.stack/DECODED_FLAG_2 already set");
    } else {
      filled.set(57);
    }

    isEcmulXorStpFlagXorCallSmcFailureCallerWontRevertXorDecodedFlag2.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackDecodedFlag3(final Boolean b) {
    if (filled.get(58)) {
      throw new IllegalStateException("hub_v2.stack/DECODED_FLAG_3 already set");
    } else {
      filled.set(58);
    }

    isEcpairingXorStpOogxXorCallSmcSuccessCallerWillRevertXorDecodedFlag3.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackDecodedFlag4(final Boolean b) {
    if (filled.get(59)) {
      throw new IllegalStateException("hub_v2.stack/DECODED_FLAG_4 already set");
    } else {
      filled.set(59);
    }

    isEcrecoverXorStpWarmthXorCallSmcSuccessCallerWontRevertXorDecodedFlag4.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackDupFlag(final Boolean b) {
    if (filled.get(60)) {
      throw new IllegalStateException("hub_v2.stack/DUP_FLAG already set");
    } else {
      filled.set(60);
    }

    isIdentityXorCodedepositXorDupFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackExtFlag(final Boolean b) {
    if (filled.get(61)) {
      throw new IllegalStateException("hub_v2.stack/EXT_FLAG already set");
    } else {
      filled.set(61);
    }

    isModexpXorCodedepositInvalidCodePrefixXorExtFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackHaltFlag(final Boolean b) {
    if (filled.get(62)) {
      throw new IllegalStateException("hub_v2.stack/HALT_FLAG already set");
    } else {
      filled.set(62);
    }

    isPrecompileXorCodedepositValidCodePrefixXorHaltFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackHashInfoFlag(final Boolean b) {
    if (filled.get(63)) {
      throw new IllegalStateException("hub_v2.stack/HASH_INFO_FLAG already set");
    } else {
      filled.set(63);
    }

    isRipemd160XorCreateAbortXorHashInfoFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackHashInfoKecHi(final Bytes b) {
    if (filled.get(109)) {
      throw new IllegalStateException("hub_v2.stack/HASH_INFO___KEC_HI already set");
    } else {
      filled.set(109);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.put((byte) 0);
    }
    addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackHashInfoKecLo(final Bytes b) {
    if (filled.get(110)) {
      throw new IllegalStateException("hub_v2.stack/HASH_INFO___KEC_LO already set");
    } else {
      filled.set(110);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.put((byte) 0);
    }
    addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackHashInfoSize(final Bytes b) {
    if (filled.get(111)) {
      throw new IllegalStateException("hub_v2.stack/HASH_INFO___SIZE already set");
    } else {
      filled.set(111);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoSizeXorDeploymentNumberXorCoinbaseAddressHi
          .put((byte) 0);
    }
    balanceXorAccountDeploymentNumberXorExpData2XorHashInfoSizeXorDeploymentNumberXorCoinbaseAddressHi
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackHeight(final Bytes b) {
    if (filled.get(112)) {
      throw new IllegalStateException("hub_v2.stack/HEIGHT already set");
    } else {
      filled.set(112);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHeightXorStorageKeyHiXorCoinbaseAddressLo.put(
          (byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHeightXorStorageKeyHiXorCoinbaseAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackBinFlag(final Boolean b) {
    if (filled.get(49)) {
      throw new IllegalStateException("hub_v2.stack/BIN_FLAG already set");
    } else {
      filled.set(49);
    }

    deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackBtcFlag(final Boolean b) {
    if (filled.get(50)) {
      throw new IllegalStateException("hub_v2.stack/BTC_FLAG already set");
    } else {
      filled.set(50);
    }

    existsXorMmuSuccessBitXorCallExceptionXorBtcFlagXorValNextIsCurrXorRequiresEvmExecution.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackCallFlag(final Boolean b) {
    if (filled.get(51)) {
      throw new IllegalStateException("hub_v2.stack/CALL_FLAG already set");
    } else {
      filled.set(51);
    }

    existsNewXorMxpDeploysXorCallPrcFailureXorCallFlagXorValNextIsOrigXorStatusCode.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackConFlag(final Boolean b) {
    if (filled.get(52)) {
      throw new IllegalStateException("hub_v2.stack/CON_FLAG already set");
    } else {
      filled.set(52);
    }

    hasCodeXorMxpFlagXorCallPrcSuccessCallerWillRevertXorConFlagXorValNextIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackCopyFlag(final Boolean b) {
    if (filled.get(53)) {
      throw new IllegalStateException("hub_v2.stack/COPY_FLAG already set");
    } else {
      filled.set(53);
    }

    hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWontRevertXorCopyFlagXorValOrigIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackCreateFlag(final Boolean b) {
    if (filled.get(54)) {
      throw new IllegalStateException("hub_v2.stack/CREATE_FLAG already set");
    } else {
      filled.set(54);
    }

    isPrecompileXorOobFlagXorCallSmcFailureCallerWillRevertXorCreateFlagXorWarm.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackDecFlag1(final Boolean b) {
    if (filled.get(55)) {
      throw new IllegalStateException("hub_v2.stack/DEC_FLAG_1 already set");
    } else {
      filled.set(55);
    }

    markedForSelfdestructXorStpExistsXorCallSmcFailureCallerWontRevertXorDecFlag1XorWarmNew.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackDecFlag2(final Boolean b) {
    if (filled.get(56)) {
      throw new IllegalStateException("hub_v2.stack/DEC_FLAG_2 already set");
    } else {
      filled.set(56);
    }

    markedForSelfdestructNewXorStpFlagXorCallSmcSuccessCallerWillRevertXorDecFlag2.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackDecFlag3(final Boolean b) {
    if (filled.get(57)) {
      throw new IllegalStateException("hub_v2.stack/DEC_FLAG_3 already set");
    } else {
      filled.set(57);
    }

    rlpaddrFlagXorStpOogxXorCallSmcSuccessCallerWontRevertXorDecFlag3.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackDecFlag4(final Boolean b) {
    if (filled.get(58)) {
      throw new IllegalStateException("hub_v2.stack/DEC_FLAG_4 already set");
    } else {
      filled.set(58);
    }

    romLexFlagXorStpWarmthXorCreateAbortXorDecFlag4.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackDelta(final Bytes b) {
    if (filled.get(113)) {
      throw new IllegalStateException("hub_v2.stack/HEIGHT_NEW already set");
    } else {
      filled.set(113);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.put(
          (byte) 0);
    }
    codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackHeightOver(final Bytes b) {
    if (filled.get(114)) {
      throw new IllegalStateException("hub_v2.stack/HEIGHT_OVER already set");
    } else {
      filled.set(114);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
          .put((byte) 0);
    }
    balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackHeightUnder(final Bytes b) {
    if (filled.get(115)) {
      throw new IllegalStateException("hub_v2.stack/HEIGHT_UNDER already set");
    } else {
      filled.set(115);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
          .put((byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackInst(final Bytes b) {
    if (filled.get(116)) {
      throw new IllegalStateException("hub_v2.stack/INST already set");
    } else {
      filled.set(116);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
          .put((byte) 0);
    }
    codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackIcpx(final Boolean b) {
    if (filled.get(63)) {
      throw new IllegalStateException("hub_v2.stack/ICPX already set");
    } else {
      filled.set(63);
    }

    createFailureConditionWontRevertXorIcpx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackInstruction(final Bytes b) {
    if (filled.get(117)) {
      throw new IllegalStateException("hub_v2.stack/INSTRUCTION already set");
    } else {
      filled.set(117);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi
          .put((byte) 0);
    }
    codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackInvalidFlag(final Boolean b) {
    if (filled.get(64)) {
      throw new IllegalStateException("hub_v2.stack/INVALID_FLAG already set");
    } else {
      filled.set(64);
    }

    isSha2256XorCreateEmptyInitCodeWillRevertXorInvalidFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackInvprex(final Boolean b) {
    if (filled.get(65)) {
      throw new IllegalStateException("hub_v2.stack/INVPREX already set");
    } else {
      filled.set(65);
    }

    rlpaddrFlagXorCreateEmptyInitCodeWontRevertXorInvprex.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackJumpDestinationVettingRequired(final Boolean b) {
    if (filled.get(67)) {
      throw new IllegalStateException("hub_v2.stack/JUMP_DESTINATION_VETTING_REQUIRED already set");
    } else {
      filled.set(67);
    }

    createNonemptyInitCodeSuccessWillRevertXorJumpDestinationVettingRequired.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackJumpFlag(final Boolean b) {
    if (filled.get(68)) {
      throw new IllegalStateException("hub_v2.stack/JUMP_FLAG already set");
    } else {
      filled.set(68);
    }

    warmNewXorCreateFailureConditionWontRevertXorJumpFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackJumpx(final Boolean b) {
    if (filled.get(66)) {
      throw new IllegalStateException("hub_v2.stack/JUMPX already set");
    } else {
      filled.set(66);
    }

    trmFlagXorCreateExceptionXorJumpx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackKecFlag(final Boolean b) {
    if (filled.get(69)) {
      throw new IllegalStateException("hub_v2.stack/KEC_FLAG already set");
    } else {
      filled.set(69);
    }

    createNonemptyInitCodeFailureWillRevertXorKecFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackLogFlag(final Boolean b) {
    if (filled.get(70)) {
      throw new IllegalStateException("hub_v2.stack/LOG_FLAG already set");
    } else {
      filled.set(70);
    }

    createNonemptyInitCodeFailureWontRevertXorLogFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackMachineStateFlag(final Boolean b) {
    if (filled.get(71)) {
      throw new IllegalStateException("hub_v2.stack/MACHINE_STATE_FLAG already set");
    } else {
      filled.set(71);
    }

    createNonemptyInitCodeSuccessWillRevertXorMachineStateFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackMaxcsx(final Boolean b) {
    if (filled.get(72)) {
      throw new IllegalStateException("hub_v2.stack/MAXCSX already set");
    } else {
      filled.set(72);
    }

    createNonemptyInitCodeSuccessWontRevertXorMaxcsx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackModFlag(final Boolean b) {
    if (filled.get(73)) {
      throw new IllegalStateException("hub_v2.stack/MOD_FLAG already set");
    } else {
      filled.set(73);
    }

    ecaddXorModFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackMulFlag(final Boolean b) {
    if (filled.get(74)) {
      throw new IllegalStateException("hub_v2.stack/MUL_FLAG already set");
    } else {
      filled.set(74);
    }

    ecmulXorMulFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackMxpFlag(final Boolean b) {
    if (filled.get(76)) {
      throw new IllegalStateException("hub_v2.stack/MXP_FLAG already set");
    } else {
      filled.set(76);
    }

    ecrecoverXorMxpFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackMxpx(final Boolean b) {
    if (filled.get(75)) {
      throw new IllegalStateException("hub_v2.stack/MXPX already set");
    } else {
      filled.set(75);
    }

    ecpairingXorMxpx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackOobFlag(final Boolean b) {
    if (filled.get(77)) {
      throw new IllegalStateException("hub_v2.stack/OOB_FLAG already set");
    } else {
      filled.set(77);
    }

    identityXorOobFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackOogx(final Boolean b) {
    if (filled.get(78)) {
      throw new IllegalStateException("hub_v2.stack/OOGX already set");
    } else {
      filled.set(78);
    }

    modexpXorOogx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackOpcx(final Boolean b) {
    if (filled.get(79)) {
      throw new IllegalStateException("hub_v2.stack/OPCX already set");
    } else {
      filled.set(79);
    }

    prcFailureKnownToHubXorOpcx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackPushValueHi(final Bytes b) {
    if (filled.get(117)) {
      throw new IllegalStateException("hub_v2.stack/PUSH_VALUE_HI already set");
    } else {
      filled.set(117);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeXorCallerAddressLoXorMmuSrcOffsetHiXorPushValueHiXorValNextLoXorGasRefundAmount.put(
          (byte) 0);
    }
    codeSizeXorCallerAddressLoXorMmuSrcOffsetHiXorPushValueHiXorValNextLoXorGasRefundAmount.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackPushValueLo(final Bytes b) {
    if (filled.get(118)) {
      throw new IllegalStateException("hub_v2.stack/PUSH_VALUE_LO already set");
    } else {
      filled.set(118);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo
          .put((byte) 0);
    }
    codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackPushpopFlag(final Boolean b) {
    if (filled.get(80)) {
      throw new IllegalStateException("hub_v2.stack/PUSHPOP_FLAG already set");
    } else {
      filled.set(80);
    }

    prcFailureKnownToRamXorPushpopFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackRdcx(final Boolean b) {
    if (filled.get(81)) {
      throw new IllegalStateException("hub_v2.stack/RDCX already set");
    } else {
      filled.set(81);
    }

    prcSuccessWillRevertXorRdcx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackShfFlag(final Boolean b) {
    if (filled.get(82)) {
      throw new IllegalStateException("hub_v2.stack/SHF_FLAG already set");
    } else {
      filled.set(82);
    }

    prcSuccessWontRevertXorShfFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackSox(final Boolean b) {
    if (filled.get(83)) {
      throw new IllegalStateException("hub_v2.stack/SOX already set");
    } else {
      filled.set(83);
    }

    ripemd160XorSox.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackSstorex(final Boolean b) {
    if (filled.get(84)) {
      throw new IllegalStateException("hub_v2.stack/SSTOREX already set");
    } else {
      filled.set(84);
    }

    selfdestructXorSstorex.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackStackItemHeight1(final Bytes b) {
    if (filled.get(119)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_HEIGHT_1 already set");
    } else {
      filled.set(119);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
          (byte) 0);
    }
    codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemHeight2(final Bytes b) {
    if (filled.get(120)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_HEIGHT_2 already set");
    } else {
      filled.set(120);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
          (byte) 0);
    }
    codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemHeight3(final Bytes b) {
    if (filled.get(121)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_HEIGHT_3 already set");
    } else {
      filled.set(121);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
          (byte) 0);
    }
    codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemHeight4(final Bytes b) {
    if (filled.get(122)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_HEIGHT_4 already set");
    } else {
      filled.set(122);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
          .put((byte) 0);
    }
    codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemHeight2(final Bytes b) {
    if (filled.get(123)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_HEIGHT_2 already set");
    } else {
      filled.set(123);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.put(
          (byte) 0);
    }
    deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemHeight3(final Bytes b) {
    if (filled.get(124)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_HEIGHT_3 already set");
    } else {
      filled.set(124);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.put(
          (byte) 0);
    }
    deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemHeight4(final Bytes b) {
    if (filled.get(125)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_HEIGHT_4 already set");
    } else {
      filled.set(125);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce.put((byte) 0);
    }
    deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemPop1(final Boolean b) {
    if (filled.get(86)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_POP_1 already set");
    } else {
      filled.set(86);
    }

    stackItemPop1.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackStackItemPop2(final Boolean b) {
    if (filled.get(87)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_POP_2 already set");
    } else {
      filled.set(87);
    }

    stackItemPop2.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackStackItemPop3(final Boolean b) {
    if (filled.get(88)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_POP_3 already set");
    } else {
      filled.set(88);
    }

    stackItemPop3.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackStackItemPop4(final Boolean b) {
    if (filled.get(89)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_POP_4 already set");
    } else {
      filled.set(89);
    }

    stackItemPop4.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackStackItemStamp1(final Bytes b) {
    if (filled.get(123)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_STAMP_1 already set");
    } else {
      filled.set(123);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      nonceNewXorContextNumberXorMxpOffset1LoXorStackItemStamp1XorNonce.put((byte) 0);
    }
    nonceNewXorContextNumberXorMxpOffset1LoXorStackItemStamp1XorNonce.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemStamp2(final Bytes b) {
    if (filled.get(124)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_STAMP_2 already set");
    } else {
      filled.set(124);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrHiXorIsStaticXorMxpOffset2HiXorStackItemStamp2XorToAddressHi.put((byte) 0);
    }
    rlpaddrDepAddrHiXorIsStaticXorMxpOffset2HiXorStackItemStamp2XorToAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemStamp3(final Bytes b) {
    if (filled.get(125)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_STAMP_3 already set");
    } else {
      filled.set(125);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrLoXorReturnerContextNumberXorMxpOffset2LoXorStackItemStamp3XorToAddressLo.put(
          (byte) 0);
    }
    rlpaddrDepAddrLoXorReturnerContextNumberXorMxpOffset2LoXorStackItemStamp3XorToAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemStamp4(final Bytes b) {
    if (filled.get(126)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_STAMP_4 already set");
    } else {
      filled.set(126);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecHiXorReturnerIsPrecompileXorMxpSize1HiXorStackItemStamp4XorValue.put((byte) 0);
    }
    rlpaddrKecHiXorReturnerIsPrecompileXorMxpSize1HiXorStackItemStamp4XorValue.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemValueHi1(final Bytes b) {
    if (filled.get(127)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_VALUE_HI_1 already set");
    } else {
      filled.set(127);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecLoXorReturnAtOffsetXorMxpSize1LoXorStackItemValueHi1.put((byte) 0);
    }
    nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemValueHi2(final Bytes b) {
    if (filled.get(128)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_VALUE_HI_2 already set");
    } else {
      filled.set(128);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.put(
          (byte) 0);
    }
    rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemValueHi3(final Bytes b) {
    if (filled.get(129)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_VALUE_HI_3 already set");
    } else {
      filled.set(129);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrSaltHiXorReturnDataOffsetXorMxpSize2LoXorStackItemValueHi3.put((byte) 0);
    }
    rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemValueHi4(final Bytes b) {
    if (filled.get(130)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_VALUE_HI_4 already set");
    } else {
      filled.set(130);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrSaltLoXorReturnDataSizeXorMxpWordsXorStackItemValueHi4.put((byte) 0);
    }
    rlpaddrSaltLoXorReturnDataSizeXorMxpWordsXorStackItemValueHi4.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemValueLo1(final Bytes b) {
    if (filled.get(131)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_VALUE_LO_1 already set");
    } else {
      filled.set(131);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      trmRawAddrHiXorOobData1XorStackItemValueLo1.put((byte) 0);
    }
    trmRawAddrHiXorOobData1XorStackItemValueLo1.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemValueLo2(final Bytes b) {
    if (filled.get(132)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_VALUE_LO_2 already set");
    } else {
      filled.set(132);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      oobData2XorStackItemValueLo2.put((byte) 0);
    }
    oobData2XorStackItemValueLo2.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemValueLo3(final Bytes b) {
    if (filled.get(133)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_VALUE_LO_3 already set");
    } else {
      filled.set(133);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      oobData3XorStackItemValueLo3.put((byte) 0);
    }
    oobData3XorStackItemValueLo3.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackItemValueLo4(final Bytes b) {
    if (filled.get(134)) {
      throw new IllegalStateException("hub_v2.stack/STACK_ITEM_VALUE_LO_4 already set");
    } else {
      filled.set(134);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      oobData4XorStackItemValueLo4.put((byte) 0);
    }
    oobData4XorStackItemValueLo4.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStackramFlag(final Boolean b) {
    if (filled.get(85)) {
      throw new IllegalStateException("hub_v2.stack/STACKRAM_FLAG already set");
    } else {
      filled.set(85);
    }

    sha2256XorStackramFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackStaticFlag(final Boolean b) {
    if (filled.get(91)) {
      throw new IllegalStateException("hub_v2.stack/STATIC_FLAG already set");
    } else {
      filled.set(91);
    }

    staticFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackStaticGas(final Bytes b) {
    if (filled.get(135)) {
      throw new IllegalStateException("hub_v2.stack/STATIC_GAS already set");
    } else {
      filled.set(135);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      oobData5XorStaticGas.put((byte) 0);
    }
    oobData5XorStaticGas.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStackStaticx(final Boolean b) {
    if (filled.get(90)) {
      throw new IllegalStateException("hub_v2.stack/STATICX already set");
    } else {
      filled.set(90);
    }

    staticx.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackStoFlag(final Boolean b) {
    if (filled.get(92)) {
      throw new IllegalStateException("hub_v2.stack/STO_FLAG already set");
    } else {
      filled.set(92);
    }

    stoFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackSux(final Boolean b) {
    if (filled.get(93)) {
      throw new IllegalStateException("hub_v2.stack/SUX already set");
    } else {
      filled.set(93);
    }

    sux.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackSwapFlag(final Boolean b) {
    if (filled.get(94)) {
      throw new IllegalStateException("hub_v2.stack/SWAP_FLAG already set");
    } else {
      filled.set(94);
    }

    swapFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackTrmFlag(final Boolean b) {
    if (filled.get(95)) {
      throw new IllegalStateException("hub_v2.stack/TRM_FLAG already set");
    } else {
      filled.set(95);
    }

    trmFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackTxnFlag(final Boolean b) {
    if (filled.get(96)) {
      throw new IllegalStateException("hub_v2.stack/TXN_FLAG already set");
    } else {
      filled.set(96);
    }

    txnFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStackWcpFlag(final Boolean b) {
    if (filled.get(97)) {
      throw new IllegalStateException("hub_v2.stack/WCP_FLAG already set");
    } else {
      filled.set(97);
    }

    wcpFlag.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageAddressHi(final Bytes b) {
    if (filled.get(109)) {
      throw new IllegalStateException("hub_v2.storage/ADDRESS_HI already set");
    } else {
      filled.set(109);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.put((byte) 0);
    }
    addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageAddressLo(final Bytes b) {
    if (filled.get(110)) {
      throw new IllegalStateException("hub_v2.storage/ADDRESS_LO already set");
    } else {
      filled.set(110);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.put((byte) 0);
    }
    addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageDeploymentNumber(final Bytes b) {
    if (filled.get(111)) {
      throw new IllegalStateException("hub_v2.storage/DEPLOYMENT_NUMBER already set");
    } else {
      filled.set(111);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
          .put((byte) 0);
    }
    balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageStorageKeyHi(final Bytes b) {
    if (filled.get(115)) {
      throw new IllegalStateException("hub_v2.storage/STORAGE_KEY_HI already set");
    } else {
      filled.set(115);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
          .put((byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageStorageKeyLo(final Bytes b) {
    if (filled.get(116)) {
      throw new IllegalStateException("hub_v2.storage/STORAGE_KEY_LO already set");
    } else {
      filled.set(116);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
          .put((byte) 0);
    }
    codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValCurrChanges(final Boolean b) {
    if (filled.get(47)) {
      throw new IllegalStateException("hub_v2.storage/VAL_CURR_CHANGES already set");
    } else {
      filled.set(47);
    }

    deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValCurrHi(final Bytes b) {
    if (filled.get(117)) {
      throw new IllegalStateException("hub_v2.storage/VAL_CURR_HI already set");
    } else {
      filled.set(117);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi
          .put((byte) 0);
    }
    codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValCurrIsOrig(final Boolean b) {
    if (filled.get(48)) {
      throw new IllegalStateException("hub_v2.storage/VAL_CURR_IS_ORIG already set");
    } else {
      filled.set(48);
    }

    deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValCurrIsZero(final Boolean b) {
    if (filled.get(49)) {
      throw new IllegalStateException("hub_v2.storage/VAL_CURR_IS_ZERO already set");
    } else {
      filled.set(49);
    }

    deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValCurrLo(final Bytes b) {
    if (filled.get(118)) {
      throw new IllegalStateException("hub_v2.storage/VAL_CURR_LO already set");
    } else {
      filled.set(118);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo
          .put((byte) 0);
    }
    codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValNextHi(final Bytes b) {
    if (filled.get(119)) {
      throw new IllegalStateException("hub_v2.storage/VAL_NEXT_HI already set");
    } else {
      filled.set(119);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
          (byte) 0);
    }
    codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValNextIsCurr(final Boolean b) {
    if (filled.get(50)) {
      throw new IllegalStateException("hub_v2.storage/VAL_NEXT_IS_CURR already set");
    } else {
      filled.set(50);
    }

    existsXorMmuSuccessBitXorCallExceptionXorBtcFlagXorValNextIsCurrXorRequiresEvmExecution.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValNextIsOrig(final Boolean b) {
    if (filled.get(51)) {
      throw new IllegalStateException("hub_v2.storage/VAL_NEXT_IS_ORIG already set");
    } else {
      filled.set(51);
    }

    existsNewXorMxpDeploysXorCallPrcFailureXorCallFlagXorValNextIsOrigXorStatusCode.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValNextIsZero(final Boolean b) {
    if (filled.get(52)) {
      throw new IllegalStateException("hub_v2.storage/VAL_NEXT_IS_ZERO already set");
    } else {
      filled.set(52);
    }

    hasCodeXorMxpFlagXorCallPrcSuccessCallerWillRevertXorConFlagXorValNextIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValNextLo(final Bytes b) {
    if (filled.get(120)) {
      throw new IllegalStateException("hub_v2.storage/VAL_NEXT_LO already set");
    } else {
      filled.set(120);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
          (byte) 0);
    }
    codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValOrigHi(final Bytes b) {
    if (filled.get(121)) {
      throw new IllegalStateException("hub_v2.storage/VAL_ORIG_HI already set");
    } else {
      filled.set(121);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
          (byte) 0);
    }
    codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValOrigIsZero(final Boolean b) {
    if (filled.get(53)) {
      throw new IllegalStateException("hub_v2.storage/VAL_ORIG_IS_ZERO already set");
    } else {
      filled.set(53);
    }

    hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWontRevertXorCopyFlagXorValOrigIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValOrigLo(final Bytes b) {
    if (filled.get(122)) {
      throw new IllegalStateException("hub_v2.storage/VAL_ORIG_LO already set");
    } else {
      filled.set(122);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
          .put((byte) 0);
    }
    codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageWarm(final Boolean b) {
    if (filled.get(54)) {
      throw new IllegalStateException("hub_v2.storage/WARM already set");
    } else {
      filled.set(54);
    }

    isPrecompileXorOobFlagXorCallSmcFailureCallerWillRevertXorCreateFlagXorWarm.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageWarmNew(final Boolean b) {
    if (filled.get(55)) {
      throw new IllegalStateException("hub_v2.storage/WARM_NEW already set");
    } else {
      filled.set(55);
    }

    markedForSelfdestructXorStpExistsXorCallSmcFailureCallerWontRevertXorDecFlag1XorWarmNew.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pTransactionBasefee(final Bytes b) {
    if (filled.get(112)) {
      throw new IllegalStateException("hub_v2.storage/STORAGE_KEY_HI already set");
    } else {
      filled.set(112);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHeightXorStorageKeyHiXorCoinbaseAddressLo.put(
          (byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHeightXorStorageKeyHiXorCoinbaseAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageStorageKeyLo(final Bytes b) {
    if (filled.get(113)) {
      throw new IllegalStateException("hub_v2.storage/STORAGE_KEY_LO already set");
    } else {
      filled.set(113);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.put(
          (byte) 0);
    }
    codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValCurrChanges(final Boolean b) {
    if (filled.get(48)) {
      throw new IllegalStateException("hub_v2.storage/VAL_CURR_CHANGES already set");
    } else {
      filled.set(48);
    }

    deploymentStatusInftyXorUpdateXorCcsrFlagXorBlake2FXorAccFlagXorValCurrChangesXorIsDeployment
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValCurrHi(final Bytes b) {
    if (filled.get(114)) {
      throw new IllegalStateException("hub_v2.storage/VAL_CURR_HI already set");
    } else {
      filled.set(114);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
          .put((byte) 0);
    }
    balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValCurrIsOrig(final Boolean b) {
    if (filled.get(49)) {
      throw new IllegalStateException("hub_v2.storage/VAL_CURR_IS_ORIG already set");
    } else {
      filled.set(49);
    }

    depStatusXorExpFlagXorCallAbortXorAddFlagXorValCurrIsOrigXorIsEip1559.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValCurrIsZero(final Boolean b) {
    if (filled.get(50)) {
      throw new IllegalStateException("hub_v2.storage/VAL_CURR_IS_ZERO already set");
    } else {
      filled.set(50);
    }

    depStatusNewXorMmuFlagXorCallEoaSuccessCallerWillRevertXorBinFlagXorValCurrIsZeroXorStatusCode
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValCurrLo(final Bytes b) {
    if (filled.get(115)) {
      throw new IllegalStateException("hub_v2.storage/VAL_CURR_LO already set");
    } else {
      filled.set(115);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
          .put((byte) 0);
    }
    balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValNextHi(final Bytes b) {
    if (filled.get(116)) {
      throw new IllegalStateException("hub_v2.storage/VAL_NEXT_HI already set");
    } else {
      filled.set(116);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
          .put((byte) 0);
    }
    codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValNextIsCurr(final Boolean b) {
    if (filled.get(51)) {
      throw new IllegalStateException("hub_v2.storage/VAL_NEXT_IS_CURR already set");
    } else {
      filled.set(51);
    }

    deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValNextIsOrig(final Boolean b) {
    if (filled.get(52)) {
      throw new IllegalStateException("hub_v2.storage/VAL_NEXT_IS_ORIG already set");
    } else {
      filled.set(52);
    }

    existsNewXorMxpDeploysXorCallExceptionXorCallFlagXorValNextIsOrig.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValNextIsZero(final Boolean b) {
    if (filled.get(53)) {
      throw new IllegalStateException("hub_v2.storage/VAL_NEXT_IS_ZERO already set");
    } else {
      filled.set(53);
    }

    hasCodeXorMxpFlagXorCallPrcFailureXorConFlagXorValNextIsZero.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValNextLo(final Bytes b) {
    if (filled.get(117)) {
      throw new IllegalStateException("hub_v2.storage/VAL_NEXT_LO already set");
    } else {
      filled.set(117);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi
          .put((byte) 0);
    }
    codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValOrigHi(final Bytes b) {
    if (filled.get(118)) {
      throw new IllegalStateException("hub_v2.storage/VAL_ORIG_HI already set");
    } else {
      filled.set(118);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo
          .put((byte) 0);
    }
    codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pStorageValOrigIsZero(final Boolean b) {
    if (filled.get(54)) {
      throw new IllegalStateException("hub_v2.storage/VAL_ORIG_IS_ZERO already set");
    } else {
      filled.set(54);
    }

    hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWillRevertXorCopyFlagXorValOrigIsZero.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pStorageValOrigLo(final Bytes b) {
    if (filled.get(119)) {
      throw new IllegalStateException("hub_v2.storage/VAL_ORIG_LO already set");
    } else {
      filled.set(119);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
          (byte) 0);
    }
    codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionGasPrice(final Bytes b) {
    if (filled.get(116)) {
      throw new IllegalStateException("hub_v2.transaction/GAS_PRICE already set");
    } else {
      filled.set(116);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoNewXorCallerAddressHiXorMmuLimb2XorInstXorValNextHiXorGasPrice.put((byte) 0);
    }
    codeHashLoNewXorCallerAddressHiXorMmuLimb2XorInstXorValNextHiXorGasPrice.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionGasRefundAmount(final Bytes b) {
    if (filled.get(117)) {
      throw new IllegalStateException("hub_v2.transaction/GAS_REFUND_AMOUNT already set");
    } else {
      filled.set(117);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeXorCallerAddressLoXorMmuSrcOffsetHiXorPushValueHiXorValNextLoXorGasRefundAmount.put(
          (byte) 0);
    }
    codeSizeXorCallerAddressLoXorMmuSrcOffsetHiXorPushValueHiXorValNextLoXorGasRefundAmount.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionGasRefundCounterFinal(final Bytes b) {
    if (filled.get(118)) {
      throw new IllegalStateException("hub_v2.transaction/GAS_REFUND_COUNTER_FINAL already set");
    } else {
      filled.set(118);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeNewXorCallerContextNumberXorMmuSrcOffsetLoXorPushValueLoXorValOrigHiXorGasRefundCounterFinal
          .put((byte) 0);
    }
    codeSizeNewXorCallerContextNumberXorMmuSrcOffsetLoXorPushValueLoXorValOrigHiXorGasRefundCounterFinal
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionInitCodeSize(final Bytes b) {
    if (filled.get(120)) {
      throw new IllegalStateException("hub_v2.transaction/INIT_CODE_SIZE already set");
    } else {
      filled.set(120);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
          (byte) 0);
    }
    codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionInitCodeSize(final Bytes b) {
    if (filled.get(123)) {
      throw new IllegalStateException("hub_v2.transaction/INIT_CODE_SIZE already set");
    } else {
      filled.set(123);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.put(
          (byte) 0);
    }
    deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionInitialBalance(final Bytes b) {
    if (filled.get(121)) {
      throw new IllegalStateException("hub_v2.transaction/INIT_GAS already set");
    } else {
      filled.set(121);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
          (byte) 0);
    }
    codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionInitialBalance(final Bytes b) {
    if (filled.get(119)) {
      throw new IllegalStateException("hub_v2.transaction/INITIAL_BALANCE already set");
    } else {
      filled.set(119);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
          .put((byte) 0);
    }
    codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
        .put(b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionIsDeployment(final Boolean b) {
    if (filled.get(48)) {
      throw new IllegalStateException("hub_v2.transaction/IS_DEPLOYMENT already set");
    } else {
      filled.set(48);
    }

    deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pTransactionIsEip1559(final Boolean b) {
    if (filled.get(49)) {
      throw new IllegalStateException("hub_v2.transaction/IS_EIP1559 already set");
    } else {
      filled.set(49);
    }

    deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pTransactionLeftoverGas(final Bytes b) {
    if (filled.get(122)) {
      throw new IllegalStateException("hub_v2.transaction/LEFTOVER_GAS already set");
    } else {
      filled.set(122);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      nonceXorCallValueXorMxpOffset1HiXorStackItemHeight4XorLeftoverGas.put((byte) 0);
    }
    nonceXorCallValueXorMxpOffset1HiXorStackItemHeight4XorLeftoverGas.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionNonce(final Bytes b) {
    if (filled.get(123)) {
      throw new IllegalStateException("hub_v2.transaction/NONCE already set");
    } else {
      filled.set(123);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      nonceNewXorContextNumberXorMxpOffset1LoXorStackItemStamp1XorNonce.put((byte) 0);
    }
    nonceNewXorContextNumberXorMxpOffset1LoXorStackItemStamp1XorNonce.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionStatusCode(final Boolean b) {
    if (filled.get(50)) {
      throw new IllegalStateException("hub_v2.transaction/STATUS_CODE already set");
    } else {
      filled.set(50);
    }

    depStatusNewXorMmuFlagXorCallEoaSuccessCallerWillRevertXorBinFlagXorValCurrIsZeroXorStatusCode
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pTransactionToAddressHi(final Bytes b) {
    if (filled.get(124)) {
      throw new IllegalStateException("hub_v2.transaction/TO_ADDRESS_HI already set");
    } else {
      filled.set(124);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.put(
          (byte) 0);
    }
    deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionToAddressLo(final Bytes b) {
    if (filled.get(125)) {
      throw new IllegalStateException("hub_v2.transaction/TO_ADDRESS_LO already set");
    } else {
      filled.set(125);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrLoXorReturnerContextNumberXorMxpOffset2LoXorStackItemStamp3XorToAddressLo.put(
          (byte) 0);
    }
    deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionTxnRequiresEvmExecution(final Boolean b) {
    if (filled.get(51)) {
      throw new IllegalStateException("hub_v2.transaction/TXN_REQUIRES_EVM_EXECUTION already set");
    } else {
      filled.set(51);
    }

    existsXorMmuSuccessBitXorCallEoaSuccessCallerWontRevertXorBtcFlagXorValNextIsCurrXorTxnRequiresEvmExecution
        .put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace pTransactionValue(final Bytes b) {
    if (filled.get(126)) {
      throw new IllegalStateException("hub_v2.transaction/VALUE already set");
    } else {
      filled.set(126);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecHiXorReturnerIsPrecompileXorMxpSize1HiXorStackItemStamp4XorValue.put((byte) 0);
    }
    nonceXorCallValueXorMxpSize2HiXorStackItemStamp1XorRefundAmount.put(b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionRefundCounterInfinity(final Bytes b) {
    if (filled.get(127)) {
      throw new IllegalStateException("hub_v2.transaction/REFUND_COUNTER_INFINITY already set");
    } else {
      filled.set(127);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity.put((byte) 0);
    }
    nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionRequiresEvmExecution(final Boolean b) {
    if (filled.get(50)) {
      throw new IllegalStateException("hub_v2.transaction/REQUIRES_EVM_EXECUTION already set");
    } else {
      filled.set(50);
    }

    existsXorMmuSuccessBitXorCallExceptionXorBtcFlagXorValNextIsCurrXorRequiresEvmExecution.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pTransactionStatusCode(final Boolean b) {
    if (filled.get(51)) {
      throw new IllegalStateException("hub_v2.transaction/STATUS_CODE already set");
    } else {
      filled.set(51);
    }

    existsNewXorMxpDeploysXorCallPrcFailureXorCallFlagXorValNextIsOrigXorStatusCode.put(
        (byte) (b ? 1 : 0));

    return this;
  }

  public Trace pTransactionToAddressHi(final Bytes b) {
    if (filled.get(128)) {
      throw new IllegalStateException("hub_v2.transaction/TO_ADDRESS_HI already set");
    } else {
      filled.set(128);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.put(
          (byte) 0);
    }
    rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionToAddressLo(final Bytes b) {
    if (filled.get(129)) {
      throw new IllegalStateException("hub_v2.transaction/TO_ADDRESS_LO already set");
    } else {
      filled.set(129);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo.put((byte) 0);
    }
    rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo.put(
        b.toArrayUnsafe());

    return this;
  }

  public Trace pTransactionValue(final Bytes b) {
    if (filled.get(130)) {
      throw new IllegalStateException("hub_v2.transaction/VALUE already set");
    } else {
      filled.set(130);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      rlpaddrKecHiXorReturnAtOffsetXorOobData2XorStackItemValueHi1XorValue.put((byte) 0);
    }
    rlpaddrKecHiXorReturnAtOffsetXorOobData2XorStackItemValueHi1XorValue.put(b.toArrayUnsafe());

    return this;
  }

  public Trace peekAtAccount(final Boolean b) {
    if (filled.get(31)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_ACCOUNT already set");
    } else {
      filled.set(31);
    }

    peekAtAccount.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace peekAtContext(final Boolean b) {
    if (filled.get(32)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_CONTEXT already set");
    } else {
      filled.set(32);
    }

    peekAtContext.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace peekAtMiscellaneous(final Boolean b) {
    if (filled.get(33)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_MISCELLANEOUS already set");
    } else {
      filled.set(33);
    }

    peekAtMiscellaneous.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace peekAtScenario(final Boolean b) {
    if (filled.get(34)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_SCENARIO already set");
    } else {
      filled.set(34);
    }

    peekAtScenario.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace peekAtStack(final Boolean b) {
    if (filled.get(35)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_STACK already set");
    } else {
      filled.set(35);
    }

    peekAtStack.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace peekAtStorage(final Boolean b) {
    if (filled.get(36)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_STORAGE already set");
    } else {
      filled.set(36);
    }

    peekAtStorage.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace peekAtTransaction(final Boolean b) {
    if (filled.get(37)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_TRANSACTION already set");
    } else {
      filled.set(37);
    }

    peekAtTransaction.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace programCounter(final Bytes b) {
    if (filled.get(38)) {
      throw new IllegalStateException("hub_v2.PROGRAM_COUNTER already set");
    } else {
      filled.set(38);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      programCounter.put((byte) 0);
    }
    programCounter.put(b.toArrayUnsafe());

    return this;
  }

  public Trace programCounterNew(final Bytes b) {
    if (filled.get(39)) {
      throw new IllegalStateException("hub_v2.PROGRAM_COUNTER_NEW already set");
    } else {
      filled.set(39);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      programCounterNew.put((byte) 0);
    }
    programCounterNew.put(b.toArrayUnsafe());

    return this;
  }

  public Trace subStamp(final Bytes b) {
    if (filled.get(40)) {
      throw new IllegalStateException("hub_v2.SUB_STAMP already set");
    } else {
      filled.set(40);
    }

    final byte[] bs = b.toArrayUnsafe();
    for (int i = bs.length; i < 32; i++) {
      subStamp.put((byte) 0);
    }
    subStamp.put(b.toArrayUnsafe());

    return this;
  }

  public Trace transactionReverts(final Boolean b) {
    if (filled.get(41)) {
      throw new IllegalStateException("hub_v2.TRANSACTION_REVERTS already set");
    } else {
      filled.set(41);
    }

    transactionReverts.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace twoLineInstruction(final Boolean b) {
    if (filled.get(42)) {
      throw new IllegalStateException("hub_v2.TWO_LINE_INSTRUCTION already set");
    } else {
      filled.set(42);
    }

    twoLineInstruction.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace txExec(final Boolean b) {
    if (filled.get(43)) {
      throw new IllegalStateException("hub_v2.TX_EXEC already set");
    } else {
      filled.set(43);
    }

    txExec.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace txFinl(final Boolean b) {
    if (filled.get(44)) {
      throw new IllegalStateException("hub_v2.TX_FINL already set");
    } else {
      filled.set(44);
    }

    txFinl.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace txInit(final Boolean b) {
    if (filled.get(45)) {
      throw new IllegalStateException("hub_v2.TX_INIT already set");
    } else {
      filled.set(45);
    }

    txInit.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace txSkip(final Boolean b) {
    if (filled.get(46)) {
      throw new IllegalStateException("hub_v2.TX_SKIP already set");
    } else {
      filled.set(46);
    }

    txSkip.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace txWarm(final Boolean b) {
    if (filled.get(47)) {
      throw new IllegalStateException("hub_v2.TX_WARM already set");
    } else {
      filled.set(47);
    }

    txWarm.put((byte) (b ? 1 : 0));

    return this;
  }

  public Trace validateRow() {
    if (!filled.get(0)) {
      throw new IllegalStateException("hub_v2.ABSOLUTE_TRANSACTION_NUMBER has not been filled");
    }

    if (!filled.get(109)) {
      throw new IllegalStateException(
          "hub_v2.ADDR_HI_xor_ACCOUNT_ADDRESS_HI_xor_CCRS_STAMP_xor_HASH_INFO___KEC_HI_xor_ADDRESS_HI_xor_BASEFEE has not been filled");
    }

    if (!filled.get(110)) {
      throw new IllegalStateException(
          "hub_v2.ADDR_LO_xor_ACCOUNT_ADDRESS_LO_xor_EXP___DATA_1_xor_HASH_INFO___KEC_LO_xor_ADDRESS_LO_xor_CALL_DATA_SIZE has not been filled");
    }

    if (!filled.get(112)) {
      throw new IllegalStateException(
          "hub_v2.ADDRESS_HI_xor_ACCOUNT_ADDRESS_HI_xor_CCRS_STAMP_xor_ALPHA_xor_ADDRESS_HI_xor_BASEFEE has not been filled");
    }

    if (!filled.get(113)) {
      throw new IllegalStateException(
          "hub_v2.ADDRESS_LO_xor_ACCOUNT_ADDRESS_LO_xor_EXP_DATA_1_xor_DELTA_xor_ADDRESS_LO_xor_BATCH_NUM has not been filled");
    }

    if (!filled.get(115)) {
      throw new IllegalStateException(
          "hub_v2.BALANCE_NEW_xor_BYTE_CODE_ADDRESS_HI_xor_EXP_DATA_3_xor_HASH_INFO_KEC_LO_xor_STORAGE_KEY_HI_xor_COINBASE_ADDRESS_HI has not been filled");
    }

    if (!filled.get(114)) {
      throw new IllegalStateException(
          "hub_v2.BALANCE_xor_ACCOUNT_DEPLOYMENT_NUMBER_xor_EXP_DATA_2_xor_HASH_INFO_KEC_HI_xor_DEPLOYMENT_NUMBER_xor_CALL_DATA_SIZE has not been filled");
    }

    if (!filled.get(1)) {
      throw new IllegalStateException("hub_v2.BATCH_NUMBER has not been filled");
    }

    if (!filled.get(2)) {
      throw new IllegalStateException("hub_v2.CALLER_CONTEXT_NUMBER has not been filled");
    }

    if (!filled.get(3)) {
      throw new IllegalStateException("hub_v2.CODE_FRAGMENT_INDEX has not been filled");
    }

    if (!filled.get(116)) {
      throw new IllegalStateException(
          "hub_v2.CODE_FRAGMENT_INDEX_xor_BYTE_CODE_ADDRESS_LO_xor_EXP_DATA_4_xor_HASH_INFO_SIZE_xor_STORAGE_KEY_LO_xor_COINBASE_ADDRESS_LO has not been filled");
    }

    if (!filled.get(118)) {
      throw new IllegalStateException(
          "hub_v2.CODE_HASH_HI_NEW_xor_BYTE_CODE_DEPLOYMENT_NUMBER_xor_MXP_GAS_MXP_xor_NB_ADDED_xor_VAL_CURR_LO_xor_FROM_ADDRESS_LO has not been filled");
    }

    if (!filled.get(117)) {
      throw new IllegalStateException(
          "hub_v2.CODE_HASH_HI_xor_BYTE_CODE_CODE_FRAGMENT_INDEX_xor_EXP_DATA_5_xor_INSTRUCTION_xor_VAL_CURR_HI_xor_FROM_ADDRESS_HI has not been filled");
    }

    if (!filled.get(120)) {
      throw new IllegalStateException(
          "hub_v2.CODE_HASH_LO_NEW_xor_CALLER_ADDRESS_HI_xor_MXP_OFFSET_1_HI_xor_PUSH_VALUE_HI_xor_VAL_NEXT_LO_xor_GAS_PRICE has not been filled");
    }

    if (!filled.get(119)) {
      throw new IllegalStateException(
          "hub_v2.CODE_HASH_LO_xor_BYTE_CODE_DEPLOYMENT_STATUS_xor_MXP_INST_xor_NB_REMOVED_xor_VAL_NEXT_HI_xor_GAS_LIMIT has not been filled");
    }

    if (!filled.get(122)) {
      throw new IllegalStateException(
          "hub_v2.CODE_SIZE_NEW_xor_CALLER_CONTEXT_NUMBER_xor_MXP_OFFSET_2_HI_xor_STACK_ITEM_HEIGHT_1_xor_VAL_ORIG_LO_xor_INITIAL_GAS has not been filled");
    }

    if (!filled.get(121)) {
      throw new IllegalStateException(
          "hub_v2.CODE_SIZE_xor_CALLER_ADDRESS_LO_xor_MXP_OFFSET_1_LO_xor_PUSH_VALUE_LO_xor_VAL_ORIG_HI_xor_INITIAL_BALANCE has not been filled");
    }

    if (!filled.get(4)) {
      throw new IllegalStateException("hub_v2.CODE_ADDRESS_LO has not been filled");
    }

    if (!filled.get(5)) {
      throw new IllegalStateException("hub_v2.CODE_DEPLOYMENT_NUMBER has not been filled");
    }

    if (!filled.get(6)) {
      throw new IllegalStateException("hub_v2.CODE_DEPLOYMENT_STATUS has not been filled");
    }

    if (!filled.get(7)) {
      throw new IllegalStateException("hub_v2.CODE_FRAGMENT_INDEX has not been filled");
    }

    if (!filled.get(114)) {
      throw new IllegalStateException(
          "hub_v2.CODE_HASH_HI_NEW_xor_BYTE_CODE_DEPLOYMENT_NUMBER_xor_EXP___DATA_5_xor_HEIGHT_OVER_xor_VAL_CURR_HI_xor_FROM_ADDRESS_LO has not been filled");
    }

    if (!filled.get(113)) {
      throw new IllegalStateException(
          "hub_v2.CODE_HASH_HI_xor_BYTE_CODE_ADDRESS_LO_xor_EXP___DATA_4_xor_HEIGHT_NEW_xor_STORAGE_KEY_LO_xor_FROM_ADDRESS_HI has not been filled");
    }

    if (!filled.get(116)) {
      throw new IllegalStateException(
          "hub_v2.CODE_HASH_LO_NEW_xor_CALLER_ADDRESS_HI_xor_MMU___LIMB_2_xor_INST_xor_VAL_NEXT_HI_xor_GAS_PRICE has not been filled");
    }

    if (!filled.get(115)) {
      throw new IllegalStateException(
          "hub_v2.CODE_HASH_LO_xor_BYTE_CODE_DEPLOYMENT_STATUS_xor_MMU___LIMB_1_xor_HEIGHT_UNDER_xor_VAL_CURR_LO_xor_GAS_LIMIT has not been filled");
    }

    if (!filled.get(118)) {
      throw new IllegalStateException(
          "hub_v2.CODE_SIZE_NEW_xor_CALLER_CONTEXT_NUMBER_xor_MMU___SRC_OFFSET_LO_xor_PUSH_VALUE_LO_xor_VAL_ORIG_HI_xor_GAS_REFUND_COUNTER_FINAL has not been filled");
    }

    if (!filled.get(117)) {
      throw new IllegalStateException(
          "hub_v2.CODE_SIZE_xor_CALLER_ADDRESS_LO_xor_MMU___SRC_OFFSET_HI_xor_PUSH_VALUE_HI_xor_VAL_NEXT_LO_xor_GAS_REFUND_AMOUNT has not been filled");
    }

    if (!filled.get(8)) {
      throw new IllegalStateException("hub_v2.CONTEXT_GETS_REVERTED_FLAG has not been filled");
    }

    if (!filled.get(9)) {
      throw new IllegalStateException("hub_v2.CONTEXT_MAY_CHANGE_FLAG has not been filled");
    }

    if (!filled.get(10)) {
      throw new IllegalStateException("hub_v2.CONTEXT_NUMBER has not been filled");
    }

    if (!filled.get(11)) {
      throw new IllegalStateException("hub_v2.CONTEXT_NUMBER_NEW has not been filled");
    }

    if (!filled.get(12)) {
      throw new IllegalStateException("hub_v2.COUNTER_TLI has not been filled");
    }

    if (!filled.get(62)) {
      throw new IllegalStateException(
          "hub_v2.CREATE_FAILURE_CONDITION_WILL_REVERT_xor_HASH_INFO_FLAG has not been filled");
    }

    if (!filled.get(63)) {
      throw new IllegalStateException(
          "hub_v2.CREATE_FAILURE_CONDITION_WONT_REVERT_xor_ICPX has not been filled");
    }

    if (!filled.get(64)) {
      throw new IllegalStateException(
          "hub_v2.CREATE_NONEMPTY_INIT_CODE_FAILURE_WILL_REVERT_xor_INVALID_FLAG has not been filled");
    }

    if (!filled.get(65)) {
      throw new IllegalStateException(
          "hub_v2.CREATE_NONEMPTY_INIT_CODE_FAILURE_WONT_REVERT_xor_JUMPX has not been filled");
    }

    if (!filled.get(66)) {
      throw new IllegalStateException(
          "hub_v2.CREATE_NONEMPTY_INIT_CODE_SUCCESS_WILL_REVERT_xor_JUMP_DESTINATION_VETTING_REQUIRED has not been filled");
    }

    if (!filled.get(67)) {
      throw new IllegalStateException(
          "hub_v2.CREATE_NONEMPTY_INIT_CODE_SUCCESS_WONT_REVERT_xor_JUMP_FLAG has not been filled");
    }

    if (!filled.get(124)) {
      throw new IllegalStateException(
          "hub_v2.DEPLOYMENT_NUMBER_INFTY_xor_CALL_DATA_SIZE_xor_MXP_SIZE_1_HI_xor_STACK_ITEM_HEIGHT_3_xor_LEFTOVER_GAS has not been filled");
    }

    if (!filled.get(125)) {
      throw new IllegalStateException(
          "hub_v2.DEPLOYMENT_NUMBER_NEW_xor_CALL_STACK_DEPTH_xor_MXP_SIZE_1_LO_xor_STACK_ITEM_HEIGHT_4_xor_NONCE has not been filled");
    }

    if (!filled.get(123)) {
      throw new IllegalStateException(
          "hub_v2.DEPLOYMENT_NUMBER_xor_CALL_DATA_OFFSET_xor_MXP_OFFSET_2_LO_xor_STACK_ITEM_HEIGHT_2_xor_INIT_CODE_SIZE has not been filled");
    }

    if (!filled.get(48)) {
      throw new IllegalStateException(
          "hub_v2.DEPLOYMENT_STATUS_INFTY_xor_IS_STATIC_xor_EXP_FLAG_xor_CALL_EOA_SUCCESS_CALLER_WILL_REVERT_xor_ADD_FLAG_xor_VAL_CURR_IS_ORIG_xor_IS_DEPLOYMENT has not been filled");
    }

    if (!filled.get(49)) {
      throw new IllegalStateException(
          "hub_v2.DEPLOYMENT_STATUS_NEW_xor_UPDATE_xor_MMU_FLAG_xor_CALL_EOA_SUCCESS_CALLER_WONT_REVERT_xor_BIN_FLAG_xor_VAL_CURR_IS_ZERO_xor_IS_TYPE2 has not been filled");
    }

    if (!filled.get(47)) {
      throw new IllegalStateException(
          "hub_v2.DEPLOYMENT_STATUS_xor_IS_ROOT_xor_CCSR_FLAG_xor_CALL_ABORT_xor_ACC_FLAG_xor_VAL_CURR_CHANGES_xor_COPY_TXCD_AT_INITIALIZATION has not been filled");
    }

    if (!filled.get(13)) {
      throw new IllegalStateException("hub_v2.CONTEXT_SELF_REVERTS_FLAG has not been filled");
    }

    if (!filled.get(14)) {
      throw new IllegalStateException("hub_v2.EXCEPTION_AHOY has not been filled");
    }

    if (!filled.get(51)) {
      throw new IllegalStateException(
          "hub_v2.EXISTS_NEW_xor_MXP_DEPLOYS_xor_CALL_PRC_FAILURE_xor_CALL_FLAG_xor_VAL_NEXT_IS_ORIG_xor_STATUS_CODE has not been filled");
    }

    if (!filled.get(50)) {
      throw new IllegalStateException(
          "hub_v2.EXISTS_xor_MMU_SUCCESS_BIT_xor_CALL_EXCEPTION_xor_BTC_FLAG_xor_VAL_NEXT_IS_CURR_xor_REQUIRES_EVM_EXECUTION has not been filled");
    }

    if (!filled.get(96)) {
      throw new IllegalStateException("hub_v2.EXP_INST_xor_PRC_CALLEE_GAS has not been filled");
    }

    if (!filled.get(15)) {
      throw new IllegalStateException("hub_v2.COUNTER_NSR has not been filled");
    }

    if (!filled.get(16)) {
      throw new IllegalStateException("hub_v2.GAS_COST has not been filled");
    }

    if (!filled.get(17)) {
      throw new IllegalStateException("hub_v2.GAS_EXPECTED has not been filled");
    }

    if (!filled.get(18)) {
      throw new IllegalStateException("hub_v2.GAS_NEXT has not been filled");
    }

    if (!filled.get(53)) {
      throw new IllegalStateException(
          "hub_v2.HAS_CODE_NEW_xor_MXP_MXPX_xor_CALL_PRC_SUCCESS_CALLER_WONT_REVERT_xor_COPY_FLAG_xor_VAL_ORIG_IS_ZERO has not been filled");
    }

    if (!filled.get(52)) {
      throw new IllegalStateException(
          "hub_v2.HAS_CODE_xor_MXP_FLAG_xor_CALL_PRC_SUCCESS_CALLER_WILL_REVERT_xor_CON_FLAG_xor_VAL_NEXT_IS_ZERO has not been filled");
    }

    if (!filled.get(19)) {
      throw new IllegalStateException("hub_v2.HASH_INFO_STAMP has not been filled");
    }

    if (!filled.get(20)) {
      throw new IllegalStateException("hub_v2.HEIGHT has not been filled");
    }

    if (!filled.get(21)) {
      throw new IllegalStateException("hub_v2.HEIGHT_NEW has not been filled");
    }

    if (!filled.get(22)) {
      throw new IllegalStateException("hub_v2.HUB_STAMP has not been filled");
    }

    if (!filled.get(23)) {
      throw new IllegalStateException("hub_v2.HUB_STAMP_TRANSACTION_END has not been filled");
    }

    if (!filled.get(54)) {
      throw new IllegalStateException(
          "hub_v2.IS_PRECOMPILE_xor_OOB_FLAG_xor_CALL_SMC_FAILURE_CALLER_WILL_REVERT_xor_CREATE_FLAG_xor_WARM has not been filled");
    }

    if (!filled.get(24)) {
      throw new IllegalStateException("hub_v2.LOG_INFO_STAMP has not been filled");
    }

    if (!filled.get(56)) {
      throw new IllegalStateException(
          "hub_v2.MARKED_FOR_SELFDESTRUCT_NEW_xor_STP_FLAG_xor_CALL_SMC_SUCCESS_CALLER_WILL_REVERT_xor_DEC_FLAG_2 has not been filled");
    }

    if (!filled.get(55)) {
      throw new IllegalStateException(
          "hub_v2.MARKED_FOR_SELFDESTRUCT_xor_STP_EXISTS_xor_CALL_SMC_FAILURE_CALLER_WONT_REVERT_xor_DEC_FLAG_1_xor_WARM_NEW has not been filled");
    }

    if (!filled.get(97)) {
      throw new IllegalStateException("hub_v2.MMU_AUX_ID_xor_PRC_CALLER_GAS has not been filled");
    }

    if (!filled.get(98)) {
      throw new IllegalStateException("hub_v2.MMU_EXO_SUM_xor_PRC_CDO has not been filled");
    }

    if (!filled.get(99)) {
      throw new IllegalStateException("hub_v2.MMU_INST_xor_PRC_CDS has not been filled");
    }

    if (!filled.get(107)) {
      throw new IllegalStateException("hub_v2.MMU_LIMB_1 has not been filled");
    }

    if (!filled.get(108)) {
      throw new IllegalStateException("hub_v2.MMU_LIMB_2 has not been filled");
    }

    if (!filled.get(100)) {
      throw new IllegalStateException("hub_v2.MMU_PHASE_xor_PRC_RAC has not been filled");
    }

    if (!filled.get(101)) {
      throw new IllegalStateException("hub_v2.MMU_REF_OFFSET_xor_PRC_RAO has not been filled");
    }

    if (!filled.get(102)) {
      throw new IllegalStateException("hub_v2.MMU_REF_SIZE_xor_PRC_RETURN_GAS has not been filled");
    }

    if (!filled.get(103)) {
      throw new IllegalStateException("hub_v2.MMU_SIZE has not been filled");
    }

    if (!filled.get(104)) {
      throw new IllegalStateException("hub_v2.MMU_SRC_ID has not been filled");
    }

    if (!filled.get(109)) {
      throw new IllegalStateException("hub_v2.MMU_SRC_OFFSET_HI has not been filled");
    }

    if (!filled.get(110)) {
      throw new IllegalStateException("hub_v2.MMU_SRC_OFFSET_LO has not been filled");
    }

    if (!filled.get(25)) {
      throw new IllegalStateException("hub_v2.MMU_STAMP has not been filled");
    }

    if (!filled.get(105)) {
      throw new IllegalStateException("hub_v2.MMU_TGT_ID has not been filled");
    }

    if (!filled.get(111)) {
      throw new IllegalStateException("hub_v2.MMU_TGT_OFFSET_LO has not been filled");
    }

    if (!filled.get(26)) {
      throw new IllegalStateException("hub_v2.MXP_STAMP has not been filled");
    }

    if (!filled.get(127)) {
      throw new IllegalStateException(
          "hub_v2.NONCE_NEW_xor_CONTEXT_NUMBER_xor_MXP_SIZE_2_LO_xor_STACK_ITEM_STAMP_2_xor_REFUND_COUNTER_INFINITY has not been filled");
    }

    if (!filled.get(126)) {
      throw new IllegalStateException(
          "hub_v2.NONCE_xor_CALL_VALUE_xor_MXP_SIZE_2_HI_xor_STACK_ITEM_STAMP_1_xor_REFUND_AMOUNT has not been filled");
    }

    if (!filled.get(27)) {
      throw new IllegalStateException("hub_v2.NUMBER_OF_NON_STACK_ROWS has not been filled");
    }

    if (!filled.get(136)) {
      throw new IllegalStateException(
          "hub_v2.OOB_DATA_8_xor_STACK_ITEM_VALUE_LO_3 has not been filled");
    }

    if (!filled.get(106)) {
      throw new IllegalStateException("hub_v2.OOB_INST has not been filled");
    }

    if (!filled.get(28)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_ACCOUNT has not been filled");
    }

    if (!filled.get(29)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_CONTEXT has not been filled");
    }

    if (!filled.get(30)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_MISCELLANEOUS has not been filled");
    }

    if (!filled.get(31)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_SCENARIO has not been filled");
    }

    if (!filled.get(32)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_STACK has not been filled");
    }

    if (!filled.get(33)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_STORAGE has not been filled");
    }

    if (!filled.get(34)) {
      throw new IllegalStateException("hub_v2.PEEK_AT_TRANSACTION has not been filled");
    }

    if (!filled.get(68)) {
      throw new IllegalStateException("hub_v2.PRC_BLAKE2f_xor_KEC_FLAG has not been filled");
    }

    if (!filled.get(69)) {
      throw new IllegalStateException(
          "hub_v2.CREATE_NONEMPTY_INIT_CODE_FAILURE_WILL_REVERT_xor_KEC_FLAG has not been filled");
    }

    if (!filled.get(70)) {
      throw new IllegalStateException(
          "hub_v2.CREATE_NONEMPTY_INIT_CODE_FAILURE_WONT_REVERT_xor_LOG_FLAG has not been filled");
    }

    if (!filled.get(71)) {
      throw new IllegalStateException(
          "hub_v2.PRC_ECPAIRING_xor_MACHINE_STATE_FLAG has not been filled");
    }

    if (!filled.get(72)) {
      throw new IllegalStateException(
          "hub_v2.CREATE_NONEMPTY_INIT_CODE_SUCCESS_WONT_REVERT_xor_MAXCSX has not been filled");
    }

    if (!filled.get(121)) {
      throw new IllegalStateException(
          "hub_v2.DEP_NUM_NEW_xor_CALL_STACK_DEPTH_xor_MXP___INST_xor_STACK_ITEM_HEIGHT_3_xor_INIT_GAS has not been filled");
    }

    if (!filled.get(120)) {
      throw new IllegalStateException(
          "hub_v2.DEP_NUM_xor_CALL_DATA_SIZE_xor_MXP___GAS_MXP_xor_STACK_ITEM_HEIGHT_2_xor_INIT_CODE_SIZE has not been filled");
    }

    if (!filled.get(50)) {
      throw new IllegalStateException(
          "hub_v2.DEP_STATUS_NEW_xor_MMU___FLAG_xor_CALL_EOA_SUCCESS_CALLER_WILL_REVERT_xor_BIN_FLAG_xor_VAL_CURR_IS_ZERO_xor_STATUS_CODE has not been filled");
    }

    if (!filled.get(49)) {
      throw new IllegalStateException(
          "hub_v2.DEP_STATUS_xor_EXP___FLAG_xor_CALL_ABORT_xor_ADD_FLAG_xor_VAL_CURR_IS_ORIG_xor_IS_EIP1559 has not been filled");
    }

    if (!filled.get(119)) {
      throw new IllegalStateException(
          "hub_v2.DEPLOYMENT_NUMBER_INFTY_xor_CALL_DATA_OFFSET_xor_MMU___TGT_OFFSET_LO_xor_STACK_ITEM_HEIGHT_1_xor_VAL_ORIG_LO_xor_INITIAL_BALANCE has not been filled");
    }

    if (!filled.get(48)) {
      throw new IllegalStateException(
          "hub_v2.DEPLOYMENT_STATUS_INFTY_xor_UPDATE_xor_CCSR_FLAG_xor_BLAKE2f_xor_ACC_FLAG_xor_VAL_CURR_CHANGES_xor_IS_DEPLOYMENT has not been filled");
    }

    if (!filled.get(17)) {
      throw new IllegalStateException("hub_v2.DOM_STAMP has not been filled");
    }

    if (!filled.get(73)) {
      throw new IllegalStateException(
          "hub_v2.PRC_FAILURE_KNOWN_TO_HUB_xor_MOD_FLAG has not been filled");
    }

    if (!filled.get(74)) {
      throw new IllegalStateException(
          "hub_v2.PRC_FAILURE_KNOWN_TO_RAM_xor_MUL_FLAG has not been filled");
    }

    if (!filled.get(75)) {
      throw new IllegalStateException("hub_v2.ECPAIRING_xor_MXPX has not been filled");
    }

    if (!filled.get(76)) {
      throw new IllegalStateException("hub_v2.ECRECOVER_xor_MXP_FLAG has not been filled");
    }

    if (!filled.get(18)) {
      throw new IllegalStateException("hub_v2.EXCEPTION_AHOY_FLAG has not been filled");
    }

    if (!filled.get(52)) {
      throw new IllegalStateException(
          "hub_v2.EXISTS_NEW_xor_MXP___DEPLOYS_xor_CALL_EXCEPTION_xor_CALL_FLAG_xor_VAL_NEXT_IS_ORIG has not been filled");
    }

    if (!filled.get(51)) {
      throw new IllegalStateException(
          "hub_v2.EXISTS_xor_MMU___SUCCESS_BIT_xor_CALL_EOA_SUCCESS_CALLER_WONT_REVERT_xor_BTC_FLAG_xor_VAL_NEXT_IS_CURR_xor_TXN_REQUIRES_EVM_EXECUTION has not been filled");
    }

    if (!filled.get(98)) {
      throw new IllegalStateException("hub_v2.EXP___INST_xor_PRC_CALLEE_GAS has not been filled");
    }

    if (!filled.get(19)) {
      throw new IllegalStateException("hub_v2.GAS_ACTUAL has not been filled");
    }

    if (!filled.get(20)) {
      throw new IllegalStateException("hub_v2.GAS_COST has not been filled");
    }

    if (!filled.get(21)) {
      throw new IllegalStateException("hub_v2.GAS_EXPECTED has not been filled");
    }

    if (!filled.get(22)) {
      throw new IllegalStateException("hub_v2.GAS_NEXT has not been filled");
    }

    if (!filled.get(23)) {
      throw new IllegalStateException("hub_v2.GAS_REFUND has not been filled");
    }

    if (!filled.get(24)) {
      throw new IllegalStateException("hub_v2.GAS_REFUND_NEW has not been filled");
    }

    if (!filled.get(54)) {
      throw new IllegalStateException(
          "hub_v2.HAS_CODE_NEW_xor_MXP___MXPX_xor_CALL_PRC_SUCCESS_CALLER_WILL_REVERT_xor_COPY_FLAG_xor_VAL_ORIG_IS_ZERO has not been filled");
    }

    if (!filled.get(53)) {
      throw new IllegalStateException(
          "hub_v2.HAS_CODE_xor_MXP___FLAG_xor_CALL_PRC_FAILURE_xor_CON_FLAG_xor_VAL_NEXT_IS_ZERO has not been filled");
    }

    if (!filled.get(25)) {
      throw new IllegalStateException("hub_v2.HASH_INFO_STAMP has not been filled");
    }

    if (!filled.get(26)) {
      throw new IllegalStateException("hub_v2.HUB_STAMP has not been filled");
    }

    if (!filled.get(27)) {
      throw new IllegalStateException("hub_v2.HUB_STAMP_TRANSACTION_END has not been filled");
    }

    if (!filled.get(77)) {
      throw new IllegalStateException("hub_v2.IDENTITY_xor_OOB_FLAG has not been filled");
    }

    if (!filled.get(55)) {
      throw new IllegalStateException(
          "hub_v2.IS_BLAKE2f_xor_OOB___FLAG_xor_CALL_PRC_SUCCESS_CALLER_WONT_REVERT_xor_CREATE_FLAG_xor_WARM has not been filled");
    }

    if (!filled.get(79)) {
      throw new IllegalStateException(
          "hub_v2.PRC_SUCCESS_WILL_REVERT_xor_PUSHPOP_FLAG has not been filled");
    }

    if (!filled.get(80)) {
      throw new IllegalStateException(
          "hub_v2.PRC_SUCCESS_WONT_REVERT_xor_RDCX has not been filled");
    }

    if (!filled.get(35)) {
      throw new IllegalStateException("hub_v2.PROGRAM_COUNTER has not been filled");
    }

    if (!filled.get(36)) {
      throw new IllegalStateException("hub_v2.PROGRAM_COUNTER_NEW has not been filled");
    }

    if (!filled.get(37)) {
      throw new IllegalStateException("hub_v2.REFGAS has not been filled");
    }

    if (!filled.get(38)) {
      throw new IllegalStateException("hub_v2.REFGAS_NEW has not been filled");
    }

    if (!filled.get(81)) {
      throw new IllegalStateException(
          "hub_v2.RETURN_DEPLOYMENT_EMPTY_CODE_WILL_REVERT_xor_SHF_FLAG has not been filled");
    }

    if (!filled.get(82)) {
      throw new IllegalStateException(
          "hub_v2.RETURN_DEPLOYMENT_EMPTY_CODE_WONT_REVERT_xor_SOX has not been filled");
    }

    if (!filled.get(83)) {
      throw new IllegalStateException(
          "hub_v2.RETURN_DEPLOYMENT_NONEMPTY_CODE_WILL_REVERT_xor_SSTOREX has not been filled");
    }

    if (!filled.get(84)) {
      throw new IllegalStateException(
          "hub_v2.RETURN_DEPLOYMENT_NONEMPTY_CODE_WONT_REVERT_xor_STACKRAM_FLAG has not been filled");
    }

    if (!filled.get(85)) {
      throw new IllegalStateException(
          "hub_v2.RETURN_EXCEPTION_xor_STACK_ITEM_POP_1 has not been filled");
    }

    if (!filled.get(86)) {
      throw new IllegalStateException(
          "hub_v2.RETURN_MESSAGE_CALL_WILL_TOUCH_RAM_xor_STACK_ITEM_POP_2 has not been filled");
    }

    if (!filled.get(87)) {
      throw new IllegalStateException(
          "hub_v2.RETURN_MESSAGE_CALL_WONT_TOUCH_RAM_xor_STACK_ITEM_POP_3 has not been filled");
    }

    if (!filled.get(128)) {
      throw new IllegalStateException(
          "hub_v2.RLPADDR_DEP_ADDR_HI_xor_RETURNER_CONTEXT_NUMBER_xor_MXP_WORDS_xor_STACK_ITEM_STAMP_3_xor_TO_ADDRESS_HI has not been filled");
    }

    if (!filled.get(129)) {
      throw new IllegalStateException(
          "hub_v2.RLPADDR_DEP_ADDR_LO_xor_RETURN_AT_CAPACITY_xor_OOB_DATA_1_xor_STACK_ITEM_STAMP_4_xor_TO_ADDRESS_LO has not been filled");
    }

    if (!filled.get(57)) {
      throw new IllegalStateException(
          "hub_v2.RLPADDR_FLAG_xor_STP_OOGX_xor_CALL_SMC_SUCCESS_CALLER_WONT_REVERT_xor_DEC_FLAG_3 has not been filled");
    }

    if (!filled.get(130)) {
      throw new IllegalStateException(
          "hub_v2.RLPADDR_KEC_HI_xor_RETURN_AT_OFFSET_xor_OOB_DATA_2_xor_STACK_ITEM_VALUE_HI_1_xor_VALUE has not been filled");
    }

    if (!filled.get(131)) {
      throw new IllegalStateException(
          "hub_v2.RLPADDR_KEC_LO_xor_RETURN_DATA_OFFSET_xor_OOB_DATA_3_xor_STACK_ITEM_VALUE_HI_2 has not been filled");
    }

    if (!filled.get(132)) {
      throw new IllegalStateException(
          "hub_v2.RLPADDR_RECIPE_xor_RETURN_DATA_SIZE_xor_OOB_DATA_4_xor_STACK_ITEM_VALUE_HI_3 has not been filled");
    }

    if (!filled.get(133)) {
      throw new IllegalStateException(
          "hub_v2.RLPADDR_SALT_HI_xor_OOB_DATA_5_xor_STACK_ITEM_VALUE_HI_4 has not been filled");
    }

    if (!filled.get(134)) {
      throw new IllegalStateException(
          "hub_v2.RLPADDR_SALT_LO_xor_OOB_DATA_6_xor_STACK_ITEM_VALUE_LO_1 has not been filled");
    }

    if (!filled.get(58)) {
      throw new IllegalStateException(
          "hub_v2.ROM_LEX_FLAG_xor_STP_WARMTH_xor_CREATE_ABORT_xor_DEC_FLAG_4 has not been filled");
    }

    if (!filled.get(88)) {
      throw new IllegalStateException("hub_v2.STACK_ITEM_POP_4 has not been filled");
    }

    if (!filled.get(90)) {
      throw new IllegalStateException("hub_v2.STATIC_FLAG has not been filled");
    }

    if (!filled.get(89)) {
      throw new IllegalStateException("hub_v2.STATICX has not been filled");
    }

    if (!filled.get(91)) {
      throw new IllegalStateException("hub_v2.STO_FLAG has not been filled");
    }

    if (!filled.get(137)) {
      throw new IllegalStateException(
          "hub_v2.STP_GAS_HI_xor_STACK_ITEM_VALUE_LO_4 has not been filled");
    }

    if (!filled.get(138)) {
      throw new IllegalStateException("hub_v2.STP_GAS_LO_xor_STATIC_GAS has not been filled");
    }

    if (!filled.get(139)) {
      throw new IllegalStateException("hub_v2.STP_GAS_PAID_OUT_OF_POCKET has not been filled");
    }

    if (!filled.get(140)) {
      throw new IllegalStateException("hub_v2.STP_GAS_STIPEND has not been filled");
    }

    if (!filled.get(141)) {
      throw new IllegalStateException("hub_v2.STP_GAS_UPFRONT_GAS_COST has not been filled");
    }

    if (!filled.get(142)) {
      throw new IllegalStateException("hub_v2.STP_INST has not been filled");
    }

    if (!filled.get(143)) {
      throw new IllegalStateException("hub_v2.STP_VAL_HI has not been filled");
    }

    if (!filled.get(144)) {
      throw new IllegalStateException("hub_v2.STP_VAL_LO has not been filled");
    }

    if (!filled.get(39)) {
      throw new IllegalStateException("hub_v2.SUB_STAMP has not been filled");
    }

    if (!filled.get(92)) {
      throw new IllegalStateException("hub_v2.SUX has not been filled");
    }

    if (!filled.get(93)) {
      throw new IllegalStateException("hub_v2.SWAP_FLAG has not been filled");
    }

    if (!filled.get(40)) {
      throw new IllegalStateException("hub_v2.TRANSACTION_REVERTS has not been filled");
    }

    if (!filled.get(59)) {
      throw new IllegalStateException(
          "hub_v2.TRM_FLAG_xor_CREATE_EMPTY_INIT_CODE_WILL_REVERT_xor_DUP_FLAG has not been filled");
    }

    if (!filled.get(135)) {
      throw new IllegalStateException(
          "hub_v2.TRM_RAW_ADDR_HI_xor_OOB_DATA_7_xor_STACK_ITEM_VALUE_LO_2 has not been filled");
    }

    if (!filled.get(41)) {
      throw new IllegalStateException("hub_v2.TWO_LINE_INSTRUCTION has not been filled");
    }

    if (!filled.get(42)) {
      throw new IllegalStateException("hub_v2.TX_EXEC has not been filled");
    }

    if (!filled.get(43)) {
      throw new IllegalStateException("hub_v2.TX_FINL has not been filled");
    }

    if (!filled.get(44)) {
      throw new IllegalStateException("hub_v2.TX_INIT has not been filled");
    }

    if (!filled.get(45)) {
      throw new IllegalStateException("hub_v2.TX_SKIP has not been filled");
    }

    if (!filled.get(46)) {
      throw new IllegalStateException("hub_v2.TX_WARM has not been filled");
    }

    if (!filled.get(94)) {
      throw new IllegalStateException("hub_v2.TXN_FLAG has not been filled");
    }

    if (!filled.get(61)) {
      throw new IllegalStateException(
          "hub_v2.WARM_NEW_xor_CREATE_EXCEPTION_xor_HALT_FLAG has not been filled");
    }

    if (!filled.get(60)) {
      throw new IllegalStateException(
          "hub_v2.WARM_xor_CREATE_EMPTY_INIT_CODE_WONT_REVERT_xor_EXT_FLAG has not been filled");
    }

    if (!filled.get(95)) {
      throw new IllegalStateException("hub_v2.TRM_FLAG has not been filled");
    }

    if (!filled.get(66)) {
      throw new IllegalStateException(
          "hub_v2.TRM___FLAG_xor_CREATE_EXCEPTION_xor_JUMPX has not been filled");
    }

    if (!filled.get(131)) {
      throw new IllegalStateException(
          "hub_v2.TRM___RAW_ADDR_HI_xor_OOB____DATA_1_xor_STACK_ITEM_VALUE_LO_1 has not been filled");
    }

    if (!filled.get(42)) {
      throw new IllegalStateException("hub_v2.TWO_LINE_INSTRUCTION has not been filled");
    }

    if (!filled.get(43)) {
      throw new IllegalStateException("hub_v2.TX_EXEC has not been filled");
    }

    if (!filled.get(44)) {
      throw new IllegalStateException("hub_v2.TX_FINL has not been filled");
    }

    if (!filled.get(45)) {
      throw new IllegalStateException("hub_v2.TX_INIT has not been filled");
    }

    if (!filled.get(46)) {
      throw new IllegalStateException("hub_v2.TX_SKIP has not been filled");
    }

    if (!filled.get(47)) {
      throw new IllegalStateException("hub_v2.TX_WARM has not been filled");
    }

    if (!filled.get(96)) {
      throw new IllegalStateException("hub_v2.TXN_FLAG has not been filled");
    }

    if (!filled.get(68)) {
      throw new IllegalStateException(
          "hub_v2.WARM_NEW_xor_CREATE_FAILURE_CONDITION_WONT_REVERT_xor_JUMP_FLAG has not been filled");
    }

    if (!filled.get(67)) {
      throw new IllegalStateException(
          "hub_v2.WARM_xor_CREATE_FAILURE_CONDITION_WILL_REVERT_xor_JUMP_DESTINATION_VETTING_REQUIRED has not been filled");
    }

    if (!filled.get(97)) {
      throw new IllegalStateException("hub_v2.WCP_FLAG has not been filled");
    }

    filled.clear();
    this.currentLine++;

    return this;
  }

  public Trace fillAndValidateRow() {
    if (!filled.get(0)) {
      absoluteTransactionNumber.position(absoluteTransactionNumber.position() + 32);
    }

    if (!filled.get(109)) {
      addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.position(
          addrHiXorAccountAddressHiXorCcrsStampXorHashInfoKecHiXorAddressHiXorBasefee.position()
              + 32);
    }

    if (!filled.get(110)) {
      addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.position(
          addrLoXorAccountAddressLoXorExpData1XorHashInfoKecLoXorAddressLoXorCallDataSize.position()
              + 32);
    }

    if (!filled.get(112)) {
      addressHiXorAccountAddressHiXorCcrsStampXorAlphaXorAddressHiXorBasefee.position(
          addressHiXorAccountAddressHiXorCcrsStampXorAlphaXorAddressHiXorBasefee.position() + 32);
    }

    if (!filled.get(113)) {
      addressLoXorAccountAddressLoXorExpData1XorDeltaXorAddressLoXorBatchNum.position(
          addressLoXorAccountAddressLoXorExpData1XorDeltaXorAddressLoXorBatchNum.position() + 32);
    }

    if (!filled.get(115)) {
      balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
          .position(
              balanceNewXorByteCodeAddressHiXorExpData3XorHashInfoKecLoXorStorageKeyHiXorCoinbaseAddressHi
                      .position()
                  + 32);
    }

    if (!filled.get(114)) {
      balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
          .position(
              balanceXorAccountDeploymentNumberXorExpData2XorHashInfoKecHiXorDeploymentNumberXorCallDataSize
                      .position()
                  + 32);
    }

    if (!filled.get(1)) {
      batchNumber.position(batchNumber.position() + 32);
    }

    if (!filled.get(2)) {
      callerContextNumber.position(callerContextNumber.position() + 32);
    }

    if (!filled.get(3)) {
      codeFragmentIndex.position(codeFragmentIndex.position() + 32);
    }

    if (!filled.get(116)) {
      codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
          .position(
              codeFragmentIndexXorByteCodeAddressLoXorExpData4XorHashInfoSizeXorStorageKeyLoXorCoinbaseAddressLo
                      .position()
                  + 32);
    }

    if (!filled.get(118)) {
      codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo
          .position(
              codeHashHiNewXorByteCodeDeploymentNumberXorMxpGasMxpXorNbAddedXorValCurrLoXorFromAddressLo
                      .position()
                  + 32);
    }

    if (!filled.get(117)) {
      codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi
          .position(
              codeHashHiXorByteCodeCodeFragmentIndexXorExpData5XorInstructionXorValCurrHiXorFromAddressHi
                      .position()
                  + 32);
    }

    if (!filled.get(120)) {
      codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice.position(
          codeHashLoNewXorCallerAddressHiXorMxpOffset1HiXorPushValueHiXorValNextLoXorGasPrice
                  .position()
              + 32);
    }

    if (!filled.get(119)) {
      codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit.position(
          codeHashLoXorByteCodeDeploymentStatusXorMxpInstXorNbRemovedXorValNextHiXorGasLimit
                  .position()
              + 32);
    }

    if (!filled.get(122)) {
      codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
          .position(
              codeSizeNewXorCallerContextNumberXorMxpOffset2HiXorStackItemHeight1XorValOrigLoXorInitialGas
                      .position()
                  + 32);
    }

    if (!filled.get(121)) {
      codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance.position(
          codeSizeXorCallerAddressLoXorMxpOffset1LoXorPushValueLoXorValOrigHiXorInitialBalance
                  .position()
              + 32);
    }

    if (!filled.get(4)) {
      codeAddressLo.position(codeAddressLo.position() + 32);
    }

    if (!filled.get(5)) {
      codeDeploymentNumber.position(codeDeploymentNumber.position() + 32);
    }

    if (!filled.get(6)) {
      codeDeploymentStatus.position(codeDeploymentStatus.position() + 1);
    }

    if (!filled.get(7)) {
      codeFragmentIndex.position(codeFragmentIndex.position() + 32);
    }

    if (!filled.get(114)) {
      codeHashHiNewXorByteCodeDeploymentNumberXorExpData5XorHeightOverXorValCurrHiXorFromAddressLo
          .position(
              codeHashHiNewXorByteCodeDeploymentNumberXorExpData5XorHeightOverXorValCurrHiXorFromAddressLo
                      .position()
                  + 32);
    }

    if (!filled.get(113)) {
      codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi.position(
          codeHashHiXorByteCodeAddressLoXorExpData4XorHeightNewXorStorageKeyLoXorFromAddressHi
                  .position()
              + 32);
    }

    if (!filled.get(116)) {
      codeHashLoNewXorCallerAddressHiXorMmuLimb2XorInstXorValNextHiXorGasPrice.position(
          codeHashLoNewXorCallerAddressHiXorMmuLimb2XorInstXorValNextHiXorGasPrice.position() + 32);
    }

    if (!filled.get(115)) {
      codeHashLoXorByteCodeDeploymentStatusXorMmuLimb1XorHeightUnderXorValCurrLoXorGasLimit
          .position(
              codeHashLoXorByteCodeDeploymentStatusXorMmuLimb1XorHeightUnderXorValCurrLoXorGasLimit
                      .position()
                  + 32);
    }

    if (!filled.get(118)) {
      codeSizeNewXorCallerContextNumberXorMmuSrcOffsetLoXorPushValueLoXorValOrigHiXorGasRefundCounterFinal
          .position(
              codeSizeNewXorCallerContextNumberXorMmuSrcOffsetLoXorPushValueLoXorValOrigHiXorGasRefundCounterFinal
                      .position()
                  + 32);
    }

    if (!filled.get(117)) {
      codeSizeXorCallerAddressLoXorMmuSrcOffsetHiXorPushValueHiXorValNextLoXorGasRefundAmount
          .position(
              codeSizeXorCallerAddressLoXorMmuSrcOffsetHiXorPushValueHiXorValNextLoXorGasRefundAmount
                      .position()
                  + 32);
    }

    if (!filled.get(8)) {
      contextGetsRevertedFlag.position(contextGetsRevertedFlag.position() + 1);
    }

    if (!filled.get(9)) {
      contextMayChangeFlag.position(contextMayChangeFlag.position() + 1);
    }

    if (!filled.get(10)) {
      contextNumber.position(contextNumber.position() + 32);
    }

    if (!filled.get(11)) {
      contextNumberNew.position(contextNumberNew.position() + 32);
    }

    if (!filled.get(12)) {
      counterTli.position(counterTli.position() + 1);
    }

    if (!filled.get(62)) {
      createFailureConditionWillRevertXorHashInfoFlag.position(
          createFailureConditionWillRevertXorHashInfoFlag.position() + 1);
    }

    if (!filled.get(63)) {
      createFailureConditionWontRevertXorIcpx.position(
          createFailureConditionWontRevertXorIcpx.position() + 1);
    }

    if (!filled.get(64)) {
      createNonemptyInitCodeFailureWillRevertXorInvalidFlag.position(
          createNonemptyInitCodeFailureWillRevertXorInvalidFlag.position() + 1);
    }

    if (!filled.get(65)) {
      createNonemptyInitCodeFailureWontRevertXorJumpx.position(
          createNonemptyInitCodeFailureWontRevertXorJumpx.position() + 1);
    }

    if (!filled.get(66)) {
      createNonemptyInitCodeSuccessWillRevertXorJumpDestinationVettingRequired.position(
          createNonemptyInitCodeSuccessWillRevertXorJumpDestinationVettingRequired.position() + 1);
    }

    if (!filled.get(67)) {
      createNonemptyInitCodeSuccessWontRevertXorJumpFlag.position(
          createNonemptyInitCodeSuccessWontRevertXorJumpFlag.position() + 1);
    }

    if (!filled.get(124)) {
      deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas.position(
          deploymentNumberInftyXorCallDataSizeXorMxpSize1HiXorStackItemHeight3XorLeftoverGas
                  .position()
              + 32);
    }

    if (!filled.get(125)) {
      deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce.position(
          deploymentNumberNewXorCallStackDepthXorMxpSize1LoXorStackItemHeight4XorNonce.position()
              + 32);
    }

    if (!filled.get(123)) {
      deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize.position(
          deploymentNumberXorCallDataOffsetXorMxpOffset2LoXorStackItemHeight2XorInitCodeSize
                  .position()
              + 32);
    }

    if (!filled.get(48)) {
      deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment
          .position(
              deploymentStatusInftyXorIsStaticXorExpFlagXorCallEoaSuccessCallerWillRevertXorAddFlagXorValCurrIsOrigXorIsDeployment
                      .position()
                  + 1);
    }

    if (!filled.get(49)) {
      deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2
          .position(
              deploymentStatusNewXorUpdateXorMmuFlagXorCallEoaSuccessCallerWontRevertXorBinFlagXorValCurrIsZeroXorIsType2
                      .position()
                  + 1);
    }

    if (!filled.get(47)) {
      deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization
          .position(
              deploymentStatusXorIsRootXorCcsrFlagXorCallAbortXorAccFlagXorValCurrChangesXorCopyTxcdAtInitialization
                      .position()
                  + 1);
    }

    if (!filled.get(13)) {
      contextSelfRevertsFlag.position(contextSelfRevertsFlag.position() + 1);
    }

    if (!filled.get(14)) {
      exceptionAhoy.position(exceptionAhoy.position() + 1);
    }

    if (!filled.get(51)) {
      existsNewXorMxpDeploysXorCallPrcFailureXorCallFlagXorValNextIsOrigXorStatusCode.position(
          existsNewXorMxpDeploysXorCallPrcFailureXorCallFlagXorValNextIsOrigXorStatusCode.position()
              + 1);
    }

    if (!filled.get(50)) {
      existsXorMmuSuccessBitXorCallExceptionXorBtcFlagXorValNextIsCurrXorRequiresEvmExecution
          .position(
              existsXorMmuSuccessBitXorCallExceptionXorBtcFlagXorValNextIsCurrXorRequiresEvmExecution
                      .position()
                  + 1);
    }

    if (!filled.get(96)) {
      expInstXorPrcCalleeGas.position(expInstXorPrcCalleeGas.position() + 8);
    }

    if (!filled.get(15)) {
      counterNsr.position(counterNsr.position() + 32);
    }

    if (!filled.get(16)) {
      gasCost.position(gasCost.position() + 32);
    }

    if (!filled.get(17)) {
      gasExpected.position(gasExpected.position() + 32);
    }

    if (!filled.get(18)) {
      gasNext.position(gasNext.position() + 32);
    }

    if (!filled.get(53)) {
      hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWontRevertXorCopyFlagXorValOrigIsZero.position(
          hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWontRevertXorCopyFlagXorValOrigIsZero
                  .position()
              + 1);
    }

    if (!filled.get(52)) {
      hasCodeXorMxpFlagXorCallPrcSuccessCallerWillRevertXorConFlagXorValNextIsZero.position(
          hasCodeXorMxpFlagXorCallPrcSuccessCallerWillRevertXorConFlagXorValNextIsZero.position()
              + 1);
    }

    if (!filled.get(19)) {
      hashInfoStamp.position(hashInfoStamp.position() + 32);
    }

    if (!filled.get(20)) {
      height.position(height.position() + 32);
    }

    if (!filled.get(21)) {
      heightNew.position(heightNew.position() + 32);
    }

    if (!filled.get(22)) {
      hubStamp.position(hubStamp.position() + 32);
    }

    if (!filled.get(23)) {
      hubStampTransactionEnd.position(hubStampTransactionEnd.position() + 32);
    }

    if (!filled.get(54)) {
      isPrecompileXorOobFlagXorCallSmcFailureCallerWillRevertXorCreateFlagXorWarm.position(
          isPrecompileXorOobFlagXorCallSmcFailureCallerWillRevertXorCreateFlagXorWarm.position()
              + 1);
    }

    if (!filled.get(24)) {
      logInfoStamp.position(logInfoStamp.position() + 32);
    }

    if (!filled.get(56)) {
      markedForSelfdestructNewXorStpFlagXorCallSmcSuccessCallerWillRevertXorDecFlag2.position(
          markedForSelfdestructNewXorStpFlagXorCallSmcSuccessCallerWillRevertXorDecFlag2.position()
              + 1);
    }

    if (!filled.get(55)) {
      markedForSelfdestructXorStpExistsXorCallSmcFailureCallerWontRevertXorDecFlag1XorWarmNew
          .position(
              markedForSelfdestructXorStpExistsXorCallSmcFailureCallerWontRevertXorDecFlag1XorWarmNew
                      .position()
                  + 1);
    }

    if (!filled.get(97)) {
      mmuAuxIdXorPrcCallerGas.position(mmuAuxIdXorPrcCallerGas.position() + 8);
    }

    if (!filled.get(98)) {
      mmuExoSumXorPrcCdo.position(mmuExoSumXorPrcCdo.position() + 8);
    }

    if (!filled.get(99)) {
      mmuInstXorPrcCds.position(mmuInstXorPrcCds.position() + 8);
    }

    if (!filled.get(107)) {
      mmuLimb1.position(mmuLimb1.position() + 32);
    }

    if (!filled.get(108)) {
      mmuLimb2.position(mmuLimb2.position() + 32);
    }

    if (!filled.get(100)) {
      mmuPhaseXorPrcRac.position(mmuPhaseXorPrcRac.position() + 8);
    }

    if (!filled.get(101)) {
      mmuRefOffsetXorPrcRao.position(mmuRefOffsetXorPrcRao.position() + 8);
    }

    if (!filled.get(102)) {
      mmuRefSizeXorPrcReturnGas.position(mmuRefSizeXorPrcReturnGas.position() + 8);
    }

    if (!filled.get(103)) {
      mmuSize.position(mmuSize.position() + 8);
    }

    if (!filled.get(104)) {
      mmuSrcId.position(mmuSrcId.position() + 8);
    }

    if (!filled.get(109)) {
      mmuSrcOffsetHi.position(mmuSrcOffsetHi.position() + 32);
    }

    if (!filled.get(110)) {
      mmuSrcOffsetLo.position(mmuSrcOffsetLo.position() + 32);
    }

    if (!filled.get(25)) {
      mmuStamp.position(mmuStamp.position() + 32);
    }

    if (!filled.get(105)) {
      mmuTgtId.position(mmuTgtId.position() + 8);
    }

    if (!filled.get(111)) {
      mmuTgtOffsetLo.position(mmuTgtOffsetLo.position() + 32);
    }

    if (!filled.get(26)) {
      mxpStamp.position(mxpStamp.position() + 32);
    }

    if (!filled.get(127)) {
      nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity.position(
          nonceNewXorContextNumberXorMxpSize2LoXorStackItemStamp2XorRefundCounterInfinity.position()
              + 32);
    }

    if (!filled.get(126)) {
      nonceXorCallValueXorMxpSize2HiXorStackItemStamp1XorRefundAmount.position(
          nonceXorCallValueXorMxpSize2HiXorStackItemStamp1XorRefundAmount.position() + 32);
    }

    if (!filled.get(27)) {
      numberOfNonStackRows.position(numberOfNonStackRows.position() + 32);
    }

    if (!filled.get(136)) {
      oobData8XorStackItemValueLo3.position(oobData8XorStackItemValueLo3.position() + 32);
    }

    if (!filled.get(106)) {
      oobInst.position(oobInst.position() + 8);
    }

    if (!filled.get(28)) {
      peekAtAccount.position(peekAtAccount.position() + 1);
    }

    if (!filled.get(29)) {
      peekAtContext.position(peekAtContext.position() + 1);
    }

    if (!filled.get(30)) {
      peekAtMiscellaneous.position(peekAtMiscellaneous.position() + 1);
    }

    if (!filled.get(31)) {
      peekAtScenario.position(peekAtScenario.position() + 1);
    }

    if (!filled.get(32)) {
      peekAtStack.position(peekAtStack.position() + 1);
    }

    if (!filled.get(33)) {
      peekAtStorage.position(peekAtStorage.position() + 1);
    }

    if (!filled.get(34)) {
      peekAtTransaction.position(peekAtTransaction.position() + 1);
    }

    if (!filled.get(68)) {
      prcBlake2FXorKecFlag.position(prcBlake2FXorKecFlag.position() + 1);
    }

    if (!filled.get(69)) {
      createNonemptyInitCodeFailureWillRevertXorKecFlag.position(
          createNonemptyInitCodeFailureWillRevertXorKecFlag.position() + 1);
    }

    if (!filled.get(70)) {
      createNonemptyInitCodeFailureWontRevertXorLogFlag.position(
          createNonemptyInitCodeFailureWontRevertXorLogFlag.position() + 1);
    }

    if (!filled.get(71)) {
      createNonemptyInitCodeSuccessWillRevertXorMachineStateFlag.position(
          createNonemptyInitCodeSuccessWillRevertXorMachineStateFlag.position() + 1);
    }

    if (!filled.get(72)) {
      createNonemptyInitCodeSuccessWontRevertXorMaxcsx.position(
          createNonemptyInitCodeSuccessWontRevertXorMaxcsx.position() + 1);
    }

    if (!filled.get(121)) {
      depNumNewXorCallStackDepthXorMxpInstXorStackItemHeight3XorInitGas.position(
          depNumNewXorCallStackDepthXorMxpInstXorStackItemHeight3XorInitGas.position() + 32);
    }

    if (!filled.get(120)) {
      depNumXorCallDataSizeXorMxpGasMxpXorStackItemHeight2XorInitCodeSize.position(
          depNumXorCallDataSizeXorMxpGasMxpXorStackItemHeight2XorInitCodeSize.position() + 32);
    }

    if (!filled.get(50)) {
      depStatusNewXorMmuFlagXorCallEoaSuccessCallerWillRevertXorBinFlagXorValCurrIsZeroXorStatusCode
          .position(
              depStatusNewXorMmuFlagXorCallEoaSuccessCallerWillRevertXorBinFlagXorValCurrIsZeroXorStatusCode
                      .position()
                  + 1);
    }

    if (!filled.get(49)) {
      depStatusXorExpFlagXorCallAbortXorAddFlagXorValCurrIsOrigXorIsEip1559.position(
          depStatusXorExpFlagXorCallAbortXorAddFlagXorValCurrIsOrigXorIsEip1559.position() + 1);
    }

    if (!filled.get(119)) {
      deploymentNumberInftyXorCallDataOffsetXorMmuTgtOffsetLoXorStackItemHeight1XorValOrigLoXorInitialBalance
          .position(
              deploymentNumberInftyXorCallDataOffsetXorMmuTgtOffsetLoXorStackItemHeight1XorValOrigLoXorInitialBalance
                      .position()
                  + 32);
    }

    if (!filled.get(48)) {
      deploymentStatusInftyXorUpdateXorCcsrFlagXorBlake2FXorAccFlagXorValCurrChangesXorIsDeployment
          .position(
              deploymentStatusInftyXorUpdateXorCcsrFlagXorBlake2FXorAccFlagXorValCurrChangesXorIsDeployment
                      .position()
                  + 1);
    }

    if (!filled.get(17)) {
      domStamp.position(domStamp.position() + 32);
    }

    if (!filled.get(73)) {
      ecaddXorModFlag.position(ecaddXorModFlag.position() + 1);
    }

    if (!filled.get(74)) {
      ecmulXorMulFlag.position(ecmulXorMulFlag.position() + 1);
    }

    if (!filled.get(75)) {
      ecpairingXorMxpx.position(ecpairingXorMxpx.position() + 1);
    }

    if (!filled.get(76)) {
      ecrecoverXorMxpFlag.position(ecrecoverXorMxpFlag.position() + 1);
    }

    if (!filled.get(18)) {
      exceptionAhoyFlag.position(exceptionAhoyFlag.position() + 1);
    }

    if (!filled.get(52)) {
      existsNewXorMxpDeploysXorCallExceptionXorCallFlagXorValNextIsOrig.position(
          existsNewXorMxpDeploysXorCallExceptionXorCallFlagXorValNextIsOrig.position() + 1);
    }

    if (!filled.get(51)) {
      existsXorMmuSuccessBitXorCallEoaSuccessCallerWontRevertXorBtcFlagXorValNextIsCurrXorTxnRequiresEvmExecution
          .position(
              existsXorMmuSuccessBitXorCallEoaSuccessCallerWontRevertXorBtcFlagXorValNextIsCurrXorTxnRequiresEvmExecution
                      .position()
                  + 1);
    }

    if (!filled.get(98)) {
      expInstXorPrcCalleeGas.position(expInstXorPrcCalleeGas.position() + 8);
    }

    if (!filled.get(19)) {
      gasActual.position(gasActual.position() + 32);
    }

    if (!filled.get(20)) {
      gasCost.position(gasCost.position() + 32);
    }

    if (!filled.get(21)) {
      gasExpected.position(gasExpected.position() + 32);
    }

    if (!filled.get(22)) {
      gasNext.position(gasNext.position() + 32);
    }

    if (!filled.get(23)) {
      gasRefund.position(gasRefund.position() + 32);
    }

    if (!filled.get(24)) {
      gasRefundNew.position(gasRefundNew.position() + 32);
    }

    if (!filled.get(54)) {
      hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWillRevertXorCopyFlagXorValOrigIsZero.position(
          hasCodeNewXorMxpMxpxXorCallPrcSuccessCallerWillRevertXorCopyFlagXorValOrigIsZero
                  .position()
              + 1);
    }

    if (!filled.get(53)) {
      hasCodeXorMxpFlagXorCallPrcFailureXorConFlagXorValNextIsZero.position(
          hasCodeXorMxpFlagXorCallPrcFailureXorConFlagXorValNextIsZero.position() + 1);
    }

    if (!filled.get(25)) {
      hashInfoStamp.position(hashInfoStamp.position() + 32);
    }

    if (!filled.get(26)) {
      hubStamp.position(hubStamp.position() + 32);
    }

    if (!filled.get(27)) {
      hubStampTransactionEnd.position(hubStampTransactionEnd.position() + 32);
    }

    if (!filled.get(77)) {
      identityXorOobFlag.position(identityXorOobFlag.position() + 1);
    }

    if (!filled.get(55)) {
      isBlake2FXorOobFlagXorCallPrcSuccessCallerWontRevertXorCreateFlagXorWarm.position(
          isBlake2FXorOobFlagXorCallPrcSuccessCallerWontRevertXorCreateFlagXorWarm.position() + 1);
    }

    if (!filled.get(79)) {
      prcSuccessWillRevertXorPushpopFlag.position(
          prcSuccessWillRevertXorPushpopFlag.position() + 1);
    }

    if (!filled.get(80)) {
      prcSuccessWontRevertXorRdcx.position(prcSuccessWontRevertXorRdcx.position() + 1);
    }

    if (!filled.get(35)) {
      programCounter.position(programCounter.position() + 32);
    }

    if (!filled.get(36)) {
      programCounterNew.position(programCounterNew.position() + 32);
    }

    if (!filled.get(37)) {
      refgas.position(refgas.position() + 32);
    }

    if (!filled.get(38)) {
      refgasNew.position(refgasNew.position() + 32);
    }

    if (!filled.get(81)) {
      returnDeploymentEmptyCodeWillRevertXorShfFlag.position(
          returnDeploymentEmptyCodeWillRevertXorShfFlag.position() + 1);
    }

    if (!filled.get(82)) {
      returnDeploymentEmptyCodeWontRevertXorSox.position(
          returnDeploymentEmptyCodeWontRevertXorSox.position() + 1);
    }

    if (!filled.get(83)) {
      returnDeploymentNonemptyCodeWillRevertXorSstorex.position(
          returnDeploymentNonemptyCodeWillRevertXorSstorex.position() + 1);
    }

    if (!filled.get(84)) {
      returnDeploymentNonemptyCodeWontRevertXorStackramFlag.position(
          returnDeploymentNonemptyCodeWontRevertXorStackramFlag.position() + 1);
    }

    if (!filled.get(85)) {
      returnExceptionXorStackItemPop1.position(returnExceptionXorStackItemPop1.position() + 1);
    }

    if (!filled.get(86)) {
      returnMessageCallWillTouchRamXorStackItemPop2.position(
          returnMessageCallWillTouchRamXorStackItemPop2.position() + 1);
    }

    if (!filled.get(87)) {
      returnMessageCallWontTouchRamXorStackItemPop3.position(
          returnMessageCallWontTouchRamXorStackItemPop3.position() + 1);
    }

    if (!filled.get(128)) {
      rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi.position(
          rlpaddrDepAddrHiXorReturnerContextNumberXorMxpWordsXorStackItemStamp3XorToAddressHi
                  .position()
              + 32);
    }

    if (!filled.get(129)) {
      rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo.position(
          rlpaddrDepAddrLoXorReturnAtCapacityXorOobData1XorStackItemStamp4XorToAddressLo.position()
              + 32);
    }

    if (!filled.get(57)) {
      rlpaddrFlagXorStpOogxXorCallSmcSuccessCallerWontRevertXorDecFlag3.position(
          rlpaddrFlagXorStpOogxXorCallSmcSuccessCallerWontRevertXorDecFlag3.position() + 1);
    }

    if (!filled.get(130)) {
      rlpaddrKecHiXorReturnAtOffsetXorOobData2XorStackItemValueHi1XorValue.position(
          rlpaddrKecHiXorReturnAtOffsetXorOobData2XorStackItemValueHi1XorValue.position() + 32);
    }

    if (!filled.get(131)) {
      rlpaddrKecLoXorReturnDataOffsetXorOobData3XorStackItemValueHi2.position(
          rlpaddrKecLoXorReturnDataOffsetXorOobData3XorStackItemValueHi2.position() + 32);
    }

    if (!filled.get(132)) {
      rlpaddrRecipeXorReturnDataSizeXorOobData4XorStackItemValueHi3.position(
          rlpaddrRecipeXorReturnDataSizeXorOobData4XorStackItemValueHi3.position() + 32);
    }

    if (!filled.get(133)) {
      rlpaddrSaltHiXorOobData5XorStackItemValueHi4.position(
          rlpaddrSaltHiXorOobData5XorStackItemValueHi4.position() + 32);
    }

    if (!filled.get(134)) {
      rlpaddrSaltLoXorOobData6XorStackItemValueLo1.position(
          rlpaddrSaltLoXorOobData6XorStackItemValueLo1.position() + 32);
    }

    if (!filled.get(58)) {
      romLexFlagXorStpWarmthXorCreateAbortXorDecFlag4.position(
          romLexFlagXorStpWarmthXorCreateAbortXorDecFlag4.position() + 1);
    }

    if (!filled.get(88)) {
      stackItemPop4.position(stackItemPop4.position() + 1);
    }

    if (!filled.get(90)) {
      staticFlag.position(staticFlag.position() + 1);
    }

    if (!filled.get(89)) {
      staticx.position(staticx.position() + 1);
    }

    if (!filled.get(91)) {
      stoFlag.position(stoFlag.position() + 1);
    }

    if (!filled.get(137)) {
      stpGasHiXorStackItemValueLo4.position(stpGasHiXorStackItemValueLo4.position() + 32);
    }

    if (!filled.get(138)) {
      stpGasLoXorStaticGas.position(stpGasLoXorStaticGas.position() + 32);
    }

    if (!filled.get(139)) {
      stpGasPaidOutOfPocket.position(stpGasPaidOutOfPocket.position() + 32);
    }

    if (!filled.get(140)) {
      stpGasStipend.position(stpGasStipend.position() + 32);
    }

    if (!filled.get(141)) {
      stpGasUpfrontGasCost.position(stpGasUpfrontGasCost.position() + 32);
    }

    if (!filled.get(142)) {
      stpInst.position(stpInst.position() + 32);
    }

    if (!filled.get(143)) {
      stpValHi.position(stpValHi.position() + 32);
    }

    if (!filled.get(144)) {
      stpValLo.position(stpValLo.position() + 32);
    }

    if (!filled.get(39)) {
      subStamp.position(subStamp.position() + 32);
    }

    if (!filled.get(92)) {
      sux.position(sux.position() + 1);
    }

    if (!filled.get(93)) {
      swapFlag.position(swapFlag.position() + 1);
    }

    if (!filled.get(40)) {
      transactionReverts.position(transactionReverts.position() + 1);
    }

    if (!filled.get(59)) {
      trmFlagXorCreateEmptyInitCodeWillRevertXorDupFlag.position(
          trmFlagXorCreateEmptyInitCodeWillRevertXorDupFlag.position() + 1);
    }

    if (!filled.get(135)) {
      trmRawAddrHiXorOobData7XorStackItemValueLo2.position(
          trmRawAddrHiXorOobData7XorStackItemValueLo2.position() + 32);
    }

    if (!filled.get(41)) {
      twoLineInstruction.position(twoLineInstruction.position() + 1);
    }

    if (!filled.get(42)) {
      txExec.position(txExec.position() + 1);
    }

    if (!filled.get(43)) {
      txFinl.position(txFinl.position() + 1);
    }

    if (!filled.get(44)) {
      txInit.position(txInit.position() + 1);
    }

    if (!filled.get(45)) {
      txSkip.position(txSkip.position() + 1);
    }

    if (!filled.get(46)) {
      txWarm.position(txWarm.position() + 1);
    }

    if (!filled.get(94)) {
      txnFlag.position(txnFlag.position() + 1);
    }

    if (!filled.get(61)) {
      warmNewXorCreateExceptionXorHaltFlag.position(
          warmNewXorCreateExceptionXorHaltFlag.position() + 1);
    }

    if (!filled.get(60)) {
      warmXorCreateEmptyInitCodeWontRevertXorExtFlag.position(
          warmXorCreateEmptyInitCodeWontRevertXorExtFlag.position() + 1);
    }

    if (!filled.get(95)) {
      trmFlag.position(trmFlag.position() + 1);
    }

    if (!filled.get(66)) {
      trmFlagXorCreateExceptionXorJumpx.position(trmFlagXorCreateExceptionXorJumpx.position() + 1);
    }

    if (!filled.get(131)) {
      trmRawAddrHiXorOobData1XorStackItemValueLo1.position(
          trmRawAddrHiXorOobData1XorStackItemValueLo1.position() + 32);
    }

    if (!filled.get(42)) {
      twoLineInstruction.position(twoLineInstruction.position() + 1);
    }

    if (!filled.get(43)) {
      txExec.position(txExec.position() + 1);
    }

    if (!filled.get(44)) {
      txFinl.position(txFinl.position() + 1);
    }

    if (!filled.get(45)) {
      txInit.position(txInit.position() + 1);
    }

    if (!filled.get(46)) {
      txSkip.position(txSkip.position() + 1);
    }

    if (!filled.get(47)) {
      txWarm.position(txWarm.position() + 1);
    }

    if (!filled.get(96)) {
      txnFlag.position(txnFlag.position() + 1);
    }

    if (!filled.get(68)) {
      warmNewXorCreateFailureConditionWontRevertXorJumpFlag.position(
          warmNewXorCreateFailureConditionWontRevertXorJumpFlag.position() + 1);
    }

    if (!filled.get(67)) {
      warmXorCreateFailureConditionWillRevertXorJumpDestinationVettingRequired.position(
          warmXorCreateFailureConditionWillRevertXorJumpDestinationVettingRequired.position() + 1);
    }

    if (!filled.get(97)) {
      wcpFlag.position(wcpFlag.position() + 1);
    }

    filled.clear();
    this.currentLine++;

    return this;
  }

  public void build() {
    if (!filled.isEmpty()) {
      throw new IllegalStateException("Cannot build trace with a non-validated row.");
    }
  }
}
