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

import java.text.DateFormat;
import java.util.Date;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileInfo;

/**
 * @author Srimanth Gunturi
 * 
 */
public class HDFSUtilites {

	public static String getDebugMessage(IFileInfo fi) {
		if (fi != null) {
			String lastMod = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG).format(new Date(fi.getLastModified()));
			
			String userPerms = "user(";
			if (fi.getAttribute(EFS.ATTRIBUTE_OWNER_READ))
				userPerms+="r";
			else
				userPerms+="-";
			if (fi.getAttribute(EFS.ATTRIBUTE_OWNER_WRITE))
				userPerms+="w";
			else
				userPerms+="-";
			if (fi.getAttribute(EFS.ATTRIBUTE_OWNER_EXECUTE))
				userPerms+="x";
			else
				userPerms+="-";
			userPerms += ")";

			String groupPerms = "group(";
			if (fi.getAttribute(EFS.ATTRIBUTE_GROUP_READ))
				groupPerms+="r";
			else
				groupPerms+="-";
			if (fi.getAttribute(EFS.ATTRIBUTE_GROUP_WRITE))
				groupPerms+="w";
			else
				groupPerms+="-";
			if (fi.getAttribute(EFS.ATTRIBUTE_GROUP_EXECUTE))
				groupPerms+="x";
			else
				groupPerms+="-";
			groupPerms += ")";

			String otherPerms = "other(";
			if (fi.getAttribute(EFS.ATTRIBUTE_OTHER_READ))
				otherPerms+="r";
			else
				otherPerms+="-";
			if (fi.getAttribute(EFS.ATTRIBUTE_OTHER_WRITE))
				otherPerms+="w";
			else
				otherPerms+="-";
			if (fi.getAttribute(EFS.ATTRIBUTE_OTHER_EXECUTE))
				otherPerms+="x";
			else
				otherPerms+="-";
			otherPerms += ")";

			return "Exists=" + fi.exists() + ", Length=" + fi.getLength() + ", LastMod=" + lastMod + ", "+userPerms+", "+groupPerms+", "+otherPerms;
		}
		return "null";
	}
}
