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

package net.consensys.linea.sequencer;

/** The Linea configuration. */
public final class LineaConfiguration {
  private final int maxTxCallDataSize;
  private final int maxBlockCallDataSize;
  private final int maxBlockSize;

  private LineaConfiguration(
      final int maxTxCallDataSize, final int maxBlockCallDataSize, final int maxBlockSize) {
    this.maxTxCallDataSize = maxTxCallDataSize;
    this.maxBlockCallDataSize = maxBlockCallDataSize;
    this.maxBlockSize = maxBlockSize;
  }

  public int maxTxCallDataSize() {
    return maxTxCallDataSize;
  }

  public int maxBlockCallDataSize() {
    return maxBlockCallDataSize;
  }

  public int maxBlockSize() {
    return maxBlockSize;
  }

  public static class Builder {
    private int maxTxCallDataSize;
    private int maxBlockCallDataSize;

    private int maxBlockSize;

    public Builder maxTxCallDataSize(int maxTxCallDataSize) {
      this.maxTxCallDataSize = maxTxCallDataSize;
      return this;
    }

    public Builder maxBlockCallDataSize(int maxBlockCallDataSize) {
      this.maxBlockCallDataSize = maxBlockCallDataSize;
      return this;
    }

    public Builder maxBlockSize(int maxBlockSize) {
      this.maxBlockSize = maxBlockSize;
      return this;
    }

    public LineaConfiguration build() {
      return new LineaConfiguration(maxTxCallDataSize, maxBlockCallDataSize, maxBlockSize);
    }
  }
}
