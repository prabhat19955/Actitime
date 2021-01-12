package com.actitime.generics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenserImplementation extends BaseClass implements ITestListener {

	
	public void onTestStart(ITestResult result) {
		
	}

	
	public void onTestSuccess(ITestResult result) {
		
	}

	
	public void onTestFailure(ITestResult arg) {
		String result=arg.getName();
		TakesScreenshot t=(TakesScreenshot) driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenSort/"+result+".png");
		try {
			FileUtils.copyFile(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	public void onTestSkipped(ITestResult result) {
		
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		
	}

	
	public void onFinish(ITestContext context) {
		
	}

	
}
