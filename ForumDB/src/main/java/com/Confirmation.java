package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class Confirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Confirmation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String nom = request.getParameter("name");
		String age= request.getParameter("age");
		session.setAttribute("nom", nom);
		session.setAttribute("age", age);
		String sessionId = session.getId();
		System.out.println(sessionId);
		String url = response.encodeURL(request.getContextPath()+"/DatabaseForum");
		response.setContentType("text/html");
		PrintWriter sortie = response.getWriter();
		sortie.println("<HTML><HEAD><TITLE></TITLE><HEAD>");
		sortie.println("<BODY>");
		sortie.println("<h2>Confirmation</h2>");
		sortie.println("<h3>Nom :"+nom+"</h3>");
		sortie.println("<h3>Age :"+age+"</h3>");
		sortie.println("Confirmez-vous votre saisie? ---");
		sortie.println("<a href=\""+url+"\">Confirmer</a></h3>);");
		sortie.println("<BODY><HTML>");
		sortie.flush();
		sortie.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
