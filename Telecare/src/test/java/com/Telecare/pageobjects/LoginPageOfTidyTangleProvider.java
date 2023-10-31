package com.Telecare.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageOfTidyTangleProvider {
	WebDriver d;
public LoginPageOfTidyTangleProvider(WebDriver d)
{
	this.d=d;
	PageFactory.initElements(d, this );
}
@FindBy(xpath="//input[@type='email']")WebElement email;
@FindBy(xpath="//input[@type='password']")WebElement password;
@FindBy(xpath="//button[@class='btn btn--primary radius-50 text-uppercase']")WebElement signin;
@FindBy(xpath="//img[@class='rounded-circle']")WebElement icon;
@FindBy(xpath="//span[@title='Sign Out']")WebElement signbutton;
@FindBy(xpath="//div[@class='dropdown-menu dropdown-menu-right show']")WebElement frame;
public void setUsername(String uname)
{
	email.sendKeys(uname);
}
public void setPassword(String passwor)
{
	password.sendKeys(passwor);
}
public void clickOnSignin()
{
	signin.click();
}
public void clickicon()
{
	icon.click();
}
public void clickSignout()
{
	signbutton.click();
}
public void showframe()
{
	frame.click();
}
}
