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
import java.net.URISyntaxException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.URIUtil;

/**
 * 
 * @author Srimanth Gunturi
 */
public class HDFSURI {
	public static final String SCHEME = "hdfs";
	private final URI uri;
	private IPath path;

	public HDFSURI(URI uri) {
		this.uri = uri;
		String pathString = uri.getPath();
		path = new Path(pathString);
	}

	public HDFSURI append(String name) {
		return new HDFSURI(URIUtil.append(uri, name));
	}

	public String lastSegment() {
		return URIUtil.lastSegment(uri);
	}

	public HDFSURI removeLastSegment() throws URISyntaxException {
		if (path.segmentCount() > 0) {
			String parentPath = path.removeLastSegments(1).toString();
			URI parentURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), parentPath, uri.getQuery(), uri.getFragment());
			return new HDFSURI(parentURI);
		}
		return null;
	}

	public URI getURI() {
		return uri;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return uri == null ? "null" : uri.toString();
	}
}
