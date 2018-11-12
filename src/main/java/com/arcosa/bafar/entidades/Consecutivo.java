package com.arcosa.bafar.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consecutivo_dia")
public class Consecutivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	private String tipo;
	private int consecutivo;
	private String fechaingreso;
	private String descripcion;
	private String nopedido;
	private String documento;
	
	public Consecutivo() {}
	
	public Consecutivo(String tipo, int consecutivo,String fechaingreso, String descripcion,String nopedido,String documento) {
		this.tipo=tipo;
		this.consecutivo=consecutivo;
		this.fechaingreso=fechaingreso;
		this.descripcion=descripcion;
		this.nopedido=nopedido;
		this.documento=documento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	public String getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNopedido() {
		return nopedido;
	}

	public void setNopedido(String nopedido) {
		this.nopedido = nopedido;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	
}
