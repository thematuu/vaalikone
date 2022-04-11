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

<%@ include file="../html/header.html" %>
<h1>Candidate <%out.println(candidateFirstname + " " + candidateLastname + "'s");%> answers: </h1>
<br><br>
	
	<div class='grid-container'>
<%
ArrayList<String> answerList=(ArrayList<String>)request.getAttribute("answerList");
ArrayList<questions> questionList=(ArrayList<questions>)request.getAttribute("questionList");
ArrayList<String> cookieList=(ArrayList<String>)request.getAttribute("cookieList");
for (int i=0;questionList!=null && i<questionList.size();i++){
	questions q=questionList.get(i);
	out.println("<div class='grid-item'>");
	out.println(i+1 + ": " + q.getQuestion()+"<br>");
	String id = Integer.toString(q.getId());
		
		String a = null;
		String option = null;
		if (i < answerList.size()) {
			a=answerList.get(i);
		
	
	
			
			if (a.equals("1")) {
				option = "strongly disagree";
			}
			else if (a.equals("2")) {
				option = "disagree";
			}
			else if (a.equals("3")) {
				option = "neutral";
			}
			else if (a.equals("4")) {
				option = "agree";
			}
			else if (a.equals("5")) {
				option = "strongly agree";
			}
			else {
				option = "Candidate hasn't answered to this question yet.";
			}
			
			out.println("<p> Candidate answer: " + a+ ": " + option + "</p>");
			
		}
		
		else {
			option = "Candidate hasn't answered to this question yet.";
			out.println("<p>" + option + "</p>");
		}
		
		if (cookieList.size() != 0) {
			out.println("<p> Your answer: ");
		
		if (i < cookieList.size()) {
			a=cookieList.get(i);
		
	
	
			
			if (a.equals("1")) {
				option = "strongly disagree";
			}
			else if (a.equals("2")) {
				option = "disagree";
			}
			else if (a.equals("3")) {
				option = "neutral";
			}
			else if (a.equals("4")) {
				option = "agree";
			}
			else if (a.equals("5")) {
				option = "strongly agree";
			}
			else {
				option = "Candidate hasn't answered to this question yet.";
			}
			
			out.println("" + a+ ": " + option + "</p>");
			
		}
		
		else {
			option = "Candidate hasn't answered to this question yet.";
			out.println("<p>" + option + "</p>");
		}
			
		
	}
	
	out.println("</div>");
	
}
	%>
		
	
	</div>
           
        	

</body>
</html>