package com.simpleinsurance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='country-select']")
	WebElement countrySelectDrop;

	@FindBy(xpath = "//li[@data-value='DE']")
	WebElement countrySelect;

	@FindBy(xpath = "//div[@id='product-name-select']")
	WebElement productNameSelectDrop;

	@FindBy(xpath = "//li[@data-value='Nokia_v1Allianz_global']")
	WebElement productSelect;

	@FindBy(xpath = "//div[@id='tariff-name-select']")
	WebElement tariffNameSelectDrop;

	@FindBy(xpath = "//li[contains(@data-value,'1-34-Nokia')]")
	WebElement tariffSelect;

	@FindBy(xpath = "//div[@id='category-name-select']")
	WebElement categorySelectDrop;

	@FindBy(xpath = "//li[contains(@data-value,'CATEGORY')]")
	WebElement categorySelect;

	@FindBy(xpath = "//div[@id='duration-select']")
	WebElement periodSelectDrop;

	@FindBy(xpath = "//li[contains(@data-value,'12 month')]")
	WebElement periodSelect;

	@FindBy(xpath = "//div[@id='frequency-select']")
	WebElement paymentTypeSelectDrop;

	@FindBy(xpath = "//li[contains(@data-value,'12 month')]")
	WebElement paymentTypeSelect;

	@FindBy(xpath = "//div[@id='class-name-select']")
	WebElement classNameSelectDrop;

	@FindBy(xpath = "//li[contains(@data-value,'PDCODE677395')]")
	WebElement classSelect;

	@FindBy(xpath = "//input[@id='input-createCertificate_serialNumber']")
	WebElement serialNumber;

	@FindBy(xpath = "//input[@id='input-createCertificate_deviceName']")
	WebElement deviceName;

	@FindBy(xpath = "//input[@id='input-createCertificate_invoiceNumber']")
	WebElement invoiceNumber;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextBtnProductTab;
	
	public void selectCountry() {
		countrySelectDrop.click();
		countrySelect.click();
	}

	public void selectProduct() {
		productNameSelectDrop.click();
		productSelect.click();
	}

	public void selectTariff() {
		tariffNameSelectDrop.click();
		tariffSelect.click();
	}

	public void selectCategory() {
		categorySelectDrop.click();
		categorySelect.click();
	}

	public void selectPeriod() {
		periodSelectDrop.click();
		periodSelect.click();
	}

	public void selectPayment() {
		paymentTypeSelectDrop.click();
		paymentTypeSelect.click();
	}

	public void selectClass() {
		classNameSelectDrop.click();
		classSelect.click();
	}

	public void enterSerialNumber(String serialNum) {
		serialNumber.sendKeys(serialNum);
	}

	public void enterDeviceName(String device) {
		deviceName.sendKeys(device);
	}

	public void enterInvoiceNumber(String number) {
		invoiceNumber.sendKeys(number);
	}
	
	public void clickOnNextTab() {
		nextBtnProductTab.click();
	}

	public CustomerPage selectProductInfo(String serialNum, String deviceName, String invoiceNum) {
		selectCountry();
		selectProduct();
		selectTariff();
		selectCategory();
		selectPeriod();
		selectPayment();
		selectClass();
		enterSerialNumber(serialNum);
		enterDeviceName(deviceName);
		enterInvoiceNumber(invoiceNum);
		clickOnNextTab();
		return new CustomerPage(driver);
	}
}
