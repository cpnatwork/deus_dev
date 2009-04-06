package deus.gatekeeper.cerberus.prep;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import deus.model.gatekeeper.LoginCredentials;

public class LoginCredentialsValidator implements Validator {

	LoginCredentials loginCredentials;

	public boolean supports(Class clazz) {
		return LoginCredentials.class.isAssignableFrom(clazz);
	}

	public void validate(Object commandObject, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"Field is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"Field is required.");

		loginCredentials = (LoginCredentials) commandObject;

		if ((loginCredentials.getPassword() != "password")
				&& (loginCredentials.getLocalUsername() != "partha")) {
			errors.reject("Credentials provided are not correct.");
		}
	}
}
