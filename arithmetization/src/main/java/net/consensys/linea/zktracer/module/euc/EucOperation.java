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

package net.consensys.linea.zktracer.module.euc;

import static net.consensys.linea.zktracer.types.Utils.leftPadTo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.Accessors;
import net.consensys.linea.zktracer.container.ModuleOperation;
import net.consensys.linea.zktracer.types.UnsignedByte;
import org.apache.tuweni.bytes.Bytes;

@Accessors(fluent = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class EucOperation extends ModuleOperation {
  @Getter @EqualsAndHashCode.Include private final Bytes dividend;
  @Getter @EqualsAndHashCode.Include private final Bytes divisor;
  @Getter private final Bytes remainder;
  @Getter private final Bytes quotient;
  private final int ctMax;

  public EucOperation(
      final Bytes dividend, final Bytes divisor, final Bytes quotient, final Bytes remainder) {
    if (divisor.isZero()) {
      throw new IllegalArgumentException("EUC module doesn't accept 0 for divisor");
    }
    final Bytes dividendTrim = dividend.trimLeadingZeros();
    final Bytes divisorTrim = divisor.trimLeadingZeros();
    this.ctMax = Math.max(dividendTrim.size(), divisorTrim.size()) - 1;
    if (ctMax >= 8) {
      throw new IllegalStateException("Max ByteSize of input is 8 for EUC, received" + ctMax + 1);
    }
    this.dividend = dividendTrim;
    this.divisor = divisorTrim;
    this.quotient = quotient;
    this.remainder = remainder;
  }

  public Bytes ceiling() {
    return !remainder.isZero() && !dividend.isZero()
        ? Bytes.ofUnsignedLong(quotient.toInt() + 1)
        : quotient;
  }

  void trace(Trace trace) {
    final Bytes dividend = leftPadTo(this.dividend, this.ctMax + 1);
    final Bytes divisor = leftPadTo(this.divisor, this.ctMax + 1);
    final Bytes quotient = leftPadTo(this.quotient, this.ctMax + 1);
    final Bytes remainder = leftPadTo(this.remainder, this.ctMax + 1);
    final Bytes ceil = this.ceiling();

    for (int ct = 0; ct <= ctMax; ct++) {
      trace
          .iomf(true)
          .ct((short) ct)
          .ctMax((short) ctMax)
          .done(ct == ctMax)
          .dividend(dividend)
          .divisor(divisor)
          .quotient(quotient)
          .remainder(remainder)
          .ceil(ceil)
          .divisorByte(UnsignedByte.of(divisor.get(ct)))
          .quotientByte(UnsignedByte.of(quotient.get(ct)))
          .remainderByte(UnsignedByte.of(remainder.get(ct)))
          .validateRow();
    }
  }

  @Override
  protected int computeLineCount() {
    return this.ctMax + 1;
  }
}
