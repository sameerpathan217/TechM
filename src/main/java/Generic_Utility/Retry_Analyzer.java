package Generic_Utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry_Analyzer implements IRetryAnalyzer {

	int count=0;
	int retry=3;
	
	public boolean retry(ITestResult result) {
		if(count<retry) {
			count++;
			return true;
		}
		return false;
	}   
}
