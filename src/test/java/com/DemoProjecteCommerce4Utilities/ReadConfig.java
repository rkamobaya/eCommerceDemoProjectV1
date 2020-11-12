package com.DemoProjecteCommerce4Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro; 
	
	public ReadConfig()
	{
		
		File src = new File("./Configuration/config.properties");    //Creates a new File instance by converting the given pathname string 
																	 // into an abstract pathname.
		
		try
		{
			FileInputStream fis = new FileInputStream(src);      //Open the file in a read mode
			pro=new Properties();
			pro.load(fis);                                       //Load the complete file in the runtime
			
		}
		catch(Exception e)										//And suppose if the file is not available at that location, there is chance to get an exception
		{                                                       //That's why we put this statement in try/catch
			System.out.println("Exception is " + e.getMessage());
		}
		
		
		
	}
	
	//Once the property file is loaded then we need to read each every value by adding a method.
	//We need a method for each every variable.
	//To load and read values in property file we have to use pro object, object of class property, along with getProperty() method.
	//After we create those methods then we need to go to the BaseClass to do some modifications. In fact in the BaseClass we should not hardcode.
	
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getEmail()
	{
		String email = pro.getProperty("emailAddress");
		return email;
	}
	
	public String getPassword()
	{
		String pass= pro.getProperty("password");
		return pass;
	}
	
	public String getChromePath()
	{
		String chrome= pro.getProperty("ChromePath");
		return chrome;
	}
	
	public String getFirefoxPath()
	{
		String firefox = pro.getProperty("FirefoxPath");
		return firefox;
	}
	
	public String getEdgePath()
	{
		String edge = pro.getProperty("EdgePath");
		return edge;
	}
	
	
	
	
	
	
	

}
