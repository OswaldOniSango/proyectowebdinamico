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
	public void registrarPago(Pago pay) {
		String sql = "insert into pago (idPAgo, monto) values (?,?)";
		try {
		conn = con.obtenerConexion();
		ps = conn.prepareStatement(sql);
		ps.setString(1, pay.getIdPago());
		ps.setDouble(2, pay.getMonto());
		ps.execute();
		ps.close();
		conn.close();
		}catch (Exception e) {
			e.getMessage();
		}
	}

}
