<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<center>
	<h2>RBAC System using Pig Queries</h2>
</center>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome !!</title>
</head>
<hr>
<hr>
<body bgcolor="#E6E6FA">

	<form method="post" action="query.jsp">
		<center>
			<h2>
				<h3>Please, Select your role!</h3>
				<br> 
				<INPUT TYPE="radio" NAME="role" VALUE="administrator" />Administrator
				<INPUT TYPE="radio" NAME="role" VALUE="employee" />Employee 
				<br>
				<INPUT TYPE="submit" VALUE="submit" /> 
			</h2>
		</center>
	</form>
	
	
</body>
</html>