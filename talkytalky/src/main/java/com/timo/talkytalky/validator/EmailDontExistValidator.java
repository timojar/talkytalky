package com.timo.talkytalky.validator;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.timo.talkytalky.bean.Kayttaja;
import com.timo.talkytalky.service.UserService;







public class EmailDontExistValidator implements
ConstraintValidator<EmailDontExist, String> {
	

	@Autowired
	private UserService service;
	

	public void initialize(EmailDontExist exist) {

	}

	public boolean isValid(String email, ConstraintValidatorContext context) {
		
		if (email == null || email.length() == 0) {
			return false;
		}
		
		
		
		
		Kayttaja k=new Kayttaja();
		
		
		
		
		try {k=service.haeKayttaja(email);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		
		if(email.equals(k.getEmail())){
			return true;	
		}
		
		
		
		return false;
		
		
		
		
	}		
	
	


}
