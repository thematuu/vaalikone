<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.questions" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vaalikone Questions</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<h2>Answer these questions: </h2>
<br><br>
	<form action="/Vaalikone" method="POST">
	<div class='grid-container'>
<%
ArrayList<questions> questionList=(ArrayList<questions>)request.getAttribute("questionList");
int name = 0;
for (int i=0;questionList!=null && i<questionList.size();i++){
	questions q=questionList.get(i);
	out.println("<div class='grid-item'>");
	out.println(i+1 + ": " + q.getQuestion()+"<br>");
	%>
				<p>
				<input type="radio" id=<%out.println(q.getId() + "-option-5");%> value=<%out.println(q.getId() + "-option-5");%> name=<%out.println(name);%>>strongly agree
				<input type="radio" id=<%out.println(q.getId() + "-option-4");%> value=<%out.println(q.getId() + "-option-4");%> name=<%out.println(name);%>>agree
				<input type="radio" id=<%out.println(q.getId() + "-option-3");%> value=<%out.println(q.getId() + "-option-3");%> name=<%out.println(name);%> checked>neutral
                <input type="radio" id=<%out.println(q.getId() + "-option-2");%> value=<%out.println(q.getId() + "-option-2");%> name=<%out.println(name);%>>disagree 
                <input type="radio" id=<%out.println(q.getId() + "-option-1");%> value=<%out.println(q.getId() + "-option-1");%> name=<%out.println(name);%>>strongly disagree
               	</p>
    		<%out.println("</div>");
    		name++;
    		%>
    		
	<%}%>
	</div>
            <p>
                <input type="submit" value="Submit">
            </p>
        </form>	

</body>
</html>