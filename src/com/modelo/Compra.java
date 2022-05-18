package com.modelo;



public class Compra {
	private int idCompra;
	private int idCliente;
	private String idPago;
	private String fechaCompra;
	private double monto;
	private String estado;
	int id = 100;
	public Compra() {
		
	}
	
	public Compra (int idCompra, int idCliente, String idPago, String fechaCompra, double monto, String estado) {
		this.idCompra = idCompra;
		this.idCliente = idCliente;
		this.idPago = idPago;
		this.fechaCompra = fechaCompra;
		this.monto = monto;
		this.estado = estado;
	}

	public int getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getIdPago() {
		return idPago;
	}

	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}
 
	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fecha) {
		this.fechaCompra = fecha;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public int generedorID () {
		
		id++;
		return id;
	}
}
