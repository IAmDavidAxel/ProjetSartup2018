package domain.mail;

public class AuthenticationFailedMailSenderException extends MailSenderException {

	public AuthenticationFailedMailSenderException() {
		super("Authentication to google account failed");
	}

}
