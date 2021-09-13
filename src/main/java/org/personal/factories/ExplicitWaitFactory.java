package org.personal.factories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.personal.constants.Constants;
import org.personal.driver.DriverManager;
import org.personal.enums.WaitStrategy;

public final class ExplicitWaitFactory {
	
	private ExplicitWaitFactory()
	{
		
	}

	public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {

		WebElement element = null;
		if (waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Constants.getTimeOut())
					.until(ExpectedConditions.elementToBeClickable(by));

		} else if (waitStrategy == WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(), Constants.getTimeOut())
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}

		else if (waitStrategy == WaitStrategy.NONE) {
			element = DriverManager.getDriver().findElement(by);
		}

		return element;
	}

}
