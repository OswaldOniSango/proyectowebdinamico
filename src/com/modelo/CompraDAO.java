package com.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.config.Conexion;

public class CompraDAO {
	Connection conn;
	Conexion con = new Conexion();
	ResultSet rs;
	PreparedStatement ps;
	
	public int registrarCompra(Compra compra) {
		String sql = "insert into compras (idCliente,idPago,fechaCompra, monto, estado) values(?,?,?,?,?)"; 
		int operacion = -1;
		try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, compra.getIdCliente());
			ps.setString(2, compra.getIdPago());
			ps.setString(3, compra.getFechaCompra());
			ps.setDouble(4, compra.getMonto());
			ps.setString(5, compra.getEstado());
			operacion = ps.executeUpdate();
			ps.close();
			conn.close();
			
		}catch  (Exception e) {
			e.getMessage();
		}
		return operacion;
	}
	
	public Compra buscarCompraSegunIdPago(String idPago) {
		String sql = "Select * from compras where idPago ='" +idPago+ "'";
		Compra compra = new Compra();
		try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
				while(rs.next()) {
					compra.setIdCompra(rs.getInt("idCompra"));
					compra.setIdCliente(rs.getInt("idCliente"));
					compra.setIdPago(rs.getString("idPago"));
					compra.setFechaCompra(rs.getString("fechaCompra"));
					compra.setMonto(rs.getDouble("monto"));
					compra.setEstado(rs.getString("estado"));
				}
			}catch (Exception e) {
				e.getMessage();
			
			}
		
		return compra;
		
	}
	public List<Compra> buscarCompraSegunIdCliente(int idCliente) {
		String sql = "Select * from compras where idCliente ="+idCliente;
		List<Compra> listaCompra= new ArrayList<>();
		try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
				while(rs.next()) {
					Compra compra = new Compra();
					compra.setIdCompra(rs.getInt("idCompra"));
					compra.setIdCliente(rs.getInt("idCliente"));
					compra.setIdPago(rs.getString("idPago"));
					compra.setFechaCompra(rs.getString("fechaCompra"));
					compra.setMonto(rs.getDouble("monto"));
					compra.setEstado(rs.getString("estado"));
					listaCompra.add(compra);
				}
			}catch (Exception e) {
				e.getMessage();
			
			}
		
		return listaCompra;
		
	}
	public List<Compra> buscarCompras() {
		String sql = "Select * from compras";
		List<Compra> listaCompra= new ArrayList<>();
		try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
				while(rs.next()) {
					Compra compra = new Compra();
					compra.setIdCompra(rs.getInt("idCompra"));
					compra.setIdCliente(rs.getInt("idCliente"));
					compra.setIdPago(rs.getString("idPago"));
					compra.setFechaCompra(rs.getString("fechaCompra"));
					compra.setMonto(rs.getDouble("monto"));
					compra.setEstado(rs.getString("estado"));
					listaCompra.add(compra);
				}
			}catch (Exception e) {
				e.getMessage();
			
			}
		
		return listaCompra;
		
	}

}
