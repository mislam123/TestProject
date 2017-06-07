package com.qa.TestProject;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest extends ReportFactory {
	
	AppiumDriver driver = null;
	Properties prop = new Properties();
	public static ExtentTest reporter;

	@BeforeMethod(alwaysRun = true)
	public void SetUp(Method caller) throws Exception {
		FileInputStream fis = new FileInputStream("Resource/config.properties");
		prop.load(fis);
		try {
			reporter = ReportFactory.getTest(caller.getName(), "Test Details : ");
		}catch (Exception e) {
			System.out.println("Failed to initiate appium driver or reporter");
			e.printStackTrace();
		}
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("device", prop.getProperty("device"));
		cap.setCapability("deviceName", prop.getProperty("deviceName"));
		cap.setCapability("platformName", prop.getProperty("platformName"));
		cap.setCapability("platformVersion", prop.getProperty("platformVersion"));
		File app = new File(prop.getProperty("appPath"));
		cap.setCapability("app", app.getAbsolutePath());
		
//		cap.setCapability("appPackage", prop.getProperty("appPackage"));
//		cap.setCapability("launchActivity", prop.getProperty("launchActivity"));
//		cap.setCapability("appWaitActivity", prop.getProperty("appWaitActivity", "10000"));
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		reporter.log(LogStatus.INFO,  "*** Appiun server is up and running ****");
	}

	
	@AfterMethod(alwaysRun = true)
	public void TearDown() throws Exception {
		driver.quit();
		reporter.log(LogStatus.INFO,  "*** AppiunDriver is shutdown ****");
		ReportFactory.closeReport();
	}


	public void ClickByID(String id) {
		driver.findElement(By.id(id)).click();
	}

	public void ClickByXpath(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void TypeByID(String id, String txt) {
		driver.findElement(By.id(id)).sendKeys(txt);
	}

	public void TypeByXpath(String xpath, String txt) {
		driver.findElement(By.xpath(xpath)).sendKeys(txt);
	}

	public String GetTextByID(String id) {
		return driver.findElement(By.id(id)).getText();
	}

	public String GetTextByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}

}
