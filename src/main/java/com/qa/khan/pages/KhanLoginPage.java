package com.qa.khan.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.khan.base.KhanTestBase;
import com.qa.khan.base.KhanTestBaseExcel;

public class KhanLoginPage extends KhanTestBaseExcel {
	
	@FindBy(id="uid-identity-text-field-1-email-or-username")
	WebElement email;
	
	@FindBy(id="uid-identity-text-field-2-password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	public KhanLoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public KhanHomePage loginpage(String username, String pass)
	{
		email.sendKeys(username);
		password.sendKeys(pass);
		loginbutton.click();
		return new KhanHomePage();
	}
}
