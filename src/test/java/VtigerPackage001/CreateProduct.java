package VtigerPackage001;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.BaseClass;
import POM.ProductPOM;

@Listeners(Generic_Utility.ListnerImpClass.class)
public class CreateProduct extends BaseClass {
	
	@Test(groups="sanity")
	public void testProduct() throws EncryptedDocumentException, IOException {
		ProductPOM pp=new ProductPOM(driver);	
		pp.createProduct(driver);
		
		System.out.println("Sameer pathan: $1000cr owner");

		System.out.println("Sameer pathan:Unstoppable SDET Engineer");
		System.out.println("===>Sameer khan pathan<===");	
		
		
		
	}

}
