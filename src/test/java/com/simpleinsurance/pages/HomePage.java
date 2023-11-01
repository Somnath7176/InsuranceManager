package com.simpleinsurance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[contains(text(),'New')]")
	WebElement newBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Import')]")
	WebElement importBtn;
	
	@FindBy(xpath = "//button[contains(@aria-label,'Menu')]")
	WebElement languageMenu;
	
	@FindBy(xpath = "//span[contains(text(),'Englis')]")
	WebElement engLanguage;
	
	public void changeLanguage() {
		languageMenu.click();
		engLanguage.click();
	}
	
	public ProductPage clickOnNewBtn() {
		changeLanguage();
		newBtn.click();
		return new ProductPage(driver);
	}
	
	public ImportInsurancesPage clickOnImportBtn() {
		changeLanguage();
		importBtn.click();
		return new ImportInsurancesPage(driver);
	}
}
