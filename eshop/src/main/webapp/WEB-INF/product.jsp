<%--
  Created by IntelliJ IDEA.
  User: Marco
  Date: 22-May-20
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a class="text-dark" href="./products?id=${ product.getId() }" class="w-100 h-100">
    <div style="background-image: url('IMG/${ product.getImagePath() }');" class="img_prod"></div>
    <div class="text-center mt-2 mb-2">
        <p><c:out value="${ product.getName() }"/></p>
        <span >CHF ${ product.getPrice() } .-</span>
        <a class="text-dark ml-2" href="./bags?method=post&productID=${product.getId()}">
              <span class="glyphicon glyphicon-shopping-cart" title="Add to my bag"> </span>
        </a>
    </div>
</a>



