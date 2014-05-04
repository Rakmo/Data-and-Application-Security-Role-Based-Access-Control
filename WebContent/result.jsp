<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
<center>
	<h2>RBAC System using Pig Queries</h2>
</center>
</head>
<hr>
<hr>
</head>

<body bgcolor="#E6E6FA">
<center>
<h3>*** INPUT QUERY ***</h3>
	<%=session.getAttribute("query")%>

<h3>*** RESULT ***</h3>
<%
 String result = (String) session.getAttribute("result");
 String outputFolder = (String) session.getAttribute("outFolder");
	if (result.startsWith("Success")) 
	{			
		String filePath = "/home/omkya/DAS_Pig/"+outputFolder;  
		FileReader file = new FileReader(filePath);
        BufferedReader br = new BufferedReader(file);
     
        String s;  
        // data extraction:  
        while ((s = br.readLine()) != null) {  
         // other code
        out.print(s+"<br>");
        }  
	} 
	else 
	{
		out.print("<br><br>ERROR: "+result);
	}
	
%>
<br><br>
<input type="button" value="Back" onclick="window.history.back()">
 </center>
</body>
</html>