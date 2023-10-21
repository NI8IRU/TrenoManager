<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
questa è la home

<a href= "insert" > inserisci Treno </a>  

<form action="insert" method="GET">
  <input type="text" id="sigla" name="sigla" value="" placeholder="inserisci la sigla del treno"><br>
  <input type="submit" value="Submit">
</form> 


<% 
     for (int i = 0; i<10; i++ ) {
%>
   <p> paragrafo generato da codice java <%=i%> </p>
 <%    
     }
%>


</body>
</html>