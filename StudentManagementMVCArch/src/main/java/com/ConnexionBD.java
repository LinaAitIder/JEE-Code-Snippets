package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBD {
	private Statement s;
	public Connection con;
	public ConnexionBD() {
		String pilote = "com.mysql.cj.jdbc.Driver";
		String databaseUrl = "jdbc:mysql://localhost:3306/students";
		try {
			try {
				Class.forName(pilote);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    con = DriverManager.getConnection(databaseUrl, "root", "");
		    s = con.createStatement();
		} catch(SQLException e ) {
			e.printStackTrace();
		}
		
		
	}
}
