package utility.datamanager;

public class MessageDataManager {
	public static final String SUCCESS_RESPONSE = "succes";
	public static final String CLIENT_CREATED = "Creation reussi verifié vos email pour confirmation";
	public static final String FAIL_RESPONSE = "failed";
	public static final String PASSWORD_POLICY_VIOLATION = "Le mot de passe que vous avez entré ne respecte pas notre politique de securité";

	// API general response message
	public static final String BAD_REQUEST_RESPONSE = "One or more provided information does not respect requirements.";
	public static final String INTERNAL_SERVER_ERROR = "An internal error occurred on the server side.";
	public static final String UNAUTHORIZED_TOKEN_ACCESS = "Provided access token is either invalid or has expired.";
	public static final String FORBIDDEN_ROLE_ACCESS = "Insufficient privileges to access the resource.";

	public static final String CLIENT_NOT_FOUND = "The client does not exist.";
	public static final String CLIENT_ALREADY_EXIST = "The chosen username is unavailable.";


	// Connection resource messages
	public static final String LOGIN_SUCCEEDED = "Login succeeded, you may use you account.";
	public static final String LOGIN_DENIED = "Login denied, check the information provided.";
	public static final String LOGOUT_SUCCEEDED = "Logout succeeded, you need to login to access you account.";
	public static final String BARBER_CREATED = "Coiffeur(euse) crée avec succès :) ";
}
