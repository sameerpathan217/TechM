package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class vTiger_Extent_Report implements ITestListener {
	
	WebDriver driver;
	 ExtentReports report;
	 ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+"Is Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" Test case failed");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Sceenshot/"+result.getMethod().getMethodName()+".png");
		
		try {
			Files.copy(src.toPath(), dest.toPath());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+"Is skipped");
	}

	public void onStart(ITestContext context) {
		Date d=new Date();
	    System.out.println(d);
	    d.toString().replace("","-").replace("::", "-");
	    ExtentSparkReporter htmlreport=new ExtentSparkReporter(new File("extentreport.html"));
	    htmlreport.config().setDocumentTitle("Extent Report");
	    htmlreport.config().setTheme(Theme.DARK);
	    
	    report=new ExtentReports();
	    report.attachReporter(htmlreport);
	    report.setSystemInfo("OS", "WINDOWS 10");
	    report.setSystemInfo("Environment: ", "Testing Environment ");
	    report.setSystemInfo("Build version","5391123456");
	    report.setSystemInfo("URL ", "www.vtiger.com");
	    report.setSystemInfo("Repoeter Name", "Sameer pathan");   
		
	}
	public void onFinish(ITestContext context) {
		report.flush();
		}
	
	
}
