package com.jayant.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
	private final WebDriver driver;
	private final WebDriverWait wait;

	public AdminPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
	}

	private final By adminMenu = By.xpath("//aside//span[normalize-space()='Admin']");
	private final By userTextbox = By.xpath("//label[contains(text(),'Username')]/following::input[1]");
	private final By searchButton = By.xpath("//button[normalize-space()='Search']");
	private final By recordsFound = By.xpath("//span[contains(normalize-space(),'Record')]");
	private final By sideMenu = By.xpath("//aside//ul//li");
	private final By userRoleDrop = By
			.xpath("//label[text()='User Role']/following::div[contains(@class,'oxd-select-text--after')][1]");
	private final By selectAdmin = By.xpath("//div[@role='listbox']//span[normalize-space()='Admin']");
	private final By statusDropDown = By
			.xpath("//label[text()='Status']/following::i[contains(@class,'oxd-select-text--arrow')]");
	private final By selectEnabled = By.xpath("//span[contains(text(),'Enabled')]");
	private final By resultsRow = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']");
	private final By noRecords = By.xpath("//span[normalize-space()='No Records Found']");

	public int menuCount() {
		List<WebElement> menu = driver.findElements(sideMenu);
		return menu.size(); // display menu count

	}

	public void clickAdmin() {
		driver.findElement(adminMenu).click(); // click on admin from menu
	}

	public void searchByusername(String username)   {
		driver.findElement(userTextbox).clear();
		driver.findElement(userTextbox).sendKeys(username);// enter user name
		driver.findElement(searchButton).click(); // click on search button
		
	}

	public int getRecordCount() {
		 // wait until search result state is resolved (either rows or no-records)
		wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOfElementLocated(noRecords), ExpectedConditions.visibilityOfElementLocated(resultsRow)));
		  // now safely read the Records Found label
		String records = wait.until(ExpectedConditions.visibilityOfElementLocated(recordsFound)).getText();
		
		if(records.toLowerCase().contains("no")) {
			return 0;
		}else {
			return Integer.parseInt(records.replaceAll("\\D+", ""));
		}

	}


	public void ByUserRole()  {
		driver.findElement(userRoleDrop).click(); // click user role drop down
		wait.until(ExpectedConditions.elementToBeClickable(selectAdmin)).click(); // select admin
		driver.findElement(searchButton).click(); // click on search button
		
	}

	public void ByUserStatus()  {
		driver.findElement(statusDropDown).click();
		wait.until(ExpectedConditions.elementToBeClickable(selectEnabled)).click();
		driver.findElement(searchButton).click(); // click on search button
		
	}

	public void refreshPage() {
		driver.navigate().refresh(); // refresh the page
	}

}
