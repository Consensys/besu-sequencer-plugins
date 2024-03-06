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

import static net.consensys.linea.zktracer.module.mmio.MmioPatterns.onePartialToTwoOutputOne;
import static net.consensys.linea.zktracer.module.mmio.MmioPatterns.onePartialToTwoOutputTwo;

import lombok.RequiredArgsConstructor;
import net.consensys.linea.zktracer.module.mmio.MmioData;
import net.consensys.linea.zktracer.module.mmu.MmuData;
import net.consensys.linea.zktracer.module.mmu.values.MmuToMmioConstantValues;
import net.consensys.linea.zktracer.module.mmu.values.MmuToMmioInstruction;
import net.consensys.linea.zktracer.types.Bytecodes;
import net.consensys.linea.zktracer.types.Bytes16;

@RequiredArgsConstructor
public class LimbToRamTwoTarget implements MmioInstruction {
  private final MmuData mmuData;

  private final int instructionId;

  @Override
  public MmioData execute() {
    final MmuToMmioConstantValues mmuToMmioConstantValues = mmuData.mmuToMmioConstantValues();
    final MmuToMmioInstruction mmuToMmioInstruction =
        mmuData.mmuToMmioInstructions().get(instructionId);

    MmioData mmioData =
        new MmioData(mmuToMmioConstantValues, mmuToMmioInstruction, mmuData.exoSumDecoder());

    mmioData.cnA(mmioData.targetContext());
    mmioData.cnB(mmioData.targetContext());
    mmioData.cnC(0);

    mmioData.indexA(mmioData.targetLimbOffset());
    mmioData.indexB(mmioData.indexA() + 1);
    mmioData.indexC(0);
    mmioData.indexX(mmioData.sourceLimbOffset());

    mmioData.valA(Bytes16.wrap(Bytecodes.readLimb(mmuData.targetRamBytes(), mmioData.indexA())));
    mmioData.valB(Bytes16.wrap(Bytecodes.readLimb(mmuData.targetRamBytes(), mmioData.indexB())));
    mmioData.valC(Bytes16.ZERO);
    mmioData.limb(mmioData.limb());

    mmioData.valANew(
        onePartialToTwoOutputOne(
            mmioData.limb(),
            mmioData.valA(),
            mmioData.sourceByteOffset(),
            mmioData.targetByteOffset()));
    mmioData.valBNew(
        onePartialToTwoOutputTwo(
            mmioData.limb(),
            mmioData.valB(),
            mmioData.sourceByteOffset(),
            mmioData.targetByteOffset(),
            mmioData.size()));
    mmioData.valCNew(Bytes16.ZERO);

    mmioData.onePartialToTwo(
        mmioData.limb(),
        mmioData.valA(),
        mmioData.valB(),
        mmioData.sourceByteOffset(),
        mmioData.targetByteOffset(),
        mmioData.size());

    return mmioData;
  }
}
