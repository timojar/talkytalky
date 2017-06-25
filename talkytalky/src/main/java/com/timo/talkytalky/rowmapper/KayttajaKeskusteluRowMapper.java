package com.timo.talkytalky.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;






import com.timo.talkytalky.bean.KayttajaKeskustelu;
import com.timo.talkytalky.bean.Keskustelu;

public class KayttajaKeskusteluRowMapper implements RowMapper<KayttajaKeskustelu> {
	
	
	
	
	
	
	public KayttajaKeskustelu  mapRow(ResultSet rs, int rownumber) throws SQLException{
		
		Keskustelu keskustelu=new Keskustelu();
		KayttajaKeskustelu kk=new KayttajaKeskustelu();
		
		
		kk.setKayttajaId(rs.getInt("kayttajaId"));
		kk.setKayttajaValtuusId(rs.getInt("kayttajaId"));;
		kk.setKeskusteluId(rs.getInt("keskusteluId"));
		keskustelu.setNimi(rs.getString("nimi"));
		keskustelu.setPvm(rs.getTimestamp("pvm"));
		keskustelu.setUpDatedPvm(rs.getTimestamp("updatedPvm"));
		keskustelu.setAloittajaId(rs.getInt("aloittajaId"));
		Timestamp pvm=keskustelu.getPvm();
		System.out.println(rs.getTimestamp("updatedPvm")+" testissä");
		System.out.println("testissä 3 "+keskustelu.getPvm());
		String pvmStr=formDate(pvm);
		keskustelu.setPvmStr(pvmStr);
		kk.setKeskustelu(keskustelu);
		
		
		
		
		
		
		
		return kk;	
	
	
	}
	
	
	private String formDate(Timestamp pvm){
		
		Date time=pvm;
		System.out.println(pvm+" testissä 2");
		SimpleDateFormat format =new SimpleDateFormat("dd-MM-yyyy");
		
		
		String pvmStr=format.format(time);
		
		return pvmStr;
		
		
		
		
		
		
	}

}
