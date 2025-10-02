package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddCustomer extends BaseClass{

	public WebDriver driver;
	JavascriptExecutor js;
	public AddCustomer(WebDriver driver) {
	      super(driver);	
	      this.driver = driver;
	      this.js = (JavascriptExecutor) driver;
	}
	
	//login  section
	@FindBy(xpath="//input[@type='email']") WebElement email; 
	@FindBy(xpath="//input[@type='password']") WebElement pass;
	
	
	@FindBy(xpath="//input[@type='checkbox']") WebElement check;
	
	@FindBy(xpath="//button[@type='submit']") WebElement button;
	
	
	// add customer section
	@FindBy(xpath="(//a//p[normalize-space(text())='Customers'])[1]") WebElement customer_menu;
	
	@FindBy(xpath="(//a//p[normalize-space(text())='Customers'])[2]") WebElement customer;
	
	@FindBy(xpath="//a[@class='btn btn-primary']/i") WebElement addnew;
	
	@FindBy(xpath="//h1[normalize-space(text())='Add a new customer']") WebElement addnewcustomertext;
	
	@FindBy(id ="SearchEmail") WebElement set_Email;
	
   @FindBy(xpath="//input[@id='Password']") WebElement password;
	
  	@FindBy(xpath="//input[@id='FirstName']" ) WebElement searchFirstName;
	
	@FindBy(xpath="//input[@id='LastName']") WebElement searchLastName;

	@FindBy(xpath="//input[@id='Gender_Male']") WebElement Male;  //Radio button
	
	@FindBy(xpath="//input[@id='Company']") WebElement CompanyName;
	
	@FindBy(xpath="(//input[@data-val='true' and  @class='check-box'])[1]") WebElement IsTaxExempt;
	
	@FindBy(xpath="(//input[@role='searchbox' and  @type='search'])[1]") WebElement Newsletter;
	
	@FindBy(xpath="//ul//span[@role='presentation']") WebElement close_Register;
	
	@FindBy(xpath="(//span[@class='select2-results']/descendant::li") WebElement CustomerType;	
	
	@FindBy(xpath="//select[@name='VendorId']") WebElement ManagerOfVendor;
	
	@FindBy(xpath="(//select[@name='VendorId']/descendant::option)[2]") WebElement Vender2;
	
	@FindBy(xpath="//input[@id='Active']") WebElement Active;
	
	@FindBy(xpath="//input[@id='MustChangePassword']") WebElement changePassword;
	
	@FindBy(xpath="//textarea[@id='AdminComment']") WebElement AdminComment;
	
	@FindBy(xpath="//div[@class='float-right']/descendant::button[@name='save']") WebElement save;
		
	 @FindBy(xpath="//li//a[text()='Logout']") WebElement logout;
	 
	 @FindBy(xpath="//ul//li[text()='nopCommerce admin demo store']") WebElement nopCommerce_text;
	
	 //action methods for login
	 public void setEmail(String UserEmail)
	{
		email.clear();
		email.sendKeys(UserEmail);
	}
	
    public void setPassword(String UserPassword)
	{
    	pass.clear();
		pass.sendKeys(UserPassword);
	}
	
	public void click_check()
	{
		check.click();
	}
	
	public void login_button()
	{
		button.click();
	}

	 //action methods for add customer
	
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public void click_customer_menu()
	{
		customer_menu.click();
		
	}
	public void click_customer()
	{
		customer.click();
		
	}
	
	public void click_addnew()
	{
		addnew.click();
		
	}
	
	
	public void send_Email(String email) throws InterruptedException
	{
		set_Email.sendKeys(email);
		
		Thread.sleep(2000);
	}
	public void send_Password(String passwd)
	{
		password.sendKeys(passwd);
		
		
	}
	public void send_FirstName(String FirstName) throws Exception
	{
		searchFirstName.sendKeys(FirstName);
		
		Thread.sleep(2000);
	}
	
	public void send_LastName(String LastName)
	{
		searchLastName.sendKeys(LastName);
		
		
	}
	
	public void MaleOption() throws InterruptedException
	{
		Male.click();
		Thread.sleep(2000);	
	}
	
	public void send_CompanyName(String Cname)
	{
		CompanyName.sendKeys(Cname);
				
	}
	
	
	
	public void send_Newsletter() throws InterruptedException
{
		Newsletter.click();
		Thread.sleep(2000);
		nopCommerce_text.click();
				
	}
	
	public void click_IsTaxExempt() throws InterruptedException
	{
		IsTaxExempt.click();
		Thread.sleep(2000);
	}


public void closereg() throws InterruptedException
{
	close_Register.click();
	Thread.sleep(2000);	
}

  public void Select_customertype() throws InterruptedException
  {
	  Select sc=new Select(CustomerType);
	  
	  for(int i=0; i<sc.getOptions().size(); i++)
	  {
		 if(sc.getOptions().get(i).getText().equals("Guests"))
		 {
			 sc.selectByIndex(i);
			 System.out.println("Selected Customer Type is : "+sc.getOptions().get(i).getText());
			 Thread.sleep(2000);
		 }
	  }
  }
  
  
  public void Activecheckbox() throws InterruptedException
  {
	  Active.click();
	  Thread.sleep(2000);
  }
  
  public void ManagerVendor() throws InterruptedException
  {
	  
	  ManagerOfVendor.click();
	  Thread.sleep(2000);
	  Vender2.click();
	  
	  
  }
  public void ChangePassword() throws InterruptedException
  {
	  changePassword.click();
	  Thread.sleep(2000);
  }
  
  
  public void send_AdminComment(String comment)
  {
      js.executeScript("arguments[0].scrollIntoView(true);", AdminComment);
      AdminComment.sendKeys(comment);
  }
  
  public void click_save() throws InterruptedException
  {
	  save.click();
	  Thread.sleep(2000);
  }
  
  
  
  
  
  
	public String getAddNewCustomerText()
	{
		return addnewcustomertext.getText();
	}
	
}