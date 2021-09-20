package org.personal.driver;

import java.net.MalformedURLException;
import java.util.Objects;

import org.personal.enums.ConfigProperties;
import org.personal.exceptions.BrowserInvocationFailedException;
import org.personal.factories.DriverFactory;
import org.personal.utils.ReadPropertyFileInMap;

/**
 * Driver Factory class is responsible for invoking and closing the browsers.
 * <p>
 * Also responsible for setting the driver variable to DriverManager which
 * handles the thread safety for the WebDriver instance
 * </p>
 * 
 * 15-Sep-2021
 * 
 * @author Vamsi Manohar 2021
 * @see DriverManager
 * @see org.personal.tests.BaseTest
 * 
 */
public final class Driver {

	/**
	 * Using private constructor to avoid external initialization
	 */

	private Driver() {
	}

	/**
	 * 15-Sep-2021
	 * 
	 * @author Vamsi Manohar 2021
	 * @param browser value will be passed from {@link org.personal.tests.BaseTest}.
	 *                Values can be chrome and firefox
	 * 
	 */

	public static void initDriver(String browser) {
		if (Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Browser Invocation Failed");
			}

			DriverManager.getDriver().get(ReadPropertyFileInMap.getValue(ConfigProperties.URL));

		}

	}

	/**
	 * 
	 */
	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
