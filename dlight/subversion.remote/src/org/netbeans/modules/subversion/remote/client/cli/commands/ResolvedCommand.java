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
package org.netbeans.modules.subversion.remote.client.cli.commands;

import java.io.IOException;
import org.netbeans.modules.subversion.remote.api.ISVNNotifyListener;
import org.netbeans.modules.subversion.remote.client.cli.SvnCommand;
import org.netbeans.modules.versioning.core.api.VCSFileProxy;
import org.openide.filesystems.FileSystem;

/**
 *
 * 
 */
public class ResolvedCommand extends SvnCommand {

    private final VCSFileProxy file;
    private final boolean recursive;

    public ResolvedCommand(FileSystem fileSystem, VCSFileProxy file, boolean recursive) {
        super(fileSystem);
        this.file = file;
        this.recursive = recursive;
    }
       
    @Override
    protected ISVNNotifyListener.Command getCommand() {
        return ISVNNotifyListener.Command.RESOLVED;
    }
    
    @Override
    protected void config(VCSFileProxy configDir, String username, String password, Arguments arguments) {
        arguments.addConfigDir(configDir);        
    }
    
    @Override
    public void prepareCommand(Arguments arguments) throws IOException {                     
        arguments.add("resolved"); //NOI18N
        if (recursive) {
            arguments.add("-R"); //NOI18N
        }
        arguments.add(file);    
        setCommandWorkingDirectory(file);        
    }
    
}