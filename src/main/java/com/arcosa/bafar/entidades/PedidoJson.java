package com.arcosa.bafar.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class PedidoJson implements Serializable {



    private static final long serialVersionUID = 1L;



    private Set<String> escaneadas = new HashSet<String>();

    private Set<String> escaneadasNo = new HashSet<String>();


    private String numPedido;





   


	public Set<String> getEscaneadas() {
		return escaneadas;
	}



	public void setEscaneadas(Set<String> escaneadas) {
		this.escaneadas = escaneadas;
	}



	public Set<String> getEscaneadasNo() {
		return escaneadasNo;
	}



	public void setEscaneadasNo(Set<String> escaneadasNo) {
		this.escaneadasNo = escaneadasNo;
	}



	public String getNumPedido() {
		return numPedido;
	}



	public void setNumPedido(String numPedido) {
		this.numPedido = numPedido;
	}



   
}

