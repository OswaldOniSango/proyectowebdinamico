
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
			<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			  <div class="container-fluid">
			    <a class="navbar-brand" href="#">Oswaldo Store</a>
			    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
			    
			    <div class="collapse navbar-collapse" id="navbarSupportedContent">
			      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			        <li class="nav-item">
			          <a class="nav-link" href="Controlador?accion=home">Home<span class="sr-only">(current)</span></a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="#">Ofertas del Dia</a>
			        </li>
			        <li class="nav-item">
			          <a class="nav-link" href="Controlador?accion=Carrito"><i class="fas fa-cart-plus"><label style="color: darkorange">${contador}</label></i>Carrito de Compras</a>
			        </li>
			      </ul>
			      <form class="d-flex">
			        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
			        <button class="btn btn-outline-success" type="submit">Search</button>
			      </form>
			      <ul class="navbar-nav">
			      	<li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">Iniciar Sesion</a>
			          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
			            <li><a class="dropdown-item" href="#">Action</a></li>
			            <li><a class="dropdown-item" href="#">Another action</a></li>
			            <li><hr class="dropdown-divider"></li>
			            <li><a class="dropdown-item" href="#">Something else here</a></li>
			          </ul>
			        </li>
			      </ul>
			    </div>
			  </div>
			</nav>
		<div class = "container mt-4">
			<div class="row">
			 <c:forEach var="p" items="${productos}">
				<div class="col-sm-4 form-group">
					<div class="card">
						<div class="card-header text-center">
							<label>${p.getNombre()}</label>
						</div>
						<div class="card-body text-center">
						<img src="ControladorIMG?id=${p.getId()}" width="200" height = "180"><br>
							<i>US$ ${p.getPrecio()}</i>
						</div>
						<div class="card-footer text-center">
							<label>${p.getDescripcion()}</label>
							<div>
								<a href="Controlador?accion=AgregarCarrito&id=${p.getId()}" class="btn btn-outline-info">Agregar a Carrito</a>
								<a href="Controlador?accion=Comprar&id=${p.getId()}"class="btn btn-danger">Comprar</a>
							</div>
						</div>
					</div>
				</div><br>
			</c:forEach>		
			</div>
		</div>

		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
		
	</body>
</html>