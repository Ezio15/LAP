package com.stg.elap.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Vignesh
 *
 */
public class PropertiesReader {

	private Properties configProp = new Properties();
	
	private static final PropertiesReader props = new PropertiesReader();
	
	public static PropertiesReader getInstance() {
		return props;
	}

	public String getSecret(String key) {
		try {
			InputStream inputStream = getClass().getResourceAsStream(Constants.SECRETS_PROPS_PATH);
			configProp.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return configProp.getProperty(key);	
	}
}