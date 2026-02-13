package com.jayant.orangehrm.tests;



import org.testng.Assert;

import org.testng.annotations.Test;

import com.jayant.orangehrm.base.BaseTest;
import com.jayant.pages.AdminPage;
import com.jayant.pages.LoginPage;

public class AdminTest extends BaseTest {

	@Test
	public void loginTest()  {
		LoginPage login = new LoginPage(getDriver(),getWait());
		login.pageOpen();
		login.performLogin("Admin", "admin123");
		Assert.assertTrue(login.dashBoardIconIsDisplayed());

		AdminPage admin = new AdminPage(getDriver(), getWait());
		admin.clickAdmin();
		admin.searchByusername("Admin");
		
		int count = admin.getRecordCount();
		System.out.println("Number of records Found: "+count);
		Assert.assertTrue(count > 0, "No records found for username : Admin");
		admin.refreshPage();
		admin.ByUserRole();
		
		int count1 = admin.getRecordCount();
		System.out.println("Number of records Found: "+count1);
		Assert.assertTrue(count1 > 0, "No records found for userRole : Admin");
		admin.refreshPage();
		admin.ByUserStatus();
		
		int count2 = admin.getRecordCount();
		System.out.println("Number of records Found: "+count2);
		Assert.assertTrue(count2 > 0, "No records found for Status : Enabled");

	}
}
