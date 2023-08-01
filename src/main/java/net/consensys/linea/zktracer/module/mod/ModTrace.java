/*
 * Copyright ConsenSys Software Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package net.consensys.linea.zktracer.module.mod;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * WARNING: This code is generated automatically. Any modifications to this code may be overwritten
 * and could lead to unexpected behavior. Please DO NOT ATTEMPT TO MODIFY this code directly.
 */
record ModTrace(@JsonProperty("Trace") Trace trace) {
  static final BigInteger DIV = new BigInteger("4");
  static final BigInteger MMEDIUM = new BigInteger("8");
  static final BigInteger MMEDIUMMO = new BigInteger("7");
  static final BigInteger MOD = new BigInteger("6");
  static final BigInteger SDIV = new BigInteger("5");
  static final BigInteger SMOD = new BigInteger("7");
  static final BigInteger THETA = new BigInteger("18446744073709551616");
  static final BigInteger THETA2 = new BigInteger("340282366920938463463374607431768211456");
  static final BigInteger THETA_SQUARED_OVER_TWO =
      new BigInteger("170141183460469231731687303715884105728");
}
