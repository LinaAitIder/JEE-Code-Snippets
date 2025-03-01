package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    
    public ActionController() {
        super();
    }
    

    public void init() throws ServletException {
        try {
            Context context = new InitialContext();
            DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/students");
            con = ds.getConnection();
        } catch (NamingException | SQLException e) {
            throw new ServletException("Database connection failed", e);
        }
    }

    public void destroy() {
        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		//fetch data
		if(action.equals("select")) {
			ArrayList<Student> Students = CrudOperations.DisplayStudentList();
			if(Students == null || Students.isEmpty()) {
		        System.out.println("No students retrieved from the database!");
		    } else {
		        System.out.println("Students retrieved: " + Students.size());
		    }
			request.setAttribute("studentList", Students);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			
		}
		
		// Add student
		if(action.equals("add")) {
			//response.sendRedirect("Formulaire.html");
			request.setAttribute("action", "add");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Formulaire.jsp");
			dispatcher.forward(request, response);
		}
		
		//Delete student
		if(action.equals("delete")) {
			int student_id = Integer.parseInt(request.getParameter("student_id"));

			boolean deletedStudent=CrudOperations.deleteStudent(student_id);
			if (deletedStudent) {
				response.sendRedirect("/index.jsp");
			} else {
				System.out.println("The student was not deleted");
			}
		}
		
		//update student data
		if(action.equals("update")) {
			int student_id = Integer.parseInt(request.getParameter("student_id"));
			request.setAttribute("action", "update");
			request.setAttribute("studentId", student_id);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Formulaire.jsp");
			dispatcher.forward(request, response);
		}

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		Student student=new Student();
		student.setName(request.getParameter("name"));
		student.setMail(request.getParameter("mail"));
		student.setCourse(request.getParameter("course"));
		student.setYear(Integer.parseInt(request.getParameter("year")));
		//Inserting Student
		if(action.equals("insert")) {
			boolean inserted = CrudOperations.addStudent(student);
			if(inserted) {  System.out.println("there's nothing wrong with the request") ; }
			else { System.out.println("there's something wrong with the request");  }
			response.sendRedirect("index.jsp");
		}
		
		if(action.equals("update")) {
			int studentId = Integer.parseInt(request.getParameter("student_id"));
			boolean updatedStudent = CrudOperations.updateStudent(student ,studentId);
			if(updatedStudent) {
				System.out.print("Updated student");
				response.sendRedirect("index.jsp");
			} else {
				System.out.println("Student was not updated");
			}
		}
	}

}
