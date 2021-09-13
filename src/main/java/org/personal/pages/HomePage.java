package org.personal.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.personal.driver.DriverManager;
import org.personal.enums.WaitStrategy;

import com.google.common.util.concurrent.Uninterruptibles;

public final class HomePage extends BasePage {
	
	private By welcome = By.id("welcome");
	private By logout=By.xpath("//a[text()='Logout']");
	
	public HomePage clickWelcome()
	{
		DriverManager.getDriver().findElement(welcome).click();
		return this;
	}
	
	public LoginPage clickLogout()
	{
		
		
		Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
		click(logout,WaitStrategy.CLICKABLE);
		return new LoginPage();
	}
	

}
