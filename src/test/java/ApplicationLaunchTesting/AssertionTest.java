package ApplicationLaunchTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {
	
	@Test
	public void testAssertion() {
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		WebElement user = driver.findElement(By.id("user-name"));
		user.sendKeys("standard_user");
		WebElement pass = driver.findElement(By.id("password"));
		pass.sendKeys("secret_sauce");
		
          Assert.assertNotEquals(user, pass);
		driver.findElement(By.id("login-button")).click();
		
	}

}
