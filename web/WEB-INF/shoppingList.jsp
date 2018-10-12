<%-- 
    Document   : shoppingList
    Created on : Oct 9, 2018, 11:13:40 AM
    Author     : 747787
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%
         ArrayList <String>list = (ArrayList<String>) session.getAttribute("list");
         session.setAttribute("list", list);
        %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <br>

        Hello ${name} <a href="ShoppingList?action=logout">Logout</a>

        <br>
        <h1>List</h1>
        <br>
        <form method="post" action="ShoppingList">
            
            Add item: <input type="text" name="addItem"><button type="submit">Add</button>
            <input type="hidden" name="action" value="add">
            </form>
            <br>
            <form method="post" action="ShoppingList">
                <c:forEach var="item" items="${list}">
                    <input name="deleteItem" value="${item}" type="radio">${item}<br>
            </c:forEach>
            <button type="submit">Delete</button>
            <input type="hidden" name="action" value="delete">
            </form>
            <%-- 
            ADD JSTL HERE
            --%>
    </body>
</html>
