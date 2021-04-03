package com.qa.khan.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.khan.pages.KhanLoginPage;
import com.qa.khan.util.*;

public class KhanTestBaseExcel {

	public static WebDriver driver;
	
public  static Object[][] Getdata(String sheet) {
		
	
	
		FileInputStream file = null;
		Workbook book = null;
		
		//File f = new File("C://Users//Priya//workspace//POM//excetoread.xlsx");//f variable points to the excel file
		
		try {
		 file = new FileInputStream("C://Users//Priya//workspace//POM//x.xlsx");//file variable reads from the excel file
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			book =WorkbookFactory.create(file);//workbookfatory creates appropriate kind of workbook(HSSF and XSSF) based on the input file
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Sheet s= book.getSheet(sheet);
		int rowc=s.getLastRowNum();
		int colc=s.getRow(0).getLastCellNum();
		System.out.println(rowc);
		System.out.println(colc);
		
		Object[][] o= new Object[rowc+1][colc];
		
		for(int i=1;i<=rowc+1;i++)
		{
			for(int j=0;j<colc;j++)
			{
				 o[i][j]=s.getRow(i).getCell(j).toString();
				System.out.println(o[i][j]);
			}
		}
		//return o;
		return o;
		
		
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
