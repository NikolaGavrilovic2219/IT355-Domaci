<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<html xmlns:th="http://www.thymeleaf.org"> 
    <head> 
        <title>Dodavanje proizvoda</title> 
    </head> 
    <body>

        <%@include file="header.jsp" %>

        <form:form method="POST" action="proizvod?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data" >

            <div id="box">
                <h2>Unesite informacije o proizvodu</h2>
                <table class="table">
                    <tr>
                        <td><form:label path="proizvod_naziv">Naziv proizvoda:</form:label></td>
                        <td><form:input id="proizvod_naziv" placeholder="naziv proizvoda" path="proizvod_naziv" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="proizvod_cena">Cena proizvoda:</form:label></td>
                        <td><form:input id="proizvod_cena" placeholder="cena proizvoda" path="proizvod_cena" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="proizvod_opis">Opis proizvoda:</form:label></td>
                        <td><form:input id="proizvod_opis" placeholder="opis proizvoda" path="proizvod_opis" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="proizvod_slika">Slika proizvoda:</form:label></td>
                        <td><input id="proizvod_slika" type="file"  class="form-control" name="file"/></td>       
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div id="box"> <input type="submit" value="posalji" class="btn-primary"/></div>
                        </td>
                    </tr>
                </table>
            </div>
        </form:form>

        <%@include file="footer.jsp" %> 