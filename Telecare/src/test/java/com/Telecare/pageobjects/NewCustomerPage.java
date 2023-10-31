package com.Telecare.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {
	WebDriver c;
	public NewCustomerPage(WebDriver d)
	{
		c=d;
		PageFactory.initElements(d, this);
		
	}
	@FindBy(xpath="//a[@href='addcustomerpage.php']")WebElement addcustomer;
	
	@FindBy(xpath="//input[@onblur='validatecustomername();']")WebElement customerName;
	
	@FindBy(xpath="//input[@type='radio']")WebElement radioButton;
	
	@FindBy(xpath="//input[@id='dob']")WebElement dob;
	
	@FindBy(xpath="//textarea[@onkeyup='validateAddress();']")WebElement address;
	
	@FindBy(xpath="//input[@name='city']")WebElement city;
	
	@FindBy(xpath="//input[@onkeyup='validateState();']")WebElement state;
	
	@FindBy(xpath="//input[@onkeyup='validatePIN();']")WebElement pincode;
	
	@FindBy(xpath="//input[@onkeyup='validateTelephone();']")WebElement phonenumber;
	
	@FindBy(xpath="//input[@name='emailid']")WebElement emailid;
	
	@FindBy(xpath="//input[@type='password']")WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")WebElement submitbutton;
	
	@FindBy(xpath="//input[@type='reset']")WebElement resetbutton;
	
	public  void newCustomer()
	{
		addcustomer.click();
	}
	public  void custName(String cname)
	{
		customerName.sendKeys(cname);
	}
	public  void rdButton()
	{
		radioButton.click();
	}
	public  void dateofBirth(String dd, String mm, String yyyy)
	{
		dob.sendKeys(dd);
		dob.sendKeys(mm);
		dob.sendKeys(yyyy);
		
	}
	public  void cusAddress(String adres)
	{
		address.sendKeys(adres);
	}
	public  void cusCity(String ciname)
	{
		 city.sendKeys(ciname);
	}
	public  void cState(String sname)
	{
		state.sendKeys(sname);
	}
	public  void cusPincode(String cpincode)
	{
		pincode.sendKeys(cpincode);
	}
	public  void cusPhonenumber(String cpnumber)
	{
		phonenumber.sendKeys(cpnumber);
	}
	public  void cusEmail(String cemail)
	{
		emailid.sendKeys(cemail);
	}
	public  void cusPassword(String cpassword)
	{
		password.sendKeys(cpassword);
	}
	public  void cusSumbit()
	{
		submitbutton.click();
	}
	public  void cusRestButton()
	{
		resetbutton.click();
	}
	
}
