package com.Telecare.testcases;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Telecare.utilities.ReadConfingure;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseTest {
	ReadConfingure	co=new ReadConfingure();
	public String url=co.getbaseurl();
	String url1=co.geturl();
	String emails=co.getemail1();
	String passs=co.getPasswor1();
    public String nm=co.getname2();
	public String username=co.getusername();
	public String password=co.getpassword();
	public  WebDriver driver;
	public Logger log;
    public static ExtentReports extent; 
	public static ExtentTest test;
	SimpleDateFormat sdf;
	Date date;
	String dateformat;
	String Repname;
	@BeforeSuite
	public void setUp1()
	{
		sdf=new SimpleDateFormat("dd-MM-YYYY,HH.mm.ss");
		 date=new Date();
		 dateformat=sdf.format(date);
		String repName="report"+dateformat+".html";
		ExtentSparkReporter spark= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		spark.config().setDocumentTitle("Hydro");
		spark.config().setReportName("Automation Test Report");
		spark.config().setTimeStampFormat("dd-MM-YYYY,HH-mm-ss");
		spark.config().setTheme(Theme.STANDARD);
		extent=new ExtentReports(); 
		extent.attachReporter(spark);
		extent.setSystemInfo("Host Name" ,"Local Host" );
		extent.setSystemInfo("Environment" ,"QA" );
		extent.setSystemInfo("User" ,"Hari" );
		
		
	}
	
	@Parameters("browser")
	@BeforeClass
	public  void setup(String browser)
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
//		DesiredCapabilities cp=new DesiredCapabilities();
//		cp.setCapability(ChromeOptions.CAPABILITY, options);
//		options.merge(cp);
		if(browser.equalsIgnoreCase("chrome"))
		{
			//System.setProperty("WebDriver.chrome.driver", co.getchromepath());
		driver=new ChromeDriver(options);
		
		}else
		{
			System.setProperty("WebDriver.gecko.driver", co.getfirefoxpath());
			driver=new FirefoxDriver();
		}
	 log=LogManager.getLogger("BaseTest.class");
	DOMConfigurator.configure("Log4j.xml");
	//PropertyConfigurator.configure("Log4j.property");
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterClass
	public  void teardown()
	{
		driver.quit();
	}

   public void takeScreenshot(String tname) throws IOException
   {
	   TakesScreenshot shot=(TakesScreenshot)driver;
	   File src=shot.getScreenshotAs(OutputType.FILE);
	   Repname=tname+dateformat+".png";
	  File dst =new File(System.getProperty("user.dir")+"/Screenshots/"+Repname);
	  Files.copy(src, dst);
	   System.out.println("Screenshot taken");
   }
   public String randomString()
   {
	   String ownstring=RandomStringUtils.randomAlphabetic(8);
	   return ownstring;
   }
   public String randomNum()
   {
	   String ownnum=RandomStringUtils.randomNumeric(5);
	   return ownnum;
   }
   @AfterSuite
	public void teatDown1()
	{
		extent.flush();
	}
   
  
	
}
