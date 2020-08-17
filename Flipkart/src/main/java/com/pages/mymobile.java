package com.pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Testbase.baseclass;

public class mymobile extends baseclass{

	
	@FindBy(xpath = "//h1[text()='Mobile Phones']")
	WebElement mobiletext;
	
	@FindBy(xpath = "//div[@class='_3b7jyH']//img[@alt='Samsung']")
	WebElement Samsung_mobile;
	
	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	WebElement Searchbox;
	
	@FindBy(xpath = "//button[@class='vh79eN']")
	WebElement gobutton;
	
	public mymobile() throws FileNotFoundException {
		PageFactory.initElements(driver, this);
	}
	
	public String validatemobilepagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean mobiletext()
	{
		return mobiletext.isDisplayed();
	}
	
	public Galaxymobile searchfunc()
	{
		Searchbox.clear();
		Searchbox.sendKeys("Samsung galaxy m31");
		gobutton.click();
		
		return new Galaxymobile();
	}

	public com.pages.Samsung_mobile clickmethod()
	{
		Samsung_mobile.click();
		return new Samsung_mobile();
	}
}
