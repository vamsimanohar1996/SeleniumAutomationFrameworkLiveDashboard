package org.personal.tests;

import java.util.List;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.personal.driver.DriverManager;
import org.testng.annotations.Test;

public final class HomePageTest extends BaseTest {

	private HomePageTest() {

	}

	@Test
	public void test1() {

		SoftAssertions soft=new SoftAssertions();
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Scope for Devops Engineers in future",
				Keys.ENTER);
		List<WebElement> allLinks = DriverManager.getDriver().findElements(By.cssSelector("a h3"));
		soft.assertThat(allLinks).as("Size is not equal to 14").hasSize(14)
		.hasSizeGreaterThan(5)
		.hasSizeBetween(5, 15)
		.extracting(e->e.getText())
		.contains("Future Scope of DevOps - 9 Reasons To Learn DevOps in 2021");
		soft.assertAll();
	}

}
