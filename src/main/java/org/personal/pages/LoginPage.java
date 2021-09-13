package org.personal.pages;

import org.openqa.selenium.By;
import org.personal.driver.DriverManager;
import org.personal.enums.WaitStrategy;
import org.personal.reports.ExtentLogger;
import org.personal.reports.ExtentManager;

public final class LoginPage extends BasePage {

	private final By username = By.id("txtUsername");
	private final By password = By.id("txtPassword");
	private final By loginBtn = By.id("btnLogin");


	public LoginPage enterUserName(String userName) {
		sendKeys(username, userName,WaitStrategy.PRESENCE);
		try {
			ExtentLogger.pass("==== Entered Username ====",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public LoginPage enterPassword(String passwordToEnter) {
		sendKeys(password, passwordToEnter,WaitStrategy.PRESENCE);
		try {
			ExtentLogger.pass("==== password entered ====",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public HomePage clickLogin() {
	    click(loginBtn,WaitStrategy.CLICKABLE);
	    try {
			ExtentLogger.pass("=== Login Clicked ===",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage();
	}
	
	public String getTitle()
	{
		return DriverManager.getDriver().getTitle();
	}

}
