package POM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.File_Utility;

public class basedataPOM {

	  //constructor call
	public basedataPOM(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	 public File_Utility fu=new File_Utility();
	
    //Declaration of webElement/locator
	@FindBy(xpath="//input[@name=\"user_name\"]")
	private WebElement username;
	
	@FindBy(xpath="//input[@name=\"user_password\"]")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement submitBtn;
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement logoutCursor;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logout;
	
	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getLogoutCursor() {
		return logoutCursor;
	}

	public WebElement getLogout() {
		return logout;
	}
	
	public void LoginApp() throws IOException {
		String username1 = fu.propertyData("user");
		String password1 = fu.propertyData("pass");
		username.sendKeys(username1);
		password.sendKeys(password1);
		submitBtn.click();		
		
	}
	
	public void logoutApp() throws InterruptedException {
		 Thread.sleep(2000);
		logoutCursor.click();
		 Thread.sleep(2000);
		logout.click();
	}
	
}
