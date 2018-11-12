package com.arcosa.bafar.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entradas_detalles")
public class EntradasDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
private Long id;
	
	private String nopallet;
	private String hu;
	private String sku;
	private String descripcion;
	private String lote;
	private double pesoneto;
	private double pesobruto;
	private String umpeso;
	private int piezas;
	private String umb;
	private String familia;
	private String ubicacion;
	private String fechacaducidad;
	private String fechaproduccion;
	private int temperaturap;
	private String edocalidad;
	private int posicion;
	private int check_in;
	private String folio;
	
	public EntradasDetalle() {}

	public EntradasDetalle(String nopallet,String hu,String sku,String descripcion,double pesoneto,String familia, String lote,String fechaproduccion,String fechacaducidad,int posicion,String umb) {
		
		this.nopallet=nopallet;
		this.hu=hu;
		this.sku=sku;
		this.descripcion=descripcion;
		this.pesoneto=pesoneto;
		this.familia=familia;
		this.lote=lote;
		this.fechaproduccion=fechaproduccion;
		this.fechacaducidad=fechacaducidad;
		this.posicion=posicion;
		this.umb=umb;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNopallet() {
		return nopallet;
	}

	public void setNopallet(String nopallet) {
		this.nopallet = nopallet;
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

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public double getPesoneto() {
		return pesoneto;
	}

	public void setPesoneto(double pesoneto) {
		this.pesoneto = pesoneto;
	}

	public double getPesobruto() {
		return pesobruto;
	}

	public void setPesobruto(double pesobruto) {
		this.pesobruto = pesobruto;
	}

	public String getUmpeso() {
		return umpeso;
	}

	public void setUmpeso(String umpeso) {
		this.umpeso = umpeso;
	}

	public int getPiezas() {
		return piezas;
	}

	public void setPiezas(int piezas) {
		this.piezas = piezas;
	}

	public String getUmb() {
		return umb;
	}

	public void setUmb(String umb) {
		this.umb = umb;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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

	public int getTemperaturap() {
		return temperaturap;
	}

	public void setTemperaturap(int temperaturap) {
		this.temperaturap = temperaturap;
	}

	public String getEdocalidad() {
		return edocalidad;
	}

	public void setEdocalidad(String edocalidad) {
		this.edocalidad = edocalidad;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public int getCheck_in() {
		return check_in;
	}

	public void setCheck_in(int check_in) {
		this.check_in = check_in;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	

	
}
