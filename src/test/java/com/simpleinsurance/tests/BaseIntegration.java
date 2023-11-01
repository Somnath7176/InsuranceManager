package com.simpleinsurance.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.simpleinsurance.utils.TestUtils;

public class BaseIntegration {

	WebDriver driver;
	Properties prop;
	TestUtils test = new TestUtils();

	@BeforeSuite
	public void doSetup() throws IOException {
		prop = test.readProp();
		if (prop.getProperty("browser").equals("chrome")) {
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("siteUrl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@DataProvider
	public Object[] testData() throws IOException {
		
		return test.readData("Sheet1");
	}
	
	@AfterSuite
	public void tearDown() {
		//driver.close();
	}
	
}
