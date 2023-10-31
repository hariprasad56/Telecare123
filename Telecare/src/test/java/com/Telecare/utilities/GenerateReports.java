package com.Telecare.utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;

public class GenerateReports extends TestListenerAdapter{
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	@BeforeSuite
	public void setup(ITestContext tr)
	{
	//WebDriver driver=new ChromeDriver();
	sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Test-Reports/report.html");
	extent=new ExtentReports();
	extent.attachReporter(sparkReporter);
	}
//	@Test
//	public void actual()
//	{
//		extent.createTest("hari");
//		test.log(Status.PASS, "actual test is pass");
//		
//	}
//	public void testFail(ITestResult tr)
//	{
//		extent.createTest("hari");
//		test.log(Status.FAIL,tr.getThrowable());
//		test.log(Status.FAIL,"test fails");
//	}
	@AfterSuite
	public void end()
	{
		extent.flush();
	}

}
