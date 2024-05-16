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

package net.consensys.linea.zktracer.module.ext;

import static org.assertj.core.api.Assertions.assertThat;

import net.consensys.linea.zktracer.opcode.OpCode;
import net.consensys.linea.zktracer.testing.BytecodeCompiler;
import net.consensys.linea.zktracer.testing.BytecodeRunner;
import org.apache.tuweni.bytes.Bytes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class TestDuplicatedOperations {
  @Test
  void testDuplicate() {
    BytecodeRunner.of(
            BytecodeCompiler.newProgram()
                .push(
                    Bytes.fromHexString(
                        "0xffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"))
                .push(0)
                .push(0)
                .op(OpCode.MULMOD)
                .push(
                    Bytes.fromHexString(
                        "0xffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"))
                .push(0)
                .push(0)
                .op(OpCode.MULMOD)
                .compile())
        .zkTracerValidator(
            zkTracer -> {
              assertThat(zkTracer.getModulesLineCount().get("EXT")).isEqualTo(9);
            })
        .run();
  }
}
