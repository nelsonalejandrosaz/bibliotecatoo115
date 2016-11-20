<%-- 
    Document   : recursoList
    Created on : 11-16-2016, 02:25:49 AM
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
            <a class="btn btn-success" role="button" href="recursoAdd.html">Adicionar Subcategoria</a> <a class="btn btn-default" role="button" href="administracionIndex.html">Regresar</a>
            <hr>
            <div class="table-responsive">
                <table class="table table-hover">
                    <tr>
                        <th>ID</th>
                        <th>Recurso</th>
                        <th>Categoria</th>
                        <th>Subcategoria</th>
                        <th>Autores</th>
                        <th>Fecha</th>
                        <th style="text-align: right"></th>
                    </tr>
                    <c:forEach items="${recursos}" var="recurso">
                        <tr>
                            <td><c:out value="${recurso.idrecurso}"/></td>
                            <td><c:out value="${recurso.nombrerecurso}"/></td>
                            <td><c:out value="${recurso.subcategoria.categoria.nombrecategoria}"/></td>
                            <td><c:out value="${recurso.subcategoria.nombresubcategoria}"/></td>
                            <td><c:out value="${recurso.autores}"/></td>
                            <td><c:out value="${recurso.fecha}"/></td>
                            <td style="text-align: right"><a class="btn btn-warning" role="button" href="recursoEdit.html?id=${recurso.idrecurso}"><span class="glyphicon glyphicon-pencil"></span></a> <a class="btn btn-danger" role="button" href="recursoDelete.html?id=${recurso.idrecurso}"><span class="glyphicon glyphicon-trash"></span></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>