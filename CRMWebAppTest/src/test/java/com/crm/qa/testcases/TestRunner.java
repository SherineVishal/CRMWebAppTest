package com.crm.qa.testcases;

import org.testng.TestNG;

import com.crm.qa.ExtentReport.ExtentReportListener;

public class TestRunner {
	
	static TestNG testng;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExtentReportListener extentReportListener=new ExtentReportListener();
		testng=new TestNG();
		testng.setTestClasses(new Class[] {IndexPageTest.class});
		testng.addListener(extentReportListener);
		testng.run();

	}

}
