package com.Telecare.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageOfTidyTangleProvider {
	WebDriver d;
	public DashboardPageOfTidyTangleProvider(WebDriver d)
	{
		this.d=d;
		PageFactory.initElements(d,this );
	}
	@FindBy(xpath="//a[@href='https://homeservices.xpressgro.com/provider/booking/list?booking_status=pending'][normalize-space()='View all']") WebElement viewall1;
	@FindBy(xpath="//input[@placeholder='Search here']")WebElement searchbar;
	@FindBy(xpath="//button[@class='btn btn--primary']")WebElement searchbutton;
	@FindBy(xpath="//button[@class='btn btn--secondary text-capitalize dropdown-toggle']")WebElement download;
	@FindBy(xpath="//a[@href='https://homeservices.xpressgro.com/provider/booking/download?booking_status=pending']")WebElement excel;
	@FindBy(xpath="//button[@class='btn text-capitalize filter-btn px-0']")WebElement filter;
	@FindBy(xpath="//input[@placeholder='Start date']") WebElement startdate;
	@FindBy(xpath="//input[@placeholder='End date']")WebElement enddate;
	@FindBy(xpath="//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']//span[@role='combobox']")WebElement categorylist;
	@FindBy(xpath="////span[@class='select2 select2-container select2-container--default select2-container--focus']//span[@role='combobox']")WebElement subcategorylist;
	@FindBy(xpath="//button[@class='btn btn--primary text-capitalize fz-14']")WebElement filterbutton;
	@FindBy(xpath="//button[@class='btn btn--secondary text-capitalize fz-14']")WebElement clearfilter;
	@FindBy(xpath="//button[@class='btn-close p-2']")WebElement crossbutton;
	@FindBy(xpath="//a[@href='https://homeservices.xpressgro.com/provider/sub-category/subscribed'][normalize-space()='View all']")WebElement acs;
	@FindBy(xpath="//button[@aria-label='Close this dialog']")WebElement cross;
	
	
	public void setViall()
	{
		viewall1.click();
	}
	public void setSearbar(String itemname)
	{
		searchbar.sendKeys("itemname");
	}
	public void setSearbutton()
	{
		searchbutton.click();
	}
	public void setDownloadbutton()
	{
		download.click();
	}
	public void setExcelbutton()
	{
		excel.click();
	}
	public void setFilterbutton()
	{
		filter.click();
	}
	public void setStartDatebox(String sdate)
	{
		startdate.sendKeys(sdate);
	}
	public void setEndDate(String edate)
	{
		enddate.sendKeys(edate);
	}
	public void setCategoryList()
	{
		categorylist.click();
	}
	public void setSubCategoryList()
	{
		subcategorylist.click();
	}
	public void setFilterButton1()
	{
		filterbutton.click();
	}
	public void setClearFilter()
	{
		clearfilter.click();
	}
	public void setClickOnCross()
	{
		crossbutton.click();
	}
	public void setClickOnView()
	{
		acs.click();
	}
	public void setCrossmark()
	{
		cross.click();
	}

}
