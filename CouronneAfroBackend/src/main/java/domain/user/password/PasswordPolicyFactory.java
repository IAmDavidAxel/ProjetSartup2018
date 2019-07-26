package domain.user.password;

import utility.datamanager.ApplicationConfiguration;

import java.util.Objects;

public class PasswordPolicyFactory {

	public static final String BASIC_POLICY = ApplicationConfiguration.passwordPolicyMode;

	public static  PasswordPolicy create(String policy){
		if(Objects.equals(policy,BASIC_POLICY)){
			return new BasicPasswordPolicy();
		}else {
			throw  new MissingPasswordPolicyModeException();
		}
	}
}
