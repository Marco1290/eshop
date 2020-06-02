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

        <div class="container pt-5 ">
            <div class="row">
                <div class="col-7 ">
                    <div class="w-100 text-center mb-3 font-italic"><h2> ${product.getName()}</h2></div>

                    <div class="w-100  h-50 text-justify mb-3 p-3 border rounded">${product.getDescription()}</div>

                    <div class="w-100 text-center mb-2 ">
                        <span class="text-uppercase font-weight-bold mr-2">Price</span><span>CHF ${product.getPrice()} .-</span>
                        <a  class="ml-3 text-dark" href="./bags?method=post&productID=${product.getId()}">
                            <span class="glyphicon glyphicon-shopping-cart" title="Add to my bag"></span>
                        </a>
                    </div>

                    <a href="./products" class="btn btn-secondary"> Back to Shopping </a>

                </div>
                <div class="col-5">
                    <img class="row mx-auto mb-3" src="IMG/${product.getImagePath()}" height="300">
                    <img class="row mx-auto " src="IMG/${product.getImage2Path()}" height="300">
                </div>
            </div>
        </div>
    </body>
</html>
