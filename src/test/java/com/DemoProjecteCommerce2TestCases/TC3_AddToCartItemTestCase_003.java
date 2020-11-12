package com.DemoProjecteCommerce2TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.DemoProjecteCommerce1Pages.eCommerceLoginPage;

public class  TC3_AddToCartItemTestCase_003   extends BaseClass{
	
	
	@Test
	public void addToCartTest() throws Throwable
	{
		TC1_eCommerceLoginTestCase_001.loginTest();
		eCommerceLoginPage ls = new eCommerceLoginPage(driver);
		ls.womenLinkTest().click();
		driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
		
		eCommerceLoginPage li = new eCommerceLoginPage(driver);
		Actions act = new Actions(driver);
		act.moveToElement(li.womenLinkTest()).click().perform();
		
		
		List<WebElement> image = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li[i]/div/div[2]/h5/a"));
		int imageCount= image.size();
		
		for(int i=0; i<imageCount; i++)
		{
			WebElement element = image.get(i);
			String text= element.getText();
			System.out.println(text);
			
			if(text.equalsIgnoreCase("Blouse"))
			{
				element.click();
				break;
			}
			Thread.sleep(10000);
		}
		
		
		
		
		
		
	}
	

}
