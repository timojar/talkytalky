package com.timo.talkytalky.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.timo.talkytalky.bean.Kayttaja;
import com.timo.talkytalky.bean.KayttajaToken;
import com.timo.talkytalky.service.UserService;





@Controller


@RequestMapping(value="password")


public class PasswordController {

	
	
	

		
	@Autowired
	private UserService service;	
		
	@Autowired
	private AuthenticationManager authenticationManager;	
	
	
	
	
	@RequestMapping(value="{tokenString}")
	public ModelAndView resetPassword(@PathVariable String tokenString)	{
		
		
		ModelAndView model=new ModelAndView("user/newpassword");
		
		System.out.println("uusi salasana+ "+tokenString);
		
		KayttajaToken k= service.haeKayttajaToken(tokenString);
		
		int id=k.getKayttaja().getId();
		System.out.println("token haettu "+id);
		Kayttaja kayttaja=service.haeKayttajaTiedot(id);
		
		String salasana=null;
		kayttaja.setSalasana(salasana);
		
		model.addObject("kayttaja", kayttaja);
		
		
		
		
		return model;
		
	}


	
	
	@RequestMapping (value="{tokenString}", method = RequestMethod.POST ) 
	public String inserPassword(@ModelAttribute(value = "kayttaja") @Valid Kayttaja k, BindingResult result
			){
		
		
		if(result.hasErrors()){
			
			System.out.println("EI onnistu");
			
			
		}
	
		
		System.out.println("uusdet tiedot "+k.toString());
		
		boolean succes=service.vaihdaSalasana(k);
		
		System.out.println(succes);
		int id=k.getId();
		
		k=service.haeKayttajaTiedot(id);
		System.out.println(k.toString());
		
		return "redirect:/";
	}
	
	
	
	
	
	
	
}
