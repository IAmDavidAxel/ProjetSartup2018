package infrastructure;

import domain.user.password.EasyCoiffureException;

public class ObjectNotFoundException extends EasyCoiffureException {

	public ObjectNotFoundException() {
		super("Object Not found ");
	}
}
