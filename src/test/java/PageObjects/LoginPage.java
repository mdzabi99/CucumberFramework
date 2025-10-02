package PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {

	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	
	}
	
	@FindBy(xpath="//input[@type='email']") WebElement email; 
	@FindBy(xpath="//input[@type='password']") WebElement pass;
	
	@FindBy(xpath="//input[@type='checkbox']") WebElement check;
	
	@FindBy(xpath="//button[@type='submit']") WebElement button;
	
	@FindBy(xpath="//li//a[text()='Logout']") WebElement logout;	
	
	
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
	
	public void click_logout() {
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(logout));
	        wait.until(ExpectedConditions.elementToBeClickable(logout));
	        logout.click();
	    } catch (Exception e) {
	        System.err.println("Logout link not found or not clickable: " + e.getMessage());
	        // Optionally, take a screenshot or print page source for debugging
	        throw e;
	    }
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
