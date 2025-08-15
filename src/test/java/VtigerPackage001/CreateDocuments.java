package VtigerPackage001;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import POM.DocumentsPOM;

@Listeners(Generic_Utility.ListnerImpClass.class)
public class CreateDocuments extends BaseClass{
	
	@Test(retryAnalyzer=Generic_Utility.Retry_Analyzer.class)
	public void testDocument() throws EncryptedDocumentException, IOException {
		DocumentsPOM dpm=new DocumentsPOM(driver);
		Assert.assertEquals(false, true);
		dpm.createDocument(driver);
		
		System.out.println("push the latest code to githhub");
		System.out.println("Hi newwwwwwwwwwww branch");
		System.out.println();

		System.out.println("Sammer pathan: Great team manager with lots of energy");
		

	}

}
