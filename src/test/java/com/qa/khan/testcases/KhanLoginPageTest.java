package com.qa.khan.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.khan.base.KhanTestBase;
import com.qa.khan.base.KhanTestBaseExcel;
import com.qa.khan.pages.KhanLoginPage;

public class KhanLoginPageTest extends KhanTestBaseExcel{
	
	KhanTestBaseExcel kb;
	
	
	@BeforeMethod
	public void setup()
	{
		KhanTestBaseExcel.driverinitialisation();
	}
	@DataProvider(name="exceldatarange")
	public Object[][] getdatafromexcel()
	{
		return KhanTestBaseExcel.Getdata("Sheet1");
	}
	@Test(dataProvider="exceldatarange")
	public void login(String un, String pas)
	{
		KhanLoginPage kl = new KhanLoginPage();
		
		kl.loginpage(un,pas);
	}
	@AfterMethod
	public void tear()
	{
		//driver.close();
	}
}
