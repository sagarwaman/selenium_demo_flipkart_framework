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

import com.pages.Galaxymobile;
import com.pages.Samsung_mobile;
import com.pages.myhomepage;
import com.pages.mylogin;
import com.pages.mymobile;
import com.relevantcodes.extentreports.LogStatus;

import Testbase.baseclass;

public class Mobile extends baseclass {

	mylogin login2;
	myhomepage home2;
	mymobile mobile2;
	Samsung_mobile sm;
	Galaxymobile gm;

	public Mobile() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeSuite
	public void report_test() {
		setupsuite();
	}

	@AfterSuite
	public void tear_down() {
		endreport();
	}

	@BeforeMethod
	public void set_up_mobile_page() throws FileNotFoundException, InterruptedException {
		initialize();
		login2 = new mylogin();
		home2 = new myhomepage();
		mobile2 = new mymobile();
		login2.loginmethod(prop.getProperty("Username"), prop.getProperty("Password"));
		home2.moveelement();
		Thread.sleep(3000);
	}

	@Test(priority = 1)
	public void validate_mobilepage_title() {
		test1 = extent.startTest("validate_mobilepage_title");
		String title = mobile2.validatemobilepagetitle();
		Assert.assertEquals(title, "Mobile Phones: Buy Mobiles Online at Best Prices in India");
	}

	@Test(priority = 2)
	public void get_text_test() {
		test1 = extent.startTest("get_text_test");
		Assert.assertTrue(mobile2.mobiletext());
	}

	@Test(priority = 3)
	public void search_method_test() throws InterruptedException {
		test1 = extent.startTest("search_method_test");
		sm = mobile2.clickmethod();
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void go_to_test() throws InterruptedException {
		test1 = extent.startTest("go_to_test");
		gm = mobile2.searchfunc();
		Thread.sleep(2000);
	}

	@AfterMethod
	public void get_report(ITestResult result) throws IOException {
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

}
