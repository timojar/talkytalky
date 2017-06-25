package com.timo.talkytalky;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@org.springframework.stereotype.Controller
public class Controller {
	
	
	
	@RequestMapping(value="/")
	public String index(){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth.isAuthenticated()) {
			
			
		return	"redirect:/user/account";
			
		}
		
		
		return "login";
	}
	
	
	@RequestMapping(value="/loginpage", method = RequestMethod.GET)
	public String login(Model model) {
		
		return "login";
 
	}
	
	
	@RequestMapping(value="/loginfail", method = RequestMethod.GET)
	public String loginerror(Model model) {
 
		model.addAttribute("loginerror", "true");
		return "login";
 
	}
	
	
	
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(Model model) {

		model.addAttribute("loggedout", "true");
		return "login";
 
	}
 

}
