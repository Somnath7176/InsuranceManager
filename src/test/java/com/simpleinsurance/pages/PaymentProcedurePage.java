package com.simpleinsurance.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentProcedurePage {

	WebDriver driver;

	public PaymentProcedurePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Weiter zur Bezahlung']")
	WebElement paymentBtn;

	public PaymentDetailsPage clickOnContinueToPayment() {
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.elementToBeClickable(paymentBtn));
		paymentBtn.click();
		return new PaymentDetailsPage(driver);
	}

}
