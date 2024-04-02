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

package net.consensys.linea.zktracer.module.mmio.instructions;

import static net.consensys.linea.zktracer.module.mmio.MmioPatterns.twoPartialToOne;

import lombok.RequiredArgsConstructor;
import net.consensys.linea.zktracer.module.mmio.MmioData;
import net.consensys.linea.zktracer.module.mmu.MmuData;
import net.consensys.linea.zktracer.module.mmu.values.MmuToMmioConstantValues;
import net.consensys.linea.zktracer.module.mmu.values.MmuToMmioInstruction;
import net.consensys.linea.zktracer.types.Bytecodes;
import net.consensys.linea.zktracer.types.Bytes16;

@RequiredArgsConstructor
public class RamToRamTwoSource implements MmioInstruction {
  private final MmuData mmuData;

  private final int instructionNumber;

  @Override
  public MmioData execute() {
    final MmuToMmioConstantValues mmuToMmioConstantValues = mmuData.mmuToMmioConstantValues();
    final MmuToMmioInstruction mmuToMmioInstruction =
        mmuData.mmuToMmioInstructions().get(instructionNumber);

    MmioData mmioData =
        new MmioData(
            mmuData.hubToMmuValues(),
            mmuToMmioConstantValues,
            mmuToMmioInstruction,
            mmuData.exoSumDecoder());

    mmioData.cnA(mmioData.sourceContext());
    mmioData.cnB(mmioData.sourceContext());
    mmioData.cnC(mmioData.targetContext());

    mmioData.indexA(mmioData.sourceLimbOffset());
    mmioData.indexB(mmioData.indexA() + 1);
    mmioData.indexC(mmioData.targetLimbOffset());
    mmioData.indexX(0);

    mmioData.valA(Bytes16.wrap(Bytecodes.readLimb(mmuData.sourceRamBytes(), mmioData.indexA())));
    mmioData.valB(Bytes16.wrap(Bytecodes.readLimb(mmuData.targetRamBytes(), mmioData.indexB())));
    mmioData.valC(Bytes16.wrap(Bytecodes.readLimb(mmuData.targetRamBytes(), mmioData.indexC())));
    mmioData.limb(Bytes16.ZERO);

    mmioData.valANew(mmioData.valA());
    mmioData.valBNew(mmioData.valB());
    mmioData.valCNew(
        twoPartialToOne(
            mmioData.valA(),
            mmioData.valB(),
            mmioData.valC(),
            mmioData.sourceByteOffset(),
            mmioData.targetByteOffset(),
            mmioData.size()));

    mmioData.twoPartialToOne(
        mmioData.valA(),
        mmioData.valB(),
        mmioData.valC(),
        mmioData.sourceByteOffset(),
        mmioData.targetByteOffset(),
        mmioData.size());

    return mmioData;
  }
}
