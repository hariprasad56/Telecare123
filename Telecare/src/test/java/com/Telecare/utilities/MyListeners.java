package com.Telecare.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.io.File;

public class MyListeners implements ITestListener{
     public static  ExtentReports reports;
      public static ExtentTest test;
	@AfterSuite
	public void onTestStart(ITestResult result) {
		String tname=result.getName();
		reports=ExtentReports1.getReport();
		test=reports.createTest(tname);
		test.log(Status.INFO,tname+"Test Execution Started" );
		
		
	}

	
	public void onTestSuccess(ITestResult result) {
		String tname=result.getName();
		test.log(Status.PASS, MarkupHelper.createLabel(tname+"-Test Case Pass",ExtentColor.GREEN));
	}


	public void onTestFailure(ITestResult result) {
		String tname=result.getName();
		test.log(Status.FAIL, MarkupHelper.createLabel(tname+"-Test Case Failed", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"-Test Case Failed", ExtentColor.RED));
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/"+tname+".png";
		File fe=new File(screenshotpath);
		if(fe.exists())
		{
			test.fail("screentshot is below:"+test.addScreenCaptureFromPath(screenshotpath));
		}
		
		
	}

	
	public void onTestSkipped(ITestResult result) {
		String tname=result.getName();
		test.log(Status.SKIP, MarkupHelper.createLabel(tname+"-Test Case Skipped", ExtentColor.ORANGE));
		
	}


	@AfterSuite
	public void onFinish(ITestContext context) {
		reports.flush();
		
	}
	

}
