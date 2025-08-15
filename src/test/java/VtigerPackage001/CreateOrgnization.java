package VtigerPackage001;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import POM.OrgnizationPOM;

@Listeners(Generic_Utility.ListnerImpClass.class)
public class CreateOrgnization extends BaseClass {
   @Test(groups="smoke")
	public void logintoApp() throws InterruptedException, EncryptedDocumentException, IOException {
	 
	   OrgnizationPOM op=new OrgnizationPOM(driver);  
	   op.addData(driver);
		System.out.println("Sameer pathan: Great english speaker");
	}
   
}
