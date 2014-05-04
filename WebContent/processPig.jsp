<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.*"%>
<%@ page import="org.apache.pig.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Processing Pig Query</title>
<center>
	<h2>RBAC System using Pig Queries</h2>
</center>
</head>
<hr>
<hr>
</head>
<body bgcolor="#E6E6FA">
	<center>
	File:
	<%
		String filepath = (String) session.getAttribute("filepath");
		out.println(""+filepath);
	%>
	 <br>
	<br>
	<b>Input Query:</b>
	<%=session.getAttribute("query")%>
	<br>
	<%			
		PigQueryParser qParser = new PigQueryParser();
		// Extracting the resources that user is trying to access!!
		String resourceName = qParser.getDatasetFileName(filepath);
		String role = (String) session.getAttribute("role");
        if(resourceName.equals("salaries") && role.equals("employee"))
        {
        	out.println("<br><br><b><i><font color='red'> Sorry, your role is not eligible to access 'salaries' dataset.</font></i></b>");
        	out.println("<br><br><b><i><font color='green'> You can only access the datasets (contacts and departments).</font></i></b>");
        	%>
        	<br>
        	<br>
        	<input type="button" value="Back" onclick="window.history.back()">
        	<%
        }
        else
        {
		 	
			String result = new PigClient().executeQuery(filepath);
			session.setAttribute("result", result);
	
			System.out.print(result);
			if (result.equalsIgnoreCase("Success!")) 
			{			
				String outFolder = qParser.getOutputFolderName(filepath);
				
				session.setAttribute("outFolder", outFolder);
				// Calling the HDFS client to read the output given by the PIG Query from HDFS.
				HdfsClient client2 = new HdfsClient();
				client2.readFile(outFolder);
				
			} 
			else 
			{
				session.setAttribute("result", result);
			}
			response.sendRedirect("result.jsp");
        }
	%>
	</center>
</body>
</html>