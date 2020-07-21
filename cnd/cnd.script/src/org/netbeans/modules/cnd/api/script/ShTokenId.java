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

package org.netbeans.modules.cnd.api.script;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;
import org.netbeans.modules.cnd.script.lexer.ShLanguageHierarchy;


/**
 *
 */
public enum ShTokenId implements TokenId {

    KEYWORD ("keyword"), // NOI18N
    COMMAND ("command"), // NOI18N
    OPERATOR ("operator"), // NOI18N
    LABEL ("label"), // NOI18N
    WHITESPACE ("whitespace"), // NOI18N
    NUMBER ("number"), // NOI18N
    STRING ("string"), // NOI18N
    IDENTIFIER ("identifier"), // NOI18N
    COMMENT ("comment"), // NOI18N
    ERROR ("error"); // NOI18N

    private String  name;
    
    ShTokenId (
        String  name
    ) {
        this.name = name;
    }

    public String primaryCategory () {
        return name;
    }

    private static final Language<ShTokenId> LANGUAGE =
            new ShLanguageHierarchy().language();

    public static Language<ShTokenId> language() {
        return LANGUAGE;
    }
}