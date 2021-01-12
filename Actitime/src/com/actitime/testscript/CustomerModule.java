package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.generics.WebDriverCommonLib;
import com.actitime.objectrepository.EnterTimeTrackPage;
import com.actitime.objectrepository.TaskPage;


@Listeners(com.actitime.generics.ListenserImplementation.class)
public class CustomerModule extends BaseClass {
	
       
	@Test
		public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
			
    	   WebDriverCommonLib lb=new WebDriverCommonLib();
    	   lb.waitForElementInGui(driver);
    	   
    	   FileLib l=new FileLib();
    	   
    	   EnterTimeTrackPage et=new EnterTimeTrackPage(driver);
    	   et.getTask().click();
    	   
    	   TaskPage ts=new TaskPage(driver);
    	   String cname = l.getExcelValue("CreateCustomer", 1, 2);
    	   String cdes = l.getExcelValue("CreateCustomer", 1, 3);
    	   String c = ts.setCreatingCustomer(cname, cdes);
    	   
    	   Assert.assertEquals(cname, c);
    		   
    	  
    	   
		}
	

}
