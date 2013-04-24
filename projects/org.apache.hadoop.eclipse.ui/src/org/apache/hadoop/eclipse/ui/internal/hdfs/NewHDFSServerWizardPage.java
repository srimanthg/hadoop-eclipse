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

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.hadoop.eclipse.internal.hdfs.HDFSFileStore;
import org.apache.hadoop.eclipse.ui.Activator;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewHDFSServerWizardPage extends WizardPage {

	private static final Logger logger = Logger.getLogger(NewHDFSServerWizardPage.class);
	private Combo serverCombo;
	private Text serverNameText;

	private String hdfsServerLocation = null;
	private String hdfsServerName = null;
	private boolean overrideDefaultSecurity = false;
	private String userId = null;
	private List<String> groupIds = new ArrayList<String>();

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
		// Security
		Group securityGroup = new Group(c, SWT.SHADOW_ETCHED_IN);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		securityGroup.setLayoutData(gd);
		securityGroup.setText("Security");
		securityGroup.setLayout(new GridLayout(2, false));
		// Override security checkbox
		List<String> userAndGroupIds = getUserAndGroupIds();
		final Button overrideSecurityCheckbox = new Button(securityGroup, SWT.CHECK);
		gd = new GridData();
		gd.horizontalSpan = 2;
		overrideSecurityCheckbox.setText("Override default security");
		overrideSecurityCheckbox.setLayoutData(gd);
		overrideSecurityCheckbox.setSelection(overrideDefaultSecurity);
		// User ID
		new Label(securityGroup, SWT.NONE).setText("User ID:");
		final Text userIdText = new Text(securityGroup, SWT.BORDER | SWT.SINGLE);
		userIdText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		userIdText.setEnabled(overrideDefaultSecurity);
		userIdText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				userId = userIdText.getText();
				if(userId!=null && userId.trim().length()<1)
					userId = null;
				validate();
			}
		});
		if (userAndGroupIds != null && userAndGroupIds.size() > 0)
			userIdText.setText(userAndGroupIds.get(0));
		// Group IDs
		Label groupIdsLabel = new Label(securityGroup, SWT.NONE);
		groupIdsLabel.setText("Group IDs:");
		groupIdsLabel.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
		final org.eclipse.swt.widgets.List groupsList = new org.eclipse.swt.widgets.List(securityGroup, SWT.BORDER);
		groupsList.setLayoutData(new GridData(GridData.FILL_BOTH));
		groupsList.setEnabled(overrideDefaultSecurity);
		if (userAndGroupIds != null && userAndGroupIds.size() > 1)
			for (String groupId : userAndGroupIds.subList(1, userAndGroupIds.size()))
				groupsList.add(groupId);
		overrideSecurityCheckbox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				overrideDefaultSecurity = overrideSecurityCheckbox.getSelection();
				if (overrideDefaultSecurity) {
					userId = userIdText.getText();
					String[] gids = groupsList.getItems();
					if (gids != null) {
						for (String gid : gids) {
							groupIds.add(gid);
						}
					}
				} else {
					userId = null;
					groupIds.clear();
				}
				userIdText.setEnabled(overrideDefaultSecurity);
				//We do not support selection/add/remove of groups
				// groupsList.setEnabled(overrideDefaultSecurity);
			}
		});

		// Populate
		String currentUrls = Activator.getDefault().getPreferenceStore().getString(Activator.PREFERENCE_HDFS_URLS);
		StringTokenizer st = new StringTokenizer(currentUrls, "\r\n", false);
		while (st.hasMoreTokens()) {
			serverCombo.add(st.nextToken());
		}
		setPageComplete(false);
		this.setControl(c);
	}

	private List<String> getUserAndGroupIds() {
		try {
			return HDFSFileStore.getClient().getDefaultUserAndGroupIds();
		} catch (IOException e) {
			logger.warn(e.getMessage(), e);
		} catch (CoreException e) {
			logger.warn(e.getMessage(), e);
		}
		return null;
	}

	/**
	 * 
	 */
	protected void validate() {
		setPageComplete(getHdfsServerName() != null && getHdfsServerLocation() != null && (!overrideDefaultSecurity || userId != null));
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

	public boolean isOverrideDefaultSecurity() {
		return overrideDefaultSecurity;
	}

	public String getUserId() {
		return userId;
	}

	public List<String> getGroupIds() {
		return groupIds;
	}
}
