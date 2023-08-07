package net.consensys.linea.zktracer.opcode;

public class Gas {
  public static final int gZero = 0;
  public static final int gJumpDest = 0;
  public static final int gBase = 2;
  public static final int gVeryLow = 3;
  public static final int gLow = 5;
  public static final int gMid = 8;
  public static final int gHigh = 10;
  public static final int gWarmAccess = 100;
  public static final int gAccessListAddress = 2400;
  public static final int gAccessListStorage = 1900;
  public static final int gColdAccountAccess = 2600;
  public static final int gColdSLoad = 2100;
  public static final int gSSet = 20000;
  public static final int gSReset = 2900;
  public static final int rSClear = 15000;
  public static final int rSelfDestruct = 24000;
  public static final int gSelfDestruct = 5000;
  public static final int gCreate = 32000;
  public static final int gCodeDeposit = 200;
  public static final int gCallValue = 9000;
  public static final int gCallStipend = 2300;
  public static final int gNewAccount = 25000;
  public static final int gExp = 10;
  public static final int gExpByte = 50;
  public static final int gMemory = 3;
  public static final int gTxCreate = 32000;
  public static final int gTxDataZero = 4;
  public static final int gTxDataNonZero = 16;
  public static final int gTransaction = 21000;
  public static final int gLog = 375;
  public static final int gLogData = 8;
  public static final int gLogTopic = 375;
  public static final int gKeccak256 = 30;
  public static final int gKeccak256Word = 6;
  public static final int gCopy = 3;
  public static final int gBlockHash = 20;
  // below are markers for gas that is computed in other modules
  // that is: hub, memory expansion, stipend, precompile info
  public static final int sMxp = 0;
  public static final int sHub = 0;
  public static final int sStp = 0;
  public static final int sPrecInfo = 0;
}
