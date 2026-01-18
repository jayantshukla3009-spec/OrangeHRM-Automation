package com.jayant.orangehrm.util;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

	public static String takeScreenshot(WebDriver driver, String testName) {
		String SSpath = "Screenshots/OrangeHRM_fail_" + System.currentTimeMillis() + ".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(SSpath);
		dest.getParentFile().mkdirs();
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SSpath;
	}
}
