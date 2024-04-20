package com.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.config.Conexion;

public class DetalleCompraDAO {
	Connection conn;
	Conexion con = new Conexion();
	PreparedStatement ps;
	ResultSet rs;
		public void insertarDetalleCompra(DetalleCompra detalle) {
			String sql = "Insert into detalle_compra(id_producto, id_compra, cantidad, Precio_compra) values(?,?,?,?)";
			try {
			conn = con.obtenerConexion();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, detalle.getIdProducto());
			ps.setInt(2, detalle.getIdCompra());
			ps.setInt(3, detalle.getCantidad());
			ps.setDouble(4, detalle.getPrecioCompra());
			ps.execute();
			ps.close();
			conn.close();


		}catch (Exception e) {
			e.getMessage();
		}
	}
		public List<DetalleCompra> verDetalleCompra(int idCompra) {
			String sql = "Select * from detalle_compra where id_compra="+idCompra;
			List<DetalleCompra> listaDetalle = new ArrayList<>();

			try {
				conn = con.obtenerConexion();
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
					while(rs.next()){
						DetalleCompra detalle = new DetalleCompra();
						detalle.setIdDetalle(rs.getInt(1));
						detalle.setIdProducto(rs.getInt(2));
						detalle.setIdCompra(rs.getInt(3));
						detalle.setCantidad(rs.getInt(4));
						detalle.setPrecioCompra(rs.getDouble(5));
						listaDetalle.add(detalle);
					}

			}catch (Exception e) {

			}
			return listaDetalle;
		}
}
