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

package net.consensys.linea.zktracer.module.mmio.dispatchers;

import com.google.common.base.Preconditions;
import lombok.RequiredArgsConstructor;
import net.consensys.linea.zktracer.module.mmio.MmioData;
import net.consensys.linea.zktracer.runtime.callstack.CallStack;
import net.consensys.linea.zktracer.runtime.microdata.MicroData;
import net.consensys.linea.zktracer.types.UnsignedByte;

@RequiredArgsConstructor
public class ExceptionalRamToStack3To2FullFastDispatcher implements MmioDispatcher {
  private final MicroData microData;

  private final CallStack callStack;

  @Override
  public MmioData dispatch() {
    MmioData mmioData = new MmioData();

    mmioData.cnA(0);
    mmioData.cnB(0);
    mmioData.cnC(0);

    mmioData.indexA(0);
    mmioData.indexB(0);
    mmioData.indexC(0);

    Preconditions.checkState(
        microData.isRootContext() && microData.isType5(),
        "Should be: EXCEPTIONAL_RAM_TO_STACK_3_TO_2_FULL");

    mmioData.valA(microData.valACache());
    mmioData.valB(microData.valBCache());
    mmioData.valC(microData.valCCache());

    mmioData.valANew(UnsignedByte.EMPTY_BYTES16);
    mmioData.valBNew(UnsignedByte.EMPTY_BYTES16);
    mmioData.valCNew(UnsignedByte.EMPTY_BYTES16);

    mmioData.valHi(mmioData.valA());
    mmioData.valLo(mmioData.valB());

    return mmioData;
  }

  @Override
  public void update(MmioData mmioData, int counter) {}
}