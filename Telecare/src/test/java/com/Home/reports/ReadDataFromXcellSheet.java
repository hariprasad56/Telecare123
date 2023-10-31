package com.Home.reports;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadDataFromXcellSheet {
	public static void main(String args[]) throws IOException
	{
		//open the file in read mode
		FileInputStream fi=new FileInputStream("C:\\Users\\user\\eclipse-workspace\\Telecare\\src\\test\\java\\com\\Telecare\\testdata\\Logindata.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sheet=wb.getSheet("sheet1");
		XSSFRow row=sheet.getRow(6);
		XSSFCell cell=row.getCell(0);
		DataFormatter data=new DataFormatter();
		String value=data.formatCellValue(cell);
		System.out.println(value);
		wb.close();
		fi.close();	
	}}

