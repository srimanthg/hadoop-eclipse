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
package org.apache.hadoop.eclipse.ui.internal.hdfs;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.eclipse.internal.hdfs.HDFSManager;
import org.apache.hadoop.eclipse.ui.Activator;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class NewHDFSWizard extends Wizard implements INewWizard {

	private static Logger logger = Logger.getLogger(NewHDFSWizard.class);
	private NewHDFSServerWizardPage serverLocationWizardPage = null;

	public NewHDFSWizard() {
		// TODO Auto-generated constructor stub
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
			serverLocationWizardPage = new NewHDFSServerWizardPage();
		}
		addPage(serverLocationWizardPage);
	}

	@Override
	public boolean performFinish() {
		if (serverLocationWizardPage != null) {
			String ambariUrl = serverLocationWizardPage.getHdfsServerLocation();
			if (ambariUrl != null) {
				IPreferenceStore ps = Activator.getDefault().getPreferenceStore();
				String currentUrls = ps.getString(Activator.PREFERENCE_HDFS_URLS);
				if (currentUrls.indexOf(ambariUrl + "\r\n") < 0) {
					currentUrls = ambariUrl + "\r\n" + currentUrls;
					ps.setValue(Activator.PREFERENCE_HDFS_URLS, currentUrls);
				}

				Job j = new Job("Creating HDFS project ["+serverLocationWizardPage.getHdfsServerName()+"]"){
					protected org.eclipse.core.runtime.IStatus run(org.eclipse.core.runtime.IProgressMonitor monitor) {
						try {
							HDFSManager.INSTANCE.createServer(serverLocationWizardPage.getHdfsServerName(), new URI(serverLocationWizardPage.getHdfsServerLocation()));
						} catch (CoreException e) {
							logger.error(e.getMessage(), e);
						} catch (URISyntaxException e) {
							logger.error(e.getMessage(), e);
						}
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
