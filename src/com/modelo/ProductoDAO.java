package com.modelo;

import java.io.*;
import java.sql.*;
import java.util.*;
import com.config.Conexion;

import jakarta.servlet.http.HttpServletResponse;

public class ProductoDAO {
	Connection conn;
	Conexion cn = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
	
	public Producto listarID(int id) {
		String sql = "select * from producto where idProducto="+id;
		Producto prod = new Producto();
		try {
			conn = cn.obtenerConexion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				prod.setId(rs.getInt(1));
				prod.setNombre(rs.getString(2));
				prod.setFoto(rs.getBinaryStream(3));
				prod.setDescripcion(rs.getString(4));
				prod.setPrecio(rs.getDouble(5));
				prod.setStock(rs.getInt(5));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return prod;
		
	}
	
	public List<Producto> listar() {
		List<Producto>productos = new ArrayList<>();
		String sql="select * from producto";
		try {
			conn = cn.obtenerConexion();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Producto p = new Producto();
				p.setId(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setFoto(rs.getBinaryStream(3));
				p.setDescripcion(rs.getString(4));
				p.setPrecio(rs.getDouble(5));
				p.setStock(rs.getInt(6));
				productos.add(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
		return productos;
		
	}
	
	public void listarImg(int id, HttpServletResponse response) {
		String sql = "select * from producto where idProducto =" +id;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		
		
		try {
			outputStream = response.getOutputStream();
			conn = cn.obtenerConexion();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				Blob pic = rs.getBlob(3);
				inputStream = pic.getBinaryStream();
				int len = -1;
				byte[] buf = new byte[4096];
				bufferedInputStream = new BufferedInputStream(inputStream);
				bufferedOutputStream = new BufferedOutputStream(outputStream);
				while((len = bufferedInputStream.read(buf)) != -1) {
					bufferedOutputStream.write(buf, 0, len);
				}
				bufferedOutputStream.close();
			}
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		
	}
}
