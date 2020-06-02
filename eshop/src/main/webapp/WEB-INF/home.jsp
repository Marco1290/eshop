<%--
  Created by IntelliJ IDEA.
  User: Marco
  Date: 11-May-20
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>

    <c:import url="header.jsp"/>

    <body>

        <c:import url="menu.jsp"/>

        <section class="container mt-4" id="homepage">
            <div class="row h-75 pt-2 pb-2">
                <div class="col-8 text-dark">
                    <a  class="text-dark" href="./products">
                        <h1>Welcome to E-SHOP !</h1>
                        <p>
                            Why end might ask civil again spoil. She dinner she our horses depend. Remember at children by reserved to vicinity. In affronting unreserved delightful simplicity ye. Law own advantage furniture continual sweetness bed agreeable perpetual. Oh song well four only head busy it. Afford son she had lively living. Tastes lovers myself too formal season our valley boy. Lived it their their walls might to by young.

                            Extremely we promotion remainder eagerness enjoyment an. Ham her demands removal brought minuter raising invited gay. Contented consisted continual curiosity contained get sex. Forth child dried in in aware do. You had met they song how feel lain evil near. Small she avoid six yet table china. And bed make say been then dine mrs. To household rapturous fulfilled attempted on so.

                        </p>
                    </a>
                </div>
                <div class="col-4">
                    <div style="background-image: url('IMG/home.jpg');" class="w-100 h-100 img_home"></div>
                </div>
            </div>
            <div class="col-12 bg-dark h-bar mt-2 mb-2" ></div>
            <div class="row h-25 pb-2">


                <c:forEach var ="product" items="${topProducts}">

                    <div class="col-4 p-3">
                        <c:set var="product" scope="session" value="${product}"/>
                        <c:import url="product.jsp"/>
                    </div>

                </c:forEach>

            </div>

        </section>


    </body>
</html>
