<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
     <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.questions" %> 
 <%@ page import="dao.Dao" %>  
  <%@ page import="data.candidate" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidates</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<h1>Candidates</h1>
<%
String party = request.getParameter("party");
if(party.equals("Vihreat")){
	party = "Vihreät";
}
ArrayList<candidate> questionList=(ArrayList<candidate>)request.getAttribute("questionList");
for (int i=0;questionList!=null && i<questionList.size();i++){
	candidate q=questionList.get(i);

	if(q.getCandidateParty().equals(party)){
		out.println("<div class='grid-item'>");
		out.println("<p> First Name: <b>"+q.getCandidateFirstName() +"</b><br>Last Name: <b>"+q.getCandidateLastName()+ "</b><br>Party: <b>"+q.getCandidateParty()+"</b></p>");
		out.println("</div>");
	}
	
	
}
%>
</body>
</html>