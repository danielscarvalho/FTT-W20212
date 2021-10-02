package ftt.ec.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	
	private static Connection conexao = null; //transformar em Sigleton... (design pattern) 

	public static Connection getDbConnection() {
		
			//https://docs.microsoft.com/pt-br/sql/connect/jdbc/microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
			//jdbc:sqlserver://localhost;user=MyUserName;password=*****;
			
			if (conexao != null) {
				return conexao; 
			} else {
						
				try {
					
					System.out.println("Connectando no BD via JDBC...");
					
		            Class.forName("com.mysql.cj.jdbc.Driver");
					
					conexao = DriverManager.getConnection(
					        "jdbc:mysql://localhost/ftt?serverTimezone=GMT-3",
					        "scott",
					        "T1ger!");
					
					System.out.print(conexao);
					
				} catch (Exception e) { //SQLException
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //try
				
			} //if
			
			return conexao;
		
	} //getDbConnection
	
} //DbConnect
