package org.personal.utils;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.personal.enums.ConfigProperties;

public final class ELKUtils {

	private ELKUtils() {

	}

	public static void addDetailsToELK(String testName, String status) {
		if (ReadPropertyFileInMap.getValue(ConfigProperties.ELKENABLER).equalsIgnoreCase("yes")) {
			Map<String, String> map = new HashMap<>();
			map.put("testName", testName);
			map.put("status", status);
			map.put("executionTime", LocalDateTime.now().toString());
			given().header("Content-Type", "application/json").body(map).post("http://localhost:9200/suite/result");
		}
	}

}
