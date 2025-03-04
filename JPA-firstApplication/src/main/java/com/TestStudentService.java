package com;

public class TestStudentService {
    public static void main(String[] args) {
        // Create StudentService instance
        StudentService studentService = new StudentService();

        // Add new students
        Student student1 = new Student(7, "John Doe");
        Student student2 = new Student(9, "Jane Smith");
        
        studentService.addStudent(student1);
        studentService.addStudent(student2);

        // Get and print all students
        System.out.println("All students:");
        for (Student student : studentService.getAllStudents()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }

        // Get student by ID
        Student retrievedStudent = studentService.getStudentById(1);
        System.out.println("\nRetrieved student:");
        System.out.println("ID: " + retrievedStudent.getId() + ", Name: " + retrievedStudent.getName());

        // Delete a student
        studentService.deleteStudent(1);

        // Get and print all students after deletion
        System.out.println("\nAll students after deletion:");
        for (Student student : studentService.getAllStudents()) {
            System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
        }
    }
}
