package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.objectrepository.EnterTimeTrackPage;
import com.actitime.objectrepository.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
		Reporter.log("open the browser", true);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void closeBrowser() {
		Reporter.log("close the browser", true);
		driver.close();
	}
	
	@BeforeMethod
	public void login() throws IOException {
		FileLib f=new FileLib();
		Reporter.log("login to the application", true);
		String un = f.getPropertyValue("username");
		String pw = f.getPropertyValue("password");
		driver.get(f.getPropertyValue("url"));
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
		
	}
	
	@AfterMethod
	public void logout() {
		Reporter.log("logout of the application", true);
		
		EnterTimeTrackPage et=new EnterTimeTrackPage(driver);
		et.getLobtn().click();
		
	}

}
