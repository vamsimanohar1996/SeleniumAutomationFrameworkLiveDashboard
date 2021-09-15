package org.personal.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.personal.driver.DriverManager;
import org.personal.enums.WaitStrategy;
import org.personal.utils.DynamicLocatorStrategy;

public final class AmazonHamburgerMenuPage extends BasePage {

	@FindBy(xpath = "//div[text()='Mobiles, Computers']/parent::a")
	private WebElement linkToMobileAndComputers;

	private String linkSubMenu = "//a[text()='%s']";

	public AmazonLaptopPage clickOnSubMenu(String menuText) {
		String newXpath = DynamicLocatorStrategy.getDynamicLocator(linkSubMenu, menuText);
		click(By.xpath(newXpath), WaitStrategy.CLICKABLE, menuText);
		if(menuText.equals("Laptops"))
		{
			return new AmazonLaptopPage();
		}
		return null;

	}

	public AmazonHamburgerMenuPage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public AmazonHamburgerMenuPage clickMobilesAndComputers() {
		linkToMobileAndComputers.click();
		return this;
	}

}
