package ApplicationLaunchTesting;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ValidationTest {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		String parent=driver.getWindowHandle();
		
		String parenttit = driver.getTitle();
	System.out.println(parenttit);
	
	   Assert.assertEquals(parenttit,"Swag Labs" );
	   
	   System.out.println("Wecome to the world of swag labs");
	   
	   
	  
	   driver.findElement(By.xpath("//a[text()=\"LinkedIn\"]")).click();
	   
	   Set<String> child = driver.getWindowHandles();
	   
	   for(String s: child) {
		   String childtit = driver.switchTo().window(s).getTitle();
		  //System.out.println(childtit);
		  
		  if(childtit.equals(parenttit)) {
			  System.out.println("Parent window detected");
		  }else {
			  System.out.println("Wrong title");
		  }
			  
		  }
	   driver.switchTo().window(parent);	   }
	}


