package com.arcosa.bafar.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class ExcelLectura {

	private List<String> fieldNames=new ArrayList<>();
	private Workbook workbook=null;
	private String workbookName="";
	
	public ExcelLectura(String workbookName) {
		this.workbookName=workbookName;
		initialize();
		
	}
	
	private void initialize() {
	setWorkbook(new HSSFWorkbook());
	}
	
	public void closeWorksheet() {
		FileOutputStream fileOut;
		try {
			fileOut=new FileOutputStream(getWorkbookName());
			getWorkbook().write(fileOut);
			fileOut.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			// TODO: handle exception
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean setupFieldsForClass(Class<?> calzz) throws Exception{
	Field[] fields= calzz.getDeclaredFields();
	for (int i=0; i< fields.length; i++) {
		fieldNames.add(fields[i].getName());
	}
	return true;
	
	}
	
	private Sheet getSheetWithName(String name) {
		Sheet sheet=null;
		for(int i=0; i<workbook.getNumberOfSheets(); i++) {
			if(name.compareTo(workbook.getSheetName(i))==0) {
				sheet=workbook.getSheetAt(i);
				break;
			}
		}
		return sheet;
	}
	
	private void initializeForRead() throws InvalidFormatException, IOException{
		InputStream inp=new FileInputStream(getWorkbookName());
		workbook=WorkbookFactory.create(inp);		
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> readData(String classname) throws Exception{
		
			initializeForRead();
		
		Sheet sheet=getSheetWithName(classname);
		List<T> result=new ArrayList<T>();
		
		Class clazz=Class.forName(workbook.getSheetName(0));
		setupFieldsForClass(clazz);
		
		Row row;
		for(int rowCount=1; rowCount<sheet.getPhysicalNumberOfRows(); rowCount++) {
			T one=(T) clazz.newInstance();
			row=sheet.getRow(rowCount);
			int colCount=0;			
			//System.out.println("valor importante "+row.getCell(0).getCellType()+ "  "+rowCount);
			if(row.getCell(0).getCellType().equals("BLANK") || row.getCell(0).getCellType()==CellType.BLANK) {
				
				break;
			}
			
			result.add(one);
			for(Cell cell:row) {
				
				String fieldName=fieldNames.get(colCount ++);
				
				Method method=constructMethod(clazz,fieldName);
				CellType cellType=cell.getCellTypeEnum();
				Class<?>returnType2=getGetterReturnClass(clazz,fieldName);
				
				//System.out.println(fieldName +" "+returnType2.getTypeName()+" "+cellType);
			
				
					 if(returnType2.getTypeName() .equals("java.lang.String")) {
						//System.out.println("entro1");
						 try {
							 String value=cell.getStringCellValue()==null?"":cell.getStringCellValue();	
							 
								
								Object[] values=new Object[1];
								values[0]=value;
								method.invoke(one, values);
								
						 }catch(Exception ex) {
							 //System.out.println("uno 1 " +ex.getMessage());
							 
							 Double num=cell.getNumericCellValue();
						
							 DecimalFormat df = new DecimalFormat("###############");				           
					             String str = df.format(num);	
					             
					            method.invoke(one, str);
					           
						 }
					
				}
				
					  if(cellType==CellType.STRING) {
						 //System.out.println("entro2");
						try {
							Class<?>returnType=getGetterReturnClass(clazz,fieldName);
							 
							 
							if(returnType.getTypeName() .equals("java.lang.String") || returnType==String.class) {	
								
								String value=cell.getStringCellValue()==null?"":cell.getStringCellValue();	;
								
								Object[] values=new Object[1];
								values[0]=value;
								method.invoke(one, values);
								
								
							}
								
								else if(returnType.getTypeName() .equals("int") || returnType==Integer.class) {	
									//System.out.println("entro");
									try{
										String value=cell.getStringCellValue();
										Object[] values=new Object[1];
										values[0]=value;
										method.invoke(one, values);
									}catch(Exception ex) {
										//System.out.println("2 "+ex.getMessage());
										Double num=cell.getNumericCellValue();
										method.invoke(one, num.intValue());
										
										
									 }
								}else if(returnType.getTypeName() .equals("double") || returnType==Double.class) {
									//System.out.println("entro double");
									try{
										String value=cell.getStringCellValue();
									Object[] values=new Object[1];
									values[0]=value;
									method.invoke(one, values);
									}
									catch(Exception ex) {
									
										//if(!ex.getMessage().equals("null")) {
										
										//System.out.println("3 "+" "+ex.getMessage());
										Double num=cell.getNumericCellValue();
										
										method.invoke(one, num);
										//}
										
									 }
								}else if(returnType.getTypeName() .equals("float") || returnType==Float.class) {
									try{
										//System.out.println("entrof");
									String value=cell.getStringCellValue();
									Object[] values=new Object[1];
									values[0]=value;
									method.invoke(one, values);
																		
									}
									catch(Exception ex) {
										
										//System.out.println("4 "+ex.getMessage());
										Double num=cell.getNumericCellValue();
										method.invoke(one, num.floatValue());
										
									 }
								}else if(returnType.getTypeName() .equals("long") || returnType==Long.class) {
									try{
										String value=cell.getStringCellValue();
										Object[] values=new Object[1];
										values[0]=value;
										method.invoke(one, values);
										}
									catch(Exception ex) {
										
										//System.out.println("5 "+ex.getMessage());
										Double num=cell.getNumericCellValue();
										method.invoke(one, num.longValue());
										
									 }
								}
								
						 }catch(Exception ex) {
							 
							 //System.out.println("6 "+ex.getMessage());
							 String aux= cell.getStringCellValue();
							 //System.out.println(aux);
							 Double num =new Double(aux.valueOf(aux));
							// System.out.println(num);
							 
					           method.invoke(one, num);
							 
						 }
					}
					
			 
			 else if (cellType==CellType.NUMERIC) {
				 //System.out.println("entro3");
					Double num=cell.getNumericCellValue();
					Class<?>returnType=getGetterReturnClass(clazz,fieldName);
					//System.out.println( returnType.getTypeName() + " "+num);
					if(returnType.getTypeName() .equals("int") || returnType==Integer.class) {	
						//System.out.println("entro");
						method.invoke(one, num.intValue());
					}else if(returnType.getTypeName() .equals("double") || returnType==Double.class) {
						//System.out.println("entrod");
						method.invoke(one, num);
					}else if(returnType.getTypeName() .equals("float") || returnType==Float.class) {
						//System.out.println("entrof");
						method.invoke(one, num.floatValue());
					}else if(returnType.getTypeName() .equals("long") || returnType==Long.class) {
						method.invoke(one, num.longValue());
					}else if(returnType==Date.class) {
						Date date= HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
						method.invoke(one, date);
					}
			 }
		
			}
				
			
			}
		
		
		
		return result;
		
	}
	
	private Class<?> getGetterReturnClass(Class<?>clazz,String fieldName){
		String methodName="get"+capitalize(fieldName);
		String methodIsName="is"+capitalize(fieldName);
		Class<?> returnType=null;
		for(Method method:clazz.getMethods()) {
			if(method.getName().equals(methodName) || method.getName().equals(methodIsName)) {
				returnType=method.getReturnType();
				break;
			}
		}
		return returnType;
	}
	
	@SuppressWarnings("unchecked")
	private Method constructMethod(Class clazz,String fieldName) throws SecurityException, NoSuchMethodException{
		Class<?> fieldClass=getGetterReturnClass(clazz, fieldName);
		return clazz.getMethod("set"+capitalize(fieldName), fieldClass);
	}
	
	public <T> void writedata(List<T> data) throws Exception{
		try {
			Sheet sheet=getWorkbook().createSheet(data.get(0).getClass().getName());
			setupFieldsForClass(data.get(0).getClass());
			int rowCount=0;
			int columnCount=0;
			Row row=sheet.createRow(rowCount++);
			for(String fieldName: fieldNames) {
				Cell cel=row.createCell(columnCount++);
				cel.setCellValue(fieldName);
			}
			Class<? extends Object> classz=data.get(0).getClass();
			for(T t:data) {
				row=sheet.createRow(rowCount++);
				columnCount=0;
				for(String fieldName:fieldNames) {
					Cell cel=row.createCell(columnCount);
					Method method=classz.getMethod("get"+capitalize(fieldName));
					Object value=method.invoke(t, (Object[]) null);
					if(value!=null) {
						if(value instanceof String) {
							cel.setCellValue((String) value);
						}else if (value instanceof Long) {
							cel.setCellValue((Long) value);
						}else if(value instanceof Integer) {
							cel.setCellValue((Integer) value);
						}else if (value instanceof Double ) {
							cel.setCellValue((Double) value);
						}else if (value instanceof Date) {
							cel.setCellValue((Date) value);
							CellStyle styleDate=workbook.createCellStyle();
							DataFormat dataFormatDate= workbook.createDataFormat();
							styleDate.setDataFormat(dataFormatDate.getFormat("dd/MM/yyyy"));
							cel.setCellStyle(styleDate);
						}else if(value instanceof Boolean) {
							cel.setCellValue((Boolean) value);
						}
					}
					columnCount++;
				}
			}
			
			for(int i=0; i<fieldNames.size(); i++)
				sheet.autoSizeColumn(i);
			
			FileOutputStream out=new FileOutputStream(new File(workbookName));
			workbook.write(out);
			out.close();
			workbook.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		}
	
	public String capitalize(String string) {
		String capital=string.substring(0, 1).toUpperCase();
		return capital+string.substring(1);
	}
	
	public String getWorkbookName() {
		return workbookName;
	}
	
	public void setWorkbookName(String workbookName) {
		this.workbookName=workbookName;
	}
	public void setWorkbook(Workbook workbook) {
		this.workbook=workbook;
	}
	public Workbook getWorkbook() {
		return workbook;
	}
	
	}

