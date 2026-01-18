package com.jayant.orangehrm.listener;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.jayant.orangehrm.base.BaseTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.jayant.orangehrm.core.ExtentManager;
import com.jayant.orangehrm.util.ScreenshotUtil;

public class Listener implements ITestListener {
	public void onTestStart(ITestResult result) {
		ExtentManager.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {

		ExtentManager.getTest().pass(MarkupHelper.createLabel(result.getName() + "Test Passed", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = BaseTest.getDriverFromThread();
		ExtentManager.getTest().fail(MarkupHelper.createLabel(result.getName() + "Test Failed", ExtentColor.RED));
		ExtentManager.getTest().fail(result.getThrowable());
		String screenshot = ScreenshotUtil.takeScreenshot(driver, result.getName());
		ExtentManager.getTest().addScreenCaptureFromPath(screenshot);
	}

	public void onTestSkipped(ITestResult result) {
		ExtentManager.getTest().skip(MarkupHelper.createLabel(result.getName() + "Test Skipped", ExtentColor.ORANGE));
	}

	public void onFinish(ITestContext context) {
		ExtentManager.flush();
	}
}
