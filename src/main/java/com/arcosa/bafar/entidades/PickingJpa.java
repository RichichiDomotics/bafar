package com.arcosa.bafar.entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="picking")
public class PickingJpa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	private String nopedido;
	private String noentrega;
	private String noclienteentrega;
	private int posicion;
	private String sku;
	private String descripcion;
	private double cantidad;
	private String umb;
	private String fechasalida;
	private String fechaingreso;
	private String horaingreso;
	private String documento;
	private String usuario;
	private int check_int;
	private int idcliente;
	
	
	public PickingJpa() {}
	
	public PickingJpa(String nopedido,String noentrega,String noclienteentrega,int posicion,String sku, String descripcion,double cantidad,String umb,String fechasalida,String documento, int idcliente ) {
		this.nopedido=nopedido;
		this.noentrega=noentrega;
		this.noclienteentrega=noclienteentrega;
		this.posicion=posicion;
		this.sku=sku;
		this.descripcion=descripcion;
		this.cantidad=cantidad;
		this.umb=umb;
		this.fechasalida=fechasalida;
		this.documento=documento;
		this.idcliente=idcliente;
		
	}

	
	

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getCheck_int() {
		return check_int;
	}

	public void setCheck_int(int check_int) {
		this.check_int = check_int;
	}

	public int getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	

}
