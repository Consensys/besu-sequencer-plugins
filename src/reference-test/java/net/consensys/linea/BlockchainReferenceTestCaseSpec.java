package net.consensys.linea;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.consensys.linea.services.kvstore.InMemoryKeyValueStorageProvider;
import org.apache.tuweni.bytes.Bytes;
import org.hyperledger.besu.datatypes.Address;
import org.hyperledger.besu.datatypes.DataGas;
import org.hyperledger.besu.datatypes.Hash;
import org.hyperledger.besu.datatypes.Wei;
import org.hyperledger.besu.ethereum.ProtocolContext;
import org.hyperledger.besu.ethereum.chain.MutableBlockchain;
import org.hyperledger.besu.ethereum.core.Block;
import org.hyperledger.besu.ethereum.core.BlockBody;
import org.hyperledger.besu.ethereum.core.BlockHeader;
import org.hyperledger.besu.ethereum.core.BlockHeaderFunctions;
import org.hyperledger.besu.ethereum.core.Deposit;
import org.hyperledger.besu.ethereum.core.Difficulty;
import org.hyperledger.besu.ethereum.core.MutableWorldState;
import org.hyperledger.besu.ethereum.core.ParsedExtraData;
import org.hyperledger.besu.ethereum.core.Transaction;
import org.hyperledger.besu.ethereum.core.Withdrawal;
import org.hyperledger.besu.ethereum.mainnet.MainnetBlockHeaderFunctions;
import org.hyperledger.besu.ethereum.rlp.BytesValueRLPInput;
import org.hyperledger.besu.ethereum.rlp.RLPInput;
import org.hyperledger.besu.ethereum.worldstate.WorldStateArchive;
import org.hyperledger.besu.evm.log.LogsBloomFilter;
import org.hyperledger.besu.evm.worldstate.WorldUpdater;

import java.util.Map;
import java.util.Optional;

import static org.hyperledger.besu.datatypes.Hash.fromHexString;
import static org.hyperledger.besu.ethereum.core.BlockBody.empty;
import static org.hyperledger.besu.ethereum.core.BlockHeader.readFrom;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockchainReferenceTestCaseSpec {
  private final String network;

  private final org.hyperledger.besu.ethereum.referencetests.BlockchainReferenceTestCaseSpec.CandidateBlock[] candidateBlocks;

  private final org.hyperledger.besu.ethereum.referencetests.BlockchainReferenceTestCaseSpec.ReferenceTestBlockHeader genesisBlockHeader;

  private final Hash lastBlockHash;

  private final WorldStateArchive worldStateArchive;

  private final MutableBlockchain blockchain;
  private final String sealEngine;

  private final ProtocolContext protocolContext;

  private static WorldStateArchive buildWorldStateArchive(
      final Map<String, ReferenceTestWorldState.AccountMock> accounts) {
    final WorldStateArchive worldStateArchive = InMemoryKeyValueStorageProvider.createInMemoryWorldStateArchive();

    final MutableWorldState worldState = worldStateArchive.getMutable();
    final WorldUpdater updater = worldState.updater();

    for (final Map.Entry<String, ReferenceTestWorldState.AccountMock> entry : accounts.entrySet()) {
      ReferenceTestWorldState.insertAccount(
          updater, Address.fromHexString(entry.getKey()), entry.getValue());
    }

    updater.commit();
    worldState.persist(null);

    return worldStateArchive;
  }

  private static MutableBlockchain buildBlockchain(final BlockHeader genesisBlockHeader) {
    final Block genesisBlock = new Block(genesisBlockHeader, empty());
    return InMemoryKeyValueStorageProvider.createInMemoryBlockchain(genesisBlock);
  }

  @JsonCreator
  public BlockchainReferenceTestCaseSpec(
      @JsonProperty("network") final String network,
      @JsonProperty("blocks") final org.hyperledger.besu.ethereum.referencetests.BlockchainReferenceTestCaseSpec.CandidateBlock[] candidateBlocks,
      @JsonProperty("genesisBlockHeader") final org.hyperledger.besu.ethereum.referencetests.BlockchainReferenceTestCaseSpec.ReferenceTestBlockHeader genesisBlockHeader,
      @SuppressWarnings("unused") @JsonProperty("genesisRLP") final String genesisRLP,
      @JsonProperty("pre") final Map<String, ReferenceTestWorldState.AccountMock> accounts,
      @JsonProperty("lastblockhash") final String lastBlockHash,
      @JsonProperty("sealEngine") final String sealEngine) {
    this.network = network;
    this.candidateBlocks = candidateBlocks;
    this.genesisBlockHeader = genesisBlockHeader;
    this.lastBlockHash = fromHexString(lastBlockHash);
    this.worldStateArchive = buildWorldStateArchive(accounts);
    this.blockchain = buildBlockchain(genesisBlockHeader);
    this.sealEngine = sealEngine;
    this.protocolContext = new ProtocolContext(this.blockchain, this.worldStateArchive, null);
  }

  public String getNetwork() {
    return network;
  }

  public org.hyperledger.besu.ethereum.referencetests.BlockchainReferenceTestCaseSpec.CandidateBlock[] getCandidateBlocks() {
    return candidateBlocks;
  }

  public WorldStateArchive getWorldStateArchive() {
    return worldStateArchive;
  }

  public BlockHeader getGenesisBlockHeader() {
    return genesisBlockHeader;
  }

  public MutableBlockchain getBlockchain() {
    return blockchain;
  }

  public ProtocolContext getProtocolContext() {
    return protocolContext;
  }

  public Hash getLastBlockHash() {
    return lastBlockHash;
  }

  public String getSealEngine() {
    return sealEngine;
  }

  public static class ReferenceTestBlockHeader extends BlockHeader {

    @JsonCreator
    public ReferenceTestBlockHeader(
        @JsonProperty("parentHash") final String parentHash,
        @JsonProperty("uncleHash") final String uncleHash,
        @JsonProperty("coinbase") final String coinbase,
        @JsonProperty("stateRoot") final String stateRoot,
        @JsonProperty("transactionsTrie") final String transactionsTrie,
        @JsonProperty("receiptTrie") final String receiptTrie,
        @JsonProperty("bloom") final String bloom,
        @JsonProperty("difficulty") final String difficulty,
        @JsonProperty("number") final String number,
        @JsonProperty("gasLimit") final String gasLimit,
        @JsonProperty("gasUsed") final String gasUsed,
        @JsonProperty("timestamp") final String timestamp,
        @JsonProperty("extraData") final String extraData,
        @JsonProperty("baseFeePerGas") final String baseFee,
        @JsonProperty("mixHash") final String mixHash,
        @JsonProperty("nonce") final String nonce,
        @JsonProperty("withdrawalsRoot") final String withdrawalsRoot,
        @JsonProperty("depositsRoot") final String depositsRoot,
        @JsonProperty("excessDataGas") final String excessDataGas,
        @JsonProperty("hash") final String hash) {
      super(
          fromHexString(parentHash), // parentHash
          uncleHash == null ? Hash.EMPTY_LIST_HASH : fromHexString(uncleHash), // ommersHash
          Address.fromHexString(coinbase), // coinbase
          fromHexString(stateRoot), // stateRoot
          transactionsTrie == null
              ? Hash.EMPTY_TRIE_HASH
              : fromHexString(transactionsTrie), // transactionsRoot
          receiptTrie == null
              ? Hash.EMPTY_TRIE_HASH
              : fromHexString(receiptTrie), // receiptTrie
          LogsBloomFilter.fromHexString(bloom), // bloom
          Difficulty.fromHexString(difficulty), // difficulty
          Long.decode(number), // number
          Long.decode(gasLimit), // gasLimit
          Long.decode(gasUsed), // gasUsed
          Long.decode(timestamp), // timestamp
          Bytes.fromHexString(extraData), // extraData
          baseFee != null ? Wei.fromHexString(baseFee) : null, // baseFee
          fromHexString(mixHash), // mixHash
          Bytes.fromHexStringLenient(nonce).toLong(),
          withdrawalsRoot != null ? fromHexString(withdrawalsRoot) : null,
          excessDataGas != null ? DataGas.fromHexString(excessDataGas) : null,
          depositsRoot != null ? fromHexString(depositsRoot) : null,
          new BlockHeaderFunctions() {
            @Override
            public Hash hash(final BlockHeader header) {
              return hash == null ? null : fromHexString(hash);
            }

            @Override
            public ParsedExtraData parseExtraData(final BlockHeader header) {
              return null;
            }
          });
    }
  }

  @JsonIgnoreProperties({
      "expectExceptionByzantium",
      "expectExceptionConstantinople",
      "expectExceptionConstantinopleFix",
      "expectExceptionIstanbul",
      "expectExceptionEIP150",
      "expectExceptionEIP158",
      "expectExceptionFrontier",
      "expectExceptionHomestead",
      "expectException",
      "blocknumber",
      "chainname",
      "expectExceptionALL",
      "chainnetwork",
      "transactionSequence"
  })
  public static class CandidateBlock {

    private final Bytes rlp;

    private final Boolean valid;

    @JsonCreator
    public CandidateBlock(
        @JsonProperty("rlp") final String rlp,
        @JsonProperty("blockHeader") final Object blockHeader,
        @JsonProperty("transactions") final Object transactions,
        @JsonProperty("uncleHeaders") final Object uncleHeaders,
        @JsonProperty("withdrawals") final Object withdrawals) {
      boolean blockVaid = true;
      // The BLOCK__WrongCharAtRLP_0 test has an invalid character in its rlp string.
      Bytes rlpAttempt = null;
      try {
        rlpAttempt = Bytes.fromHexString(rlp);
      } catch (final IllegalArgumentException e) {
        blockVaid = false;
      }
      this.rlp = rlpAttempt;

      if (blockHeader == null
          && transactions == null
          && uncleHeaders == null
          && withdrawals == null) {
        blockVaid = false;
      }

      this.valid = blockVaid;
    }

    public boolean isValid() {
      return valid;
    }

    public boolean isExecutable() {
      return rlp != null;
    }

    public Block getBlock() {
      final RLPInput input = new BytesValueRLPInput(rlp, false);
      input.enterList();
      final MainnetBlockHeaderFunctions blockHeaderFunctions = new MainnetBlockHeaderFunctions();
      final BlockHeader header = readFrom(input, blockHeaderFunctions);
      final BlockBody body =
          new BlockBody(
              input.readList(Transaction::readFrom),
              input.readList(inputData -> readFrom(inputData, blockHeaderFunctions)),
              input.isEndOfCurrentList()
                  ? Optional.empty()
                  : Optional.of(input.readList(Withdrawal::readFrom)),
              input.isEndOfCurrentList()
                  ? Optional.empty()
                  : Optional.of(input.readList(Deposit::readFrom)));
      return new Block(header, body);
    }
  }
}
