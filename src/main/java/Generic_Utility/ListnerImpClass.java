package Generic_Utility;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListnerImpClass implements ITestListener {

	public void onTestFailure(ITestResult result) {
		String name = result.getMethod().getMethodName();
		
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File dest=new File("./Screenshot/"+ name +".png");
				try {
					Files.copy(src.toPath(), dest.toPath());
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	}
	
	

}
