package com.arcosa.bafar.controladores;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import java.util.List;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.arcosa.bafar.dao.ICatalogosDao;
import com.arcosa.bafar.dao.ICodigosDao;
import com.arcosa.bafar.dao.IConciliaconDao;
import com.arcosa.bafar.dao.IEntradasDao;
import com.arcosa.bafar.dao.IEntradasDetalleDao;
import com.arcosa.bafar.dao.IPalletDao;
import com.arcosa.bafar.dao.IPickingDao;
import com.arcosa.bafar.dao.ISurtidoDao;
import com.arcosa.bafar.entidades.Catalogos;
import com.arcosa.bafar.entidades.CodigoBarras;
import com.arcosa.bafar.entidades.Conciliacion;
import com.arcosa.bafar.entidades.Entradas;
import com.arcosa.bafar.entidades.EntradasDetalle;
import com.arcosa.bafar.entidades.EntradasDetalleJpa;
import com.arcosa.bafar.entidades.EntradasJpa;
import com.arcosa.bafar.entidades.PalletsJpa;
import com.arcosa.bafar.entidades.PedidoJson;
import com.arcosa.bafar.entidades.PickingJpa;
import com.arcosa.bafar.entidades.SurtidoDetalle;
import com.arcosa.bafar.entidades.SurtidoJson;
import com.arcosa.bafar.service.IClienteService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;


@RestController
public class AplicacionJsonController {

	
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private  IEntradasDao entradasService;
	@Autowired
	private IConciliaconDao conciliacioService;
	@Autowired
	private ISurtidoDao surtidoService;
	@Autowired
	private  IPickingDao pickingService;
	@Autowired
	private IEntradasDetalleDao detalleService;
	@Autowired
	private ICatalogosDao catalogosService;
	@Autowired
	private IPalletDao palletService;
	@Autowired
	private ICodigosDao codigoService;
	
	protected final Log logger = LogFactory.getLog(this.getClass());
	
	//@CrossOrigin(origins = "http://192.168.0.43:9090")
	@CrossOrigin(origins="*")
	@GetMapping(value="/cargar-entrega/{noentrega}",  produces = { "application/json" })
	public @ResponseBody JsonNode jsonEntradas(@PathVariable(value = "noentrega") String noentrega) {
	
		
		logger.info("Variable:  "+noentrega);
		
		ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonNode = mapper.createObjectNode();

    JsonNodeFactory f = JsonNodeFactory.instance ;

    ObjectNode addnode = f.objectNode();
    
    if(noentrega.equals("1")) {
    List<Entradas> entrada=clienteService.findByEntregas(0);
	List<EntradasDetalle> entradadet=clienteService.findByEntregaDetalle(0);
	

	for(Entradas noentrada:entrada) {
		addnode = ((ObjectNode) jsonNode).putObject(noentrada.getNoentrega());
		
		for(EntradasDetalle det:entradadet) {
			if(noentrada.getId()==Long.valueOf(det.getFolio())) {
				
				
				addnode.putObject(det.getHu())
				.put("hu",det.getHu())
					.put("utransporte",det.getNopallet())			     
			        .put("sku",det.getSku())
			        .put("descripcion",det.getDescripcion())
			        .put("lote",det.getLote())
			        .put("umb", det.getUmb())
			        .put("pesoneto",det.getPesoneto())
			        .put("familia",det.getFamilia())
			        .put("fechaproduccion", det.getFechaproduccion())
			        .put("fechacaducidad",det.getFechacaducidad())
			        .put("estatus",det.getCheck_in());
			        
			        
			        
			      
			}
		}
	}
    }
    else if(noentrega.equals("3")) {
        List<Entradas> entrada=clienteService.findByEntregas(3);
    	List<EntradasDetalle> entradadet=clienteService.findByEntregaDetalle(2);
    	

    	for(Entradas noentrada:entrada) {
    		addnode = ((ObjectNode) jsonNode);
    		
    		for(EntradasDetalle det:entradadet) {
    			if(noentrada.getId()==Long.valueOf(det.getFolio())) {
    				
    				
    				addnode.putObject(det.getHu())
    				.put("hu",det.getHu())
    					.put("utransporte",det.getNopallet())			     
    			        .put("sku",det.getSku())
    			        .put("descripcion",det.getDescripcion())
    			        .put("lote",det.getLote())
    			        .put("umb", det.getUmb())
    			        .put("pesoneto",det.getPesoneto())
    			        .put("familia",det.getFamilia())
    			        .put("fechaproduccion", det.getFechaproduccion())
    			        .put("fechacaducidad",det.getFechacaducidad())
    			        .put("estatus",det.getCheck_in());
    			        
    			        
    			        
    			      
    			}
    		}
    	}
        }
    else if(noentrega.equals("2")) {
    	
    
    	List<PickingJpa> pickDet=clienteService.findByPicking();
    	
    	
    	for(PickingJpa pick:pickDet) {
    		
    		addnode = ((ObjectNode) jsonNode).putObject(pick.getNopedido());
    		for(PickingJpa pick2:pickDet) {
    			if(pick2.getNopedido().equals(pick.getNopedido())) {
    		addnode.putObject(pick2.getSku())
    		.put("sku", pick2.getSku())
    		.put("noentrega", pick2.getNoentrega())
    		.put("noentregacliente", pick2.getNoclienteentrega())
	        .put("descripcion",pick2.getDescripcion())
	        .put("pesoObjetivo",pick2.getCantidad())
	        .put("umb",pick2.getUmb())	        
	        .put("estatus",pick2.getCheck_int())
	        .putObject("totales")
	        .put("kilos",0)
	        .put("piezas",0)
	        .put("uMan","[]");
    			}
    		}
    	}
    	
    }
    
    else if(noentrega.equals("4")) {
       
    	
    	Iterable<Catalogos> catDet=catalogosService.findAll();
    	
    	
    	for(Catalogos cat:catDet) {
    		
    		addnode = ((ObjectNode) jsonNode).putObject(cat.getSku())
    		
    		
	        .put("descripcion",cat.getDescripcion())
	        .put("familia",cat.getFamilia())
	        .put("umb",cat.getUmb());
    			
    		
    	}
    }
    	else if (noentrega.equals("5")) {
    	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    	Date fecha=new Date();
    	String sFecha=sdf.format(fecha);
    	int consecutivo=clienteService.findByConsBarras(sFecha);
    	
    	addnode = ((ObjectNode) jsonNode)
        		
        		
    	        .put("consecutivo",consecutivo)
    	        .put("fecha",sFecha);
    		
    	}
    
    	else {
    		Long entrada=clienteService.findByEntregasId(noentrega)==null?0:clienteService.findByEntregasId(noentrega);
    		if(entrada>0) {
        	List<EntradasDetalle> entradadet=clienteService.findByEntrega(noentrega);
        	
        	
        		addnode = ((ObjectNode) jsonNode);
        		
        		for(EntradasDetalle det:entradadet) {
        			if(entrada==Long.valueOf(det.getFolio())) {
        				
        				
        				addnode.putObject(det.getHu())
        				.put("hu",det.getHu())
        					.put("utransporte",det.getNopallet())			     
        			        .put("sku",det.getSku())
        			        .put("descripcion",det.getDescripcion())
        			        .put("lote",det.getLote())
        			        .put("umb", det.getUmb())
        			        .put("pesoneto",det.getPesoneto())
        			        .put("familia",det.getFamilia())
        			        .put("fechaproduccion", det.getFechaproduccion())
        			        .put("fechacaducidad",det.getFechacaducidad())
        			        .put("estatus",det.getCheck_in());
        			      
        			}
        			
        		}
        	
            }
    		else {
    			List<PickingJpa> pickdet= clienteService.findByPickingPed( noentrega);
    			List<SurtidoDetalle> sdet1=clienteService.findBySalFIN(1);
    			List<SurtidoDetalle> sdet2=clienteService.findBySalFIN(2);
    			List<SurtidoDetalle> sdet3=clienteService.findBySalFIN(7);
    			List<SurtidoDetalle> sdet=new ArrayList<>();
    	    	sdet.addAll(sdet1);
    	    	sdet.addAll(sdet2);
    	    	sdet.addAll(sdet3);
    	    	
    	    	for(PickingJpa pick:pickdet) {
    	    		
    	    		addnode = ((ObjectNode) jsonNode).putObject(pick.getNopedido());
    	    		if(pick.getCheck_int()==0) {
    	    			/*addnode.putObject(pick.getSku())		
        	    		.put("sku", pick.getSku())
        	    		.put("noentrega", pick.getNoentrega())
        	    		.put("noentregacliente", pick.getNoclienteentrega())
        		        .put("descripcion",pick.getDescripcion())
        		        .put("peso",pick.getCantidad())
        		        .put("lote",0)
        		        .put("umb",pick.getUmb())	        
        		        .put("estatus",pick.getCheck_int());
        		        */
    	    			
    	    			addnode.putObject("00000")
        				.put("hu","00000")
        					.put("utransporte",0)			     
        			        .put("sku",pick.getSku())
        			        .put("descripcion",pick.getDescripcion())
        			        .put("lote",0)
        			        .put("umb", pick.getUmb())
        			        .put("pesoneto",pick.getCantidad())
        			        .put("familia",0)
        			        .put("fechaproduccion", "")
        			        .put("fechacaducidad","")
        			        .put("estatus",pick.getCheck_int());
    	    			
    	    		}
    	    		
    	    		for(SurtidoDetalle pick2:sdet) {
    	    			if(pick2.getFoliosalida().equals(pick.getNopedido())) {
    	    		/*addnode.putObject(pick.getSku())		
    	    		.put("sku", pick2.getSku())
    	    		.put("noentrega", pick2.getNoentrega())
    	    		.put("noentregacliente", pick.getNoclienteentrega())
    		        .put("descripcion",pick2.getDescripcion())
    		        .put("pesoNeto",pick2.getPesoneto())
    		        .put("lote",pick2.getLote())
    		        .put("umb",pick2.getUmb())	        
    		        .put("estatus",pick2.getCheck_in());
    		        */
    	    				
    	    				addnode.putObject(pick2.getHu())
            				.put("hu",pick2.getHu())
            					.put("utransporte",pick2.getNopallet())			     
            			        .put("sku",pick2.getSku())
            			        .put("descripcion",pick2.getDescripcion())
            			        .put("lote",pick2.getLote())
            			        .put("umb", pick2.getUmb())
            			        .put("pesoneto",pick2.getPesoneto())
            			        .put("familia",pick2.getFamilia())
            			        .put("fechaproduccion", pick2.getFechaproduccion())
            			        .put("fechacaducidad",pick2.getFechacaducidad())
            			        .put("estatus",pick2.getCheck_in());
    	    			
    	    			
    	    			}
    	    		}
    	    	}
    		}
    	}
    	
        

		
	return jsonNode;
				
				
		
	}
	
	
	//@CrossOrigin(origins = "http://192.168.0.43:9090")
	@CrossOrigin(origins="*")
	@PostMapping(path="/envioJson",   consumes = { "application/json" })
		public  String  envioJson(@RequestBody  PedidoJson numpedido) throws Exception {
		
		SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
		
		Date fechaBf=new Date();
		
		    Set<Long> id=new HashSet<>();
		    id.add(clienteService.findByEntregasId(numpedido.getNumPedido()));
		    
		    
		    Iterable<EntradasJpa> entradas=entradasService.findAllById(id);
		    Set<String> codigos=numpedido.getEscaneadas();
		 		    		   
		    for( EntradasJpa entra:entradas) {
		    			
		    	List<EntradasDetalleJpa> detalleList=new ArrayList<>(entra.getDetalle());
		    			    	
		    	for(EntradasDetalleJpa det:detalleList) {
		    		
		    	for (String escaneada:codigos) {
		    					    	
			    	int top=det.getHu().indexOf(escaneada);
			    	if(top==0) {
			    		det.setCheck_in(8);
			    		
			    		codigos.remove(escaneada);
			    		break;
			    	}			    				  
			    }		    			    	
			   }			    	
		    	entradasService.save(entra);
		    }
		    
		    
		    
		    List<Conciliacion> consolida=new ArrayList<>();
		    for (String noescaneada:numpedido.getEscaneadasNo()) {
		    	//System.out.println("no escaneada: "+noescaneada);	
		    	Conciliacion conciliacion=new Conciliacion(noescaneada, "", parseador.format(fechaBf), 0, "E",numpedido.getNumPedido());
		    	consolida.add(conciliacion);
		    	
		    }
		    conciliacioService.saveAll(consolida);
		    
		   
		    return "leido";
		}
	
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/finalizaEnt",   consumes = { "application/json" })
		public  String  finaliza(@RequestBody  PedidoJson numpedido) throws Exception {
		
		    Set<Long> id=new HashSet<>();
		    id.add(clienteService.findByEntregasId(numpedido.getNumPedido()));
		    
		    
		    Iterable<EntradasJpa> entradas=entradasService.findAllById(id);
		    List<EntradasDetalle> codigos=clienteService.findByEntFIN(numpedido.getNumPedido(),8);
		 	
		    if(codigos.size()==0) {
		    	return "Favor de realizar escaneos";
		    }
		    
		    for( EntradasJpa entra:entradas) {
		    			
		    	List<EntradasDetalleJpa> detalleList=new ArrayList<>(entra.getDetalle());
		    			    	
		    	for(EntradasDetalleJpa det:detalleList) {
		    		
		    	for (EntradasDetalle escaneada:codigos) {
		    					    	
			    	int top=det.getHu().indexOf(escaneada.getHu());
			    	if(top==0) {
			    		det.setCheck_in(1);
			    		
			    		codigos.remove(escaneada);
			    		break;
			    	}			    				  
			    }		    			    	
			   }	
		    	entra.setCheck_in(2);
		    	entradasService.save(entra);
		    }
		    
		    /*try {
		    		String path="cmd /c start D:\\Documentos\\merida\\Proyecto_bafar\\cron_entrada.bat";		   
				   //String path="cmd /c start C:\\carnemart\\cron_entrada.bat";
				   //String path="/root/carnemart/cron_entrada.sh";
					Runtime rn=Runtime.getRuntime();
					Process pr=rn.exec(path);					
					logger.info(numpedido.getNumPedido());
					//pr.waitFor(200, TimeUnit.MILLISECONDS);
					
		    }
		    catch(Exception ex) {
		    	logger.error("Primer script");
		    	logger.error(ex.getMessage());
		    }
		    */
		    
		    
		    try {
		    	
		    	
		    	//	String path="cmd /c start D:\\Documentos\\merida\\Proyecto_bafar\\cron_detalle.bat";		   
				  // String path="cmd /c start C:\\carnemart\\cron_detalle.bat";
				   String path="/root/carnemart/cron_detalle.sh";
					Runtime rn=Runtime.getRuntime();
					Process pr=rn.exec(path);					
					logger.info(numpedido.getNumPedido());
					//pr.waitFor(200, TimeUnit.MILLISECONDS);
					Thread.sleep(700);
					 return "finalizado";
					
		    }
		    catch(Exception ex) {
		    	logger.error("Segundo script");
		    	logger.error(ex.getMessage());
		    	return "error";
		    }
		
		    
		}
	
	
	//@CrossOrigin(origins = "http://192.168.0.43:9090")
		@CrossOrigin(origins="*")
	@PostMapping(path="/surtidoJson",   consumes = { "application/json" })
		public  String  surtidoJson(@RequestBody  SurtidoJson numpedido) throws Exception {
		
			logger.info("Surtido JSON");
			

		SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat palletFormat = new SimpleDateFormat("MMddss");
		
		
		
		Date fechaBf=new Date();
		
		
		List<EntradasDetalle> entradadet=clienteService.findByEntregaDetalle(2);
		List<PickingJpa>  clienteDest=clienteService.findByPickingPed(numpedido.getNumPedido());
		Set<List<String>> codigos=numpedido.getEscaneadas();
		List<SurtidoDetalle> listSurtido=new ArrayList<>();
		
		
		String pallet="";
			
		int consecutivo=clienteService.findByPalletsT();
		
		
			for(List<String> tres:codigos) {
		
				
				for(EntradasDetalle det:entradadet) {
				
		    	int top=det.getHu().indexOf(tres.get(0));
		    	if(top==0) {
		    		
		    		String[] llenado=clienteService.findByPickingExc(numpedido.getNumPedido(), numpedido.getNoEntrega(), det.getSku());
		    		
		    		String [] val=llenado[0].split(",");
		    		
		    		
		    		//logger.info("Consecutivo "+consecutivo+ "Posicion "+position+" Posicion for "+pick.getPosicion());
		    		
		    		int pall=consecutivo+Integer.valueOf(tres.get(1));
		    		
		    		//logger.info(tres.get(0)+ "  "+tres.get(1));
		    		if(consecutivo>9) {
						pallet=palletFormat.format(fechaBf)+val[0].toString().substring(1, 4)+"0"+pall;
					}
					if(consecutivo>99) {
						pallet=palletFormat.format(fechaBf)+val[0].toString().substring(1, 4)+pall;
					}
					else {
						pallet=palletFormat.format(fechaBf)+val[0].toString().substring(1, 4)+"00"+pall;
					}
							
					if(det.getSku()!=null || !det.getSku().equals("")) {
						
		    		SurtidoDetalle surt=new SurtidoDetalle(numpedido.getNumPedido(), numpedido.getNoEntrega(), 
		    				val[0].toString(), pallet, tres.get(0), det.getSku(), det.getDescripcion(), det.getPesoneto(), det.getPesobruto(),
		    				1, val[1].toString(), det.getLote(), det.getFechaproduccion(), det.getFechacaducidad(), parseador.format(fechaBf), 
		    				Integer.valueOf(val[2].toString()),String.valueOf(det.getFamilia()),7);
		    		
		    		listSurtido.add(surt);
		    		
					}
		    		
		    		det.setCheck_in(9);
		    		
		    		detalleService.save(det);
		    		entradadet.remove(det);
		    		break;
		    		
		    		
		    	}	
		    	
			}
			
		}
		//pick.setCheck_int(1);
		
		surtidoService.saveAll(listSurtido);
		   
		
		
		  List<Conciliacion> consolida=new ArrayList<>();
		    for (String noescaneada:numpedido.getEscaneadasNo()) {
		    	//System.out.println("no escaneada: "+noescaneada);	
		    	Conciliacion conciliacion=new Conciliacion(noescaneada, "", parseador.format(fechaBf), 0, "S",numpedido.getNumPedido());
		    	consolida.add(conciliacion);
		    }
		    conciliacioService.saveAll(consolida);
		   
		    List<Object[]> groupById=clienteService.findByGroupSurtido(numpedido.getNumPedido());
		    List<PalletsJpa> listpallet=new ArrayList<>();
		   
		    int consecutivo2=clienteService.findByPalletsT();
		    
		    for(Object[] gt:groupById) {
		    
		    	consecutivo2=consecutivo2+1;
		    	 
		    	 String palletB="";
		    	 if(consecutivo>9) {
		    		 palletB="CP00"+(consecutivo2);
					}
		    	 else if(consecutivo>99) {
		    		 palletB="CP0"+(consecutivo2);
					}
		    	 else if(consecutivo>999) {
		    		 palletB="CP"+(consecutivo2);
		    	 }
					else {
						palletB="CP000"+(consecutivo2);
					}
		    	 
		    	    String cliente=(String)gt[0];
		    	    String sku=(String)gt[1];
		    	    String palletS=(String)gt[2];
		    	    String familia=(String)gt[3];
		    	    String cantidades=(String)gt[4];
		    	    
		    	    
		    	    PalletsJpa palletU=new PalletsJpa(palletB,parseador.format(fechaBf),clienteDest.get(0).getDocumento(),numpedido.getNumPedido(),numpedido.getNoEntrega(),cliente,sku,Integer.valueOf(familia),palletS,cantidades);
			    	listpallet.add(palletU);
		    	
		    }
		    
		  
		    
		palletService.saveAll(listpallet);
		
		    
		    return "agregado";
		}
	
		
		@CrossOrigin(origins="*")
	@PostMapping(path="/finalizaSurt",   consumes = { "application/json" })
		public  String  finalizaSurt(@RequestBody  SurtidoJson numpedido) throws Exception {
		
			logger.info("finalizaSurt JSON");
			

		List<EntradasDetalle> entradadet=clienteService.findByEntregaDetalle(9);
		List<PickingJpa>  clienteDest=clienteService.findByPickingPed(numpedido.getNumPedido());
		List<SurtidoDetalle> codigos=clienteService.findBySurtidoDetalle(numpedido.getNumPedido(),7);
		List<SurtidoDetalle> listSurtido=new ArrayList<>();
		
		 if(codigos.size()==0) {
		    	return "Favor de realizar escaneos";
		    }
			
		
		for (PickingJpa pick:clienteDest) {
			
		
			for(SurtidoDetalle tres:codigos) {
		
				
				for(EntradasDetalle det:entradadet) {
				
		    	int top=det.getHu().indexOf(tres.getHu());
		    	if(top==0) {
		    		
							
					
		    		SurtidoDetalle surt=new SurtidoDetalle();
		    		surt.setCheck_in(1);
		    		
		    		listSurtido.add(surt);
		    		
		    		
		    		
		    		det.setCheck_in(3);
		    		
		    		detalleService.save(det);
		    		entradadet.remove(det);
		    		break;
		    		
		    		
		    	}	
		    	
			}
			
		}
		pick.setCheck_int(1);
		pickingService.save(pick);
		surtidoService.saveAll(listSurtido);
		}    
		
		
		 try {
		    	//	String path="cmd /c start D:\\Documentos\\merida\\Proyecto_bafar\\cron_salida.bat";		   
				  // String path="cmd /c start C:\\carnemart\\cron_salida.bat";
				   String path="/root/carnemart/cron_salida.sh";
					Runtime rn=Runtime.getRuntime();
					Process pr=rn.exec(path);					
					logger.info(numpedido.getNumPedido());
					//pr.waitFor(200, TimeUnit.MILLISECONDS);
					
		    }
		    catch(Exception ex) {
		    	logger.error("Primer script Surtido");
		    	logger.error(ex.getMessage());
		    }
		    
		    
		    
		    try {
		    	
		    	Thread.sleep(700);
		    	// String path="cmd /c start D:\\Documentos\\merida\\Proyecto_bafar\\cron_salida_detalle.bat";		   
				 //  String path="cmd /c start C:\\carnemart\\cron_salida_detalle.bat";
				   String path="/root/carnemart/cron_salida_detalle.sh";
					Runtime rn=Runtime.getRuntime();
					Process pr=rn.exec(path);					
					logger.info(numpedido.getNumPedido());
					//pr.waitFor(200, TimeUnit.MILLISECONDS);
					
					 return "finalizado";
		    }
		    catch(Exception ex) {
		    	logger.error("Segundo script Surtido");
		    	logger.error(ex.getMessage());
		    	return "error";
		    }
		
		    
		    
		}
		
		
		@CrossOrigin(origins="*")
		@PostMapping(path="/codigoJson",   consumes = { "application/json" })
			public  String  codigoJson(@RequestBody  List<CodigoBarras> codigos) throws Exception {
			
				logger.info("Codigos de barras JSON");
				
				codigoService.saveAll(codigos);
				
				return "consecutivo";
		}
	
	}
