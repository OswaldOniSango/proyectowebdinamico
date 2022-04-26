package com.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.config.Conexion;

public class ClienteDAO {
	
	
	public void insertarCliente(Cliente cliente) {
		Conexion con = new Conexion();
		Connection conn;
		PreparedStatement ps;
		String sql = "Insert into cliente(nombre, apellido, dni, email, password) values(?,?,?,?,?)";		
		try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellido());
			ps.setString(3, cliente.getDni());
			ps.setString(4, cliente.getEmail());
			ps.setString(5, cliente.getPassword());
			ps.execute();
			ps.close();
			conn.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
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
				cliente.setNombre(rs.getString("nombre"));
				cliente.setApellido(rs.getString("apellido"));
				cliente.setDni(rs.getString("dni"));
				cliente.setEmail(rs.getString("email"));
				cliente.setPassword(rs.getString("password"));
			}
			ps.close();
			conn.close();
		}catch(Exception e) {
			e.getStackTrace();
		}
		System.out.println(cliente.getNombre());
		return cliente;
		
	}
}
