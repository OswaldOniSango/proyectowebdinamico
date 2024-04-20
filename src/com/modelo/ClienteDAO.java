package com.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.config.Conexion;

public class ClienteDAO {


	public int insertarCliente(Cliente cliente) {
		Conexion con = new Conexion();
		Connection conn;
		PreparedStatement ps;
		int operacion = -1;

		String sql = "Insert into cliente(nombre, apellido, dni, email, password, tipo_usuario) values(?,?,?,?,?,?)";
		try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getEmail());
			ps.setString(5, cliente.getPassword());
			ps.setString(6, cliente.getTipoUsuario());
			operacion = ps.executeUpdate();
			ps.close();
			conn.close();

		}catch(Exception e) {
			e.getStackTrace();
		}
		return operacion;

	}

	public Cliente validarCliente(String email, String password) {

		Conexion con = new Conexion();
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		Cliente cliente = new Cliente();
		String sql = "Select * from cliente where email='"+email+"' and password='"+password+"'";
		try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				cliente.setIdCliente(rs.getInt("id"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setDni(rs.getString("dni"));
				cliente.setEmail(rs.getString("email"));
				cliente.setPassword(rs.getString("password"));
				cliente.setTipoUsuario(rs.getString("tipo_usuario"));

			}
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		return cliente;

	}
	public boolean existeClienteEmail(String email) {

		Conexion con = new Conexion();
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		String sql = "Select * from cliente where email='"+email+"'";
		boolean existe = false;
		try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				existe = true;
			}
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		return existe;

	}
	public boolean existeClienteDni(String dni) {

	Conexion con = new Conexion();
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String sql = "Select * from cliente where dni='"+dni+"'";
	boolean existe = false;
	try {
		conn = con.obtenerConexion();
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while(rs.next()) {
			existe = true;
		}
		ps.close();
		conn.close();
	}catch(Exception e) {
		e.getStackTrace();
	}
	return existe;
	}

	public int actualizarContrasenia(int id, String password) {
		Conexion con = new Conexion();
		Connection conn;
		PreparedStatement ps;
		int operacion = -1;
		String sql = "Update cliente set password = ? where id = ?";
		try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setInt(2, id);
			operacion = ps.executeUpdate();
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.getMessage();
		}

		return operacion;
	}
	public Cliente verPerfilCliente(int id) {

		Conexion con = new Conexion();
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		Cliente cliente = new Cliente();
		String sql = "Select * from cliente where id="+id;
		try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				cliente.setIdCliente(rs.getInt("id"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setDni(rs.getString("dni"));
				cliente.setEmail(rs.getString("email"));
				cliente.setPassword(rs.getString("password"));
				cliente.setTipoUsuario(rs.getString("tipo_usuario"));

			}
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		return cliente;

	}

}
