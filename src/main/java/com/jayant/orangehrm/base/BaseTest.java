package com.jayant.orangehrm.base;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jayant.orangehrm.core.DriverFactory;

public class BaseTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private  WebDriverWait wait;

    protected void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    protected WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriver getDriverFromThread() {
        return driver.get();
    }

    @BeforeMethod
    protected void setUp() {
        setDriver(DriverFactory.createDriver());
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
    }

    public  WebDriverWait getWait() {
        return wait;
    }

    protected void cleanUp() {
        driver.remove();
    }

    @AfterMethod
    protected void tearDown() {
        getDriver().quit();
        cleanUp();
    }
}
