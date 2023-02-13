<%-- 
    Document   : login
    Created on : 12-Feb-2023, 3:07:00 AM
    Author     : Karsten Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="post">
            <h1>Login</h1>
            Username: <input type="text" name="username" value="${username}"><br>
            Password: <input type="password" name="password" value="${password}"><br>
            <span style="color: red;">${errorMsg}</span>
            <span style="color: green;">${logoutMsg}</span>
            <input type="submit" name="login" value="Login"><br>
        </form>
    </body>
</html>
