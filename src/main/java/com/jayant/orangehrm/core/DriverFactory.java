package com.jayant.orangehrm.core;


import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver createDriver() {
		WebDriverManager.chromedriver().setup();
		Map<String, Object> pref = new HashMap<>();
		pref.put("profile.credentials_enable_service", false);
		pref.put("profile.password_manager_leak_detection", false);
		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("prefs", pref);

		WebDriver driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		return driver;

	}

}
