<%-- 
    Document   : home
    Created on : 6-Oct-2022, 12:34:16 AM
    Author     : Karsten Monteiro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        
        <h3>Hello ${username}.</h3>
        <a href="login?logout" name="logout">Log Out</a>
    </body>
</html>