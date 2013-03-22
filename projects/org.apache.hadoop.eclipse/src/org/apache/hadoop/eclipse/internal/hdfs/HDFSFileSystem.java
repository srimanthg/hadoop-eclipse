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

package org.apache.hadoop.eclipse.internal.hdfs;

import java.net.URI;

import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.filesystem.provider.FileSystem;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * 
 * @author Srimanth Gunturi
 */
public class HDFSFileSystem extends FileSystem {
	
	public static final String SCHEME = "hdfs";

	public static void loadFileSystems() throws Exception {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject[] projects = workspace.getRoot().getProjects();
		boolean anyHDFSProjects = false;
		if(projects!=null){
			for(int pc=0; pc<projects.length; pc++){
				if(projects[pc].getDescription().getLocationURI().getScheme()==SCHEME){
					anyHDFSProjects = true;
					break;
				}
			}
		}
		if(!anyHDFSProjects){
			String projectName = "HDFS";
			IProject project = workspace.getRoot().getProject(projectName);
			IProjectDescription pd = workspace.newProjectDescription(projectName);
			pd.setLocationURI(new URI("hdfs://dev.hortonworks.com:8020/"));
			project.create(pd, new NullProgressMonitor());
			project.open(new NullProgressMonitor());
		}
	}

	@Override
	public IFileStore getStore(URI uri) {
		return new HDFSFileStore(new HDFSURI(uri));
	}

}
