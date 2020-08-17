package com.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.baseclass;

public class mylogin extends baseclass {
	

	@FindBy(xpath = "//span[@class='_1hgiYz']//span[contains(text(),'Login')]")
	WebElement myloginlogo;
	
    @FindBy(xpath = "//input[@class='_2zrpKA _1dBPDZ']") 
    WebElement username;
    
    @FindBy(xpath = "//input[@class='_2zrpKA _3v41xv _1dBPDZ']") 
    WebElement password;
    
    @FindBy(xpath = "//button[@class='_2AkmmA _1LctnI _7UHT_c']")
    WebElement myloginbutton;
    
	public mylogin() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validatelogo()
	{
		return myloginlogo.isDisplayed();
	}
	
	public String gettitle()
	{
		return driver.getTitle();
	}
	
	public myhomepage loginmethod(String un,String pwd) throws FileNotFoundException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		myloginbutton.click();
		
		return new myhomepage();
	}

}
