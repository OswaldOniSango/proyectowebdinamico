
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="css/bootstrap.min.css"> 
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
		<meta charset="UTF-8">
			<title>ShoppingCart</title>
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
			          <a class="nav-link" href="Controlador?accion=Carrito" title="Carrito de Compras"><i class="fas fa-cart-plus"><label style="color: darkorange">  (${contador})</label></i></a>
			        </li>
			      </ul>
			      <form action="Controlador" method ="get" class="d-flex">
			        <input class="form-control me-2" name="busqueda" type="search" placeholder="Buscar" aria-label="Search">
			        <button class="btn btn-outline-secondary" name ="accion" value="Buscar" type="submit">Buscar</button>
			      </form>
			      <ul class="navbar-nav">
			      	<li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa fa-user-circle" aria-hidden="true"> ${cliente.getNombre()}</i></a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			          
			            <li><a class="dropdown-item" href="#">Mi Perfil</a></li>
			            <c:choose>
			            <c:when test="${cliente.getTipoUsuario() == 'ADMINISTRADOR' }">
			            	<li><a class="dropdown-item" href="Controlador?accion=VerMisProductos">Mis Productos</a></li>
			            	<li><a class="dropdown-item" href="Controlador?accion=VerMisVentas">Mis Ventas</a></li>
			            </c:when>
						<c:otherwise>
			            	<li><a class="dropdown-item" href="Controlador?accion=VerMisCompras">Mis Compras</a></li>
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
			          <a class="nav-link" href="Controlador?accion=Carrito" title="Carrito de Compras"><i class="fas fa-cart-plus"><label style="color: darkorange">  (${contador})</label></i></a>
			        </li>
			      </ul>
			      <form action="Controlador" method ="get" class="d-flex">
			        <input class="form-control me-2" name="busqueda" type="search" placeholder="Buscar" aria-label="Search">
			        <button class="btn btn-outline-secondary" name ="accion" value="Buscar" type="submit">Buscar</button>
			      </form>
			      <ul class="navbar-nav">
			      	<li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa fa-user-circle" aria-hidden="true">Iniciar Sesion</i></a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="iniciarsesion.jsp">Iniciar Sesion</a></li>
			            <li><a class="dropdown-item" href="registro.jsp">Registrarse</a></li>
			          </ul>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
		</c:otherwise>
	</c:choose>	
		<div class = "container mt-4">
			<div class="row">
			 <c:forEach var="p" items="${productos}">
				<div class="col-sm-4 form-group">
					<div class="card">
						<div class="card-header text-center">
							<label>${p.getNombre()}</label>
						</div>
						<div class="card-body text-center">
						<img src="ControladorIMG?id=${p.getId()}" width="200" height = "250"><br>
							<i>US$ ${p.getPrecio()}0</i>
						</div>
						<div class="card-footer text-center">
							<label>${p.getDescripcion()}</label><br>
							<div>
								<a href="Controlador?accion=AgregarCarrito&id=${p.getId()}" class="btn btn-outline-info"><i class="fas fa-cart-plus">Agregar a Carrito</i></a>
								<a href="Controlador?accion=Comprar&id=${p.getId()}"class="btn btn-danger">Comprar</a>
							</div>
						</div>
					</div>
				</div><br>
			</c:forEach>		
			</div>
		</div>
		<!-- JavaScript Bundle with Popper -->
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>		
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>
</html>