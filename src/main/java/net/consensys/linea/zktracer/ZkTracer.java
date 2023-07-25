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

package net.consensys.linea.zktracer;

import java.util.List;

import lombok.RequiredArgsConstructor;
import net.consensys.linea.zktracer.module.Module;
import net.consensys.linea.zktracer.module.add.Add;
import net.consensys.linea.zktracer.module.hub.Hub;
import net.consensys.linea.zktracer.module.mod.Mod;
import net.consensys.linea.zktracer.module.mul.Mul;
import net.consensys.linea.zktracer.module.shf.Shf;
import net.consensys.linea.zktracer.module.wcp.Wcp;
import net.consensys.linea.zktracer.opcode.OpCode;
import net.consensys.linea.zktracer.opcode.OpCodes;
import org.apache.tuweni.bytes.Bytes;
import org.hyperledger.besu.datatypes.Transaction;
import org.hyperledger.besu.evm.frame.MessageFrame;
import org.hyperledger.besu.evm.operation.Operation;
import org.hyperledger.besu.plugin.data.BlockBody;
import org.hyperledger.besu.plugin.data.BlockHeader;
import org.hyperledger.besu.plugin.services.tracer.BlockAwareOperationTracer;

@RequiredArgsConstructor
public class ZkTracer implements BlockAwareOperationTracer {
  private final ZkTraceBuilder zkTraceBuilder = new ZkTraceBuilder();
  private final Hub hub;
  private final List<Module> modules;

  public ZkTracer() {
    this.hub = new Hub();
    this.modules = List.of(new Mul(), new Shf(), new Wcp(), new Add(), new Mod());
    // Load opcodes configured in src/main/resources/opcodes.yml.
    OpCodes.load();
  }

  public ZkTracer(List<Module> modules) {
    this.hub = new Hub();
    this.modules = modules;
  }

  public ZkTrace getTrace() {
    for (Module module : this.modules) {
      zkTraceBuilder.addTrace(module);
    }
    return zkTraceBuilder.build();
  }

  public void traceStartConflation(final long numBlocksInConflation) {
    for (Module module : this.modules) {
      module.traceStartConflation(numBlocksInConflation);
    }
  }

  public void traceEndConflation() {
    for (Module module : this.modules) {
      module.traceEndConflation();
    }
  }

  @Override
  public void traceStartBlock(final BlockHeader blockHeader, final BlockBody blockBody) {
    this.hub.traceStartBlock(blockHeader, blockBody);
    for (Module module : this.modules) {
      module.traceStartBlock(blockHeader, blockBody);
    }
  }

  @Override
  public void traceEndBlock(final BlockHeader blockHeader, final BlockBody blockBody) {
    this.hub.traceEndBlock(blockHeader, blockBody);
    for (Module module : this.modules) {
      module.traceEndBlock(blockHeader, blockBody);
    }
  }

  @Override
  public void traceStartTransaction(final Transaction transaction) {
    this.hub.traceStartTx(transaction);
    for (Module module : this.modules) {
      module.traceStartTx(transaction);
    }
  }

  @Override
  public void traceEndTransaction(final Bytes output, final long gasUsed, final long timeNs) {
    this.hub.traceEndTx();
    for (Module module : this.modules) {
      module.traceEndTx();
    }
  }

  // TODO: missing ContextEnter/Exit

  @Override
  public void tracePreExecution(final MessageFrame frame) {
    OpCode opCode = OpCode.of(frame.getCurrentOperation().getOpcode());
    this.hub.trace(frame);

    if (!this.hub.isError()) {
      for (Module module : this.modules) {
        if (module.supportedOpCodes().contains(opCode)) {
          module.trace(frame);
        }
      }
    }
  }

  @Override
  public void tracePostExecution(MessageFrame frame, Operation.OperationResult operationResult) {
    this.hub.tracePostExecution(frame, operationResult);
  }
}
