package org.personal.tests;

import java.util.Map;

import org.personal.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {





	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data)  {
	
		Map<String,String>map=(Map<String,String>)data[0];
		System.out.println(map);
		Driver.initDriver(map.get("browser"));
	}

	@AfterMethod
	protected void tearDown() {
		Driver.quitDriver();
	}
}
