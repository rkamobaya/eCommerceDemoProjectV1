package com.DemoProjecteCommerce1Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eCommerceLoginPage {
	
	WebDriver driver;
	
	public eCommerceLoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement Sg;
	
	@FindBy(id="email")
	WebElement userId;
	
	@FindBy(id="passwd")
	WebElement password;
	
	@FindBy(id="SubmitLogin")
	WebElement submit;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
	WebElement userN;
	
	@FindBy(id="email_create")
	WebElement createEmail;
	
	@FindBy(id="SubmitCreate")
	WebElement accCreatebutton;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	WebElement women;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	WebElement dresses;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	WebElement tshirts;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	WebElement cart;
	
	@FindBy(xpath="//*[@id=\"header_logo\"]/a/img")
	WebElement logo;
	
	
	
	
	
	
	public WebElement logoTest()
	{
		return logo;
	}
	
	public WebElement shoppingCartTest()
	{
		return cart;
	}
	
	public WebElement tshirtsLinkTest()
	{
		return tshirts;
	}
	
	public WebElement dressesLinkTest()
	{
		return dresses;
	}
		
	public WebElement womenLinkTest()
	{
		return women;
	}
	
	public WebElement createAccountSubmitButton()
	{
		return accCreatebutton;
	}
	
	public WebElement accountCreateEmail()
	{
		return createEmail;
	}
	
	public WebElement userDisplay()
	{
		return userN;
	}
	
	public WebElement signInSubmit()
	{
		return submit;
	}
	
	public WebElement passwordSet()
	{
		return password;
	}
	
	public WebElement emailAddressSet()
	{
		return userId;
	}
	
	public WebElement toLoginWindow()
	{
		return Sg;
	}
	
	
	

}
