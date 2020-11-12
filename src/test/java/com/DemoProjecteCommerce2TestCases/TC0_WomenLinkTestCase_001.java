package com.DemoProjecteCommerce2TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.DemoProjecteCommerce1Pages.eCommerceLoginPage;

import junit.framework.Assert;

public class TC0_WomenLinkTestCase_001 extends BaseClass {
	

	
	@Test
	public void womenLinkHomePageTest()
	{
		
		eCommerceLoginPage lp = new eCommerceLoginPage(driver);
		lp.womenLinkTest().click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String womenTextValidation=driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/div/p[1]/strong")).getText();
		
		System.out.println(womenTextValidation);
		
		Assert.assertEquals("You will find here all woman fashion collections", womenTextValidation);		
		
		
	}
	

}
