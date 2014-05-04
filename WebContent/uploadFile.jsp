<%@ page import="java.io.*"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.io.File"%>

<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<%
		//to get the content type information from JSP Request Header
		String query = (String) request.getParameter("query");
		out.print("-------> "+query);
		session.setAttribute("query", query);
       	String filepath = "/home/omkya/DAS_Pig/temp.pig";
		FileOutputStream fos= new FileOutputStream(filepath, false);

		session.setAttribute("filepath", filepath);
	    PrintWriter printWriter = new PrintWriter(fos);//, true));

	    printWriter.println(query);	    

	    printWriter.close();
		
%>
<Br>
<b>You have successfully upload the PIG Query file <%out.println(filepath);%> 
	on the server
</b>
<br />
<b>Please wait while we are executing the Query at the back-end for
	the User: </b>

<%
	RequestDispatcher dispatcher = request.getRequestDispatcher("processPig.jsp");
	dispatcher.forward(request, response );
%>

