<%--
  Created by IntelliJ IDEA.
  User: Marco
  Date: 17-May-20
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <c:import url="header.jsp"/>


    <body>

        <c:import url="menu.jsp"/>


        <div class="container pt-5">
            <div class="row mb-3">
                <div class="col-12 text-center bg-success text-white rounded">${message}</div>
            </div>
            <div class="row">
                <c:forEach var ="product" items="${products}">

                    <div class="col-3">
                        <c:set var="product" scope="session" value="${product}"/>
                        <c:import url="product.jsp"/>
                    </div>

                </c:forEach>
            </div>
        </div>
    </body>
</html>

