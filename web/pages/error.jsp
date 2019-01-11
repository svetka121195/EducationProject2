<%@ page import="app.model.User" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: Светлана
  Date: 13.07.2018
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List error</title>
</head>
<body>

error
<form method="post">
    <table>
        <tr>
            <th>Add user:</th>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login">
            <td/>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr><td><button type="submit">Submit</button></td></tr>
    </table>
</form>


<p><c:out value="${error}"/></p>



<table border="1">

    <caption>Users list</caption>

    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Login</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>


    <c:forEach var="user" items="${usersList}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td>
                <form method="get" action="/edit">
                    <button name="id" value="<c:out value="${user.id}"/>" type="submit">Edit</button>
                </form>
            </td>
            <td>
                <form method="post" action="/delete">
                    <button name="id" value="<c:out value="${user.id}"/>" type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
