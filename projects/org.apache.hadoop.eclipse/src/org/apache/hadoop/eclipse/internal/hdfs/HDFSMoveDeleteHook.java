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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.team.IMoveDeleteHook;
import org.eclipse.core.resources.team.IResourceTree;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author Srimanth Gunturi
 * 
 */
public class HDFSMoveDeleteHook implements IMoveDeleteHook {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.team.IMoveDeleteHook#deleteFile(org.eclipse
	 * .core.resources.team.IResourceTree, org.eclipse.core.resources.IFile,
	 * int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean deleteFile(IResourceTree tree, IFile file, int updateFlags, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.team.IMoveDeleteHook#deleteFolder(org.eclipse
	 * .core.resources.team.IResourceTree, org.eclipse.core.resources.IFolder,
	 * int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean deleteFolder(IResourceTree tree, IFolder folder, int updateFlags, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.team.IMoveDeleteHook#deleteProject(org.eclipse
	 * .core.resources.team.IResourceTree, org.eclipse.core.resources.IProject,
	 * int, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean deleteProject(IResourceTree tree, IProject project, int updateFlags, IProgressMonitor monitor) {
		if (HDFSFileSystem.SCHEME.equals(project.getLocationURI().getScheme())) {
			// Deleting a HDFS project. When asking to delete project
			// with contents, we do it ourselves.
			if ((IResource.ALWAYS_DELETE_PROJECT_CONTENT & updateFlags) > 0) {
				throw new RuntimeException(
						"Deletion of HDFS project root folder is not supported. To remove project uncheck the \'Delete project contains on disk\' checkbox");
				// return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.team.IMoveDeleteHook#moveFile(org.eclipse.
	 * core.resources.team.IResourceTree, org.eclipse.core.resources.IFile,
	 * org.eclipse.core.resources.IFile, int,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean moveFile(IResourceTree tree, IFile source, IFile destination, int updateFlags, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.team.IMoveDeleteHook#moveFolder(org.eclipse
	 * .core.resources.team.IResourceTree, org.eclipse.core.resources.IFolder,
	 * org.eclipse.core.resources.IFolder, int,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean moveFolder(IResourceTree tree, IFolder source, IFolder destination, int updateFlags, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.team.IMoveDeleteHook#moveProject(org.eclipse
	 * .core.resources.team.IResourceTree, org.eclipse.core.resources.IProject,
	 * org.eclipse.core.resources.IProjectDescription, int,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean moveProject(IResourceTree tree, IProject source, IProjectDescription description, int updateFlags, IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		return false;
	}

}
