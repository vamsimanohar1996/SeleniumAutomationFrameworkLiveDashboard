package org.personal.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.personal.annotations.FrameworkAnnotation;
import org.personal.enums.CategoryType;
import org.personal.pages.AmazonHomePage;
import org.testng.SkipException;
import org.testng.annotations.Test;

public final class AmazonPageTest extends BaseTest {
	
	
	private AmazonPageTest()
	{
		
	}
	
	
	@FrameworkAnnotation(author={"Vamsi","Manohar"}, category= {CategoryType.REGRESSION, CategoryType.SMOKE})
	@Test
	public void amazonPageTest(Map<String,String>data)
	{
		String title =  new AmazonHomePage().clickHamburgerIcon().clickMobilesAndComputers().clickOnSubMenu("Laptops").getTitle();
		Assertions.assertThat(title).isNotBlank()
		.isNotEmpty()
		.hasSizeGreaterThan(2)
		.containsIgnoringCase("Laptop");
	}

	
	@FrameworkAnnotation(author={"Vamsi","Manohar"}, category= {CategoryType.REGRESSION, CategoryType.SMOKE})
	@Test
	public void newTest(Map<String,String>data)
	{
		/*
		 * String title = new
		 * AmazonHomePage().clickHamburgerIcon().clickMobilesAndComputers().
		 * clickOnSubMenu("Laptops").getTitle();
		 * Assertions.assertThat(title).isNotBlank() .isNotEmpty()
		 * .hasSizeGreaterThan(2) .containsIgnoringCase("Laptop");
		 */
		
		throw new SkipException("Test Skipped");
	}
}
