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
package org.apache.hadoop.eclipse.ui;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author Srimanth Gunturi
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.apache.hadoop.eclipse.ui"; //$NON-NLS-1$
	public static final String PREFERENCE_HDFS_URLS = "HDFS_SERVER_URLS";
	public static ImageDescriptor IMAGE_REMOTE_OVR;
	public static ImageDescriptor IMAGE_LOCAL_OVR;
	public static ImageDescriptor IMAGE_INCOMING_OVR;
	public static ImageDescriptor IMAGE_OUTGOING_OVR;
	public static ImageDescriptor IMAGE_SYNC_OVR;

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		loadImages();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	private void loadImages(){
		Bundle bundle = getDefault().getBundle();
		URL remoteFileUrl = FileLocator.find(bundle, new Path("/icons/ovr/remote_resource.gif"), null);
		URL localFileUrl = FileLocator.find(bundle, new Path("/icons/ovr/local_resource.gif"), null);
		URL incomingUrl = FileLocator.find(bundle, new Path("/icons/ovr/overlay-incoming.gif"), null);
		URL outgoingUrl = FileLocator.find(bundle, new Path("/icons/ovr/overlay-outgoing.gif"), null);
		URL waitingUrl = FileLocator.find(bundle, new Path("/icons/ovr/waiting_ovr.gif"), null);
		IMAGE_REMOTE_OVR = ImageDescriptor.createFromURL(remoteFileUrl);
		IMAGE_LOCAL_OVR = ImageDescriptor.createFromURL(localFileUrl);
		IMAGE_INCOMING_OVR = ImageDescriptor.createFromURL(incomingUrl);
		IMAGE_OUTGOING_OVR = ImageDescriptor.createFromURL(outgoingUrl);
		IMAGE_SYNC_OVR = ImageDescriptor.createFromURL(waitingUrl);
	}
}
