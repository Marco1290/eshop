<%--
  Created by IntelliJ IDEA.
  User: Marco
  Date: 24-Apr-20
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oups... </title>
</head>
<body>
    <h1>Oups..... Something went wrong !</h1>
    <a href="${requestScope['javax.servlet.forward.request_uri']}">Try again !</a>
</body>
</html>
