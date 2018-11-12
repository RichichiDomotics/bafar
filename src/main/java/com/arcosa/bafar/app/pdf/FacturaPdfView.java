package com.arcosa.bafar.app.pdf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Component;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.arcosa.bafar.entidades.PalletsJpa;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

@Component("pdfview/verpdf")
public class FacturaPdfView extends AbstractPdfView {


	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<PalletsJpa> excelList = (ArrayList<PalletsJpa>) model.get("pdfview");
		
		logger.info("Lista Pallet :"+excelList.size());
		
		for(PalletsJpa item: excelList) {
			
			 Barcode barcode3;
			    barcode3 = BarcodeFactory.createCode128(item.getNopallet());
			    barcode3.setResolution(300);
			    
			    
			  
			   // BarcodeImageHandler.savePNG(barcode3, new File("D:/carnemart/codigos/Code128-1.png"));
			   // Image imd = Image.getInstance("D:/carnemart/codigos/Code128-1.png");
			    
			   // BarcodeImageHandler.savePNG(barcode3, new File("C:/carnemart/codigos/Code128-1.png"));			    
			   // Image imd = Image.getInstance("C:/carnemart/codigos/Code128-1.png");
			    
			    BarcodeImageHandler.savePNG(barcode3, new File("/root/carnemart/codigos/Code128-1.png"));			    
			    Image imd = Image.getInstance("/root/carnemart/codigos/Code128-1.png");
			    
			    //Rectangle pagesize=new Rectangle(5.08f,7.62f,90);
			    Rectangle pagesize=PageSize.A4;
			    		    
		PdfPTable tabla = new PdfPTable(2);
		tabla.setWidths(new int[]{8, 14});
		
		
		PdfPCell cell = null;
		
		cell = new PdfPCell(new Phrase("No. Pedido "));		
		cell.setHorizontalAlignment(1);
		cell.setBorder(0);
		tabla.addCell(cell);
		
		PdfPCell cell2 = null;
		
		cell2 = new PdfPCell(imd);
		
		cell2.setBorder(0);
		cell2.setRowspan(3);
		cell2.setHorizontalAlignment(1);
		tabla.addCell(cell2);
		
		PdfPCell cell3 = null;
		Font font3=new Font();
		font3.setSize(20);
		font3.setStyle(1);
		cell3 = new PdfPCell(new Phrase(item.getNopedido(),font3));	
		cell3.setBorder(0);
		cell3.setRowspan(3);
	
		tabla.addCell(cell3);
		
		PdfPCell cell4 = null;
		Font font4=new Font();
		font4.setSize(16);
		font4.setStyle(1);
		
		cell4 = new PdfPCell(new Phrase(item.getNopallet(),font4));	
		cell4.setHorizontalAlignment(1);
		cell4.setBorder(0);
		cell4.setPadding(8f);
		tabla.addCell(cell4);
	
		
		
		PdfPCell cell5 = null;
		Font font5=new Font();
		font5.setSize(12);
		font5.setStyle(0);
		
		cell5 = new PdfPCell(new Phrase("Cliente Destino "+ item.getNoclienteentrega(),font5));	
		cell5.setHorizontalAlignment(1);		
		cell5.setBorder(1);
		cell5.setPadding(14f);
		tabla.addCell(cell5);
		
		
		PdfPCell cell6 = null;
		Font font6=new Font();
		font6.setSize(12);
		font6.setStyle(0);
		
		cell6 = new PdfPCell(new Phrase("No. Entrega: "+item.getNoentrega(),font6));	
		cell6.setHorizontalAlignment(1);		
		cell6.setBorder(1);
		cell6.setPadding(14f);
		tabla.addCell(cell6);
		
		
		int itera=0;
		
		String [] sku=item.getSku().split(",");
		String [] cantidad=item.getCantidades().split(",");
		int total=0;
		for (String valorSku:sku) {
			tabla.addCell("SKU "+valorSku +": CANTIDAD "+cantidad[itera]);
			total=total+Integer.valueOf(cantidad[itera]);
			itera++;
		}
		
		PdfPCell cell7 = null;
		Font font7=new Font();
		font7.setSize(12);
		font7.setStyle(0);
		
		cell7 = new PdfPCell(new Phrase("TOTALES :"+total,font7));	
		cell7.setColspan(2);
		//cell7.setPadding(14f);
		tabla.addCell(cell7);
		
		
		
		
		document.add(tabla);
		document.setPageSize(pagesize);
		
		
		
		}
		
	}

}
