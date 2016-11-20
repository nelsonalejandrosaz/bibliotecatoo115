<%-- 
    Document   : categoriaAdd
    Created on : 11-14-2016, 11:33:06 AM
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
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="nombrecategoria" class="control-label">Nombre Categoria:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="nombrecategoria" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Boton enviar -->
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <form:button class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Ingresar</form:button> <a class="btn btn-warning" role="button" href="categoriaList.html"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</a>
                    </div>
                </div>
            </form:form>
            <!-- Fin del form -->
        </div>
    </body>
</html>
