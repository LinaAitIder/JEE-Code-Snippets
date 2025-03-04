<%@ page import="com.Student, com.StudentService" %>
<%@ page import="java.util.List" %>
<%
    StudentService studentService = new StudentService();
    List<Student> students = studentService.getAllStudents();
%>
<!DOCTYPE html>
<html>
<head>
    <title>All Students</title>
</head>
<body>
    <h1>All Students</h1>
    <ul>
        <% for (Student student : students) { %>
            <li>ID: <%= student.getId() %>, Name: <%= student.getName() %></li>
        <% } %>
    </ul>
</body>
</html>
