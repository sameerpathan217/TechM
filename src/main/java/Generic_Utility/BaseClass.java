package Generic_Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import POM.basedataPOM;

public class BaseClass {
	public static WebDriver sdriver;
	 public WebDriver driver;
	 public File_Utility fu=new File_Utility();
	 public basedataPOM bdp;
	 
	 
	@BeforeSuite(groups={"sanity","smoke"})
	public void connectToDB() {
		System.out.println("Database is fetched successfully");
	}
	
	//@Parameters("Browser")
	@BeforeClass(groups={"sanity","smoke"})
	public void launchApplication() throws IOException {
		System.out.println("Browser is launched successfully");
		 
		 String data = fu.propertyData("Browser");
		 String url = fu.propertyData("vturl");
		 
		if(data.equals("chrome")) {
			driver=new ChromeDriver();
			driver.get(url);
			
		}else if(data.equals("edge")){
			System.setProperty("webdriver.edge.driver", "D:\\Training\\TestAutomation\\vTiger\\drivers\\msedgedriver.exe");

			driver=new EdgeDriver();	
			driver.get(url);
			
		}else {
			System.out.println("Wrong browser selected");
		}
		sdriver=driver;
	}
	
	@BeforeMethod(groups={"sanity","smoke"})
	public void loginApplication() throws InterruptedException, IOException {
	
		 System.out.println("User is logged in successfully");
		  bdp=new basedataPOM(driver);
		  bdp.LoginApp();
		
	}
	
	@AfterMethod(groups={"sanity","smoke"})
	public void logoutApplication() throws InterruptedException {
		System.out.println("User is log-out successfully");
	     bdp	=new basedataPOM(driver);
		 bdp.logoutApp();

	}
	
	@AfterClass(groups={"sanity","smoke"})
	public void closeApplication() {
		System.out.println("Browser closed");
	}
	
	@AfterSuite(groups={"sanity","smoke"})
	public void closeTheDB() {
		System.out.println("Database connection closed");
	}
 }
