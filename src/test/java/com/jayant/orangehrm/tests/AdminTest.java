package com.jayant.orangehrm.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.jayant.orangehrm.base.BaseTest;
import com.jayant.pages.AdminPage;
import com.jayant.pages.LoginPage;

public class AdminTest extends BaseTest {

	@Test
	public void loginTest()  {
		LoginPage p1 = new LoginPage(getDriver());
		p1.pageOpen();
		p1.login("Admin", "admin123");
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Admin']"))).isDisplayed();
		String url = getDriver().getCurrentUrl();
		Assert.assertTrue(url.contains("/dashboard/"));

		AdminPage a1 = new AdminPage(getDriver(), getWait());
		a1.clickAdmin();
		a1.searchByusername("Admin");
		
		int count = a1.getRecordCount();
		System.out.println("Number of records Found: "+count);
		Assert.assertTrue(count > 0, "No records found for username : Admin");
		a1.refreshPage();
		a1.ByUserRole();
		
		int count1 = a1.getRecordCount();
		System.out.println("Number of records Found: "+count1);
		Assert.assertTrue(count1 > 0, "No records found for userRole : Admin");
		a1.refreshPage();
		a1.ByUserStatus();
		
		int count2 = a1.getRecordCount();
		System.out.println("Number of records Found: "+count2);
		Assert.assertTrue(count2 > 0, "No records found for Status : Enabled");

	}
}
