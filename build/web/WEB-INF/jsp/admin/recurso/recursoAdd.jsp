<%-- 
    Document   : recursoAdd
    Created on : 11-20-2016, 09:25:51 PM
    Author     : Nelson Alejandro Saz <nelsonalejandrosaz@gmail.com>
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
            <!-- Inicio del form -->
            <form:form class="form-horizontal">
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="nombrerecurso" class="control-label">Nombre Recurso:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="nombrerecurso" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Atributo 2 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="" class="control-label">Categoria:</form:label>
                    </div>
                    <!-- Input o select -->
                    <div class="col-sm-10">
                        <select id="categoriaS" name="categoria" class="form-control">
                            <c:forEach items="${categorias}" var="categoria">
                                <option value="${categoria.idcategoria}">${categoria.nombrecategoria}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <!-- Atributo 3 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="subcategoria" class="control-label">Subcategoria:</form:label>
                    </div>
                    <!-- Input o select -->
                    <div class="col-sm-10">
                        <select id="subcategoriaS" name="subcategoria" class="form-control">
                            <c:forEach items="${subcategorias}" var="subcategoria">
                                <option value="${subcategoria.idsubcategoria}">${subcategoria.nombresubcategoria}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="descripcion" class="control-label">Descripcion:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                    <form:textarea path="descripcion" class="form-control"></form:textarea>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="sinopsis" class="control-label">Sinopsis:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                    <form:textarea path="sinopsis" class="form-control"></form:textarea>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="autores" class="control-label">Autores:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="autores" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="fecha" class="control-label">Fecha:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="fecha" class="form-control" type="date"></form:input>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="volumen" class="control-label">Volumen:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="volumen" class="form-control" type="number"></form:input>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="unidades" class="control-label">Unidades:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="unidades" class="form-control" type="number"></form:input>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="editorial" class="control-label">Editorial:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="editorial" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="imagen" class="control-label">Imagen:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="imagen" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="formato" class="control-label">Formato:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="formato" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Atributo 1 -->
                <div class="form-group">
                    <!-- Label -->
                    <div class="col-sm-2">
                        <form:label path="prestamointerno" class="control-label">Prestamo:</form:label>
                    </div>
                    <!-- Input -->
                    <div class="col-sm-10">
                        <form:input path="prestamointerno" class="form-control"></form:input>
                    </div>
                </div>
                <!-- Boton enviar -->
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <form:button class="btn btn-success" ><span class="glyphicon glyphicon-ok-sign"></span> Agregar</form:button> <a class="btn btn-warning" role="button" href="subcategoriaList.html"><span class="glyphicon glyphicon-remove-sign"></span> Cancelar</a>
                    </div>
                </div>
            </form:form>
            <!-- Fin del form -->
        </div>
    </body>
    
    <c:url value="/subcategoriaByCategoria.html" var="subcategoriaURL" />    
    <script>
        $(document).ready(function() { 
	$('#categoriaS').change(
		function() {
			id = $(this).val();
                        $("#subcategoriaS").load("subcategoriaByCategoria.html?id="+id);
		});
        });
    </script>
    
</html>