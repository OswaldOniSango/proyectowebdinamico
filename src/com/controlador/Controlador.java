package com.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.modelo.Carro;
import com.modelo.Cliente;
import com.modelo.ClienteDAO;
import com.modelo.Producto;
import com.modelo.ProductoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Controlador
 */
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
    String nombreClienteLogueado = "Iniciar sesion";
    String emailClienteLogueado = "Registrarse";
    Cliente cliente = new Cliente();
	ClienteDAO cdao = new ClienteDAO();
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			String accion = request.getParameter("accion");
	    	productos = pDAO.listar();
	    	Producto p = new Producto();
	    	HttpSession session = request.getSession();
	    	session.setAttribute("log", nombreClienteLogueado);
	        session.setAttribute("logmail", emailClienteLogueado);

	        
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
	    			System.out.println(passwordSesion);
	    			
	    			
	    			cliente = cdao.validarCliente(emailSesion, passwordSesion);
	    			if (cliente.getNombre() != null && cliente.getDni() != null && cliente.getEmail() != null) {
	    				session = request.getSession();
		    			nombreClienteLogueado = cliente.getNombre() + " " + cliente.getApellido();
		    			emailClienteLogueado = cliente.getEmail();
	    				request.setAttribute("cliente", cliente);
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
	    			
	    			if (password1.equals(password)) {
	    			
	    			cliente.setNombre(nombre);
	    			cliente.setApellido(apellido);
	    			cliente.setDni(dni);
	    			cliente.setEmail(email);
	    			cliente.setPassword(password);
	    			session = request.getSession();
	    			nombreClienteLogueado = cliente.getNombre() + " " + cliente.getApellido();
	    			emailClienteLogueado = cliente.getEmail();
	    			
	    			cdao.insertarCliente(cliente);
	    			
	    			
	    			request.setAttribute("cliente", cliente);
	    			request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
	    			} else {
	    				String errorPass = "Las contraseñas deben coincidir";
	    				request.setAttribute("ContraseñaInvalida", errorPass);
	    				request.getRequestDispatcher("registro.jsp").forward(request, response);
	    			}
	    			break;
	            
	    		
	    		case "CerrarSesion":
	    			listaCarrito = new ArrayList<>();
	                cliente = new Cliente();
	                session.invalidate();
	                nombreClienteLogueado = "Iniciar Sesion";
	                emailClienteLogueado = "Registrarse";
	                request.getRequestDispatcher("Controlador?accion=Salir").forward(request, response);
	                break;	
	    			
	    		default:
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
