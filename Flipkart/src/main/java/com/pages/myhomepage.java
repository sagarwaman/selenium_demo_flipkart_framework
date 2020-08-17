package com.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.baseclass;

public class myhomepage extends baseclass{

	@FindBy(xpath = "//span[contains(text(),'Electronics')]")
	WebElement electronics;
	
	@FindBy(xpath = "//a[@title='Mobiles']")
	WebElement mobiles;
	
	@FindBy(xpath = "//img[@class='_1e_EAo']")
	WebElement homepagelogo;
	
	
	public myhomepage() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}

	
	public boolean validatehomepagelogo()
	{
		return homepagelogo.isDisplayed();
	}
	
	public mymobile moveelement() throws InterruptedException, FileNotFoundException
	{
		Actions a = new Actions(driver);
		Thread.sleep(5000);
		a.moveToElement(electronics).build().perform();
		mobiles.click();
		Thread.sleep(2000);
		return new mymobile();			
	}
}
