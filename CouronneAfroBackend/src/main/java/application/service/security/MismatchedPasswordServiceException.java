package application.service.security;

import application.service.exception.ServiceException;

public class MismatchedPasswordServiceException extends ServiceException {

	public MismatchedPasswordServiceException(){
		super("The provided password is incorrect, Did You forgot your password?");
	}

}
