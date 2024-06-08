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

package net.consensys.linea.zktracer.module.hub;

import net.consensys.linea.zktracer.opcode.OpCode;
import net.consensys.linea.zktracer.testing.BytecodeCompiler;
import net.consensys.linea.zktracer.testing.BytecodeRunner;
import net.consensys.linea.zktracer.testing.EvmExtension;
import org.apache.tuweni.bytes.Bytes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(EvmExtension.class)
public class StupidCreateTBD {

  @Test
  void testStupidCreateTBD() {
    BytecodeRunner.of(
            BytecodeCompiler.newProgram()
                .push(
                    Bytes.fromHexString(
                        "0x63deadbeef000000000000000000000000000000000000000000000000000000"))
                .push(Bytes.of(0x00))
                .op(OpCode.MSTORE)
                .push(0x05)
                .push(0x00)
                .push(0x00)
                .op(OpCode.CREATE)
                .op(OpCode.DUP1)
                .compile())
        .run();
  }

  @Test
  void TestReturnDataCopyAlternative() {
    BytecodeCompiler program = BytecodeCompiler.newProgram();

    program
        .push("63deadbeef000000000000000000000000000000000000000000000000000000")
        .push(0)
        .op(OpCode.MSTORE)
        .push(0x04)
        .push(0)
        .push(0)
        .op(OpCode.CREATE)
        .op(OpCode.DUP1);

    BytecodeRunner bytecodeRunner = BytecodeRunner.of(program.compile());
    bytecodeRunner.run();
  }
}
