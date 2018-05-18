<%--
  Created by IntelliJ IDEA.
  User: asv14
  Date: 19.05.2018
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<%=("authErr".equals(request.getParameter("errorMsg"))) ? "Неверное имя пользователя/пароль" : ""%><BR>
<%=("noAuth".equals(request.getParameter("errorMsg"))) ? "Необходимо пройти авторизацию" : ""%><BR>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" value="user" name="userName"><BR>
    <input type="text" value="password" name="userPassword"><BR>
    <input type="submit" value="ok">

</form>
</body>
</html>
