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
		    swal("Item, no eliminado");
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
	
})