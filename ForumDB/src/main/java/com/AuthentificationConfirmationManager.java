package com;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.SQLException;

public class AuthentificationConfirmationManager extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;
    private PreparedStatement ps;
    private Connection con;
    String verifyQuery = "Select name, age from person";
    
	public AuthentificationConfirmationManager() {
        super();
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		String pilote = getServletContext().getInitParameter("jdbc.Driver");
		String databaseUrl = getServletContext().getInitParameter("localisation");
		
		try {
			Class.forName(pilote);
		    con = DriverManager.getConnection(databaseUrl, "root", "");
			ps = con.prepareStatement(verifyQuery);
			
		} 
		catch(ClassNotFoundException e) {
			System.out.println("Driver DB not found");
		}
		catch (SQLException e) {
			System.out.println("DB not found"); 
		}
	}

}
