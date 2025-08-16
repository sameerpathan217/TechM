package POM;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utility.Excel_Utility;
import Generic_Utility.WebDriver_Utility;

public class DashboardPOM {

	//Created constructor
	public DashboardPOM(WebDriver driver) {
	  PageFactory.initElements(driver,this);
	}
	//Write a webelement as private 
	@FindBy(xpath="//a[text()='Dashboard']")
	private WebElement dashboardClk;
	
	@FindBy(id="dashboard_combo")
	private WebElement dashboardDropdown;
	
	//convert private Webelement to public
	public WebElement getDashboardClk() {
		return dashboardClk;
	}

	public WebElement getDashboardDropdown() {
		return dashboardDropdown;
	}
	
	///make a method to call in script by using the public webelement data
	
	WebDriver_Utility wu=new WebDriver_Utility();
	Excel_Utility eu=new Excel_Utility();
	
	public void dashboardOption(WebDriver driver) throws EncryptedDocumentException, IOException {
		wu.implicitWait(driver);
		dashboardClk.click();
		String exdata = eu.readExcelData("Sheet1", 9, 1);
		
		WebElement data = dashboardDropdown;
		wu.selectDropdown(data,exdata);
		
	}
}
