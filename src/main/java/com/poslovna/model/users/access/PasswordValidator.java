package com.poslovna.model.users.access;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String>{

	@Override
	public void initialize(Password arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext ctx) {
		if(password == null){
			return false;
		}
		System.out.println("\nprovera passa\n");
		return password.matches("^(?=.{8,100})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$"); // malo, veliko, cifra; min 8
	}

}
