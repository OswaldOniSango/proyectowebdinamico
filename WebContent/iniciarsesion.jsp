<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css"> 
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
<title>Iniciar Sesion</title>
</head>
<body>
				<form action="Controlador" method="post">
					<div class = "text-center"><img width="80" height = "80"src="imagenes/jordan.png"></div>
					<div class="col-sm-3 mx-auto" >
						<div class="card">
							<div class="card-body">
								<label><h2>Iniciar sesión</h2></label><br>
								<div style="color:red">${ErrorValidacion}</div>
								<label> Correo electronico </label>
								<input name ="email"type="email" class="form-control"><br>
								
								<label>Contraseña</label>
								<input name= "password" type="text" class="form-control"><br>
								<button type="submit" name ="accion" value="InicioSesion" class="btn btn-primary btn-lg btn-block col-sm-12" class>Iniciar sesión</button><br>
								
									<div class="text-center"><hr class="my-3 text-center"><h5></h5>¿Eres nuevo en OswaldoStore?</h5>
									</div>
									
								<a href="registro.jsp"type="button" class="btn btn-secondary btn-lg btn-block col-sm-12">Registrarse</a>
							</div>	
						</div>
					</div>
				</form>
			
			
			
		<hr>
		<footer class="text-center text-lg-start">
			<div class="text-center p-3 style=">
			© 2022 Oswaldo Hernandez Copyright
			</Div>
		</footer>	
			
		<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
		<script src="js/Funciones.js"type="text/javascript"></script>
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<!-- JavaScript Bundle with Popper -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
				
</body>
</html>