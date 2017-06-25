package com.timo.talkytalky.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;







@Documented
@Constraint(validatedBy = EmailExistValidator.class)
@Target( { FIELD, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailExist {
	
	
	
	
	
	
	 String message() ;
	 
	 Class<?>[] groups() default {};
	 
	 Class<? extends Payload>[] payload() default {};	
			
	
		
	
	
	
	

}
