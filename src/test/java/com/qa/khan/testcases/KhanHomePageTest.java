package com.qa.khan.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.khan.base.KhanTestBase;
import com.qa.khan.pages.KhanHomePage;
import com.qa.khan.pages.KhanLoginPage;

public class KhanHomePageTest extends KhanTestBase {
	
	
	
	
	@BeforeMethod
	public void setup()
	{
		KhanTestBase.driverinitialisation();
		KhanLoginPage kl = new KhanLoginPage();
		kl.loginpage(KhanTestBase.property.getProperty("email"), KhanTestBase.property.getProperty("password"));
		
	}
	
	@Test
	public void loggedInUsernameTest()
	{
		KhanHomePage hp= new KhanHomePage();
		boolean value = hp.loggedInUsername();
		Assert.assertEquals(value, true);
	}
	
	@AfterMethod
	public void tear()
	{
		
	}

}
