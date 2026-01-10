package com.jayant.orangehrm.tests;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.jayant.orangehrm.util.ExcelUtil;

public class LoginDDTTest extends BaseTest {

	@DataProvider //(parallel = true)
	public Object[][] LoginData() throws IOException {
		return ExcelUtil.getLoginData("src/test/resources/Orhm_loginData.xlsx", "LoginDataSheet");
	}

	@Test(dataProvider = "LoginData")
	public void Ohrm_LoginTest(String username, String password,String expectedResult)  {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		// Login
		driver.findElement(By.name("username")).sendKeys(username); // enter user name
		driver.findElement(By.name("password")).sendKeys(password);// enter password
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click(); // click on login button

		// Logout

		String Dashboard_URL = driver.getCurrentUrl();

		if (expectedResult.equalsIgnoreCase("Valid")) {
			Assert.assertTrue(Dashboard_URL.contains("/dashboard/"));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".oxd-userdropdown-tab"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Logout']"))).click();
			Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
            System.out.println("Login succesful");
		} else {
			String errorMsg= wait
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
