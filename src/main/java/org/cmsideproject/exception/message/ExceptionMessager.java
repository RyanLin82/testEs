package org.cmsideproject.exception.message;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionMessager {
	private Logger log = LogManager.getLogger(this.getClass());
	public static final String DEFAULT_ERROR_CODE = "000";
	public static final String EXCEPTION_MESSAGE_FILE = "exceptions.messages";

	private Map<String, String> messageMap;
	private static ExceptionMessager singleton;

	private ExceptionMessager() {
		this.initMessages();
	}

	public static ExceptionMessager getInstance() {
		if (singleton == null) {
			singleton = new ExceptionMessager();
		}
		return singleton;
	}

	private void initMessages() {
		this.messageMap = new HashMap<String, String>();

		String messageFile = EXCEPTION_MESSAGE_FILE;
		File propertiesFile = new File(messageFile);

		Parameters params = new Parameters();
		FileBasedConfigurationBuilder<FileBasedConfiguration> builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(
				PropertiesConfiguration.class).configure(params.fileBased().setFile(propertiesFile));

		try {
			Configuration config = builder.getConfiguration();
			Iterator<String> keys = config.getKeys();

			while (keys.hasNext()) {
				String code = keys.next();
				String message = config.getString(code, "");

				this.messageMap.put(code, message);
			}
		} catch (Exception e) {
			log.error("Unable to load exception messages from file [{}]", messageFile, e);
		}
	}

	public String decode(String code, String... args) {
		String message = (this.messageMap.containsKey(code)) ? this.messageMap.get(code)
				: this.messageMap.get(DEFAULT_ERROR_CODE);

		for (int i = 0; i < args.length; i++) {
			message = message.replace("{" + i + "}", args[i]);
		}

		return message;
	}
}
