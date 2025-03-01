<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page import="java.util.List"%>
<%@ page import="com.Student"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Student-List</title>
</head>
<body>

	<table class="table container">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Name</th>
				<th scope="col">Mail</th>
				<th scope="col">Course</th>
				<th scope="col">Year</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${studentList}">
				<tr>
					<td><c:out value='${student.id}' /></td>
					<td><c:out value='${student.name}' /></td>
					<td><c:out value='${student.mail}' /></td>
					<td><c:out value='${student.course}' /></td>
					<td><c:out value='${student.year}' /></td>
					<td><a
						href="ActionController?action=delete&student_id=${student.id}"><i
							class="bi bi-trash3-fill"></i></a></td>
					<td><a
						href="ActionController?action=update&student_id=${student.id}"><i
							class="bi bi-pencil-square"></i> </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="ActionController?action=select" class="btn btn-primary">Charger
			les données</a> <a href="ActionController?action=add"
			class="btn btn-primary">Add Student</a>
	</div>
</body>
</html>