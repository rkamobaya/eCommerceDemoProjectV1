package com.DemoProjecteCommerce2TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.DemoProjecteCommerce1Pages.eCommerceLoginPage;

import junit.framework.Assert;

public class TC04_CartImageHomePageTestCase_001 extends BaseClass {
	
	@Test
	public void cartImageTestValidation()
	{
		eCommerceLoginPage lv = new eCommerceLoginPage(driver);
		lv.shoppingCartTest().click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		String cartText = driver.findElement(By.id("cart_title")).getText();
		System.out.println(cartText);
		
		Assert.assertEquals("SHOPPING-CART SUMMARY", cartText);
		
		
		
	}

}
