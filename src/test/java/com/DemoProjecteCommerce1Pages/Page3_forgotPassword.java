package com.DemoProjecteCommerce1Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page3_forgotPassword {
	
	WebDriver driver;
	
	public Page3_forgotPassword(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(xpath="//span[contains(text(), 'Retrieve Password')]")
	WebElement fp;
	
	@FindBy(xpath="//span[contains(text(), 'Back to Login')]")
	WebElement bl;
	
	@FindBy(xpath="//p[contains(text(), 'Please enter the email address you used to register. We will then send you a new password.')]")
	WebElement fpt;
	
	
	
	
	public WebElement processToRetrievePasswordMessage()
	{
		return fpt;
	}
	
	public WebElement backToLoginButton()
	{
		return bl;
	}
	
	public WebElement retrievePasswordButton()
	{
		return fp;
	}
	

}
