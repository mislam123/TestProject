package com.qa.TestProject;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;


public class MobileAutomationExercise_03 extends BaseTest {
	Properties prop = new Properties();
	
	@Test
	public void AndroidAutomation() throws Exception{
				
		FileInputStream fis = new FileInputStream("Resource/config.properties");
	    prop.load(fis);
		
	    	TypeByID(prop.getProperty("searchBoxId"),prop.getProperty("EnterText"));
	    	ClickByXpath(prop.getProperty("selectDeviceXpath"));
		    ClickByXpath(prop.getProperty("OFFERS_xpath"));
		    String rating = GetTextByID(prop.getProperty("getRatingId"));
		    System.out.println("Tablet rating is : "+ rating);
		    reporter.log(LogStatus.INFO, "Tablet rating is : "+ rating);
		    String price = GetTextByXpath(prop.getProperty("getPriceXpath"));
		    System.out.println("The third lowest price of the tablet is : " +  price);
		    reporter.log(LogStatus.INFO, "The third lowest price of the tablet is : " +  price);

		    //TimeUnit.SECONDS.sleep(5);
		   
	}
}
