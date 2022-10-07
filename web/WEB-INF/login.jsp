<%-- 
    Document   : login
    Created on : 6-Oct-2022, 12:34:10 AM
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
        <h1>Login</h1>
        
        <form method="post" action="login">
            Username: <input type="text" name="username" value="${username}"><br>
            Password: <input type="password" name="password" value="${password}"><br>
            <input type="submit" name="login" value="Login"><br>
            <span>${loginMsg}</span>
        </form>
    </body>
</html>