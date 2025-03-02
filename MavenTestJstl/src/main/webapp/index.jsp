<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>test_cours</title>
</head>
<body>
<c:set var="upperlimit" value="20" />
<c:forEach var="i" begin="2" end="${upperlimit - 10}" >
    <c:choose>
        <c:when test='${i%2 == 0}'>
            <c:out value='${i} is even' /><br/>
        </c:when>
        <c:otherwise>
            <c:out value='${i} is odd'/><br/>
        </c:otherwise>
    </c:choose>
</c:forEach>
</body>
</html>