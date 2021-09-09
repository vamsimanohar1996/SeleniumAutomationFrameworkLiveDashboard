package org.personal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import org.personal.constants.Constants;

public final class ReadPropertyFile {

	private ReadPropertyFile() {

	}

	private static Properties property = new Properties();
	

	/* Loading Properties file logic is implemented in static block in order to
	avoid the multiple calls to fileInputStream whenever a property value is
	 needed
	 */
	
	static {
		try {
			FileInputStream fileInputStream = new FileInputStream(Constants.getConfigFilePath());
			property.load(fileInputStream);
		} catch (FileNotFoundException fn) {
			fn.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
	}
	
	

	/****
	 * 
	 * @param key
	 * @return
	 * @throws Exception
	 */

	public static String getPropertyValue(String key) throws Exception {

		if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
			throw new Exception("Property name " + key + " is not found. Please check config.properties file");
		}
		return property.getProperty(key);
	}

}
