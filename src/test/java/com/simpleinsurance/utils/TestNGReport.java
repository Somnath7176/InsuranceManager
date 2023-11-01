package com.simpleinsurance.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestNGReport {
	static ExtentReports extent;

	public static ExtentReports getReportObject() {
		String path = "test-output/TestNGReport.html";
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(path);
		reporter.config().setReportName("Test Automation Report");
		reporter.config().setDocumentTitle("Simple Insurance");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "Simple Insurance");
		extent.setSystemInfo("User Name", "Somnath Bhagat");
		return extent;
	}
}
