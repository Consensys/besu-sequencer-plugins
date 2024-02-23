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

package net.consensys.linea.zktracer.module.tables.shf;

import java.nio.MappedByteBuffer;
import java.util.List;

import net.consensys.linea.zktracer.ColumnHeader;
import net.consensys.linea.zktracer.module.Module;
import net.consensys.linea.zktracer.types.UnsignedByte;
import org.apache.tuweni.bytes.Bytes;

public record ShfRt() implements Module {
  @Override
  public String moduleKey() {
    return "shfRT";
  }

  @Override
  public void enterTransaction() {}

  @Override
  public void popTransaction() {}

  @Override
  public int lineCount() {
    return 256 * 9;
  }

  @Override
  public List<ColumnHeader> columnsHeaders() {
    return Trace.headers(this.lineCount());
  }

  public void commit(List<MappedByteBuffer> buffers) {
    final Trace trace = new Trace(buffers);
    for (int a = 0; a <= 255; a++) {
      for (int uShp = 0; uShp <= 8; uShp++) {
        trace
            .byte1(UnsignedByte.of(a))
            .las(Bytes.ofUnsignedShort(a).shiftLeft(8 - uShp)) // a<<(8-µShp)
            .mshp((short) uShp)
            .rap(Bytes.ofUnsignedShort(a).shiftRight(uShp))
            .ones((Bytes.fromHexString("0xFF").shiftRight(uShp)).not())
            .iomf(true)
            .validateRow();
      }
    }
  }
}
