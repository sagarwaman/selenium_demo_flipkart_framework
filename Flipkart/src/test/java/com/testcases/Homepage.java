package com.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.myhomepage;
import com.pages.mylogin;
import com.pages.mymobile;
import com.relevantcodes.extentreports.LogStatus;

import Testbase.baseclass;

public class Homepage extends baseclass {

	mylogin login1;
	myhomepage home1;
	mymobile mobile1;

	public Homepage() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	public void Homepagereporttest() {
		//setupsuite();
	}

	@BeforeMethod
	public void Homepage_setup() throws FileNotFoundException {
		initialize();
		login1 = new mylogin();
		home1 = new myhomepage();
		login1.loginmethod(prop.getProperty("Username"), prop.getProperty("Password"));
	}

	@Test(priority = 1)
	public void validate_homepage_logo() {
		test1 = extent.startTest("validate_homepage_logo");
		Assert.assertTrue(home1.validatehomepagelogo());
	}

	@Test(priority = 2)
	public void navigate_home_page_test() throws InterruptedException, FileNotFoundException {
		test1 = extent.startTest("navigate_home_page_test");
		mobile1 = home1.moveelement();
	}

	@AfterMethod
	public void getreport(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test1.log(LogStatus.FAIL, "Test case fail is " + result.getName());
			test1.log(LogStatus.FAIL, "Test case fail is " + result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {
			test1.log(LogStatus.SKIP, "Test case SKIP is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test1.log(LogStatus.PASS, "Test case Pass is " + result.getName());
		}
		extent.endTest(test1);
		driver.quit();
	}

	@AfterSuite
	public void teardown() {
		//endreport();
	}
}
