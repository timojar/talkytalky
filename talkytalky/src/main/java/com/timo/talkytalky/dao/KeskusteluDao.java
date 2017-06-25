package com.timo.talkytalky.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.timo.talkytalky.bean.Kayttaja;
import com.timo.talkytalky.bean.KayttajaKeskustelu;
import com.timo.talkytalky.bean.Keskustelu;
import com.timo.talkytalky.rowmapper.KayttajaKeskusteluRowMapper;
import com.timo.talkytalky.rowmapper.KayttajaRowMapper;

@Repository
public class KeskusteluDao {
	
	
	

	@Inject
	private JdbcTemplate jdbcTemplate;

	
	
	
	
public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}





	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	
	
	
	
	public int luoKeskustelu(Keskustelu k){
		
		
		String sql="insert into keskustelu (nimi, pvm, updatedPvm) values (?, ?, ?)";	
		
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "id" });
				ps.setString(1, k.getNimi());
				ps.setTimestamp(2,new Timestamp(System.currentTimeMillis()));
				ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
							
				return ps;
			}
		}, idHolder);

		
		int keskusteluId= idHolder.getKey().intValue();
		
		
		
		
		
		return keskusteluId;
		
	}
	
	
	public void luoKauttajaKeskustelu(KayttajaKeskustelu kk){
		
	String sql="insert into kayttajaKeskustelu (kayttajaId, kayttajavaltuusId, keskusteluId) values (?, ?, ?)";	
		
	
	Object[] parametrit = new Object[] { kk.getKayttajaId(), kk.getKayttajaValtuusId(), kk.getKeskusteluId() };

	jdbcTemplate.update(sql, parametrit);

		
		
	}
	
	
	public List <KayttajaKeskustelu> haeKeskustelut(int kayttajaId) 	{
		
		

		String sql = "select keskusteluId, kayttajaValtuusId, kayttajaid, nimi, pvm, updatedPvm  from kayttajakeskustelu join keskustelu on kayttajakeskustelu.keskusteluid=keskustelu.id join kayttaja on kayttajakeskustelu.kayttajaId=kayttaja.id where kayttajaId=?";
		Object[] parametrit = new Object[] { kayttajaId };
		RowMapper<KayttajaKeskustelu> mapper = new KayttajaKeskusteluRowMapper();

		
		List<KayttajaKeskustelu> kkList = jdbcTemplate.query(sql, parametrit, mapper);
		return kkList;

		
		
		
		
	}
	
	
	
	

}
