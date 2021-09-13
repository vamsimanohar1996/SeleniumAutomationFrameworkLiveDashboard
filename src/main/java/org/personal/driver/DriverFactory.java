package org.personal.driver;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.personal.enums.ConfigProperties;
import org.personal.utils.ReadPropertyFileInMap;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {

	}

	public static void initDriver(String browser) throws Exception {
		if (Objects.isNull(DriverManager.getDriver())) {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			}

			DriverManager.setDriver(driver);
			DriverManager.getDriver().get(ReadPropertyFileInMap.getValue(ConfigProperties.URL));
		}

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
