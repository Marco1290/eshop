<%--
  Created by IntelliJ IDEA.
  User: Marco
  Date: 17-May-20
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="header.jsp"/>
<body>


    <div class="container p-5 mt-5">
        <form method="post" action="./payment">
            <input type="hidden" name="method" value="post">
            <div class="from-group mt-4">
                <label>Total</label>
                <span class="bg-dark text-white rounded ml-5 p-3">CHF ${total} .- </span>
            </div>
            <div class="from-group mt-5">
                <label for="email">Email address</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
            </div>
            <div class="from-group mt-3">
                <label for="name">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Dupont Loic">
            </div>
            <div class="from-group mt-3">
                <label for="carteNum">Carte information</label>
                <input type="text" class="form-control" id="carteNum" name="carteNum" placeholder="0983183174781477483">

                <label for="carteNum" class="mt-3">Month</label>
                <input type="number" class="form-control" id="month" name="month"  min="1" max="12">

                <label for="carteNum" class="mt-3">Year</label>
                <input type="number" class="form-control" id="year" name="year"  min="1" max="99">
            </div>
            <div class="row mt-5">
                <div class="col-3">
                    <a href="./products" class="btn btn-secondary"> Back to Shopping </a>
                </div>
                <div class="offset-6 col-3 d-flex justify-content-end">
                    <button type="submit"  class="btn btn-success">Order</button>
                </div>
            </div>
        </form>

    </div>
</body>
</html>
