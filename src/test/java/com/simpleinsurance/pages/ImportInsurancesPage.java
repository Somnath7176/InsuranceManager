package com.simpleinsurance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;

import javax.swing.event.MenuKeyEvent;

import java.awt.Toolkit;

public class ImportInsurancesPage {

	WebDriver driver;

	public ImportInsurancesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@role,'presentation') and @tabindex='0']")
	WebElement browseBtn;

	@FindBy(xpath = "//span[contains(text(),'Import')]")
	WebElement importBtn;
	
	public void selectFileByUsingRobot() {
		String filePath = "src/test/resources/testdata.csv";
		Robot rb = null;
		try {
			rb = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// copying File path to Clipboard
		StringSelection str = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		// press Contol+V for pasting
		rb.keyPress(MenuKeyEvent.VK_CONTROL);
		rb.keyPress(MenuKeyEvent.VK_V);

		// release Contol+V for pasting
		rb.keyRelease(MenuKeyEvent.VK_CONTROL);
		rb.keyRelease(MenuKeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(MenuKeyEvent.VK_ENTER);
		rb.keyRelease(MenuKeyEvent.VK_ENTER);
	}

	public void importFile() {
		browseBtn.click();
		selectFileByUsingRobot();
		importBtn.click();
	}
}
