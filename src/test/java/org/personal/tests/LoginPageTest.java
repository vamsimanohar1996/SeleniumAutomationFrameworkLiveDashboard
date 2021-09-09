package org.personal.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.personal.driver.DriverManager;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTest {

	private LoginPageTest() {

	}

	@Test
	public void test1()

	{
	
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
		
	}
	
	//@Test
	public void test2()

	{
	
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Devops", Keys.ENTER);
		
	}


}
