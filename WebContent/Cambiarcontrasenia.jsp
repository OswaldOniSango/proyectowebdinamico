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
								<label><h2>Cambiar Contraseña</h2></label><br>
								
								<div style="color:red">${ContraseñaInvalida}</div>
								<label>Contraseña</label>
								<input type="password" name="password"class="form-control" required><br>
								
								<label>Confirmar tu contraseña</label>
								<input type="password" name="password1" class="form-control" required><br>
								
								
								<button name="accion" value="CambiarContrasenia" type="submit" class="btn btn-primary btn-lg btn-block col-sm-12" >Cambiar</button><br>
								<div style="color:red">${errorRegistro}</div>
								<hr>
								
								
							</div>	
						</div>
					</div>
				</form>
		
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>