package com.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.examples.xssf.usermodel.CreateCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//codes here only to handle excel
public class Excellibrary {
	String filepath="C:\\Users\\LOKESH\\OneDrive\\Desktop\\Book3.xlsx";
//these are reusuable methods..if v want v can use this method
	public String ReadExceldata(String sheetname, int rownum, int colnum)throws EncryptedDocumentException, IOException { // to read data from excel
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis); // locate the workbook
		Sheet sh = wb.getSheet(sheetname); // locate the sheet
		Row rw = sh.getRow(rownum);
		String data = rw.getCell(colnum).getStringCellValue();
		return data;
	}

	public int getnumberofcount(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis); // locate the workbook
		Sheet sh = wb.getSheet(sheetname); // locate the sheet
		int rowcount = sh.getLastRowNum();
		return rowcount;

	}
public void writedetailinexcel(String sheetname,int rownum,int colnum,String data) throws EncryptedDocumentException, IOException {
FileInputStream fis = new FileInputStream(filepath);
Workbook wb = WorkbookFactory.create(fis); // locate the workbook
Sheet sh = wb.getSheet(sheetname); // locate the sheet
Row rw = sh.getRow(rownum);
Cell cell=rw.createCell(colnum);
cell.setCellType(CellType.STRING);
FileOutputStream fos=new FileOutputStream(filepath);
cell.setCellValue(data);
wb.write(fos);
wb.close();


}

public int ReadNumericExceldata(String sheetname,int rownum,int colnum) throws EncryptedDocumentException, IOException {
	FileInputStream fis = new FileInputStream(filepath);
	Workbook wb = WorkbookFactory.create(fis); // locate the workbook
	Sheet sh = wb.getSheet(sheetname); // locate the sheet
	Row rw = sh.getRow(rownum);
	Integer data=(int)rw.getCell(colnum).getNumericCellValue();

	return data;
}
}