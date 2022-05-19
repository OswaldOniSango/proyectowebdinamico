package com.controlador;


import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.modelo.Carro;
import com.modelo.Cliente;
import com.modelo.ClienteDAO;
import com.modelo.Compra;
import com.modelo.CompraDAO;
import com.modelo.DetalleCompra;
import com.modelo.DetalleCompraDAO;
import com.modelo.Pago;
import com.modelo.PagoDAO;
import com.modelo.Producto;
import com.modelo.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class Controlador
 */
@MultipartConfig
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controlador() {
        // TODO Auto-generated constructor stubs
    }
    	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    ProductoDAO pDAO = new ProductoDAO();
    List<Producto> productos = new ArrayList<>(); 
    List<Carro> listaCarrito = new ArrayList<>();
    List<Compra> listaCompra = new ArrayList<>();
    List<DetalleCompra> listaDetalleCompra = new ArrayList<>();
    int item;
    double totalPagar;
    int cantidad = 1;
    Cliente cliente = new Cliente();
	ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    Pago pago = new Pago();
    PagoDAO pagoDAO= new PagoDAO();
    CompraDAO compraDAO = new CompraDAO();
    DetalleCompraDAO detalleDAO = new DetalleCompraDAO();
    DetalleCompra detalleCompra = new DetalleCompra();
    String errorCompra;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String accion = request.getParameter("accion");
	    	productos = pDAO.listar();
	    	Producto p = new Producto();
	    	HttpSession session = request.getSession();
	    	
	    	
	        
	    	int idp;
	    	Carro car = null;
	    	switch(accion) {
	    	  	case "Comprar":
	    	  		totalPagar = 0;
	    	  		idp = Integer.parseInt(request.getParameter("id"));
	    			p = pDAO.listarID(idp);
	    			item += 1;
	    			car = new Carro ();
	    			car.setItem(item);
	    			car.setIdProducto(p.getId());
	    			car.setNombre(p.getNombre());
	    			car.setDescripcion(p.getDescripcion());
	    			car.setPrecioCompra(p.getPrecio());
	    			car.setCantidad(cantidad);
	    			car.setSubTotal(cantidad*p.getPrecio());
	    			listaCarrito.add(car);
	    			for (int i = 0 ; i < listaCarrito.size() ; i++) {
	    				totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
	    			}
	    			request.setAttribute("totalPagar",totalPagar);
	    			request.setAttribute("carrito", listaCarrito);
	    			request.setAttribute("contador",listaCarrito.size());
	    			request.getRequestDispatcher("carrito.jsp").forward(request, response);
	    			break;
	    	
	    		case "AgregarCarrito":
	    			idp = Integer.parseInt(request.getParameter("id"));
	    			p = pDAO.listarID(idp);
	    			
	    			cantidad = 1;
	    			int pos = 0;
	    			if(listaCarrito.size() > 0) {
	    			for(int i = 0 ; i < listaCarrito.size() ; i++) {
	    				if(idp == listaCarrito.get(i).getIdProducto() ) {
	    					pos = i;
	    				}
	    			}
	    			
		    			if(idp == listaCarrito.get(pos).getIdProducto()) {
		    				cantidad += listaCarrito.get(pos).getCantidad();
		    				listaCarrito.get(pos).setCantidad(cantidad);
		    				listaCarrito.get(pos).setSubTotal(cantidad*listaCarrito.get(pos).getPrecioCompra());
		    			}else {
		    				item += 1;
			    			car = new Carro ();
			    			car.setItem(item);
			    			car.setIdProducto(p.getId());
			    			car.setNombre(p.getNombre());
			    			car.setDescripcion(p.getDescripcion());
			    			car.setPrecioCompra(p.getPrecio());
			    			car.setCantidad(cantidad);
			    			car.setSubTotal(cantidad*p.getPrecio());
			    			listaCarrito.add(car);
			    			
		    			}
	    			}else {	
		    			item += 1;
		    			car = new Carro ();
		    			car.setItem(item);
		    			car.setIdProducto(p.getId());
		    			car.setNombre(p.getNombre());
		    			car.setDescripcion(p.getDescripcion());
		    			car.setPrecioCompra(p.getPrecio());
		    			car.setCantidad(cantidad);
		    			car.setSubTotal(cantidad*p.getPrecio());
		    			listaCarrito.add(car);
	    			}
	    			String mensaje = "<div class=\"alert alert-info\" role=\"alert\">Se ha agregado "+ p.getNombre() +" a tu lista de compras</div>";
	    			request.setAttribute("mensaje",mensaje);
	    			request.setAttribute("contador",listaCarrito.size());
	    			request.getRequestDispatcher("Controlador?accion=home").forward(request,response);
	    			break;
	    		
	    		case "Carrito":
	    			if (listaCarrito.size() < 1) {
	    				item = 0;
	    			}
	    			totalPagar = 0.00;
	    			request.setAttribute("carrito", listaCarrito);
	    			for (int i = 0 ; i < listaCarrito.size() ; i++) {
	    				totalPagar = totalPagar + listaCarrito.get(i).getSubTotal();
	    			}
	    			request.setAttribute("totalPagar",totalPagar);
	    			request.getRequestDispatcher("carrito.jsp").forward(request, response);
	    			break;
	    			
	    		case "Eliminar":
	    			int idPro = Integer.parseInt(request.getParameter("idp"));
	    			for(int i = 0 ; i < listaCarrito.size() ; i++ ) {
	    				if(idPro== listaCarrito.get(i).getIdProducto()) {
	    					listaCarrito.remove(i);
	    				}
	    			}
	    			break;	
	    			
	    		
	    				
	    		case "ActualizarCantidad":
	    			int idprod = Integer.parseInt(request.getParameter("idp"));
	    			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
	    			for(int i = 0; i < listaCarrito.size(); i++) {
	    				if(idprod == listaCarrito.get(i).getIdProducto()) {
	    					listaCarrito.get(i).setCantidad(cantidad);
	    					listaCarrito.get(i).setSubTotal(cantidad*listaCarrito.get(i).getPrecioCompra());
	    				}
	    			}
	    			break;
	    		case "InicioSesion":
	    			String emailSesion = request.getParameter("email");
	    			String passwordSesion = request.getParameter("password");
	    			
	    			cliente = cdao.validarCliente(emailSesion, passwordSesion);
	    			if (cliente.getNombre() != null && cliente.getDni() != null && cliente.getEmail() != null) {
		    			
	    				session.setAttribute("cliente", cliente);
	    				request.setAttribute("carrito", listaCarrito);
	    				request.getRequestDispatcher("carrito.jsp");
	    				request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
	    			}else {
	    				String errorValidacion = "<div class=\"alert alert-danger\" role=\"alert\">Usuario o contraseña incorrecta</div>";
	    				request.setAttribute("ErrorValidacion", errorValidacion);
	    				request.getRequestDispatcher("iniciarsesion.jsp").forward(request, response);
	    			}
	    			
	    			
	    			
	    			break;
	    			
	    		case "RegistroClientes":
	    			
	    			String nombre = request.getParameter("nombre");
	    			String apellido = request.getParameter("apellido");
	    			String dni = request.getParameter("dni");
	    			String email = request.getParameter("email");
	    			String password = request.getParameter("password");
	    			String password1 = request.getParameter("password1");
	    			String tipoUsuario = null;
	    		
	    			if (cdao.existeClienteEmail(email) == true) {
	    				String errorClienteRegistradoEmail = "<div class=\"alert alert-danger\" role=\"alert\">Este correo ya ha sido registrado.</div>";
	    				request.setAttribute("errorClienteRegistradoEmail", errorClienteRegistradoEmail);
	    			}
	    			if (cdao.existeClienteDni(dni) == true) {
	    				String errorClienteRegistradoDni = "<div class=\"alert alert-danger\" role=\"alert\">Este DNI ya ha sido registrado.</div>";
	    				request.setAttribute("errorClienteRegistradoDni", errorClienteRegistradoDni);
	    			}
	    			
	    			if (password1.equals(password)) {
	    			
		    			cliente.setNombre(nombre);
		    			cliente.setApellido(apellido);
		    			cliente.setDni(dni);
		    			cliente.setEmail(email);
		    			cliente.setPassword(password);
		    			cliente.setTipoUsuario(tipoUsuario);
		    			int operacion = cdao.insertarCliente(cliente);
		    			if (operacion == 1) {
		    				session.setAttribute("cliente", cliente);
		    				request.getRequestDispatcher("carrito.jsp");
			    			request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
		    			}else {
		    				String errorRegistro = "<div class=\"alert alert-danger\" role=\"alert\">Hemos tenido problemas registrandote, Intenta mas tarde</div>";
		    				request.setAttribute("errorRegistro", errorRegistro);
		    				request.getRequestDispatcher("registro.jsp").forward(request, response);
		    			}
		    			
	    			} else {
	    				String errorPass = "<div class=\"alert alert-danger\" role=\"alert\">Las contraseñas deben coincidir</div>";
	    				request.setAttribute("ContraseñaInvalida", errorPass);
	    				request.getRequestDispatcher("registro.jsp").forward(request, response);
	    			}
	    			break;
	            
	    		case "VerMisProductos":
	    			
	    			request.setAttribute("cliente",cliente);
		    		request.setAttribute("productos", productos);
		    		
		    		if (cliente.getTipoUsuario() != null){
		    			request.getRequestDispatcher("misproductos.jsp").forward(request, response);
		    		}else if(cliente.getNombre() != null && cliente.getTipoUsuario() == null) {
		    			request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
		    		}else if(cliente.getNombre() == null & cliente.getTipoUsuario() == null ){
		    			request.getRequestDispatcher("iniciarsesion.jsp").forward(request, response);	
		    		}
		    		break;
	    			
	    		case "AgregarNuevosProductos":
	    			request.getRequestDispatcher("agregarproducto.jsp").forward(request, response);
	    			break;
	    			
	    		case "RegistroProductos":
	    			String mensajeRegistroProducto;
	    			Part archivo = request.getPart("foto");
	    			InputStream is = archivo.getInputStream();    			
	    			String name = request.getParameter("nombre");
	    			String descripcion = request.getParameter("descripcion");
	    			double precio = Double.parseDouble(request.getParameter("precio"));
	    			int stock = Integer.parseInt(request.getParameter("stock"));
	    			
	    			
	    			p.setNombre(name);
	    			p.setFoto(is);
	    			p.setDescripcion(descripcion);
	    			p.setPrecio(precio);
	    			p.setStock(stock);
	    			
	    			int operacion = pDAO.insertarProducto(p);
	    			if(operacion == 1) {
	    				mensajeRegistroProducto = "<div class=\"alert alert-success\" role=\"alert\">Su producto ha sido registrado exitosamente.</div>";
	    				request.setAttribute("mensajeRegistroProducto", mensajeRegistroProducto);
	    				request.getRequestDispatcher("Controlador?accion=VerMisProductos").forward(request, response);
	    			}else {
	    				mensajeRegistroProducto = "<div class=\"alert alert-danger\" role=\"alert\">No hemos podido registrar su producto.</div>";
	    				request.setAttribute("mensajeRegistroProducto", mensajeRegistroProducto);
	    				request.getRequestDispatcher("Controlador?accion=VerMisProductos").forward(request, response);
	    			}
	    			break;
	    			
	    		case "EliminarProducto":
    				int idProducto = Integer.parseInt(request.getParameter("idp"));
	    			pDAO.eliminarProducto(idProducto);
	    			request.getRequestDispatcher("Controlador?accion=VerMisProductos");
	    			break;
	    			
	    		case "Buscar":
	    			
	    			String busqueda  = request.getParameter("busqueda");
	    			productos = pDAO.buscarProducto(busqueda);
	    			
	    			if(productos.size() != 0) {
		    			request.setAttribute("cliente",cliente);
		    			request.setAttribute("productos", productos);
		    			request.getRequestDispatcher("index.jsp").forward(request, response);
	    			}else {
	    				String error ="<div class=\"alert alert-danger\" role=\"alert\">Disculpa. no hemos encontrado productos con tu descripcion</div>";
	    				request.setAttribute("error", error);
	    				request.setAttribute("cliente",cliente);
		    			request.getRequestDispatcher("Controlador?accion=home.jsp").forward(request, response);
	    			}
	    			break;
	    			
	    		case "BuscarMisProductos":
	    			
	    			String busquedaMisProductos  = request.getParameter("busqueda");
	    			productos = pDAO.buscarProducto(busquedaMisProductos);
	    			
	    			request.setAttribute("cliente",cliente);
	    			request.setAttribute("productos", productos);
	    			request.getRequestDispatcher("misproductos.jsp").forward(request, response);
	    			
	    			break;
	    			
	    			
	    		case "GenerarPago":
	    			String mensajePago;	
	    			if(cliente.getNombre() != null) {	
		    			if(totalPagar != 0) {
		    				mensajePago ="<div class=\"alert alert-success\" role=\"alert\">Pago realizado exitosamente.</div>";
			    			pago.setMonto(totalPagar);
			    			pago.setIdPago(UUID.randomUUID().toString());
			    			pagoDAO.registrarPago(pago);
			    			request.setAttribute("mensaje",mensajePago);;
			    			request.setAttribute("carrito", listaCarrito);
			    			request.setAttribute("totalPagar",totalPagar);
			    			request.getRequestDispatcher("carrito.jsp").forward(request, response);	
		    			}else {
		    				mensajePago = "<div class=\"alert alert-danger\" role=\"alert\">Hemos tenido un error realizando tu pago, por favor verifica que el carrito de compras no este vacio</div>";
			    			request.setAttribute("mensaje",mensajePago);
		    				request.getRequestDispatcher("carrito.jsp").forward(request, response);	
		    			}
	    			}else {	
	    			request.getRequestDispatcher("iniciarsesion.jsp").forward(request, response);
	    			}
	    			break;
	    			
	    		case "GenerarCompra":
	    			if(cliente.getNombre() != null) {	
			    		if(pago.getIdPago() != null) {	
			    			Compra compra = new Compra();
			    			String fecha = new Date().toString();
			    			compra.setIdCliente(cliente.getIdCliente());
			    			compra.setIdPago(pago.getIdPago());
			    			compra.setFechaCompra(fecha);
			    			compra.setMonto(totalPagar);
			    			compra.setEstado("Su producto esta pendiente de envío");
			    			operacion = compraDAO.registrarCompra(compra);
				    			if(operacion == 1) {
				    				compra = compraDAO.buscarCompraSegunIdPago(pago.getIdPago());
				    				for(int i = 0 ; i < listaCarrito.size() ; i++ ) {
				    					DetalleCompra detalle = new DetalleCompra();
				    					detalle.setIdProducto(listaCarrito.get(i).getIdProducto());
				    					detalle.setIdCompra(compra.getIdCompra());
				    					detalle.setCantidad(listaCarrito.get(i).getCantidad());
				    					detalle.setPrecioCompra(listaCarrito.get(i).getSubTotal());
				    					detalleDAO.insertarDetalleCompra(detalle);
				    					
				    				}
				    				listaCompra.add(compra);
				    				request.setAttribute("listacompra",listaCompra);
			    					request.getRequestDispatcher("compras.jsp").forward(request, response);
				    			}
			    		}else {
		    				errorCompra = "<div class=\"alert alert-danger\" role=\"alert\">Para generar la compra primero debes realizar el pago</div>";
			    			request.setAttribute("errorCompra",errorCompra);
			    			request.setAttribute("carrito", listaCarrito);
			    			request.setAttribute("totalPagar",totalPagar);
		    				request.getRequestDispatcher("carrito.jsp").forward(request, response);	
			    		}
	    			}else {
	    				request.getRequestDispatcher("iniciarsesion.jsp").forward(request, response);
	    			}
	    				
	    			break;
	    			
	    		case "VerMisCompras":
	    			
	    			listaCompra = compraDAO.buscarCompraSegunIdCliente(cliente.getIdCliente());
	    			request.setAttribute("listacompra",listaCompra);
	    			if (cliente.getNombre() != null){
		    			request.getRequestDispatcher("compras.jsp").forward(request, response);
		    		}else {
	    			request.getRequestDispatcher("iniciarsesion.jsp").forward(request, response);
		    		}
	    			break;
	    		case "Detalle":
	    			int idC = Integer.parseInt(request.getParameter("id"));
	    			listaDetalleCompra = detalleDAO.verDetalleCompra(idC);
	    			if (cliente.getNombre() != null){
		    			request.setAttribute("listaDetalleCompra",listaDetalleCompra);
		    			request.getRequestDispatcher("detalle.jsp").forward(request, response);
	    			}else {
	    				request.getRequestDispatcher("iniciarsesion.jsp").forward(request, response);
	    			}
	    		break;
	    		
	    		case "VerMisVentas":
	    			listaCompra = compraDAO.buscarCompras();
	    			request.setAttribute("listacompra",listaCompra);
	    			
	    			if (cliente.getTipoUsuario() != null){
		    			request.getRequestDispatcher("misventas.jsp").forward(request, response);
		    		}else if(cliente.getNombre() != null && cliente.getTipoUsuario() == null) {
		    			request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
		    		}else if(cliente.getNombre() == null & cliente.getTipoUsuario() == null ){
		    			request.getRequestDispatcher("iniciarsesion.jsp").forward(request, response);	
		    		}
	    			
	    		break;
	    		
	    		case "MiPerfil":
	    			request.setAttribute("cliente",cliente);
	    			request.getRequestDispatcher("perfil.jsp").forward(request, response);
	    		break;
	    		
	    		case "CambiarContrasenia":
	    			String mensajeContrasenia;
	    			String passwordNuevo = request.getParameter("password");
	    			String passwordNuevo1 = request.getParameter("password1");
	    			if (passwordNuevo1.equals(passwordNuevo)) {
	    				int resultado = cdao.actualizarContrasenia(cliente.getIdCliente(), passwordNuevo1);
	    					if(resultado ==  1) {
	    						mensajeContrasenia = "<div class=\"alert alert-success\" role=\"alert\">Se ha modificado su contraseña exitosamente.</div>";
	    						request.setAttribute("mensaje", mensajeContrasenia);
	    						request.getRequestDispatcher("perfil.jsp").forward(request, response);
	    					}
	    			}else {
	    				mensajeContrasenia = "<div class=\"alert alert-danger\" role=\"alert\">Las contraseñas deben coincidir</div>";
	    				request.setAttribute("ContraseñaInvalida", mensajeContrasenia);
	    				request.getRequestDispatcher("Cambiarcontrasenia.jsp").forward(request, response);
	    			}
	    			
	    			
	    		break;	
	    		case "CerrarSesion":
	    			listaCarrito = new ArrayList<>();
	                cliente = new Cliente();
	                session.invalidate();
	                request.getRequestDispatcher("Controlador?accion=Salir").forward(request, response);
	                break;	
	    			
	    		default:
	    		request.setAttribute("contador",listaCarrito.size());	
	    		request.setAttribute("cliente",cliente);
	    		request.setAttribute("productos", productos);
	    		request.setAttribute("totalPagar",totalPagar);
	    		request.getRequestDispatcher("index.jsp").forward(request, response);
	    	}
		
    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
