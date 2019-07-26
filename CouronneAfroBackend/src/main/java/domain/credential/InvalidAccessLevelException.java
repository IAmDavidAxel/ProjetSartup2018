package domain.credential;

import domain.exception.CouronneAfroException;

public class InvalidAccessLevelException extends CouronneAfroException {
	public InvalidAccessLevelException() {
		super("vous n'avez pas la permission de visiter ce contenue");
	}
}
