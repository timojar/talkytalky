package com.timo.talkytalky.service;

import java.util.List;

import com.timo.talkytalky.bean.Kayttaja;
import com.timo.talkytalky.bean.KayttajaKeskustelu;
import com.timo.talkytalky.bean.KayttajaToken;
import com.timo.talkytalky.bean.KayttajaValtuus;
import com.timo.talkytalky.bean.Keskustelu;

public interface UserService {
	
	
	public abstract Kayttaja insertKayttaja(Kayttaja k);	
	
	public abstract Kayttaja haeKayttaja (String email);
	
	public abstract List<KayttajaKeskustelu> haeKeskustelut(int kayttajaId);
	
	public abstract void luoKeskustelu(Keskustelu k, KayttajaValtuus kv);
	
	public abstract void luoKayttajaToken(KayttajaToken k);
	
	public abstract KayttajaToken haeKayttajaToken(String tokenString);
	
	public abstract Kayttaja haeKayttajaTiedot (int id);
	
	public abstract boolean vaihdaSalasana(Kayttaja k);	

}
