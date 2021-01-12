package com.actitime.objectrepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.generics.WebDriverCommonLib;

public class TaskPage extends BaseClass {
	
	@FindBy(xpath="//div[.='Add New']")
	private WebElement addnew;
	
	@FindBy(xpath="//div[.='+ New Customer']")
	private WebElement newcustomer; 
	
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement customername;
	
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
	private WebElement customerdescription;
	
	@FindBy(xpath="(//div[.='- Select Customer -'])[2]")
	private WebElement selectcustomer;
	
	@FindBy(xpath="//div[.='Our company' and @class='itemRow cpItemRow ']")
	private WebElement selectcompany;
	
	@FindBy(xpath="//div[.='Create Customer']")
	private WebElement createbtn;
	
	@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[1]")
	private WebElement check;
	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String setCreatingCustomer(String cn, String cd) throws EncryptedDocumentException, IOException {
		FileLib l=new FileLib();
		WebDriverCommonLib lb=new WebDriverCommonLib();
		lb.waitForElementInGui(driver);
		addnew.click();
		newcustomer.click();
		customername.sendKeys(cn);
		customerdescription.sendKeys(cd);
		selectcustomer.click();
		selectcompany.click();
		createbtn.click();
		lb.waitForElement(driver, check, "title", l.getExcelValue("CreateCustomer", 1, 2));
		String cc = check.getText();
		return cc;
		
		
	}

}
