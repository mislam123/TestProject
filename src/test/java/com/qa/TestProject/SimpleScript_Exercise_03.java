package com.qa.TestProject;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class SimpleScript_Exercise_03 {
	
	
	// this script does not follow any Automation framework strategy. It’s a stand-alone test script that can be run independently.

	AppiumDriver driver;

		@BeforeTest
		public void SetUp() throws Exception {

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("device", "Android");
			cap.setCapability("deviceName", "Galaxy J7");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "6.0.1");
			File app = new File("AppFile/idealo.apk");
			cap.setCapability("app", app.getAbsolutePath());
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
		@Test
		public void AndroidAuto(){
			driver.findElement(By.id("de.idealo.android:id/search_src_text")).sendKeys("Apple iPad Pro 9.7 32GB");
			driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]")).click();
			driver.findElement(By.xpath("//android.widget.LinearLayout/android.support.v7.app.ActionBar.Tab[2]/android.widget.TextView")).click();
			String rating = driver.findElement(By.id("de.idealo.android:id/tv_product_tests")).getText();
			System.out.println("Tablet rating is : " + rating);
			String price = driver.findElement(By.xpath("//android.widget.FrameLayout[3]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
			System.out.println("The third lowest price of the tablet is : " +  price);
			// TimeUnit.SECONDS.sleep(5);
	}
	
	
		@AfterTest
		public void TearDown(){
			driver.quit();
		}
	}

	
