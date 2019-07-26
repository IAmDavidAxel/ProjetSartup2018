package utility;

public class ApplicationConfiguration {
	/**
	 * Properties files
	 */
	public static final String PROPERTIES_FILE_NAME = "easyCoiffure.properties";

	/**
	 * Server properties
	 */
	public static String mode;
	public static int serverPort;
	public static String tokenExpirationPolicy;
	public static int tokenLength;

	/**
	 * Mailing properties
	 */
	public static String mailAddress;
	public static String mailPassword;
	public static String sendInterval;
	public static String sendAttempt;
	public static String passwordPolicyMode;

	/**
	 * Manager credentials
	 */
	public static String managerUsername;
	public static String managerPassword;
}
