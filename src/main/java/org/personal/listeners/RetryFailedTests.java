package org.personal.listeners;

import org.personal.enums.ConfigProperties;
import org.personal.utils.ReadPropertyFileInMap;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

	private int count = 0;
	private int retries = 1;

	@Override
	public boolean retry(ITestResult result) {

		boolean value = false;

		if (ReadPropertyFileInMap.getValue(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			value = count < retries;
			count++;

		}

		return value;
	}

}
