package com.Telecare.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Telecare.pageobjects.DashboardPageOfTidyTangleProvider;
import com.Telecare.pageobjects.LoginPageOfTidyTangleProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.Telecare.pageobjects.AvailableServicesPage;
import com.Telecare.pageobjects.MySubcriptionsPage;

public class SubscribeSofaCleanService extends BaseTest{
	@Test
	public void sofaCleaning() throws InterruptedException, IOException
	{
		test=extent.createTest("Subscribe sofa cleaning service");
		test.log(Status.INFO, "test case execution started");
		LoginPageOfTidyTangleProvider tlp= new LoginPageOfTidyTangleProvider(driver);
		tlp.setUsername(emails);
		tlp.setPassword(passs);
		tlp.clickOnSignin();
		Thread.sleep(5000);
		DashboardPageOfTidyTangleProvider dbp=new DashboardPageOfTidyTangleProvider(driver);
//		dbp.setCrossmark();
//		Thread.sleep(3000);
		AvailableServicesPage asp=new AvailableServicesPage(driver);
		asp.setAvailSer();
		asp.setCleanAndPest();
		asp.setSubbutton();
		asp.setYesbutton();
		MySubcriptionsPage msp=new MySubcriptionsPage(driver);
		msp.setMySub();
		msp.setSubscriSubCat();
		boolean gps=driver.getPageSource().contains("Total Sub Categories:1");
				
		if(gps==true)
		{
		Assert.assertTrue(true);
		test.log(Status.PASS, MarkupHelper.createLabel("Subscribe sofa cleaning service"+"-test pass", ExtentColor.GREEN));
		log.info("Pass:Total Sub Categories number should be displayed");
		}
		else
		{
			Assert.assertTrue(false);
			test.log(Status.FAIL, MarkupHelper.createLabel("Subscribe sofa cleaning service"+"-test fail", ExtentColor.RED));
			takeScreenshot("Subscribe sofa cleaning service");
		    log.info("Fail:Total Sub Categories number should not be displayed");
		}
		
	}

}
