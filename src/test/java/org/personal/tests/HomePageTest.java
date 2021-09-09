package org.personal.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.personal.driver.DriverManager;
import org.testng.annotations.Test;

public final class HomePageTest extends BaseTest {
	
	private HomePageTest()
	{
		
	}
	
	
	@Test
	public void test1() {
	
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Blockchain Learning tutorials", Keys.ENTER);
	}

}
