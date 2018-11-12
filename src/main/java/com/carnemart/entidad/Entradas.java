package com.carnemart.entidad;

import java.io.Serializable;

public class Entradas implements Serializable {
	/**
	 * 
	 */

	//------------- Cabecera ------------------//
	private String noentrega;
	//private String almacenEmbq;
	//private String fechaIngreso;
	private String utrasporte;
	
	//-------------Transporte ----------------//
	
	//private String nombreTransp;
	//private String codigoTransp;
	//private Long marchamo;
	//private int temperaturaT;
	//private String notaEspecial;
	
	//--------------Detalle ------------------//
	
	private String hu;
	private String sku;	
	private String descripcion;
	private double pesoneto;
	private String familia;
	private String umb;
	private String lote;
	private String fechaproduccion;
	private String fechacaducidad;	
	private String posicion;
	
	//private double pesoBruto;
	//private String umPeso;
	//private int piezas;
	//private String ubicacion;
	//private int temperaturaP;
	//private String edoCalidad;
	public String getNoentrega() {
		return noentrega;
	}
	public void setNoentrega(String noentrega) {
		this.noentrega = noentrega;
	}
	public String getUtrasporte() {
		return utrasporte;
	}
	public void setUtrasporte(String utrasporte) {
		this.utrasporte = utrasporte;
	}
	public String getHu() {
		return hu;
	}
	public void setHu(String hu) {
		this.hu = hu;
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
	public double getPesoneto() {
		return pesoneto;
	}
	public void setPesoneto(double pesoneto) {
		this.pesoneto = pesoneto;
	}
	public String getFamilia() {
		return familia;
	}
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public String getFechacaducidad() {
		return fechacaducidad;
	}
	public void setFechacaducidad(String fechacaducidad) {
		this.fechacaducidad = fechacaducidad;
	}
	public String getFechaproduccion() {
		return fechaproduccion;
	}
	public void setFechaproduccion(String fechaproduccion) {
		this.fechaproduccion = fechaproduccion;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public String getUmb() {
		return umb;
	}
	public void setUmb(String umb) {
		this.umb = umb;
	}
		
		
	
		
	
	
}
