package com.poslovna.model.users.access;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PasswordValidatorOld implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return String.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors e) {
		String pass = (String) arg0;
		if(!pass.matches("^(?=.{8,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$")){ // minimum 8: malo, veliko, znak, cifra
			e.reject("password");
		}
	}

}
