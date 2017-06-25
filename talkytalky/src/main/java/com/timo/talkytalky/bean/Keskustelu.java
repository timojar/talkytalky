package com.timo.talkytalky.bean;

import java.sql.Timestamp;

public class Keskustelu {
	
private int id;
private String nimi;
private Timestamp pvm;
private String pvmStr;
private Timestamp upDatedPvm;
private int aloittajaId;




public int getAloittajaId() {
	return aloittajaId;
}
public void setAloittajaId(int aloittajaId) {
	this.aloittajaId = aloittajaId;
}
public String getPvmStr() {
	return pvmStr;
}
public void setPvmStr(String pvmStr) {
	this.pvmStr = pvmStr;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNimi() {
	return nimi;
}
public void setNimi(String nimi) {
	this.nimi = nimi;
}
public Timestamp getPvm() {
	return pvm;
}
public void setPvm(Timestamp pvm) {
	this.pvm = pvm;
}
public Timestamp getUpDatedPvm() {
	return upDatedPvm;
}
public void setUpDatedPvm(Timestamp upDatedPvm) {
	this.upDatedPvm = upDatedPvm;
}
@Override
public String toString() {
	return "Keskustelu [id=" + id + ", nimi=" + nimi + ", pvm=" + pvm
			+ ", upDatedPvm=" + upDatedPvm + "]";
}





	
	

}
