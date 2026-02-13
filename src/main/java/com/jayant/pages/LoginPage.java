package com.jayant.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private final WebDriver driver;
	private final WebDriverWait wait;

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;

	}

	private final By usernameField = By.name("username");
	private final By passwordField = By.name("password");
	private final By loginButton = By.xpath("//button[normalize-space()='Login']");
	private final String URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private final By dashBoardIcon = By.xpath("(//span[normalize-space()='Dashboard'])[2]");
    private final By dropDown = By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutButton = By.xpath("//a[normalize-space()='Logout']");
    private final By errorMessage = By.xpath("//p[normalize-space()='Invalid credentials']");
	public void pageOpen() {
		driver.get(URL);
	}

	public void enterUsername(String username) {
		wait.until(ExpectedConditions.elementToBeClickable(usernameField)).sendKeys(username);// enter user name

	}

	public void enterPassword(String password) {
		wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password); // enter password
	}

	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click(); // click on login button
	}
	
	public void performLogin(String username,String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}
	public boolean dashBoardIconIsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(dashBoardIcon)).isDisplayed();
	}
	public void logoutDropDown() {
		wait.until(ExpectedConditions.elementToBeClickable(dropDown)).click();
	}
	public void logout() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton))
		.click();
	}
	public void performLogout() {
		logoutDropDown();
		logout();
	}
	public boolean loginPageElementIsDisplayed() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).isDisplayed();
	}
	public String errorMessage() {
		return wait
				.until(ExpectedConditions
						.visibilityOfElementLocated(errorMessage))
				.getText();
	}

}
