package com.timo.talkytalky.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.timo.talkytalky.bean.Kayttaja;

public class KayttajaRowMapper implements RowMapper<Kayttaja> {

	
	

public Kayttaja  mapRow(ResultSet rs, int rownumber) throws SQLException{
	
	
	Kayttaja k=new Kayttaja();
	
	k.setId(rs.getInt("id"));
	k.setEtunimi(rs.getString("etunimi"));
	k.setSukunimi(rs.getString("sukunimi"));
	k.setEmail(rs.getString("email"));
	k.setSalasana(rs.getString("salasana"));
	
	
	
	
	return k;
	
	
	
}
	
	
	
	
}
