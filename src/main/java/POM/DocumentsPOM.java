package POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic_Utility.Excel_Utility;
import Generic_Utility.WebDriver_Utility;

public class DocumentsPOM {
	
	public DocumentsPOM(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Write all webelements as private
	@FindBy(xpath="//td[@class=\"tabUnSelected\"]/preceding::a[text()='Documents']")
	private WebElement documentsBtn;

	@FindBy(xpath="//img[@alt=\"Create Document...\"]")
	private WebElement createDocument;
	
	@FindBy(name="notes_title")
	private WebElement documentName;
	
	@FindBy(name="filelocationtype")
	private WebElement documentType;
	
	@FindBy(xpath="//select[@name=\"filelocationtype\"]/preceding::input[@title=\"Save [Alt+S]\"]")
	private WebElement documentSave;
	
	//conver private Webelement to public by using getters method
	public WebElement getDocumentsBtn() {
		return documentsBtn;
	}

	public WebElement getCreateDocument() {
		return createDocument;
	}

	public WebElement getDocumentName() {
		return documentName;
	}

	public WebElement getDocumentType() {
		return documentType;
	}

	public WebElement getDocumentSave() {
		return documentSave;
	}
	
	WebDriver_Utility wu=new WebDriver_Utility();
	Excel_Utility eu=new Excel_Utility();
	
	public void createDocument(WebDriver driver) throws EncryptedDocumentException, IOException {
		wu.implicitWait(driver);
		documentsBtn.click();
		createDocument.click();
		
		String data = eu.excelFormat("Sheet1", 6, 1);
		documentName.sendKeys(data);
		
		WebElement opt = documentType;
		
		wu.selectDropdown(opt,"External");
		
		documentSave.click();
	    	
	}

}
