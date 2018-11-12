package com.arcosa.bafar;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;






@SpringBootApplication
public class BafarApplication extends SpringBootServletInitializer {//implements CommandLineRunner {

	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BafarApplication.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(BafarApplication.class, args);
	}
	
	/*@Override
	public void run(String... args) throws Exception {
		
		String fileName = "excel/ejemplo.xls";
        ClassLoader classLoader = new BafarApplication().getClass().getClassLoader();
        String excelPath=classLoader.getResource(fileName).getPath();
       		
	ExcelLectura excel=new ExcelLectura(excelPath);		
	try {			
		Date curDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formath = new SimpleDateFormat("HH:mm:ss");
		        String dateToStr = format.format(curDate);
		        String horaToStr = formath.format(curDate);
		        //System.out.println(DateToStr);

		List<Entradas> inFile= excel.readData(Entradas.class.getName());	
		
		Set<EntradasDetalleJpa> detalle=new HashSet<>();
		double totalPeso=0.0;
		String s_entregas="";
		for (Entradas ent:inFile) {
			s_entregas=	ent.getNoentrega();
			//System.out.println(s_entregas);
			totalPeso +=ent.getPesoneto();
			//System.out.println(ent.getLote());
			EntradasDetalleJpa registro=new EntradasDetalleJpa(ent.getUtrasporte(),ent.getHu(),ent.getSku(),ent.getDescripcion(),ent.getPesoneto(),ent.getFamilia(),ent.getLote(),ent.getFechaproduccion(),ent.getFechacaducidad(),ent.getPosicion(),ent.getUmb());
			detalle.add(registro);
		}
		
		EntradasJpa entradas=new EntradasJpa(s_entregas, totalPeso, inFile.size(), dateToStr, horaToStr, detalle) ;
		
		entradasService.save(entradas);
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	*/
	
}
