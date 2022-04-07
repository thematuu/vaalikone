<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.questions" %>
 <%@ page import="data.answers" %>  
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Candidate Answers</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<% 	String candidateFirstname = String.valueOf(request.getAttribute("candidateFirstName"));
	String candidateLastname = String.valueOf(request.getAttribute("candidateLastName"));
%>
<h2>Candidate <%out.println(candidateFirstname + " " + candidateLastname);%> answers: </h2>
<br><br>
	
	<div class='grid-container'>
<%
ArrayList<answers> answerList=(ArrayList<answers>)request.getAttribute("answerList");
ArrayList<questions> questionList=(ArrayList<questions>)request.getAttribute("questionList");

for (int i=0;questionList!=null && i<questionList.size();i++){
	questions q=questionList.get(i);
	out.println("<div class='grid-item'>");
	out.println(q.getQuestion()+"<br>");
	int id =(q.getId());
	for (int k=0;answerList!=null && k<answerList.size();k++){
		answers a=answerList.get(k);
		int kid = a.getKid();
		if (id == kid) {
			String answer = a.getAnswer();
			String option = null;
			if (answer.equals("1")) {
				option = "strongly disagree";
			}
			if (answer.equals("2")) {
				option = "disagree";
			}
			if (answer.equals("3")) {
				option = "I'm not sure";
			}
			if (answer.equals("4")) {
				option = "agree";
			}
			if (answer.equals("5")) {
				option = "strongly agree";
			}
			
			out.println("<p>" + answer+ ": " + option + "</p>");
			
		}
	}
	
	out.println("</div>");
	
}
	%>
		
	
	</div>
           
        	

</body>
</html>