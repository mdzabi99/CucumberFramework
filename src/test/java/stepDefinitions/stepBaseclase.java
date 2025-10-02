package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomer;
import PageObjects.LoginPage;

public class stepBaseclase {
	 public WebDriver driver;
	 public LoginPage lp;
	 public AddCustomer addcust;
	
	public static String RanString()
	{
		String GenString = RandomStringUtils.randomAlphabetic(5);
	   return GenString;
		
	}
}
