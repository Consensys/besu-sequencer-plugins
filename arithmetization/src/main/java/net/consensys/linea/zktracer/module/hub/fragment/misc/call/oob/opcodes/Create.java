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

package net.consensys.linea.zktracer.module.hub.fragment.misc.call.oob.opcodes;

import static net.consensys.linea.zktracer.module.oob.Trace.OOB_INST_create;
import static net.consensys.linea.zktracer.types.Conversions.booleanToBytes;

import net.consensys.linea.zktracer.module.hub.fragment.misc.call.oob.OobCall;
import net.consensys.linea.zktracer.module.hub.signals.AbortingConditions;
import net.consensys.linea.zktracer.module.hub.signals.FailureConditions;
import net.consensys.linea.zktracer.module.oob.OobDataChannel;
import net.consensys.linea.zktracer.types.EWord;
import org.apache.tuweni.bytes.Bytes;

public record Create(
    AbortingConditions aborts,
    FailureConditions failures,
    EWord value,
    EWord creatorBalance,
    long createdNonce,
    boolean createdHasCode,
    int callStackDepth)
    implements OobCall {
  @Override
  public Bytes data(OobDataChannel i) {
    return switch (i) {
      case DATA_1 -> value.hi();
      case DATA_2 -> value.lo();
      case DATA_3 -> creatorBalance.lo();
      case DATA_4 -> Bytes.ofUnsignedLong(createdNonce);
      case DATA_5 -> booleanToBytes(createdHasCode);
      case DATA_6 -> Bytes.ofUnsignedLong(callStackDepth);
      case DATA_7 -> booleanToBytes(aborts.any());
      case DATA_8 -> booleanToBytes(failures.any());
    };
  }

  @Override
  public int oobInstruction() {
    return OOB_INST_create;
  }
}
