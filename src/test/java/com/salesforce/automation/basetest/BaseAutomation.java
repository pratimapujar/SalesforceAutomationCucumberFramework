package com.salesforce.automation.basetest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.salesforce.automation.utilities.CommonUtilities;
//import com.salesforce.automation.utilities.GenerateReports;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseAutomation extends CommonUtilities {
	/*public static WebDriver driver = null;
	public static String path;
	//public static GenerateReports report = null;
	
	@Before(order=0)
	public void setupBefore() {
		// report = GenerateReports.getInstance();
		// GenerateReports.startExtentReport();
		try {
			browserSel("chrome");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// GenerateReports.StartSingleTestReport("test1");
		try {
			goToURL();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		untilPageLoad();
		
	}
	
		@After
	public static void afterMethod() {
		//report.logTestInfo("after method execution is started");
		try {
			closeDriver();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static void browserSel(String browser) throws Exception {

		switch (browser) {

		case "chrome":
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("None of the chrome, edge or firefox browser selected");
		}
	}

	

	public static void goToURL() throws InterruptedException {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	}
	
	public static void untilPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
	}
	
	public static void closeDriver() throws Exception {
		Thread.sleep(3000);
		driver.close();
	}

*/	
}