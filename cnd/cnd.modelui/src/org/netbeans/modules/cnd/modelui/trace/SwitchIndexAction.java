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

package org.netbeans.modules.cnd.modelui.trace;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import org.openide.nodes.Node;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;
import org.openide.util.actions.NodeAction;
/**
 *
 */
public final class SwitchIndexAction extends NodeAction {
    public static final String CND_MODEL_INDEX_ENABLED_PROPERTY = "cnd.model.index.enabled"; // NOI18N
    
    private JCheckBoxMenuItem presenter;
    
    public SwitchIndexAction() {
        presenter = new JCheckBoxMenuItem(getName());
        presenter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onActionPerformed();
            }
        });
    }
    
    @Override
    public String getName() {
	return NbBundle.getMessage(getClass(), ("CTL_SwitchIndexAction")); // NOI18N
    }
    
    @Override
    public HelpCtx getHelpCtx() {
	return HelpCtx.DEFAULT_HELP;
    }
    
    @Override
    public JMenuItem getMenuPresenter() {
        return getPresenter();
    }    
    
    @Override
    public JMenuItem getPopupPresenter() {
        return getPresenter();
    }
    
    private JMenuItem getPresenter() {
        presenter.setEnabled(true);
        presenter.setSelected(Boolean.getBoolean(CND_MODEL_INDEX_ENABLED_PROPERTY));
        presenter.setVisible(TestProjectActionBase.TEST_XREF);
        return presenter;
    }
    
    @Override
    protected boolean enable(Node[] activatedNodes)  {
        return true;
    }

    private void onActionPerformed() {
        performAction(getActivatedNodes());
    }
    
    /** Actually nobody but us call this since we have a presenter. */
    @Override
    public void performAction(final Node[] activatedNodes) {
        if (Boolean.getBoolean(CND_MODEL_INDEX_ENABLED_PROPERTY)) {
            System.err.println("SWITCH INDEX OFF"); // NOI18N
            System.setProperty(CND_MODEL_INDEX_ENABLED_PROPERTY, "false"); // NOI18N
        } else {
            System.err.println("SWITCH INDEX ON");
            System.setProperty(CND_MODEL_INDEX_ENABLED_PROPERTY, "true"); // NOI18N
        }
    }
    
    @Override
    protected boolean asynchronous () {
        return false;
    }
}