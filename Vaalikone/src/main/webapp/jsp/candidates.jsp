<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
     <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.questions" %> 
 <%@ page import="app.Login" %> 
 <%@ page import="dao.Dao" %>  
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
ArrayList<questions> questionList=(ArrayList<questions>)request.getAttribute("questionList");
for (int i=0;questionList!=null && i<questionList.size();i++){
	questions q=questionList.get(i);
	out.println("<div class='grid-item'>");
	out.println("<p>ID: "+q.getId()+"  Candidate: "+q.getCandidate());
	out.println("</div>");
}
%>

</body>
</html>