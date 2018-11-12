package com.arcosa.bafar.entidades;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Generico  implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 
public String nopedido;
public String activar;

public String getNopedido() {
	return nopedido;
}
public void setNopedido(String nopedido) {
	this.nopedido = nopedido;
}
public String getActivar() {
	return activar;
}
public void setActivar(String activar) {
	this.activar = activar;
}



}
