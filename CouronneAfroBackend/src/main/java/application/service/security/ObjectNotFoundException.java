package application.service.security;

import domain.exception.CouronneAfroException;

public class ObjectNotFoundException extends Exception {

	public ObjectNotFoundException(){
		super("Object not Found");
	}

}
