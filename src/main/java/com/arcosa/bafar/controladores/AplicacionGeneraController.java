package com.arcosa.bafar.controladores;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arcosa.bafar.dao.IEntradasDao;
import com.arcosa.bafar.entidades.Entradas;
import com.arcosa.bafar.entidades.EntradasJpa;
import com.arcosa.bafar.entidades.Generico;
import com.arcosa.bafar.service.IClienteService;

@RestController
public class AplicacionGeneraController {
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private  IEntradasDao entradasService;
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/generaRD",   consumes = { "application/json" })
	public String generaRD(@RequestBody  Generico numpedido) throws Exception {
		String codigoRD="";
		logger.info("Generacion de RD "+numpedido.getActivar());
		if(numpedido.getActivar().equals("0")) {
			
			
				Long id=clienteService.findByEntregasId(numpedido.getNopedido());
				
				Optional<EntradasJpa> fr=entradasService.findById(id);
		    
		    EntradasJpa ou=fr.get();
		   if(ou.getCodigo_asc()==null || ou.getCodigo_asc().equals("")) {
		    ou.setCheck_in(99);
		   entradasService.save(ou);
			
		//	String path="cmd /c start D:\\Documentos\\merida\\Proyecto_bafar\\cron_interfaz.bat";		   
		  // String path="cmd /c start C:\\carnemart\\cron_interfaz.bat";
		   String path="/root/carnemart/cron_interfaz.sh";
			Runtime rn=Runtime.getRuntime();
			Process pr=rn.exec(path);					
			logger.info(numpedido.getNopedido());
			//pr.waitFor(200, TimeUnit.MILLISECONDS);
			Thread.sleep(1000);
			codigoRD=clienteService.findByEntregasRD(numpedido.getNopedido());
			logger.info(codigoRD);
			
			
		   }
		   else {
			   codigoRD=clienteService.findByEntregasRD(numpedido.getNopedido());
		   }
			
		}
		else if(numpedido.getActivar().equals("1")) {
			Long id=clienteService.findByEntregasId(numpedido.getNopedido());
			
			Optional<EntradasJpa> fr=entradasService.findById(id);
	    
	    EntradasJpa ent=fr.get();
	    ent.setCheck_in(0);
	    entradasService.save(ent);
	    
		}
		else if(numpedido.getActivar().equals("2")) {
			codigoRD=clienteService.findByEntregasRD(numpedido.getNopedido());
		}
		
		return codigoRD;
	}

}
