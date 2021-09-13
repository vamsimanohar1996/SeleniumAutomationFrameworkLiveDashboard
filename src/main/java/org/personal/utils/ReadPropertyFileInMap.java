package org.personal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import org.personal.constants.Constants;
import org.personal.enums.ConfigProperties;

public final class ReadPropertyFileInMap {

	private ReadPropertyFileInMap() {

	}

	private static Properties property = new Properties();
	private static final Map<String, String> CONFIG_MAP = new HashMap<>();

	static {
		try {
			FileInputStream fileInputStream = new FileInputStream(Constants.getConfigFilePath());
			property.load(fileInputStream);

			for (Map.Entry<Object, Object> entry : property.entrySet()) {
				CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}

//			property.entrySet()
//					.forEach(entry -> CONFIG_MAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));

		} catch (FileNotFoundException fn) {
			fn.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static String getValue(ConfigProperties key) throws Exception {
		if (Objects.isNull(key.name().toLowerCase()) || Objects.isNull(CONFIG_MAP.get(key.name().toLowerCase()))) {
			throw new Exception("Property name " + key + " is not found. Please check config.properties file");
		}

		return CONFIG_MAP.get(key.name().toLowerCase());
	}

}
