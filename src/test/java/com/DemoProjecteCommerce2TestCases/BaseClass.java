package com.DemoProjecteCommerce2TestCases;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.log4testng.Logger;

import com.DemoProjecteCommerce4Utilities.ReadConfig;
import com.DemoProjecteCommerce4Utilities.Reporting;


public class BaseClass {

	// for every test case setup() and tearDown() methods are required. Those 2 methods are common to every test case. 
	//Thus those 2 methods must be part of BaseClass.
	//Taking screenshot on failure must be part also of BaseClass because it is common also to every test case.
	//Instead of writing them multiple times in every test case, we must write them only once in BaseClass and then 
	//through inheritance relationship we have to extends this BaseClass to every test case.
	//Also we need to write here all the variables common to every test case
	
	static ReadConfig readconfig = new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();     //before:  public String baseURL = "http://automationpractice.com/";
	public static String emailAddress = readconfig.getEmail();         //before: public String emailAddress = "ken@aol.com";
	public static String password = readconfig.getPassword();          //before: public String password = "test123";
	public String ChromePath = readconfig.getChromePath();
	public String FirefoxPath = readconfig.getFirefoxPath();
	public String EdgePath = readconfig.getEdgePath();
	
	public static WebDriver driver;
	
	Reporting reporting = new Reporting();
	
	public static Logger logger;
	
	
	@Parameters("browser")                //Run Test Case on Desired Browser------->we need to use TestNG.xml file and pass browser as parameter 
	@BeforeClass                          //in TestNG.xml file. And in the test case we have 
	public void setup(String br)
	{
		logger = Logger.getLogger(BaseClass.class);
		//PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "log4j.properties");
		PropertyConfigurator.configure("log4j.properties");
		
		//C:\Users\rkamo\eclipse-workspace\DemoProjecteCommerce = System.getProperty("user.dir")-----> project home directory
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver= new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver =new FirefoxDriver();
		}
		else if(br.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", readconfig.getEdgePath());
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		
		
		driver.get(readconfig.getApplicationURL());
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws Throwable
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		File destPath = new File(destinationFile);
		FileUtils.copyFile(source, destPath);
		return destinationFile;
	}
	
	


}
