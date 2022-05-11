$(document).ready(function (){
	$(" tr #btnEliminar").click(function(){
		var idp = $(this).parent().find("#idp").val();
		swal({
		  title: "Estas seguro/a?",
		  text: "Estas a punto de eliminar este item de tu lista de compras!",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		}).then((willDelete) => {
		  if (willDelete) {
			eliminar(idp);
		    swal("Perfecto, el item ha sido eliminado de la lista", {
		      icon: "success",
		    }).then((willDelete) => {
				if(willDelete){
					parent.location.href="Controlador?accion=Carrito"
				}
			});
		  } else {
		    swal("Perfecto, Tu Item no ha sido eliminado");
		  }
		});
		
	});
	
	function eliminar(idp){
		var url = "Controlador?accion=Eliminar";
		$.ajax({
			type:'POST',
			url : url,
			data: "idp="+idp,
			success: function(data,textStatus,jqXHR){
				
			}
		})
	}
	
	$("tr #cantidad").click(function(){
		var idp = $(this).parent().find("#idpro").val();
		var cantidad = $(this).parent().find("#cantidad").val();
		var url = "Controlador?accion=ActualizarCantidad";
		$.ajax({
			type: 'POST',
			url : url,
			data : "idp="+idp+"&cantidad="+cantidad,
			success:function(data, textStatus, jqXHR){
				parent.location.href="Controlador?accion=Carrito"
			}
		});
	});
	
		$("tr #btnEliminarProducto").click(function(){
			console.log("Estoy aqui");
		var idp = $(this).parent().find("#idp").val();
		swal({
		  title: "¿Estás seguro/a que deseas eliminarlo?",
		  text: "Si eliminas este producto ya este no estará mas disponible en tu tienda on-line",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		}).then((willDelete) => {
		  if (willDelete) {
			eliminarProducto(idp);
		    swal("Tu producto ha sido eliminado de la lista.", {
		      icon: "success",
		    }).then((willDelete) => {
				if(willDelete){
					parent.location.href="Controlador?accion=VerMisProductos"
				}
			});
		  } else {
		    swal("Perfecto, Tu Item no ha sido eliminado");
		  }
		});
		
	});
		
		function eliminarProducto(idp){
		var url = "Controlador?accion=EliminarProducto";
		$.ajax({
			type:'POST',
			url : url,
			data: "idp="+idp,
			success: function(data,textStatus,jqXHR){
				
			}
		})
	}
	
});