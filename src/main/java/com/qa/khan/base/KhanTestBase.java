package com.qa.khan.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.khan.pages.KhanLoginPage;

public class KhanTestBase {
	
	FileInputStream file;
	public static WebDriver driver;
	public static Properties property;
	public KhanTestBase() 
	{
		File f = new File("C://Users//Priya//workspace//POM//src//main//java//com//qa//khan//properties//configuration.properties");
		try {
			file = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 property = new Properties();
		try {
			property.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static KhanLoginPage driverinitialisation()
	{
		System.setProperty("webdriver.chrome.driver", "C://Users//Priya//Desktop//Tutors//chromedriver_win32 (3)//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.khanacademy.org/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("login-or-signup")).click();
		return new KhanLoginPage();
	}
	
	
	

}
