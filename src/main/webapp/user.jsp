<%@ page import="model.Account" %><%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 02/11/2022
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đây là trang USER</h1>
<%
    Account account = (Account) session.getAttribute("account");
%>
<%=account.getUsername()%>

</body>
</html>
