package com.jayant.orangehrm.base;
import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.jayant.orangehrm.core.DriverFactory;
import org.testng.annotations.Listeners;
@Listeners(com.jayant.orangehrm.listener.Listener.class)
public class BaseTest {
private static ThreadLocal<WebDriver>driver = new ThreadLocal<>();
protected  void setDriver(WebDriver driverInstance) {
	driver.set(driverInstance);
}
protected  WebDriver getDriver() {
	return driver.get();
}
public static WebDriver getDriverFromThread() {
	return driver.get();
}
protected WebDriverWait getWait() {
	return new WebDriverWait(getDriver(), Duration.ofSeconds(30));
}
protected  void cleanUp() {
	driver.remove();
}
@BeforeMethod
protected void setUp() {
	setDriver(DriverFactory.createDriver());
	
	
}
@AfterMethod
protected void tearDown() {
	getDriver().quit();
	cleanUp();
}
}

