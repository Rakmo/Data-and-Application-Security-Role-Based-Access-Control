<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.PigQueryParser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script type="text/javascript">
function validate()
{
	String query = document.getElementsByName("query"); 
	if(query.equals(null))
		return false;
		
 return true;
}
</script>
<center>
	<h2>RBAC System using Pig Queries</h2>
</center>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query Here</title>
</head>
<hr>
<hr>


<body bgcolor="#E6E6FA">
<center>
	The role selected is <b><u><%=request.getParameter("role") %></u></b>

	<%
	String role=request.getParameter("role");
	session.setAttribute("role", role);
	%>


	<form name="queryForm" action='uploadFile.jsp' method="post">
	<br>
	The datasets available to fire a query -> <b><i>salaries, contacts</i></b> and <b><i>departments</i></b>
	<br>Role - employee can only access the datasets (contacts and departments)
	<br>Role - administrator can access all the datasets (salaries, contacts and departments)
	<br>
		<table>
			<tr>
				<td><label>Write Your Pig Query Here:</label></td>
				<td><textarea name="query" rows="5" cols="50"></textarea></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" onClick="return validate();" value="G0" />&nbsp; <input type="button" value="Back" onclick="window.history.back()"></td>
			</tr>
		</table>
	</form>

</center>
</body>
</html>