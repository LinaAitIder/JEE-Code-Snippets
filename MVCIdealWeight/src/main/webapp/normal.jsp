<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Hello  ${person.name}  </h3>
	<h6>Your are normal! Keep going</h6>
</body>
</html>

<!--
We can get information from the requestDispatcher that was forwarded using different ways :
- ${key.attribute} exemple : ${object.attribute}
- <jsp:useBean id="key" type="somePackage.ValueObject" scope="request" />
<jsp:getProperty name="key" property="someProperty"/>
-->
