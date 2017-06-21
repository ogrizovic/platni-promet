package com.poslovna.model.users.access;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

	String message() default "{Minimalna duzina lozinke je 8 karaktera. Mora sadrzati malo, veliko slovo, znak i cifru}";
    
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
}
