package server;

import utility.datamanager.ApplicationConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropertyConfiguration {

	private String fileName;
	private Properties properties = null;
	private InputStream inputStream = null;

	public PropertyConfiguration(String propertiesFileName) {
		fileName = propertiesFileName;
	}

	public void initialize() {
		properties = new Properties();
		inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
	}

	public void apply() {
		if (properties != null) {

			try {
				properties.load(inputStream);
			} catch (IOException exception) {
				Logger.getGlobal().log(Level.SEVERE, "Can't load properties file");
			}

			ApplicationConfiguration.mode = properties.getProperty("app.mode");
			ApplicationConfiguration.serverPort = Integer.parseInt(properties.getProperty("app.server.port"));

			ApplicationConfiguration.sqliteDbName = properties.getProperty("sqlite.database.name");
			ApplicationConfiguration.testSqliteDbName = properties.getProperty("test.sqlite.database.name");
			ApplicationConfiguration.sqliteSchemaFileName = properties.getProperty("sqlite.schema.file.name");

			ApplicationConfiguration.mailAddress = properties.getProperty("app.system.mail.account.address");
			ApplicationConfiguration.mailPassword = properties.getProperty("app.system.mail.account.password");
			ApplicationConfiguration.sendInterval = properties.getProperty("app.system.mail.invalid.sending.interval");
			ApplicationConfiguration.sendAttempt = properties.getProperty("app.system.mail.invalid.sending.attempt");


			ApplicationConfiguration.tokenExpirationPolicyFromProperties = properties.getProperty("app.system.token.expiration.policy");
			ApplicationConfiguration.tokenLength = Integer.parseInt(properties.getProperty("user.token.length"));
			ApplicationConfiguration.passwordPolicyMode = properties.getProperty("app.system.token.password.policy");

			ApplicationConfiguration.managerUsername = properties.getProperty("app.system.default.manager.account.username");
			ApplicationConfiguration.managerPassword = properties.getProperty("app.system.default.manager.account.password");

		}
	}

}
