package com.DemoProjecteCommerce2TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.DemoProjecteCommerce1Pages.eCommerceLoginPage;

import junit.framework.Assert;

public class TC01_DressesLinkTestCase_001 extends BaseClass{
	
	
	@Test
	public void dressesLinkHomePageValidation()
	{
		eCommerceLoginPage lg = new eCommerceLoginPage(driver);
		lg.dressesLinkTest().click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
	String dressesText = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/span")).getText();
	System.out.println("dressesText");
	
	Assert.assertEquals("Dresses", dressesText);
		
	}

}
