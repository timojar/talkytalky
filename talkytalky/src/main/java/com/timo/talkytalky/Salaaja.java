package com.timo.talkytalky;


import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class Salaaja {

  public  String salaa(String sana) { 
	  
	  
	  StandardPasswordEncoder spe = new StandardPasswordEncoder();
		
		String hashedPassword=spe.encode(sana);
		
		

		
		
		return hashedPassword;
		
  }
  
  
  
  
  
  
  
  
}