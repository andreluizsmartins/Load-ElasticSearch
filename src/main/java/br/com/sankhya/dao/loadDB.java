package br.com.sankhya.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.sankhya.api.apiElastic;
import br.com.sankhya.db.FabricaDeConnection;

public class loadDB {

	public loadDB() {
		// TODO Auto-generated constructor stub
	}

	
	public static void get() {
		
		Statement stmt = null;
		ResultSet rs = null;
		Connection c = FabricaDeConnection.ObterConexaoOracle();
		StringBuilder json = new StringBuilder();
		try {

			
			stmt = c.createStatement();
			rs = stmt.executeQuery("select * from ELK_TGFPRO");
			 JSONArray jsonArray = new JSONArray();
			while (rs.next()) {
				JSONObject obj = new JSONObject();
				JSONObject obj2 = new JSONObject();
				JSONObject obj3 = new JSONObject();
	            int total_rows = rs.getMetaData().getColumnCount();
	            for (int i = 0; i < total_rows; i++) {
	                obj.put(rs.getMetaData().getColumnLabel(i + 1)
	                        .toLowerCase(), rs.getObject(i + 1));

	            }
	            obj2.put("_index", "sankhya_tgfpro");
	            obj2.put("_id", rs.getString("codprod"));
	            obj3.put("create", obj2);
	            
	            json.append(obj3+"\n"+obj+"\n");
	           // apiElastic.setDoc(obj.toString(), obj3.toString());
	            //jsonArray.put(obj);

			}
			
			stmt.close();
			c.close();	
					

		} catch (Exception e) {
			
			System.err.print(e.getMessage());
		}

		System.out.println(json.toString());
		apiElastic.setDoc(json);
		
		
	}
}
