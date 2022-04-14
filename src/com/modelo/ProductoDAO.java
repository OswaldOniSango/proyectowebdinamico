package com.modelo;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		System.out.println(sql);
		InputStream inputStream = null;
		OutputStream outputStream = null;
		BufferedInputStream bufferedInputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		response.setContentType("image/*");
		
		try {
			outputStream = response.getOutputStream();
			conn = cn.obtenerConexion();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if(rs.next()) {
				inputStream = rs.getAsciiStream("foto");
				
			}
			bufferedInputStream = new BufferedInputStream(inputStream);
			bufferedOutputStream = new BufferedOutputStream(outputStream);
			
			
			
			FileOutputStream ficheronuevo = new FileOutputStream("/Users/macbookAir/eclipse-workspace/ProyectoWEBDinamico/imagen"+id +".jpg");
			int i = 0;
			while((i = bufferedInputStream.read()) != -1) {
				ficheronuevo.write(i);
				bufferedOutputStream.write(i);
				
				
			}
			ficheronuevo.close();
			
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		
	}
}
