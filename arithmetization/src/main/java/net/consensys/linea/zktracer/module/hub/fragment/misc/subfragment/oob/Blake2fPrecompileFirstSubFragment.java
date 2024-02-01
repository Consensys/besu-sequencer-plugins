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

package net.consensys.linea.zktracer.module.hub.fragment.misc.subfragment.oob;

import static net.consensys.linea.zktracer.module.oob.Trace.OOB_INST_blake2f_cds;
import static net.consensys.linea.zktracer.types.Conversions.booleanToBytes;

import net.consensys.linea.zktracer.module.hub.precompiles.PrecompileInvocation;
import net.consensys.linea.zktracer.module.oob.OobDataChannel;
import org.apache.tuweni.bytes.Bytes;

public record Blake2fPrecompileFirstSubFragment(PrecompileInvocation p)
    implements GenericOobSubFragment {
  @Override
  public Bytes data(OobDataChannel i) {
    return switch (i) {
      case DATA_2 -> Bytes.ofUnsignedLong(p.callDataSource().length());
      case DATA_3 -> Bytes.ofUnsignedLong(p.requestedReturnDataTarget().length());
      case DATA_4 -> booleanToBytes(p.hubSuccess());
      case DATA_8 -> booleanToBytes(!p.requestedReturnDataTarget().isEmpty());
      default -> Bytes.EMPTY;
    };
  }

  @Override
  public int oobInstruction() {
    return OOB_INST_blake2f_cds;
  }
}
