<%-- 
    Document   : categoriaDelete
    Created on : 11-14-2016, 12:34:52 AM
    Author     : nelsonalejandrosaz
--%>
<%@include file="../taglib_include.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../head_include.jsp" %>
    </head>
    <body>
        <div class="container">
            <h1><c:out value="${titulo}"/></h1>
            <hr>
            <form:form class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <h4>Seguro que desea eliminar la categoria: <c:out value="${command.nombrecategoria}"/></h4>
                        <form:button class="btn btn-danger" ><span class="glyphicon glyphicon-trash"></span> Eliminar</form:button> <a class="btn btn-warning" role="button" href="categoriaList.html"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</a>
                    </div>
                </div>
            </form:form>
        </div>
    </body>
</html>

