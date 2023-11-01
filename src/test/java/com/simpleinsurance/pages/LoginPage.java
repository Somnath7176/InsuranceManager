package com.simpleinsurance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "login_username")
	WebElement userName;
	
	@FindBy(id = "login_password")
	WebElement userPass;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement nextBtn;
	
	public void enterUserName(String uName) {
		userName.sendKeys(uName);
	}
	
	public void enterUserPass(String uPass) {
		userPass.sendKeys(uPass);
	}
	
	public void clickOnNext() {
		nextBtn.click();
	}
	
	public HomePage doLogin(String uName, String uPass) {
		enterUserName(uName);
		enterUserPass(uPass);
		clickOnNext();
		return new HomePage(driver);
	}
}
