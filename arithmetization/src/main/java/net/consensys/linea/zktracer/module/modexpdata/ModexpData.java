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

package net.consensys.linea.zktracer.module.modexpdata;

import static net.consensys.linea.zktracer.types.Conversions.bigIntegerToBytes;

import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.util.List;

import net.consensys.linea.zktracer.ColumnHeader;
import net.consensys.linea.zktracer.container.stacked.set.StackedSet;
import net.consensys.linea.zktracer.module.Module;
import org.apache.tuweni.bytes.Bytes;

public class ModexpData implements Module {
  private StackedSet<ModexpDataOperation> state = new StackedSet<>();

  @Override
  public String moduleKey() {
    return "MODEXP";
  }

  @Override
  public void enterTransaction() {
    this.state.enter();
  }

  @Override
  public void popTransaction() {
    this.state.pop();
  }

  @Override
  public int lineCount() {
    return this.state.lineCount();
  }

  @Override
  public List<ColumnHeader> columnsHeaders() {
    return Trace.headers(this.lineCount());
  }

  public void call(final ModexpDataOperation operation) {
    BigInteger base = operation.base().toUnsignedBigInteger();
    BigInteger exp = operation.exp().toUnsignedBigInteger();
    BigInteger mod = operation.mod().toUnsignedBigInteger();
    BigInteger result = base.modPow(exp, mod);

    Bytes resultBytes = bigIntegerToBytes(result);
    operation.result(resultBytes);

    this.state.add(operation);
  }

  @Override
  public void commit(List<MappedByteBuffer> buffers) {
    Trace trace = new Trace(buffers);
    int stamp = 0;
    for (ModexpDataOperation o : this.state) {
      stamp++;
      o.trace(trace, stamp);
    }
  }
}
