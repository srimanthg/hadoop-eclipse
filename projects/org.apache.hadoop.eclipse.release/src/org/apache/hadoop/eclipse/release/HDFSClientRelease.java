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
package org.apache.hadoop.eclipse.release;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.eclipse.hdfs.ResourceInformation;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * HDFS Client for HDFS version 1.1.2.21.
 * 
 * @author Srimanth Gunturi
 */
public class HDFSClientRelease extends org.apache.hadoop.eclipse.hdfs.HDFSClient {

	private static Logger logger = Logger.getLogger(HDFSClientRelease.class);
	private Configuration config;

	public HDFSClientRelease() {
		config = new Configuration();
	}

	private ResourceInformation getResourceInformation(FileStatus fileStatus) {
		ResourceInformation fi = new ResourceInformation();
		fi.setFolder(fileStatus.isDir());
		fi.setGroup(fileStatus.getGroup());
		fi.setLastAccessedTime(fileStatus.getAccessTime());
		fi.setLastModifiedTime(fileStatus.getAccessTime());
		fi.setName(fileStatus.getPath().getName());
		fi.setOwner(fileStatus.getOwner());
		fi.setPath(fileStatus.getPath().getParent() == null ? "/" : fileStatus.getPath().getParent().toString());
		fi.setReplicationFactor(fileStatus.getReplication());
		fi.setSize(fileStatus.getLen());
		return fi;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.hdfs.HDFSClient#getResource(java.net.URI)
	 */
	@Override
	public ResourceInformation getResourceInformation(URI uri) throws IOException {
		FileSystem fs = FileSystem.get(uri, config);
		Path path = new Path(uri.getPath());
		FileStatus fileStatus = null;
		ResourceInformation fi = null;
		try {
			fileStatus = fs.getFileStatus(path);
			fi = getResourceInformation(fileStatus);
		} catch (FileNotFoundException fne) {
			logger.info(fne.getMessage());
			logger.debug(fne.getMessage(), fne);
		}
		return fi;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.hdfs.HDFSClient#setResource(java.net.URI,
	 * org.apache.hadoop.eclipse.hdfs.ResourceInformation)
	 */
	@Override
	public void setResourceInformation(URI uri, ResourceInformation information) throws IOException {
		FileSystem fs = FileSystem.get(uri, config);
		Path path = new Path(uri.getPath());
		if (!information.isFolder()) {
			fs.setTimes(path, information.getLastModifiedTime(), information.getLastAccessedTime());
		}
		if (information.getOwner() != null || information.getGroup() != null)
			fs.setOwner(path, information.getOwner(), information.getGroup());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#listResources(java.net.URI)
	 */
	@Override
	public List<ResourceInformation> listResources(URI uri) throws IOException {
		List<ResourceInformation> ris = null;
		FileSystem fs = FileSystem.get(uri, config);
		Path path = new Path(uri.getPath());
		FileStatus[] listStatus = fs.listStatus(path);
		if (listStatus != null) {
			ris = new ArrayList<ResourceInformation>();
			for (FileStatus ls : listStatus) {
				ris.add(getResourceInformation(ls));
			}
		}
		return ris;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#openInputStream(java.net.URI,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public InputStream openInputStream(URI uri, IProgressMonitor monitor) throws IOException {
		FileSystem fs = FileSystem.get(uri, config);
		Path path = new Path(uri.getPath());
		FSDataInputStream open = fs.open(path);
		return open;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#openInputStream(java.net.URI,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public OutputStream createOutputStream(URI uri, IProgressMonitor monitor) throws IOException {
		FileSystem fs = FileSystem.get(uri, config);
		Path path = new Path(uri.getPath());
		FSDataOutputStream outputStream = fs.create(path);
		return outputStream;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#openInputStream(java.net.URI,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public OutputStream openOutputStream(URI uri, IProgressMonitor monitor) throws IOException {
		FileSystem fs = FileSystem.get(uri, config);
		Path path = new Path(uri.getPath());
		// TODO. Temporary fix till Issue#3 is fixed.
		FSDataOutputStream outputStream = fs.create(path);
		return outputStream;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.hdfs.HDFSClient#mkdirs(java.net.URI,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public boolean mkdirs(URI uri, IProgressMonitor monitor) throws IOException {
		FileSystem fs = FileSystem.get(uri, config);
		Path path = new Path(uri.getPath());
		return fs.mkdirs(path);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.hdfs.HDFSClient#delete(java.net.URI,
	 * org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void delete(URI uri, IProgressMonitor monitor) throws IOException {
		FileSystem fs = FileSystem.get(uri, config);
		Path path = new Path(uri.getPath());
		fs.delete(path, true);
	}

}
