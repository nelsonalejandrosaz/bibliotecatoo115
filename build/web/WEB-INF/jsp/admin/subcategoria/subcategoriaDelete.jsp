<%-- 
    Document   : subcategoriaDelete
    Created on : 11-16-2016, 02:12:28 AM
    Author     : nelso
--%>

<%@include file="../head_include.jsp" %>

<body>
    <div class="container">
        <h1><c:out value="${titulo}"/></h1>
        <hr>
        <form:form class="form-horizontal">
            <div class="form-group">
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <h4>Seguro que desea eliminar la subcategoria: <c:out value="${command.nombresubcategoria}"/></h4>
                        <form:button class="btn btn-danger" ><span class="glyphicon glyphicon-trash"></span> Eliminar</form:button> <a class="btn btn-warning" role="button" href="subcategoriaList.html"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</a>
                        </div>
                    </div>
                </div>
        </form:form>
    </div>
</body>
</html>
