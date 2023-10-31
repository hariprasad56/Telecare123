package com.Telecare.utilities;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener {
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public String timeStamp; 
	
	public void onStart(ITestContext context)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date date=new Date();
		 timeStamp=sdf.format(date);
		String repName="report"+timeStamp+".html";
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		 //htmlReporter.loadXMLConfig("C:\\Users\\user\\eclipse-workspace\\Telecare\\exetent-configuration.xml");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host name", "Localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "Hari");
		//sparkReporter.config().setChartVisibilityOnOpen(true);
		sparkReporter.config().setDocumentTitle("Telecare");
		sparkReporter.config().setReportName("Test Automation Report");
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setTimeStampFormat("EEEE,MMMM dd, yyyy, hh:mm a'('zzz')'");
	}
	
    
	public void onTestSucess(ITestResult tr)
	{	
		test=extent.createTest(tr.getName());
		Assert.assertTrue(true);
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr)
	{
		//test=extent.createTest(tr.getName());
		Assert.assertFalse(false);
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		String screenshotPath=System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".jpg";
	   File f =new File(screenshotPath);
	   if(f.exists())
	   {
		   test.fail("screentshot is below:"+test.addScreenCaptureFromPath(screenshotPath));
	   }
		
	}
	
	
	public void onTestSkipped(ITestResult tr)
	{
		//test=extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
   
	public void getResult(ITestResult tr)
	{
	if(tr.getStatus()==ITestResult.FAILURE)	
	{
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName()+"-Test Case Failed", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getThrowable()+"-Test Case Failed", ExtentColor.RED));
	}else if(tr.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName()+"-Test Case Pass", ExtentColor.GREEN));	
	}
	else
	{
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName()+"-Test Case Skipped", ExtentColor.ORANGE));
	}
	extent.flush();
	}
	
	public void onTestFinish(ITestContext context)
	{
		extent.flush();
	}
}
