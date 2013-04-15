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
package org.apache.hadoop.eclipse.ui.internal;

import java.net.URI;

import org.apache.hadoop.eclipse.internal.hdfs.HDFSFileStore;
import org.apache.hadoop.eclipse.internal.hdfs.HDFSManager;
import org.apache.hadoop.eclipse.internal.hdfs.HDFSURI;
import org.apache.log4j.Logger;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

public class HDFSLightweightLabelDecorator implements ILightweightLabelDecorator {
	private static final Logger logger = Logger.getLogger(HDFSLightweightLabelDecorator.class);
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void addListener(ILabelProviderListener listener) {}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	@Override
	public void dispose() {}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang.Object, org.eclipse.jface.viewers.IDecoration)
	 */
	@Override
	public void decorate(Object element, IDecoration decoration) {
		if(element instanceof IResource){
			IResource r = (IResource) element;
			URI locationURI = r.getLocationURI();
			if(HDFSURI.SCHEME.equals(locationURI.getScheme())){
				try {
					HDFSFileStore store = (HDFSFileStore) EFS.getStore(locationURI);
					if(r instanceof IProject){
						decoration.addSuffix(" "+locationURI.toString());
					}
					decorate(store, decoration);
				} catch (CoreException e) {
					logger.debug(e.getMessage(), e);
				}
				
			}
		}
	}
	
	protected void decorate(HDFSFileStore store, IDecoration decoration){
		if(store!=null){
			if(HDFSManager.INSTANCE.isServerOperationRunning(store.toURI().toString())){
				decoration.addOverlay(org.apache.hadoop.eclipse.ui.Activator.IMAGE_OUTGOING_OVR);
			}else{
				if(store.isLocalFile()){
					decoration.addOverlay(org.apache.hadoop.eclipse.ui.Activator.IMAGE_LOCAL_OVR);		
				}else{
					decoration.addOverlay(org.apache.hadoop.eclipse.ui.Activator.IMAGE_REMOTE_OVR);		
				}
			}
		}
	}
	
}
