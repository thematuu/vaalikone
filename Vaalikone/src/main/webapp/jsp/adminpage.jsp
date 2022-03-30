<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
     <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.kysymys" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN PAGE</title>
</head>
<body>
<%@ include file="../html/somehtml.html" %>

<%
ArrayList<kysymys> kysymysList=(ArrayList<kysymys>)request.getAttribute("kysymyslist");

for (int i=0;kysymysList!=null && i<kysymysList.size();i++){
	kysymys k=kysymysList.get(i);
	out.println(k.getId()+": "+k.getkysymykset()+"<br>");
}
%>




</body>
</html>