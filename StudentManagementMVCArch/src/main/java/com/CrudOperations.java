package com;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CrudOperations {
    private static String selectQuery ="Select * from students";
    private static String addQuery = "Insert into students (name ,mail, course, year) Values (?, ?, ?, ?)";
    private static String deleteQuery = "delete from students where id=?";
    private static String updateQuery = "Update students set name=?, mail=?, course=?, year=? where id=?";


	public static boolean addStudent(Student student) {
		ConnexionBD db = new ConnexionBD();
		PreparedStatement ps;
		try {
			ps = db.con.prepareStatement(addQuery);
			ps.setString(1,student.name);
			ps.setString(2,student.mail);
			ps.setString(3,student.course);
			ps.setInt(4,student.year);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		return true;

	}
	
	public static ArrayList<Student> DisplayStudentList(){
		ConnexionBD db = new ConnexionBD();
		PreparedStatement ps;
		ArrayList<Student> studentList = null;
		try {
		ps = db.con.prepareStatement(selectQuery);
		
		ResultSet res = ps.executeQuery();
		// Getting the list of students
		studentList = new ArrayList<Student>();
		while(res.next()) {
			Student student = new Student();
			student.setId(res.getInt(1));
			student.setName(res.getString(2));
			student.setMail(res.getString(3));
			student.setCourse(res.getString(4));
			student.setYear(res.getInt(5));
			studentList.add(student);
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentList;
	}

	public static boolean deleteStudent(int studentId) {
		try {
			ConnexionBD db = new ConnexionBD();
			PreparedStatement ps = db.con.prepareStatement(deleteQuery);
			ps.setInt(1, studentId);
			ps.executeUpdate();
			return true;
		} catch(SQLException e ) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean updateStudent(Student student, int studentId) {
		ConnexionBD db = new ConnexionBD();
		try { 
			PreparedStatement ps = db.con.prepareStatement(updateQuery);
			ps.setString(1, student.getName());
			ps.setString(2, student.getMail());
			ps.setString(3, student.getCourse());
			ps.setInt(4, student.getYear());
			ps.setInt(5, studentId);

			ps.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		}
}
