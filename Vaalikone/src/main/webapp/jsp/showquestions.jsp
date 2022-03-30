<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.questions" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone</title>
</head>
<body>
<h2>Answer these questions: </h2>
<br><br>
	<form action="/Vaalikone" method="POST">
<%
ArrayList<questions> questionList=(ArrayList<questions>)request.getAttribute("questionList");

for (int i=0;questionList!=null && i<questionList.size();i++){
	questions q=questionList.get(i);
	int id = 0;
	out.println(i+1 + ": " + q.getQuestion()+"<br>");
	%>
				<p>
				<input type="radio" id=<%out.println(q.getId() + "-option-5");%> name=<%out.println(q.getId());%>>strongly agree
				<input type="radio" id=<%out.println(q.getId() + "-option-4");%> name=<%out.println(q.getId());%>>agree
				<input type="radio" id=<%out.println(q.getId() + "-option-3");%> name=<%out.println(q.getId());%> checked>I'm not sure
                <input type="radio" id=<%out.println(q.getId() + "-option-2");%> name=<%out.println(q.getId());%>>disagree 
                <input type="radio" id=<%out.println(q.getId() + "-option-1");%> name=<%out.println(q.getId());%>>strongly disagree
               	<br>
               	<br>
               	<br>
            </p>    
	<%}%>
            <p>
                <input type="submit" value="Submit">
            </p>
        </form>	

</body>
</html>