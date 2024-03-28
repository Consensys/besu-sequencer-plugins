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

package net.consensys.linea.zktracer.module.mmu.instructions;

import static net.consensys.linea.zktracer.types.Conversions.bigIntegerToBytes;
import static net.consensys.linea.zktracer.types.Conversions.longToBytes;

import java.util.ArrayList;
import java.util.List;

import net.consensys.linea.zktracer.module.euc.Euc;
import net.consensys.linea.zktracer.module.euc.EucOperation;
import net.consensys.linea.zktracer.module.mmu.MmuData;
import net.consensys.linea.zktracer.module.mmu.Trace;
import net.consensys.linea.zktracer.module.mmu.values.HubToMmuValues;
import net.consensys.linea.zktracer.module.mmu.values.MmuEucCallRecord;
import net.consensys.linea.zktracer.module.mmu.values.MmuOutAndBinValues;
import net.consensys.linea.zktracer.module.mmu.values.MmuToMmioConstantValues;
import net.consensys.linea.zktracer.module.mmu.values.MmuToMmioInstruction;
import net.consensys.linea.zktracer.module.mmu.values.MmuWcpCallRecord;
import net.consensys.linea.zktracer.module.wcp.Wcp;
import net.consensys.linea.zktracer.runtime.callstack.CallStack;
import org.apache.tuweni.bytes.Bytes;

public class RamToRamSansPadding implements MmuInstruction {
  private final Euc euc;
  private final Wcp wcp;
  private List<MmuEucCallRecord> eucCallRecords;
  private List<MmuWcpCallRecord> wcpCallRecords;
  private short lastLimbByteSize;
  private short middleSourceByteOffset;
  private boolean lastLimbSingleSource;
  private boolean initialSloIncrement;
  private boolean lastLimbIsFast;
  private long initialSourceLimbOffset;
  private short initialSourceByteOffset;
  private long initialTargetLimbOffset;
  private short initialTargetByteOffset;
  private long realSize;
  private boolean aligned;
  private long finalTargetLimbOffset;
  private long totInitialNonTrivial;
  private boolean totNonTrivialIsOne;
  private short firstLimbByteSize;
  private boolean firstLimbSingleSource;
  private boolean initialTboIsZero;
  private boolean lastLimbIsFull;
  private boolean firstLimbIsFast;

  public RamToRamSansPadding(Euc euc, Wcp wcp) {
    this.euc = euc;
    this.wcp = wcp;
    this.eucCallRecords = new ArrayList<>(Trace.NB_PP_ROWS_RAM_TO_RAM_SANS_PADDING);
    this.wcpCallRecords = new ArrayList<>(Trace.NB_PP_ROWS_RAM_TO_RAM_SANS_PADDING);
  }

  @Override
  public MmuData preProcess(MmuData mmuData, final CallStack callStack) {
    final HubToMmuValues hubToMmuValues = mmuData.hubToMmuValues();
    row1(hubToMmuValues);
    row2(hubToMmuValues);
    row3(hubToMmuValues);
    row4();
    row5();

    mmuData.eucCallRecords(eucCallRecords);
    mmuData.wcpCallRecords(wcpCallRecords);

    // setting Out and Bin values
    mmuData.outAndBinValues(
        MmuOutAndBinValues.builder()
            .out1(lastLimbByteSize)
            .out2(middleSourceByteOffset)
            .bin1(aligned)
            .bin2(lastLimbSingleSource)
            .bin3(initialSloIncrement)
            .bin4(lastLimbIsFast)
            .build());

    mmuData.totalLeftZeroesInitials(0);
    mmuData.totalNonTrivialInitials((int) totInitialNonTrivial);
    mmuData.totalRightZeroesInitials(0);

    return mmuData;
  }

  private void row1(final HubToMmuValues hubToMmuValues) {
    // row n°1
    final Bytes dividend = bigIntegerToBytes(hubToMmuValues.sourceOffsetLo());
    EucOperation eucOp = euc.callEUC(dividend, Bytes.of(Trace.LLARGE));

    initialSourceLimbOffset = eucOp.quotient().toInt();
    initialSourceByteOffset = (short) eucOp.remainder().toInt();

    eucCallRecords.add(
        MmuEucCallRecord.builder()
            .dividend(dividend.toLong())
            .divisor(Trace.LLARGE)
            .quotient(eucOp.quotient().toLong())
            .remainder(eucOp.remainder().toLong())
            .build());

    final Bytes wcpArg1 = longToBytes(hubToMmuValues.referenceSize());
    final Bytes wcpArg2 = longToBytes(hubToMmuValues.size());
    final boolean wcpResult = wcp.callLT(wcpArg1, wcpArg2);

    realSize = wcpResult ? hubToMmuValues.referenceSize() : hubToMmuValues.size();

    wcpCallRecords.add(
        MmuWcpCallRecord.instLtBuilder().arg1Lo(wcpArg1).arg2Lo(wcpArg2).result(wcpResult).build());
  }

  private void row2(final HubToMmuValues hubToMmuValues) {
    // row n°2
    final Bytes dividend = longToBytes(hubToMmuValues.referenceOffset());
    EucOperation eucOp = euc.callEUC(dividend, Bytes.of(Trace.LLARGE));

    initialTargetLimbOffset = eucOp.quotient().toInt();
    initialTargetByteOffset = (short) eucOp.remainder().toInt();

    eucCallRecords.add(
        MmuEucCallRecord.builder()
            .dividend(dividend.toLong())
            .divisor(Trace.LLARGE)
            .quotient(eucOp.quotient().toLong())
            .remainder(eucOp.remainder().toLong())
            .build());

    final Bytes wcpArg1 = longToBytes(initialSourceByteOffset);
    final Bytes wcpArg2 = longToBytes(initialTargetByteOffset);
    aligned = wcp.callEQ(wcpArg1, wcpArg2);

    wcpCallRecords.add(
        MmuWcpCallRecord.instEqBuilder().arg1Lo(wcpArg1).arg2Lo(wcpArg2).result(aligned).build());
  }

  private void row3(final HubToMmuValues hubToMmuValues) {
    // row n°3
    final Bytes dividend = longToBytes(hubToMmuValues.referenceOffset() + realSize - 1);
    EucOperation eucOp = euc.callEUC(dividend, Bytes.of(Trace.LLARGE));

    finalTargetLimbOffset = eucOp.quotient().toLong();

    totInitialNonTrivial = finalTargetLimbOffset - initialTargetLimbOffset + 1;

    eucCallRecords.add(
        MmuEucCallRecord.builder()
            .dividend(dividend.toLong())
            .divisor(Trace.LLARGE)
            .quotient(eucOp.quotient().toLong())
            .remainder(eucOp.remainder().toLong())
            .build());

    final Bytes wcpArg1 = longToBytes(totInitialNonTrivial);
    final Bytes wcpArg2 = Bytes.of(1);
    totNonTrivialIsOne = wcp.callEQ(wcpArg1, wcpArg2);

    wcpCallRecords.add(
        MmuWcpCallRecord.instEqBuilder()
            .arg1Lo(wcpArg1)
            .arg2Lo(wcpArg2)
            .result(totNonTrivialIsOne)
            .build());

    firstLimbByteSize =
        (short) (totNonTrivialIsOne ? (int) realSize : Trace.LLARGE - initialTargetByteOffset);
    lastLimbByteSize = (short) (totNonTrivialIsOne ? realSize : 1 + eucOp.remainder().toInt());
  }

  private void row4() {
    // row n°4
    final Bytes wcpArg1 = longToBytes(initialSourceByteOffset + firstLimbByteSize - 1);
    final Bytes wcpArg2 = Bytes.of(Trace.LLARGE);
    firstLimbSingleSource = wcp.callLT(wcpArg1, wcpArg2);
    wcpCallRecords.add(
        MmuWcpCallRecord.instLtBuilder()
            .arg1Lo(wcpArg1)
            .arg2Lo(wcpArg2)
            .result(firstLimbSingleSource)
            .build());

    if (aligned) {
      middleSourceByteOffset = 0;
    } else {
      middleSourceByteOffset =
          (short)
              (firstLimbSingleSource
                  ? initialSourceByteOffset + firstLimbByteSize
                  : initialSourceByteOffset + firstLimbByteSize - Trace.LLARGE);
    }

    final Bytes dividend = longToBytes(middleSourceByteOffset + lastLimbByteSize - 1);
    EucOperation eucOp = euc.callEUC(dividend, Bytes.of(Trace.LLARGE));
    eucCallRecords.add(
        MmuEucCallRecord.builder()
            .dividend(dividend.toLong())
            .divisor(Trace.LLARGE)
            .quotient(eucOp.quotient().toLong())
            .remainder(eucOp.remainder().toLong())
            .build());

    lastLimbSingleSource =
        totNonTrivialIsOne ? firstLimbSingleSource : eucOp.quotient().toInt() == 0;
    initialSloIncrement = aligned ? true : !firstLimbSingleSource;
  }

  private void row5() {
    // row n°5
    final Bytes wcpArg1 = longToBytes(initialTargetByteOffset);
    initialTboIsZero = wcp.callISZERO(wcpArg1);
    wcpCallRecords.add(
        MmuWcpCallRecord.instIsZeroBuilder().arg1Lo(wcpArg1).result(firstLimbSingleSource).build());

    final Bytes dividend = longToBytes(lastLimbByteSize);
    EucOperation eucOp = euc.callEUC(dividend, Bytes.of(Trace.LLARGE));
    eucCallRecords.add(
        MmuEucCallRecord.builder()
            .dividend(dividend.toLong())
            .divisor(Trace.LLARGE)
            .quotient(eucOp.quotient().toLong())
            .remainder(eucOp.remainder().toLong())
            .build());
    lastLimbIsFull = eucOp.quotient().toInt() == 1;
    lastLimbIsFast = aligned && lastLimbIsFull;
    if (!totNonTrivialIsOne) {
      firstLimbIsFast = aligned && initialTboIsZero;
    }
  }

  @Override
  public MmuData setMicroInstructions(MmuData mmuData) {
    final HubToMmuValues hubToMmuValues = mmuData.hubToMmuValues();

    // Setting MMIO constant values
    mmuData.mmuToMmioConstantValues(
        MmuToMmioConstantValues.builder()
            .sourceContextNumber(hubToMmuValues.sourceId())
            .targetContextNumber(hubToMmuValues.targetId())
            .build());

    // Setting the source and target ram bytes
    mmuData.setSourceRamBytes();
    mmuData.setTargetRamBytes();

    // Setting the list of MMIO instructions
    if (mmuData.totalNonTrivialInitials() == 1) {
      onlyMicroInstruction(mmuData);
    } else {
      firstMicroInstruction(mmuData);

      final int firstMiddleSlo =
          (int) (initialSloIncrement ? initialSourceLimbOffset + 1 : initialSourceLimbOffset);
      final int middleMicroInst =
          aligned ? Trace.MMIO_INST_RAM_TO_LIMB_TRANSPLANT : Trace.MMIO_INST_RAM_TO_LIMB_TWO_SOURCE;
      for (int i = 1; i < mmuData.totalNonTrivialInitials() - 1; i++) {
        middleMicroInstruction(mmuData, middleMicroInst, i, firstMiddleSlo);
      }
      lastMicroInstruction(mmuData, firstMiddleSlo);
    }

    return mmuData;
  }

  private void onlyMicroInstruction(MmuData mmuData) {
    final int onlyMicroInst = calculateLastOrOnlyMicroInstruction();

    mmuData.mmuToMmioInstruction(
        MmuToMmioInstruction.builder()
            .mmioInstruction(onlyMicroInst)
            .size(firstLimbByteSize)
            .sourceLimbOffset((int) initialSourceLimbOffset)
            .sourceByteOffset(initialSourceByteOffset)
            .targetLimbOffset((int) initialTargetLimbOffset)
            .targetByteOffset(initialTargetByteOffset)
            .build());
  }

  private void firstMicroInstruction(MmuData mmuData) {
    final int onlyMicroInst = calculateFirstMicroInstruction();

    mmuData.mmuToMmioInstruction(
        MmuToMmioInstruction.builder()
            .mmioInstruction(onlyMicroInst)
            .size(firstLimbByteSize)
            .sourceLimbOffset((int) initialSourceLimbOffset)
            .sourceByteOffset(initialSourceByteOffset)
            .targetLimbOffset((int) initialTargetLimbOffset)
            .targetByteOffset(initialTargetByteOffset)
            .build());
  }

  private void middleMicroInstruction(
      MmuData mmuData, int middleMicrioInstruction, int i, int firstMiddleSlo) {

    mmuData.mmuToMmioInstruction(
        MmuToMmioInstruction.builder()
            .mmioInstruction(middleMicrioInstruction)
            .size((short) Trace.LLARGE)
            .sourceLimbOffset(firstMiddleSlo + i - 1)
            .sourceByteOffset(middleSourceByteOffset)
            .targetLimbOffset((int) initialTargetLimbOffset + i)
            .targetByteOffset((short) 0)
            .build());
  }

  private void lastMicroInstruction(MmuData mmuData, int firstMiddleSlo) {
    final int lastMicroInst = calculateLastOrOnlyMicroInstruction();

    mmuData.mmuToMmioInstruction(
        MmuToMmioInstruction.builder()
            .mmioInstruction(lastMicroInst)
            .size(lastLimbByteSize)
            .sourceLimbOffset((int) (firstMiddleSlo + totInitialNonTrivial - 1))
            .sourceByteOffset(middleSourceByteOffset)
            .targetLimbOffset((int) (initialTargetLimbOffset + totInitialNonTrivial))
            .targetByteOffset((short) 0)
            .build());
  }

  private int calculateLastOrOnlyMicroInstruction() {
    if (lastLimbIsFast) {
      return Trace.MMIO_INST_RAM_TO_RAM_TRANSPLANT;
    } else {
      return lastLimbSingleSource
          ? Trace.MMIO_INST_RAM_TO_RAM_PARTIAL
          : Trace.MMIO_INST_RAM_TO_RAM_TWO_SOURCE;
    }
  }

  private int calculateFirstMicroInstruction() {
    if (firstLimbIsFast) {
      return Trace.MMIO_INST_RAM_TO_RAM_TRANSPLANT;
    } else {
      return firstLimbSingleSource
          ? Trace.MMIO_INST_RAM_TO_RAM_PARTIAL
          : Trace.MMIO_INST_RAM_TO_RAM_TWO_SOURCE;
    }
  }
}
