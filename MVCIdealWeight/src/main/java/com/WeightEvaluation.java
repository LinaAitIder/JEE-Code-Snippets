package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class WeightEvaluation extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public WeightEvaluation() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double weight = Double.parseDouble(request.getParameter("poids"));
		double taille = Double.parseDouble(request.getParameter("taille"));
		String name = request.getParameter("name");
		Person person = new Person();
		person.setTaille(taille);
		person.setName(name);
		person.setPoids(weight);
		double fitvariation=person.getFit();
		if(fitvariation<18.5) {
			request.setAttribute("person", person);
			RequestDispatcher view = request.getRequestDispatcher("slim.jsp");
			view.forward(request, response);		
		} else if(fitvariation>= 18.5 && fitvariation<25) {
			request.setAttribute("person", person);
			RequestDispatcher view = request.getRequestDispatcher("normal.jsp");
			view.forward(request, response);
		} else if(fitvariation >=25 && fitvariation<30) {
			request.setAttribute("person", person);
			RequestDispatcher view = request.getRequestDispatcher("Obese.jsp");
			view.forward(request, response);
		} else {
			request.setAttribute("person", person);
			RequestDispatcher view = request.getRequestDispatcher("Obese.jsp");
			view.forward(request, response);
		}
		
	}

}
