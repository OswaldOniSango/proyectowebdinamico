package com.modelo;

public class Carro {
	int item;
	int idProducto;
	String nombre;
	String descripcion;
	double precioCompra;
	int cantidad;
	double subTotal;
	
	public Carro() {
		
	}
	
	public Carro(int item, int idProducto, String nombre, String descripcion, double precioCompra, int cantidad,
			double subTotal) {
		super();
		this.item = item;
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProduco) {
		this.idProducto = idProduco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

}
