/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.eclipse.ui.internal.zookeeper;

import org.apache.hadoop.eclipse.internal.zookeeper.ZooKeeperManager;
import org.apache.hadoop.eclipse.ui.Activator;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class NewZooKeeperWizard extends Wizard implements INewWizard {

	//private static Logger logger = Logger.getLogger(NewZooKeeperWizard.class);
	private NewZooKeeperServerWizardPage serverLocationWizardPage = null;

	public NewZooKeeperWizard() {
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {
		super.addPages();
		if (serverLocationWizardPage == null) {
			serverLocationWizardPage = new NewZooKeeperServerWizardPage();
		}
		addPage(serverLocationWizardPage);
	}

	@Override
	public boolean performFinish() {
		if (serverLocationWizardPage != null) {
			String ambariUrl = serverLocationWizardPage.getZkServerLocation();
			if (ambariUrl != null) {
				IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
				String currentUrls = ps.getString(Activator.PREFERENCE_ZOOKEEPER_URLS);
				if (currentUrls.indexOf(ambariUrl + "\r\n") < 0) {
					currentUrls = ambariUrl + "\r\n" + currentUrls;
					ps.setValue(Activator.PREFERENCE_ZOOKEEPER_URLS, currentUrls);
				}

				Job j = new Job("Creating ZooKeeper project [" + serverLocationWizardPage.getZkServerName() + "]") {
					protected org.eclipse.core.runtime.IStatus run(org.eclipse.core.runtime.IProgressMonitor monitor) {
						ZooKeeperManager.INSTANCE.createServer(serverLocationWizardPage.getZkServerName(), serverLocationWizardPage.getZkServerLocation());
						return Status.OK_STATUS;
					};
				};
				j.schedule();
				return true;
			}
		}
		return false;
	}

}
