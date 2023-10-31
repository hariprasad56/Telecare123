package com.Telecare.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MySubcriptionsPage {
	WebDriver d;
	public MySubcriptionsPage(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this );
	}
	@FindBy(xpath="//span[normalize-space()='My subscriptions']")WebElement ms;
	@FindBy(xpath="//a[normalize-space()='Subscribed Sub categories']")WebElement ssc;
	
	
	
	
	
	
	
	public void setMySub()
	{
		ms.click();
	}
	public void setSubscriSubCat()
	{
		ssc.click();
	}

}
