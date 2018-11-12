package com.arcosa.bafar.controladores;


import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.arcosa.bafar.dao.IEntradasDao;
import com.arcosa.bafar.dao.IPalletDao;
import com.arcosa.bafar.dao.IPickingDao;
import com.arcosa.bafar.entidades.EntradasDetalle;
import com.arcosa.bafar.entidades.EntradasDetalleJpa;
import com.arcosa.bafar.entidades.EntradasJpa;
import com.arcosa.bafar.entidades.PalletsJpa;
import com.arcosa.bafar.entidades.ParametrosGet;
import com.arcosa.bafar.entidades.PickingJpa;
import com.arcosa.bafar.entidades.SurtidoDetalle;
import com.arcosa.bafar.entidades.TablaExcel;
import com.arcosa.bafar.service.IClienteService;
import com.arcosa.bafar.service.IUploadFileService;
import com.arcosa.bafar.util.ExcelLectura;
import com.carnemart.entidad.Entradas;
import com.carnemart.entidad.Picking;


@Controller
@SessionAttributes("aplicacion")
public class AplicacionController {
	
	@Autowired
	private IUploadFileService uploadFileService;
	@Autowired
	private  IEntradasDao entradasService;
	@Autowired
	private  IPickingDao pickingService;
	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IPalletDao palletService;
	
	
	private int banderaTipo=0;

	protected final Log logger = LogFactory.getLog(this.getClass());
	
	@Secured("ROLE_ADMIN")	
	@RequestMapping(value = {"/carga","/"}, method = RequestMethod.GET)
	public String carga(@RequestParam(name = "page", defaultValue = "0") int page, Model model,
			Authentication authentication,
			HttpServletRequest request,
			Locale locale) {

		if(authentication != null) {
			logger.info("Hola usuario autenticado, tu username es: ".concat(authentication.getName()));
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if(auth != null) {
			logger.info("Utilizando forma estática SecurityContextHolder.getContext().getAuthentication(): Usuario autenticado: ".concat(auth.getName()));
		}
		
		if(hasRole("ROLE_ADMIN")) {
			logger.info("Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}
		
		SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request, "");
		
		if(securityContext.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}

		if(request.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando HttpServletRequest: Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Forma usando HttpServletRequest: Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}	
		
						
		return "carga";
	}
	
	@Secured("ROLE_ADMIN")	
	@RequestMapping(value = {"/surtido"}, method = RequestMethod.GET)
	public String surtido(@ModelAttribute ParametrosGet parametros, Model model,
			Authentication authentication,
			HttpServletRequest request,
			Locale locale) {
		if(authentication != null) {
			logger.info("Hola usuario autenticado, tu username es: ".concat(authentication.getName()));
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if(auth != null) {
			logger.info("Utilizando forma estática SecurityContextHolder.getContext().getAuthentication(): Usuario autenticado: ".concat(auth.getName()));
		}
		
		if(hasRole("ROLE_ADMIN")) {
			logger.info("Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}
		
		SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request, "");
		
		if(securityContext.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}

		if(request.isUserInRole("ROLE_ADMIN")) {
			logger.info("Forma usando HttpServletRequest: Hola ".concat(auth.getName()).concat(" tienes acceso!"));
		} else {
			logger.info("Forma usando HttpServletRequest: Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
		}
		
		model.addAttribute("parametros", new ParametrosGet());
		
	return "surtido";
	}
	
	@Secured("ROLE_ADMIN")	
	@PostMapping("/ver")
	public String surtidoexc(@ModelAttribute("parametros") ParametrosGet parametros,Model model) {
		logger.info("Variable:  "+parametros.getNopedido());
		
		List<SurtidoDetalle> surtido=clienteService.findBySurtidoDetalle(parametros.getNopedido(),2);
		logger.info("Variable surtido:  "+parametros.getNopedido());
		
		
		
		model.addAttribute("tablasurtido", surtido);
		
		return "surtido";
	}

	@CrossOrigin(origins="*")
	@GetMapping("/cargar/{noentrega}")
	public String carga(@PathVariable(value = "noentrega") String noentrega, Model model,
			Authentication authentication,
			HttpServletRequest request,
			Locale locale) {
	
		logger.info("Variable:  "+noentrega);
		
				List<TablaExcel> tablaexcel=new ArrayList<TablaExcel>();
				if(noentrega.substring(0, 1).equals("P")) {
					TablaExcel tb=new TablaExcel();
					tb.setCb1("No. Pedido");
					tb.setCb2("No. Entrega");
					tb.setCb3("No. Cliente Entrega");
					tb.setCb4("Sku");
					tb.setCb5("Descripcion");
					tb.setCb6("Peso Objetivo");
					
					tablaexcel.add(tb);
					
					List<PickingJpa> detPicking=clienteService.findByPicking(noentrega);
					for(PickingJpa picking:detPicking) {
						TablaExcel td=new TablaExcel();
						td.setCb1(picking.getNopedido());
						td.setCb2(picking.getNoentrega());
						td.setCb3(picking.getNoclienteentrega());
						td.setCb4(picking.getSku());
						td.setCb5(picking.getDescripcion());
						td.setCb6(String.valueOf(picking.getCantidad()));
						
						tablaexcel.add(td);
					}
					
				}else {
				TablaExcel tb=new TablaExcel();
				tb.setCb1("No Entrega");
				tb.setCb2("Unidad de Transporte");
				tb.setCb3("Codigo de Barras");
				tb.setCb4("SKU");
				tb.setCb5("Descripcion");
				tb.setCb6("Peso Neto");
				tb.setCb7("Lote");
				tb.setCb8("Fecha de Caducidad");
				tablaexcel.add(tb);
				
				List<EntradasDetalle> detallesEnt=clienteService.findByEntrega(noentrega);
				
				for(EntradasDetalle detalleJpa :detallesEnt) {
					TablaExcel td=new TablaExcel();
					td.setCb1(noentrega);
					td.setCb2(detalleJpa.getNopallet());
					td.setCb3(detalleJpa.getHu());
					td.setCb4(detalleJpa.getSku());
					td.setCb5(detalleJpa.getDescripcion());
					td.setCb6(String.valueOf(detalleJpa.getPesoneto()));
					td.setCb7(detalleJpa.getLote());
					td.setCb8(detalleJpa.getFechacaducidad());
					
					tablaexcel.add(td);
				}
				}
				 model.addAttribute("tablaexcel", tablaexcel);
		return "carga";
	}
	

	@GetMapping("/descargar/{id}")
	public String ver(@PathVariable(value = "id") String id, Model model, RedirectAttributes flash, Locale locale) throws Exception {
	
	
		try {
		if(id == null || id.equals("null")) {
			logger.info("valor nullo");
			model.addAttribute("parametros", new ParametrosGet());
			
			return "surtido";
			
		}
		else {
		logger.info("valor del id "+id);
		List<SurtidoDetalle> archivo = clienteService.findBySurtidoDetalle(id,2); // clienteService.findFacturaById(id);
		
		

		model.addAttribute("excelview", archivo);
		}
		}
		catch (Exception e) {
			return "surtido";
		}
		
		return "excelview/ver";
	}
	
	@GetMapping("/descargarpdf/{id}")
	public String verpdf(@PathVariable(value = "id") String id, Model model, RedirectAttributes flash, Locale locale) throws Exception {
	
	
		try {
		
		logger.info("valor del id etiqueta "+id);
		Long idV=new Long(id);
		Iterable<PalletsJpa> archivo=null;
		if(idV>0) {
		
		Set<Long> valores=new HashSet<>();
		valores.add(idV);
		
		 archivo = palletService.findAllById(valores); // clienteService.findFacturaById(id);
		
		}
		else {
			archivo= clienteService.findByPallets();
		}
		

		model.addAttribute("pdfview", archivo);
		
		}
		catch (Exception e) {
			return "pallets";
		}
		
		return "pdfview/verpdf";
	}
	
	@Secured("ROLE_ADMIN")	
	@RequestMapping(value = "/excelcarga", method=RequestMethod.POST)	
	public String excelcarga(@RequestParam("file") MultipartFile file,Model model) throws MalformedURLException, SQLException {		
		String fileName=escribirExcel(file);
		logger.info("Nombre archivo "+fileName);
		if(fileName.substring(0, 1).equals("E")) {
			banderaTipo=1;
		}
		else if(fileName.substring(0, 1).equals("P")) {
			banderaTipo=2;
		}
		String excelPath=uploadFileService.load(fileName);
		System.out.println("excel path: "+excelPath);
		ExcelLectura excel=new ExcelLectura(excelPath);			
		String valEntrega="";
		
		try {			
			Date curDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat formath = new SimpleDateFormat("HH:mm:ss");
			        String dateToStr = format.format(curDate);
			        String horaToStr = formath.format(curDate);
			        
			        //System.out.println(dateToStr);
			      
			        if(banderaTipo==1) {
			List<Entradas> inFile= excel.readData(Entradas.class.getName());	
			
			Set<EntradasDetalleJpa> detalle=new HashSet<>();
			double totalPeso=0.0;
			String s_entregas="";
			for (Entradas ent:inFile) {				
				s_entregas=	ent.getNoentrega()==null?"":ent.getNoentrega()	;
				
				
				if(!s_entregas.equals("")) {
				totalPeso +=ent.getPesoneto();				
				EntradasDetalleJpa registro=new EntradasDetalleJpa(ent.getUtrasporte()==null?"0":ent.getUtrasporte(),
						ent.getHu()==null?"0":ent.getHu(),ent.getSku()==null?"0":ent.getSku(),
						ent.getDescripcion()==null?"":ent.getDescripcion(),ent.getPesoneto(),
						ent.getFamilia()==null?"0":ent.getFamilia(),ent.getLote()==null?"0":ent.getLote(),
						ent.getFechaproduccion()==null?"":ent.getFechaproduccion(),ent.getFechacaducidad()==null?"":ent.getFechacaducidad(),
						ent.getPosicion()==null?"0":ent.getPosicion(),ent.getUmb()==null?"0":ent.getUmb(),1);
				detalle.add(registro);
				}
			}
			
			EntradasJpa entradas=new EntradasJpa(s_entregas, totalPeso, inFile.size(), dateToStr, horaToStr, detalle,fileName,765) ;
			
			entradasService.save(entradas);
			
			valEntrega=s_entregas;
					
							
			      }
			      else if(banderaTipo==2) {
			    	  List<Picking> inFile= excel.readData(Picking.class.getName());
			    	  
			    	  
						double totalPeso=0.0;
						String s_entregas=fileName;
						
						
						for (Picking ent:inFile) {
							
							totalPeso +=ent.getCantidad();				
							PickingJpa registro=new PickingJpa(ent.getNopedido(),ent.getNoentrega(),ent.getNoclienteentrega(),ent.getPosicion(),ent.getSku(),ent.getDescripcion(),ent.getCantidad(),ent.getUmb(),ent.getFechasalida(),s_entregas,765);
							
							pickingService.save(registro);
						}
						
						
						
						
						
						valEntrega=s_entregas;
			      }
			      					
		} catch (Exception e) {
			// TODO Auto-generated catch block			
			logger.error(e.getMessage());
			return "redirect:/carga";
		}
				
		
		return "redirect:/cargar/" + valEntrega;
	}
	
	
	@Secured("ROLE_USER")	
	@GetMapping("/pallets")
	public String pallets(Model model) {
		
		List<PalletsJpa> pallets=clienteService.findByPallets();
		
		model.addAttribute("palletview", pallets);
		
		return "pallets";
	}

	
	private String escribirExcel(MultipartFile files) {
		try {
			
			byte[] bytes=files.getBytes();
			Path rootPath = uploadFileService.cargaExcel(files);
			Files.write(rootPath, bytes);
			return files.getOriginalFilename();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	
private boolean hasRole(String role) {
		
		SecurityContext context = SecurityContextHolder.getContext();
		
		if(context == null) {
			return false;
		}
		
		Authentication auth = context.getAuthentication();
		
		if(auth == null) {
			return false;
		}
		
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		
		return authorities.contains(new SimpleGrantedAuthority(role));
		
	}
}
