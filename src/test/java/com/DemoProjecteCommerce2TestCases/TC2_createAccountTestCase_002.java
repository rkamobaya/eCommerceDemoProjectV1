package com.DemoProjecteCommerce2TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DemoProjecteCommerce1Pages.createAccountPage;
import com.DemoProjecteCommerce1Pages.eCommerceLoginPage;
import com.DemoProjecteCommerce4Utilities.XLUtils;

public class TC2_createAccountTestCase_002 extends BaseClass {      //In all the test cases we need 1st to extends the BaseClass
					                                            //Then we need to write the test method along with DataProvider.
	                                                             //The DataProvider method will provider the data to the test method.
	
	
	//Once the DataProvider is implemented, the test method should read the data and execute multiple of times based on number of inputs.
	//Here should specify one parameter which is dataProvider="createAccountData" in @Test annotation.
	
	@Test(dataProvider="createAccountData")
	public void createAccount(String Email, String Title, String FirstName, String LastName, String Password, String AddressFname, String AddressLname, String Street, String City, String State, String ZipCode, String Country,String mobilePhone, String addressAlias)
	{
		eCommerceLoginPage lp = new eCommerceLoginPage(driver);
		lp.toLoginWindow().click();
		lp.emailAddressSet().sendKeys(Email);
		lp.createAccountSubmitButton();
				
		createAccountPage ca = new createAccountPage(driver);
		
		if(Title=="Mr.")
		{
			ca.genderMaleSelect().click();
		}
		else if(Title=="Mrs.")
		{
			ca.genderFemaleSelect().click();
		}
		
		ca.setFirstName().sendKeys(FirstName);
		ca.setLastName().sendKeys(LastName);
		lp.emailAddressSet().sendKeys(Email);
		ca.setPassword().sendKeys(Password);
		ca.addressFirstNameSet().sendKeys(AddressFname);
		ca.addressLastNameSet().sendKeys(AddressLname);
		ca.addressStreetSet().sendKeys(Street);
		ca.addressCitySet().sendKeys(City);
		ca.addressStateSet().selectByVisibleText(State);
		ca.addressZipCodeSet().sendKeys(ZipCode);
		ca.addressCountrySelect().selectByVisibleText(Country);
		ca.addressMobilePhoneSet().sendKeys(mobilePhone);
		ca.addressAliasSet().sendKeys(addressAlias);
		
		ca.submitAccountButton().click();
		
		
	}
	
	

	//Internally this DataProvider method getData() will take the data from Excel file and store that in 2 dimensional array and 
	//finally it will return this 2 dimensional array to the actual test case
	@DataProvider(name="createAccountData")   
	public String [][] getData() throws IOException                         //String 2 dimension array is the return type of this method getData()              
	{
		//1st we need the path of the excel file - Where my excel file is present??? 
		String path = "C:\\Users\\rkamo\\eclipse-workspace\\DemoProjecteCommerce\\src\\test\\java\\com\\DemoProjecteCommerce3TestData\\eCommerceData.xlsx";
		
		//Then we need to read the data from the excel file. For that we need to count the number of rows and columns. For that we need to 
		//call the methods in the utility class XLUtils.java Since those methods are static we will call them directly will the class name.
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		//Then We need to create 2 dimension array to store the data. We create 2 dimension array with the same size as in excel sheet, same
		//name of rows and same number of columns. Later we will read the excel data and store the data in accountData[][].
		String accountData[][] = new String [rownum][colcount];
		
		//Now we need to write a for loop to get the data from excel sheet
		for(int i=1; i<=rownum; i++)                          //represent every row. Since i start with 1 index (not 0 index) means the 
													          //excel file sheet header is excluded
		{
			for(int j=0; j<colcount; j++)                     //represent every column. j start with 0 index means the 1st column is included
			{
				//By the time this for loop is completed this accountData[][] will contains all the data from excel file
				accountData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);   //I get the values from excel sheet and store in 2 dimension
			}                                             //array accountData[][]. i-1 because we eliminate the 1st row which is a header row.
				
		}
		//This 2 dimension array accountData[][] contains the data now. Now what to do is to return this 2 dimension array cad send this 
		//data to the test method.
		return accountData;
				
	}
	
	
	
	

}
