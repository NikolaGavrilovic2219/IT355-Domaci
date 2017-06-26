<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<html> 
    <head> 
        <title>Dodavanje proizvoda</title> 
    </head> 
    <body>

        <%@include file="header.jsp" %>


        <form:form method="POST" action="/MotoShop/dodavanjeProizvoda" commandName="proizvod">
            
            <div id="box">
                <h2>Unesite informacije o proizvodu</h2>
                <table class="table">
                    <tr>
                        <td><form:label path="ime">Ime proizvoda:</form:label></td>
                        <td><form:input path="ime" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="cena">Cena proizvoda:</form:label></td>
                        <td><form:input path="cena" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="opis">Opis proizvoda:</form:label></td>
                        <td><form:input path="opis" class="form-control"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div id="box"> <input type="submit" value="Pošalji" class="btn-primary"/></div>
                        </td>
                    </tr>
                </table>
            </div>
        </form:form>

        <%@include file="footer.jsp" %> 