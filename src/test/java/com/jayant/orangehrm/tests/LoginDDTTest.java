package com.jayant.orangehrm.tests;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.jayant.orangehrm.base.BaseTest;
import com.jayant.orangehrm.util.ExcelUtil;

public class LoginDDTTest extends BaseTest {

	@DataProvider 
	public Object[][] LoginData() throws IOException {
		return ExcelUtil.getLoginData("src/test/resources/excel-files/Orhm_loginData.xlsx", "LoginDataSheet");
	}

	@Test(dataProvider = "LoginData")
	public void Ohrm_LoginTest(String username, String password,String expectedResult)  {
		getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Login
		getDriver().findElement(By.name("username")).sendKeys(username); // enter user name
		getDriver().findElement(By.name("password")).sendKeys(password);// enter password
		getDriver().findElement(By.xpath("//button[normalize-space()='Login']")).click(); // click on login button

		// Logout

		String Dashboard_URL = getDriver().getCurrentUrl();

		if (expectedResult.equalsIgnoreCase("Valid")) {
			Assert.assertTrue(Dashboard_URL.contains("/dashboard/"));
			getWait().until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-userdropdown-tab"))).click();
			getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']"))).click();
			Assert.assertTrue(getDriver().getCurrentUrl().contains("/login"));
            System.out.println("Login succesful");
		} else {
			String errorMsg= getWait()
					.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Invalid credentials']"))).getText();
			Assert.assertEquals(errorMsg, "Invalid credentials");
			System.out.println("Login failed due to :"+errorMsg);
					

		}
		System.out.println(
			    "Thread ID: " + Thread.currentThread().getId()
			);


	}
}
