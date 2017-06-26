<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="false" %>
<html>
    <body>
        <%@include file="header.jsp" %>

        <div class="container">

            <h1>Edit proizvod</h1>  
            <form:form method="POST" action="/MotoShop/editsave" >    
                <table class="table">    
                    <tr>  
                       <td>ID: </td>   
                       <td><form:input id="proizvod_id" path="proizvod_id"  class="form-control"/></td>  
                    </tr>   
                    <tr>    
                        <td>Naziv : </td>   
                        <td><form:input id="proizvod_naziv" path="proizvod_naziv"  class="form-control"/></td>  
                    </tr>    
                    <tr>    
                        <td>Cena :</td>    
                        <td><form:input id="proizvod_cena" path="proizvod_cena" class="form-control"/></td>  
                    </tr>   
                    <tr>    
                        <td>Opis :</td>    
                        <td><form:input id="proizvod_opis" path="proizvod_opis" class="form-control"/></td>  
                    </tr>   

                    <tr>
                        <td><input type="submit" value="Edit Save" /></td>    
                    </tr>    
                </table>    
            </form:form>  
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>