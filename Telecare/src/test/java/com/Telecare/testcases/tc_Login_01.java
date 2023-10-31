package com.Telecare.testcases;

import java.io.IOException;

import org.testng.Assert;
import com.Telecare.utilities.Reporting;
import com.Telecare.utilities.XLUtils;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Telecare.pageobjects.LoginPage;

public class tc_Login_01 extends BaseTest {
	
	@Test
	public void pageTest() throws IOException
	{
		test=extent.createTest("pageTest");
		test.log(Status.INFO, "page test execution started");
		log.info("Enter the url");
		//driver.get(url);
		driver.manage().window().maximize();
		
		//String tile=driver.getTitle();
		//System.out.println(tile);
//		Assert.assertTrue(true);
//		System.out.println("Home page is displayed");
		LoginPage lp=new LoginPage(driver);
		log.info("Enter the username");
		lp.setusername(username);
		log.info("Enter the password");
		lp.setpassword(password);
		log.info("Click on login button");
		lp.setloginButton();
         //test.log(Status.INFO, "page test execution started");
		if(driver.getTitle().equals("Guru99 Bank Manager HomePa"))
		{
			Assert.assertTrue(true);
			test.log(Status.PASS, MarkupHelper.createLabel("pagetest"+"-test pass", ExtentColor.GREEN));
		}
		else
		{
			Assert.assertFalse(false);
			System.out.println("test fails");
			takeScreenshot("pagetest");
			String scpath=System.getProperty("user.dir")+"/Screenshots/"+"pagetest.png";
			test.log(Status.FAIL, MarkupHelper.createLabel("xldata"+"-test fail", ExtentColor.RED));
			//test.addScreenCaptureFromPath(scpath, "Guru Page");
			test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(scpath, "Guru page").build());
			
			
		}
	}
//		@DataProvider(name="LoginData")
//	    String [][] getData() throws IOException
//		{
//			String path=System.getProperty("user.dir")+"/src/test/java/com/Telecare/testdata/Logindata.xlsx";
//		int rownu=XLUtils.getRowCount(path, "sheet1");
//		int colnu=XLUtils.getCellCount(path, "sheet1", 1);
//		String logindata[][]=new String[rownu][colnu];
//		for(int i=1;i<rownu;i++)
//		{
//			for(int j=0;j<colnu;j++)
//			{
//				logindata[i][j]=XLUtils.getCellData(path, "sheet1", i, j);
//			}
//		}
//		return logindata;
//			
//		}
}

