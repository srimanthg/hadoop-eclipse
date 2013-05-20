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
package org.apache.hadoop.eclipse.release.webhdfs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.eclipse.hdfs.ResourceInformation;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

/**
 * HDFS Client for WebHDFS version 1.1.2.21.
 * 
 * @author Srimanth Gunturi
 */
public class HDFSClientRelease extends org.apache.hadoop.eclipse.hdfs.HDFSClient {

	private static Logger logger = Logger.getLogger(HDFSClientRelease.class);
	
	private HttpClient httpClient = null;

	/**
	 * 
	 */
	public HDFSClientRelease() {
	}

	protected HttpClient getHttpClient() {
		if (httpClient == null) {
			httpClient = new DefaultHttpClient();
		}
		return httpClient;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#getDefaultUserAndGroupIds()
	 */
	@Override
	public List<String> getDefaultUserAndGroupIds() throws IOException, InterruptedException {
		return new ArrayList<String>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#getResourceInformation(java
	 * .net.URI, java.lang.String)
	 */
	@Override
	public ResourceInformation getResourceInformation(URI uri, String user) throws IOException, InterruptedException {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#setResourceInformation(java
	 * .net.URI, org.apache.hadoop.eclipse.hdfs.ResourceInformation,
	 * java.lang.String)
	 */
	@Override
	public void setResourceInformation(URI uri, ResourceInformation information, String user) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#listResources(java.net.URI,
	 * java.lang.String)
	 */
	@Override
	public List<ResourceInformation> listResources(URI uri, String user) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#openInputStream(java.net.URI,
	 * java.lang.String)
	 */
	@Override
	public InputStream openInputStream(URI uri, String user) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.hdfs.HDFSClient#mkdirs(java.net.URI,
	 * java.lang.String)
	 */
	@Override
	public boolean mkdirs(URI uri, String user) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#openOutputStream(java.net.URI,
	 * java.lang.String)
	 */
	@Override
	public OutputStream openOutputStream(URI uri, String user) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.hadoop.eclipse.hdfs.HDFSClient#createOutputStream(java.net
	 * .URI, java.lang.String)
	 */
	@Override
	public OutputStream createOutputStream(URI uri, String user) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.hadoop.eclipse.hdfs.HDFSClient#delete(java.net.URI,
	 * java.lang.String)
	 */
	@Override
	public void delete(URI uri, String user) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

	}

}
