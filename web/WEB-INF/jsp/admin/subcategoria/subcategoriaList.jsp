<%-- 
    Document   : subcategoriaList
    Created on : 11-14-2016, 11:59:01 AM
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
        <h1>${titulo}</h1>
        <hr>
        <a class="btn btn-success" role="button" href="subcategoriaAdd.html">Adicionar Subcategoria</a> <a class="btn btn-default" role="button" href="administracionIndex.html">Regresar</a>
        <hr>
        <div class="table-responsive">
            <table class="table table-hover">
                <tr>
                    <th>ID</th>
                    <th>Subcategoria</th>
                    <th>Categoria</th>
                    <th style="text-align: right"></th>
                </tr>
                <c:forEach items="${subcategorias}" var="subcategoria">
                    <tr>
                        <td><c:out value="${subcategoria.idsubcategoria}"/></td>
                        <td><c:out value="${subcategoria.nombresubcategoria}"/></td>
                        <td><c:out value="${subcategoria.categoria.nombrecategoria}"/></td>
                        <td style="text-align: right"><a class="btn btn-warning" role="button" href="subcategoriaEdit.html?id=${subcategoria.idsubcategoria}"><span class="glyphicon glyphicon-pencil"></span></a> <a class="btn btn-danger" role="button" href="subcategoriaDelete.html?id=${subcategoria.idsubcategoria}"><span class="glyphicon glyphicon-trash"></span></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>





