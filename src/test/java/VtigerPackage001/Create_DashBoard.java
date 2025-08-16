package VtigerPackage001;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import POM.DashboardPOM;

public class Create_DashBoard extends BaseClass {
	
	@Test(groups="smoke")
	public void dashboardTest() throws EncryptedDocumentException, IOException {
		
		DashboardPOM dp=new DashboardPOM(driver);
		dp.dashboardOption(driver);
		
	}

}
