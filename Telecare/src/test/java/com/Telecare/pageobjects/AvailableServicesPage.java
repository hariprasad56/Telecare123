package com.Telecare.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AvailableServicesPage {
	WebDriver d;
	public AvailableServicesPage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this );
	}
	@FindBy(xpath="//span[text()='Available services']")WebElement as;
	@FindBy(xpath="//a[normalize-space()='Cleaning & Pest Control']")WebElement cp;
	@FindBy(xpath="//button[@id='button-c6180819-3ae0-402f-8156-b2f827270e45']")WebElement sub;
	@FindBy(xpath="//button[@id='button-c6180819-3ae0-402f-8156-b2f827270e45']")WebElement unsub;
	@FindBy(xpath="//button[normalize-space()='Yes']")WebElement ys;
	@FindBy(xpath="//button[normalize-space()='Cancel']")WebElement cl;
	@FindBy(xpath="//button[@aria-label='Close this dialog']")WebElement csb;
	@FindBy(xpath="//div[@class='service-list']//div[1]//div[2]//div[1]//button[1]")WebElement fs;
	@FindBy(xpath="//img[@src='https://homeservices.xpressgro.com/storage/app/public/service/2023-07-06-64a6b1280ed5b.png']")WebElement cushionimg;
	@FindBy(xpath="//img[@src='https://homeservices.xpressgro.com/storage/app/public/service/2023-07-06-64a6afe9ce4fd.png']")WebElement sofaimg;
	@FindBy(xpath="//img[@src='https://homeservices.xpressgro.com/storage/app/public/service/2023-07-06-64a6b38589540.png']")WebElement dtimage;
	@FindBy(xpath="//img[@src='https://homeservices.xpressgro.com/storage/app/public/service/2023-07-06-64a6b43d5174c.png']")WebElement mcimage ;
	@FindBy(xpath="//img[@src='https://homeservices.xpressgro.com/storage/app/public/service/2023-07-06-64a6b22cb4a7f.png']")WebElement ccimage ;
	
	public void setCleanAndPest()
	{
		cp.click();                    
	}
	public void setAvailSer()
	{
		as.click();
	}
	public void setSubbutton()
	{
		sub.click();
	}
	public void setYesbutton()
	{
		ys.click();
	}

}
