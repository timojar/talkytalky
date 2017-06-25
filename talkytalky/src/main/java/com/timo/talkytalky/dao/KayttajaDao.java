package com.timo.talkytalky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.timo.talkytalky.Salaaja;
import com.timo.talkytalky.bean.Kayttaja;
import com.timo.talkytalky.bean.KayttajaKeskustelu;
import com.timo.talkytalky.bean.KayttajaToken;
import com.timo.talkytalky.bean.KayttajaValtuus;
import com.timo.talkytalky.rowmapper.KayttajaRowMapper;
import com.timo.talkytalky.rowmapper.KayttajaTokenRowMapper;

@Repository
public class KayttajaDao {
	
	

	
	@Inject
	private JdbcTemplate jdbcTemplate;

	
	
	
	
public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}





	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}





public	Kayttaja insertKayttaja(Kayttaja k){
	
	String sql="insert into kayttaja (enabled, etunimi, sukunimi, email, salasana) values (?, ?, ?, ?, ?)";
	

	Salaaja salaaja=new Salaaja();
	// jdbc pistää generoidun id:n tänne talteen
	KeyHolder idHolder = new GeneratedKeyHolder();
	String sana=k.getSalasana();
String salasanaKryptattuna=salaaja.salaa(sana);
	k.setSalasanaKryptattuna(salasanaKryptattuna);
	// suoritetaan päivitys itse määritellyllä PreparedStatementCreatorilla
	// ja KeyHolderilla
	jdbcTemplate.update(new PreparedStatementCreator() {
		public PreparedStatement createPreparedStatement(
				Connection connection) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(sql,
					new String[] { "id" });
			ps.setInt(1, 1);
			ps.setString(2, k.getEtunimi());
			ps.setString(3, k.getSukunimi());
			ps.setString(4, k.getEmail());
			ps.setString(5, k.getSalasanaKryptattuna());
			
			return ps;
		}
	}, idHolder);

	// tallennetaan id takaisin beaniin, koska
	// kutsujalla pitäisi olla viittaus samaiseen olioon
	k.setId(idHolder.getKey().intValue());	
	
	
	
	
	
	return k;
}
	


public int lisaaOikeudet(KayttajaValtuus kv){
	
	
	String sql="insert into kayttajaValtuus (  kayttajaId, valtuusId) values ( ?, ?)";
			
	KeyHolder idHolder = new GeneratedKeyHolder();
	
	
	
	jdbcTemplate.update(new PreparedStatementCreator() {
		public PreparedStatement createPreparedStatement(
				Connection connection) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(sql,
					new String[] { "id" });
			ps.setInt(1, kv.getKayttajaId());
			ps.setInt(2, kv.getValtuusId());
		
			
			
			return ps;
		}
	}, idHolder);

	
	int kayttajaValtuusId=idHolder.getKey().intValue();
	
	
	return kayttajaValtuusId;
	
}

	
	
	
public Kayttaja haeKaytta(String email) 	{
	
	

	String sql = "select * from kayttaja where email = ?";
	Object[] parametrit = new Object[] { email };
	RowMapper<Kayttaja> mapper = new KayttajaRowMapper();

	Kayttaja k = jdbcTemplate.queryForObject(sql, parametrit, mapper);
	return k;

	
	
}



public Kayttaja haeKayttajanTiedot(int id)throws EiLoydyPoikkeus 	{
	
	

	String sql = "select * from kayttaja where id = ?";
	System.out.println("string lause ja id "+3);
	Object[] parametrit = new Object[] { id };
	RowMapper<Kayttaja> mapper = new KayttajaRowMapper();

	Kayttaja k = jdbcTemplate.queryForObject(sql, parametrit, mapper);
	System.out.println("toimiiko? "+k.toString());
	return k;

	
	
}



public void lisaaToken(KayttajaToken k){
	

	
	String sql="insert into kayttajaToken (kayttajaId, tokenString) values (?, ?)";	
	
	
	
	
KeyHolder idHolder = new GeneratedKeyHolder();
	
	
	
	jdbcTemplate.update(new PreparedStatementCreator() {
		public PreparedStatement createPreparedStatement(
				Connection connection) throws SQLException {
			PreparedStatement ps = connection.prepareStatement(sql,
					new String[] { "id" });
			ps.setInt(1, k.getKayttaja().getId());
			ps.setString(2, k.getTokenString());
		
			
			
			return ps;
		}
	}, idHolder);

	
	
}



public KayttajaToken haeKayttajaToken(String tokenString){
	
	String sql = "select * from kayttajatoken where tokenString = ?";
	Object[] parametrit = new Object[] { tokenString };
	RowMapper<KayttajaToken> mapper = new KayttajaTokenRowMapper();

	KayttajaToken k = jdbcTemplate.queryForObject(sql, parametrit, mapper);
	return k;

	
	
	
	
	
	
}






public boolean uusiSalasana(Kayttaja k){
	
	boolean succes=false;
	
	Salaaja salaaja=new Salaaja();
	
	String sql="update kayttaja set salasana=? where id=?";	
	
	String sana=k.getSalasana();
	
	String salasanaKryptattuna=salaaja.salaa(sana);
	
	Object[] parametrit = new Object[] {salasanaKryptattuna, k.getId() };

	try {
		jdbcTemplate.update(sql, parametrit);
		
		succes=true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	
		
	return succes;
	
	}






}
