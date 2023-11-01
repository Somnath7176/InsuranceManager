package com.simpleinsurance.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentDetailsPage {

	WebDriver driver;

	public PaymentDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='CardField-number CardField-child']")
	WebElement cardNumber;

	@FindBy(xpath = "//input[@name='exp-date']")
	WebElement expDate;

	@FindBy(xpath = "//input[@name='cvv']")
	WebElement cardCvv;

	@FindBy(xpath = "//span[text()='Kostenpflichtig bestellen']")
	WebElement makePayment;

	@FindBy(name = "__privateStripeFrame0446")
	WebElement frameElement;

	public void enterCardNumber(String cardNumberVal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[@class='CardField-number CardField-child']")));
		// driver.switchTo().frame("__privateStripeFrame0446");

		cardNumber.click();
		cardNumber.sendKeys(cardNumberVal);

	}

	public void enterExpDate(String mmYY) {
		expDate.sendKeys(mmYY);
	}

	public void enterCvv(String cvvValue) {
		cardCvv.sendKeys(cvvValue);
	}

	public void clickOnMakePayment() {
		makePayment.click();
	}

	public void completePayment(String cardNum, String expDate, String cvv) {
		enterCardNumber(cardNum);
		enterExpDate(expDate);
		enterCvv(cvv);
		clickOnMakePayment();
	}
}
