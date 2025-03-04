package com;

import java.util.List;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService() {
        this.studentDAO = new StudentDAO();
    }

    // Method to add a student
    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    // Method to get a student by ID
    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    // Method to get all students
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    // Method to delete a student by ID
    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }
}
