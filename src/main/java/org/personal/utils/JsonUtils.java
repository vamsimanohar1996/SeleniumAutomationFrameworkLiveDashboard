package org.personal.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.personal.constants.Constants;
import org.personal.enums.ConfigProperties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	
	
	private static Map<String,String>CONFIG_MAP;
	
	private JsonUtils()
	{
		
	}
	
	static
	{
		try {
			CONFIG_MAP = new ObjectMapper().readValue(new File(Constants.getConfigJSONFilePath()),
					new TypeReference<HashMap<String,String>>(){});
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
