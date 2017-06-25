package com.timo.talkytalky.bean;

import org.jboss.logging.Message;

import com.timo.talkytalky.validator.EmailDontExist;


public class KayttajaToken {

private int id;

private Kayttaja kayttaja;

private String tokenString;

@EmailDontExist (message = "Email dont't exist in system")
private String email;



public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Kayttaja getKayttaja() {
	return kayttaja;
}

public void setKayttaja(Kayttaja kayttaja) {
	this.kayttaja = kayttaja;
}

public String getTokenString() {
	return tokenString;
}

public void setTokenString(String tokenString) {
	this.tokenString = tokenString;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}






	

}
