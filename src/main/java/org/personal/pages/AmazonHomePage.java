package org.personal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.personal.driver.DriverManager;

public final class AmazonHomePage extends BasePage
{
	
	@FindBy(id="nav-hamburger-menu")
	private WebElement linkHamburgerIcon;
	
	
	public AmazonHomePage()
	{
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	
	public AmazonHamburgerMenuPage clickHamburgerIcon()
	{
		linkHamburgerIcon.click();
		return new AmazonHamburgerMenuPage();
	}
}
