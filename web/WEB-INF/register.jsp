<%-- 
    Document   : register
    Created on : Oct 9, 2018, 11:13:24 AM
    Author     : 747787
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <br>
        <form method="post" action="ShoppingList">
            Username:<input type="text" name="user">
            <button type="submit">Register Name</button>
            <input type="hidden" name="action" value="register">
        </form>
    </body>
</html>
