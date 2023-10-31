package com.Telecare.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.Telecare.pageobjects.LoginPageOfTidyTangleProvider;
import com.Telecare.utilities.XLUtils;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class tc_LoginTidyTangle1 extends BaseTest{
	@Test()
	public void tidyTangle() throws IOException
	{
		test=extent.createTest("TidyTangleLoginPage");
		test.log(Status.INFO, "test case execution started");
	LoginPageOfTidyTangleProvider tlp= new LoginPageOfTidyTangleProvider(driver);
	tlp.setUsername(emails);
	tlp.setPassword(passs);
	tlp.clickOnSignin();
	String tit=driver.getTitle();
	if(tit.equals("Dashboard"))
	{
		Assert.assertTrue(true);
		test.log(Status.PASS, MarkupHelper.createLabel("TidyTangleLoginPage"+"-test pass", ExtentColor.GREEN));
		log.info("Pass:Dashboard sucessfully opened ");
		tlp.clickicon();
		tlp.clickSignout();
	}
	else
	{
		Assert.assertTrue(false);
		test.log(Status.FAIL, MarkupHelper.createLabel("TidyTangleLoginPage"+"-test fail", ExtentColor.RED));
		takeScreenshot("TidyTangleLoginPage");
	    log.info("Fail:Dashboard not opened");
	}
	
	
}
	@DataProvider(name="TidyLoginData")
   String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/Telecare/testdata/TidyTangleLogindata.xlsx";
	int rownu=XLUtils.getRowCount(path, "sheet1");
	int colnu=XLUtils.getCellCount(path, "sheet1", 1);
	String logindata[][]=new String[rownu][colnu];
	for(int i=1;i<rownu;i++)	{
	for(int j=0;j<colnu;j++)
		{
			logindata[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
		}
	}
	return logindata;
		
	}	
	}
