package POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Excel_Utility;
import Generic_Utility.File_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;

public class ProductPOM {

	public ProductPOM(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//declare all the webelement in private
	
	@FindBy(xpath="//img[@src=\"themes/softed/images/Home.PNG\"]/../../..//a[text()='Products']")
	private WebElement productClick;

	@FindBy(xpath="//img[@alt=\"Create Product...\"]")
	private WebElement createProduct;
	
	@FindBy(xpath="//input[@name=\"productname\"]")
	private WebElement productName;
	
	
	@FindBy(id="productcode")
	private WebElement productCode;
	
	@FindBy(xpath="//input[@title=\"Save [Alt+S]\"]")
	private WebElement  saveButton;
	
	
	public WebElement getProductClick() {
		return productClick;
	}

	public WebElement getCreateProduct() {
		return createProduct;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCode() {
		return productCode;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	WebDriver_Utility wu=new WebDriver_Utility();
	File_Utility fu=new File_Utility();
	Java_Utility ju=new Java_Utility();
	Excel_Utility eu=new Excel_Utility();
	
	public void createProduct(WebDriver driver) throws EncryptedDocumentException, IOException {
		wu.implicitWait(driver);
		int data = ju.randonNum();
		wu.implicitWait(driver);
		
        String pname = eu.excelFormat("Sheet1", 3, 1);
        String pcode = eu.excelFormat("Sheet1", 3, 2);
        productClick.click();
		createProduct.click();
		productName.sendKeys(pname+""+data);
		productCode.sendKeys(pcode);
	}
	
}
