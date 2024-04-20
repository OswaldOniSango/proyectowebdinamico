package com.modelo;

public class DetalleCompra {
	private int idDetalle;
	private int idProducto;
	private int idCompra;
	private int cantidad;
	private double precioCompra;
	public DetalleCompra() {

	}
	public DetalleCompra(int idDetalle, int idProducto, int idCompra, int cantidad, double precioCompra) {
		this.idDetalle = idDetalle;
		this.idProducto = idProducto;
		this.idCompra = idCompra;
		this.cantidad = cantidad;
		this.precioCompra = precioCompra;
	}
	public int getIdDetalle() {
		return idDetalle;
	}
	public void setIdDetalle(int idDetalle) {
		this.idDetalle = idDetalle;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}



}
