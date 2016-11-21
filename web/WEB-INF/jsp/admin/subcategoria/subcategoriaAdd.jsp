<%-- 
    Document   : subcategoriaAdd
    Created on : 11-16-2016, 01:50:25 AM
    Author     : nelso
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
                    <form:label class="control-label col-sm-2" path="nombresubcategoria">Nombre Subcategoria: </form:label>
                        <div class="col-sm-10">
                        <form:input class="form-control" path="nombresubcategoria"></form:input>
                        </div>
                    </div>
                <div class="form-group">
                    <form:label class="control-label col-sm-2" path="nombresubcategoria">Categoria: </form:label>
                        <div class="col-sm-10">
                            <select class="form-control" name="categoria">
                                <c:forEach items="${categorias}" var="categoria">
                                    <option value="${categoria.idcategoria}">${categoria.nombrecategoria}</option>
                                </c:forEach>
                            </select>
                        </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <form:button class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Ingresar</form:button> <a class="btn btn-warning" role="button" href="subcategoriaList.html"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</a>
                        </div>
                    </div>
            </form:form>
        </div>
    </body>
</html>