package org.personal.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.personal.constants.Constants;
import org.testng.annotations.DataProvider;

public final class DataProviderUtils {

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider(parallel=true)
	public static Object[] getData(Method m) {
		String testName = m.getName();

		if (list.isEmpty()) {
			list = ExcelUtils.getTestData(Constants.getIterationSheet());
		}

		List<Map<String, String>> executionList = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).get("testname").equalsIgnoreCase(testName)
					&& list.get(i).get("execute").equalsIgnoreCase("yes")) {

				executionList.add(list.get(i));
			}

		}
		return executionList.toArray();
	}

}
