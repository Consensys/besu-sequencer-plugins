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

package net.consensys.linea.zktracer.module.txn_data;

import lombok.Builder;

@Builder
public record RlptxrcptOutgoing(short phase, int outgoing) {

  public static RlptxrcptOutgoing set(final short phase, final int value) {
    return RlptxrcptOutgoing.builder().phase(phase).outgoing(value).build();
  }

  public static RlptxrcptOutgoing emptyValue() {
    return RlptxrcptOutgoing.builder().phase((short) 0).outgoing(0).build();
  }
}
