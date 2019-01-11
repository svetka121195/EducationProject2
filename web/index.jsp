<%--
  Created by IntelliJ IDEA.
  User: Светлана
  Date: 30.07.2018
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Application</title>
  </head>
  <body>

  <form method="post" action="/authorization">
    <table>
      <tr>
        <th>Sign in:</th>
      </tr>
      <tr>
        <td>Login:</td>
        <td><input type="text" id="uName" name="login">
        <td/>
      </tr>
      <tr>
        <td>Password:</td>
        <td><input type="password" id="uPass" name="password"></td>
      </tr>
      <tr><td><button type="submit" value="Log in">Submit</button></td></tr>
    </table>
  </form>


  <button onclick="location.href='/admin'">Users list</button>
  </body>
</html>
