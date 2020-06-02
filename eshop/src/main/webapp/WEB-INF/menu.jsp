<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Marco
  Date: 11-May-20
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>

<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <a href="./">
            <span class="glyphicon glyphicon-home text-whites"></span>
        </a>

        <div class="navbar-header text-white">
            <a class="navbar-brand" href="./">E-Shop</a>
        </div>

        <ul class="nav navbar-nav navbar-right ">
            <li>
                <a href="./checkout"><span class="glyphicon glyphicon-shopping-cart text-white"></span></a>
                <span class="text-white"> <c:out value="${prodQuantity}"/> </span>
            </li>
        </ul>
    </div>
</nav>
