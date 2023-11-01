package com.simpleinsurance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//label[@class='MuiFormControlLabel-root'])[1]/span[1]/span/input")
	WebElement allInfoCheckBox;
	
	@FindBy(xpath = "(//label[@class='MuiFormControlLabel-root'])[2]/span[1]/span/input")
	WebElement customerCheckBox;
	
	@FindBy(xpath = "(//label[@class='MuiFormControlLabel-root'])[3]/span[1]/span/input")
	WebElement infoCheckBox;
	
	@FindBy(xpath = "(//label[@class='MuiFormControlLabel-root'])[4]/span[1]/span/input")
	WebElement insuredCheckBox;
	
	@FindBy(xpath = "//span[contains(text(),'Create insurance')]")
	WebElement createInsuranceBtn;
	
	public PaymentProcedurePage selectAllCheckBoxes() {
		allInfoCheckBox.click();
		customerCheckBox.click();
		infoCheckBox.click();
		insuredCheckBox.click();
		createInsuranceBtn.click();
		return new PaymentProcedurePage(driver);
	}
	
	
}
