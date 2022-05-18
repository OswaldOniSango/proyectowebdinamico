<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="css/bootstrap.min.css"> 
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
	</head>
	<body>
	<c:choose>
	<c:when test="${cliente.getTipoUsuario() == 'ADMINISTRADOR'}">
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="Controlador?accion=home">Store</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link" href="#"><i class="fa fa-home" aria-hidden="true"></i>Home<span class="sr-only">(current)</span></a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="#">Ofertas del Dia</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="Controlador?accion=home">Seguir comprando</a>
			        </li>
			      </ul>
			      <form action ="Controlador" method="get" class="d-flex">
			        <input class="form-control me-2" name="busqueda"type="search" placeholder="Buscar" aria-label="Search">
			        <button class="btn btn-outline-secondary" name="accion" value="BuscarMisProductos" type="submit">Buscar</button>
			      </form>
			      <ul class="navbar-nav">
			      	<li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa fa-user-circle" aria-hidden="true">${cliente.getNombre()}</i></a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="#">Mi Perfil</a></li>
			            <li><a class="dropdown-item" href="Controlador?accion=VerMisProductos">Mis Productos</a></li>
			            <li><a class="dropdown-item" href="Controlador?accion=VerMisProductos">Mis Ventas</a></li>
			            <li><hr class="dropdown-divider"></li>
			            <li><a class="dropdown-item" href="Controlador?accion=CerrarSesion">Cerrar Sesion</a></li>
			          </ul>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</c:when>
		</c:choose>
			<div class="Container mt-4">
			<h3>Estos son tus productos</h3>
			<br>
				<div class="row">
					<div class="col-sm-8 mx-auto">
						<table class = "table table-hover">
						<a href="Controlador?accion=AgregarNuevosProductos" class="btn btn-info btn-block" class>Agregar Producto Nuevo</a>
							<thead>
								<tr>
									<th>ITEM</th>
									<th>NOMBRE</th>
									<th>DESCRIPCION</th>
									<th>FOTO</th>
									<th>PRECIO</th>
									<th>STOCK</th>
									<th>ACCIONES</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="p" items="${productos}">
								<tr>
									<td>${p.getId()}</td>
									<td>${p.getNombre()}</td>
									<td>${p.getDescripcion()}</td>
									<td><img src="ControladorIMG?id=${p.getId()}" width="100" height="100"></td>
									<td>${p.getPrecio()}</td>
									<td>${p.getStock()}</td>
									<td>
										<input type="hidden" id= "idp" value="${p.getId()}">													
										<a class = "form-control text-center" id= "btnEliminarProducto" href="#"><i class="fas fa-trash"></i></a>
									</td>
								</tr>
							</c:forEach>							
							</tbody>
						</table>
					</div>
				</div>
			</div>
			
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		<script src="js/FuncionesJavascript.js"type="text/javascript"></script>
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<!-- JavaScript Bundle with Popper -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>
</html>