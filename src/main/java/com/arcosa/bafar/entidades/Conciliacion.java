package com.arcosa.bafar.entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="conciliacion")
public class Conciliacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	private String hu;
	private String observaciones;
	private String fechaingreso;
	private int conciliacion;
	private String tipomovimiento;
	private String fechaconciliada;
	private String folio;
	
	public Conciliacion() {}
	
	public Conciliacion(String hu,String observaciones,String fechaingreso,int conciliacion,String tipomovimiento,String folio) {
		this.hu=hu;
		this.observaciones=observaciones;
		this.fechaingreso=fechaingreso;
		this.conciliacion=conciliacion;
		this.tipomovimiento=tipomovimiento;
		this.folio=folio;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHu() {
		return hu;
	}

	public void setHu(String hu) {
		this.hu = hu;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getFechaingreso() {
		return fechaingreso;
	}

	public void setFechaingreso(String fechaingreso) {
		this.fechaingreso = fechaingreso;
	}

	public int getConciliacion() {
		return conciliacion;
	}

	public void setConciliacion(int conciliacion) {
		this.conciliacion = conciliacion;
	}

	public String getTipomovimiento() {
		return tipomovimiento;
	}

	public void setTipomovimiento(String tipomovimiento) {
		this.tipomovimiento = tipomovimiento;
	}

	public String getFechaconciliada() {
		return fechaconciliada;
	}

	public void setFechaconciliada(String fechaconciliada) {
		this.fechaconciliada = fechaconciliada;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}
	
	
	
	
}
