package br.com.sankhya.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class FabricaDeConnection {

	
	

		public FabricaDeConnection() {
			// TODO Auto-generated constructor stub
		}


	public static Connection ObterConexaoOracle() {

		    Connection conexao = null;
		    try {
		    	
		         Class.forName("oracle.jdbc.driver.OracleDriver");
		        
		         conexao = DriverManager.getConnection("jdbc:oracle:thin:@//127.0.0.1:1521/SKCONTAINER", "SKCONTAINER","tecsis" );
		         
		    
		    } catch (ClassNotFoundException e) {
		            
		    	
			      
		    	e.printStackTrace();
		    } catch (SQLException e) {
		    
			           
		    	
		    	e.printStackTrace();
		    	System.out.println(e.getMessage());
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Banco OK");
		    return conexao;
		}
	
}
