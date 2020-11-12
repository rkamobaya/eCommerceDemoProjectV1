package com.DemoProjecteCommerce2TestCases;

import org.testng.annotations.Test;

import com.DemoProjecteCommerce1Pages.eCommerceLoginPage;

import junit.framework.Assert;

public class TC03_WebLogoHomePageTestCase_001 extends BaseClass {
	
	@Test
	public void logoWebHomePageTest()
	{
		eCommerceLoginPage la = new eCommerceLoginPage(driver);
		Boolean logo = la.logoTest().isDisplayed();
		
		Assert.assertTrue(logo);
		
		
	}	
	

}
