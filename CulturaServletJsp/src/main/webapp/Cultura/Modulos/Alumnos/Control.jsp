<%-- 
    Document   : Control
    Created on : 08-may-2012, 9:32:57
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url('../../recursos/img/aliezze.jpg');background-repeat: no-repeat  ">
        <%
        String codigo=request.getParameter("codigo");
        String rombre=request.getParameter("nombre");
        out.println(rombre);
        
        %>
        <%= rombre%>
        
    </body>
</html>
