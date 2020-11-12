package com.DemoProjecteCommerce2TestCases;

import java.io.File;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.DemoProjecteCommerce1Pages.eCommerceLoginPage;

import junit.framework.Assert;

public class TC1_eCommerceLoginTestCase_001 extends BaseClass {
	
	
	
	@Test
	public static void loginTest() throws InterruptedException
	{
		eCommerceLoginPage lp = new eCommerceLoginPage(driver);
		lp.toLoginWindow().click();
		Thread.sleep(5000);
		
		lp.emailAddressSet().sendKeys(emailAddress);
		logger.debug("Enter user email address");
		
		
		lp.passwordSet().sendKeys(password);
		logger.fatal("Enter user password");
		
		lp.signInSubmit().click();
		logger.info("User submits his credentials for login");
		logger.debug("This is debug message");
		logger.error("This is an error message");
		
		Thread.sleep(5000);
		
	
		 String userText = lp.userDisplay().getText();
		 
		 String userTextExpected ="Kamo Re";
		 
		  
		  if(userText.equals(userTextExpected)) //same as
		  if(userText==userTextExpected) { Assert.assertTrue(true);
		  logger.info("User logins successfully into application");
		  } 
		  
		  else 
		  { Assert.assertTrue(false);
		  logger.error("User fails to login successfully into application");
		  
		  }
		 
		
	}
	
	@Test
	public void addToCard() throws InterruptedException
	{
		TC1_eCommerceLoginTestCase_001.loginTest();
		

		//*[@id="block_top_menu"]/ul/li[1]/a
		
	
		eCommerceLoginPage ln = new eCommerceLoginPage(driver);
		
		//To work with mouse hover we need to use Action class. Action class will be responsible for all the advanced activities(like mouse hover, scroll up and down etc---)
		Actions act = new Actions(driver);                                              //We need to pass the driver here. 
		
		//Once the object act is created we need to call the method of the Action class moveToElement(). In our case its womenLink in the ecommerceLoginPage. 
		//So ln.womenLinkTest() since ln is the object of ecommerceLoginPage we have created. And then we need to complete it by the method perform(). 
		//but we have serie of operation then we need to write build().perform()   Only perform() when it is a single operation. 
		//As result the mouse will keep pointing at that particular web element .
		act.moveToElement(ln.womenLinkTest()).perform();
		
		Thread.sleep(5000);
		
		//Once the mouse is pointed at this web element, several elements or links will display and we need to click on one of that element. 
		//How to do that?????
		//When we do a mouse hover a list of web elements displays, and each of them represents link with a tag a
		//*[@id="block_top_menu"]/ul/li[1]/ul/li[1]/ul/li[1]/a
		//This will return list of web elements
		List<WebElement> links = driver.findElements(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li[i]/a"));
		
		//I want to check how many links I have
		int total_count=links.size();
		
		//Now I can run a for loop so I can navigate among these links. At every i value it will return me one unique web element.
		for (int i=1; i<=total_count; i++)
		{
			WebElement element = links.get(i);                         //I will use the object links and i will pass the index
			String text = element.getAttribute("innerHTML");    //Once I get the web element at that index which operation I want to perform. Here I want to get the text in the html code
			System.out.println("Link name is " + text);                //It will print the link name
			
			//After I get all the links printed I want to write a condition 
			if(text.equalsIgnoreCase("t-shirts"))
			{
				element.click();
				String title = driver.getTitle();
				System.out.println(title);
				
				break;                  //Once it find the link "t-shirt" and click on it, I want to get out the loop.
			}
			
		}
		
		
		
		
	}
	



}
