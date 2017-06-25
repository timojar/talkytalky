package com.timo.talkytalky.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.timo.talkytalky.Salaaja;
import com.timo.talkytalky.bean.Kayttaja;
import com.timo.talkytalky.bean.KayttajaKeskustelu;
import com.timo.talkytalky.bean.KayttajaToken;
import com.timo.talkytalky.bean.KayttajaValtuus;
import com.timo.talkytalky.bean.Keskustelu;
import com.timo.talkytalky.dao.KayttajaDao;
import com.timo.talkytalky.service.MailService;
import com.timo.talkytalky.service.UserService;





@Controller


@RequestMapping(value="user")
public class KayttajaController {
	
@Autowired
private UserService service;	
	
@Autowired
private AuthenticationManager authenticationManager;

@Autowired
private MailService mail;


 



@RequestMapping(value="register")
public ModelAndView registerForm()	{
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String email = auth.getName();
	System.out.println("security "+email);
	
	ModelAndView model=new ModelAndView("user/register");
	System.out.println("user");
	
	model.addObject("kayttaja", new Kayttaja());
	
	
	return model;
	
}


@RequestMapping (value="register", method = RequestMethod.POST ) 
public String register(@ModelAttribute(value = "kayttaja") @Valid Kayttaja k, BindingResult result
		){
	
	
	
	







System.out.println(result.getErrorCount());

if(result.hasErrors()){
	
	
	
	System.out.println(result.getFieldError());
	
	return "user/register";	
}
String username=k.getEmail();
String password=k.getSalasanaKryptattuna();


service.insertKayttaja(k);

SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
updatedAuthorities.add(authority);




SecurityContextHolder.getContext().setAuthentication(
        new UsernamePasswordAuthenticationToken(
                username,
                password,
                updatedAuthorities)
);




	return "redirect:/user/account";
}



@RequestMapping(value="account")
public ModelAndView account()	{
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String email = auth.getName();
	
	Kayttaja k=service.haeKayttaja(email);
	int kayttajaId=k.getId();
	List<KayttajaKeskustelu>kk= service.haeKeskustelut(kayttajaId);
	
	System.out.println(kk.size());
	
	ModelAndView model=new ModelAndView("user/account");

	
	model.addObject("keskustelut", kk);
	model.addObject("kayttaja", new Kayttaja());
	
	
	return model;
	
}



@RequestMapping(value="create")
public ModelAndView createForm()	{
	

	ModelAndView model=new ModelAndView("conversation/create");
	
	
	model.addObject("keskustelu", new Keskustelu());
	
	
	return model;
	
}


@RequestMapping(value="create", method = RequestMethod.POST )
public ModelAndView createTopic(@ModelAttribute(value="kayttaja")Keskustelu k)	{
	
	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	String email = auth.getName();
	Kayttaja kayttaja=service.haeKayttaja(email);
	int kayttajaId=kayttaja.getId();

	KayttajaValtuus kv=new KayttajaValtuus();
	kv.setKayttajaId(kayttajaId);
	
	ModelAndView model=new ModelAndView("conversation/create");
	
	model.addObject("keskustelu", new Keskustelu());
	
	service.luoKeskustelu(k, kv);
	
	return model;
	
}





@RequestMapping(value="resetpassword")
public ModelAndView resetPassword()	{
	
	
	ModelAndView model=new ModelAndView("user/password");
	model.addObject("k", new KayttajaToken());
	System.out.println("uusi salasana");
	
	
	return model;
	
}

@RequestMapping(value="resetpassword", method =RequestMethod.POST)
public String checkEmail(@ModelAttribute(value = "k") @Valid KayttajaToken k, BindingResult result,
		ServletRequest request){
	
	if(result.hasErrors()){
		System.out.println("Virheessä "+result.getFieldError().getDefaultMessage());
		return "user/password";
		
	}
	


	Salaaja kryptaaja=new Salaaja();

	
	
	String sana = UUID.randomUUID().toString();
	String tokenString = kryptaaja.salaa(sana);
	k.setTokenString(tokenString);
	
	String url = "http://" + request.getServerName() + ":"
			+ request.getServerPort() + "/talkytalky/password/"
			+ tokenString;
	
	String email=k.getEmail();
	Kayttaja kayttaja=service.haeKayttaja(email);
	k.setKayttaja(kayttaja);
	String subject="new password";
	String message=paswordResetBody(url, kayttaja);
	
	try {
		mail.sendEmail(k.getEmail(), subject, message);
		
	} catch (Exception e) {
		// TODO: handle exception
		
		e.printStackTrace();
	}
	service.luoKayttajaToken(k);
	
	
	
	return "user/password";
	
}








private String paswordResetBody(String url, Kayttaja kayttaja) {
	String linebreak = System.getProperty("line.separator");

	String text = "Hey "  + kayttaja.getEtunimi() + "! "+linebreak+
			
			linebreak+"You can reset your password the link below!"
			+ linebreak+linebreak + url+linebreak +linebreak+ "Best regards" + linebreak
			+ "Talkytalky service team ";

	return text;
}




}
