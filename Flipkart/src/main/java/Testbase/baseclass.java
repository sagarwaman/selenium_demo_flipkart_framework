package Testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.util.myutilclass;


public class baseclass {
	
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentReports extent;
	public static ExtentTest test1;

	
	public baseclass() throws FileNotFoundException
	{
		prop = new Properties();
		FileInputStream fp = new FileInputStream("C:\\Users\\SAGAR\\git\\Demorepo\\Flipkart\\src\\main\\java\\com\\config\\config.properties");
		try {
			prop.load(fp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void initialize()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\SAGAR\\Documents\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();	
		}
		else if(browsername.equals("ff")) {
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.25.0-win64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(myutilclass.Page_load_out, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(myutilclass.implicity_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	public void setupsuite()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/extentreport.html",true);
	}
	
	public void endreport()
	{
		extent.flush();
		extent.close();
	}
	
}
