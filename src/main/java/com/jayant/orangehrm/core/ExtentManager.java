package com.jayant.orangehrm.core;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static ExtentReports getReport() {
		if (extent == null) {
			String reportPath = "Reports/OrangeHRM_Login_" + System.currentTimeMillis() + ".html";
			File reportFile = new File(reportPath);
			reportFile.getParentFile().mkdirs();
			ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

			spark.config().setDocumentTitle("Orange HRM Login Test");
			spark.config().setReportName("Login and Logout reports");
			spark.config().setTheme(Theme.DARK);
			extent = new ExtentReports();
			extent.attachReporter(spark);
			extent.setSystemInfo("User Name", "User.name");
			extent.setSystemInfo("OS", "User.os");
			extent.setSystemInfo("Browser", "Chrome");

		}
		return extent;
	}

	public static void createTest(String testName) {
		ExtentTest extentTest = getReport().createTest(testName);
		test.set(extentTest);
	}

	public static ExtentTest getTest() {
		return test.get();
	}

	public static void flush() {
		extent.flush();
		test.remove();
	}
}
