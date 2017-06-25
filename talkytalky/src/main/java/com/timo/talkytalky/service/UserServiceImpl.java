package com.timo.talkytalky.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timo.talkytalky.bean.Kayttaja;
import com.timo.talkytalky.bean.KayttajaKeskustelu;
import com.timo.talkytalky.bean.KayttajaToken;
import com.timo.talkytalky.bean.KayttajaValtuus;
import com.timo.talkytalky.bean.Keskustelu;
import com.timo.talkytalky.dao.KayttajaDao;
import com.timo.talkytalky.dao.KeskusteluDao;

@Service
public class UserServiceImpl implements UserService {
	
	
@Inject
private KayttajaDao dao;	

@Autowired
private KeskusteluDao kDao;


public KayttajaDao getDao() {
	return dao;
}




public void setDao(KayttajaDao dao) {
	this.dao = dao;
}








public KeskusteluDao getkDao() {
	return kDao;
}




public void setkDao(KeskusteluDao kDao) {
	this.kDao = kDao;
}




public Kayttaja insertKayttaja(Kayttaja k){
	
	
Kayttaja kayttaja=dao.insertKayttaja(k)	;

KayttajaValtuus kv=new KayttajaValtuus();

int kayttajaId=kayttaja.getId();
int valtuusId=1;
kv.setKayttajaId(kayttajaId);
kv.setValtuusId(valtuusId);


dao.lisaaOikeudet(kv);


	
return k;	
}



public Kayttaja haeKayttaja (String email){
	
Kayttaja k= dao.haeKaytta(email);

return k;
	
	
}


public void luoKeskustelu(Keskustelu k, KayttajaValtuus kv){
	
	KayttajaKeskustelu kk= new KayttajaKeskustelu();
	
	int aloittajaId=kv.getKayttajaId();
	k.setAloittajaId(aloittajaId);
	int keskusteluId= kDao.luoKeskustelu(k);
	
	int valtuusId=2;
	int kayttajaId=kv.getKayttajaId();
	kv.setValtuusId(valtuusId);
		
	int kayttajaValtuusId=dao.lisaaOikeudet(kv);
	
	kk.setKayttajaId(kayttajaId);
	kk.setKeskusteluId(keskusteluId);
	kk.setKayttajaValtuusId(kayttajaValtuusId);
	
	kDao.luoKauttajaKeskustelu(kk);
	
	
}




public List<KayttajaKeskustelu> haeKeskustelut(int kayttajaId){
	
	
	List<KayttajaKeskustelu> kkList=kDao.haeKeskustelut(kayttajaId);
	List<KayttajaKeskustelu> keskustelut=new ArrayList<KayttajaKeskustelu>();
	for(int i=0; i<kkList.size(); i++){
	
	int id=kkList.get(i).getKeskustelu().getAloittajaId();
	Kayttaja aloittaja=haeKayttajaTiedot(id);
	KayttajaKeskustelu k=kkList.get(i);
	k.setAloittaja(aloittaja);
	keskustelut.add(k);
		
		
	}
	
	
	return keskustelut;
	
}


public void luoKayttajaToken(KayttajaToken k){
	
	
	dao.lisaaToken(k);
	
}



public KayttajaToken haeKayttajaToken(String tokenString){
	
	KayttajaToken k=dao.haeKayttajaToken(tokenString);
	System.out.println("token: "+k.getKayttaja().getId());
	return k;
	
}

public  Kayttaja haeKayttajaTiedot (int id){
	
	Kayttaja kayttaja=dao.haeKayttajanTiedot(id);
	
	return kayttaja;
	
	
}



public  boolean vaihdaSalasana(Kayttaja k){
	
	
	boolean succes=dao.uusiSalasana(k);
	
	return succes;
	
	
	
}
	

}
