<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="header.jsp" %>

    <div id="box">
        <h1>Proizvodi:</h1>
        <c:if test="${!empty proizvodi}">
            <table>
                <tr>
                    <th width="350"> Naziv </th>
                    <th width="200"> Cena </th>
                </tr>
                <c:forEach items="${proizvodi}" var="proizvod">
                    <tr>
                        <td>${proizvod.proizvod_naziv}</td>
                        <td>${proizvod.proizvod_cena}</td>
                        <td>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </div>

    <%@include file="footer.jsp" %> 