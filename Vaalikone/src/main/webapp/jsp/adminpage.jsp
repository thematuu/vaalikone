<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
     <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.kysymys" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN PAGE</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
<%@ include file="../html/somehtml.html" %>
<h2>Add question!</h2>
        <form action="/AddQuestion" method="POST">
            <p>
                Give the question you want to add <input type="text" name="question">
            </p>
            <p>
                <input type="submit" value="Add">
            </p>
        </form>	
        <div class='grid-container'>
<%
ArrayList<kysymys> kysymysList=(ArrayList<kysymys>)request.getAttribute("kysymyslist");

for (int i=0;kysymysList!=null && i<kysymysList.size();i++){
	kysymys k=kysymysList.get(i);
	out.println("<div class='grid-item'>");
	out.println("<p>ID: "+k.getId()+"  Question: "+k.getkysymykset()+"</p> <form action='/deleteQuestion' style='display: inline-block;' method='POST'><input type='hidden' name='id' value='"+k.getId()+"'><input type='submit' name='ok' value='Delete'></form>");
	out.println("<form action='/UpdateQuestion' method='POST'>");
	out.println("<input type='hidden' name='id' value='"+k.getId()+"'><br>UPDATE THE QUESTION: <input type='text'data-required='true' size='50' name='kysymys' value=''><br>");
	out.println("<input type='submit' name='ok' value='Update'></form>");
	out.println("</div>");
}
%>
</div>



</body>
</html>