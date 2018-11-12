package com.arcosa.bafar.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="surtido_detalle")
public class SurtidoDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
private Long id;
	private String foliosalida;
	private String noentrega;
	private String clientedestino;
	private String nopallet;
	private String hu;
	private String sku;
	private String descripcion;
	private double pesoneto;
	private double pesobruto;
	private int cantidadsurtida;
	private String umb;
	private String lote;
	private String fechaproduccion;
	private String fechacaducidad;
	private String fecharegistro;
	private int posicion;
	public String familia;
	public int check_in;

	public SurtidoDetalle() {}
	
	public SurtidoDetalle(String foliosalida,String noentrega,String clientedestino,String nopallet,String hu,String sku,String descripcion,double pesoneto,double pesobruto,int cantidadsurtida,String umb,String lote, String fechaproduccion,String fechacaducidad, String fecharegistro,int posicion,String familia,int check_in) {
		this.foliosalida=foliosalida;
		this.noentrega=noentrega;
		this.clientedestino=clientedestino;
		this.nopallet=nopallet;
		this.hu=hu;
		this.sku=sku;
		this.descripcion=descripcion;
		this.pesoneto=pesoneto;
		this.pesobruto=pesobruto;
		this.cantidadsurtida=cantidadsurtida;
		this.umb=umb;
		this.lote=lote;
		this.fechaproduccion=fechaproduccion;
		this.fechacaducidad=fechacaducidad;
		this.fecharegistro=fecharegistro;
		this.posicion=posicion;
		this.familia=familia;
		this.check_in=check_in;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoliosalida() {
		return foliosalida;
	}

	public void setFoliosalida(String foliosalida) {
		this.foliosalida = foliosalida;
	}

	public String getNoentrega() {
		return noentrega;
	}

	public void setNoentrega(String noentrega) {
		this.noentrega = noentrega;
	}

	public String getClientedestino() {
		return clientedestino;
	}

	public void setClientedestino(String clientedestino) {
		this.clientedestino = clientedestino;
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

	public int getCantidadsurtida() {
		return cantidadsurtida;
	}

	public void setCantidadsurtida(int cantidadsurtida) {
		this.cantidadsurtida = cantidadsurtida;
	}

	public String getUmb() {
		return umb;
	}

	public void setUmb(String umb) {
		this.umb = umb;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getFechaproduccion() {
		return fechaproduccion;
	}

	public void setFechaproduccion(String fechaproduccion) {
		this.fechaproduccion = fechaproduccion;
	}

	public String getFechacaducidad() {
		return fechacaducidad;
	}

	public void setFechacaducidad(String fechacaducidad) {
		this.fechacaducidad = fechacaducidad;
	}

	public String getFecharegistro() {
		return fecharegistro;
	}

	public void setFecharegistro(String fecharegistro) {
		this.fecharegistro = fecharegistro;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public int getCheck_in() {
		return check_in;
	}

	public void setCheck_in(int check_in) {
		this.check_in = check_in;
	}
	
	
}
