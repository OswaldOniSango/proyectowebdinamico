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
			          <a class="nav-link" href="Controlador?accion=home"></i>Seguir comprando</a>
			        </li>
			      </ul>s
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
			<div class="Container mt-4">
			<h3>Estos son los zapatos seleccionados para su compra</h3>
			<br>
				<div class="row">
					<div class="col-sm-8">
						<table class = "table table-hover">
							<thead>
								<tr>
									<th>ITEM</th>
									<th>NOMBRE</th>
									<th>DESCRIPCION</th>
									<th>PRECIO</th>
									<th>CANTIDAD</th>
									<th>SUBTOTAL</th>
									<th>ACCIONES</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="prodCarrito" items="${carrito}">
								<tr>
									<td>${prodCarrito.getItem()}</td>
									<td>${prodCarrito.getNombre()}</td>
									<td>${prodCarrito.getDescripcion()}</td>
									<td>${prodCarrito.getPrecioCompra()}</td>
									<td>${prodCarrito.getCantidad()}</td>
									<td>${prodCarrito.getSubTotal()}</td>
									<td>
										<a href="#">Eliminar</a>
										<a href="#">Editar</a>
									</td>
								</tr>
							</c:forEach>								
								
							</tbody>
						</table>
					</div>
					<div class="col-sm-4">
						<div class="card">
							<div class="card-header">
								<h3>Esta es su compra:</h3>
							</div>
							<div class="card-body">
							<label> Subtotal:</label>
							<input type="text" value="US$ ${totalPagar}0" readonly="" class="form-control">
							<label> Descuento:</label>
							<input type="text" value="US$ 0.00"readonly="" class="form-control">
							<label> Total a Pagar:</label>
							<input type="text" value="US$ ${totalPagar}0"readonly="" class="form-control">	
							
							</div>
							<div class="card-footer">
								<a href="#" class="btn btn-info btn-block" class>Realizar Pago</a>
								<a href="#" class="btn btn-danger btn-block" class>Generar Compra</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
		
	</body>
</html>