<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <body>
        <%@include file="header.jsp" %>

        <div class="container">

            <h1>Zdravo, korisnice!</h1>

            <div class="row">
                        <c:if test="${!empty proizvodi}">
                            <c:forEach items="${proizvodi}" var="proizvod">
                                <div class="col-sm-4 col-lg-4 col-md-4">
                                    <div class="thumbnail">
                                        <img src="${proizvod.proizvod_slika}" alt="">
                                        <div class="caption">
                                            <h4 class="pull-right">${proizvod.proizvod_cena}</h4>
                                            <h4><a href="#">${proizvod.proizvod_naziv}</a>
                                            </h4>
                                            <p>${proizvod.proizvod_opis}</p>
                                        </div>
                                        <div class="ratings">
                                            <p class="pull-right">15 reviews</p>
                                            <p>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                                <span class="glyphicon glyphicon-star"></span>
                                            </p>
                                        </div>
                                        <a href="/MotoShop/editproizvod/${proizvod.proizvod_id}">edit</a>
                                        <a href="/MotoShop/deleteproizvod/${proizvod.proizvod_id}">delete</a>  
                                        <div id="box"> <input type="submit" value="Pošalji" class="btn btn-warning"/></div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>