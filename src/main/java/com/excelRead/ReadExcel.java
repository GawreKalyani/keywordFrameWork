package com.excelRead;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	
	public FileInputStream fis=null;
	public XSSFSheet sheet=null;
	public XSSFWorkbook wb=null;
	
	public Sheet getSheet(String fileName, String sheetName) throws Exception {
		fis= new FileInputStream(fileName);
		wb= new XSSFWorkbook(fis);
		
		return wb.getSheet(sheetName);
		
	}
	
	
}
