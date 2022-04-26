<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css"> 
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous"/>
<style>
input[type=number]::-webkit-outer-spin-button, input[type=number]::-webkit-inner-spin-button {
    -webkit-appearance: none;
    margin: 0;
}
input[type=number] {
    -moz-appearance:textfield;
}

</style>		
<title>Registrarte en OswaldoStore</title>
</head>
<body>
<form action="Controlador" method = "post" class="text-center">
<img width="80" height = "80"src="imagenes/jordan.png"></div>
					<div class="col-sm-4 mx-auto" >
						<div class="card">
							<div class="card-body">
								<label><h2>Crear cuenta</h2></label><br>
								<label> Nombre </label>
								<input type="text" name="nombre" class="form-control" required><br>
								
								<label> Apellido </label>
								<input type="text" name="apellido" class="form-control" required><br>
								
								<label> DNI </label>
								<input type="number" alt="number" name = "dni" class="form-control" required><br>
								
								<label> Email </label>
								<input type="email" name ="email"class="form-control"required><br>
								
								<div style="color:red">${ContraseñaInvalida}</div>
								<label>Contraseña</label>
								<input type="password" name="password"class="form-control" required><br>
								
								<label>Confirmar tu contraseña</label>
								<input type="password" name="password1" class="form-control" required><br>
								
								
								<button name="accion" value="RegistroClientes" type="submit" class="btn btn-primary btn-lg btn-block col-sm-12">Crear tu cuenta</button><br>
								
								<hr>
								
								<div class="text-center">¿Ya tienes tu cuenta en OswaldoStore? <a href="iniciarsesion.jsp">Iniciar sesion</a>
								</div>
								
							</div>	
						</div>
					</div>
				</form>

</body>
</html>