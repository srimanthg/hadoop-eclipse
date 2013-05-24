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

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * @author Srimanth Gunturi
 * 
 */
public class ZooKeeperNodeStorage implements IStorage {

	private final ZooKeeperNodeEditorInput editorInput;

	/**
	 * 
	 */
	public ZooKeeperNodeStorage(ZooKeeperNodeEditorInput editorInput) {
		this.editorInput = editorInput;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IStorage#getContents()
	 */
	@Override
	public InputStream getContents() throws CoreException {
		return new ByteArrayInputStream(editorInput.getNodeData().data);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IStorage#getFullPath()
	 */
	@Override
	public IPath getFullPath() {
		return new Path(editorInput.getNode().getPath());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IStorage#getName()
	 */
	@Override
	public String getName() {
		return editorInput.getName();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.resources.IStorage#isReadOnly()
	 */
	@Override
	public boolean isReadOnly() {
		return false;
	}

}
