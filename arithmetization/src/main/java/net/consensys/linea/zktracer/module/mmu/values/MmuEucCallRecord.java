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

package net.consensys.linea.zktracer.module.mmu.values;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.Accessors;

@Builder
@Getter
@Accessors(fluent = true)
public class MmuEucCallRecord {
  public static final MmuEucCallRecord EMPTY_CALL = builder().build();

  @Builder.Default boolean flag = true;
  long dividend;
  long divisor;
  long quotient;
  long remainder;

  public long ceiling() {
    return this.flag && this.remainder != 0 && this.dividend != 0
        ? this.quotient + 1
        : this.quotient;
  }
}
