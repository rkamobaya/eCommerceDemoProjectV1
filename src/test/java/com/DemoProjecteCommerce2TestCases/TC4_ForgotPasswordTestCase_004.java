package com.DemoProjecteCommerce2TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DemoProjecteCommerce1Pages.Page3_forgotPassword;
import com.DemoProjecteCommerce1Pages.eCommerceLoginPage;

public class TC4_ForgotPasswordTestCase_004 extends BaseClass {
	
	public static eCommerceLoginPage lg;
	public static Page3_forgotPassword sv;
	
	@Test 
	public static void verifyForgotPassportLinkTest()
	{
	lg = new eCommerceLoginPage(driver);
	lg.toLoginWindow().click();
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	
	lg.forgotPasswordCheck().click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	
	sv = new Page3_forgotPassword(driver);
	String expectedMessage = "Please enter the email address you used to register. We will then send you a new password.";
	String actualMessage = driver.findElement(By.xpath("//p[contains(text(), 'Please enter the email address you used to register. We will then send you a new password.')]")).getText();
	
	Assert.assertEquals(actualMessage, expectedMessage);
	
	}
	
	@Test
	public void verifyBackToLoginTest()
	{
		//TC4_ForgotPasswordTestCase_004.verifyForgotPassportLinkTest();
		sv.backToLoginButton().click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String actualText = lg.alreadyRegisterCheckText().getText();
		String text ="ALREADY REGISTERED";
		
		Assert.assertEquals(actualText,text );
		
		
		
		
	}
	
}
	
	


