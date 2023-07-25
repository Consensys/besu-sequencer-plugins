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

package net.consensys.linea.zktracer.specs;

import net.consensys.linea.zktracer.AbstractModuleTracerBySpecTest;
import net.consensys.linea.zktracer.module.ModuleTracer;
import net.consensys.linea.zktracer.module.alu.mod.ModTracer;

/** Implementation of a module tracer by spec class for the MOD module. */
public class ModTracerBySpecTest extends AbstractModuleTracerBySpecTest {

  static ModuleTracer tracer = new ModTracer();

  public static Object[][] specs() {
    return findSpecFiles(tracer.jsonKey());
  }

  @Override
  protected ModuleTracer getModuleTracer() {
    return tracer;
  }
}
