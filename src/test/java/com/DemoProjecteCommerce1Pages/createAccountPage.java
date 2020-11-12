package com.DemoProjecteCommerce1Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class createAccountPage {
	
	WebDriver driver;
	
	public createAccountPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id=\"columns\"]/div[1]/span[2]")
	WebElement auth;
	
	@FindBy(id="id_gender1")
	WebElement gender1;
	
	@FindBy(id="id_gender2")
	WebElement gender2;
	
	@FindBy(name="customer_firstname")
	WebElement fname;
	
	@FindBy(name="customer_lastname")
	WebElement lname;
	
	@FindBy(how=How.ID, using="passwd")
	WebElement pass;
	
	@FindBy(id="days")
	WebElement dropdownDays;
	
	@FindBy(id="months")
	WebElement dropdownMonths;
	
	@FindBy(id="years")
	WebElement dropdownYears;
	
	@FindBy(name="newsletter")
	WebElement newsCheck;
	
	@FindBy(id="optin")
	WebElement partnerCheck;
	
	@FindBy(name="firstname")
	WebElement firstN;
	
	@FindBy(id="lastname")
	WebElement lastN;
	
	@FindBy(how=How.ID, using="address1")
	WebElement address;
	
	@FindBy(how=How.NAME, using="city")
	WebElement city;
	
	@FindBy(how=How.ID, using="state")
	WebElement dropdownState;
	
	@FindBy(id="postcode")
	WebElement zipCode;
	
	@FindBy(id="id_country")
	WebElement addressCountry;
	
	@FindBy(name="phone_mobile")
	WebElement cellPhone;
	
	@FindBy(id="alias")
	WebElement alias;
	
	@FindBy(how=How.ID, using="submitAccount")
	WebElement submit;
	
	
	
	
	public WebElement submitAccountButton()
	{
		return submit;
	}
	
	public WebElement addressAliasSet()
	{
		return alias;
	}
	
	public WebElement addressMobilePhoneSet()
	{
		return cellPhone;
	}
	
	public Select addressCountrySelect()
	{
		return new Select(addressCountry);
	}
	
	public WebElement addressZipCodeSet()
	{
		return zipCode;
	}
	
	public Select addressStateSet()
	{
		return new Select(dropdownState);
	}
	
	public WebElement addressCitySet()
	{
		return city;
	}
	
	public WebElement addressStreetSet()
	{
		return address;
	}
	
	public WebElement addressLastNameSet()
	{
		return lastN;
	}

	public WebElement addressFirstNameSet()
	{
		return firstN;
	}
	
	public WebElement partnerCheckBox()
	{
		return partnerCheck;
	}
	
	public WebElement NewsletterCheckBox()
	{
		return newsCheck;
	}
	
	public Select dropdowSelectYears()
	{
		return new Select(dropdownYears);
	}
	
	public Select dropdownSelectMonths()
	{
		return new Select(dropdownMonths);
	}
	
	public Select dropdownSelectDays()
	{
		return new Select(dropdownDays);
	}
	
	public WebElement setPassword()
	{
		return pass;
	}
	
	public WebElement setLastName()
	{
		return lname;
	}
	
	public WebElement setFirstName()
	{
		return fname;
	}
	
	public WebElement genderFemaleSelect()
	{
		return gender2;
	}
	
	public WebElement genderMaleSelect()
	{
		return gender1;
	}
	
	public WebElement authenticateDisplay()
	{
		return auth;
	}

}
