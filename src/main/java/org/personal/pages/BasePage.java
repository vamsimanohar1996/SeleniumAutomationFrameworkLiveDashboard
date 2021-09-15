package org.personal.pages;

import org.openqa.selenium.By;
import org.personal.enums.WaitStrategy;
import org.personal.factories.ExplicitWaitFactory;

public class BasePage {

	protected void click(By by, WaitStrategy waitStrategy) {

		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
	}

	protected void sendKeys(By by, String keys, WaitStrategy waitStrategy) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(keys);
	}

	protected void click(By by, WaitStrategy waitStrategy,String element) {

		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
	}
}
