package com.timo.talkytalky.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.timo.talkytalky.bean.Kayttaja;
import com.timo.talkytalky.bean.KayttajaToken;



public class KayttajaTokenRowMapper implements RowMapper<KayttajaToken>  {
	
	
	
	
	
	
	public KayttajaToken  mapRow(ResultSet rs, int rownumber) throws SQLException{
		
		Kayttaja kayttaja=new Kayttaja();
		KayttajaToken k=new KayttajaToken();
		
		k.setId(rs.getInt("id"));
		k.setTokenString(rs.getString("tokenString"));
		kayttaja.setId(rs.getInt("kayttajaId"));
		k.setKayttaja(kayttaja);
		
		
		
		
		return k;
		
			
	
	
	}
	
	
	
	
	

}
