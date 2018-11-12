package com.arcosa.bafar.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="entradas")
public class Entradas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id",unique=true,nullable=false)
	private Long id;

	@Column(name="noentrega",unique=true,nullable=false)
	private String noentrega;
	private int tipoproducto;
	private double totalpeso;
	private int cantidad;
	private String fechaingreso;
	private String horaingreso;

	private String usuario;
	private int check_in;
	private String codigo_asc;


	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "folio")
	private Set<EntradasDetalle> detalle=new HashSet<>();


	public Entradas() {}

	public Entradas(String noentrega,double totalpeso,int cantidad,String fechaingreso,String horaingreso, Set<EntradasDetalle> detalle) {
		this.noentrega=noentrega;
		this.totalpeso=totalpeso;
		this.cantidad=cantidad;
		this.fechaingreso=fechaingreso;
		this.horaingreso=horaingreso;
		this.detalle=detalle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNoentrega() {
		return noentrega;
	}

	public void setNoentrega(String noentrega) {
		this.noentrega = noentrega;
	}

	public int getTipoproducto() {
		return tipoproducto;
	}

	public void setTipoproducto(int tipoproducto) {
		this.tipoproducto = tipoproducto;
	}

	public double getTotalpeso() {
		return totalpeso;
	}

	public void setTotalpeso(double totalpeso) {
		this.totalpeso = totalpeso;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public String getHoraingreso() {
		return horaingreso;
	}

	public void setHoraingreso(String horaingreso) {
		this.horaingreso = horaingreso;
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

	public Set<EntradasDetalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(Set<EntradasDetalle> detalle) {
		this.detalle = detalle;
	}

	public String getCodigo_asc() {
		return codigo_asc;
	}

	public void setCodigo_asc(String codigo_asc) {
		this.codigo_asc = codigo_asc;
	}

	





}
