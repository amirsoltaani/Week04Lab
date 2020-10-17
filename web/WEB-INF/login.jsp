<%-- 
    Document   : login
    Created on : 17-Oct-2020, 12:21:39 PM
    Author     : AmirS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Week 04: Login</title>
</head>
<body>
<h1>Login</h1>
<form action="login" method="post">
    <label for="username">Username: </label>
    <input type="text" name="username" id="username" value="${user}">
    <br>
    <label for="password">Username: </label>
    <input type="password" name="password" id="password" value="${pass}">
    <br>
    <input type="submit" value="Log in">
</form>
<p>${success_logout}</p>
<p>${invalid}</p>
</body>
</html>
