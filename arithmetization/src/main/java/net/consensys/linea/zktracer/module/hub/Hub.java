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

package net.consensys.linea.zktracer.module.hub;

import static net.consensys.linea.zktracer.types.AddressUtils.effectiveToAddress;
import static net.consensys.linea.zktracer.types.AddressUtils.isPrecompile;
import static net.consensys.linea.zktracer.types.AddressUtils.precompileAddress;
import static net.consensys.linea.zktracer.types.HubProcessingPhase.TX_EXEC;
import static net.consensys.linea.zktracer.types.HubProcessingPhase.TX_FINAL;
import static net.consensys.linea.zktracer.types.HubProcessingPhase.TX_INIT;
import static net.consensys.linea.zktracer.types.HubProcessingPhase.TX_SKIP;
import static net.consensys.linea.zktracer.types.HubProcessingPhase.TX_WARM;

import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.google.common.base.Preconditions;
import lombok.Getter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import net.consensys.linea.zktracer.ColumnHeader;
import net.consensys.linea.zktracer.ZkTracer;
import net.consensys.linea.zktracer.module.Module;
import net.consensys.linea.zktracer.module.add.Add;
import net.consensys.linea.zktracer.module.bin.Bin;
import net.consensys.linea.zktracer.module.blake2fmodexpdata.Blake2fModexpData;
import net.consensys.linea.zktracer.module.blockdata.Blockdata;
import net.consensys.linea.zktracer.module.blockhash.Blockhash;
import net.consensys.linea.zktracer.module.ecdata.EcData;
import net.consensys.linea.zktracer.module.euc.Euc;
import net.consensys.linea.zktracer.module.exp.Exp;
import net.consensys.linea.zktracer.module.ext.Ext;
import net.consensys.linea.zktracer.module.hub.defer.*;
import net.consensys.linea.zktracer.module.hub.fragment.*;
import net.consensys.linea.zktracer.module.hub.fragment.imc.ImcFragment;
import net.consensys.linea.zktracer.module.hub.fragment.scenario.ScenarioFragment;
import net.consensys.linea.zktracer.module.hub.precompiles.PrecompileInvocation;
import net.consensys.linea.zktracer.module.hub.section.*;
import net.consensys.linea.zktracer.module.hub.signals.PlatformController;
import net.consensys.linea.zktracer.module.hub.transients.DeploymentInfo;
import net.consensys.linea.zktracer.module.hub.transients.Transients;
import net.consensys.linea.zktracer.module.limits.Keccak;
import net.consensys.linea.zktracer.module.limits.L2Block;
import net.consensys.linea.zktracer.module.limits.L2L1Logs;
import net.consensys.linea.zktracer.module.limits.precompiles.Blake2fRounds;
import net.consensys.linea.zktracer.module.limits.precompiles.EcAddEffectiveCall;
import net.consensys.linea.zktracer.module.limits.precompiles.EcMulEffectiveCall;
import net.consensys.linea.zktracer.module.limits.precompiles.EcPairingCallEffectiveCall;
import net.consensys.linea.zktracer.module.limits.precompiles.EcPairingMillerLoop;
import net.consensys.linea.zktracer.module.limits.precompiles.EcRecoverEffectiveCall;
import net.consensys.linea.zktracer.module.limits.precompiles.ModexpEffectiveCall;
import net.consensys.linea.zktracer.module.limits.precompiles.RipeMd160Blocks;
import net.consensys.linea.zktracer.module.limits.precompiles.Sha256Blocks;
import net.consensys.linea.zktracer.module.logdata.LogData;
import net.consensys.linea.zktracer.module.loginfo.LogInfo;
import net.consensys.linea.zktracer.module.mmio.Mmio;
import net.consensys.linea.zktracer.module.mmu.Mmu;
import net.consensys.linea.zktracer.module.mod.Mod;
import net.consensys.linea.zktracer.module.mul.Mul;
import net.consensys.linea.zktracer.module.mxp.Mxp;
import net.consensys.linea.zktracer.module.oob.Oob;
import net.consensys.linea.zktracer.module.rlpaddr.RlpAddr;
import net.consensys.linea.zktracer.module.rlptxn.RlpTxn;
import net.consensys.linea.zktracer.module.rlptxrcpt.RlpTxrcpt;
import net.consensys.linea.zktracer.module.rom.Rom;
import net.consensys.linea.zktracer.module.romlex.RomLex;
import net.consensys.linea.zktracer.module.shakiradata.ShakiraData;
import net.consensys.linea.zktracer.module.shf.Shf;
import net.consensys.linea.zktracer.module.stp.Stp;
import net.consensys.linea.zktracer.module.tables.bin.BinRt;
import net.consensys.linea.zktracer.module.tables.instructionDecoder.InstructionDecoder;
import net.consensys.linea.zktracer.module.tables.shf.ShfRt;
import net.consensys.linea.zktracer.module.trm.Trm;
import net.consensys.linea.zktracer.module.txndata.TxnData;
import net.consensys.linea.zktracer.module.wcp.Wcp;
import net.consensys.linea.zktracer.opcode.*;
import net.consensys.linea.zktracer.opcode.gas.projector.GasProjector;
import net.consensys.linea.zktracer.runtime.LogInvocation;
import net.consensys.linea.zktracer.runtime.callstack.CallFrame;
import net.consensys.linea.zktracer.runtime.callstack.CallFrameType;
import net.consensys.linea.zktracer.runtime.callstack.CallStack;
import net.consensys.linea.zktracer.runtime.stack.StackContext;
import net.consensys.linea.zktracer.runtime.stack.StackLine;
import net.consensys.linea.zktracer.types.*;
import org.apache.tuweni.bytes.Bytes;
import org.apache.tuweni.bytes.Bytes32;
import org.apache.tuweni.units.bigints.UInt256;
import org.hyperledger.besu.datatypes.AccessListEntry;
import org.hyperledger.besu.datatypes.Address;
import org.hyperledger.besu.datatypes.Transaction;
import org.hyperledger.besu.datatypes.Wei;
import org.hyperledger.besu.evm.account.Account;
import org.hyperledger.besu.evm.account.AccountState;
import org.hyperledger.besu.evm.frame.MessageFrame;
import org.hyperledger.besu.evm.internal.Words;
import org.hyperledger.besu.evm.log.Log;
import org.hyperledger.besu.evm.log.LogTopic;
import org.hyperledger.besu.evm.operation.Operation;
import org.hyperledger.besu.evm.worldstate.WorldView;
import org.hyperledger.besu.plugin.data.BlockBody;
import org.hyperledger.besu.plugin.data.BlockHeader;
import org.hyperledger.besu.plugin.data.ProcessableBlockHeader;

@Slf4j
@Accessors(fluent = true)
public class Hub implements Module {

  private static final int TAU = 8;

  public static final GasProjector GAS_PROJECTOR = new GasProjector();

  /** accumulate the trace information for the Hub */
  @Getter public final State state = new State();

  /** contain the factories for trace segments that need complex initialization */
  @Getter private final Factories factories;

  /** provides phase-related volatile information */
  @Getter Transients transients;

  /**
   * Long-lived states, not used in tracing per se but keeping track of data of the associated
   * lifetime
   */
  @Getter CallStack callStack = new CallStack();

  @Getter TransactionStack txStack = new TransactionStack();

  /** Stores all the actions that must be deferred to a later time */
  @Getter private final DeferRegistry defers = new DeferRegistry();

  /** stores all data related to failure states & module activation */
  @Getter private final PlatformController pch;

  @Getter private ProcessableBlockHeader currentBlockHeader;

  @Override
  public String moduleKey() {
    return "HUB";
  }

  @Override
  public List<ColumnHeader> columnsHeaders() {
    return Trace.headers(this.lineCount());
  }

  @Override
  public void commit(List<MappedByteBuffer> buffers) {
    final Trace trace = new Trace(buffers);
    this.state.commit(trace);
  }

  public int stamp() {
    return this.state.stamps().hub();
  }

  public OpCodeData opCodeData() {
    return this.currentFrame().opCodeData();
  }

  public OpCode opCode() {
    return this.currentFrame().opCode();
  }

  TraceSection currentTraceSection() {
    return this.state.currentTxTrace().currentSection();
  }

  public int lastPc() {
    if (this.state.currentTxTrace().isEmpty()) {
      return 0;
    } else {
      return this.state.currentTxTrace().currentSection().pc();
    }
  }

  public int lastContextNumber() {
    if (this.state.currentTxTrace().isEmpty()) {
      return 0;
    } else {
      return this.state.currentTxTrace().currentSection().contextNumber();
    }
  }

  public void addTraceSection(TraceSection section) {
    section.seal(this);
    this.state.currentTxTrace().add(section);
  }

  @Getter private final Wcp wcp = new Wcp(this);
  private final Module add = new Add(this);
  private final Module bin = new Bin(this);
  private final Blake2fModexpData blake2fModexpData = new Blake2fModexpData(this.wcp);
  @Getter private final EcData ecData;
  private final Blockdata blockdata;
  private final Blockhash blockhash = new Blockhash(wcp);
  private final Euc euc;
  private final Ext ext = new Ext(this);
  private final Module mul = new Mul(this);
  private final Mod mod = new Mod();
  private final Module shf = new Shf();
  private final RlpTxn rlpTxn;
  private final Module mxp;
  private final Mmio mmio;

  @Getter private final Exp exp;
  @Getter private final Mmu mmu;
  private final RlpTxrcpt rlpTxrcpt;
  private final LogInfo logInfo;
  private final LogData logData;
  private final Trm trm = new Trm();
  private final RlpAddr rlpAddr = new RlpAddr(this, trm);
  private final Rom rom;

  @Getter private final RomLex romLex;
  private final TxnData txnData;
  private final ShakiraData shakiraData = new ShakiraData(this.wcp);
  private final ModexpEffectiveCall modexpEffectiveCall;
  private final Stp stp = new Stp(this, wcp, mod);
  private final L2Block l2Block;

  @Getter private final Oob oob;

  private final List<Module> modules;
  /*
   * Those modules are not traced, we just compute the number of calls to those
   * precompile to meet the prover limits
   */
  private final List<Module> precompileLimitModules;
  private final List<Module> refTableModules;

  public Hub(final Address l2l1ContractAddress, final Bytes l2l1Topic) {
    this.l2Block = new L2Block(l2l1ContractAddress, LogTopic.of(l2l1Topic));
    this.transients = new Transients(this);
    this.factories = new Factories(this);

    this.pch = new PlatformController(this);
    this.mxp = new Mxp(this);
    this.exp = new Exp(this.wcp);
    this.romLex = new RomLex(this);
    this.rom = new Rom(this.romLex);
    this.rlpTxn = new RlpTxn(this.romLex);
    this.euc = new Euc(this.wcp);
    this.txnData = new TxnData(this, this.romLex, this.wcp, this.euc);
    this.blockdata = new Blockdata(this.wcp, this.txnData, this.rlpTxn);
    this.rlpTxrcpt = new RlpTxrcpt(txnData);
    this.logData = new LogData(rlpTxrcpt);
    this.logInfo = new LogInfo(rlpTxrcpt);
    this.ecData = new EcData(this, this.wcp, this.ext);
    this.oob = new Oob(this, (Add) this.add, this.mod, this.wcp);
    this.mmu =
        new Mmu(
            this.euc,
            this.wcp,
            this.romLex,
            this.rlpTxn,
            this.rlpTxrcpt,
            this.ecData,
            this.blake2fModexpData,
            this.callStack);
    this.mmio = new Mmio(this.mmu);

    final EcRecoverEffectiveCall ecRec = new EcRecoverEffectiveCall(this);
    this.modexpEffectiveCall = new ModexpEffectiveCall(this, this.blake2fModexpData);
    final EcPairingCallEffectiveCall ecPairingCall = new EcPairingCallEffectiveCall(this);
    final L2Block l2Block = new L2Block(l2l1ContractAddress, LogTopic.of(l2l1Topic));

    this.precompileLimitModules =
        List.of(
            new Sha256Blocks(this, shakiraData),
            ecRec,
            new RipeMd160Blocks(this, shakiraData),
            this.modexpEffectiveCall,
            new EcAddEffectiveCall(this),
            new EcMulEffectiveCall(this),
            ecPairingCall,
            new EcPairingMillerLoop(ecPairingCall),
            new Blake2fRounds(this, this.blake2fModexpData),
            // Block level limits
            l2Block,
            new Keccak(this, ecRec, l2Block, shakiraData),
            new L2L1Logs(l2Block));

    this.refTableModules = List.of(new BinRt(), new InstructionDecoder(), new ShfRt());

    this.modules =
        Stream.concat(
                Stream.of(
                    this.add,
                    this.bin,
                    this.blake2fModexpData,
                    this.blockdata,
                    this.blockhash,
                    this.ecData,
                    this.euc,
                    this.ext,
                    this.logData,
                    this.logInfo,
                    this.mmio,
                    this.mmu,
                    this.mod,
                    this.mul,
                    this.mxp,
                    this.oob,
                    this.exp,
                    this.rlpAddr,
                    this.rlpTxn,
                    this.rom,
                    this.romLex,
                    this.shakiraData,
                    this.shf,
                    this.stp,
                    this.trm,
                    this.wcp, /* WARN: must be called BEFORE txnData */
                    this.txnData,
                    this.rlpTxrcpt /* WARN: must be called AFTER txnData */),
                this.precompileLimitModules.stream())
            .toList();
  }

  /**
   * @return a list of all modules for which to generate traces
   */
  public List<Module> getModulesToTrace() {
    return Stream.concat(
            this.refTableModules.stream(),
            // Modules
            Stream.of(
                this,
                this.add,
                this.bin,
                this.blake2fModexpData,
                this.ecData,
                this.blockdata,
                this.blockhash,
                this.ext,
                this.euc,
                this.exp,
                this.logData,
                this.logInfo,
                this.mmu, // WARN: must be called before the MMIO
                this.mmio,
                this.mod,
                this.mul,
                this.mxp,
                // TODO: Temporarily disabled.
                //                this.oob,
                this.rlpAddr,
                this.rlpTxn,
                this.rlpTxrcpt,
                this.rom,
                this.romLex,
                this.shakiraData,
                this.shf,
                this.stp,
                this.trm,
                this.txnData,
                this.wcp))
        .toList();
  }

  /**
   * List all the modules for which to generate counters. Intersects with, but is not equal to
   * {@code getModulesToTrace}.
   *
   * @return the modules to count
   */
  public List<Module> getModulesToCount() {
    return Stream.concat(
            Stream.of(
                this,
                this.romLex,
                this.add,
                this.bin,
                this.blockdata,
                this.blockhash,
                this.ext,
                this.ecData,
                this.euc,
                this.mmu,
                this.mmio,
                this.logData,
                this.logInfo,
                this.mod,
                this.mul,
                this.mxp,
                // TODO: Temporarily disabled.
                //                this.oob,
                this.exp,
                this.rlpAddr,
                this.rlpTxn,
                this.rlpTxrcpt,
                this.rom,
                this.shf,
                this.trm,
                this.txnData,
                this.wcp,
                this.l2Block),
            this.precompileLimitModules.stream())
        .toList();
  }

  /**
   * Traces a skipped transaction, i.e. a “pure” transaction without EVM execution.
   *
   * @param world a view onto the state
   */
  void processStateSkip(WorldView world) {
    this.state.setProcessingPhase(TX_SKIP);
    this.state.stamps().incrementHubStamp();
    final boolean isDeployment = this.txStack.current().getBesuTransaction().getTo().isEmpty();

    //
    // 3 sections -- account changes
    //
    // From account information
    final Address fromAddress = this.txStack.current().getBesuTransaction().getSender();
    final AccountSnapshot oldFromAccount =
        AccountSnapshot.fromAccount(
            world.get(fromAddress),
            isPrecompile(fromAddress),
            this.transients.conflation().deploymentInfo().number(fromAddress),
            false);

    // To account information
    final Address toAddress = effectiveToAddress(this.txStack.current().getBesuTransaction());
    if (isDeployment) {
      this.transients.conflation().deploymentInfo().deploy(toAddress);
    }
    final AccountSnapshot oldToAccount =
        AccountSnapshot.fromAccount(
            world.get(toAddress),
            isPrecompile(toAddress),
            this.transients.conflation().deploymentInfo().number(toAddress),
            false);

    // Miner account information
    final Address minerAddress = this.transients.block().minerAddress();

    final AccountSnapshot oldMinerAccount =
        AccountSnapshot.fromAccount(
            world.get(minerAddress),
            isPrecompile(minerAddress),
            this.transients
                .conflation()
                .deploymentInfo()
                .number(this.transients.block().minerAddress()),
            false);

    // Putatively updateCallerReturnData deployment number
    this.defers.postTx(
        new SkippedPostTransactionDefer(
            oldFromAccount,
            oldToAccount,
            oldMinerAccount,
            Wei.of(this.txStack.current().getEffectiveGasPrice()),
            this.transients.block().baseFee()));
  }

  /**
   * Traces the isWarm-up information of a transaction
   *
   * @param world a view onto the state
   */
  void processPrewarmingPhase(WorldView world) {
    this.state.setProcessingPhase(TX_WARM);
    this.txStack
        .current()
        .getBesuTransaction()
        .getAccessList()
        .ifPresent(
            accessList -> {
              if (!accessList.isEmpty()) {
                Set<Address> seenAddresses = new HashSet<>(precompileAddress);
                Map<Address, Set<Bytes32>> seenKeys = new HashMap<>();
                List<TraceFragment> fragments = new ArrayList<>();

                for (AccessListEntry entry : accessList) {
                  this.state.stamps().incrementHubStamp();
                  final Address address = entry.address();

                  final DeploymentInfo deploymentInfo =
                      this.transients.conflation().deploymentInfo();

                  final int deploymentNumber = deploymentInfo.number(address);
                  Preconditions.checkArgument(
                      !deploymentInfo.isDeploying(address),
                      "Deployment status during TX_INIT phase of any address should always be false");

                  final boolean isAccountWarm = seenAddresses.contains(address);
                  final AccountSnapshot preWarmingAccountSnapshot =
                      AccountSnapshot.fromAccount(
                          world.get(address), isAccountWarm, deploymentNumber, false);

                  final AccountSnapshot postWarmingAccountSnapshot =
                      AccountSnapshot.fromAccount(
                          world.get(address), true, deploymentNumber, false);

                  fragments.add(
                      this.factories
                          .accountFragment()
                          .makeWithTrm(
                              preWarmingAccountSnapshot, postWarmingAccountSnapshot, address));

                  seenAddresses.add(address);

                  List<Bytes32> keys = entry.storageKeys();
                  for (Bytes32 k : keys) {
                    this.state.stamps().incrementHubStamp();

                    final UInt256 key = UInt256.fromBytes(k);
                    final EWord value =
                        Optional.ofNullable(world.get(address))
                            .map(account -> EWord.of(account.getStorageValue(key)))
                            .orElse(EWord.ZERO);

                    fragments.add(
                        new StorageFragment(
                            address,
                            deploymentInfo.number(address),
                            EWord.of(key),
                            value,
                            value,
                            value,
                            seenKeys.computeIfAbsent(address, x -> new HashSet<>()).contains(key),
                            true));

                    seenKeys.get(address).add(key);
                  }
                }

                final TransactionProcessingMetadata transactionProcessingMetadata =
                    this.txStack.current();
                final Transaction besuTx = transactionProcessingMetadata.getBesuTransaction();
                final Address senderAddress = besuTx.getSender();
                final Address receiverAddress = effectiveToAddress(besuTx);
                transactionProcessingMetadata.isSenderPreWarmed(
                    seenAddresses.contains(senderAddress));
                transactionProcessingMetadata.isReceiverPreWarmed(
                    seenAddresses.contains(receiverAddress));

                this.addTraceSection(new WarmupSection(this, fragments));
              }
            });
  }

  /**
   * Trace the preamble of a transaction
   *
   * @param world a view onto the state
   */
  void processStateInit(WorldView world) {
    this.state.setProcessingPhase(TX_INIT);
    this.state.stamps().incrementHubStamp();
    final TransactionProcessingMetadata tx = this.transients.tx();
    final boolean isDeployment = tx.getBesuTransaction().getTo().isEmpty();
    final Address toAddress = effectiveToAddress(tx.getBesuTransaction());
    final DeploymentInfo deploymentInfo = this.transients.conflation().deploymentInfo();

    final Address fromAddress = tx.getBesuTransaction().getSender();
    final Account fromAccount = world.get(fromAddress);
    final AccountSnapshot preInitFromSnapshot =
        AccountSnapshot.fromAccount(
            fromAccount,
            tx.isSenderPreWarmed(),
            deploymentInfo.number(fromAddress),
            deploymentInfo.isDeploying(fromAddress));

    final Wei transactionGasPrice =
        ZkTracer.feeMarket
            .getTransactionPriceCalculator()
            .price(
                (org.hyperledger.besu.ethereum.core.Transaction) tx.getBesuTransaction(),
                Optional.of(this.transients.block().baseFee()));
    final Wei value = (Wei) tx.getBesuTransaction().getValue();
    final AccountSnapshot postInitFromSnapshot =
        preInitFromSnapshot.debit(
            transactionGasPrice.multiply(tx.getBesuTransaction().getGasLimit()).add(value), true);

    final boolean isSelfCredit = toAddress.equals(fromAddress);

    final Account toAccount = world.get(toAddress);

    final AccountSnapshot preInitToSnapshot =
        isSelfCredit
            ? postInitFromSnapshot
            : AccountSnapshot.fromAccount(
                toAccount,
                tx.isReceiverPreWarmed(),
                deploymentInfo.number(toAddress),
                deploymentInfo.isDeploying(toAddress));

    if (isDeployment) {
      deploymentInfo.deploy(toAddress);
    }

    final Bytecode initBytecode =
        new Bytecode(tx.getBesuTransaction().getInit().orElse(Bytes.EMPTY));
    final AccountSnapshot postInitToSnapshot =
        isDeployment
            ? preInitToSnapshot.deploy(value, initBytecode)
            : preInitToSnapshot.credit(value, true);

    final TransactionFragment txFragment = TransactionFragment.prepare(this.txStack.current());
    this.defers.postTx(txFragment);

    final AccountFragment.AccountFragmentFactory accountFragmentFactory =
        this.factories.accountFragment();

    this.addTraceSection(
        new TxInitSection(
            this,
            accountFragmentFactory.make(preInitFromSnapshot, postInitFromSnapshot),
            accountFragmentFactory
                .makeWithTrm(preInitToSnapshot, postInitToSnapshot, toAddress)
                .requiresCodeFragmentIndex(true),
            ImcFragment.forTxInit(this),
            ContextFragment.initializeExecutionContext(this),
            txFragment));

    this.state.setProcessingPhase(TX_EXEC);
  }

  public CallFrame currentFrame() {
    if (this.callStack().isEmpty()) {
      return CallFrame.EMPTY;
    }
    return this.callStack.current();
  }

  public int contextNumberNew(WorldView world) {
    switch (this.state.getProcessingPhase()) {
      case TX_SKIP, TX_WARM, TX_FINAL -> {
        return 0;
      }
      case TX_INIT -> {
        return this.state.stamps().hub() + 1;
      }
      case TX_EXEC -> {
        final OpCode opCode = this.opCode();

        if (pch.exceptions().any()
            || opCode.getData().instructionFamily().equals(InstructionFamily.HALT)
            || opCode.getData().instructionFamily().equals(InstructionFamily.INVALID)) {
          return this.callStack.depth() == 0 ? 0 : this.callStack().caller().contextNumber();
        }

        final int currentContextNumber = this.callStack().current().contextNumber();

        if (opCode.isCall()) {
          if (pch().abortingConditions().any()) {
            return currentContextNumber;
          }
          Address calleeAddress =
              Address.extract((Bytes32) this.currentFrame().frame().getStackItem(1));
          if (world.get(calleeAddress).hasCode()) {
            return 1 + stamp();
          }
        }

        if (opCode.isCreate()) {
          if (pch().abortingConditions().any() || pch().failureConditions().any()) {
            return currentContextNumber;
          }
          final int initCodeSize = this.currentFrame().frame().getStackItem(2).toInt();
          if (initCodeSize != 0) {
            return 1 + stamp();
          }
        }

        return currentContextNumber;
      }
      default -> {
        {
          throw new IllegalStateException(
              String.format("Hub can't be in the state %s", this.state.getProcessingPhase()));
        }
      }
    }
  }

  public MessageFrame messageFrame() {
    return this.callStack.current().frame();
  }

  private void handleStack(MessageFrame frame) {
    this.currentFrame().stack().processInstruction(this, frame, TAU * this.state.stamps().hub());
  }

  void triggerModules(MessageFrame frame) {
    if (this.pch.exceptions().none() && this.pch.abortingConditions().none()) {
      for (Module precompileLimit : this.precompileLimitModules) {
        precompileLimit.tracePreOpcode(frame);
      }
    }

    if (this.pch.signals().romLex()) {
      this.romLex.tracePreOpcode(frame);
    }
    if (this.pch.signals().add()) {
      this.add.tracePreOpcode(frame);
    }
    if (this.pch.signals().bin()) {
      this.bin.tracePreOpcode(frame);
    }
    if (this.pch.signals().rlpAddr()) {
      this.rlpAddr.tracePreOpcode(frame);
    }
    if (this.pch.signals().mul()) {
      this.mul.tracePreOpcode(frame);
    }
    if (this.pch.signals().ext()) {
      this.ext.tracePreOpcode(frame);
    }
    if (this.pch.signals().mod()) {
      this.mod.tracePreOpcode(frame);
    }
    if (this.pch.signals().wcp()) {
      this.wcp.tracePreOpcode(frame);
    }
    if (this.pch.signals().shf()) {
      this.shf.tracePreOpcode(frame);
    }
    if (this.pch.signals().mxp()) {
      this.mxp.tracePreOpcode(frame);
    }
    if (this.pch.signals().oob()) {
      this.oob.tracePreOpcode(frame);
    }
    if (this.pch.signals().stp()) {
      this.stp.tracePreOpcode(frame);
    }
    if (this.pch.signals().exp()) {
      this.exp.tracePreOpcode(frame);
    }
    if (this.pch.signals().trm()) {
      this.trm.tracePreOpcode(frame);
    }
    if (this.pch.signals().hashInfo()) {
      // TODO: this.hashInfo.tracePreOpcode(frame);
    }
    if (this.pch.signals().ecData()) {
      this.ecData.tracePreOpcode(frame);
    }
    if (this.pch.signals().blockhash()) {
      this.blockhash.tracePreOpcode(frame);
    }
  }

  void processStateExec(MessageFrame frame) {
    this.currentFrame().frame(frame);
    this.state.stamps().incrementHubStamp();

    this.pch.setup(frame);
    this.state.stamps().stampSubmodules(this.pch());

    this.handleStack(frame);
    this.triggerModules(frame);
    if (this.pch().exceptions().any() || this.currentFrame().opCode() == OpCode.REVERT) {
      this.callStack.revert(this.state.stamps().hub());
    }

    if (this.currentFrame().stack().isOk()) {
      this.traceOperation(frame);
    } else {
      this.addTraceSection(new StackOnlySection(this));
      this.currentTraceSection()
          .addFragmentsWithoutStack(this, ContextFragment.executionEmptyReturnData(this.callStack));
    }
  }

  void processStateFinal(WorldView worldView) {
    this.state.setProcessingPhase(TX_FINAL);
    this.state.stamps().incrementHubStamp();

    final Address fromAddress = this.txStack.current().getBesuTransaction().getSender();
    final Account fromAccount = worldView.get(fromAddress);
    final DeploymentInfo deploymentInfo = this.transients.conflation().deploymentInfo();
    final AccountSnapshot preFinalFromSnapshot =
        AccountSnapshot.fromAccount(
            fromAccount,
            true,
            deploymentInfo.number(fromAddress),
            deploymentInfo.isDeploying(fromAddress));

    // TODO: still no finished
    final AccountSnapshot postFinalFromSnapshot =
        AccountSnapshot.fromAccount(
            fromAccount,
            true,
            deploymentInfo.number(fromAddress),
            deploymentInfo.isDeploying(fromAddress));

    final Address minerAddress = this.txStack.current().getCoinbase();
    final Account minerAccount = worldView.get(minerAddress);

    final AccountSnapshot preFinalCoinbaseSnapshot =
        AccountSnapshot.fromAccount(
            minerAccount,
            true,
            deploymentInfo.number(minerAddress),
            deploymentInfo.isDeploying(minerAddress));

    // TODO: still not finished
    final AccountSnapshot postFinalCoinbaseSnapshot =
        AccountSnapshot.fromAccount(
            minerAccount,
            true,
            deploymentInfo.number(minerAddress),
            deploymentInfo.isDeploying(minerAddress));

    final AccountFragment.AccountFragmentFactory accountFragmentFactory =
        this.factories.accountFragment();

    if (this.txStack.current().statusCode()) {
      // if no revert: 2 account rows (sender, coinbase) + 1 tx row
      this.addTraceSection(
          new EndTransactionSection(
              this,
              accountFragmentFactory.make(preFinalFromSnapshot, postFinalFromSnapshot),
              accountFragmentFactory.make(preFinalCoinbaseSnapshot, postFinalCoinbaseSnapshot),
              TransactionFragment.prepare(this.txStack.current())));
    } else {
      // Trace the exceptions of a transaction that could not even start
      // TODO: integrate with PCH
      // if (this.exceptions == null) {
      // this.exceptions = Exceptions.fromOutOfGas();
      // }
      // otherwise 4 account rows (sender, coinbase, sender, recipient) + 1 tx row
      final Address toAddress = this.transients.tx().getBesuTransaction().getSender();
      final Account toAccount = worldView.get(toAddress);
      final AccountSnapshot preFinalToSnapshot =
          AccountSnapshot.fromAccount(
              toAccount,
              true,
              deploymentInfo.number(toAddress),
              deploymentInfo.isDeploying(toAddress));

      // TODO: still not finished
      final AccountSnapshot postFinalToSnapshot =
          AccountSnapshot.fromAccount(
              toAccount,
              true,
              deploymentInfo.number(toAddress),
              deploymentInfo.isDeploying(toAddress));
      this.addTraceSection(
          new EndTransactionSection(
              this,
              accountFragmentFactory.make(preFinalFromSnapshot, postFinalFromSnapshot),
              accountFragmentFactory.make(preFinalToSnapshot, postFinalToSnapshot),
              accountFragmentFactory.make(preFinalCoinbaseSnapshot, postFinalCoinbaseSnapshot)));
    }
  }

  @Override
  public void enterTransaction() {
    for (Module m : this.modules) {
      m.enterTransaction();
    }
  }

  @Override
  public void traceStartTx(final WorldView world, final Transaction tx) {
    this.pch.reset();
    this.state.enter();
    this.txStack.enterTransaction(world, tx, transients.block());

    this.defers.postTx(this.state.currentTxTrace());

    this.enterTransaction();

    if (!this.txStack.current().requiresEvmExecution()) {
      this.processStateSkip(world);
    } else {
      if (this.txStack.current().requiresPrewarming()) {
        this.processPrewarmingPhase(world);
      }
      this.processStateInit(world);
    }

    for (Module m : this.modules) {
      // TODO: should use only a LineaTransaction as its argument
      m.traceStartTx(world, tx);
      m.traceStartTx(this.txStack().current());
    }
  }

  @Override
  public void popTransaction() {
    this.txStack.pop();
    this.state.pop();
    for (Module m : this.modules) {
      m.popTransaction();
    }
  }

  @Override
  public void traceEndTx(
      WorldView world,
      Transaction tx,
      boolean isSuccessful,
      Bytes output,
      List<Log> logs,
      long gasUsed) {
    final long leftoverGas = txStack.current().getBesuTransaction().getGasLimit() - gasUsed;
    txStack
        .current()
        .completeLineaTransaction(
            isSuccessful, leftoverGas, this.accruedRefunds(), this.state.stamps().hub());
    this.txStack.exitTransaction(this, isSuccessful);

    if (this.state.processingPhase != TX_SKIP) {
      this.processStateFinal(world);
    }

    this.defers.runPostTx(this, world, tx, isSuccessful);

    for (Module m : this.modules) {
      m.traceEndTx(world, tx, isSuccessful, output, logs, gasUsed);
    }
  }

  private void unlatchStack(MessageFrame frame) {
    this.unlatchStack(frame, this.currentTraceSection());
  }

  public void unlatchStack(MessageFrame frame, TraceSection section) {
    if (this.currentFrame().pending() == null) {
      return;
    }

    StackContext pending = this.currentFrame().pending();
    for (int i = 0; i < pending.lines().size(); i++) {
      StackLine line = pending.lines().get(i);

      if (line.needsResult()) {
        Bytes result = Bytes.EMPTY;
        // Only pop from the stack if no exceptions have been encountered
        if (this.pch.exceptions().none()) {
          result = frame.getStackItem(0).copy();
        }

        // This works because we are certain that the stack chunks are the first.
        ((StackFragment) section.lines().get(i).specific())
            .stackOps()
            .get(line.resultColumn() - 1)
            .value(result);
      }
    }

    if (this.pch.exceptions().none()) {
      for (TraceSection.TraceLine line : section.lines()) {
        if (line.specific() instanceof StackFragment stackFragment) {
          stackFragment.feedHashedValue(frame);
        }
      }
    }
  }

  @Override
  public void traceContextEnter(MessageFrame frame) {
    this.pch.reset();

    if (frame.getDepth() == 0) {
      // Bedrock...
      final TransactionProcessingMetadata currentTx = transients().tx();
      final Address toAddress = effectiveToAddress(currentTx.getBesuTransaction());
      final boolean isDeployment = this.transients.tx().getBesuTransaction().getTo().isEmpty();

      final boolean shouldCopyTxCallData =
          !isDeployment && !frame.getInputData().isEmpty() && currentTx.requiresEvmExecution();
      // TODO simplify this, the same bedRock context ( = root context ??) seems to be
      // generated in
      // both case
      if (shouldCopyTxCallData) {
        this.callStack.newMantleAndBedrock(
            this.state.stamps().hub(),
            this.transients.tx().getBesuTransaction().getSender(),
            toAddress,
            CallFrameType.MANTLE,
            new Bytecode(
                toAddress == null
                    ? this.transients.tx().getBesuTransaction().getData().orElse(Bytes.EMPTY)
                    : Optional.ofNullable(frame.getWorldUpdater().get(toAddress))
                        .map(AccountState::getCode)
                        .orElse(Bytes.EMPTY)),
            Wei.of(this.transients.tx().getBesuTransaction().getValue().getAsBigInteger()),
            this.transients.tx().getBesuTransaction().getGasLimit(),
            this.transients.tx().getBesuTransaction().getData().orElse(Bytes.EMPTY),
            this.transients.conflation().deploymentInfo().number(toAddress),
            toAddress.isEmpty()
                ? 0
                : this.transients.conflation().deploymentInfo().number(toAddress),
            this.transients.conflation().deploymentInfo().isDeploying(toAddress));
      } else {
        this.callStack.newBedrock(
            this.state.stamps().hub(),
            // this.transients.tx().transaction().getSender(),
            toAddress,
            CallFrameType.BEDROCK,
            new Bytecode(
                toAddress == null
                    ? this.transients.tx().getBesuTransaction().getData().orElse(Bytes.EMPTY)
                    : Optional.ofNullable(frame.getWorldUpdater().get(toAddress))
                        .map(AccountState::getCode)
                        .orElse(Bytes.EMPTY)),
            Wei.of(this.transients.tx().getBesuTransaction().getValue().getAsBigInteger()),
            this.transients.tx().getBesuTransaction().getGasLimit(),
            this.transients.tx().getBesuTransaction().getData().orElse(Bytes.EMPTY),
            this.transients.conflation().deploymentInfo().number(toAddress),
            toAddress.isEmpty()
                ? 0
                : this.transients.conflation().deploymentInfo().number(toAddress),
            this.transients.conflation().deploymentInfo().isDeploying(toAddress));
      }
    } else {
      // ...or CALL
      final boolean isDeployment = frame.getType() == MessageFrame.Type.CONTRACT_CREATION;
      final Address codeAddress = frame.getContractAddress();
      final CallFrameType frameType =
          frame.isStatic() ? CallFrameType.STATIC : CallFrameType.STANDARD;
      if (isDeployment) {
        this.transients.conflation().deploymentInfo().markDeploying(codeAddress);
      }
      final int codeDeploymentNumber =
          this.transients.conflation().deploymentInfo().number(codeAddress);

      final int callDataOffsetStackArgument =
          callStack.current().opCode().callHasSixArgument() ? 2 : 3;

      final long callDataOffset =
          isDeployment
              ? 0
              : Words.clampedToLong(
                  callStack.current().frame().getStackItem(callDataOffsetStackArgument));

      final long callDataSize =
          isDeployment
              ? 0
              : Words.clampedToLong(
                  callStack.current().frame().getStackItem(callDataOffsetStackArgument + 1));

      final long callDataContextNumber = this.callStack.current().contextNumber();

      this.callStack.enter(
          this.state.stamps().hub(),
          frame.getRecipientAddress(),
          frame.getContractAddress(),
          new Bytecode(frame.getCode().getBytes()),
          frameType,
          frame.getValue(),
          frame.getRemainingGas(),
          frame.getInputData(),
          callDataOffset,
          callDataSize,
          callDataContextNumber,
          this.transients.conflation().deploymentInfo().number(codeAddress),
          codeDeploymentNumber,
          isDeployment);

      this.defers.runNextContext(this, frame);

      for (Module m : this.modules) {
        m.traceContextEnter(frame);
      }
    }
  }

  private boolean requiresEvmExecution(final WorldView worldView, final Transaction tx) {
    Optional<? extends Address> receiver = tx.getTo();

    if (receiver.isPresent()) {
      Optional<Account> receiverInWorld = Optional.ofNullable(worldView.get(receiver.get()));

      return receiverInWorld.map(AccountState::hasCode).orElse(false);
    }

    return !tx.getInit().get().isEmpty();
  }

  public void traceContextReEnter(MessageFrame frame) {
    this.defers.runReEntry(this, frame);
    if (this.currentFrame().needsUnlatchingAtReEntry() != null) {
      this.unlatchStack(frame, this.currentFrame().needsUnlatchingAtReEntry());
      this.currentFrame().needsUnlatchingAtReEntry(null);
    }
  }

  @Override
  public void traceContextExit(MessageFrame frame) {
    if (frame.getDepth() > 0) {
      this.transients
          .conflation()
          .deploymentInfo()
          .unmarkDeploying(this.currentFrame().codeAddress());

      DeploymentExceptions contextExceptions =
          DeploymentExceptions.fromFrame(this.currentFrame(), frame);
      this.currentTraceSection().setContextExceptions(contextExceptions);
      if (contextExceptions.any()) {
        this.callStack.revert(this.state.stamps().hub());
      }

      this.callStack.exit();

      for (Module m : this.modules) {
        m.traceContextExit(frame);
      }
    }
  }

  @Override
  public void tracePreOpcode(final MessageFrame frame) {
    if (this.state().processingPhase == TX_SKIP) {
      return;
    }
    this.processStateExec(frame);
  }

  public void tracePostExecution(MessageFrame frame, Operation.OperationResult operationResult) {
    if (this.state.processingPhase == TX_SKIP) {
      return;
    }

    if (this.currentFrame().opCode().isCreate() && operationResult.getHaltReason() == null) {
      this.handleCreate(Words.toAddress(frame.getStackItem(0)));
    }

    this.defers.runPostExec(this, frame, operationResult);
    this.romLex.tracePostOpcode(frame);

    if (this.currentFrame().needsUnlatchingAtReEntry() == null) {
      this.unlatchStack(frame);
    }

    switch (this.opCodeData().instructionFamily()) {
      case ADD -> {
        if (this.pch.exceptions().noStackException()) {
          this.add.tracePostOpcode(frame);
        }
      }
      case MOD -> {
        if (this.pch.exceptions().noStackException()) {
          this.mod.tracePostOpcode(frame);
        }
      }
      case MUL -> {
        if (this.pch.exceptions().noStackException()) {
          this.mul.tracePostOpcode(frame);
        }
      }
      case EXT -> {
        if (this.pch.exceptions().noStackException()) {
          this.ext.tracePostOpcode(frame);
        }
      }
      case WCP -> {
        if (this.pch.exceptions().noStackException()) {
          this.wcp.tracePostOpcode(frame);
        }
      }
      case BIN -> {}
      case SHF -> {
        if (this.pch.exceptions().noStackException()) {
          this.shf.tracePostOpcode(frame);
        }
      }
      case KEC -> {}
      case CONTEXT -> {}
      case ACCOUNT -> {}
      case COPY -> {}
      case TRANSACTION -> {}
      case BATCH -> {
        if (this.currentFrame().opCode() == OpCode.BLOCKHASH) {
          this.blockhash.tracePostOpcode(frame);
        }
      }
      case STACK_RAM -> {
        if (this.pch.exceptions().noStackException()) {
          this.mxp.tracePostOpcode(frame);
        }
      }
      case STORAGE -> {}
      case JUMP -> {}
      case MACHINE_STATE -> {}
      case PUSH_POP -> {}
      case DUP -> {}
      case SWAP -> {}
      case LOG -> {}
      case CREATE -> {}
      case CALL -> {}
      case HALT -> {}
      case INVALID -> {}
      default -> {}
    }
  }

  private void handleCreate(Address target) {
    this.transients.conflation().deploymentInfo().deploy(target);
  }

  @Override
  public void traceStartBlock(final ProcessableBlockHeader processableBlockHeader) {
    this.transients.block().blockUpdate(processableBlockHeader);
    this.txStack.resetBlock();
    for (Module m : this.modules) {
      m.traceStartBlock(processableBlockHeader);
    }
  }

  @Override
  public void traceEndBlock(final BlockHeader blockHeader, final BlockBody blockBody) {
    for (Module m : this.modules) {
      m.traceEndBlock(blockHeader, blockBody);
    }
  }

  @Override
  public void traceStartConflation(long blockCount) {
    this.transients.conflation().update();
    for (Module m : this.modules) {
      m.traceStartConflation(blockCount);
    }
  }

  @Override
  public void traceEndConflation(final WorldView world) {
    this.romLex.traceEndConflation(world);

    this.defers.runPostConflation(this, world);

    for (Module m : this.modules) {
      if (!m.equals(this.romLex)) {
        m.traceEndConflation(world);
      }
    }
  }

  public long accruedRefunds() {
    return this.state.currentTxTrace().refundCounter();
  }

  // TODO: how do these implementations of remainingGas()
  //  and expectedGas() behave with respect to resuming
  //  execution after a CALL / CREATE ? One of them is
  //  necessarily false ...
  public long remainingGas() {
    return this.state().getProcessingPhase() == TX_EXEC
        ? this.currentFrame().frame().getRemainingGas()
        : 0;
  }

  public long expectedGas() {
    return this.state().getProcessingPhase() == TX_EXEC
        ? this.currentFrame().frame().getRemainingGas()
        : 0;
  }

  @Override
  public int lineCount() {
    return this.state.lineCount();
  }

  public int cumulatedTxCount() {
    return this.state.txCount();
  }

  void traceOperation(MessageFrame frame) {
    switch (this.opCodeData().instructionFamily()) {
      case ADD, MOD, SHF, BIN, WCP, EXT, BATCH, MACHINE_STATE, PUSH_POP, DUP, SWAP, INVALID -> this
          .addTraceSection(new StackOnlySection(this));
      case MUL -> {
        if (this.opCode() == OpCode.EXP) {
          this.addTraceSection(
              new ExpSection(this, ImcFragment.forOpcode(this, this.messageFrame())));
        } else {
          this.addTraceSection(new StackOnlySection(this));
        }
      }
      case HALT -> {
        final CallFrame parentFrame = this.callStack.parent();

        switch (this.opCode()) {
          case RETURN -> {
            Bytes returnData = Bytes.EMPTY;
            // Trying to read memory with absurd arguments will throw an exception
            if (pch.exceptions().none()) {
              returnData = this.transients.op().returnData();
            }
            this.currentFrame().returnDataSource(transients.op().returnDataSegment());
            this.currentFrame().returnData(returnData);
            if (!this.pch.exceptions().any() && !this.currentFrame().underDeployment()) {
              parentFrame.latestReturnData(returnData);
            } else {
              parentFrame.latestReturnData(Bytes.EMPTY);
            }
            final ImcFragment imcFragment = ImcFragment.forOpcode(this, frame); // TODO finish it
          }
          case REVERT -> {
            final Bytes returnData = this.transients.op().returnData();
            this.currentFrame().returnDataSource(transients.op().returnDataSegment());
            this.currentFrame().returnData(returnData);
            if (!this.pch.exceptions().any()) {
              parentFrame.latestReturnData(returnData);
            } else {
              parentFrame.latestReturnData(Bytes.EMPTY);
            }
            final ImcFragment imcFragment = ImcFragment.forOpcode(this, frame); // TODO finish it
          }
          case STOP, SELFDESTRUCT -> parentFrame.latestReturnData(Bytes.EMPTY);
        }

        this.addTraceSection(new StackOnlySection(this));
      }
      case KEC -> this.addTraceSection(
          new KeccakSection(
              this, this.currentFrame(), ImcFragment.forOpcode(this, this.messageFrame())));
      case CONTEXT -> this.addTraceSection(
          new ContextLogSection(this, ContextFragment.readContextData(callStack)));
      case LOG -> {
        this.addTraceSection(
            new ContextLogSection(this, ContextFragment.readContextData(callStack)));
        LogInvocation.forOpcode(this);
      }
      case ACCOUNT -> {
        TraceSection accountSection = new AccountSection(this);
        if (this.opCodeData().stackSettings().flag1()) {
          accountSection.addFragment(
              this, this.currentFrame(), ContextFragment.readContextData(callStack));
        }

        final Bytes rawTargetAddress =
            switch (this.currentFrame().opCode()) {
              case BALANCE, EXTCODESIZE, EXTCODEHASH -> frame.getStackItem(0);
              default -> this.currentFrame().address();
            };
        final Address targetAddress = Words.toAddress(rawTargetAddress);
        final Account targetAccount = frame.getWorldUpdater().get(targetAddress);
        final AccountSnapshot accountSnapshot =
            AccountSnapshot.fromAccount(
                targetAccount,
                frame.isAddressWarm(targetAddress),
                this.transients.conflation().deploymentInfo().number(targetAddress),
                this.transients.conflation().deploymentInfo().isDeploying(targetAddress));
        accountSection.addFragment(
            this,
            this.currentFrame(),
            this.factories
                .accountFragment()
                .makeWithTrm(accountSnapshot, accountSnapshot, rawTargetAddress));

        this.addTraceSection(accountSection);
      }
      case COPY -> {
        TraceSection copySection = new CopySection(this);
        if (this.opCodeData().stackSettings().flag1()) {

          final Bytes rawTargetAddress =
              switch (this.currentFrame().opCode()) {
                case CODECOPY -> this.currentFrame().codeAddress();
                case EXTCODECOPY -> frame.getStackItem(0);
                default -> throw new IllegalStateException("unexpected opcode");
              };
          final Address targetAddress = Words.toAddress(rawTargetAddress);
          final Account targetAccount = frame.getWorldUpdater().get(targetAddress);
          AccountSnapshot accountSnapshot =
              AccountSnapshot.fromAccount(
                  targetAccount,
                  frame.isAddressWarm(targetAddress),
                  this.transients.conflation().deploymentInfo().number(targetAddress),
                  this.transients.conflation().deploymentInfo().isDeploying(targetAddress));

          copySection.addFragment(
              this,
              this.currentFrame(),
              this.currentFrame().opCode() == OpCode.EXTCODECOPY
                  ? this.factories
                      .accountFragment()
                      .makeWithTrm(accountSnapshot, accountSnapshot, rawTargetAddress)
                  : this.factories.accountFragment().make(accountSnapshot, accountSnapshot));
        } else {
          copySection.addFragment(
              this, this.currentFrame(), ContextFragment.readContextData(callStack));
        }
        this.addTraceSection(copySection);
      }
      case TRANSACTION -> this.addTraceSection(
          new TransactionSection(this, TransactionFragment.prepare(this.txStack.current())));
      case STACK_RAM -> {
        switch (this.currentFrame().opCode()) {
          case CALLDATALOAD -> {
            final ImcFragment imcFragment = ImcFragment.forOpcode(this, frame);

            this.addTraceSection(
                new StackRam(this, imcFragment, ContextFragment.readContextData(callStack)));
          }
          case MLOAD, MSTORE, MSTORE8 -> this.addTraceSection(
              new StackRam(this, ImcFragment.forOpcode(this, frame)));
          default -> throw new IllegalStateException("unexpected STACK_RAM opcode");
        }
      }
      case STORAGE -> {
        Address address = this.currentFrame().address();
        EWord key = EWord.of(frame.getStackItem(0));
        switch (this.currentFrame().opCode()) {
          case SSTORE -> {
            EWord valNext = EWord.of(frame.getStackItem(0));
            this.addTraceSection(
                new StorageSection(
                    this,
                    ContextFragment.readContextData(callStack),
                    new StorageFragment(
                        address,
                        this.currentFrame().accountDeploymentNumber(),
                        key,
                        this.txStack.current().getStorage().getOriginalValueOrUpdate(address, key),
                        EWord.of(frame.getTransientStorageValue(address, key)),
                        valNext,
                        frame.isStorageWarm(address, key),
                        true)));
          }
          case SLOAD -> {
            EWord valCurrent = EWord.of(frame.getTransientStorageValue(address, key));
            this.addTraceSection(
                new StorageSection(
                    this,
                    ContextFragment.readContextData(callStack),
                    new StorageFragment(
                        address,
                        this.currentFrame().accountDeploymentNumber(),
                        key,
                        this.txStack.current().getStorage().getOriginalValueOrUpdate(address, key),
                        valCurrent,
                        valCurrent,
                        frame.isStorageWarm(address, key),
                        true)));
          }
          default -> throw new IllegalStateException("invalid operation in family STORAGE");
        }
      }
      case CREATE -> {
        Address myAddress = this.currentFrame().address();
        Account myAccount = frame.getWorldUpdater().get(myAddress);
        AccountSnapshot myAccountSnapshot =
            AccountSnapshot.fromAccount(
                myAccount,
                frame.isAddressWarm(myAddress),
                this.transients.conflation().deploymentInfo().number(myAddress),
                this.transients.conflation().deploymentInfo().isDeploying(myAddress));

        Address createdAddress = this.currentFrame().address();
        Account createdAccount = frame.getWorldUpdater().get(createdAddress);
        AccountSnapshot createdAccountSnapshot =
            AccountSnapshot.fromAccount(
                createdAccount,
                frame.isAddressWarm(createdAddress),
                this.transients.conflation().deploymentInfo().number(createdAddress),
                this.transients.conflation().deploymentInfo().isDeploying(createdAddress));

        CreateSection createSection =
            new CreateSection(this, myAccountSnapshot, createdAccountSnapshot);
        this.addTraceSection(createSection);
        this.currentFrame().needsUnlatchingAtReEntry(createSection);
      }

      case CALL -> {
        final Address myAddress = this.currentFrame().address();
        final Account myAccount = frame.getWorldUpdater().get(myAddress);
        final AccountSnapshot myAccountSnapshot =
            AccountSnapshot.fromAccount(
                myAccount,
                frame.isAddressWarm(myAddress),
                this.transients.conflation().deploymentInfo().number(myAddress),
                this.transients.conflation().deploymentInfo().isDeploying(myAddress));

        final Bytes rawCalledAddress = frame.getStackItem(1);
        final Address calledAddress = Words.toAddress(rawCalledAddress);
        final Optional<Account> calledAccount =
            Optional.ofNullable(frame.getWorldUpdater().get(calledAddress));
        final boolean hasCode = calledAccount.map(AccountState::hasCode).orElse(false);

        final AccountSnapshot calledAccountSnapshot =
            AccountSnapshot.fromAccount(
                calledAccount,
                frame.isAddressWarm(myAddress),
                this.transients.conflation().deploymentInfo().number(myAddress),
                this.transients.conflation().deploymentInfo().isDeploying(myAddress));

        Optional<Precompile> targetPrecompile = Precompile.maybeOf(calledAddress);

        if (this.pch().exceptions().any()) {
          //
          // THERE IS AN EXCEPTION
          //
          if (this.pch().exceptions().staticFault()) {
            this.addTraceSection(
                new FailedCallSection(
                    this,
                    ScenarioFragment.forCall(this, hasCode),
                    ImcFragment.forCall(this, myAccount, calledAccount),
                    ContextFragment.readContextData(callStack)));
          } else if (this.pch().exceptions().outOfMemoryExpansion()) {
            this.addTraceSection(
                new FailedCallSection(
                    this,
                    ScenarioFragment.forCall(this, hasCode),
                    ImcFragment.forCall(this, myAccount, calledAccount)));
          } else if (this.pch().exceptions().outOfGas()) {
            this.addTraceSection(
                new FailedCallSection(
                    this,
                    ScenarioFragment.forCall(this, hasCode),
                    ImcFragment.forCall(this, myAccount, calledAccount),
                    this.factories
                        .accountFragment()
                        .makeWithTrm(
                            calledAccountSnapshot, calledAccountSnapshot, rawCalledAddress)));
          }
        } else if (this.pch.abortingConditions().any()) {
          //
          // THERE IS AN ABORT
          //
          TraceSection abortedSection =
              new FailedCallSection(
                  this,
                  ScenarioFragment.forCall(this, hasCode),
                  ImcFragment.forCall(this, myAccount, calledAccount),
                  ContextFragment.readContextData(callStack),
                  this.factories.accountFragment().make(myAccountSnapshot, myAccountSnapshot),
                  this.factories
                      .accountFragment()
                      .makeWithTrm(calledAccountSnapshot, calledAccountSnapshot, rawCalledAddress),
                  ContextFragment.nonExecutionEmptyReturnData(callStack));
          this.addTraceSection(abortedSection);
        } else {
          final ImcFragment imcFragment = ImcFragment.forOpcode(this, frame);

          if (hasCode) {
            final SmartContractCallSection section =
                new SmartContractCallSection(
                    this, myAccountSnapshot, calledAccountSnapshot, rawCalledAddress, imcFragment);
            this.addTraceSection(section);
            this.currentFrame().needsUnlatchingAtReEntry(section);
          } else {
            //
            // CALL EXECUTED
            //

            // TODO: fill the callee & requested return data for the current call frame
            // TODO: i.e. ensure that the precompile frame behaves as expected

            Optional<PrecompileInvocation> precompileInvocation =
                targetPrecompile.map(p -> PrecompileInvocation.of(this, p));

            // TODO: this is ugly, and surely not at the right place. It should provide the
            // precompile result (from the precompile module)
            // TODO useless (and potentially dangerous) if the precompile is a failure
            if (targetPrecompile.isPresent()) {
              this.callStack.newPrecompileResult(
                  this.stamp(), Bytes.EMPTY, 0, targetPrecompile.get().address);
            }

            final NoCodeCallSection section =
                new NoCodeCallSection(
                    this,
                    precompileInvocation,
                    myAccountSnapshot,
                    calledAccountSnapshot,
                    rawCalledAddress,
                    imcFragment);
            this.addTraceSection(section);
            this.currentFrame().needsUnlatchingAtReEntry(section);
          }
        }
      }

      case JUMP -> {
        AccountSnapshot codeAccountSnapshot =
            AccountSnapshot.fromAccount(
                frame.getWorldUpdater().get(this.currentFrame().codeAddress()),
                true,
                this.transients
                    .conflation()
                    .deploymentInfo()
                    .number(this.currentFrame().codeAddress()),
                this.currentFrame().underDeployment());

        JumpSection jumpSection =
            new JumpSection(
                this,
                ContextFragment.readContextData(callStack),
                this.factories.accountFragment().make(codeAccountSnapshot, codeAccountSnapshot),
                ImcFragment.forOpcode(this, frame));

        this.addTraceSection(jumpSection);
      }
    }

    // In all cases, add a context fragment if an exception occurred
    if (this.pch().exceptions().any()) {
      this.currentTraceSection()
          .addFragment(
              this, this.currentFrame(), ContextFragment.executionEmptyReturnData(callStack));
    }
  }
}
