package ApplicationLaunchTesting;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class AppLaunch {
	public static void main(String[]args) throws InterruptedException, IOException {
		
	//	System.setProperty("webdriver.edge.driver", "D:\\Training\\TestAutomation\\vTiger\\drivers\\msedgedriver.exe");
		

		
		//WebDriver driver=new EdgeDriver();
		ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--start-maximized");
		ch.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(ch);
		
		FileInputStream fis=new FileInputStream("D:\\Training\\TestAutomation\\vTiger\\src\\test\\resources\\vTigerData.properties");
		Properties ps=new Properties();
		ps.load(fis);
		String url = ps.getProperty("url");
		String user = ps.getProperty("username");
		String pass = ps.getProperty("password");
		driver.get(url);
		//Thread.sleep(4000);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(user);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(pass);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		WebElement opt = driver.findElement(By.xpath("//label[text()='User Role']/../..//div[text()=\"-- Select --\"]"));
		opt.click();
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(4000);
		WebElement data = driver.findElement(By.xpath("//input[@placeholder=\"Type for hints...\"]"));
		WebElement usern = driver.findElement(By.xpath("//label[text()='Username']/../..//input[@class=\"oxd-input oxd-input--active\"]"));
		usern.sendKeys("James");
		FileInputStream fis1=new FileInputStream("./src/test/resources/vTigerExcelData.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String nam = cell.getStringCellValue();
		
		data.sendKeys(nam);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//P[@class=\"oxd-userdropdown-name\"]")).click();
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
	   
	    
		
	}

}
