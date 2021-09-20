package org.personal.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;

/**
 * 
 * 15-Sep-2021
 * 
 * @author Vamsi Manohar 2021
 */

public final class DriverManager {

	private DriverManager() {

	}

	private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return dr.get();
	}

	static void setDriver(WebDriver driver) {
		if (Objects.nonNull(driver)) {
			dr.set(driver);
		}
	}

	static void unload() {
		dr.remove();
	}

}
