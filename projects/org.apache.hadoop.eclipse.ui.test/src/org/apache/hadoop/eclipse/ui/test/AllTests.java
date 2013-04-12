/**
 * 
 */
package org.apache.hadoop.eclipse.ui.test;

import org.apache.hadoop.eclipse.ui.test.hdfs.HDFSTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	HDFSTests.class
})
/**
 * @author Srimanth Gunturi
 *
 */
public class AllTests {}
