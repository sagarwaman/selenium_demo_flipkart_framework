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
import com.relevantcodes.extentreports.LogStatus;

import Testbase.baseclass;

public class loginpage extends baseclass {

	mylogin login1;
	myhomepage homepage;

	public loginpage() throws FileNotFoundException {
		super();
	}

	@BeforeMethod
	public void login_page_setup() throws FileNotFoundException {
		initialize();
		login1 = new mylogin();
	}

	@BeforeSuite
	public void login_report_test() {
		//setupsuite();
	}

	@Test(priority = 1)
	public void get_loginpage_title() {
		test1 = extent.startTest("getmytitle");
		String title = login1.gettitle();
		extent.addSystemInfo("OS", "Windows");
		Assert.assertEquals(title,
				"Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!");
	}

	@Test(priority = 2)
	public void validate_loginpage_logo() {
		test1 = extent.startTest("validatemylogo");
		Assert.assertTrue(login1.validatelogo());
	}

	@Test(priority = 3)
	public void login_app() throws FileNotFoundException {
		test1 = extent.startTest("loginapp");
		homepage = login1.loginmethod(prop.getProperty("Username"), prop.getProperty("Password"));
	}

	@Test(priority = 4)
	public void my_test() {
		test1 = extent.startTest("mytest");
		Assert.assertTrue(false);
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

	@AfterSuite
	public void endtest() {
		//endreport();
	}

}
