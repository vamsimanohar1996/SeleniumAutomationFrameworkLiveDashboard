package org.personal.tests;

import org.personal.driver.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	
	@BeforeMethod
	protected void setUp() throws Exception
	{
		DriverFactory.initDriver();
	}

	
	@AfterMethod
	protected void tearDown()
	{
		DriverFactory.quitDriver();
	}
}
