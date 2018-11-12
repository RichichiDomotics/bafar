package com.arcosa.bafar.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pallets")
public class PalletsJpa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	private String nopallet;
	private String fechacreacion;
	private String documento;
	private String nopedido;
	private String noentrega;
	private String noclienteentrega;
	private String sku;
	private String usuario;
	private int check_in;
	private int camara;
	private String pallet_surtido;
	private String cantidades;
	
	public PalletsJpa() {}
	
	public PalletsJpa(String nopallet,String fechacreacion,String documento,String nopedido,String noentrega,String noclienteentrega,String sku,int camara,String pallet_surtido,String cantidades) {
		this.nopallet=nopallet;
		this.fechacreacion=fechacreacion;
		this.documento=documento;
		this.nopedido=nopedido;
		this.noentrega=noentrega;
		this.noclienteentrega=noclienteentrega;
		this.sku=sku;
		this.camara=camara;
		this.pallet_surtido=pallet_surtido;
		this.cantidades=cantidades;
	}

	
	
	public String getCantidades() {
		return cantidades;
	}

	public void setCantidades(String cantidades) {
		this.cantidades = cantidades;
	}

	public String getPallet_surtido() {
		return pallet_surtido;
	}

	public void setPallet_surtido(String pallet_surtido) {
		this.pallet_surtido = pallet_surtido;
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

	public String getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(String fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getCheck_in() {
		return check_in;
	}

	public void setCheck_in(int check_in) {
		this.check_in = check_in;
	}

	public int getCamara() {
		return camara;
	}

	public void setCamara(int camara) {
		this.camara = camara;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	
	
}
