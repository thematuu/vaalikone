<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.questions" %>   
 <%@ page import="data.candidate" %> 
 <%@ page import="data.ResultScoring" %> 
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
<%

//ArrayList<questions> questionList=(ArrayList<questions>)request.getAttribute("questionList");
ArrayList<candidate> candidateList=(ArrayList<candidate>)request.getAttribute("candidateList");
ArrayList<ResultScoring> Scorelist=(ArrayList<ResultScoring>)request.getAttribute("Scorelist");
// for (int j=0;candidateList!=null && j<candidateList.size();j++){
// 	candidate c=candidateList.get(j);
// 	out.println("<p>candidate ID: "+c.getId()+"</p>");
// 	for (int i=0;questionList!=null && i<questionList.size();i++){
// 		questions q=questionList.get(i);
// 		out.println("<p>questions ID: "+q.getId()+"</p>");

// 	}
// }
for (int i = 0; Scorelist != null && i < Scorelist.size(); i++) {
			int rank = i+1;
			ResultScoring s = Scorelist.get(i);
			out.println("<h1>Compatibility ranking: " + rank +". </h1>");
			out.println("<p>Candidate ID: " + s.getId()+"</p>");
			for (int j=0;candidateList!=null && j<candidateList.size();j++){
			 	candidate c=candidateList.get(j);
			 	if(c.getId()==s.getId()){
			 		out.println("<p>Candidate Name: " + c.getFirstName()+" " + c.getLastName()+"</p>");

			 		
			 	}
			}
			out.println("<p> Candidate TotalPoints: " + s.getTotalPoints()+"</p>");
			out.println("<br>");
		}
%>	
	
<br><br>
	

</body>
</html>