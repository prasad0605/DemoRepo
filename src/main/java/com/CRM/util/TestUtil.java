package com.CRM.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.CRM.base.basetest;

public class TestUtil extends basetest{
	
	public void SwitchtoFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	public static Object[][] getExceldata(String sheetname){
		Object [][] data = null;
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("/FreeCRMTest/src/main/java/com/CRM/testdata/FreeCRM.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet ws=wb.getSheet(sheetname);
			int rowcount=ws.getLastRowNum();
			int colcount=ws.getRow(0).getLastCellNum();
			data=new Object[rowcount][colcount];
			for(int i=0;i<rowcount;i++){
				for(int j=0;j<colcount;j++){
					data[i][j]=ws.getRow(i+1).getCell(j).toString();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
	}

}
