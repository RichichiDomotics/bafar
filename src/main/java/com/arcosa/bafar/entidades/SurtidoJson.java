package com.arcosa.bafar.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SurtidoJson implements Serializable {

	 private static final long serialVersionUID = 1L;



	    private Set<List<String>> escaneadas = new HashSet<List<String>>();

	    private Set<String> escaneadasNo = new HashSet<String>();

	   
	    
	    private String noEntrega;
	    private String numPedido;
	    

		

		public Set<List<String>> getEscaneadas() {
			return escaneadas;
		}

		public void setEscaneadas(Set<List<String>> escaneadas) {
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

		public String getNoEntrega() {
			return noEntrega;
		}

		public void setNoEntrega(String noEntrega) {
			this.noEntrega = noEntrega;
		}
	    
	    

}
