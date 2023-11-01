package com.simpleinsurance.tests;

import org.testng.annotations.Test;

import com.simpleinsurance.pages.ConfirmationPage;
import com.simpleinsurance.pages.CustomerPage;
import com.simpleinsurance.pages.HomePage;
import com.simpleinsurance.pages.ImportInsurancesPage;
import com.simpleinsurance.pages.LoginPage;
import com.simpleinsurance.pages.PaymentDetailsPage;
import com.simpleinsurance.pages.PaymentProcedurePage;
import com.simpleinsurance.pages.ProductPage;

public class SITest extends BaseIntegration{

	@Test(dataProvider = "testData")
	public void createSingleInsurancePolicy(String tName, String uName, String uPass, String serialNum, String deviceName, String invoiceNum, String fName, String lName, String email, String street, String house, String pin, String city, String country, String taxCode, String cardNumber, String expDate, String cvv) {
		LoginPage login = new LoginPage(driver);
		HomePage home = login.doLogin(uName, uPass);
		ProductPage product = home.clickOnNewBtn();
		CustomerPage customer = product.selectProductInfo(serialNum, deviceName, invoiceNum);
		ConfirmationPage confirm = customer.enterCustomerInfo(fName, lName, email, street, house, pin, city, country, taxCode);
		PaymentProcedurePage paymentProcedure =  confirm.selectAllCheckBoxes();
		PaymentDetailsPage paymentDetails = paymentProcedure.clickOnContinueToPayment();
		paymentDetails.completePayment(cardNumber, expDate, cvv);
	}
	
	@Test(dataProvider = "testData")
	public void createInsurancePolicyByUsingCsv(String tName, String uName, String uPass, String serialNum, String deviceName, String invoiceNum, String fName, String lName, String email, String street, String house, String pin, String city, String country, String taxCode, String cardNumber, String expDate, String cvv) {
		LoginPage login = new LoginPage(driver);
		HomePage home = login.doLogin("testsellingpartner1@simplesurance.de", "TestSellingPartner1Pass");
		ImportInsurancesPage impCsv = home.clickOnImportBtn();
		impCsv.importFile();
	}
}
