<%-- 
    Document   : principal
    Created on : 16/04/2020, 12:47:06
    Author     : Martins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Seja bem vindo, <%= request.getAttribute("user")%> </h1>
    </body>
</html>
