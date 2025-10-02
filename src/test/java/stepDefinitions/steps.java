package stepDefinitions;


import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.AddCustomer;
import PageObjects.LoginPage;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class steps extends stepBaseclase
{

	  
    
	 @Given("User Launch Chrome browser")
	 public void user_launch_chrome_browser() {
	    
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\mdjab\\eclipse-workspace\\Cucumber_Framework\\Drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 lp=new LoginPage(driver);
		 addcust=new AddCustomer(driver);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		
	 }
	 @When("User open URL {string}")
	 public void user_open_url(String string) {
	   
		 driver.get(string);
	 }
	 @When("User enters Email as {string} and Password as {string}")
	 public void user_enters_email_as_and_password_as(String email, String pass) {
	  
		 lp.setEmail(email);
		 lp.setPassword(pass);
	 }
	 @When("Click on Login")
	 public void click_on_login() {
	   lp.click_check();
	   lp.login_button();
	 }
	 
	 
@Then("Page Title should be {string}")
public void page_title_should_be(String Title) 
{
	System.out.println("printing Expected from feature file "+Title);
	
	String actual_title=driver.getTitle();
	
	System.out.println("printing actual title from application "+actual_title);
	
    if(actual_title.contains("nopCommerce"))
    {
       
        Assert.assertTrue(true);   
    }
    else
    {
    	 Assert.assertTrue(false); 
    }
	
}

@Then("User can view Dashboard")
public void user_can_view_dashboard() {
    
	String Title=driver.getTitle();
    if(driver.getPageSource().contains(Title))
    {
    	Assert.assertTrue(true);
    }
}
@Then("User Click on customers Menu")
public void user_click_on_customers_menu() {
    
	addcust.click_customer_menu();
}
@Then("Click on customers Menu Item")
public void click_on_customers_menu_item() {
    
	addcust.click_customer();
}
@Then("Click on Add new button")
public void click_on_add_new_button() {
    
   addcust.click_addnew(); 
}  
@Then("User can view Add new customer Page")
public void user_can_view_add_new_customer_page() {
    
    String addPage="Add a new customer";
    
    String actual_page=addcust.getAddNewCustomerText();
    
    if(actual_page.contains(addPage))
	
    {
    	Assert.assertTrue(true);
	}
	else
	{
		Assert.assertTrue(false);
    }
    
}
@When("User enter customer info")
public void user_enter_customer_info() throws Exception {
    
	String emil=stepBaseclase.RanString()+"@gmail.com";
	addcust.setEmail(emil);
	addcust.setPassword("test123");
	addcust.send_FirstName("Jabi");
	addcust.send_LastName("Vulla");
	addcust.MaleOption();
	addcust.send_AdminComment("This is for testing");
	addcust.send_CompanyName("Olive");
	addcust.send_Newsletter();
	addcust.click_IsTaxExempt();
	addcust.closereg();
	addcust.Activecheckbox();
	addcust.ChangePassword();
	
    
}
@When("Click on Save button")
public void click_on_save_button() throws InterruptedException {
    
	addcust.click_save();
    
}
@Then("User can view confirmation message {string}")
public void user_can_view_confirmation_message(String msg) {
    
	Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
 
}
@When("User click on Log out link")
public void user_click_on_log_out_link() {
   lp.click_logout();
}

@Then("Close browser")
public void close_browser() {
	if (driver != null) {
        driver.quit();
    }
}




	
	
}