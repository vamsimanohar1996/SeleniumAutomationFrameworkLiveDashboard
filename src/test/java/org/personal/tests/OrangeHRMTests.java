package org.personal.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.personal.pages.LoginPage;
import org.testng.annotations.Test;

public final class OrangeHRMTests extends BaseTest {

	private OrangeHRMTests() {

	}

	@Test()
	public void loginLogoutTest(Map<String, String> data) throws Exception {

		LoginPage login = new LoginPage();

		String msg = login.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickWelcome().clickLogout().getTitle();
		Assertions.assertThat(msg).containsIgnoringCase("ORANGEHRM").hasSizeBetween(1, 10);

	}

	@Test()
	public void newTest(Map<String, String> data) throws Exception {

		LoginPage login = new LoginPage();

		String msg = login.enterUserName(data.get("username")).enterPassword(data.get("password")).clickLogin()
				.clickWelcome().clickLogout().getTitle();
		Assertions.assertThat(msg).containsIgnoringCase("ORANGEHRM").hasSizeBetween(1, 10);

	}

}
