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

package net.consensys.linea.zktracer.module.mmio;

import net.consensys.linea.zktracer.module.mmu.MicroData;
import net.consensys.linea.zktracer.runtime.callstack.CallStack;

class RamToRamSlideOverlappingChunkDispatcher implements MmioDispatcher {
  @Override
  public MmioData dispatch(MicroData microData, CallStack callStack) {
    MmioData mmioData = new MmioData();
    mmioData.cnA(microData.sourceContext());
    mmioData.cnB(microData.targetContext());
    mmioData.cnC(0);
    mmioData.indexA(microData.sourceLimbOffset().toInt());
    mmioData.indexB(microData.targetLimbOffset().toInt());
    mmioData.indexC(microData.targetLimbOffset().toInt() + 1);
    mmioData.valA(callStack.valueFromMemory(mmioData.cnA(), mmioData.indexA()));
    mmioData.valB(callStack.valueFromMemory(mmioData.cnB(), mmioData.indexB()));
    mmioData.valC(callStack.valueFromMemory(mmioData.cnC(), mmioData.indexC()));
    mmioData.valANew(mmioData.valA());

    mmioData.valBNew(mmioData.valB());
    int targetByteOffset = microData.targetByteOffset().toInteger();
    int sourceByteOffset = microData.sourceByteOffset().toInteger();
    for (int i = targetByteOffset; i < 16; i++) {
      mmioData.valBNew()[i] = mmioData.valA()[sourceByteOffset + i - targetByteOffset];
    }

    mmioData.valCNew(mmioData.valC());
    int size = microData.size();
    int maxIndex = size - (16 - targetByteOffset);
    for (int i = 0; i < maxIndex; i++) {
      mmioData.valCNew()[i] = mmioData.valA()[sourceByteOffset + (16 - targetByteOffset) + i];
    }

    mmioData.updateLimbsInMemory(callStack);

    return mmioData;
  }

  @Override
  public void update(MmioData mmioData, MicroData microData, int counter) {
    mmioData.onePartialToTwo(
        mmioData.byteA(counter),
        mmioData.byteB(counter),
        mmioData.byteC(counter),
        mmioData.acc1(),
        mmioData.acc2(),
        mmioData.acc3(),
        mmioData.acc4(),
        microData.sourceByteOffset(),
        microData.targetByteOffset(),
        microData.size(),
        counter);
  }
}