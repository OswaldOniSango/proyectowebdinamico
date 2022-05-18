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
	<c:when test="${cliente.getNombre() != null}">
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
			      <ul class="navbar-nav">
			      	<li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa fa-user-circle" aria-hidden="true">${cliente.getNombre()}</i></a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="#">Mi Perfil</a></li>
			            <c:choose>
			            <c:when test="${cliente.getTipoUsuario() == 'ADMINISTRADOR' }">
			            	<li><a class="dropdown-item" href="Controlador?accion=VerMisProductos">Mis Productos</a></li>
			            	
			            </c:when>
						<c:otherwise>
			            	<li><a class="dropdown-item" href="#">${cliente.getTipoUsuario()}Mis Compras</a></li>
			            </c:otherwise>
			            </c:choose>
			            
			            <li><hr class="dropdown-divider"></li>
			            <li><a class="dropdown-item" href="Controlador?accion=CerrarSesion">Cerrar Sesion</a></li>
			          </ul>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</c:when>
		<c:otherwise>
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
			      <form action="Controlador" method ="get" class="d-flex">
			        <input class="form-control me-2" name="busqueda" type="search" placeholder="Buscar" aria-label="Search">
			        <button class="btn btn-outline-secondary" name ="accion" value="Buscar" type="submit">Buscar</button>
			      </form>
			      <ul class="navbar-nav">
			      	<li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa fa-user-circle" aria-hidden="true">Iniciar sesion</i></a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="iniciarsesion.jsp">Iniciar sesion</a></li>
			            <li><a class="dropdown-item" href="registro.jsp">Registrarse</a></li>
			          </ul>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</c:otherwise>
	</c:choose>	
			<div class="Container mt-4">
			<h3>Estos son sus compras</h3>
			<br>
				<div class="row">
					<div class="col-sm-8 mx-auto">
						<table class = "table table-hover">
							<thead>
								<tr>
									<th>Codigo de Compra</th>
									<th>Fecha de Compra</th>
									<th>Monto</th>
									<th>Codigo de Pago</th>
									<th>Estado</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="compra" items="${listacompra}">
								<tr>
									<td>${compra.getIdCompra()}</td>
									<td>${compra.getFechaCompra()}</td>
									<td>${compra.getMonto()}</td>
									<td>${compra.getIdPago()}</td>
									<td>${compra.getEstado()}</td>
									<td>
									<a href="Controlador?accion=Detalle&id=${compra.getIdCompra()}">Ver detalles</a>
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