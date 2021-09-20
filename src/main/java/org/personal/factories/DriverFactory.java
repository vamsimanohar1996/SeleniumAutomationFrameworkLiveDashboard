package org.personal.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.personal.enums.ConfigProperties;
import org.personal.utils.ReadPropertyFileInMap;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * 16-Sep-2021
 * 
 * @author Vamsi Manohar 2021
 */
public final class DriverFactory {

	private DriverFactory() {

	}

	public static WebDriver getDriver(String browser) throws MalformedURLException {
		WebDriver driver = null;
		String runMode = ReadPropertyFileInMap.getValue(ConfigProperties.RUNMODE);

		if (browser.equalsIgnoreCase("chrome")) {
			if (runMode.equalsIgnoreCase("remote")) 
			{
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.CHROME);
				driver = new RemoteWebDriver(new URL(""), cap);

			}

			else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			if (runMode.equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(BrowserType.FIREFOX);

				driver = new RemoteWebDriver(new URL(ReadPropertyFileInMap.getValue(ConfigProperties.SELENIUMGRIDURL)), cap);

			}

			else {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

		}
		return driver;
	}

}
