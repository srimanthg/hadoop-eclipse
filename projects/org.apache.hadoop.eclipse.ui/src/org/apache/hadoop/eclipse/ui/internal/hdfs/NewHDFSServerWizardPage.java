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
import java.util.StringTokenizer;

import org.apache.hadoop.eclipse.ui.Activator;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewHDFSServerWizardPage extends WizardPage {

	private Combo serverCombo;
	private Text serverNameText;

	private String hdfsServerLocation = null;
	private String hdfsServerName = null;

	protected NewHDFSServerWizardPage() {
		super("HDFS Server Location");
		setTitle("HDFS Server Location");
		setDescription("Enter the name and location of the HDFS server");
	}

	@Override
	public void createControl(Composite parent) {
		Composite c = new Composite(parent, SWT.NONE);
		final GridLayout layout = new GridLayout(2, false);
		layout.marginLeft = 5;
		layout.marginRight = 20;
		c.setLayout(layout);

		// Add Name
		Label nameLabel = new Label(c, SWT.NONE);
		nameLabel.setText("Name:");
		serverNameText = new Text(c, SWT.BORDER | SWT.SINGLE);
		serverNameText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		serverNameText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				String nameText = serverNameText.getText();
				if (nameText != null && nameText.trim().length() > 0) {
					setHdfsServerName(nameText);
				} else {
					setHdfsServerName(null);
				}
				NewHDFSServerWizardPage.this.validate();
			}
		});

		// Add Combo
		Label comboLabel = new Label(c, SWT.NONE);
		comboLabel.setText("URL:");
		serverCombo = new Combo(c, SWT.BORDER);
		serverCombo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		serverCombo.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				String urlText = serverCombo.getText();
				if (urlText != null && urlText.trim().length() > 0) {
					try {
						new URI(urlText);
						setHdfsServerLocation(urlText);
					} catch (URISyntaxException e1) {
						setHdfsServerLocation(null);
					}
				}
				NewHDFSServerWizardPage.this.validate();
			}
		});

		// Add example
		new Label(c, SWT.NONE);
		Label exampleLabel = new Label(c, SWT.NONE);
		exampleLabel.setText("Example: hdfs://hdfs.server.hostname:8020");
		exampleLabel.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GRAY));
		
		// Populate
		String currentUrls = Activator.getDefault().getPreferenceStore().getString(Activator.PREFERENCE_HDFS_URLS);
		StringTokenizer st = new StringTokenizer(currentUrls, "\r\n", false);
		while (st.hasMoreTokens()) {
			serverCombo.add(st.nextToken());
		}
		setPageComplete(false);
		this.setControl(c);
	}

	/**
	 * 
	 */
	protected void validate() {
		setPageComplete(getHdfsServerName() != null && getHdfsServerLocation() != null);
	}

	public String getHdfsServerLocation() {
		return hdfsServerLocation;
	}

	public void setHdfsServerLocation(String ambariServerUrl) {
		this.hdfsServerLocation = ambariServerUrl;
	}

	public void setHdfsServerName(String hdfsServerName) {
		this.hdfsServerName = hdfsServerName;
	}

	public String getHdfsServerName() {
		return hdfsServerName;
	}
}
