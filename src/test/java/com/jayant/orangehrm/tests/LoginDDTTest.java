package com.jayant.orangehrm.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.jayant.orangehrm.base.BaseTest;
import com.jayant.orangehrm.util.ExcelUtil;
import com.jayant.pages.LoginPage;

public class LoginDDTTest extends BaseTest {

	@DataProvider
	public Object[][] LoginData() throws IOException {
		return ExcelUtil.getLoginData("src/test/resources/excel-files/Orhm_loginData.xlsx", "LoginDataSheet");
	}

	@Test(dataProvider = "LoginData")
	public void Ohrm_LoginTest(String username, String password, String expectedResult) {
		LoginPage login = new LoginPage(getDriver(), getWait());
		login.pageOpen();
		// Login
		login.performLogin(username, password);
		// Logout

		if (expectedResult.equalsIgnoreCase("Valid")) {

			Assert.assertTrue(login.dashBoardIconIsDisplayed(), "DashBoard Icon was not displayed");
			login.performLogout();

			Assert.assertTrue(login.loginPageElementIsDisplayed());
			System.out.println("Login succesful");
		} else {
			Assert.assertEquals(login.errorMessage(), "Invalid credentials");
			System.out.println("Login failed due to :" + login.errorMessage());

		}
		System.out.println("Thread ID: " + Thread.currentThread().getId());

	}
}
