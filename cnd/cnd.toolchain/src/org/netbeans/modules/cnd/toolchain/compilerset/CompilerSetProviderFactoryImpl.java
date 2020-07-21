/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.cnd.toolchain.compilerset;

import org.netbeans.modules.cnd.spi.toolchain.CompilerSetProvider;
import org.netbeans.modules.cnd.spi.toolchain.CompilerSetProviderFactory;
import org.netbeans.modules.nativeexecution.api.ExecutionEnvironment;
import org.openide.util.Lookup;

/**
 * An factory for creation CompilerSetProvider instances
 */
public class CompilerSetProviderFactoryImpl {
    /**
     * Creates a new instance of CompilerSetProvider
     * for the given execution environment
     * @param execEnv execution environment to create CompilerSetProvider for
     * @return new CompilerSetProvider instance
     */
    public static CompilerSetProvider createNew(ExecutionEnvironment execEnv) {
        CompilerSetProviderFactory factory = Lookup.getDefault().lookup(CompilerSetProviderFactory.class);
        if (factory == null) {
            throw new IllegalStateException(CompilerSetProviderFactory.class.getName() +" not found in lookup"); //NOI18N
        }
        return factory.createNew(execEnv);
    }

    private CompilerSetProviderFactoryImpl() {
    }
}