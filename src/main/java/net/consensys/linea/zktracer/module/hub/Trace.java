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

package net.consensys.linea.zktracer.module.hub;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WARNING: This code is generated automatically. Any modifications to this code may be overwritten
 * and could lead to unexpected behavior. Please DO NOT ATTEMPT TO MODIFY this code directly.
 */
public record Trace(
    @JsonProperty("ABORT_FLAG") List<Boolean> abortFlag,
    @JsonProperty("ABSOLUTE_TRANSACTION_NUMBER") List<BigInteger> absoluteTransactionNumber,
    @JsonProperty("ACC_FLAG") List<Boolean> accFlag,
    @JsonProperty("ADD_FLAG_xor_WARM_xor_VAL_NEXT_IS_ZERO")
        List<Boolean> addFlagXorWarmXorValNextIsZero,
    @JsonProperty("BATCH_NUMBER") List<BigInteger> batchNumber,
    @JsonProperty("BIN_FLAG") List<Boolean> binFlag,
    @JsonProperty("BTC_FLAG") List<Boolean> btcFlag,
    @JsonProperty("CALL_FLAG") List<Boolean> callFlag,
    @JsonProperty("CALLER_CONTEXT_NUMBER") List<BigInteger> callerContextNumber,
    @JsonProperty("CODE_ADDRESS_HI") List<BigInteger> codeAddressHi,
    @JsonProperty("CODE_ADDRESS_LO") List<BigInteger> codeAddressLo,
    @JsonProperty("CODE_DEPLOYMENT_NUMBER") List<BigInteger> codeDeploymentNumber,
    @JsonProperty("CODE_DEPLOYMENT_STATUS") List<Boolean> codeDeploymentStatus,
    @JsonProperty("CON_FLAG") List<Boolean> conFlag,
    @JsonProperty("CONTEXT_GETS_REVRTD_FLAG") List<Boolean> contextGetsRevrtdFlag,
    @JsonProperty("CONTEXT_MAY_CHANGE_FLAG") List<Boolean> contextMayChangeFlag,
    @JsonProperty("CONTEXT_NUMBER") List<BigInteger> contextNumber,
    @JsonProperty("CONTEXT_NUMBER_NEW") List<BigInteger> contextNumberNew,
    @JsonProperty("CONTEXT_REVERT_STAMP") List<BigInteger> contextRevertStamp,
    @JsonProperty("CONTEXT_SELF_REVRTS_FLAG") List<Boolean> contextSelfRevrtsFlag,
    @JsonProperty("CONTEXT_WILL_REVERT_FLAG") List<Boolean> contextWillRevertFlag,
    @JsonProperty("COPY_FLAG_xor_HAS_CODE_xor_VAL_NEXT_IS_ORIG_xor_IS_EIP1559")
        List<Boolean> copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559,
    @JsonProperty("COUNTER_NSR") List<BigInteger> counterNsr,
    @JsonProperty("COUNTER_TLI") List<Boolean> counterTli,
    @JsonProperty("CREATE_FLAG") List<Boolean> createFlag,
    @JsonProperty("DECODED_FLAG_2") List<Boolean> decodedFlag2,
    @JsonProperty("DECODED_FLAG_3") List<Boolean> decodedFlag3,
    @JsonProperty("DECODED_FLAG_4") List<Boolean> decodedFlag4,
    @JsonProperty("DUP_FLAG") List<Boolean> dupFlag,
    @JsonProperty("EXCEPTION_AHOY_FLAG") List<Boolean> exceptionAhoyFlag,
    @JsonProperty("EXT_FLAG") List<Boolean> extFlag,
    @JsonProperty("FAILURE_CONDITION_FLAG") List<Boolean> failureConditionFlag,
    @JsonProperty("GAS_ACTUAL") List<BigInteger> gasActual,
    @JsonProperty("GAS_COST") List<BigInteger> gasCost,
    @JsonProperty("GAS_EXPECTED") List<BigInteger> gasExpected,
    @JsonProperty("GAS_MEMORY_EXPANSION") List<BigInteger> gasMemoryExpansion,
    @JsonProperty("GAS_NEXT") List<BigInteger> gasNext,
    @JsonProperty("GAS_REFUND") List<BigInteger> gasRefund,
    @JsonProperty("HALT_FLAG") List<Boolean> haltFlag,
    @JsonProperty(
            "HEIGHT_NEW_xor_ADDRESS_LO_xor_GAS_REFUND_AMOUNT_xor_RETURNER_IS_PRECOMPILE_xor_STORAGE_KEY_HI")
        List<BigInteger>
            heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi,
    @JsonProperty("HEIGHT_OVER") List<BigInteger> heightOver,
    @JsonProperty(
            "HEIGHT_UNDER_xor_DEPLOYMENT_NUMBER_INFTY_xor_FROM_ADDRESS_LO_xor_RETURN_AT_OFFSET")
        List<BigInteger> heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset,
    @JsonProperty("HEIGHT_xor_CODE_SIZE_xor_GAS_REFUND_COUNTER_FINAL_xor_RETURN_DATA_SIZE")
        List<BigInteger> heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize,
    @JsonProperty("HUB_STAMP") List<BigInteger> hubStamp,
    @JsonProperty("INSTRUCTION_xor_NONCE_xor_INIT_CODE_SIZE_xor_BYTE_CODE_ADDRESS_HI")
        List<BigInteger> instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi,
    @JsonProperty("INVALID_FLAG") List<Boolean> invalidFlag,
    @JsonProperty("INVPREX") List<Boolean> invprex,
    @JsonProperty("JUMP_FLAG") List<Boolean> jumpFlag,
    @JsonProperty("JUMPX") List<Boolean> jumpx,
    @JsonProperty("KEC_FLAG") List<Boolean> kecFlag,
    @JsonProperty("LOG_FLAG") List<Boolean> logFlag,
    @JsonProperty("MAXCSX") List<Boolean> maxcsx,
    @JsonProperty("MOD_FLAG_xor_HAS_CODE_NEW_xor_VAL_ORIG_IS_ZERO")
        List<Boolean> modFlagXorHasCodeNewXorValOrigIsZero,
    @JsonProperty("MUL_FLAG") List<Boolean> mulFlag,
    @JsonProperty("MXP_FLAG") List<Boolean> mxpFlag,
    @JsonProperty("MXPX") List<Boolean> mxpx,
    @JsonProperty("NUMBER_OF_NON_STACK_ROWS") List<BigInteger> numberOfNonStackRows,
    @JsonProperty("OOB_FLAG") List<Boolean> oobFlag,
    @JsonProperty("OOGX") List<Boolean> oogx,
    @JsonProperty("OPCX") List<Boolean> opcx,
    @JsonProperty("PEEK_AT_ACCOUNT") List<Boolean> peekAtAccount,
    @JsonProperty("PEEK_AT_CONTEXT") List<Boolean> peekAtContext,
    @JsonProperty("PEEK_AT_STACK") List<Boolean> peekAtStack,
    @JsonProperty("PEEK_AT_STORAGE") List<Boolean> peekAtStorage,
    @JsonProperty("PEEK_AT_TRANSACTION") List<Boolean> peekAtTransaction,
    @JsonProperty("PROGRAM_COUNTER") List<BigInteger> programCounter,
    @JsonProperty("PROGRAM_COUNTER_NEW") List<BigInteger> programCounterNew,
    @JsonProperty(
            "PUSH_VALUE_HI_xor_CODE_HASH_LO_xor_COINBASE_ADDRESS_HI_xor_BYTE_CODE_DEPLOYMENT_STATUS_xor_STORAGE_KEY_LO")
        List<BigInteger>
            pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo,
    @JsonProperty("PUSH_VALUE_LO_xor_BALANCE_xor_CALL_DATA_SIZE_xor_CALLER_CONTEXT_NUMBER")
        List<BigInteger> pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber,
    @JsonProperty("PUSHPOP_FLAG") List<Boolean> pushpopFlag,
    @JsonProperty("RDCX") List<Boolean> rdcx,
    @JsonProperty("SHF_FLAG") List<Boolean> shfFlag,
    @JsonProperty("SOX_xor_IS_PRECOMPILE_xor_VAL_CURR_IS_ORIG")
        List<Boolean> soxXorIsPrecompileXorValCurrIsOrig,
    @JsonProperty("SSTOREX") List<Boolean> sstorex,
    @JsonProperty("STACK_ITEM_HEIGHT_1_xor_CALL_STACK_DEPTH")
        List<BigInteger> stackItemHeight1XorCallStackDepth,
    @JsonProperty(
            "STACK_ITEM_HEIGHT_2_xor_CODE_HASH_LO_NEW_xor_TO_ADDRESS_LO_xor_RETURN_DATA_OFFSET_xor_DEPLOYMENT_NUMBER")
        List<BigInteger>
            stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber,
    @JsonProperty(
            "STACK_ITEM_HEIGHT_3_xor_BALANCE_NEW_xor_NONCE_xor_ACCOUNT_DEPLOYMENT_NUMBER_xor_ADDRESS_HI")
        List<BigInteger>
            stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi,
    @JsonProperty(
            "STACK_ITEM_HEIGHT_4_xor_DEPLOYMENT_STATUS_NEW_xor_VALUE_xor_BYTE_CODE_DEPLOYMENT_NUMBER_xor_VAL_ORIG_HI")
        List<BigInteger>
            stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi,
    @JsonProperty("STACK_ITEM_POP_1") List<Boolean> stackItemPop1,
    @JsonProperty("STACK_ITEM_POP_2") List<Boolean> stackItemPop2,
    @JsonProperty("STACK_ITEM_POP_3") List<Boolean> stackItemPop3,
    @JsonProperty("STACK_ITEM_POP_4") List<Boolean> stackItemPop4,
    @JsonProperty("STACK_ITEM_STAMP_1_xor_GAS_LIMIT_xor_CALL_VALUE")
        List<BigInteger> stackItemStamp1XorGasLimitXorCallValue,
    @JsonProperty(
            "STACK_ITEM_STAMP_2_xor_DEPLOYMENT_NUMBER_xor_TO_ADDRESS_HI_xor_CALLER_ADDRESS_HI")
        List<BigInteger> stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi,
    @JsonProperty("STACK_ITEM_STAMP_3") List<BigInteger> stackItemStamp3,
    @JsonProperty(
            "STACK_ITEM_STAMP_4_xor_DEPLOYMENT_STATUS_xor_COINBASE_ADDRESS_LO_xor_CALLER_ADDRESS_LO_xor_ADDRESS_LO")
        List<BigInteger>
            stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo,
    @JsonProperty(
            "STACK_ITEM_VALUE_HI_1_xor_CODE_HASH_HI_NEW_xor_FROM_ADDRESS_HI_xor_ACCOUNT_ADDRESS_LO_xor_VAL_ORIG_LO")
        List<BigInteger>
            stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo,
    @JsonProperty("STACK_ITEM_VALUE_HI_2_xor_CODE_HASH_HI_xor_GAS_PRICE_xor_CALL_DATA_OFFSET")
        List<BigInteger> stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset,
    @JsonProperty("STACK_ITEM_VALUE_HI_3_xor_RETURN_AT_SIZE")
        List<BigInteger> stackItemValueHi3XorReturnAtSize,
    @JsonProperty(
            "STACK_ITEM_VALUE_HI_4_xor_NONCE_NEW_xor_INIT_GAS_xor_CALL_DATA_SIZE_xor_VAL_CURR_LO")
        List<BigInteger> stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo,
    @JsonProperty(
            "STACK_ITEM_VALUE_LO_1_xor_ADDRESS_HI_xor_INITIAL_BALANCE_xor_BYTE_CODE_ADDRESS_LO_xor_VAL_NEXT_HI")
        List<BigInteger>
            stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi,
    @JsonProperty("STACK_ITEM_VALUE_LO_2_xor_RETURNER_CONTEXT_NUMBER")
        List<BigInteger> stackItemValueLo2XorReturnerContextNumber,
    @JsonProperty(
            "STACK_ITEM_VALUE_LO_3_xor_DEPLOYMENT_NUMBER_NEW_xor_LEFTOVER_GAS_xor_IS_STATIC_xor_VAL_CURR_HI")
        List<BigInteger>
            stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi,
    @JsonProperty("STACK_ITEM_VALUE_LO_4_xor_CONTEXT_NUMBER")
        List<BigInteger> stackItemValueLo4XorContextNumber,
    @JsonProperty("STACKRAM_FLAG_xor_SUFFICIENT_BALANCE_xor_VAL_NEXT_IS_CURR_xor_STATUS_CODE")
        List<Boolean> stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode,
    @JsonProperty("STATIC_FLAG_xor_DEPLOYMENT_STATUS_INFTY_xor_WARM")
        List<Boolean> staticFlagXorDeploymentStatusInftyXorWarm,
    @JsonProperty("STATIC_GAS_xor_CODE_SIZE_NEW_xor_BASEFEE_xor_ACCOUNT_ADDRESS_HI_xor_VAL_NEXT_LO")
        List<BigInteger> staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo,
    @JsonProperty("STATICX_xor_EXISTS_xor_VAL_CURR_CHANGES_xor_TXN_REQUIRES_EVM_EXECUTION")
        List<Boolean> staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution,
    @JsonProperty("STO_FLAG_xor_WARM_NEW_xor_WARM_NEW") List<Boolean> stoFlagXorWarmNewXorWarmNew,
    @JsonProperty("SUX") List<Boolean> sux,
    @JsonProperty("SWAP_FLAG") List<Boolean> swapFlag,
    @JsonProperty("TRANSACTION_END_STAMP") List<BigInteger> transactionEndStamp,
    @JsonProperty("TRANSACTION_REVERTS") List<BigInteger> transactionReverts,
    @JsonProperty("TRM_FLAG") List<Boolean> trmFlag,
    @JsonProperty("TWO_LINE_INSTRUCTION") List<Boolean> twoLineInstruction,
    @JsonProperty("TX_EXEC") List<Boolean> txExec,
    @JsonProperty("TX_FINL") List<Boolean> txFinl,
    @JsonProperty("TX_INIT") List<Boolean> txInit,
    @JsonProperty("TX_SKIP") List<Boolean> txSkip,
    @JsonProperty("TX_WARM") List<Boolean> txWarm,
    @JsonProperty("TXN_FLAG") List<Boolean> txnFlag,
    @JsonProperty("UPDATE_xor_DECODED_FLAG_1_xor_EXISTS_NEW_xor_VAL_CURR_IS_ZERO_xor_IS_DEPLOYMENT")
        List<Boolean> updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment,
    @JsonProperty("WCP_FLAG") List<Boolean> wcpFlag) {
  static TraceBuilder builder() {
    return new TraceBuilder();
  }

  public static class TraceBuilder {
    private final BitSet filled = new BitSet();

    @JsonProperty("ABORT_FLAG")
    private final List<Boolean> abortFlag = new ArrayList<>();

    @JsonProperty("ABSOLUTE_TRANSACTION_NUMBER")
    private final List<BigInteger> absoluteTransactionNumber = new ArrayList<>();

    @JsonProperty("ACC_FLAG")
    private final List<Boolean> accFlag = new ArrayList<>();

    @JsonProperty("ADD_FLAG_xor_WARM_xor_VAL_NEXT_IS_ZERO")
    private final List<Boolean> addFlagXorWarmXorValNextIsZero = new ArrayList<>();

    @JsonProperty("BATCH_NUMBER")
    private final List<BigInteger> batchNumber = new ArrayList<>();

    @JsonProperty("BIN_FLAG")
    private final List<Boolean> binFlag = new ArrayList<>();

    @JsonProperty("BTC_FLAG")
    private final List<Boolean> btcFlag = new ArrayList<>();

    @JsonProperty("CALL_FLAG")
    private final List<Boolean> callFlag = new ArrayList<>();

    @JsonProperty("CALLER_CONTEXT_NUMBER")
    private final List<BigInteger> callerContextNumber = new ArrayList<>();

    @JsonProperty("CODE_ADDRESS_HI")
    private final List<BigInteger> codeAddressHi = new ArrayList<>();

    @JsonProperty("CODE_ADDRESS_LO")
    private final List<BigInteger> codeAddressLo = new ArrayList<>();

    @JsonProperty("CODE_DEPLOYMENT_NUMBER")
    private final List<BigInteger> codeDeploymentNumber = new ArrayList<>();

    @JsonProperty("CODE_DEPLOYMENT_STATUS")
    private final List<Boolean> codeDeploymentStatus = new ArrayList<>();

    @JsonProperty("CON_FLAG")
    private final List<Boolean> conFlag = new ArrayList<>();

    @JsonProperty("CONTEXT_GETS_REVRTD_FLAG")
    private final List<Boolean> contextGetsRevrtdFlag = new ArrayList<>();

    @JsonProperty("CONTEXT_MAY_CHANGE_FLAG")
    private final List<Boolean> contextMayChangeFlag = new ArrayList<>();

    @JsonProperty("CONTEXT_NUMBER")
    private final List<BigInteger> contextNumber = new ArrayList<>();

    @JsonProperty("CONTEXT_NUMBER_NEW")
    private final List<BigInteger> contextNumberNew = new ArrayList<>();

    @JsonProperty("CONTEXT_REVERT_STAMP")
    private final List<BigInteger> contextRevertStamp = new ArrayList<>();

    @JsonProperty("CONTEXT_SELF_REVRTS_FLAG")
    private final List<Boolean> contextSelfRevrtsFlag = new ArrayList<>();

    @JsonProperty("CONTEXT_WILL_REVERT_FLAG")
    private final List<Boolean> contextWillRevertFlag = new ArrayList<>();

    @JsonProperty("COPY_FLAG_xor_HAS_CODE_xor_VAL_NEXT_IS_ORIG_xor_IS_EIP1559")
    private final List<Boolean> copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559 = new ArrayList<>();

    @JsonProperty("COUNTER_NSR")
    private final List<BigInteger> counterNsr = new ArrayList<>();

    @JsonProperty("COUNTER_TLI")
    private final List<Boolean> counterTli = new ArrayList<>();

    @JsonProperty("CREATE_FLAG")
    private final List<Boolean> createFlag = new ArrayList<>();

    @JsonProperty("DECODED_FLAG_2")
    private final List<Boolean> decodedFlag2 = new ArrayList<>();

    @JsonProperty("DECODED_FLAG_3")
    private final List<Boolean> decodedFlag3 = new ArrayList<>();

    @JsonProperty("DECODED_FLAG_4")
    private final List<Boolean> decodedFlag4 = new ArrayList<>();

    @JsonProperty("DUP_FLAG")
    private final List<Boolean> dupFlag = new ArrayList<>();

    @JsonProperty("EXCEPTION_AHOY_FLAG")
    private final List<Boolean> exceptionAhoyFlag = new ArrayList<>();

    @JsonProperty("EXT_FLAG")
    private final List<Boolean> extFlag = new ArrayList<>();

    @JsonProperty("FAILURE_CONDITION_FLAG")
    private final List<Boolean> failureConditionFlag = new ArrayList<>();

    @JsonProperty("GAS_ACTUAL")
    private final List<BigInteger> gasActual = new ArrayList<>();

    @JsonProperty("GAS_COST")
    private final List<BigInteger> gasCost = new ArrayList<>();

    @JsonProperty("GAS_EXPECTED")
    private final List<BigInteger> gasExpected = new ArrayList<>();

    @JsonProperty("GAS_MEMORY_EXPANSION")
    private final List<BigInteger> gasMemoryExpansion = new ArrayList<>();

    @JsonProperty("GAS_NEXT")
    private final List<BigInteger> gasNext = new ArrayList<>();

    @JsonProperty("GAS_REFUND")
    private final List<BigInteger> gasRefund = new ArrayList<>();

    @JsonProperty("HALT_FLAG")
    private final List<Boolean> haltFlag = new ArrayList<>();

    @JsonProperty(
        "HEIGHT_NEW_xor_ADDRESS_LO_xor_GAS_REFUND_AMOUNT_xor_RETURNER_IS_PRECOMPILE_xor_STORAGE_KEY_HI")
    private final List<BigInteger>
        heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi =
            new ArrayList<>();

    @JsonProperty("HEIGHT_OVER")
    private final List<BigInteger> heightOver = new ArrayList<>();

    @JsonProperty(
        "HEIGHT_UNDER_xor_DEPLOYMENT_NUMBER_INFTY_xor_FROM_ADDRESS_LO_xor_RETURN_AT_OFFSET")
    private final List<BigInteger>
        heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset = new ArrayList<>();

    @JsonProperty("HEIGHT_xor_CODE_SIZE_xor_GAS_REFUND_COUNTER_FINAL_xor_RETURN_DATA_SIZE")
    private final List<BigInteger> heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize =
        new ArrayList<>();

    @JsonProperty("HUB_STAMP")
    private final List<BigInteger> hubStamp = new ArrayList<>();

    @JsonProperty("INSTRUCTION_xor_NONCE_xor_INIT_CODE_SIZE_xor_BYTE_CODE_ADDRESS_HI")
    private final List<BigInteger> instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi =
        new ArrayList<>();

    @JsonProperty("INVALID_FLAG")
    private final List<Boolean> invalidFlag = new ArrayList<>();

    @JsonProperty("INVPREX")
    private final List<Boolean> invprex = new ArrayList<>();

    @JsonProperty("JUMP_FLAG")
    private final List<Boolean> jumpFlag = new ArrayList<>();

    @JsonProperty("JUMPX")
    private final List<Boolean> jumpx = new ArrayList<>();

    @JsonProperty("KEC_FLAG")
    private final List<Boolean> kecFlag = new ArrayList<>();

    @JsonProperty("LOG_FLAG")
    private final List<Boolean> logFlag = new ArrayList<>();

    @JsonProperty("MAXCSX")
    private final List<Boolean> maxcsx = new ArrayList<>();

    @JsonProperty("MOD_FLAG_xor_HAS_CODE_NEW_xor_VAL_ORIG_IS_ZERO")
    private final List<Boolean> modFlagXorHasCodeNewXorValOrigIsZero = new ArrayList<>();

    @JsonProperty("MUL_FLAG")
    private final List<Boolean> mulFlag = new ArrayList<>();

    @JsonProperty("MXP_FLAG")
    private final List<Boolean> mxpFlag = new ArrayList<>();

    @JsonProperty("MXPX")
    private final List<Boolean> mxpx = new ArrayList<>();

    @JsonProperty("NUMBER_OF_NON_STACK_ROWS")
    private final List<BigInteger> numberOfNonStackRows = new ArrayList<>();

    @JsonProperty("OOB_FLAG")
    private final List<Boolean> oobFlag = new ArrayList<>();

    @JsonProperty("OOGX")
    private final List<Boolean> oogx = new ArrayList<>();

    @JsonProperty("OPCX")
    private final List<Boolean> opcx = new ArrayList<>();

    @JsonProperty("PEEK_AT_ACCOUNT")
    private final List<Boolean> peekAtAccount = new ArrayList<>();

    @JsonProperty("PEEK_AT_CONTEXT")
    private final List<Boolean> peekAtContext = new ArrayList<>();

    @JsonProperty("PEEK_AT_STACK")
    private final List<Boolean> peekAtStack = new ArrayList<>();

    @JsonProperty("PEEK_AT_STORAGE")
    private final List<Boolean> peekAtStorage = new ArrayList<>();

    @JsonProperty("PEEK_AT_TRANSACTION")
    private final List<Boolean> peekAtTransaction = new ArrayList<>();

    @JsonProperty("PROGRAM_COUNTER")
    private final List<BigInteger> programCounter = new ArrayList<>();

    @JsonProperty("PROGRAM_COUNTER_NEW")
    private final List<BigInteger> programCounterNew = new ArrayList<>();

    @JsonProperty(
        "PUSH_VALUE_HI_xor_CODE_HASH_LO_xor_COINBASE_ADDRESS_HI_xor_BYTE_CODE_DEPLOYMENT_STATUS_xor_STORAGE_KEY_LO")
    private final List<BigInteger>
        pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo =
            new ArrayList<>();

    @JsonProperty("PUSH_VALUE_LO_xor_BALANCE_xor_CALL_DATA_SIZE_xor_CALLER_CONTEXT_NUMBER")
    private final List<BigInteger> pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber =
        new ArrayList<>();

    @JsonProperty("PUSHPOP_FLAG")
    private final List<Boolean> pushpopFlag = new ArrayList<>();

    @JsonProperty("RDCX")
    private final List<Boolean> rdcx = new ArrayList<>();

    @JsonProperty("SHF_FLAG")
    private final List<Boolean> shfFlag = new ArrayList<>();

    @JsonProperty("SOX_xor_IS_PRECOMPILE_xor_VAL_CURR_IS_ORIG")
    private final List<Boolean> soxXorIsPrecompileXorValCurrIsOrig = new ArrayList<>();

    @JsonProperty("SSTOREX")
    private final List<Boolean> sstorex = new ArrayList<>();

    @JsonProperty("STACK_ITEM_HEIGHT_1_xor_CALL_STACK_DEPTH")
    private final List<BigInteger> stackItemHeight1XorCallStackDepth = new ArrayList<>();

    @JsonProperty(
        "STACK_ITEM_HEIGHT_2_xor_CODE_HASH_LO_NEW_xor_TO_ADDRESS_LO_xor_RETURN_DATA_OFFSET_xor_DEPLOYMENT_NUMBER")
    private final List<BigInteger>
        stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber =
            new ArrayList<>();

    @JsonProperty(
        "STACK_ITEM_HEIGHT_3_xor_BALANCE_NEW_xor_NONCE_xor_ACCOUNT_DEPLOYMENT_NUMBER_xor_ADDRESS_HI")
    private final List<BigInteger>
        stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi =
            new ArrayList<>();

    @JsonProperty(
        "STACK_ITEM_HEIGHT_4_xor_DEPLOYMENT_STATUS_NEW_xor_VALUE_xor_BYTE_CODE_DEPLOYMENT_NUMBER_xor_VAL_ORIG_HI")
    private final List<BigInteger>
        stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi =
            new ArrayList<>();

    @JsonProperty("STACK_ITEM_POP_1")
    private final List<Boolean> stackItemPop1 = new ArrayList<>();

    @JsonProperty("STACK_ITEM_POP_2")
    private final List<Boolean> stackItemPop2 = new ArrayList<>();

    @JsonProperty("STACK_ITEM_POP_3")
    private final List<Boolean> stackItemPop3 = new ArrayList<>();

    @JsonProperty("STACK_ITEM_POP_4")
    private final List<Boolean> stackItemPop4 = new ArrayList<>();

    @JsonProperty("STACK_ITEM_STAMP_1_xor_GAS_LIMIT_xor_CALL_VALUE")
    private final List<BigInteger> stackItemStamp1XorGasLimitXorCallValue = new ArrayList<>();

    @JsonProperty(
        "STACK_ITEM_STAMP_2_xor_DEPLOYMENT_NUMBER_xor_TO_ADDRESS_HI_xor_CALLER_ADDRESS_HI")
    private final List<BigInteger>
        stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi = new ArrayList<>();

    @JsonProperty("STACK_ITEM_STAMP_3")
    private final List<BigInteger> stackItemStamp3 = new ArrayList<>();

    @JsonProperty(
        "STACK_ITEM_STAMP_4_xor_DEPLOYMENT_STATUS_xor_COINBASE_ADDRESS_LO_xor_CALLER_ADDRESS_LO_xor_ADDRESS_LO")
    private final List<BigInteger>
        stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo =
            new ArrayList<>();

    @JsonProperty(
        "STACK_ITEM_VALUE_HI_1_xor_CODE_HASH_HI_NEW_xor_FROM_ADDRESS_HI_xor_ACCOUNT_ADDRESS_LO_xor_VAL_ORIG_LO")
    private final List<BigInteger>
        stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo =
            new ArrayList<>();

    @JsonProperty("STACK_ITEM_VALUE_HI_2_xor_CODE_HASH_HI_xor_GAS_PRICE_xor_CALL_DATA_OFFSET")
    private final List<BigInteger> stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset =
        new ArrayList<>();

    @JsonProperty("STACK_ITEM_VALUE_HI_3_xor_RETURN_AT_SIZE")
    private final List<BigInteger> stackItemValueHi3XorReturnAtSize = new ArrayList<>();

    @JsonProperty(
        "STACK_ITEM_VALUE_HI_4_xor_NONCE_NEW_xor_INIT_GAS_xor_CALL_DATA_SIZE_xor_VAL_CURR_LO")
    private final List<BigInteger>
        stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo = new ArrayList<>();

    @JsonProperty(
        "STACK_ITEM_VALUE_LO_1_xor_ADDRESS_HI_xor_INITIAL_BALANCE_xor_BYTE_CODE_ADDRESS_LO_xor_VAL_NEXT_HI")
    private final List<BigInteger>
        stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi =
            new ArrayList<>();

    @JsonProperty("STACK_ITEM_VALUE_LO_2_xor_RETURNER_CONTEXT_NUMBER")
    private final List<BigInteger> stackItemValueLo2XorReturnerContextNumber = new ArrayList<>();

    @JsonProperty(
        "STACK_ITEM_VALUE_LO_3_xor_DEPLOYMENT_NUMBER_NEW_xor_LEFTOVER_GAS_xor_IS_STATIC_xor_VAL_CURR_HI")
    private final List<BigInteger>
        stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi =
            new ArrayList<>();

    @JsonProperty("STACK_ITEM_VALUE_LO_4_xor_CONTEXT_NUMBER")
    private final List<BigInteger> stackItemValueLo4XorContextNumber = new ArrayList<>();

    @JsonProperty("STACKRAM_FLAG_xor_SUFFICIENT_BALANCE_xor_VAL_NEXT_IS_CURR_xor_STATUS_CODE")
    private final List<Boolean> stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode =
        new ArrayList<>();

    @JsonProperty("STATIC_FLAG_xor_DEPLOYMENT_STATUS_INFTY_xor_WARM")
    private final List<Boolean> staticFlagXorDeploymentStatusInftyXorWarm = new ArrayList<>();

    @JsonProperty("STATIC_GAS_xor_CODE_SIZE_NEW_xor_BASEFEE_xor_ACCOUNT_ADDRESS_HI_xor_VAL_NEXT_LO")
    private final List<BigInteger>
        staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo = new ArrayList<>();

    @JsonProperty("STATICX_xor_EXISTS_xor_VAL_CURR_CHANGES_xor_TXN_REQUIRES_EVM_EXECUTION")
    private final List<Boolean> staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution =
        new ArrayList<>();

    @JsonProperty("STO_FLAG_xor_WARM_NEW_xor_WARM_NEW")
    private final List<Boolean> stoFlagXorWarmNewXorWarmNew = new ArrayList<>();

    @JsonProperty("SUX")
    private final List<Boolean> sux = new ArrayList<>();

    @JsonProperty("SWAP_FLAG")
    private final List<Boolean> swapFlag = new ArrayList<>();

    @JsonProperty("TRANSACTION_END_STAMP")
    private final List<BigInteger> transactionEndStamp = new ArrayList<>();

    @JsonProperty("TRANSACTION_REVERTS")
    private final List<BigInteger> transactionReverts = new ArrayList<>();

    @JsonProperty("TRM_FLAG")
    private final List<Boolean> trmFlag = new ArrayList<>();

    @JsonProperty("TWO_LINE_INSTRUCTION")
    private final List<Boolean> twoLineInstruction = new ArrayList<>();

    @JsonProperty("TX_EXEC")
    private final List<Boolean> txExec = new ArrayList<>();

    @JsonProperty("TX_FINL")
    private final List<Boolean> txFinl = new ArrayList<>();

    @JsonProperty("TX_INIT")
    private final List<Boolean> txInit = new ArrayList<>();

    @JsonProperty("TX_SKIP")
    private final List<Boolean> txSkip = new ArrayList<>();

    @JsonProperty("TX_WARM")
    private final List<Boolean> txWarm = new ArrayList<>();

    @JsonProperty("TXN_FLAG")
    private final List<Boolean> txnFlag = new ArrayList<>();

    @JsonProperty("UPDATE_xor_DECODED_FLAG_1_xor_EXISTS_NEW_xor_VAL_CURR_IS_ZERO_xor_IS_DEPLOYMENT")
    private final List<Boolean> updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment =
        new ArrayList<>();

    @JsonProperty("WCP_FLAG")
    private final List<Boolean> wcpFlag = new ArrayList<>();

    private TraceBuilder() {}

    public int size() {
      if (!filled.isEmpty()) {
        throw new RuntimeException("Cannot measure a trace with a non-validated row.");
      }

      return this.abortFlag.size();
    }

    public TraceBuilder abortFlag(final Boolean b) {
      if (filled.get(4)) {
        throw new IllegalStateException("ABORT_FLAG already set");
      } else {
        filled.set(4);
      }

      abortFlag.add(b);

      return this;
    }

    public TraceBuilder absoluteTransactionNumber(final BigInteger b) {
      if (filled.get(13)) {
        throw new IllegalStateException("ABSOLUTE_TRANSACTION_NUMBER already set");
      } else {
        filled.set(13);
      }

      absoluteTransactionNumber.add(b);

      return this;
    }

    public TraceBuilder batchNumber(final BigInteger b) {
      if (filled.get(15)) {
        throw new IllegalStateException("BATCH_NUMBER already set");
      } else {
        filled.set(15);
      }

      batchNumber.add(b);

      return this;
    }

    public TraceBuilder callerContextNumber(final BigInteger b) {
      if (filled.get(11)) {
        throw new IllegalStateException("CALLER_CONTEXT_NUMBER already set");
      } else {
        filled.set(11);
      }

      callerContextNumber.add(b);

      return this;
    }

    public TraceBuilder codeAddressHi(final BigInteger b) {
      if (filled.get(36)) {
        throw new IllegalStateException("CODE_ADDRESS_HI already set");
      } else {
        filled.set(36);
      }

      codeAddressHi.add(b);

      return this;
    }

    public TraceBuilder codeAddressLo(final BigInteger b) {
      if (filled.get(31)) {
        throw new IllegalStateException("CODE_ADDRESS_LO already set");
      } else {
        filled.set(31);
      }

      codeAddressLo.add(b);

      return this;
    }

    public TraceBuilder codeDeploymentNumber(final BigInteger b) {
      if (filled.get(12)) {
        throw new IllegalStateException("CODE_DEPLOYMENT_NUMBER already set");
      } else {
        filled.set(12);
      }

      codeDeploymentNumber.add(b);

      return this;
    }

    public TraceBuilder codeDeploymentStatus(final Boolean b) {
      if (filled.get(16)) {
        throw new IllegalStateException("CODE_DEPLOYMENT_STATUS already set");
      } else {
        filled.set(16);
      }

      codeDeploymentStatus.add(b);

      return this;
    }

    public TraceBuilder contextGetsRevrtdFlag(final Boolean b) {
      if (filled.get(21)) {
        throw new IllegalStateException("CONTEXT_GETS_REVRTD_FLAG already set");
      } else {
        filled.set(21);
      }

      contextGetsRevrtdFlag.add(b);

      return this;
    }

    public TraceBuilder contextMayChangeFlag(final Boolean b) {
      if (filled.get(26)) {
        throw new IllegalStateException("CONTEXT_MAY_CHANGE_FLAG already set");
      } else {
        filled.set(26);
      }

      contextMayChangeFlag.add(b);

      return this;
    }

    public TraceBuilder contextNumber(final BigInteger b) {
      if (filled.get(41)) {
        throw new IllegalStateException("CONTEXT_NUMBER already set");
      } else {
        filled.set(41);
      }

      contextNumber.add(b);

      return this;
    }

    public TraceBuilder contextNumberNew(final BigInteger b) {
      if (filled.get(2)) {
        throw new IllegalStateException("CONTEXT_NUMBER_NEW already set");
      } else {
        filled.set(2);
      }

      contextNumberNew.add(b);

      return this;
    }

    public TraceBuilder contextRevertStamp(final BigInteger b) {
      if (filled.get(32)) {
        throw new IllegalStateException("CONTEXT_REVERT_STAMP already set");
      } else {
        filled.set(32);
      }

      contextRevertStamp.add(b);

      return this;
    }

    public TraceBuilder contextSelfRevrtsFlag(final Boolean b) {
      if (filled.get(34)) {
        throw new IllegalStateException("CONTEXT_SELF_REVRTS_FLAG already set");
      } else {
        filled.set(34);
      }

      contextSelfRevrtsFlag.add(b);

      return this;
    }

    public TraceBuilder contextWillRevertFlag(final Boolean b) {
      if (filled.get(20)) {
        throw new IllegalStateException("CONTEXT_WILL_REVERT_FLAG already set");
      } else {
        filled.set(20);
      }

      contextWillRevertFlag.add(b);

      return this;
    }

    public TraceBuilder counterNsr(final BigInteger b) {
      if (filled.get(40)) {
        throw new IllegalStateException("COUNTER_NSR already set");
      } else {
        filled.set(40);
      }

      counterNsr.add(b);

      return this;
    }

    public TraceBuilder counterTli(final Boolean b) {
      if (filled.get(25)) {
        throw new IllegalStateException("COUNTER_TLI already set");
      } else {
        filled.set(25);
      }

      counterTli.add(b);

      return this;
    }

    public TraceBuilder exceptionAhoyFlag(final Boolean b) {
      if (filled.get(24)) {
        throw new IllegalStateException("EXCEPTION_AHOY_FLAG already set");
      } else {
        filled.set(24);
      }

      exceptionAhoyFlag.add(b);

      return this;
    }

    public TraceBuilder failureConditionFlag(final Boolean b) {
      if (filled.get(27)) {
        throw new IllegalStateException("FAILURE_CONDITION_FLAG already set");
      } else {
        filled.set(27);
      }

      failureConditionFlag.add(b);

      return this;
    }

    public TraceBuilder gasActual(final BigInteger b) {
      if (filled.get(6)) {
        throw new IllegalStateException("GAS_ACTUAL already set");
      } else {
        filled.set(6);
      }

      gasActual.add(b);

      return this;
    }

    public TraceBuilder gasCost(final BigInteger b) {
      if (filled.get(28)) {
        throw new IllegalStateException("GAS_COST already set");
      } else {
        filled.set(28);
      }

      gasCost.add(b);

      return this;
    }

    public TraceBuilder gasExpected(final BigInteger b) {
      if (filled.get(30)) {
        throw new IllegalStateException("GAS_EXPECTED already set");
      } else {
        filled.set(30);
      }

      gasExpected.add(b);

      return this;
    }

    public TraceBuilder gasMemoryExpansion(final BigInteger b) {
      if (filled.get(8)) {
        throw new IllegalStateException("GAS_MEMORY_EXPANSION already set");
      } else {
        filled.set(8);
      }

      gasMemoryExpansion.add(b);

      return this;
    }

    public TraceBuilder gasNext(final BigInteger b) {
      if (filled.get(0)) {
        throw new IllegalStateException("GAS_NEXT already set");
      } else {
        filled.set(0);
      }

      gasNext.add(b);

      return this;
    }

    public TraceBuilder gasRefund(final BigInteger b) {
      if (filled.get(7)) {
        throw new IllegalStateException("GAS_REFUND already set");
      } else {
        filled.set(7);
      }

      gasRefund.add(b);

      return this;
    }

    public TraceBuilder hubStamp(final BigInteger b) {
      if (filled.get(29)) {
        throw new IllegalStateException("HUB_STAMP already set");
      } else {
        filled.set(29);
      }

      hubStamp.add(b);

      return this;
    }

    public TraceBuilder numberOfNonStackRows(final BigInteger b) {
      if (filled.get(14)) {
        throw new IllegalStateException("NUMBER_OF_NON_STACK_ROWS already set");
      } else {
        filled.set(14);
      }

      numberOfNonStackRows.add(b);

      return this;
    }

    public TraceBuilder pAccountAddressHi(final BigInteger b) {
      if (filled.get(52)) {
        throw new IllegalStateException("ADDRESS_HI already set");
      } else {
        filled.set(52);
      }

      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.add(b);

      return this;
    }

    public TraceBuilder pAccountAddressLo(final BigInteger b) {
      if (filled.get(47)) {
        throw new IllegalStateException("ADDRESS_LO already set");
      } else {
        filled.set(47);
      }

      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.add(b);

      return this;
    }

    public TraceBuilder pAccountBalance(final BigInteger b) {
      if (filled.get(53)) {
        throw new IllegalStateException("BALANCE already set");
      } else {
        filled.set(53);
      }

      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.add(b);

      return this;
    }

    public TraceBuilder pAccountBalanceNew(final BigInteger b) {
      if (filled.get(43)) {
        throw new IllegalStateException("BALANCE_NEW already set");
      } else {
        filled.set(43);
      }

      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.add(b);

      return this;
    }

    public TraceBuilder pAccountCodeHashHi(final BigInteger b) {
      if (filled.get(56)) {
        throw new IllegalStateException("CODE_HASH_HI already set");
      } else {
        filled.set(56);
      }

      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.add(b);

      return this;
    }

    public TraceBuilder pAccountCodeHashHiNew(final BigInteger b) {
      if (filled.get(50)) {
        throw new IllegalStateException("CODE_HASH_HI_NEW already set");
      } else {
        filled.set(50);
      }

      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.add(b);

      return this;
    }

    public TraceBuilder pAccountCodeHashLo(final BigInteger b) {
      if (filled.get(51)) {
        throw new IllegalStateException("CODE_HASH_LO already set");
      } else {
        filled.set(51);
      }

      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.add(b);

      return this;
    }

    public TraceBuilder pAccountCodeHashLoNew(final BigInteger b) {
      if (filled.get(45)) {
        throw new IllegalStateException("CODE_HASH_LO_NEW already set");
      } else {
        filled.set(45);
      }

      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.add(b);

      return this;
    }

    public TraceBuilder pAccountCodeSize(final BigInteger b) {
      if (filled.get(58)) {
        throw new IllegalStateException("CODE_SIZE already set");
      } else {
        filled.set(58);
      }

      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.add(b);

      return this;
    }

    public TraceBuilder pAccountCodeSizeNew(final BigInteger b) {
      if (filled.get(42)) {
        throw new IllegalStateException("CODE_SIZE_NEW already set");
      } else {
        filled.set(42);
      }

      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.add(b);

      return this;
    }

    public TraceBuilder pAccountDeploymentNumber(final BigInteger b) {
      if (filled.get(55)) {
        throw new IllegalStateException("DEPLOYMENT_NUMBER already set");
      } else {
        filled.set(55);
      }

      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.add(b);

      return this;
    }

    public TraceBuilder pAccountDeploymentNumberInfty(final BigInteger b) {
      if (filled.get(57)) {
        throw new IllegalStateException("DEPLOYMENT_NUMBER_INFTY already set");
      } else {
        filled.set(57);
      }

      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.add(b);

      return this;
    }

    public TraceBuilder pAccountDeploymentNumberNew(final BigInteger b) {
      if (filled.get(44)) {
        throw new IllegalStateException("DEPLOYMENT_NUMBER_NEW already set");
      } else {
        filled.set(44);
      }

      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.add(b);

      return this;
    }

    public TraceBuilder pAccountDeploymentStatus(final BigInteger b) {
      if (filled.get(46)) {
        throw new IllegalStateException("DEPLOYMENT_STATUS already set");
      } else {
        filled.set(46);
      }

      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.add(b);

      return this;
    }

    public TraceBuilder pAccountDeploymentStatusInfty(final Boolean b) {
      if (filled.get(72)) {
        throw new IllegalStateException("DEPLOYMENT_STATUS_INFTY already set");
      } else {
        filled.set(72);
      }

      staticFlagXorDeploymentStatusInftyXorWarm.add(b);

      return this;
    }

    public TraceBuilder pAccountDeploymentStatusNew(final BigInteger b) {
      if (filled.get(48)) {
        throw new IllegalStateException("DEPLOYMENT_STATUS_NEW already set");
      } else {
        filled.set(48);
      }

      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.add(b);

      return this;
    }

    public TraceBuilder pAccountExists(final Boolean b) {
      if (filled.get(69)) {
        throw new IllegalStateException("EXISTS already set");
      } else {
        filled.set(69);
      }

      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.add(b);

      return this;
    }

    public TraceBuilder pAccountExistsNew(final Boolean b) {
      if (filled.get(66)) {
        throw new IllegalStateException("EXISTS_NEW already set");
      } else {
        filled.set(66);
      }

      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.add(b);

      return this;
    }

    public TraceBuilder pAccountHasCode(final Boolean b) {
      if (filled.get(67)) {
        throw new IllegalStateException("HAS_CODE already set");
      } else {
        filled.set(67);
      }

      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.add(b);

      return this;
    }

    public TraceBuilder pAccountHasCodeNew(final Boolean b) {
      if (filled.get(74)) {
        throw new IllegalStateException("HAS_CODE_NEW already set");
      } else {
        filled.set(74);
      }

      modFlagXorHasCodeNewXorValOrigIsZero.add(b);

      return this;
    }

    public TraceBuilder pAccountIsPrecompile(final Boolean b) {
      if (filled.get(70)) {
        throw new IllegalStateException("IS_PRECOMPILE already set");
      } else {
        filled.set(70);
      }

      soxXorIsPrecompileXorValCurrIsOrig.add(b);

      return this;
    }

    public TraceBuilder pAccountNonce(final BigInteger b) {
      if (filled.get(54)) {
        throw new IllegalStateException("NONCE already set");
      } else {
        filled.set(54);
      }

      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.add(b);

      return this;
    }

    public TraceBuilder pAccountNonceNew(final BigInteger b) {
      if (filled.get(49)) {
        throw new IllegalStateException("NONCE_NEW already set");
      } else {
        filled.set(49);
      }

      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.add(b);

      return this;
    }

    public TraceBuilder pAccountSufficientBalance(final Boolean b) {
      if (filled.get(68)) {
        throw new IllegalStateException("SUFFICIENT_BALANCE already set");
      } else {
        filled.set(68);
      }

      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.add(b);

      return this;
    }

    public TraceBuilder pAccountWarm(final Boolean b) {
      if (filled.get(73)) {
        throw new IllegalStateException("WARM already set");
      } else {
        filled.set(73);
      }

      addFlagXorWarmXorValNextIsZero.add(b);

      return this;
    }

    public TraceBuilder pAccountWarmNew(final Boolean b) {
      if (filled.get(71)) {
        throw new IllegalStateException("WARM_NEW already set");
      } else {
        filled.set(71);
      }

      stoFlagXorWarmNewXorWarmNew.add(b);

      return this;
    }

    public TraceBuilder pContextAccountAddressHi(final BigInteger b) {
      if (filled.get(42)) {
        throw new IllegalStateException("ACCOUNT_ADDRESS_HI already set");
      } else {
        filled.set(42);
      }

      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.add(b);

      return this;
    }

    public TraceBuilder pContextAccountAddressLo(final BigInteger b) {
      if (filled.get(50)) {
        throw new IllegalStateException("ACCOUNT_ADDRESS_LO already set");
      } else {
        filled.set(50);
      }

      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.add(b);

      return this;
    }

    public TraceBuilder pContextAccountDeploymentNumber(final BigInteger b) {
      if (filled.get(43)) {
        throw new IllegalStateException("ACCOUNT_DEPLOYMENT_NUMBER already set");
      } else {
        filled.set(43);
      }

      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.add(b);

      return this;
    }

    public TraceBuilder pContextByteCodeAddressHi(final BigInteger b) {
      if (filled.get(54)) {
        throw new IllegalStateException("BYTE_CODE_ADDRESS_HI already set");
      } else {
        filled.set(54);
      }

      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.add(b);

      return this;
    }

    public TraceBuilder pContextByteCodeAddressLo(final BigInteger b) {
      if (filled.get(52)) {
        throw new IllegalStateException("BYTE_CODE_ADDRESS_LO already set");
      } else {
        filled.set(52);
      }

      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.add(b);

      return this;
    }

    public TraceBuilder pContextByteCodeDeploymentNumber(final BigInteger b) {
      if (filled.get(48)) {
        throw new IllegalStateException("BYTE_CODE_DEPLOYMENT_NUMBER already set");
      } else {
        filled.set(48);
      }

      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.add(b);

      return this;
    }

    public TraceBuilder pContextByteCodeDeploymentStatus(final BigInteger b) {
      if (filled.get(51)) {
        throw new IllegalStateException("BYTE_CODE_DEPLOYMENT_STATUS already set");
      } else {
        filled.set(51);
      }

      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.add(b);

      return this;
    }

    public TraceBuilder pContextCallDataOffset(final BigInteger b) {
      if (filled.get(56)) {
        throw new IllegalStateException("CALL_DATA_OFFSET already set");
      } else {
        filled.set(56);
      }

      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.add(b);

      return this;
    }

    public TraceBuilder pContextCallDataSize(final BigInteger b) {
      if (filled.get(49)) {
        throw new IllegalStateException("CALL_DATA_SIZE already set");
      } else {
        filled.set(49);
      }

      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.add(b);

      return this;
    }

    public TraceBuilder pContextCallStackDepth(final BigInteger b) {
      if (filled.get(63)) {
        throw new IllegalStateException("CALL_STACK_DEPTH already set");
      } else {
        filled.set(63);
      }

      stackItemHeight1XorCallStackDepth.add(b);

      return this;
    }

    public TraceBuilder pContextCallValue(final BigInteger b) {
      if (filled.get(59)) {
        throw new IllegalStateException("CALL_VALUE already set");
      } else {
        filled.set(59);
      }

      stackItemStamp1XorGasLimitXorCallValue.add(b);

      return this;
    }

    public TraceBuilder pContextCallerAddressHi(final BigInteger b) {
      if (filled.get(55)) {
        throw new IllegalStateException("CALLER_ADDRESS_HI already set");
      } else {
        filled.set(55);
      }

      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.add(b);

      return this;
    }

    public TraceBuilder pContextCallerAddressLo(final BigInteger b) {
      if (filled.get(46)) {
        throw new IllegalStateException("CALLER_ADDRESS_LO already set");
      } else {
        filled.set(46);
      }

      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.add(b);

      return this;
    }

    public TraceBuilder pContextCallerContextNumber(final BigInteger b) {
      if (filled.get(53)) {
        throw new IllegalStateException("CALLER_CONTEXT_NUMBER already set");
      } else {
        filled.set(53);
      }

      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.add(b);

      return this;
    }

    public TraceBuilder pContextContextNumber(final BigInteger b) {
      if (filled.get(62)) {
        throw new IllegalStateException("CONTEXT_NUMBER already set");
      } else {
        filled.set(62);
      }

      stackItemValueLo4XorContextNumber.add(b);

      return this;
    }

    public TraceBuilder pContextIsStatic(final BigInteger b) {
      if (filled.get(44)) {
        throw new IllegalStateException("IS_STATIC already set");
      } else {
        filled.set(44);
      }

      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.add(b);

      return this;
    }

    public TraceBuilder pContextReturnAtOffset(final BigInteger b) {
      if (filled.get(57)) {
        throw new IllegalStateException("RETURN_AT_OFFSET already set");
      } else {
        filled.set(57);
      }

      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.add(b);

      return this;
    }

    public TraceBuilder pContextReturnAtSize(final BigInteger b) {
      if (filled.get(61)) {
        throw new IllegalStateException("RETURN_AT_SIZE already set");
      } else {
        filled.set(61);
      }

      stackItemValueHi3XorReturnAtSize.add(b);

      return this;
    }

    public TraceBuilder pContextReturnDataOffset(final BigInteger b) {
      if (filled.get(45)) {
        throw new IllegalStateException("RETURN_DATA_OFFSET already set");
      } else {
        filled.set(45);
      }

      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.add(b);

      return this;
    }

    public TraceBuilder pContextReturnDataSize(final BigInteger b) {
      if (filled.get(58)) {
        throw new IllegalStateException("RETURN_DATA_SIZE already set");
      } else {
        filled.set(58);
      }

      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.add(b);

      return this;
    }

    public TraceBuilder pContextReturnerContextNumber(final BigInteger b) {
      if (filled.get(60)) {
        throw new IllegalStateException("RETURNER_CONTEXT_NUMBER already set");
      } else {
        filled.set(60);
      }

      stackItemValueLo2XorReturnerContextNumber.add(b);

      return this;
    }

    public TraceBuilder pContextReturnerIsPrecompile(final BigInteger b) {
      if (filled.get(47)) {
        throw new IllegalStateException("RETURNER_IS_PRECOMPILE already set");
      } else {
        filled.set(47);
      }

      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.add(b);

      return this;
    }

    public TraceBuilder pContextUpdate(final Boolean b) {
      if (filled.get(66)) {
        throw new IllegalStateException("UPDATE already set");
      } else {
        filled.set(66);
      }

      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.add(b);

      return this;
    }

    public TraceBuilder pStackAccFlag(final Boolean b) {
      if (filled.get(80)) {
        throw new IllegalStateException("ACC_FLAG already set");
      } else {
        filled.set(80);
      }

      accFlag.add(b);

      return this;
    }

    public TraceBuilder pStackAddFlag(final Boolean b) {
      if (filled.get(73)) {
        throw new IllegalStateException("ADD_FLAG already set");
      } else {
        filled.set(73);
      }

      addFlagXorWarmXorValNextIsZero.add(b);

      return this;
    }

    public TraceBuilder pStackBinFlag(final Boolean b) {
      if (filled.get(101)) {
        throw new IllegalStateException("BIN_FLAG already set");
      } else {
        filled.set(101);
      }

      binFlag.add(b);

      return this;
    }

    public TraceBuilder pStackBtcFlag(final Boolean b) {
      if (filled.get(93)) {
        throw new IllegalStateException("BTC_FLAG already set");
      } else {
        filled.set(93);
      }

      btcFlag.add(b);

      return this;
    }

    public TraceBuilder pStackCallFlag(final Boolean b) {
      if (filled.get(95)) {
        throw new IllegalStateException("CALL_FLAG already set");
      } else {
        filled.set(95);
      }

      callFlag.add(b);

      return this;
    }

    public TraceBuilder pStackConFlag(final Boolean b) {
      if (filled.get(77)) {
        throw new IllegalStateException("CON_FLAG already set");
      } else {
        filled.set(77);
      }

      conFlag.add(b);

      return this;
    }

    public TraceBuilder pStackCopyFlag(final Boolean b) {
      if (filled.get(67)) {
        throw new IllegalStateException("COPY_FLAG already set");
      } else {
        filled.set(67);
      }

      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.add(b);

      return this;
    }

    public TraceBuilder pStackCreateFlag(final Boolean b) {
      if (filled.get(103)) {
        throw new IllegalStateException("CREATE_FLAG already set");
      } else {
        filled.set(103);
      }

      createFlag.add(b);

      return this;
    }

    public TraceBuilder pStackDecodedFlag1(final Boolean b) {
      if (filled.get(66)) {
        throw new IllegalStateException("DECODED_FLAG_1 already set");
      } else {
        filled.set(66);
      }

      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.add(b);

      return this;
    }

    public TraceBuilder pStackDecodedFlag2(final Boolean b) {
      if (filled.get(99)) {
        throw new IllegalStateException("DECODED_FLAG_2 already set");
      } else {
        filled.set(99);
      }

      decodedFlag2.add(b);

      return this;
    }

    public TraceBuilder pStackDecodedFlag3(final Boolean b) {
      if (filled.get(92)) {
        throw new IllegalStateException("DECODED_FLAG_3 already set");
      } else {
        filled.set(92);
      }

      decodedFlag3.add(b);

      return this;
    }

    public TraceBuilder pStackDecodedFlag4(final Boolean b) {
      if (filled.get(84)) {
        throw new IllegalStateException("DECODED_FLAG_4 already set");
      } else {
        filled.set(84);
      }

      decodedFlag4.add(b);

      return this;
    }

    public TraceBuilder pStackDupFlag(final Boolean b) {
      if (filled.get(94)) {
        throw new IllegalStateException("DUP_FLAG already set");
      } else {
        filled.set(94);
      }

      dupFlag.add(b);

      return this;
    }

    public TraceBuilder pStackExtFlag(final Boolean b) {
      if (filled.get(112)) {
        throw new IllegalStateException("EXT_FLAG already set");
      } else {
        filled.set(112);
      }

      extFlag.add(b);

      return this;
    }

    public TraceBuilder pStackHaltFlag(final Boolean b) {
      if (filled.get(97)) {
        throw new IllegalStateException("HALT_FLAG already set");
      } else {
        filled.set(97);
      }

      haltFlag.add(b);

      return this;
    }

    public TraceBuilder pStackHeight(final BigInteger b) {
      if (filled.get(58)) {
        throw new IllegalStateException("HEIGHT already set");
      } else {
        filled.set(58);
      }

      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.add(b);

      return this;
    }

    public TraceBuilder pStackHeightNew(final BigInteger b) {
      if (filled.get(47)) {
        throw new IllegalStateException("HEIGHT_NEW already set");
      } else {
        filled.set(47);
      }

      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.add(b);

      return this;
    }

    public TraceBuilder pStackHeightOver(final BigInteger b) {
      if (filled.get(64)) {
        throw new IllegalStateException("HEIGHT_OVER already set");
      } else {
        filled.set(64);
      }

      heightOver.add(b);

      return this;
    }

    public TraceBuilder pStackHeightUnder(final BigInteger b) {
      if (filled.get(57)) {
        throw new IllegalStateException("HEIGHT_UNDER already set");
      } else {
        filled.set(57);
      }

      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.add(b);

      return this;
    }

    public TraceBuilder pStackInstruction(final BigInteger b) {
      if (filled.get(54)) {
        throw new IllegalStateException("INSTRUCTION already set");
      } else {
        filled.set(54);
      }

      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.add(b);

      return this;
    }

    public TraceBuilder pStackInvalidFlag(final Boolean b) {
      if (filled.get(81)) {
        throw new IllegalStateException("INVALID_FLAG already set");
      } else {
        filled.set(81);
      }

      invalidFlag.add(b);

      return this;
    }

    public TraceBuilder pStackInvprex(final Boolean b) {
      if (filled.get(85)) {
        throw new IllegalStateException("INVPREX already set");
      } else {
        filled.set(85);
      }

      invprex.add(b);

      return this;
    }

    public TraceBuilder pStackJumpFlag(final Boolean b) {
      if (filled.get(109)) {
        throw new IllegalStateException("JUMP_FLAG already set");
      } else {
        filled.set(109);
      }

      jumpFlag.add(b);

      return this;
    }

    public TraceBuilder pStackJumpx(final Boolean b) {
      if (filled.get(111)) {
        throw new IllegalStateException("JUMPX already set");
      } else {
        filled.set(111);
      }

      jumpx.add(b);

      return this;
    }

    public TraceBuilder pStackKecFlag(final Boolean b) {
      if (filled.get(98)) {
        throw new IllegalStateException("KEC_FLAG already set");
      } else {
        filled.set(98);
      }

      kecFlag.add(b);

      return this;
    }

    public TraceBuilder pStackLogFlag(final Boolean b) {
      if (filled.get(102)) {
        throw new IllegalStateException("LOG_FLAG already set");
      } else {
        filled.set(102);
      }

      logFlag.add(b);

      return this;
    }

    public TraceBuilder pStackMaxcsx(final Boolean b) {
      if (filled.get(79)) {
        throw new IllegalStateException("MAXCSX already set");
      } else {
        filled.set(79);
      }

      maxcsx.add(b);

      return this;
    }

    public TraceBuilder pStackModFlag(final Boolean b) {
      if (filled.get(74)) {
        throw new IllegalStateException("MOD_FLAG already set");
      } else {
        filled.set(74);
      }

      modFlagXorHasCodeNewXorValOrigIsZero.add(b);

      return this;
    }

    public TraceBuilder pStackMulFlag(final Boolean b) {
      if (filled.get(88)) {
        throw new IllegalStateException("MUL_FLAG already set");
      } else {
        filled.set(88);
      }

      mulFlag.add(b);

      return this;
    }

    public TraceBuilder pStackMxpFlag(final Boolean b) {
      if (filled.get(91)) {
        throw new IllegalStateException("MXP_FLAG already set");
      } else {
        filled.set(91);
      }

      mxpFlag.add(b);

      return this;
    }

    public TraceBuilder pStackMxpx(final Boolean b) {
      if (filled.get(108)) {
        throw new IllegalStateException("MXPX already set");
      } else {
        filled.set(108);
      }

      mxpx.add(b);

      return this;
    }

    public TraceBuilder pStackOobFlag(final Boolean b) {
      if (filled.get(104)) {
        throw new IllegalStateException("OOB_FLAG already set");
      } else {
        filled.set(104);
      }

      oobFlag.add(b);

      return this;
    }

    public TraceBuilder pStackOogx(final Boolean b) {
      if (filled.get(105)) {
        throw new IllegalStateException("OOGX already set");
      } else {
        filled.set(105);
      }

      oogx.add(b);

      return this;
    }

    public TraceBuilder pStackOpcx(final Boolean b) {
      if (filled.get(86)) {
        throw new IllegalStateException("OPCX already set");
      } else {
        filled.set(86);
      }

      opcx.add(b);

      return this;
    }

    public TraceBuilder pStackPushValueHi(final BigInteger b) {
      if (filled.get(51)) {
        throw new IllegalStateException("PUSH_VALUE_HI already set");
      } else {
        filled.set(51);
      }

      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.add(b);

      return this;
    }

    public TraceBuilder pStackPushValueLo(final BigInteger b) {
      if (filled.get(53)) {
        throw new IllegalStateException("PUSH_VALUE_LO already set");
      } else {
        filled.set(53);
      }

      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.add(b);

      return this;
    }

    public TraceBuilder pStackPushpopFlag(final Boolean b) {
      if (filled.get(90)) {
        throw new IllegalStateException("PUSHPOP_FLAG already set");
      } else {
        filled.set(90);
      }

      pushpopFlag.add(b);

      return this;
    }

    public TraceBuilder pStackRdcx(final Boolean b) {
      if (filled.get(96)) {
        throw new IllegalStateException("RDCX already set");
      } else {
        filled.set(96);
      }

      rdcx.add(b);

      return this;
    }

    public TraceBuilder pStackShfFlag(final Boolean b) {
      if (filled.get(78)) {
        throw new IllegalStateException("SHF_FLAG already set");
      } else {
        filled.set(78);
      }

      shfFlag.add(b);

      return this;
    }

    public TraceBuilder pStackSox(final Boolean b) {
      if (filled.get(70)) {
        throw new IllegalStateException("SOX already set");
      } else {
        filled.set(70);
      }

      soxXorIsPrecompileXorValCurrIsOrig.add(b);

      return this;
    }

    public TraceBuilder pStackSstorex(final Boolean b) {
      if (filled.get(87)) {
        throw new IllegalStateException("SSTOREX already set");
      } else {
        filled.set(87);
      }

      sstorex.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemHeight1(final BigInteger b) {
      if (filled.get(63)) {
        throw new IllegalStateException("STACK_ITEM_HEIGHT_1 already set");
      } else {
        filled.set(63);
      }

      stackItemHeight1XorCallStackDepth.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemHeight2(final BigInteger b) {
      if (filled.get(45)) {
        throw new IllegalStateException("STACK_ITEM_HEIGHT_2 already set");
      } else {
        filled.set(45);
      }

      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemHeight3(final BigInteger b) {
      if (filled.get(43)) {
        throw new IllegalStateException("STACK_ITEM_HEIGHT_3 already set");
      } else {
        filled.set(43);
      }

      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemHeight4(final BigInteger b) {
      if (filled.get(48)) {
        throw new IllegalStateException("STACK_ITEM_HEIGHT_4 already set");
      } else {
        filled.set(48);
      }

      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemPop1(final Boolean b) {
      if (filled.get(106)) {
        throw new IllegalStateException("STACK_ITEM_POP_1 already set");
      } else {
        filled.set(106);
      }

      stackItemPop1.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemPop2(final Boolean b) {
      if (filled.get(76)) {
        throw new IllegalStateException("STACK_ITEM_POP_2 already set");
      } else {
        filled.set(76);
      }

      stackItemPop2.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemPop3(final Boolean b) {
      if (filled.get(82)) {
        throw new IllegalStateException("STACK_ITEM_POP_3 already set");
      } else {
        filled.set(82);
      }

      stackItemPop3.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemPop4(final Boolean b) {
      if (filled.get(83)) {
        throw new IllegalStateException("STACK_ITEM_POP_4 already set");
      } else {
        filled.set(83);
      }

      stackItemPop4.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemStamp1(final BigInteger b) {
      if (filled.get(59)) {
        throw new IllegalStateException("STACK_ITEM_STAMP_1 already set");
      } else {
        filled.set(59);
      }

      stackItemStamp1XorGasLimitXorCallValue.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemStamp2(final BigInteger b) {
      if (filled.get(55)) {
        throw new IllegalStateException("STACK_ITEM_STAMP_2 already set");
      } else {
        filled.set(55);
      }

      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemStamp3(final BigInteger b) {
      if (filled.get(65)) {
        throw new IllegalStateException("STACK_ITEM_STAMP_3 already set");
      } else {
        filled.set(65);
      }

      stackItemStamp3.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemStamp4(final BigInteger b) {
      if (filled.get(46)) {
        throw new IllegalStateException("STACK_ITEM_STAMP_4 already set");
      } else {
        filled.set(46);
      }

      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemValueHi1(final BigInteger b) {
      if (filled.get(50)) {
        throw new IllegalStateException("STACK_ITEM_VALUE_HI_1 already set");
      } else {
        filled.set(50);
      }

      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemValueHi2(final BigInteger b) {
      if (filled.get(56)) {
        throw new IllegalStateException("STACK_ITEM_VALUE_HI_2 already set");
      } else {
        filled.set(56);
      }

      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemValueHi3(final BigInteger b) {
      if (filled.get(61)) {
        throw new IllegalStateException("STACK_ITEM_VALUE_HI_3 already set");
      } else {
        filled.set(61);
      }

      stackItemValueHi3XorReturnAtSize.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemValueHi4(final BigInteger b) {
      if (filled.get(49)) {
        throw new IllegalStateException("STACK_ITEM_VALUE_HI_4 already set");
      } else {
        filled.set(49);
      }

      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemValueLo1(final BigInteger b) {
      if (filled.get(52)) {
        throw new IllegalStateException("STACK_ITEM_VALUE_LO_1 already set");
      } else {
        filled.set(52);
      }

      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemValueLo2(final BigInteger b) {
      if (filled.get(60)) {
        throw new IllegalStateException("STACK_ITEM_VALUE_LO_2 already set");
      } else {
        filled.set(60);
      }

      stackItemValueLo2XorReturnerContextNumber.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemValueLo3(final BigInteger b) {
      if (filled.get(44)) {
        throw new IllegalStateException("STACK_ITEM_VALUE_LO_3 already set");
      } else {
        filled.set(44);
      }

      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.add(b);

      return this;
    }

    public TraceBuilder pStackStackItemValueLo4(final BigInteger b) {
      if (filled.get(62)) {
        throw new IllegalStateException("STACK_ITEM_VALUE_LO_4 already set");
      } else {
        filled.set(62);
      }

      stackItemValueLo4XorContextNumber.add(b);

      return this;
    }

    public TraceBuilder pStackStackramFlag(final Boolean b) {
      if (filled.get(68)) {
        throw new IllegalStateException("STACKRAM_FLAG already set");
      } else {
        filled.set(68);
      }

      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.add(b);

      return this;
    }

    public TraceBuilder pStackStaticFlag(final Boolean b) {
      if (filled.get(72)) {
        throw new IllegalStateException("STATIC_FLAG already set");
      } else {
        filled.set(72);
      }

      staticFlagXorDeploymentStatusInftyXorWarm.add(b);

      return this;
    }

    public TraceBuilder pStackStaticGas(final BigInteger b) {
      if (filled.get(42)) {
        throw new IllegalStateException("STATIC_GAS already set");
      } else {
        filled.set(42);
      }

      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.add(b);

      return this;
    }

    public TraceBuilder pStackStaticx(final Boolean b) {
      if (filled.get(69)) {
        throw new IllegalStateException("STATICX already set");
      } else {
        filled.set(69);
      }

      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.add(b);

      return this;
    }

    public TraceBuilder pStackStoFlag(final Boolean b) {
      if (filled.get(71)) {
        throw new IllegalStateException("STO_FLAG already set");
      } else {
        filled.set(71);
      }

      stoFlagXorWarmNewXorWarmNew.add(b);

      return this;
    }

    public TraceBuilder pStackSux(final Boolean b) {
      if (filled.get(107)) {
        throw new IllegalStateException("SUX already set");
      } else {
        filled.set(107);
      }

      sux.add(b);

      return this;
    }

    public TraceBuilder pStackSwapFlag(final Boolean b) {
      if (filled.get(89)) {
        throw new IllegalStateException("SWAP_FLAG already set");
      } else {
        filled.set(89);
      }

      swapFlag.add(b);

      return this;
    }

    public TraceBuilder pStackTrmFlag(final Boolean b) {
      if (filled.get(75)) {
        throw new IllegalStateException("TRM_FLAG already set");
      } else {
        filled.set(75);
      }

      trmFlag.add(b);

      return this;
    }

    public TraceBuilder pStackTxnFlag(final Boolean b) {
      if (filled.get(100)) {
        throw new IllegalStateException("TXN_FLAG already set");
      } else {
        filled.set(100);
      }

      txnFlag.add(b);

      return this;
    }

    public TraceBuilder pStackWcpFlag(final Boolean b) {
      if (filled.get(110)) {
        throw new IllegalStateException("WCP_FLAG already set");
      } else {
        filled.set(110);
      }

      wcpFlag.add(b);

      return this;
    }

    public TraceBuilder pStorageAddressHi(final BigInteger b) {
      if (filled.get(43)) {
        throw new IllegalStateException("ADDRESS_HI already set");
      } else {
        filled.set(43);
      }

      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.add(b);

      return this;
    }

    public TraceBuilder pStorageAddressLo(final BigInteger b) {
      if (filled.get(46)) {
        throw new IllegalStateException("ADDRESS_LO already set");
      } else {
        filled.set(46);
      }

      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.add(b);

      return this;
    }

    public TraceBuilder pStorageDeploymentNumber(final BigInteger b) {
      if (filled.get(45)) {
        throw new IllegalStateException("DEPLOYMENT_NUMBER already set");
      } else {
        filled.set(45);
      }

      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.add(b);

      return this;
    }

    public TraceBuilder pStorageStorageKeyHi(final BigInteger b) {
      if (filled.get(47)) {
        throw new IllegalStateException("STORAGE_KEY_HI already set");
      } else {
        filled.set(47);
      }

      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.add(b);

      return this;
    }

    public TraceBuilder pStorageStorageKeyLo(final BigInteger b) {
      if (filled.get(51)) {
        throw new IllegalStateException("STORAGE_KEY_LO already set");
      } else {
        filled.set(51);
      }

      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.add(b);

      return this;
    }

    public TraceBuilder pStorageValCurrChanges(final Boolean b) {
      if (filled.get(69)) {
        throw new IllegalStateException("VAL_CURR_CHANGES already set");
      } else {
        filled.set(69);
      }

      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.add(b);

      return this;
    }

    public TraceBuilder pStorageValCurrHi(final BigInteger b) {
      if (filled.get(44)) {
        throw new IllegalStateException("VAL_CURR_HI already set");
      } else {
        filled.set(44);
      }

      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.add(b);

      return this;
    }

    public TraceBuilder pStorageValCurrIsOrig(final Boolean b) {
      if (filled.get(70)) {
        throw new IllegalStateException("VAL_CURR_IS_ORIG already set");
      } else {
        filled.set(70);
      }

      soxXorIsPrecompileXorValCurrIsOrig.add(b);

      return this;
    }

    public TraceBuilder pStorageValCurrIsZero(final Boolean b) {
      if (filled.get(66)) {
        throw new IllegalStateException("VAL_CURR_IS_ZERO already set");
      } else {
        filled.set(66);
      }

      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.add(b);

      return this;
    }

    public TraceBuilder pStorageValCurrLo(final BigInteger b) {
      if (filled.get(49)) {
        throw new IllegalStateException("VAL_CURR_LO already set");
      } else {
        filled.set(49);
      }

      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.add(b);

      return this;
    }

    public TraceBuilder pStorageValNextHi(final BigInteger b) {
      if (filled.get(52)) {
        throw new IllegalStateException("VAL_NEXT_HI already set");
      } else {
        filled.set(52);
      }

      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.add(b);

      return this;
    }

    public TraceBuilder pStorageValNextIsCurr(final Boolean b) {
      if (filled.get(68)) {
        throw new IllegalStateException("VAL_NEXT_IS_CURR already set");
      } else {
        filled.set(68);
      }

      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.add(b);

      return this;
    }

    public TraceBuilder pStorageValNextIsOrig(final Boolean b) {
      if (filled.get(67)) {
        throw new IllegalStateException("VAL_NEXT_IS_ORIG already set");
      } else {
        filled.set(67);
      }

      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.add(b);

      return this;
    }

    public TraceBuilder pStorageValNextIsZero(final Boolean b) {
      if (filled.get(73)) {
        throw new IllegalStateException("VAL_NEXT_IS_ZERO already set");
      } else {
        filled.set(73);
      }

      addFlagXorWarmXorValNextIsZero.add(b);

      return this;
    }

    public TraceBuilder pStorageValNextLo(final BigInteger b) {
      if (filled.get(42)) {
        throw new IllegalStateException("VAL_NEXT_LO already set");
      } else {
        filled.set(42);
      }

      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.add(b);

      return this;
    }

    public TraceBuilder pStorageValOrigHi(final BigInteger b) {
      if (filled.get(48)) {
        throw new IllegalStateException("VAL_ORIG_HI already set");
      } else {
        filled.set(48);
      }

      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.add(b);

      return this;
    }

    public TraceBuilder pStorageValOrigIsZero(final Boolean b) {
      if (filled.get(74)) {
        throw new IllegalStateException("VAL_ORIG_IS_ZERO already set");
      } else {
        filled.set(74);
      }

      modFlagXorHasCodeNewXorValOrigIsZero.add(b);

      return this;
    }

    public TraceBuilder pStorageValOrigLo(final BigInteger b) {
      if (filled.get(50)) {
        throw new IllegalStateException("VAL_ORIG_LO already set");
      } else {
        filled.set(50);
      }

      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.add(b);

      return this;
    }

    public TraceBuilder pStorageWarm(final Boolean b) {
      if (filled.get(72)) {
        throw new IllegalStateException("WARM already set");
      } else {
        filled.set(72);
      }

      staticFlagXorDeploymentStatusInftyXorWarm.add(b);

      return this;
    }

    public TraceBuilder pStorageWarmNew(final Boolean b) {
      if (filled.get(71)) {
        throw new IllegalStateException("WARM_NEW already set");
      } else {
        filled.set(71);
      }

      stoFlagXorWarmNewXorWarmNew.add(b);

      return this;
    }

    public TraceBuilder pTransactionBasefee(final BigInteger b) {
      if (filled.get(42)) {
        throw new IllegalStateException("BASEFEE already set");
      } else {
        filled.set(42);
      }

      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.add(b);

      return this;
    }

    public TraceBuilder pTransactionCallDataSize(final BigInteger b) {
      if (filled.get(53)) {
        throw new IllegalStateException("CALL_DATA_SIZE already set");
      } else {
        filled.set(53);
      }

      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.add(b);

      return this;
    }

    public TraceBuilder pTransactionCoinbaseAddressHi(final BigInteger b) {
      if (filled.get(51)) {
        throw new IllegalStateException("COINBASE_ADDRESS_HI already set");
      } else {
        filled.set(51);
      }

      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.add(b);

      return this;
    }

    public TraceBuilder pTransactionCoinbaseAddressLo(final BigInteger b) {
      if (filled.get(46)) {
        throw new IllegalStateException("COINBASE_ADDRESS_LO already set");
      } else {
        filled.set(46);
      }

      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.add(b);

      return this;
    }

    public TraceBuilder pTransactionFromAddressHi(final BigInteger b) {
      if (filled.get(50)) {
        throw new IllegalStateException("FROM_ADDRESS_HI already set");
      } else {
        filled.set(50);
      }

      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.add(b);

      return this;
    }

    public TraceBuilder pTransactionFromAddressLo(final BigInteger b) {
      if (filled.get(57)) {
        throw new IllegalStateException("FROM_ADDRESS_LO already set");
      } else {
        filled.set(57);
      }

      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.add(b);

      return this;
    }

    public TraceBuilder pTransactionGasLimit(final BigInteger b) {
      if (filled.get(59)) {
        throw new IllegalStateException("GAS_LIMIT already set");
      } else {
        filled.set(59);
      }

      stackItemStamp1XorGasLimitXorCallValue.add(b);

      return this;
    }

    public TraceBuilder pTransactionGasPrice(final BigInteger b) {
      if (filled.get(56)) {
        throw new IllegalStateException("GAS_PRICE already set");
      } else {
        filled.set(56);
      }

      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.add(b);

      return this;
    }

    public TraceBuilder pTransactionGasRefundAmount(final BigInteger b) {
      if (filled.get(47)) {
        throw new IllegalStateException("GAS_REFUND_AMOUNT already set");
      } else {
        filled.set(47);
      }

      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.add(b);

      return this;
    }

    public TraceBuilder pTransactionGasRefundCounterFinal(final BigInteger b) {
      if (filled.get(58)) {
        throw new IllegalStateException("GAS_REFUND_COUNTER_FINAL already set");
      } else {
        filled.set(58);
      }

      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.add(b);

      return this;
    }

    public TraceBuilder pTransactionInitCodeSize(final BigInteger b) {
      if (filled.get(54)) {
        throw new IllegalStateException("INIT_CODE_SIZE already set");
      } else {
        filled.set(54);
      }

      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.add(b);

      return this;
    }

    public TraceBuilder pTransactionInitGas(final BigInteger b) {
      if (filled.get(49)) {
        throw new IllegalStateException("INIT_GAS already set");
      } else {
        filled.set(49);
      }

      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.add(b);

      return this;
    }

    public TraceBuilder pTransactionInitialBalance(final BigInteger b) {
      if (filled.get(52)) {
        throw new IllegalStateException("INITIAL_BALANCE already set");
      } else {
        filled.set(52);
      }

      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.add(b);

      return this;
    }

    public TraceBuilder pTransactionIsDeployment(final Boolean b) {
      if (filled.get(66)) {
        throw new IllegalStateException("IS_DEPLOYMENT already set");
      } else {
        filled.set(66);
      }

      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.add(b);

      return this;
    }

    public TraceBuilder pTransactionIsEip1559(final Boolean b) {
      if (filled.get(67)) {
        throw new IllegalStateException("IS_EIP1559 already set");
      } else {
        filled.set(67);
      }

      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.add(b);

      return this;
    }

    public TraceBuilder pTransactionLeftoverGas(final BigInteger b) {
      if (filled.get(44)) {
        throw new IllegalStateException("LEFTOVER_GAS already set");
      } else {
        filled.set(44);
      }

      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.add(b);

      return this;
    }

    public TraceBuilder pTransactionNonce(final BigInteger b) {
      if (filled.get(43)) {
        throw new IllegalStateException("NONCE already set");
      } else {
        filled.set(43);
      }

      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.add(b);

      return this;
    }

    public TraceBuilder pTransactionStatusCode(final Boolean b) {
      if (filled.get(68)) {
        throw new IllegalStateException("STATUS_CODE already set");
      } else {
        filled.set(68);
      }

      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.add(b);

      return this;
    }

    public TraceBuilder pTransactionToAddressHi(final BigInteger b) {
      if (filled.get(55)) {
        throw new IllegalStateException("TO_ADDRESS_HI already set");
      } else {
        filled.set(55);
      }

      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.add(b);

      return this;
    }

    public TraceBuilder pTransactionToAddressLo(final BigInteger b) {
      if (filled.get(45)) {
        throw new IllegalStateException("TO_ADDRESS_LO already set");
      } else {
        filled.set(45);
      }

      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.add(b);

      return this;
    }

    public TraceBuilder pTransactionTxnRequiresEvmExecution(final Boolean b) {
      if (filled.get(69)) {
        throw new IllegalStateException("TXN_REQUIRES_EVM_EXECUTION already set");
      } else {
        filled.set(69);
      }

      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.add(b);

      return this;
    }

    public TraceBuilder pTransactionValue(final BigInteger b) {
      if (filled.get(48)) {
        throw new IllegalStateException("VALUE already set");
      } else {
        filled.set(48);
      }

      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.add(b);

      return this;
    }

    public TraceBuilder peekAtAccount(final Boolean b) {
      if (filled.get(33)) {
        throw new IllegalStateException("PEEK_AT_ACCOUNT already set");
      } else {
        filled.set(33);
      }

      peekAtAccount.add(b);

      return this;
    }

    public TraceBuilder peekAtContext(final Boolean b) {
      if (filled.get(18)) {
        throw new IllegalStateException("PEEK_AT_CONTEXT already set");
      } else {
        filled.set(18);
      }

      peekAtContext.add(b);

      return this;
    }

    public TraceBuilder peekAtStack(final Boolean b) {
      if (filled.get(3)) {
        throw new IllegalStateException("PEEK_AT_STACK already set");
      } else {
        filled.set(3);
      }

      peekAtStack.add(b);

      return this;
    }

    public TraceBuilder peekAtStorage(final Boolean b) {
      if (filled.get(5)) {
        throw new IllegalStateException("PEEK_AT_STORAGE already set");
      } else {
        filled.set(5);
      }

      peekAtStorage.add(b);

      return this;
    }

    public TraceBuilder peekAtTransaction(final Boolean b) {
      if (filled.get(38)) {
        throw new IllegalStateException("PEEK_AT_TRANSACTION already set");
      } else {
        filled.set(38);
      }

      peekAtTransaction.add(b);

      return this;
    }

    public TraceBuilder programCounter(final BigInteger b) {
      if (filled.get(22)) {
        throw new IllegalStateException("PROGRAM_COUNTER already set");
      } else {
        filled.set(22);
      }

      programCounter.add(b);

      return this;
    }

    public TraceBuilder programCounterNew(final BigInteger b) {
      if (filled.get(9)) {
        throw new IllegalStateException("PROGRAM_COUNTER_NEW already set");
      } else {
        filled.set(9);
      }

      programCounterNew.add(b);

      return this;
    }

    public TraceBuilder transactionEndStamp(final BigInteger b) {
      if (filled.get(1)) {
        throw new IllegalStateException("TRANSACTION_END_STAMP already set");
      } else {
        filled.set(1);
      }

      transactionEndStamp.add(b);

      return this;
    }

    public TraceBuilder transactionReverts(final BigInteger b) {
      if (filled.get(39)) {
        throw new IllegalStateException("TRANSACTION_REVERTS already set");
      } else {
        filled.set(39);
      }

      transactionReverts.add(b);

      return this;
    }

    public TraceBuilder twoLineInstruction(final Boolean b) {
      if (filled.get(23)) {
        throw new IllegalStateException("TWO_LINE_INSTRUCTION already set");
      } else {
        filled.set(23);
      }

      twoLineInstruction.add(b);

      return this;
    }

    public TraceBuilder txExec(final Boolean b) {
      if (filled.get(37)) {
        throw new IllegalStateException("TX_EXEC already set");
      } else {
        filled.set(37);
      }

      txExec.add(b);

      return this;
    }

    public TraceBuilder txFinl(final Boolean b) {
      if (filled.get(17)) {
        throw new IllegalStateException("TX_FINL already set");
      } else {
        filled.set(17);
      }

      txFinl.add(b);

      return this;
    }

    public TraceBuilder txInit(final Boolean b) {
      if (filled.get(10)) {
        throw new IllegalStateException("TX_INIT already set");
      } else {
        filled.set(10);
      }

      txInit.add(b);

      return this;
    }

    public TraceBuilder txSkip(final Boolean b) {
      if (filled.get(19)) {
        throw new IllegalStateException("TX_SKIP already set");
      } else {
        filled.set(19);
      }

      txSkip.add(b);

      return this;
    }

    public TraceBuilder txWarm(final Boolean b) {
      if (filled.get(35)) {
        throw new IllegalStateException("TX_WARM already set");
      } else {
        filled.set(35);
      }

      txWarm.add(b);

      return this;
    }

    public TraceBuilder setAbortFlagAt(final Boolean b, int i) {
      abortFlag.set(i, b);

      return this;
    }

    public TraceBuilder setAbsoluteTransactionNumberAt(final BigInteger b, int i) {
      absoluteTransactionNumber.set(i, b);

      return this;
    }

    public TraceBuilder setBatchNumberAt(final BigInteger b, int i) {
      batchNumber.set(i, b);

      return this;
    }

    public TraceBuilder setCallerContextNumberAt(final BigInteger b, int i) {
      callerContextNumber.set(i, b);

      return this;
    }

    public TraceBuilder setCodeAddressHiAt(final BigInteger b, int i) {
      codeAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setCodeAddressLoAt(final BigInteger b, int i) {
      codeAddressLo.set(i, b);

      return this;
    }

    public TraceBuilder setCodeDeploymentNumberAt(final BigInteger b, int i) {
      codeDeploymentNumber.set(i, b);

      return this;
    }

    public TraceBuilder setCodeDeploymentStatusAt(final Boolean b, int i) {
      codeDeploymentStatus.set(i, b);

      return this;
    }

    public TraceBuilder setContextGetsRevrtdFlagAt(final Boolean b, int i) {
      contextGetsRevrtdFlag.set(i, b);

      return this;
    }

    public TraceBuilder setContextMayChangeFlagAt(final Boolean b, int i) {
      contextMayChangeFlag.set(i, b);

      return this;
    }

    public TraceBuilder setContextNumberAt(final BigInteger b, int i) {
      contextNumber.set(i, b);

      return this;
    }

    public TraceBuilder setContextNumberNewAt(final BigInteger b, int i) {
      contextNumberNew.set(i, b);

      return this;
    }

    public TraceBuilder setContextRevertStampAt(final BigInteger b, int i) {
      contextRevertStamp.set(i, b);

      return this;
    }

    public TraceBuilder setContextSelfRevrtsFlagAt(final Boolean b, int i) {
      contextSelfRevrtsFlag.set(i, b);

      return this;
    }

    public TraceBuilder setContextWillRevertFlagAt(final Boolean b, int i) {
      contextWillRevertFlag.set(i, b);

      return this;
    }

    public TraceBuilder setCounterNsrAt(final BigInteger b, int i) {
      counterNsr.set(i, b);

      return this;
    }

    public TraceBuilder setCounterTliAt(final Boolean b, int i) {
      counterTli.set(i, b);

      return this;
    }

    public TraceBuilder setExceptionAhoyFlagAt(final Boolean b, int i) {
      exceptionAhoyFlag.set(i, b);

      return this;
    }

    public TraceBuilder setFailureConditionFlagAt(final Boolean b, int i) {
      failureConditionFlag.set(i, b);

      return this;
    }

    public TraceBuilder setGasActualAt(final BigInteger b, int i) {
      gasActual.set(i, b);

      return this;
    }

    public TraceBuilder setGasCostAt(final BigInteger b, int i) {
      gasCost.set(i, b);

      return this;
    }

    public TraceBuilder setGasExpectedAt(final BigInteger b, int i) {
      gasExpected.set(i, b);

      return this;
    }

    public TraceBuilder setGasMemoryExpansionAt(final BigInteger b, int i) {
      gasMemoryExpansion.set(i, b);

      return this;
    }

    public TraceBuilder setGasNextAt(final BigInteger b, int i) {
      gasNext.set(i, b);

      return this;
    }

    public TraceBuilder setGasRefundAt(final BigInteger b, int i) {
      gasRefund.set(i, b);

      return this;
    }

    public TraceBuilder setHubStampAt(final BigInteger b, int i) {
      hubStamp.set(i, b);

      return this;
    }

    public TraceBuilder setNumberOfNonStackRowsAt(final BigInteger b, int i) {
      numberOfNonStackRows.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountAddressHiAt(final BigInteger b, int i) {
      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountAddressLoAt(final BigInteger b, int i) {
      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountBalanceAt(final BigInteger b, int i) {
      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountBalanceNewAt(final BigInteger b, int i) {
      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountCodeHashHiAt(final BigInteger b, int i) {
      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountCodeHashHiNewAt(final BigInteger b, int i) {
      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountCodeHashLoAt(final BigInteger b, int i) {
      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.set(
          i, b);

      return this;
    }

    public TraceBuilder setPAccountCodeHashLoNewAt(final BigInteger b, int i) {
      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.set(
          i, b);

      return this;
    }

    public TraceBuilder setPAccountCodeSizeAt(final BigInteger b, int i) {
      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountCodeSizeNewAt(final BigInteger b, int i) {
      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentNumberAt(final BigInteger b, int i) {
      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentNumberInftyAt(final BigInteger b, int i) {
      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentNumberNewAt(final BigInteger b, int i) {
      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentStatusAt(final BigInteger b, int i) {
      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.set(
          i, b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentStatusInftyAt(final Boolean b, int i) {
      staticFlagXorDeploymentStatusInftyXorWarm.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentStatusNewAt(final BigInteger b, int i) {
      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.set(
          i, b);

      return this;
    }

    public TraceBuilder setPAccountExistsAt(final Boolean b, int i) {
      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountExistsNewAt(final Boolean b, int i) {
      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountHasCodeAt(final Boolean b, int i) {
      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountHasCodeNewAt(final Boolean b, int i) {
      modFlagXorHasCodeNewXorValOrigIsZero.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountIsPrecompileAt(final Boolean b, int i) {
      soxXorIsPrecompileXorValCurrIsOrig.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountNonceAt(final BigInteger b, int i) {
      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountNonceNewAt(final BigInteger b, int i) {
      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountSufficientBalanceAt(final Boolean b, int i) {
      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountWarmAt(final Boolean b, int i) {
      addFlagXorWarmXorValNextIsZero.set(i, b);

      return this;
    }

    public TraceBuilder setPAccountWarmNewAt(final Boolean b, int i) {
      stoFlagXorWarmNewXorWarmNew.set(i, b);

      return this;
    }

    public TraceBuilder setPContextAccountAddressHiAt(final BigInteger b, int i) {
      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.set(i, b);

      return this;
    }

    public TraceBuilder setPContextAccountAddressLoAt(final BigInteger b, int i) {
      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.set(i, b);

      return this;
    }

    public TraceBuilder setPContextAccountDeploymentNumberAt(final BigInteger b, int i) {
      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPContextByteCodeAddressHiAt(final BigInteger b, int i) {
      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPContextByteCodeAddressLoAt(final BigInteger b, int i) {
      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.set(i, b);

      return this;
    }

    public TraceBuilder setPContextByteCodeDeploymentNumberAt(final BigInteger b, int i) {
      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.set(
          i, b);

      return this;
    }

    public TraceBuilder setPContextByteCodeDeploymentStatusAt(final BigInteger b, int i) {
      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.set(
          i, b);

      return this;
    }

    public TraceBuilder setPContextCallDataOffsetAt(final BigInteger b, int i) {
      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.set(i, b);

      return this;
    }

    public TraceBuilder setPContextCallDataSizeAt(final BigInteger b, int i) {
      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.set(i, b);

      return this;
    }

    public TraceBuilder setPContextCallStackDepthAt(final BigInteger b, int i) {
      stackItemHeight1XorCallStackDepth.set(i, b);

      return this;
    }

    public TraceBuilder setPContextCallValueAt(final BigInteger b, int i) {
      stackItemStamp1XorGasLimitXorCallValue.set(i, b);

      return this;
    }

    public TraceBuilder setPContextCallerAddressHiAt(final BigInteger b, int i) {
      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPContextCallerAddressLoAt(final BigInteger b, int i) {
      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.set(
          i, b);

      return this;
    }

    public TraceBuilder setPContextCallerContextNumberAt(final BigInteger b, int i) {
      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.set(i, b);

      return this;
    }

    public TraceBuilder setPContextContextNumberAt(final BigInteger b, int i) {
      stackItemValueLo4XorContextNumber.set(i, b);

      return this;
    }

    public TraceBuilder setPContextIsStaticAt(final BigInteger b, int i) {
      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.set(i, b);

      return this;
    }

    public TraceBuilder setPContextReturnAtOffsetAt(final BigInteger b, int i) {
      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.set(i, b);

      return this;
    }

    public TraceBuilder setPContextReturnAtSizeAt(final BigInteger b, int i) {
      stackItemValueHi3XorReturnAtSize.set(i, b);

      return this;
    }

    public TraceBuilder setPContextReturnDataOffsetAt(final BigInteger b, int i) {
      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.set(
          i, b);

      return this;
    }

    public TraceBuilder setPContextReturnDataSizeAt(final BigInteger b, int i) {
      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.set(i, b);

      return this;
    }

    public TraceBuilder setPContextReturnerContextNumberAt(final BigInteger b, int i) {
      stackItemValueLo2XorReturnerContextNumber.set(i, b);

      return this;
    }

    public TraceBuilder setPContextReturnerIsPrecompileAt(final BigInteger b, int i) {
      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.set(i, b);

      return this;
    }

    public TraceBuilder setPContextUpdateAt(final Boolean b, int i) {
      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.set(i, b);

      return this;
    }

    public TraceBuilder setPStackAccFlagAt(final Boolean b, int i) {
      accFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackAddFlagAt(final Boolean b, int i) {
      addFlagXorWarmXorValNextIsZero.set(i, b);

      return this;
    }

    public TraceBuilder setPStackBinFlagAt(final Boolean b, int i) {
      binFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackBtcFlagAt(final Boolean b, int i) {
      btcFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackCallFlagAt(final Boolean b, int i) {
      callFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackConFlagAt(final Boolean b, int i) {
      conFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackCopyFlagAt(final Boolean b, int i) {
      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.set(i, b);

      return this;
    }

    public TraceBuilder setPStackCreateFlagAt(final Boolean b, int i) {
      createFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackDecodedFlag1At(final Boolean b, int i) {
      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.set(i, b);

      return this;
    }

    public TraceBuilder setPStackDecodedFlag2At(final Boolean b, int i) {
      decodedFlag2.set(i, b);

      return this;
    }

    public TraceBuilder setPStackDecodedFlag3At(final Boolean b, int i) {
      decodedFlag3.set(i, b);

      return this;
    }

    public TraceBuilder setPStackDecodedFlag4At(final Boolean b, int i) {
      decodedFlag4.set(i, b);

      return this;
    }

    public TraceBuilder setPStackDupFlagAt(final Boolean b, int i) {
      dupFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackExtFlagAt(final Boolean b, int i) {
      extFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackHaltFlagAt(final Boolean b, int i) {
      haltFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackHeightAt(final BigInteger b, int i) {
      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.set(i, b);

      return this;
    }

    public TraceBuilder setPStackHeightNewAt(final BigInteger b, int i) {
      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.set(i, b);

      return this;
    }

    public TraceBuilder setPStackHeightOverAt(final BigInteger b, int i) {
      heightOver.set(i, b);

      return this;
    }

    public TraceBuilder setPStackHeightUnderAt(final BigInteger b, int i) {
      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.set(i, b);

      return this;
    }

    public TraceBuilder setPStackInstructionAt(final BigInteger b, int i) {
      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPStackInvalidFlagAt(final Boolean b, int i) {
      invalidFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackInvprexAt(final Boolean b, int i) {
      invprex.set(i, b);

      return this;
    }

    public TraceBuilder setPStackJumpFlagAt(final Boolean b, int i) {
      jumpFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackJumpxAt(final Boolean b, int i) {
      jumpx.set(i, b);

      return this;
    }

    public TraceBuilder setPStackKecFlagAt(final Boolean b, int i) {
      kecFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackLogFlagAt(final Boolean b, int i) {
      logFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackMaxcsxAt(final Boolean b, int i) {
      maxcsx.set(i, b);

      return this;
    }

    public TraceBuilder setPStackModFlagAt(final Boolean b, int i) {
      modFlagXorHasCodeNewXorValOrigIsZero.set(i, b);

      return this;
    }

    public TraceBuilder setPStackMulFlagAt(final Boolean b, int i) {
      mulFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackMxpFlagAt(final Boolean b, int i) {
      mxpFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackMxpxAt(final Boolean b, int i) {
      mxpx.set(i, b);

      return this;
    }

    public TraceBuilder setPStackOobFlagAt(final Boolean b, int i) {
      oobFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackOogxAt(final Boolean b, int i) {
      oogx.set(i, b);

      return this;
    }

    public TraceBuilder setPStackOpcxAt(final Boolean b, int i) {
      opcx.set(i, b);

      return this;
    }

    public TraceBuilder setPStackPushValueHiAt(final BigInteger b, int i) {
      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.set(
          i, b);

      return this;
    }

    public TraceBuilder setPStackPushValueLoAt(final BigInteger b, int i) {
      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.set(i, b);

      return this;
    }

    public TraceBuilder setPStackPushpopFlagAt(final Boolean b, int i) {
      pushpopFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackRdcxAt(final Boolean b, int i) {
      rdcx.set(i, b);

      return this;
    }

    public TraceBuilder setPStackShfFlagAt(final Boolean b, int i) {
      shfFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackSoxAt(final Boolean b, int i) {
      soxXorIsPrecompileXorValCurrIsOrig.set(i, b);

      return this;
    }

    public TraceBuilder setPStackSstorexAt(final Boolean b, int i) {
      sstorex.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemHeight1At(final BigInteger b, int i) {
      stackItemHeight1XorCallStackDepth.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemHeight2At(final BigInteger b, int i) {
      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.set(
          i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemHeight3At(final BigInteger b, int i) {
      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemHeight4At(final BigInteger b, int i) {
      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.set(
          i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemPop1At(final Boolean b, int i) {
      stackItemPop1.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemPop2At(final Boolean b, int i) {
      stackItemPop2.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemPop3At(final Boolean b, int i) {
      stackItemPop3.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemPop4At(final Boolean b, int i) {
      stackItemPop4.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemStamp1At(final BigInteger b, int i) {
      stackItemStamp1XorGasLimitXorCallValue.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemStamp2At(final BigInteger b, int i) {
      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemStamp3At(final BigInteger b, int i) {
      stackItemStamp3.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemStamp4At(final BigInteger b, int i) {
      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.set(
          i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueHi1At(final BigInteger b, int i) {
      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueHi2At(final BigInteger b, int i) {
      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueHi3At(final BigInteger b, int i) {
      stackItemValueHi3XorReturnAtSize.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueHi4At(final BigInteger b, int i) {
      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueLo1At(final BigInteger b, int i) {
      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueLo2At(final BigInteger b, int i) {
      stackItemValueLo2XorReturnerContextNumber.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueLo3At(final BigInteger b, int i) {
      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueLo4At(final BigInteger b, int i) {
      stackItemValueLo4XorContextNumber.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStackramFlagAt(final Boolean b, int i) {
      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStaticFlagAt(final Boolean b, int i) {
      staticFlagXorDeploymentStatusInftyXorWarm.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStaticGasAt(final BigInteger b, int i) {
      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStaticxAt(final Boolean b, int i) {
      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.set(i, b);

      return this;
    }

    public TraceBuilder setPStackStoFlagAt(final Boolean b, int i) {
      stoFlagXorWarmNewXorWarmNew.set(i, b);

      return this;
    }

    public TraceBuilder setPStackSuxAt(final Boolean b, int i) {
      sux.set(i, b);

      return this;
    }

    public TraceBuilder setPStackSwapFlagAt(final Boolean b, int i) {
      swapFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackTrmFlagAt(final Boolean b, int i) {
      trmFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackTxnFlagAt(final Boolean b, int i) {
      txnFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStackWcpFlagAt(final Boolean b, int i) {
      wcpFlag.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageAddressHiAt(final BigInteger b, int i) {
      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageAddressLoAt(final BigInteger b, int i) {
      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.set(
          i, b);

      return this;
    }

    public TraceBuilder setPStorageDeploymentNumberAt(final BigInteger b, int i) {
      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.set(
          i, b);

      return this;
    }

    public TraceBuilder setPStorageStorageKeyHiAt(final BigInteger b, int i) {
      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageStorageKeyLoAt(final BigInteger b, int i) {
      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.set(
          i, b);

      return this;
    }

    public TraceBuilder setPStorageValCurrChangesAt(final Boolean b, int i) {
      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValCurrHiAt(final BigInteger b, int i) {
      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValCurrIsOrigAt(final Boolean b, int i) {
      soxXorIsPrecompileXorValCurrIsOrig.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValCurrIsZeroAt(final Boolean b, int i) {
      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValCurrLoAt(final BigInteger b, int i) {
      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValNextHiAt(final BigInteger b, int i) {
      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValNextIsCurrAt(final Boolean b, int i) {
      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValNextIsOrigAt(final Boolean b, int i) {
      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValNextIsZeroAt(final Boolean b, int i) {
      addFlagXorWarmXorValNextIsZero.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValNextLoAt(final BigInteger b, int i) {
      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValOrigHiAt(final BigInteger b, int i) {
      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.set(
          i, b);

      return this;
    }

    public TraceBuilder setPStorageValOrigIsZeroAt(final Boolean b, int i) {
      modFlagXorHasCodeNewXorValOrigIsZero.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageValOrigLoAt(final BigInteger b, int i) {
      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageWarmAt(final Boolean b, int i) {
      staticFlagXorDeploymentStatusInftyXorWarm.set(i, b);

      return this;
    }

    public TraceBuilder setPStorageWarmNewAt(final Boolean b, int i) {
      stoFlagXorWarmNewXorWarmNew.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionBasefeeAt(final BigInteger b, int i) {
      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionCallDataSizeAt(final BigInteger b, int i) {
      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionCoinbaseAddressHiAt(final BigInteger b, int i) {
      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.set(
          i, b);

      return this;
    }

    public TraceBuilder setPTransactionCoinbaseAddressLoAt(final BigInteger b, int i) {
      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.set(
          i, b);

      return this;
    }

    public TraceBuilder setPTransactionFromAddressHiAt(final BigInteger b, int i) {
      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionFromAddressLoAt(final BigInteger b, int i) {
      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionGasLimitAt(final BigInteger b, int i) {
      stackItemStamp1XorGasLimitXorCallValue.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionGasPriceAt(final BigInteger b, int i) {
      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionGasRefundAmountAt(final BigInteger b, int i) {
      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionGasRefundCounterFinalAt(final BigInteger b, int i) {
      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionInitCodeSizeAt(final BigInteger b, int i) {
      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionInitGasAt(final BigInteger b, int i) {
      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionInitialBalanceAt(final BigInteger b, int i) {
      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionIsDeploymentAt(final Boolean b, int i) {
      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionIsEip1559At(final Boolean b, int i) {
      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionLeftoverGasAt(final BigInteger b, int i) {
      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionNonceAt(final BigInteger b, int i) {
      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionStatusCodeAt(final Boolean b, int i) {
      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionToAddressHiAt(final BigInteger b, int i) {
      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionToAddressLoAt(final BigInteger b, int i) {
      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.set(
          i, b);

      return this;
    }

    public TraceBuilder setPTransactionTxnRequiresEvmExecutionAt(final Boolean b, int i) {
      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.set(i, b);

      return this;
    }

    public TraceBuilder setPTransactionValueAt(final BigInteger b, int i) {
      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.set(
          i, b);

      return this;
    }

    public TraceBuilder setPeekAtAccountAt(final Boolean b, int i) {
      peekAtAccount.set(i, b);

      return this;
    }

    public TraceBuilder setPeekAtContextAt(final Boolean b, int i) {
      peekAtContext.set(i, b);

      return this;
    }

    public TraceBuilder setPeekAtStackAt(final Boolean b, int i) {
      peekAtStack.set(i, b);

      return this;
    }

    public TraceBuilder setPeekAtStorageAt(final Boolean b, int i) {
      peekAtStorage.set(i, b);

      return this;
    }

    public TraceBuilder setPeekAtTransactionAt(final Boolean b, int i) {
      peekAtTransaction.set(i, b);

      return this;
    }

    public TraceBuilder setProgramCounterAt(final BigInteger b, int i) {
      programCounter.set(i, b);

      return this;
    }

    public TraceBuilder setProgramCounterNewAt(final BigInteger b, int i) {
      programCounterNew.set(i, b);

      return this;
    }

    public TraceBuilder setTransactionEndStampAt(final BigInteger b, int i) {
      transactionEndStamp.set(i, b);

      return this;
    }

    public TraceBuilder setTransactionRevertsAt(final BigInteger b, int i) {
      transactionReverts.set(i, b);

      return this;
    }

    public TraceBuilder setTwoLineInstructionAt(final Boolean b, int i) {
      twoLineInstruction.set(i, b);

      return this;
    }

    public TraceBuilder setTxExecAt(final Boolean b, int i) {
      txExec.set(i, b);

      return this;
    }

    public TraceBuilder setTxFinlAt(final Boolean b, int i) {
      txFinl.set(i, b);

      return this;
    }

    public TraceBuilder setTxInitAt(final Boolean b, int i) {
      txInit.set(i, b);

      return this;
    }

    public TraceBuilder setTxSkipAt(final Boolean b, int i) {
      txSkip.set(i, b);

      return this;
    }

    public TraceBuilder setTxWarmAt(final Boolean b, int i) {
      txWarm.set(i, b);

      return this;
    }

    public TraceBuilder setAbortFlagRelative(final Boolean b, int i) {
      abortFlag.set(abortFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setAbsoluteTransactionNumberRelative(final BigInteger b, int i) {
      absoluteTransactionNumber.set(absoluteTransactionNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setBatchNumberRelative(final BigInteger b, int i) {
      batchNumber.set(batchNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setCallerContextNumberRelative(final BigInteger b, int i) {
      callerContextNumber.set(callerContextNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setCodeAddressHiRelative(final BigInteger b, int i) {
      codeAddressHi.set(codeAddressHi.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setCodeAddressLoRelative(final BigInteger b, int i) {
      codeAddressLo.set(codeAddressLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setCodeDeploymentNumberRelative(final BigInteger b, int i) {
      codeDeploymentNumber.set(codeDeploymentNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setCodeDeploymentStatusRelative(final Boolean b, int i) {
      codeDeploymentStatus.set(codeDeploymentStatus.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setContextGetsRevrtdFlagRelative(final Boolean b, int i) {
      contextGetsRevrtdFlag.set(contextGetsRevrtdFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setContextMayChangeFlagRelative(final Boolean b, int i) {
      contextMayChangeFlag.set(contextMayChangeFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setContextNumberRelative(final BigInteger b, int i) {
      contextNumber.set(contextNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setContextNumberNewRelative(final BigInteger b, int i) {
      contextNumberNew.set(contextNumberNew.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setContextRevertStampRelative(final BigInteger b, int i) {
      contextRevertStamp.set(contextRevertStamp.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setContextSelfRevrtsFlagRelative(final Boolean b, int i) {
      contextSelfRevrtsFlag.set(contextSelfRevrtsFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setContextWillRevertFlagRelative(final Boolean b, int i) {
      contextWillRevertFlag.set(contextWillRevertFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setCounterNsrRelative(final BigInteger b, int i) {
      counterNsr.set(counterNsr.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setCounterTliRelative(final Boolean b, int i) {
      counterTli.set(counterTli.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setExceptionAhoyFlagRelative(final Boolean b, int i) {
      exceptionAhoyFlag.set(exceptionAhoyFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setFailureConditionFlagRelative(final Boolean b, int i) {
      failureConditionFlag.set(failureConditionFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setGasActualRelative(final BigInteger b, int i) {
      gasActual.set(gasActual.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setGasCostRelative(final BigInteger b, int i) {
      gasCost.set(gasCost.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setGasExpectedRelative(final BigInteger b, int i) {
      gasExpected.set(gasExpected.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setGasMemoryExpansionRelative(final BigInteger b, int i) {
      gasMemoryExpansion.set(gasMemoryExpansion.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setGasNextRelative(final BigInteger b, int i) {
      gasNext.set(gasNext.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setGasRefundRelative(final BigInteger b, int i) {
      gasRefund.set(gasRefund.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setHubStampRelative(final BigInteger b, int i) {
      hubStamp.set(hubStamp.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setNumberOfNonStackRowsRelative(final BigInteger b, int i) {
      numberOfNonStackRows.set(numberOfNonStackRows.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountAddressHiRelative(final BigInteger b, int i) {
      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.set(
          stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPAccountAddressLoRelative(final BigInteger b, int i) {
      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.set(
          heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPAccountBalanceRelative(final BigInteger b, int i) {
      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.set(
          pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountBalanceNewRelative(final BigInteger b, int i) {
      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.set(
          stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPAccountCodeHashHiRelative(final BigInteger b, int i) {
      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.set(
          stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountCodeHashHiNewRelative(final BigInteger b, int i) {
      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.set(
          stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPAccountCodeHashLoRelative(final BigInteger b, int i) {
      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.set(
          pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPAccountCodeHashLoNewRelative(final BigInteger b, int i) {
      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.set(
          stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPAccountCodeSizeRelative(final BigInteger b, int i) {
      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.set(
          heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountCodeSizeNewRelative(final BigInteger b, int i) {
      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.set(
          staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentNumberRelative(final BigInteger b, int i) {
      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.set(
          stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentNumberInftyRelative(final BigInteger b, int i) {
      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.set(
          heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentNumberNewRelative(final BigInteger b, int i) {
      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.set(
          stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentStatusRelative(final BigInteger b, int i) {
      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.set(
          stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentStatusInftyRelative(final Boolean b, int i) {
      staticFlagXorDeploymentStatusInftyXorWarm.set(
          staticFlagXorDeploymentStatusInftyXorWarm.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountDeploymentStatusNewRelative(final BigInteger b, int i) {
      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.set(
          stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPAccountExistsRelative(final Boolean b, int i) {
      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.set(
          staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountExistsNewRelative(final Boolean b, int i) {
      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.set(
          updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountHasCodeRelative(final Boolean b, int i) {
      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.set(
          copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountHasCodeNewRelative(final Boolean b, int i) {
      modFlagXorHasCodeNewXorValOrigIsZero.set(
          modFlagXorHasCodeNewXorValOrigIsZero.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountIsPrecompileRelative(final Boolean b, int i) {
      soxXorIsPrecompileXorValCurrIsOrig.set(soxXorIsPrecompileXorValCurrIsOrig.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountNonceRelative(final BigInteger b, int i) {
      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.set(
          instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountNonceNewRelative(final BigInteger b, int i) {
      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.set(
          stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountSufficientBalanceRelative(final Boolean b, int i) {
      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.set(
          stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountWarmRelative(final Boolean b, int i) {
      addFlagXorWarmXorValNextIsZero.set(addFlagXorWarmXorValNextIsZero.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPAccountWarmNewRelative(final Boolean b, int i) {
      stoFlagXorWarmNewXorWarmNew.set(stoFlagXorWarmNewXorWarmNew.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextAccountAddressHiRelative(final BigInteger b, int i) {
      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.set(
          staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextAccountAddressLoRelative(final BigInteger b, int i) {
      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.set(
          stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPContextAccountDeploymentNumberRelative(final BigInteger b, int i) {
      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.set(
          stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPContextByteCodeAddressHiRelative(final BigInteger b, int i) {
      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.set(
          instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextByteCodeAddressLoRelative(final BigInteger b, int i) {
      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.set(
          stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPContextByteCodeDeploymentNumberRelative(final BigInteger b, int i) {
      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.set(
          stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPContextByteCodeDeploymentStatusRelative(final BigInteger b, int i) {
      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.set(
          pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPContextCallDataOffsetRelative(final BigInteger b, int i) {
      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.set(
          stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextCallDataSizeRelative(final BigInteger b, int i) {
      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.set(
          stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextCallStackDepthRelative(final BigInteger b, int i) {
      stackItemHeight1XorCallStackDepth.set(stackItemHeight1XorCallStackDepth.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextCallValueRelative(final BigInteger b, int i) {
      stackItemStamp1XorGasLimitXorCallValue.set(
          stackItemStamp1XorGasLimitXorCallValue.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextCallerAddressHiRelative(final BigInteger b, int i) {
      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.set(
          stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextCallerAddressLoRelative(final BigInteger b, int i) {
      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.set(
          stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPContextCallerContextNumberRelative(final BigInteger b, int i) {
      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.set(
          pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextContextNumberRelative(final BigInteger b, int i) {
      stackItemValueLo4XorContextNumber.set(stackItemValueLo4XorContextNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextIsStaticRelative(final BigInteger b, int i) {
      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.set(
          stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPContextReturnAtOffsetRelative(final BigInteger b, int i) {
      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.set(
          heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextReturnAtSizeRelative(final BigInteger b, int i) {
      stackItemValueHi3XorReturnAtSize.set(stackItemValueHi3XorReturnAtSize.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextReturnDataOffsetRelative(final BigInteger b, int i) {
      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.set(
          stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPContextReturnDataSizeRelative(final BigInteger b, int i) {
      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.set(
          heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextReturnerContextNumberRelative(final BigInteger b, int i) {
      stackItemValueLo2XorReturnerContextNumber.set(
          stackItemValueLo2XorReturnerContextNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPContextReturnerIsPrecompileRelative(final BigInteger b, int i) {
      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.set(
          heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPContextUpdateRelative(final Boolean b, int i) {
      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.set(
          updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackAccFlagRelative(final Boolean b, int i) {
      accFlag.set(accFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackAddFlagRelative(final Boolean b, int i) {
      addFlagXorWarmXorValNextIsZero.set(addFlagXorWarmXorValNextIsZero.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackBinFlagRelative(final Boolean b, int i) {
      binFlag.set(binFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackBtcFlagRelative(final Boolean b, int i) {
      btcFlag.set(btcFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackCallFlagRelative(final Boolean b, int i) {
      callFlag.set(callFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackConFlagRelative(final Boolean b, int i) {
      conFlag.set(conFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackCopyFlagRelative(final Boolean b, int i) {
      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.set(
          copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackCreateFlagRelative(final Boolean b, int i) {
      createFlag.set(createFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackDecodedFlag1Relative(final Boolean b, int i) {
      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.set(
          updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackDecodedFlag2Relative(final Boolean b, int i) {
      decodedFlag2.set(decodedFlag2.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackDecodedFlag3Relative(final Boolean b, int i) {
      decodedFlag3.set(decodedFlag3.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackDecodedFlag4Relative(final Boolean b, int i) {
      decodedFlag4.set(decodedFlag4.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackDupFlagRelative(final Boolean b, int i) {
      dupFlag.set(dupFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackExtFlagRelative(final Boolean b, int i) {
      extFlag.set(extFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackHaltFlagRelative(final Boolean b, int i) {
      haltFlag.set(haltFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackHeightRelative(final BigInteger b, int i) {
      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.set(
          heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackHeightNewRelative(final BigInteger b, int i) {
      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.set(
          heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStackHeightOverRelative(final BigInteger b, int i) {
      heightOver.set(heightOver.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackHeightUnderRelative(final BigInteger b, int i) {
      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.set(
          heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackInstructionRelative(final BigInteger b, int i) {
      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.set(
          instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackInvalidFlagRelative(final Boolean b, int i) {
      invalidFlag.set(invalidFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackInvprexRelative(final Boolean b, int i) {
      invprex.set(invprex.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackJumpFlagRelative(final Boolean b, int i) {
      jumpFlag.set(jumpFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackJumpxRelative(final Boolean b, int i) {
      jumpx.set(jumpx.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackKecFlagRelative(final Boolean b, int i) {
      kecFlag.set(kecFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackLogFlagRelative(final Boolean b, int i) {
      logFlag.set(logFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackMaxcsxRelative(final Boolean b, int i) {
      maxcsx.set(maxcsx.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackModFlagRelative(final Boolean b, int i) {
      modFlagXorHasCodeNewXorValOrigIsZero.set(
          modFlagXorHasCodeNewXorValOrigIsZero.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackMulFlagRelative(final Boolean b, int i) {
      mulFlag.set(mulFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackMxpFlagRelative(final Boolean b, int i) {
      mxpFlag.set(mxpFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackMxpxRelative(final Boolean b, int i) {
      mxpx.set(mxpx.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackOobFlagRelative(final Boolean b, int i) {
      oobFlag.set(oobFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackOogxRelative(final Boolean b, int i) {
      oogx.set(oogx.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackOpcxRelative(final Boolean b, int i) {
      opcx.set(opcx.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackPushValueHiRelative(final BigInteger b, int i) {
      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.set(
          pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStackPushValueLoRelative(final BigInteger b, int i) {
      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.set(
          pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackPushpopFlagRelative(final Boolean b, int i) {
      pushpopFlag.set(pushpopFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackRdcxRelative(final Boolean b, int i) {
      rdcx.set(rdcx.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackShfFlagRelative(final Boolean b, int i) {
      shfFlag.set(shfFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackSoxRelative(final Boolean b, int i) {
      soxXorIsPrecompileXorValCurrIsOrig.set(soxXorIsPrecompileXorValCurrIsOrig.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackSstorexRelative(final Boolean b, int i) {
      sstorex.set(sstorex.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemHeight1Relative(final BigInteger b, int i) {
      stackItemHeight1XorCallStackDepth.set(stackItemHeight1XorCallStackDepth.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemHeight2Relative(final BigInteger b, int i) {
      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.set(
          stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStackStackItemHeight3Relative(final BigInteger b, int i) {
      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.set(
          stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStackStackItemHeight4Relative(final BigInteger b, int i) {
      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.set(
          stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStackStackItemPop1Relative(final Boolean b, int i) {
      stackItemPop1.set(stackItemPop1.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemPop2Relative(final Boolean b, int i) {
      stackItemPop2.set(stackItemPop2.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemPop3Relative(final Boolean b, int i) {
      stackItemPop3.set(stackItemPop3.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemPop4Relative(final Boolean b, int i) {
      stackItemPop4.set(stackItemPop4.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemStamp1Relative(final BigInteger b, int i) {
      stackItemStamp1XorGasLimitXorCallValue.set(
          stackItemStamp1XorGasLimitXorCallValue.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemStamp2Relative(final BigInteger b, int i) {
      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.set(
          stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemStamp3Relative(final BigInteger b, int i) {
      stackItemStamp3.set(stackItemStamp3.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemStamp4Relative(final BigInteger b, int i) {
      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.set(
          stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueHi1Relative(final BigInteger b, int i) {
      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.set(
          stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueHi2Relative(final BigInteger b, int i) {
      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.set(
          stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueHi3Relative(final BigInteger b, int i) {
      stackItemValueHi3XorReturnAtSize.set(stackItemValueHi3XorReturnAtSize.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueHi4Relative(final BigInteger b, int i) {
      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.set(
          stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueLo1Relative(final BigInteger b, int i) {
      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.set(
          stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueLo2Relative(final BigInteger b, int i) {
      stackItemValueLo2XorReturnerContextNumber.set(
          stackItemValueLo2XorReturnerContextNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueLo3Relative(final BigInteger b, int i) {
      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.set(
          stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStackStackItemValueLo4Relative(final BigInteger b, int i) {
      stackItemValueLo4XorContextNumber.set(stackItemValueLo4XorContextNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStackramFlagRelative(final Boolean b, int i) {
      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.set(
          stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStaticFlagRelative(final Boolean b, int i) {
      staticFlagXorDeploymentStatusInftyXorWarm.set(
          staticFlagXorDeploymentStatusInftyXorWarm.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStaticGasRelative(final BigInteger b, int i) {
      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.set(
          staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStaticxRelative(final Boolean b, int i) {
      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.set(
          staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackStoFlagRelative(final Boolean b, int i) {
      stoFlagXorWarmNewXorWarmNew.set(stoFlagXorWarmNewXorWarmNew.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackSuxRelative(final Boolean b, int i) {
      sux.set(sux.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackSwapFlagRelative(final Boolean b, int i) {
      swapFlag.set(swapFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackTrmFlagRelative(final Boolean b, int i) {
      trmFlag.set(trmFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackTxnFlagRelative(final Boolean b, int i) {
      txnFlag.set(txnFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStackWcpFlagRelative(final Boolean b, int i) {
      wcpFlag.set(wcpFlag.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageAddressHiRelative(final BigInteger b, int i) {
      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.set(
          stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStorageAddressLoRelative(final BigInteger b, int i) {
      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.set(
          stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStorageDeploymentNumberRelative(final BigInteger b, int i) {
      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.set(
          stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStorageStorageKeyHiRelative(final BigInteger b, int i) {
      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.set(
          heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStorageStorageKeyLoRelative(final BigInteger b, int i) {
      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.set(
          pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStorageValCurrChangesRelative(final Boolean b, int i) {
      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.set(
          staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageValCurrHiRelative(final BigInteger b, int i) {
      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.set(
          stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStorageValCurrIsOrigRelative(final Boolean b, int i) {
      soxXorIsPrecompileXorValCurrIsOrig.set(soxXorIsPrecompileXorValCurrIsOrig.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageValCurrIsZeroRelative(final Boolean b, int i) {
      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.set(
          updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageValCurrLoRelative(final BigInteger b, int i) {
      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.set(
          stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageValNextHiRelative(final BigInteger b, int i) {
      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.set(
          stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStorageValNextIsCurrRelative(final Boolean b, int i) {
      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.set(
          stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageValNextIsOrigRelative(final Boolean b, int i) {
      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.set(
          copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageValNextIsZeroRelative(final Boolean b, int i) {
      addFlagXorWarmXorValNextIsZero.set(addFlagXorWarmXorValNextIsZero.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageValNextLoRelative(final BigInteger b, int i) {
      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.set(
          staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageValOrigHiRelative(final BigInteger b, int i) {
      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.set(
          stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStorageValOrigIsZeroRelative(final Boolean b, int i) {
      modFlagXorHasCodeNewXorValOrigIsZero.set(
          modFlagXorHasCodeNewXorValOrigIsZero.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageValOrigLoRelative(final BigInteger b, int i) {
      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.set(
          stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPStorageWarmRelative(final Boolean b, int i) {
      staticFlagXorDeploymentStatusInftyXorWarm.set(
          staticFlagXorDeploymentStatusInftyXorWarm.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPStorageWarmNewRelative(final Boolean b, int i) {
      stoFlagXorWarmNewXorWarmNew.set(stoFlagXorWarmNewXorWarmNew.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionBasefeeRelative(final BigInteger b, int i) {
      staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.set(
          staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionCallDataSizeRelative(final BigInteger b, int i) {
      pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.set(
          pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionCoinbaseAddressHiRelative(final BigInteger b, int i) {
      pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.set(
          pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPTransactionCoinbaseAddressLoRelative(final BigInteger b, int i) {
      stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.set(
          stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPTransactionFromAddressHiRelative(final BigInteger b, int i) {
      stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.set(
          stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPTransactionFromAddressLoRelative(final BigInteger b, int i) {
      heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.set(
          heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionGasLimitRelative(final BigInteger b, int i) {
      stackItemStamp1XorGasLimitXorCallValue.set(
          stackItemStamp1XorGasLimitXorCallValue.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionGasPriceRelative(final BigInteger b, int i) {
      stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.set(
          stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionGasRefundAmountRelative(final BigInteger b, int i) {
      heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.set(
          heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPTransactionGasRefundCounterFinalRelative(final BigInteger b, int i) {
      heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.set(
          heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionInitCodeSizeRelative(final BigInteger b, int i) {
      instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.set(
          instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionInitGasRelative(final BigInteger b, int i) {
      stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.set(
          stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionInitialBalanceRelative(final BigInteger b, int i) {
      stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.set(
          stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPTransactionIsDeploymentRelative(final Boolean b, int i) {
      updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.set(
          updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionIsEip1559Relative(final Boolean b, int i) {
      copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.set(
          copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionLeftoverGasRelative(final BigInteger b, int i) {
      stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.set(
          stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPTransactionNonceRelative(final BigInteger b, int i) {
      stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.set(
          stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPTransactionStatusCodeRelative(final Boolean b, int i) {
      stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.set(
          stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionToAddressHiRelative(final BigInteger b, int i) {
      stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.set(
          stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionToAddressLoRelative(final BigInteger b, int i) {
      stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.set(
          stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPTransactionTxnRequiresEvmExecutionRelative(final Boolean b, int i) {
      staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.set(
          staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPTransactionValueRelative(final BigInteger b, int i) {
      stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.set(
          stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi
                  .size()
              - 1
              - i,
          b);

      return this;
    }

    public TraceBuilder setPeekAtAccountRelative(final Boolean b, int i) {
      peekAtAccount.set(peekAtAccount.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPeekAtContextRelative(final Boolean b, int i) {
      peekAtContext.set(peekAtContext.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPeekAtStackRelative(final Boolean b, int i) {
      peekAtStack.set(peekAtStack.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPeekAtStorageRelative(final Boolean b, int i) {
      peekAtStorage.set(peekAtStorage.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setPeekAtTransactionRelative(final Boolean b, int i) {
      peekAtTransaction.set(peekAtTransaction.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setProgramCounterRelative(final BigInteger b, int i) {
      programCounter.set(programCounter.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setProgramCounterNewRelative(final BigInteger b, int i) {
      programCounterNew.set(programCounterNew.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setTransactionEndStampRelative(final BigInteger b, int i) {
      transactionEndStamp.set(transactionEndStamp.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setTransactionRevertsRelative(final BigInteger b, int i) {
      transactionReverts.set(transactionReverts.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setTwoLineInstructionRelative(final Boolean b, int i) {
      twoLineInstruction.set(twoLineInstruction.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setTxExecRelative(final Boolean b, int i) {
      txExec.set(txExec.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setTxFinlRelative(final Boolean b, int i) {
      txFinl.set(txFinl.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setTxInitRelative(final Boolean b, int i) {
      txInit.set(txInit.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setTxSkipRelative(final Boolean b, int i) {
      txSkip.set(txSkip.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder setTxWarmRelative(final Boolean b, int i) {
      txWarm.set(txWarm.size() - 1 - i, b);

      return this;
    }

    public TraceBuilder validateRow() {
      if (!filled.get(4)) {
        throw new IllegalStateException("ABORT_FLAG has not been filled");
      }

      if (!filled.get(13)) {
        throw new IllegalStateException("ABSOLUTE_TRANSACTION_NUMBER has not been filled");
      }

      if (!filled.get(80)) {
        throw new IllegalStateException("ACC_FLAG has not been filled");
      }

      if (!filled.get(73)) {
        throw new IllegalStateException(
            "ADD_FLAG_xor_WARM_xor_VAL_NEXT_IS_ZERO has not been filled");
      }

      if (!filled.get(15)) {
        throw new IllegalStateException("BATCH_NUMBER has not been filled");
      }

      if (!filled.get(101)) {
        throw new IllegalStateException("BIN_FLAG has not been filled");
      }

      if (!filled.get(93)) {
        throw new IllegalStateException("BTC_FLAG has not been filled");
      }

      if (!filled.get(95)) {
        throw new IllegalStateException("CALL_FLAG has not been filled");
      }

      if (!filled.get(11)) {
        throw new IllegalStateException("CALLER_CONTEXT_NUMBER has not been filled");
      }

      if (!filled.get(36)) {
        throw new IllegalStateException("CODE_ADDRESS_HI has not been filled");
      }

      if (!filled.get(31)) {
        throw new IllegalStateException("CODE_ADDRESS_LO has not been filled");
      }

      if (!filled.get(12)) {
        throw new IllegalStateException("CODE_DEPLOYMENT_NUMBER has not been filled");
      }

      if (!filled.get(16)) {
        throw new IllegalStateException("CODE_DEPLOYMENT_STATUS has not been filled");
      }

      if (!filled.get(77)) {
        throw new IllegalStateException("CON_FLAG has not been filled");
      }

      if (!filled.get(21)) {
        throw new IllegalStateException("CONTEXT_GETS_REVRTD_FLAG has not been filled");
      }

      if (!filled.get(26)) {
        throw new IllegalStateException("CONTEXT_MAY_CHANGE_FLAG has not been filled");
      }

      if (!filled.get(41)) {
        throw new IllegalStateException("CONTEXT_NUMBER has not been filled");
      }

      if (!filled.get(2)) {
        throw new IllegalStateException("CONTEXT_NUMBER_NEW has not been filled");
      }

      if (!filled.get(32)) {
        throw new IllegalStateException("CONTEXT_REVERT_STAMP has not been filled");
      }

      if (!filled.get(34)) {
        throw new IllegalStateException("CONTEXT_SELF_REVRTS_FLAG has not been filled");
      }

      if (!filled.get(20)) {
        throw new IllegalStateException("CONTEXT_WILL_REVERT_FLAG has not been filled");
      }

      if (!filled.get(67)) {
        throw new IllegalStateException(
            "COPY_FLAG_xor_HAS_CODE_xor_VAL_NEXT_IS_ORIG_xor_IS_EIP1559 has not been filled");
      }

      if (!filled.get(40)) {
        throw new IllegalStateException("COUNTER_NSR has not been filled");
      }

      if (!filled.get(25)) {
        throw new IllegalStateException("COUNTER_TLI has not been filled");
      }

      if (!filled.get(103)) {
        throw new IllegalStateException("CREATE_FLAG has not been filled");
      }

      if (!filled.get(99)) {
        throw new IllegalStateException("DECODED_FLAG_2 has not been filled");
      }

      if (!filled.get(92)) {
        throw new IllegalStateException("DECODED_FLAG_3 has not been filled");
      }

      if (!filled.get(84)) {
        throw new IllegalStateException("DECODED_FLAG_4 has not been filled");
      }

      if (!filled.get(94)) {
        throw new IllegalStateException("DUP_FLAG has not been filled");
      }

      if (!filled.get(24)) {
        throw new IllegalStateException("EXCEPTION_AHOY_FLAG has not been filled");
      }

      if (!filled.get(112)) {
        throw new IllegalStateException("EXT_FLAG has not been filled");
      }

      if (!filled.get(27)) {
        throw new IllegalStateException("FAILURE_CONDITION_FLAG has not been filled");
      }

      if (!filled.get(6)) {
        throw new IllegalStateException("GAS_ACTUAL has not been filled");
      }

      if (!filled.get(28)) {
        throw new IllegalStateException("GAS_COST has not been filled");
      }

      if (!filled.get(30)) {
        throw new IllegalStateException("GAS_EXPECTED has not been filled");
      }

      if (!filled.get(8)) {
        throw new IllegalStateException("GAS_MEMORY_EXPANSION has not been filled");
      }

      if (!filled.get(0)) {
        throw new IllegalStateException("GAS_NEXT has not been filled");
      }

      if (!filled.get(7)) {
        throw new IllegalStateException("GAS_REFUND has not been filled");
      }

      if (!filled.get(97)) {
        throw new IllegalStateException("HALT_FLAG has not been filled");
      }

      if (!filled.get(47)) {
        throw new IllegalStateException(
            "HEIGHT_NEW_xor_ADDRESS_LO_xor_GAS_REFUND_AMOUNT_xor_RETURNER_IS_PRECOMPILE_xor_STORAGE_KEY_HI has not been filled");
      }

      if (!filled.get(64)) {
        throw new IllegalStateException("HEIGHT_OVER has not been filled");
      }

      if (!filled.get(57)) {
        throw new IllegalStateException(
            "HEIGHT_UNDER_xor_DEPLOYMENT_NUMBER_INFTY_xor_FROM_ADDRESS_LO_xor_RETURN_AT_OFFSET has not been filled");
      }

      if (!filled.get(58)) {
        throw new IllegalStateException(
            "HEIGHT_xor_CODE_SIZE_xor_GAS_REFUND_COUNTER_FINAL_xor_RETURN_DATA_SIZE has not been filled");
      }

      if (!filled.get(29)) {
        throw new IllegalStateException("HUB_STAMP has not been filled");
      }

      if (!filled.get(54)) {
        throw new IllegalStateException(
            "INSTRUCTION_xor_NONCE_xor_INIT_CODE_SIZE_xor_BYTE_CODE_ADDRESS_HI has not been filled");
      }

      if (!filled.get(81)) {
        throw new IllegalStateException("INVALID_FLAG has not been filled");
      }

      if (!filled.get(85)) {
        throw new IllegalStateException("INVPREX has not been filled");
      }

      if (!filled.get(109)) {
        throw new IllegalStateException("JUMP_FLAG has not been filled");
      }

      if (!filled.get(111)) {
        throw new IllegalStateException("JUMPX has not been filled");
      }

      if (!filled.get(98)) {
        throw new IllegalStateException("KEC_FLAG has not been filled");
      }

      if (!filled.get(102)) {
        throw new IllegalStateException("LOG_FLAG has not been filled");
      }

      if (!filled.get(79)) {
        throw new IllegalStateException("MAXCSX has not been filled");
      }

      if (!filled.get(74)) {
        throw new IllegalStateException(
            "MOD_FLAG_xor_HAS_CODE_NEW_xor_VAL_ORIG_IS_ZERO has not been filled");
      }

      if (!filled.get(88)) {
        throw new IllegalStateException("MUL_FLAG has not been filled");
      }

      if (!filled.get(91)) {
        throw new IllegalStateException("MXP_FLAG has not been filled");
      }

      if (!filled.get(108)) {
        throw new IllegalStateException("MXPX has not been filled");
      }

      if (!filled.get(14)) {
        throw new IllegalStateException("NUMBER_OF_NON_STACK_ROWS has not been filled");
      }

      if (!filled.get(104)) {
        throw new IllegalStateException("OOB_FLAG has not been filled");
      }

      if (!filled.get(105)) {
        throw new IllegalStateException("OOGX has not been filled");
      }

      if (!filled.get(86)) {
        throw new IllegalStateException("OPCX has not been filled");
      }

      if (!filled.get(33)) {
        throw new IllegalStateException("PEEK_AT_ACCOUNT has not been filled");
      }

      if (!filled.get(18)) {
        throw new IllegalStateException("PEEK_AT_CONTEXT has not been filled");
      }

      if (!filled.get(3)) {
        throw new IllegalStateException("PEEK_AT_STACK has not been filled");
      }

      if (!filled.get(5)) {
        throw new IllegalStateException("PEEK_AT_STORAGE has not been filled");
      }

      if (!filled.get(38)) {
        throw new IllegalStateException("PEEK_AT_TRANSACTION has not been filled");
      }

      if (!filled.get(22)) {
        throw new IllegalStateException("PROGRAM_COUNTER has not been filled");
      }

      if (!filled.get(9)) {
        throw new IllegalStateException("PROGRAM_COUNTER_NEW has not been filled");
      }

      if (!filled.get(51)) {
        throw new IllegalStateException(
            "PUSH_VALUE_HI_xor_CODE_HASH_LO_xor_COINBASE_ADDRESS_HI_xor_BYTE_CODE_DEPLOYMENT_STATUS_xor_STORAGE_KEY_LO has not been filled");
      }

      if (!filled.get(53)) {
        throw new IllegalStateException(
            "PUSH_VALUE_LO_xor_BALANCE_xor_CALL_DATA_SIZE_xor_CALLER_CONTEXT_NUMBER has not been filled");
      }

      if (!filled.get(90)) {
        throw new IllegalStateException("PUSHPOP_FLAG has not been filled");
      }

      if (!filled.get(96)) {
        throw new IllegalStateException("RDCX has not been filled");
      }

      if (!filled.get(78)) {
        throw new IllegalStateException("SHF_FLAG has not been filled");
      }

      if (!filled.get(70)) {
        throw new IllegalStateException(
            "SOX_xor_IS_PRECOMPILE_xor_VAL_CURR_IS_ORIG has not been filled");
      }

      if (!filled.get(87)) {
        throw new IllegalStateException("SSTOREX has not been filled");
      }

      if (!filled.get(63)) {
        throw new IllegalStateException(
            "STACK_ITEM_HEIGHT_1_xor_CALL_STACK_DEPTH has not been filled");
      }

      if (!filled.get(45)) {
        throw new IllegalStateException(
            "STACK_ITEM_HEIGHT_2_xor_CODE_HASH_LO_NEW_xor_TO_ADDRESS_LO_xor_RETURN_DATA_OFFSET_xor_DEPLOYMENT_NUMBER has not been filled");
      }

      if (!filled.get(43)) {
        throw new IllegalStateException(
            "STACK_ITEM_HEIGHT_3_xor_BALANCE_NEW_xor_NONCE_xor_ACCOUNT_DEPLOYMENT_NUMBER_xor_ADDRESS_HI has not been filled");
      }

      if (!filled.get(48)) {
        throw new IllegalStateException(
            "STACK_ITEM_HEIGHT_4_xor_DEPLOYMENT_STATUS_NEW_xor_VALUE_xor_BYTE_CODE_DEPLOYMENT_NUMBER_xor_VAL_ORIG_HI has not been filled");
      }

      if (!filled.get(106)) {
        throw new IllegalStateException("STACK_ITEM_POP_1 has not been filled");
      }

      if (!filled.get(76)) {
        throw new IllegalStateException("STACK_ITEM_POP_2 has not been filled");
      }

      if (!filled.get(82)) {
        throw new IllegalStateException("STACK_ITEM_POP_3 has not been filled");
      }

      if (!filled.get(83)) {
        throw new IllegalStateException("STACK_ITEM_POP_4 has not been filled");
      }

      if (!filled.get(59)) {
        throw new IllegalStateException(
            "STACK_ITEM_STAMP_1_xor_GAS_LIMIT_xor_CALL_VALUE has not been filled");
      }

      if (!filled.get(55)) {
        throw new IllegalStateException(
            "STACK_ITEM_STAMP_2_xor_DEPLOYMENT_NUMBER_xor_TO_ADDRESS_HI_xor_CALLER_ADDRESS_HI has not been filled");
      }

      if (!filled.get(65)) {
        throw new IllegalStateException("STACK_ITEM_STAMP_3 has not been filled");
      }

      if (!filled.get(46)) {
        throw new IllegalStateException(
            "STACK_ITEM_STAMP_4_xor_DEPLOYMENT_STATUS_xor_COINBASE_ADDRESS_LO_xor_CALLER_ADDRESS_LO_xor_ADDRESS_LO has not been filled");
      }

      if (!filled.get(50)) {
        throw new IllegalStateException(
            "STACK_ITEM_VALUE_HI_1_xor_CODE_HASH_HI_NEW_xor_FROM_ADDRESS_HI_xor_ACCOUNT_ADDRESS_LO_xor_VAL_ORIG_LO has not been filled");
      }

      if (!filled.get(56)) {
        throw new IllegalStateException(
            "STACK_ITEM_VALUE_HI_2_xor_CODE_HASH_HI_xor_GAS_PRICE_xor_CALL_DATA_OFFSET has not been filled");
      }

      if (!filled.get(61)) {
        throw new IllegalStateException(
            "STACK_ITEM_VALUE_HI_3_xor_RETURN_AT_SIZE has not been filled");
      }

      if (!filled.get(49)) {
        throw new IllegalStateException(
            "STACK_ITEM_VALUE_HI_4_xor_NONCE_NEW_xor_INIT_GAS_xor_CALL_DATA_SIZE_xor_VAL_CURR_LO has not been filled");
      }

      if (!filled.get(52)) {
        throw new IllegalStateException(
            "STACK_ITEM_VALUE_LO_1_xor_ADDRESS_HI_xor_INITIAL_BALANCE_xor_BYTE_CODE_ADDRESS_LO_xor_VAL_NEXT_HI has not been filled");
      }

      if (!filled.get(60)) {
        throw new IllegalStateException(
            "STACK_ITEM_VALUE_LO_2_xor_RETURNER_CONTEXT_NUMBER has not been filled");
      }

      if (!filled.get(44)) {
        throw new IllegalStateException(
            "STACK_ITEM_VALUE_LO_3_xor_DEPLOYMENT_NUMBER_NEW_xor_LEFTOVER_GAS_xor_IS_STATIC_xor_VAL_CURR_HI has not been filled");
      }

      if (!filled.get(62)) {
        throw new IllegalStateException(
            "STACK_ITEM_VALUE_LO_4_xor_CONTEXT_NUMBER has not been filled");
      }

      if (!filled.get(68)) {
        throw new IllegalStateException(
            "STACKRAM_FLAG_xor_SUFFICIENT_BALANCE_xor_VAL_NEXT_IS_CURR_xor_STATUS_CODE has not been filled");
      }

      if (!filled.get(72)) {
        throw new IllegalStateException(
            "STATIC_FLAG_xor_DEPLOYMENT_STATUS_INFTY_xor_WARM has not been filled");
      }

      if (!filled.get(42)) {
        throw new IllegalStateException(
            "STATIC_GAS_xor_CODE_SIZE_NEW_xor_BASEFEE_xor_ACCOUNT_ADDRESS_HI_xor_VAL_NEXT_LO has not been filled");
      }

      if (!filled.get(69)) {
        throw new IllegalStateException(
            "STATICX_xor_EXISTS_xor_VAL_CURR_CHANGES_xor_TXN_REQUIRES_EVM_EXECUTION has not been filled");
      }

      if (!filled.get(71)) {
        throw new IllegalStateException("STO_FLAG_xor_WARM_NEW_xor_WARM_NEW has not been filled");
      }

      if (!filled.get(107)) {
        throw new IllegalStateException("SUX has not been filled");
      }

      if (!filled.get(89)) {
        throw new IllegalStateException("SWAP_FLAG has not been filled");
      }

      if (!filled.get(1)) {
        throw new IllegalStateException("TRANSACTION_END_STAMP has not been filled");
      }

      if (!filled.get(39)) {
        throw new IllegalStateException("TRANSACTION_REVERTS has not been filled");
      }

      if (!filled.get(75)) {
        throw new IllegalStateException("TRM_FLAG has not been filled");
      }

      if (!filled.get(23)) {
        throw new IllegalStateException("TWO_LINE_INSTRUCTION has not been filled");
      }

      if (!filled.get(37)) {
        throw new IllegalStateException("TX_EXEC has not been filled");
      }

      if (!filled.get(17)) {
        throw new IllegalStateException("TX_FINL has not been filled");
      }

      if (!filled.get(10)) {
        throw new IllegalStateException("TX_INIT has not been filled");
      }

      if (!filled.get(19)) {
        throw new IllegalStateException("TX_SKIP has not been filled");
      }

      if (!filled.get(35)) {
        throw new IllegalStateException("TX_WARM has not been filled");
      }

      if (!filled.get(100)) {
        throw new IllegalStateException("TXN_FLAG has not been filled");
      }

      if (!filled.get(66)) {
        throw new IllegalStateException(
            "UPDATE_xor_DECODED_FLAG_1_xor_EXISTS_NEW_xor_VAL_CURR_IS_ZERO_xor_IS_DEPLOYMENT has not been filled");
      }

      if (!filled.get(110)) {
        throw new IllegalStateException("WCP_FLAG has not been filled");
      }

      filled.clear();

      return this;
    }

    public TraceBuilder fillAndValidateRow() {
      if (!filled.get(4)) {
        abortFlag.add(false);
        this.filled.set(4);
      }
      if (!filled.get(13)) {
        absoluteTransactionNumber.add(BigInteger.ZERO);
        this.filled.set(13);
      }
      if (!filled.get(80)) {
        accFlag.add(false);
        this.filled.set(80);
      }
      if (!filled.get(73)) {
        addFlagXorWarmXorValNextIsZero.add(false);
        this.filled.set(73);
      }
      if (!filled.get(15)) {
        batchNumber.add(BigInteger.ZERO);
        this.filled.set(15);
      }
      if (!filled.get(101)) {
        binFlag.add(false);
        this.filled.set(101);
      }
      if (!filled.get(93)) {
        btcFlag.add(false);
        this.filled.set(93);
      }
      if (!filled.get(95)) {
        callFlag.add(false);
        this.filled.set(95);
      }
      if (!filled.get(11)) {
        callerContextNumber.add(BigInteger.ZERO);
        this.filled.set(11);
      }
      if (!filled.get(36)) {
        codeAddressHi.add(BigInteger.ZERO);
        this.filled.set(36);
      }
      if (!filled.get(31)) {
        codeAddressLo.add(BigInteger.ZERO);
        this.filled.set(31);
      }
      if (!filled.get(12)) {
        codeDeploymentNumber.add(BigInteger.ZERO);
        this.filled.set(12);
      }
      if (!filled.get(16)) {
        codeDeploymentStatus.add(false);
        this.filled.set(16);
      }
      if (!filled.get(77)) {
        conFlag.add(false);
        this.filled.set(77);
      }
      if (!filled.get(21)) {
        contextGetsRevrtdFlag.add(false);
        this.filled.set(21);
      }
      if (!filled.get(26)) {
        contextMayChangeFlag.add(false);
        this.filled.set(26);
      }
      if (!filled.get(41)) {
        contextNumber.add(BigInteger.ZERO);
        this.filled.set(41);
      }
      if (!filled.get(2)) {
        contextNumberNew.add(BigInteger.ZERO);
        this.filled.set(2);
      }
      if (!filled.get(32)) {
        contextRevertStamp.add(BigInteger.ZERO);
        this.filled.set(32);
      }
      if (!filled.get(34)) {
        contextSelfRevrtsFlag.add(false);
        this.filled.set(34);
      }
      if (!filled.get(20)) {
        contextWillRevertFlag.add(false);
        this.filled.set(20);
      }
      if (!filled.get(67)) {
        copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559.add(false);
        this.filled.set(67);
      }
      if (!filled.get(40)) {
        counterNsr.add(BigInteger.ZERO);
        this.filled.set(40);
      }
      if (!filled.get(25)) {
        counterTli.add(false);
        this.filled.set(25);
      }
      if (!filled.get(103)) {
        createFlag.add(false);
        this.filled.set(103);
      }
      if (!filled.get(99)) {
        decodedFlag2.add(false);
        this.filled.set(99);
      }
      if (!filled.get(92)) {
        decodedFlag3.add(false);
        this.filled.set(92);
      }
      if (!filled.get(84)) {
        decodedFlag4.add(false);
        this.filled.set(84);
      }
      if (!filled.get(94)) {
        dupFlag.add(false);
        this.filled.set(94);
      }
      if (!filled.get(24)) {
        exceptionAhoyFlag.add(false);
        this.filled.set(24);
      }
      if (!filled.get(112)) {
        extFlag.add(false);
        this.filled.set(112);
      }
      if (!filled.get(27)) {
        failureConditionFlag.add(false);
        this.filled.set(27);
      }
      if (!filled.get(6)) {
        gasActual.add(BigInteger.ZERO);
        this.filled.set(6);
      }
      if (!filled.get(28)) {
        gasCost.add(BigInteger.ZERO);
        this.filled.set(28);
      }
      if (!filled.get(30)) {
        gasExpected.add(BigInteger.ZERO);
        this.filled.set(30);
      }
      if (!filled.get(8)) {
        gasMemoryExpansion.add(BigInteger.ZERO);
        this.filled.set(8);
      }
      if (!filled.get(0)) {
        gasNext.add(BigInteger.ZERO);
        this.filled.set(0);
      }
      if (!filled.get(7)) {
        gasRefund.add(BigInteger.ZERO);
        this.filled.set(7);
      }
      if (!filled.get(97)) {
        haltFlag.add(false);
        this.filled.set(97);
      }
      if (!filled.get(47)) {
        heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi.add(
            BigInteger.ZERO);
        this.filled.set(47);
      }
      if (!filled.get(64)) {
        heightOver.add(BigInteger.ZERO);
        this.filled.set(64);
      }
      if (!filled.get(57)) {
        heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset.add(BigInteger.ZERO);
        this.filled.set(57);
      }
      if (!filled.get(58)) {
        heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize.add(BigInteger.ZERO);
        this.filled.set(58);
      }
      if (!filled.get(29)) {
        hubStamp.add(BigInteger.ZERO);
        this.filled.set(29);
      }
      if (!filled.get(54)) {
        instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi.add(BigInteger.ZERO);
        this.filled.set(54);
      }
      if (!filled.get(81)) {
        invalidFlag.add(false);
        this.filled.set(81);
      }
      if (!filled.get(85)) {
        invprex.add(false);
        this.filled.set(85);
      }
      if (!filled.get(109)) {
        jumpFlag.add(false);
        this.filled.set(109);
      }
      if (!filled.get(111)) {
        jumpx.add(false);
        this.filled.set(111);
      }
      if (!filled.get(98)) {
        kecFlag.add(false);
        this.filled.set(98);
      }
      if (!filled.get(102)) {
        logFlag.add(false);
        this.filled.set(102);
      }
      if (!filled.get(79)) {
        maxcsx.add(false);
        this.filled.set(79);
      }
      if (!filled.get(74)) {
        modFlagXorHasCodeNewXorValOrigIsZero.add(false);
        this.filled.set(74);
      }
      if (!filled.get(88)) {
        mulFlag.add(false);
        this.filled.set(88);
      }
      if (!filled.get(91)) {
        mxpFlag.add(false);
        this.filled.set(91);
      }
      if (!filled.get(108)) {
        mxpx.add(false);
        this.filled.set(108);
      }
      if (!filled.get(14)) {
        numberOfNonStackRows.add(BigInteger.ZERO);
        this.filled.set(14);
      }
      if (!filled.get(104)) {
        oobFlag.add(false);
        this.filled.set(104);
      }
      if (!filled.get(105)) {
        oogx.add(false);
        this.filled.set(105);
      }
      if (!filled.get(86)) {
        opcx.add(false);
        this.filled.set(86);
      }
      if (!filled.get(33)) {
        peekAtAccount.add(false);
        this.filled.set(33);
      }
      if (!filled.get(18)) {
        peekAtContext.add(false);
        this.filled.set(18);
      }
      if (!filled.get(3)) {
        peekAtStack.add(false);
        this.filled.set(3);
      }
      if (!filled.get(5)) {
        peekAtStorage.add(false);
        this.filled.set(5);
      }
      if (!filled.get(38)) {
        peekAtTransaction.add(false);
        this.filled.set(38);
      }
      if (!filled.get(22)) {
        programCounter.add(BigInteger.ZERO);
        this.filled.set(22);
      }
      if (!filled.get(9)) {
        programCounterNew.add(BigInteger.ZERO);
        this.filled.set(9);
      }
      if (!filled.get(51)) {
        pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo.add(
            BigInteger.ZERO);
        this.filled.set(51);
      }
      if (!filled.get(53)) {
        pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber.add(BigInteger.ZERO);
        this.filled.set(53);
      }
      if (!filled.get(90)) {
        pushpopFlag.add(false);
        this.filled.set(90);
      }
      if (!filled.get(96)) {
        rdcx.add(false);
        this.filled.set(96);
      }
      if (!filled.get(78)) {
        shfFlag.add(false);
        this.filled.set(78);
      }
      if (!filled.get(70)) {
        soxXorIsPrecompileXorValCurrIsOrig.add(false);
        this.filled.set(70);
      }
      if (!filled.get(87)) {
        sstorex.add(false);
        this.filled.set(87);
      }
      if (!filled.get(63)) {
        stackItemHeight1XorCallStackDepth.add(BigInteger.ZERO);
        this.filled.set(63);
      }
      if (!filled.get(45)) {
        stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber.add(
            BigInteger.ZERO);
        this.filled.set(45);
      }
      if (!filled.get(43)) {
        stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi.add(
            BigInteger.ZERO);
        this.filled.set(43);
      }
      if (!filled.get(48)) {
        stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi.add(
            BigInteger.ZERO);
        this.filled.set(48);
      }
      if (!filled.get(106)) {
        stackItemPop1.add(false);
        this.filled.set(106);
      }
      if (!filled.get(76)) {
        stackItemPop2.add(false);
        this.filled.set(76);
      }
      if (!filled.get(82)) {
        stackItemPop3.add(false);
        this.filled.set(82);
      }
      if (!filled.get(83)) {
        stackItemPop4.add(false);
        this.filled.set(83);
      }
      if (!filled.get(59)) {
        stackItemStamp1XorGasLimitXorCallValue.add(BigInteger.ZERO);
        this.filled.set(59);
      }
      if (!filled.get(55)) {
        stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi.add(BigInteger.ZERO);
        this.filled.set(55);
      }
      if (!filled.get(65)) {
        stackItemStamp3.add(BigInteger.ZERO);
        this.filled.set(65);
      }
      if (!filled.get(46)) {
        stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo.add(
            BigInteger.ZERO);
        this.filled.set(46);
      }
      if (!filled.get(50)) {
        stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo.add(
            BigInteger.ZERO);
        this.filled.set(50);
      }
      if (!filled.get(56)) {
        stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset.add(BigInteger.ZERO);
        this.filled.set(56);
      }
      if (!filled.get(61)) {
        stackItemValueHi3XorReturnAtSize.add(BigInteger.ZERO);
        this.filled.set(61);
      }
      if (!filled.get(49)) {
        stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo.add(BigInteger.ZERO);
        this.filled.set(49);
      }
      if (!filled.get(52)) {
        stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi.add(
            BigInteger.ZERO);
        this.filled.set(52);
      }
      if (!filled.get(60)) {
        stackItemValueLo2XorReturnerContextNumber.add(BigInteger.ZERO);
        this.filled.set(60);
      }
      if (!filled.get(44)) {
        stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi.add(
            BigInteger.ZERO);
        this.filled.set(44);
      }
      if (!filled.get(62)) {
        stackItemValueLo4XorContextNumber.add(BigInteger.ZERO);
        this.filled.set(62);
      }
      if (!filled.get(68)) {
        stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode.add(false);
        this.filled.set(68);
      }
      if (!filled.get(72)) {
        staticFlagXorDeploymentStatusInftyXorWarm.add(false);
        this.filled.set(72);
      }
      if (!filled.get(42)) {
        staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo.add(BigInteger.ZERO);
        this.filled.set(42);
      }
      if (!filled.get(69)) {
        staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution.add(false);
        this.filled.set(69);
      }
      if (!filled.get(71)) {
        stoFlagXorWarmNewXorWarmNew.add(false);
        this.filled.set(71);
      }
      if (!filled.get(107)) {
        sux.add(false);
        this.filled.set(107);
      }
      if (!filled.get(89)) {
        swapFlag.add(false);
        this.filled.set(89);
      }
      if (!filled.get(1)) {
        transactionEndStamp.add(BigInteger.ZERO);
        this.filled.set(1);
      }
      if (!filled.get(39)) {
        transactionReverts.add(BigInteger.ZERO);
        this.filled.set(39);
      }
      if (!filled.get(75)) {
        trmFlag.add(false);
        this.filled.set(75);
      }
      if (!filled.get(23)) {
        twoLineInstruction.add(false);
        this.filled.set(23);
      }
      if (!filled.get(37)) {
        txExec.add(false);
        this.filled.set(37);
      }
      if (!filled.get(17)) {
        txFinl.add(false);
        this.filled.set(17);
      }
      if (!filled.get(10)) {
        txInit.add(false);
        this.filled.set(10);
      }
      if (!filled.get(19)) {
        txSkip.add(false);
        this.filled.set(19);
      }
      if (!filled.get(35)) {
        txWarm.add(false);
        this.filled.set(35);
      }
      if (!filled.get(100)) {
        txnFlag.add(false);
        this.filled.set(100);
      }
      if (!filled.get(66)) {
        updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment.add(false);
        this.filled.set(66);
      }
      if (!filled.get(110)) {
        wcpFlag.add(false);
        this.filled.set(110);
      }

      return this.validateRow();
    }

    public Trace build() {
      if (!filled.isEmpty()) {
        throw new IllegalStateException("Cannot build trace with a non-validated row.");
      }

      return new Trace(
          abortFlag,
          absoluteTransactionNumber,
          accFlag,
          addFlagXorWarmXorValNextIsZero,
          batchNumber,
          binFlag,
          btcFlag,
          callFlag,
          callerContextNumber,
          codeAddressHi,
          codeAddressLo,
          codeDeploymentNumber,
          codeDeploymentStatus,
          conFlag,
          contextGetsRevrtdFlag,
          contextMayChangeFlag,
          contextNumber,
          contextNumberNew,
          contextRevertStamp,
          contextSelfRevrtsFlag,
          contextWillRevertFlag,
          copyFlagXorHasCodeXorValNextIsOrigXorIsEip1559,
          counterNsr,
          counterTli,
          createFlag,
          decodedFlag2,
          decodedFlag3,
          decodedFlag4,
          dupFlag,
          exceptionAhoyFlag,
          extFlag,
          failureConditionFlag,
          gasActual,
          gasCost,
          gasExpected,
          gasMemoryExpansion,
          gasNext,
          gasRefund,
          haltFlag,
          heightNewXorAddressLoXorGasRefundAmountXorReturnerIsPrecompileXorStorageKeyHi,
          heightOver,
          heightUnderXorDeploymentNumberInftyXorFromAddressLoXorReturnAtOffset,
          heightXorCodeSizeXorGasRefundCounterFinalXorReturnDataSize,
          hubStamp,
          instructionXorNonceXorInitCodeSizeXorByteCodeAddressHi,
          invalidFlag,
          invprex,
          jumpFlag,
          jumpx,
          kecFlag,
          logFlag,
          maxcsx,
          modFlagXorHasCodeNewXorValOrigIsZero,
          mulFlag,
          mxpFlag,
          mxpx,
          numberOfNonStackRows,
          oobFlag,
          oogx,
          opcx,
          peekAtAccount,
          peekAtContext,
          peekAtStack,
          peekAtStorage,
          peekAtTransaction,
          programCounter,
          programCounterNew,
          pushValueHiXorCodeHashLoXorCoinbaseAddressHiXorByteCodeDeploymentStatusXorStorageKeyLo,
          pushValueLoXorBalanceXorCallDataSizeXorCallerContextNumber,
          pushpopFlag,
          rdcx,
          shfFlag,
          soxXorIsPrecompileXorValCurrIsOrig,
          sstorex,
          stackItemHeight1XorCallStackDepth,
          stackItemHeight2XorCodeHashLoNewXorToAddressLoXorReturnDataOffsetXorDeploymentNumber,
          stackItemHeight3XorBalanceNewXorNonceXorAccountDeploymentNumberXorAddressHi,
          stackItemHeight4XorDeploymentStatusNewXorValueXorByteCodeDeploymentNumberXorValOrigHi,
          stackItemPop1,
          stackItemPop2,
          stackItemPop3,
          stackItemPop4,
          stackItemStamp1XorGasLimitXorCallValue,
          stackItemStamp2XorDeploymentNumberXorToAddressHiXorCallerAddressHi,
          stackItemStamp3,
          stackItemStamp4XorDeploymentStatusXorCoinbaseAddressLoXorCallerAddressLoXorAddressLo,
          stackItemValueHi1XorCodeHashHiNewXorFromAddressHiXorAccountAddressLoXorValOrigLo,
          stackItemValueHi2XorCodeHashHiXorGasPriceXorCallDataOffset,
          stackItemValueHi3XorReturnAtSize,
          stackItemValueHi4XorNonceNewXorInitGasXorCallDataSizeXorValCurrLo,
          stackItemValueLo1XorAddressHiXorInitialBalanceXorByteCodeAddressLoXorValNextHi,
          stackItemValueLo2XorReturnerContextNumber,
          stackItemValueLo3XorDeploymentNumberNewXorLeftoverGasXorIsStaticXorValCurrHi,
          stackItemValueLo4XorContextNumber,
          stackramFlagXorSufficientBalanceXorValNextIsCurrXorStatusCode,
          staticFlagXorDeploymentStatusInftyXorWarm,
          staticGasXorCodeSizeNewXorBasefeeXorAccountAddressHiXorValNextLo,
          staticxXorExistsXorValCurrChangesXorTxnRequiresEvmExecution,
          stoFlagXorWarmNewXorWarmNew,
          sux,
          swapFlag,
          transactionEndStamp,
          transactionReverts,
          trmFlag,
          twoLineInstruction,
          txExec,
          txFinl,
          txInit,
          txSkip,
          txWarm,
          txnFlag,
          updateXorDecodedFlag1XorExistsNewXorValCurrIsZeroXorIsDeployment,
          wcpFlag);
    }
  }
}
