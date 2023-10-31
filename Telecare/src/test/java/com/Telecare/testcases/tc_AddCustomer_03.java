package com.Telecare.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Telecare.pageobjects.LoginPage;
import com.Telecare.pageobjects.NewCustomerPage;
import com.Telecare.utilities.Reporting;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class tc_AddCustomer_03 extends BaseTest{
	@Test
	public void customerPage() throws InterruptedException, IOException
	{
		test=extent.createTest("customerpage");
		test.log(Status.INFO, "test case execution started");
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		lp.setpassword(password);
		lp.setloginButton();
		Thread.sleep(3000);
		//System.out.println(driver.getTitle());
       // Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
	    //log.info("pass:Home page is displayed");
		NewCustomerPage cp=new NewCustomerPage(driver);
		cp.newCustomer();
		cp.custName(co.getcusName());
		cp.rdButton();
		cp.dateofBirth(co.getdob(), co.getdob1(), co.getdob2());
		cp.cusAddress(co.getAddress());
		cp.cusCity(co.getCity());
		cp.cState(co.getState());
		cp.cusPincode(co.getPin());
		cp.cusPhonenumber(co.getMobileno());
		cp.cusEmail(randomString()+"@gmail.com");
		cp.cusPassword(co.getPassword1());
		cp.cusSumbit();
		Thread.sleep(5000);
		boolean reg=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(reg==true)
		{
			Assert.assertTrue(true);
			test.log(Status.PASS, MarkupHelper.createLabel("xldata"+"-test pass", ExtentColor.GREEN));
			log.info("Pass:customer sucessfully registered");
			
			
		}
		else
		{
		     Assert.assertFalse(false);
			test.log(Status.FAIL, MarkupHelper.createLabel("xldata"+"-test fail", ExtentColor.RED));
			takeScreenshot("customerPage");
		    log.info("Fail:customer not sucessfully registered");
		}
	}

}
