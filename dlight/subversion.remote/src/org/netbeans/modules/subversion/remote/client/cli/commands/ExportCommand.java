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
import org.netbeans.modules.subversion.remote.api.SVNRevision;
import org.netbeans.modules.subversion.remote.api.SVNUrl;
import org.netbeans.modules.subversion.remote.client.cli.SvnCommand;
import org.netbeans.modules.versioning.core.api.VCSFileProxy;
import org.openide.filesystems.FileSystem;

/**
 *
 * 
 */
public class ExportCommand extends SvnCommand {

    private final SVNUrl url;
    private final VCSFileProxy file;
    private final SVNRevision revision;
    private final boolean force;
    private final VCSFileProxy destination;


    public ExportCommand(FileSystem fileSystem, SVNUrl url, VCSFileProxy destination, SVNRevision revision, boolean force) {
        super(fileSystem);
        this.url = url;
        this.destination = destination;
        this.revision = revision;
        this.force = force;

        this.file = null;
    }

    public ExportCommand(FileSystem fileSystem, VCSFileProxy file, VCSFileProxy destination, boolean force) {
        super(fileSystem);
        this.file = file;
        this.destination = destination;
        this.force = force;

        this.revision = null;
        this.url = null;
    }

    @Override
    protected ISVNNotifyListener.Command getCommand() {
        return ISVNNotifyListener.Command.CHECKOUT;
    }

    @Override
    public void prepareCommand(Arguments arguments) throws IOException {
        arguments.add("export"); // NOI18N
        if(revision != null) {
            arguments.add(revision);
        }
        if(url != null) {
            arguments.add(url);
            arguments.add(destination);
        } else {
            arguments.add(file);
            arguments.add(destination);
        }
        if (force) {
            arguments.add("--force"); // NOI18N
        }
        setCommandWorkingDirectory(destination);
    }
    
}