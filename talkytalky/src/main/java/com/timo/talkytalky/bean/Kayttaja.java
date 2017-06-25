package com.timo.talkytalky.bean;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;



import com.timo.talkytalky.validator.EmailDontExist;
import com.timo.talkytalky.validator.EmailExist;

public class Kayttaja {


private int id;	
@Size(min=1, max=50)
private String etunimi;
@Size(min=1, max=150)
private String sukunimi;


private String existingEmail;
@Size(min=1, max=150)
private String salasana;
private String salasanaKryptattuna;

@Email @Size(min=1, max=200) @EmailExist(message = "Email is already use")
private String email;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEtunimi() {
	return etunimi;
}
public void setEtunimi(String etunimi) {
	this.etunimi = etunimi;
}
public String getSukunimi() {
	return sukunimi;
}
public void setSukunimi(String sukunimi) {
	this.sukunimi = sukunimi;
}


public String getExistingEmail() {
	return existingEmail;
}
public void setExistingEmail(String existingEmail) {
	this.existingEmail = existingEmail;
}
public String getSalasana() {
	return salasana;
}
public void setSalasana(String salasana) {
	this.salasana = salasana;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}




public String getSalasanaKryptattuna() {
	return salasanaKryptattuna;
}
public void setSalasanaKryptattuna(String salasanaKryptattuna) {
	this.salasanaKryptattuna = salasanaKryptattuna;
}
@Override
public String toString() {
	return "Kayttaja [id=" + id + ", etunimi=" + etunimi + ", sukunimi="
			+ sukunimi + ", salasana=" + salasana + ", email=" + email + "]";
}
	
	




}
