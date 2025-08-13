package POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import Generic_Utility.WebDriver_Utility;

public class OrgnizationPOM {
	
	public OrgnizationPOM(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//create privateWebElement(it is known as encapsulation)
	@FindBy(xpath="//td[@class=\"tabSelected\"]/..//a[text()='Organizations']")
	private WebElement orgTabClick;

	@FindBy(xpath="//img[@alt=\"Create Organization...\"]")
	private WebElement createOrg;
	
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgName;
	
	@FindBy(xpath="//select[@name=\"industry\"]")
	private WebElement selectIndustry;
	
	@FindBy(xpath="//b[text()='Description Information']/following::input[@title=\"Save [Alt+S]\"]")
	private WebElement saveInfo;
	
	//Convert private Webelement to public 
	public WebElement getOrgTabClick() {
		return orgTabClick;
	}

	public WebElement getCreateOrg() {
		return createOrg;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSelectIndustry() {
		return selectIndustry;
	}

	public WebElement getSaveInfo() {
		return saveInfo;
	}
	WebDriver_Utility wu=new WebDriver_Utility();
	Java_Utility ju=new Java_Utility();
	
	Excel_Utility eu=new Excel_Utility();
	
	public void addData(WebDriver driver) throws InterruptedException, EncryptedDocumentException, IOException {
		wu.implicitWait(driver);
		int num = ju.randonNum();
		orgTabClick.click();
		createOrg.click();
		
		String data = eu.excelFormat("Sheet1",3,0);
		orgName.sendKeys(data+""+num);
		WebElement si = selectIndustry;
		
		wu.selectDropdown(si,"Banking");
		saveInfo.click();
		
	}
}
