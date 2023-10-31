package com.Telecare.testcases;
import com.Telecare.utilities.Reporting;
import java.awt.AWTException;

import java.io.IOException;
import java.net.URL;
import java.net.http.HttpClient;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Telecare.pageobjects.LoginPage;
import com.Telecare.utilities.XLUtils;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class tc_Login_02 extends BaseTest{
	@Test(dataProvider="LoginData")
	public void xlData(String user,String pwd) throws InterruptedException, IOException
	{

	    test=extent.createTest("xldata");
     	test.log(Status.INFO,"Execution started");
		log.info("Enter the url");
		//driver.get(url);
		driver.manage().window().maximize();
		LoginPage lp=new LoginPage(driver);
		log.info("Enter the username");
		lp.setusername(user);
		log.info("Enter the password");
		lp.setpassword(pwd);
		log.info("Enter the Loginbutton");
		lp.setloginButton();
		Thread.sleep(5000);
		if(isAlertPresent()==true)
		{
			Assert.assertFalse(false);
			takeScreenshot("xlData");
			log.info("My test case is failed");
			test.log(Status.FAIL, MarkupHelper.createLabel("xldata"+"-test fail", ExtentColor.RED));
		    driver.switchTo().alert().accept();
		    Thread.sleep(5000);
		    driver.switchTo().defaultContent();
		
		}
		else
		{
			Assert.assertTrue(true);
			lp.setlogout();
			test.log(Status.PASS, MarkupHelper.createLabel("xldata"+"-test pass", ExtentColor.GREEN));
			Thread.sleep(5000);
			try
			{
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			}
			catch(Exception e)
			{
				System.out.println("go to next page");
			}
			
		}
	}
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/Telecare/testdata/Logindata1.xlsx";
	int rownu=XLUtils.getRowCount(path, "sheet1");
	int colnu=XLUtils.getCellCount(path, "sheet1", 1);
	String logindata[][]=new String[rownu][colnu];
	for(int i=0;i<rownu;i++)
	{
		for(int j=0;j<colnu;j++)
		{
			logindata[i][j]=XLUtils.getCellData(path, "sheet1", i, j);
		}
	}
	return logindata;

}}


