package com.simpleinsurance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {

	WebDriver driver;
	
	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='firstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@name='lastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@name='streetName']")
	WebElement streetName;
	
	@FindBy(xpath = "//input[@name='streetNumber']")
	WebElement streetNumber;
	
	@FindBy(xpath = "//input[@name='zip']")
	WebElement zipCode;
	
	@FindBy(xpath = "//input[@name='city']")
	WebElement cityName;
	
	@FindBy(xpath = "//input[@name='country']")
	WebElement countryName;
	
	@FindBy(xpath = "//input[@name='taxCode']")
	WebElement taxCode;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextBtnCustomerTab;
	
	public void enterFName(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void enterLName(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void enterEmail(String uEmail) {
		email.sendKeys(uEmail);
	}
	
	public void enterStreetName(String uStreetName) {
		streetName.sendKeys(uStreetName);
	}
	
	public void enterStreetNumber(String uStreetNum) {
		streetNumber.sendKeys(uStreetNum);
	}
	
	public void enterZipCode(String uZipCode) {
		zipCode.sendKeys(uZipCode);
	}
	
	public void enterCityName(String uCityName) {
		cityName.sendKeys(uCityName);
	}
	
	public void enterCountryName(String uCountryName) {
		countryName.sendKeys(uCountryName);
	}
	
	public void enterTaxCode(String uCode) {
		taxCode.sendKeys(uCode);
	}
	
	public void clickOnNextTab() {
		nextBtnCustomerTab.click();
	}
	
	public ConfirmationPage enterCustomerInfo(String fName, String lName, String email, String street, String house, String pin, String city, String country, String taxCode) {
		enterFName(fName);
		enterLName(lName);
		enterEmail(email);
		enterStreetName(street);
		enterStreetNumber(house);
		enterZipCode(pin);
		enterCityName(city);
		enterCountryName(country);
		enterTaxCode(taxCode);
		clickOnNextTab();
		return new ConfirmationPage(driver);
	}
}
