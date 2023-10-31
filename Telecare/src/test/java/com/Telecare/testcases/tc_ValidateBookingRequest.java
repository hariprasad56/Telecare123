package com.Telecare.testcases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Telecare.pageobjects.LoginPageOfTidyTangleProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.Telecare.pageobjects.DashboardPageOfTidyTangleProvider;

public class tc_ValidateBookingRequest extends BaseTest{
	@Test()
	public void bookingRequestPage() throws IOException, InterruptedException
	{
		test=extent.createTest("BookingRequest");
		test.log(Status.INFO, "test case execution started");
		LoginPageOfTidyTangleProvider tlp= new LoginPageOfTidyTangleProvider(driver);
		tlp.setUsername(emails);
		tlp.setPassword(passs);
		tlp.clickOnSignin();
		Thread.sleep(5000);
		DashboardPageOfTidyTangleProvider dbp=new DashboardPageOfTidyTangleProvider(driver);
		//dbp.setViall();
		//dbp.setClickOnView();
		dbp.setCrossmark();
		Thread.sleep(3000);
		dbp.setViall();
		//dbp.setAservice();
		Thread.sleep(3000);
		String tname=driver.getTitle();
		if(tname.equals("Bookings"))
		{
			Assert.assertTrue(true);
			test.log(Status.PASS, MarkupHelper.createLabel("TidyTangleLoginPage"+"-test pass", ExtentColor.GREEN));
			log.info("Pass:Booking Request page sucessfully opened ");
//			dbp.setSearbar(nm);
//			dbp.setSearbutton();
//			dbp.setDownloadbutton();
//			dbp.setExcelbutton();
//			dbp.setFilterbutton();
//			dbp.setClickOnCross();
		}
		else
		{
			Assert.assertTrue(false);
			test.log(Status.FAIL, MarkupHelper.createLabel("TidyTangleLoginPage"+"-test fail", ExtentColor.RED));
			takeScreenshot("Booking Request Page");
		    log.info("Fail:Booking Request page sucessfully opened");
		}
	}

}
