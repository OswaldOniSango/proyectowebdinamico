package com.modelo;

public class Pago {
	private String idPago;
	private double monto;

	 public Pago() {

	 }
	 public Pago(String idPago, double monto) {
		 this.idPago = idPago;
		 this.monto = monto;
	 }

	 public String getIdPago() {
		 return idPago;
	 }
	 public void setIdPago(String idPago) {
		 this.idPago = idPago;
	 }
	 public double getMonto() {
		 return monto;
	 }
	 public void setMonto(double monto) {
		 this.monto = monto;
	 }
}
