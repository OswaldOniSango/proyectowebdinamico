package com.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
		Connection con;
		String dbUrl = "jdbc:mysql://localhost/dbShoppingCart?serverTimezone=UTC";
		String dbUser = "root";
		String dbPass = "";
		public Connection obtenerConexion(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			}catch(Exception e) {
				e.printStackTrace();
			}
			return con;
		}
	

}
