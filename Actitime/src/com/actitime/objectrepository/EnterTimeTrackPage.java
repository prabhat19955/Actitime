package com.actitime.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.BaseClass;

public class EnterTimeTrackPage extends BaseClass {
	
	@FindBy(xpath="//a[@class='logout']")
	private WebElement lobtn;
	
	@FindBy(id="container_tasks")
	private WebElement task;
	
	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLobtn() {
		return lobtn;
	}

	public WebElement getTask() {
		return task;
	}

	
	
	
}
