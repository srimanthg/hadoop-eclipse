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

import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.ui.internal.zookeeper.ZooKeeperCommonContentProvider;
import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.navigator.ICommonContentExtensionSite;
import org.eclipse.ui.navigator.ICommonContentProvider;

/**
 * @author Srimanth Gunturi
 * 
 */
public class HadoopCommonContentProvider implements ICommonContentProvider {

	private static final Logger logger = Logger.getLogger(HadoopCommonContentProvider.class);
	private List<ICommonContentProvider> childProviders = new ArrayList<ICommonContentProvider>();

	/**
	 * 
	 */
	public HadoopCommonContentProvider() {
		childProviders.add(new ZooKeeperCommonContentProvider());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.
	 * Object)
	 */
	@Override
	public Object[] getElements(Object inputElement) {
		List<Object> elements = new ArrayList<Object>();
		for (ICommonContentProvider cp : childProviders) {
			Object[] ces = cp.getElements(inputElement);
			if (ces != null)
				for (Object s : ces)
					elements.add(s);
		}
		if (logger.isDebugEnabled())
			logger.debug("getElements(" + inputElement + "): " + elements);
		return elements.toArray();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.
	 * Object)
	 */
	@Override
	public Object[] getChildren(Object parentElement) {
		List<Object> elements = new ArrayList<Object>();
		for (ICommonContentProvider cp : childProviders) {
			Object[] ces = cp.getChildren(parentElement);
			if (ces != null)
				for (Object s : ces)
					elements.add(s);
		}
		if (logger.isDebugEnabled())
			logger.debug("getChildren(" + parentElement + "): " + elements);
		return elements.toArray();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object
	 * )
	 */
	@Override
	public Object getParent(Object element) {
		for (ICommonContentProvider cp : childProviders) {
			Object parent = cp.getParent(element);
			if (parent != null)
				return parent;
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.
	 * Object)
	 */
	@Override
	public boolean hasChildren(Object element) {
		for (ICommonContentProvider cp : childProviders) {
			boolean hasChildren = cp.hasChildren(element);
			if (hasChildren)
				return hasChildren;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	@Override
	public void dispose() {
		for (ICommonContentProvider cp : childProviders)
			cp.dispose();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface
	 * .viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		for (ICommonContentProvider cp : childProviders)
			cp.inputChanged(viewer, oldInput, newInput);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.IMementoAware#restoreState(org.eclipse.ui.IMemento
	 * )
	 */
	@Override
	public void restoreState(IMemento aMemento) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.IMementoAware#saveState(org.eclipse.ui.IMemento)
	 */
	@Override
	public void saveState(IMemento aMemento) {
		// TODO Auto-generated method stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.navigator.ICommonContentProvider#init(org.eclipse.ui.navigator
	 * .ICommonContentExtensionSite)
	 */
	@Override
	public void init(ICommonContentExtensionSite aConfig) {
		for (ICommonContentProvider cp : childProviders)
			cp.init(aConfig);
	}

}
