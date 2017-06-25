package com.timo.talkytalky.bean;

public class KayttajaKeskustelu {
	
private int kayttajaId;	
private int keskusteluId;	
private int kayttajaValtuusId;
private String nimi;
private Kayttaja kayttaja;
private Kayttaja aloittaja;

private Keskustelu keskustelu;






public Kayttaja getAloittaja() {
	return aloittaja;
}
public void setAloittaja(Kayttaja aloittaja) {
	this.aloittaja = aloittaja;
}
public Keskustelu getKeskustelu() {
	return keskustelu;
}
public void setKeskustelu(Keskustelu keskustelu) {
	this.keskustelu = keskustelu;
}
public Kayttaja getKayttaja() {
	return kayttaja;
}
public void setKayttaja(Kayttaja kayttaja) {
	this.kayttaja = kayttaja;
}
public int getKayttajaId() {
	return kayttajaId;
}
public void setKayttajaId(int kayttajaId) {
	this.kayttajaId = kayttajaId;
}
public int getKeskusteluId() {
	return keskusteluId;
}
public void setKeskusteluId(int keskusteluId) {
	this.keskusteluId = keskusteluId;
}
public int getKayttajaValtuusId() {
	return kayttajaValtuusId;
}
public void setKayttajaValtuusId(int kayttajaValtuusId) {
	this.kayttajaValtuusId = kayttajaValtuusId;
}
public String getNimi() {
	return nimi;
}
public void setNimi(String nimi) {
	this.nimi = nimi;
}	





	
	

}
