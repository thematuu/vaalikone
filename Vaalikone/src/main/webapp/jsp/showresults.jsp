<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.questions" %>   
 <%@ page import="data.candidate" %> 
 <%@ page import = "java.io.*,java.util.*" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone Results</title>
</head>
<body>
<h2>Results: </h2>
<br>
<p>TEST: ${candidateAnswer} </p>
<%

ArrayList<questions> questionList=(ArrayList<questions>)request.getAttribute("questionList");
ArrayList<candidate> candidateList=(ArrayList<candidate>)request.getAttribute("candidateList");

for (int j=0;candidateList!=null && j<candidateList.size();j++){
	candidate c=candidateList.get(j);
	out.println("<p>candidate ID: "+c.getId()+"</p>");
	for (int i=0;questionList!=null && i<questionList.size();i++){
		questions q=questionList.get(i);
		out.println("<p>questions ID: "+q.getId()+"</p>");

	}
}
%>	
	
<br><br>
<h2>Have a nice day! </h2>
	

</body>
</html>