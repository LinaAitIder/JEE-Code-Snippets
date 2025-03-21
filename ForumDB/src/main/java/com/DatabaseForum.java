package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DatabaseForum extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PreparedStatement ps;
    private Connection con;
    private String addQuery = "Insert into person (name, age) Values (?, ?)";
    private String deleteQuery = "delete from person (name, age) Values (?, ?)";

 
    public DatabaseForum() {
        super();
    }

    @Override
	public void init() throws ServletException {
		try {		
			Context context = new InitialContext();
			DataSource pilote =(DataSource)context.lookup("java:comp/env/jdbc/jeedb");
			con = pilote.getConnection();
			ps = con.prepareStatement(addQuery);	
		} catch (NamingException e) {
	        throw new ServletException("JNDI lookup failed", e);
		} catch (SQLException e) {
	        throw new ServletException("Database connection failed", e); 
		}
	}

    @Override
	public void destroy() {
		if(con!=null) {
			try {
				con.close();
				ps.close();
			} catch(SQLException e) {
				log("Erreur Fermeture BD");
			}
		}
	}

	
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter sortie = response.getWriter();
			HttpSession session = request.getSession(false);
			System.out.println(session.getId());
			sortie.println("<HTML><HEAD><TITLE>Reponse Formulaire</TITLE></HEAD></BODY>");
			if(session!=null) {
				ps.setString(1, (String)session.getAttribute("nom"));
				ps.setInt(2, Integer.parseInt((String)session.getAttribute("age")));
				ps.executeUpdate();
				sortie.println("<H2>Enregistrement de vos coordonee effectue</H2>");
				sortie.println("</body></html>");
				session.invalidate();
			} else {
				sortie.println("<H3>Il faut d'abord saisir vos coordonne : ");
				sortie.println("<a href=\"DatabaseForum\">Retour</a></h3>");
				sortie.println("</body></html>");
			}
		
		} catch(SQLException e) { log("Personne non enregistree");}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		String name=request.getParameter("name");
		int age;
		try {
		age = Integer.parseInt(request.getParameter("age"));
		} catch(NumberFormatException e) {
			throw e;
		}
		if (ps == null) {
	            log("PreparedStatement is null in doPost(). Initialization may have failed.");
	            response.getWriter().append("Error: PreparedStatement is not initialized.");
	            return;
	        }
		  
		try {
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.executeUpdate();
			
			response.setContentType("text/html");
			PrintWriter sortie = response.getWriter();
			sortie.println("<html><head><title>Reponse formulaire</title></head></html>");
			sortie.println("<H2>Enregistrement de vos coordonne effectue</h2>");
			sortie.println("<body></html>");
		} catch(SQLException e) { 
			log("SQL Exception in doPost()", e);
			e.printStackTrace();
		}
	}

}
