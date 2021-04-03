package com.qa.khan.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.khan.base.KhanTestBase;
import com.qa.khan.base.KhanTestBaseExcel;

public class KhanHomePage extends KhanTestBaseExcel {
	
	@FindBy(xpath="//span[contains(text(),'Priya dharshini')]")
	WebElement name;
	
	public KhanHomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean loggedInUsername()
	{
		return name.isDisplayed();
	}
}
