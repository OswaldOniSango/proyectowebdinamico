package com.modelo;

import java.io.InputStream;

public class Producto {
	int id;
	String nombre;
	InputStream foto;
	String descripcion;
	double precio;
	int stock;
	boolean oferta;
	double precioOferta;

	public Producto() {

	}

	public Producto(int  id, String nombre, InputStream foto, String descripcion, double precio, int stock, boolean oferta, double precioOferta) {
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.oferta = oferta;
		this.precioOferta = precioOferta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public InputStream getFoto() {
		return foto;
	}

	public void setFoto(InputStream foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	public boolean getOferta() {
		return oferta;
	}

	public double getPrecioOferta() {
		return precioOferta;
	}

	public void setPrecioOferta(double precioOferta) {
		this.precioOferta = precioOferta;
	}

}
