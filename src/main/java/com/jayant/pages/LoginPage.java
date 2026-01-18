package com.jayant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private final WebDriver driver;
    
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}

	private final By usernameField = By.name("username");
	private final By passwordField = By.name("password");
	private final By loginButton = By.xpath("//button[normalize-space()='Login']");

	public void pageOpen() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	public void login(String username, String password) {
		driver.findElement(usernameField).sendKeys(username);// enter user name
		driver.findElement(passwordField).sendKeys(password); // enter password
		driver.findElement(loginButton).click(); // click on login button
	}

}
