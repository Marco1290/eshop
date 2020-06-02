<%--
  Created by IntelliJ IDEA.
  User: Marco
  Date: 17-May-20
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <header>
        <jsp:include page="header.jsp"/>
        <title>e-shop</title>
    </header>
    <body>


        <div class="container p-5 mt-5">


                <c:forEach var ="bag" items="${bags}">
                    <div class="row p-3 border rounded">
                        <div class="col-5">
                                ${bag.getProduct().getName() }
                        </div>
                        <div class="col-4">
                                ${bag.getQuantity() }
                                <a class="text-dark" href="./bags?method=putPlus&bagID=${bag.getId()}">
                                    <span class="glyphicon glyphicon-plus"></span>
                                </a>
                                <a class="text-dark" href="./bags?method=putMinus&bagID=${bag.getId()}">
                                    <span class="glyphicon glyphicon-minus"></span>
                                </a>
                        </div>
                        <div class="col-1">
                            <a class="text-dark" href="./bags?method=delete&bagID=${bag.getId()}">
                                <span class="glyphicon glyphicon-trash"></span>
                            </a>
                        </div>
                        <div class="col-2">
                                ${Math.round(bag.getQuantity()*bag.getProduct().getPrice() *100)/100} .-
                        </div>
                    </div>
                </c:forEach>

            <div class="row mt-3 p-2 bg-dark text-white ">
                <div class="col-3">
                  Total
                </div>
                <div class="offset-6 col-3">
                    CHF ${Math.round(total *100)/100} .-
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-3 ">
                    <a href="./products" class="btn btn-secondary">Back to shopping</a>
                </div>
                <div class="offset-6 col-3 d-flex justify-content-end">
                    <c:if test = "${bags.size() > 0}">
                        <a href="./payment"><button type="button" class="btn btn-success">Pay</button></a>
                     </c:if>
                </div>

            </div>
        </div>


    </body>
</html>
