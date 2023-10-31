package com.Telecare.utilities;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
public class ExtentReports1 {
	public static ExtentReports getReport()
	{
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	Date date=new Date();
	String timeStamp=sdf.format(date);
	String repName="report"+timeStamp+".html" ;
	ExtentSparkReporter spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
	ExtentReports reports = new ExtentReports();
	reports.attachReporter(spark);
	spark.config().setDocumentTitle("Telecare");
	spark.config().setReportName("Test Automation Report");
	spark.config().setTheme(Theme.DARK);
	spark.config().setTimeStampFormat("EEEE,MMMM dd, yyyy, hh:mm a'('zzz')'");
	reports.setSystemInfo("Host name", "Localhost");
	reports.setSystemInfo("Environment", "QA");
	reports.setSystemInfo("user", "Hari");
	return reports;
	}
}
