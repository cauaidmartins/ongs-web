<%-- 
    Document   : Login
    Created on : 16/04/2020, 11:49:57
    Author     : Martins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="css/style.css">
        <title>Lista de Usuários</title>
    </head>

    <body>
        <section class="container-fluid">
            <section class="row justify-content-center">
                <section class="col-12 col-sm-6 col-md-3">
                   <table class="table-container">
                        <h4>Lista de Usuários</h4><br>
                        <table>
                        <jsp:useBean id="usuarioB" scope="session" class="bean.UsuarioBean"/>
                        <td>Nome : <jsp:getProperty name="usuarioB" property="nome"/><br></td>
                        <td>CPF : <jsp:getProperty name="usuarioB" property="cpf"/><br></td>
                        <td>Email :<jsp:getProperty name="usuarioB" property="email"/><br></td>
                        <td>Senha :<jsp:getProperty name="usuarioB" property="senha"/><br></td>
                        <a href="login.jsp">Deslogar</a>
                        </table>
                    <c:forEach items="${userList}" var="user">
                        <tr>
                            <td>${user.nome}</td>
                            <td>${user.cpf}</td>
                            <td>${user.email}</td>
                            <td>${user.senha}</td>
                        </tr>
                    </c:forEach>
                    </table>
                </section>
            </section>
        </section>
    </div>

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>

</html>
