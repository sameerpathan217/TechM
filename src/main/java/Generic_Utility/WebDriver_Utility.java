package Generic_Utility;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility {
  

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
	}
	
	public void explicitWait(WebDriver driver,WebElement ele) {
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}	
	
	public void selectDropdown(WebElement ele,String text) {
		Select sat=new Select(ele);
		sat.selectByContainsVisibleText(text);
		
	}
	
	public void mouseAction(WebDriver driver,WebElement ele) {
		Actions ac=new Actions(driver);
		ac.moveToElement(ele).perform();
	}
	
	public void acceptAlert(WebDriver driver) {
		Alert al=driver.switchTo().alert();
		al.accept();
	}

}
