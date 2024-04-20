package com.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.config.Conexion;

public class PagoDAO {
	Connection conn;
	Conexion con = new Conexion();
	ResultSet rs;
	PreparedStatement ps;
	public void registrarPago(Pago pago) {
		String sql = "insert into pago (idPAgo, monto) values (?,?)";
		try {
		conn = con.obtenerConexion();
		ps = conn.prepareStatement(sql);
		ps.setString(1, pago.getIdPago());
		ps.setDouble(2, pago.getMonto());
		ps.execute();
		ps.close();
		conn.close();
		}catch (Exception e) {
			e.getMessage();
		}
	}

}
