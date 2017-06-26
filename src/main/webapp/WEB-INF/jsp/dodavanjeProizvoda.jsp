<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%@include file="header.jsp" %>

    <div id="box">
        <h2>Podaci o proizvodu</h2>
        <table class="table">
            <tr>
                <td>Ime</td>
                <td>${ime}</td>
            </tr>
            <tr>
                <td>Cena</td>
                <td>${cena}</td>
            </tr>
            <tr>
                <td>Opis</td>
                <td>${opis}</td>
            </tr>
        </table>
    </div>

    <%@include file="footer.jsp" %> 