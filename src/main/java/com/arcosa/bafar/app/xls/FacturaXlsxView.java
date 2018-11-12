package com.arcosa.bafar.app.xls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.arcosa.bafar.dao.IConsecutivoDao;
import com.arcosa.bafar.entidades.Consecutivo;
import com.arcosa.bafar.entidades.SurtidoDetalle;
import com.arcosa.bafar.service.IClienteService;




@Component("excelview/ver.xlsx")
public class FacturaXlsxView extends AbstractXlsxView {

	@Autowired
	private IClienteService clienteService;
	@Autowired
	private IConsecutivoDao consecutivoDao;
	
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
		SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
		
		

		
		SimpleDateFormat d = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat dc = new SimpleDateFormat("dd.MM.yyyy");
		Date fechaBf=new Date();
		String fechain=parseador.format(fechaBf);
				//response.setHeader("Content-Disposition", "attachment; filename=\"factura_view.xlsx\"");
		List<SurtidoDetalle> excelList = (ArrayList<SurtidoDetalle>) model.get("excelview");
		
		String doc=clienteService.findByCabecera(excelList.get(0).getFoliosalida());
		String sec="";
		String cabecera="";
		Date date = parseador.parse(fechain);
		
		if(doc!=null && !doc.equals("")) {
			cabecera="attachment; filename="+doc ;
		}
		else {
			int consecutivo=clienteService.findByConsecutivo(fechain);
		if(consecutivo==0) {
			consecutivo=1;
			sec="0000"+consecutivo;
		}
		else {
			consecutivo=consecutivo+1;
			if(consecutivo>9) {
				sec="000"+consecutivo;
			}
			if(consecutivo>99) {
				sec="00"+consecutivo;
			}
			else {
				
					sec="0000"+consecutivo;
				
			}
		}
	
		String documento="S"+d.format(date)+sec+".xlsx";
		
		Consecutivo conse=new Consecutivo("S", consecutivo, fechain, "",excelList.get(0).getFoliosalida(),documento);
		consecutivoDao.save(conse);
		
		cabecera="attachment; filename=\"S"+d.format(date)+sec+".xlsx";
		
		
		}
		
		
		
		
		response.setHeader("Content-Disposition",cabecera);
		
		Sheet sheet = workbook.createSheet("SURTIDO");
		
		
		MessageSourceAccessor mensajes =  getMessageSourceAccessor();
		
		
		CellStyle theaderStyle = workbook.createCellStyle();
		theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
		theaderStyle.setBorderTop(BorderStyle.MEDIUM);
		theaderStyle.setBorderRight(BorderStyle.MEDIUM);
		theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
		theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
		theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		CellStyle tbodyStyle = workbook.createCellStyle();
		tbodyStyle.setBorderBottom(BorderStyle.THIN);
		tbodyStyle.setBorderTop(BorderStyle.THIN);
		tbodyStyle.setBorderRight(BorderStyle.THIN);
		tbodyStyle.setBorderLeft(BorderStyle.THIN);
		
		Row header = sheet.createRow(0);
		Cell cell = header.createCell(0);
		
		
		/*header.createCell(0).setCellValue(mensajes.getMessage("text.surtido.nopedido"));
		header.createCell(1).setCellValue(mensajes.getMessage("text.surtido.noentrega"));
		header.createCell(2).setCellValue(mensajes.getMessage("text.surtido.nocliente"));
		header.createCell(3).setCellValue(mensajes.getMessage("text.surtido.nopallet"));
		header.createCell(4).setCellValue(mensajes.getMessage("text.surtido.nocaja"));
		header.createCell(5).setCellValue(mensajes.getMessage("text.surtido.posicion"));
		header.createCell(6).setCellValue(mensajes.getMessage("text.surtido.sku"));
		header.createCell(7).setCellValue(mensajes.getMessage("text.surtido.descripcion"));
		header.createCell(8).setCellValue(mensajes.getMessage("text.surtido.pesoneto"));
		header.createCell(9).setCellValue(mensajes.getMessage("text.surtido.pesobruto"));
		header.createCell(10).setCellValue(mensajes.getMessage("text.surtido.cajas"));
		header.createCell(11).setCellValue(mensajes.getMessage("text.surtido.umb"));
		header.createCell(12).setCellValue(mensajes.getMessage("text.surtido.lote"));
		header.createCell(13).setCellValue(mensajes.getMessage("text.surtido.fechaproduccion"));
		header.createCell(14).setCellValue(mensajes.getMessage("text.surtido.fechacaducidad"));
		header.createCell(15).setCellValue(mensajes.getMessage("text.surtido.fechasalida"));
		*/
		
		header.createCell(0).setCellValue(mensajes.getMessage("text.surtido.noentrega"));
		header.createCell(1).setCellValue(mensajes.getMessage("text.surtido.posicion"));
		header.createCell(2).setCellValue(mensajes.getMessage("text.surtido.lote"));
		header.createCell(3).setCellValue(mensajes.getMessage("text.surtido.sku"));
		header.createCell(4).setCellValue(mensajes.getMessage("text.surtido.nocaja"));
		header.createCell(5).setCellValue(mensajes.getMessage("text.surtido.nocliente"));
		header.createCell(6).setCellValue(mensajes.getMessage("text.surtido.nopallet"));
		header.createCell(7).setCellValue(mensajes.getMessage("text.surtido.nopedido"));
		header.createCell(8).setCellValue(mensajes.getMessage("text.surtido.fechasalida"));
		header.createCell(9).setCellValue(mensajes.getMessage("text.surtido.pesoneto"));
		header.createCell(10).setCellValue(mensajes.getMessage("text.surtido.umb"));
		
		
		header.getCell(0).setCellStyle(theaderStyle);
		header.getCell(1).setCellStyle(theaderStyle);
		header.getCell(2).setCellStyle(theaderStyle);
		header.getCell(3).setCellStyle(theaderStyle);
		header.getCell(4).setCellStyle(theaderStyle);
		header.getCell(5).setCellStyle(theaderStyle);
		header.getCell(6).setCellStyle(theaderStyle);
		header.getCell(7).setCellStyle(theaderStyle);
		header.getCell(8).setCellStyle(theaderStyle);
		header.getCell(9).setCellStyle(theaderStyle);
		header.getCell(10).setCellStyle(theaderStyle);
		/*
		header.getCell(11).setCellStyle(theaderStyle);
		header.getCell(12).setCellStyle(theaderStyle);
		header.getCell(13).setCellStyle(theaderStyle);
		header.getCell(14).setCellStyle(theaderStyle);
		header.getCell(15).setCellStyle(theaderStyle);
		*/
		
		
		int rownum = 1;
		for(SurtidoDetalle item: excelList) {
			Row fila = sheet.createRow(rownum ++);
			/*cell = fila.createCell(0);
			cell.setCellValue(item.getFoliosalida());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(1);
			cell.setCellValue(item.getNoentrega());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(2);
			cell.setCellValue(item.getClientedestino());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(3);
			cell.setCellValue(item.getNopallet());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(4);
			cell.setCellValue(item.getHu());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(5);
			cell.setCellValue(item.getPosicion());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(6);
			cell.setCellValue(item.getSku());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(7);
			cell.setCellValue(item.getDescripcion());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(8);
			cell.setCellValue(item.getPesoneto());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(9);
			cell.setCellValue(item.getPesobruto());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(10);
			cell.setCellValue(item.getCantidadsurtida());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(11);
			cell.setCellValue(item.getUmb());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(12);
			cell.setCellValue(item.getLote());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(13);
			cell.setCellValue(item.getFechaproduccion());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(14);
			cell.setCellValue(item.getFechacaducidad());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(15);
			cell.setCellValue(item.getFecharegistro());
			cell.setCellStyle(tbodyStyle);
			*/
			
			cell = fila.createCell(0);
			cell.setCellValue(item.getNoentrega());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(1);
			cell.setCellValue(item.getPosicion());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(2);
			cell.setCellValue(item.getLote());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(3);
			cell.setCellValue(item.getSku());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(4);
			cell.setCellValue(item.getHu());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(5);
			cell.setCellValue(item.getClientedestino());
			cell.setCellStyle(tbodyStyle);
			
			String pallet=clienteService.findByPalletsNo(item.getNopallet(),item.getFoliosalida());
			
			cell = fila.createCell(6);
			cell.setCellValue(pallet);
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(7);
			cell.setCellValue(item.getFoliosalida());
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(8);
			cell.setCellValue(dc.format(fechaBf));
			cell.setCellStyle(tbodyStyle);
			
			cell = fila.createCell(9);
			cell.setCellValue(item.getPesoneto());
			cell.setCellStyle(tbodyStyle);
			
			
			cell = fila.createCell(10);
			cell.setCellValue(item.getUmb());
			cell.setCellStyle(tbodyStyle);
			
		}
	
	}catch (Exception e) {
		// TODO: handle exception
		logger.error(e.getMessage());
	}
	}
	

}
