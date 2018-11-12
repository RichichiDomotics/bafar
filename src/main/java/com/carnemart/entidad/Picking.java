package com.carnemart.entidad;

import java.io.Serializable;

public class Picking implements Serializable {

	/**
	 * 
	 */
	
	
	private String nopedido;
	private String noentrega;
	private String noclienteentrega;
	private int posicion;
	private String sku;
	private String descripcion;
	private double cantidad;
	private String umb;
	private String fechasalida;
	
	
	public String getNopedido() {
		return nopedido;
	}
	public void setNopedido(String nopedido) {
		this.nopedido = nopedido;
	}
	public String getNoentrega() {
		return noentrega;
	}
	public void setNoentrega(String noentrega) {
		this.noentrega = noentrega;
	}
	public String getNoclienteentrega() {
		return noclienteentrega;
	}
	public void setNoclienteentrega(String noclienteentrega) {
		this.noclienteentrega = noclienteentrega;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public String getUmb() {
		return umb;
	}
	public void setUmb(String umb) {
		this.umb = umb;
	}
	public String getFechasalida() {
		return fechasalida;
	}
	public void setFechasalida(String fechasalida) {
		this.fechasalida = fechasalida;
	}
	
	
	

}
