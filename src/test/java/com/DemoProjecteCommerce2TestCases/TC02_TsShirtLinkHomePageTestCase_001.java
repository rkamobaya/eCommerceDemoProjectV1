package com.DemoProjecteCommerce2TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoProjecteCommerce1Pages.eCommerceLoginPage;

public class TC02_TsShirtLinkHomePageTestCase_001 extends BaseClass{
	
	@Test
	public void tsShirtLinkHomePageTest()
	{
		eCommerceLoginPage lt = new eCommerceLoginPage(driver);
		lt.tshirtsLinkTest().click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		String tshirtText= driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/span")).getText();
		System.out.println(tshirtText);
		
		Assert.assertEquals(tshirtText, "T-shirts");
		
		
	}
	
	
	
	
	
	
	

}
