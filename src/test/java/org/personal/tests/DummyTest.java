package org.personal.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

public class DummyTest {

	@Test(dataProvider="getData")
	public void test(String browser,String version) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(browser);
		cap.setVersion(version);
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.get("https://google.co.in");
		System.out.println(driver.getTitle());
		Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		driver.quit();
	}

	@DataProvider(parallel=true)
	public Object[][] getData() {
		return new Object[][] { { "chrome","93.0.4577.63" }, { "chrome","70.0.3538.77" }, { "firefox","92.0" }, { "firefox","92.0" } };
	}
}
