package ApplicationLaunchTesting;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



//Open a browser, go to https://www.saucedemo.com/
//log in using standard user credentials, sort products by price (low to high), and print the names and prices of the sorted products.


public class PracticeTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://www.saucedemo.com/");
		
	//Alert al=driver.switchTo().alert();
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(4000);
		WebElement opt = driver.findElement(By.xpath("//select[@class=\"product_sort_container\"]"));
		Select sat=new Select(opt);
		sat.selectByIndex(2);
		
		
		List<WebElement> name = driver.findElements(By.xpath("//div[@class=\"inventory_item_name \"]"));
		
		 List<WebElement> price = driver.findElements(By.xpath("//div[@class=\"inventory_item_price\"]"));
		int s=name.size();
		 for(int i=0;i<s;i++) {
			 String pname = name.get(i).getText();
			 String pprice = price.get(i).getText();
			 
			 System.out.println("Product price is "+pname+"=====>"+ pprice);
		 }
		
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,400)");
		 
	}
}
