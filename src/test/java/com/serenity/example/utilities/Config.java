package com.serenity.example.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
	final static Logger LOG = LoggerFactory.getLogger(Config.class);
	static Properties CONFIG = new Properties();

	public Properties initializeConfig() {
		InputStream is = null;
		try {
			is = Config.class.getResourceAsStream("/Properties/test.properties");
			CONFIG.load(is);

		} catch (Exception e) {
			LOG.error(e.getMessage());
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					LOG.error("Unable to close File Input stream");
				}
			}
		}
		return CONFIG;
	}

}