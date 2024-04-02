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

package net.consensys.linea.zktracer.module.mmu.instructions;

import static net.consensys.linea.zktracer.module.mmu.Trace.LLARGE;

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
import net.consensys.linea.zktracer.runtime.callstack.CallStack;
import org.apache.tuweni.bytes.Bytes;

public class ExoToRamTransplants implements MmuInstruction {
  private Euc euc;
  private List<MmuEucCallRecord> eucCallRecords;
  private List<MmuWcpCallRecord> wcpCallRecords;

  public ExoToRamTransplants(Euc euc) {
    this.euc = euc;
    this.eucCallRecords = new ArrayList<>(Trace.NB_PP_ROWS_EXO_TO_RAM_TRANSPLANTS);
    this.wcpCallRecords = new ArrayList<>(Trace.NB_PP_ROWS_EXO_TO_RAM_TRANSPLANTS);
  }

  @Override
  public MmuData preProcess(MmuData mmuData, final CallStack callStack) {
    // row n°1
    final Bytes dividend = Bytes.ofUnsignedInt(mmuData.hubToMmuValues().size());
    final EucOperation eucOp = euc.callEUC(dividend, Bytes.of(LLARGE));

    eucCallRecords.add(
        MmuEucCallRecord.builder()
            .dividend(dividend.toLong())
            .divisor(LLARGE)
            .quotient(eucOp.quotient().toLong())
            .remainder(eucOp.remainder().toLong())
            .build());

    wcpCallRecords.add(MmuWcpCallRecord.EMPTY_CALL);

    mmuData.eucCallRecords(eucCallRecords);
    mmuData.wcpCallRecords(wcpCallRecords);
    mmuData.outAndBinValues(MmuOutAndBinValues.DEFAULT);

    mmuData.totalLeftZeroesInitials(0);
    mmuData.totalNonTrivialInitials(eucOp.ceiling().toInt());
    mmuData.totalRightZeroesInitials(0);

    return mmuData;
  }

  @Override
  public MmuData setMicroInstructions(MmuData mmuData) {
    HubToMmuValues hubToMmuValues = mmuData.hubToMmuValues();

    // Setting MMIO constant values
    mmuData.mmuToMmioConstantValues(
        MmuToMmioConstantValues.builder()
            .targetContextNumber(hubToMmuValues.targetId())
            .exoSum(hubToMmuValues.exoSum())
            .phase(hubToMmuValues.phase())
            .exoId(hubToMmuValues.sourceId())
            .totalSize((int) hubToMmuValues.size())
            .build());

    // Setting the target ram bytes
    // If the exo module is RlpTxn, the previous target RAM Bytes is empty, as we created a non-evm
    // context number ram to store the call data
    if (!mmuData.hubToMmuValues().exoIsTxcd()) {
      mmuData.setTargetRamBytes();
    } else {
      mmuData.targetRamBytes(Bytes.EMPTY);
    }

    // setting the MMIO instructions
    for (int i = 0; i < mmuData.totalNonTrivialInitials(); i++) {
      mmuData.mmuToMmioInstruction(
          MmuToMmioInstruction.builder()
              .mmioInstruction(Trace.MMIO_INST_LIMB_TO_RAM_TRANSPLANT)
              .sourceLimbOffset(i)
              .targetLimbOffset(i)
              .size((short) LLARGE)
              .build());
    }

    return mmuData;
  }
}
