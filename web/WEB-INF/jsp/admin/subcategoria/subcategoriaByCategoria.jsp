<%-- 
    Document   : subcategoriaByCategoria
    Created on : 11-19-2016, 07:16:18 PM
    Author     : Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${subcategorias}" var="subcategoria">
    <option value="${subcategoria.idsubcategoria}">${subcategoria.nombresubcategoria}</option>
</c:forEach>
