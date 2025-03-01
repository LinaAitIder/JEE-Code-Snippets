<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit/Add Student</title>
</head>
<body>

<h3>Edit/Add Student</h3>
<form action="ActionController?action=${action}&student_id=${studentId}" method="post">
<input placeholder="name"  name="name" type="text" />
<input placeholder="email" name="mail" type="text" />
<input placeholder="course" name="course" type="text"/>
<input placeholder="year" name="year" type="text"/>
<input value="submit"  type="submit"/>
</form>

	
</body>
</html>