package com.controlador;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import com.modelo.Carro;
import com.modelo.Cliente;
import com.modelo.ClienteDAO;
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
    int item;
    double totalPagar;
    int cantidad = 1;
    Cliente cliente = new Cliente();
	ClienteDAO cdao = new ClienteDAO();
    Producto p = new Producto();
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String accion = request.getParameter("accion");
	    	productos = pDAO.listar();
	    	Producto p = new Producto();
	    	HttpSession session = request.getSession();
	    	
	    	
	        
	    	int idp;
	    	Carro car;
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
	    				request.getRequestDispatcher("carrito.jsp");
	    				request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
	    			}else {
	    				String errorValidacion = "Usuario o contraseña incorrecta";
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
	    				String errorClienteRegistradoEmail = "Este correo ya ha sido registrado.";
	    				request.setAttribute("errorClienteRegistradoEmail", errorClienteRegistradoEmail);
	    			}
	    			if (cdao.existeClienteDni(dni) == true) {
	    				String errorClienteRegistradoDni = "Este DNI ya ha sido registrado.";
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
		    				String errorRegistro = "Disculpa, hemos tenido un error al registrarte. <Br>Por favor, intenta mas tarde.";
		    				request.setAttribute("errorRegistro", errorRegistro);
		    				request.getRequestDispatcher("registro.jsp").forward(request, response);
		    			}
		    			
	    			} else {
	    				String errorPass = "Las contraseñas deben coincidir";
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
	    			Part archivo = request.getPart("foto");
	    			InputStream is = archivo.getInputStream();    			
	    			int id = Integer.parseInt(request.getParameter("id"));
	    			String name = request.getParameter("nombre");
	    			String descripcion = request.getParameter("descripcion");
	    			double precio = Double.parseDouble(request.getParameter("precio"));
	    			int stock = Integer.parseInt(request.getParameter("stock"));
	    			
	    			p.setId(id);
	    			p.setNombre(name);
	    			p.setFoto(is);
	    			p.setDescripcion(descripcion);
	    			p.setPrecio(precio);
	    			p.setStock(stock);
	    			
	    			int operacion = pDAO.insertarProducto(p);
	    			
	    			System.out.println(operacion);
	    			
	    			
	    			request.getRequestDispatcher("Controlador?accion=VerMisProductos").forward(request, response);
	    			break;
	    			
	    		case "EliminarProducto":
	    			
	    			int idProducto = Integer.parseInt(request.getParameter("idp"));
	    			pDAO.EliminarProducto(idProducto);
	    			
	    			request.getRequestDispatcher("Controlador?accion=VerMisProductos");
	    			break;
	    		case "CerrarSesion":
	    			listaCarrito = new ArrayList<>();
	                cliente = new Cliente();
	                session.invalidate();
	                request.getRequestDispatcher("Controlador?accion=Salir").forward(request, response);
	                break;	
	    			
	    		default:
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
