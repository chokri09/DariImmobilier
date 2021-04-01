package tn.dari.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import tn.dari.entities.User;

public class UserExcelExporter {
  private XSSFWorkbook workbook;
  private XSSFSheet sheet;
  
  private List<User> listUsers;
  
  public UserExcelExporter(List<User> listUsers) {
		this.listUsers = listUsers;
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Users");
	}
  
  private void writeHeaderRow(){
	  Row row = sheet.createRow(0);
	  
	  CellStyle style = workbook.createCellStyle();
	  XSSFFont font = workbook.createFont();
	  font.setBold(true);
	  font.setFontHeight(17);
	  style.setFont(font);
	  
	  Cell cell = row.createCell(0);
	  cell.setCellValue("user ID");
	  
	   cell = row.createCell(1);
	  cell.setCellValue("account Non Locked");
	  
	  cell = row.createCell(2);
	  cell.setCellValue("Email");
	  
	   cell = row.createCell(3);
	  cell.setCellValue("First name");
	  
	   cell = row.createCell(4);
	  cell.setCellValue("Last name");
	  
	   cell = row.createCell(5);
	  cell.setCellValue("Is Actif");
	  
	   cell = row.createCell(6);
	  cell.setCellValue("Telephone");
	  
	   cell = row.createCell(7);
	  cell.setCellValue("Username");
  }
  private void writeDataRows(){
	  int rowCount = 1 ;
	  for (User user : listUsers) {
		  Row row = sheet.createRow(rowCount++);
		  
		  Cell cell = row.createCell(0);
		  cell.setCellValue(user.getId());
		  
		  cell = row.createCell(1);
		  cell.setCellValue(user.isAccountNonLocked());
		  
		   cell = row.createCell(2);
		  cell.setCellValue(user.getEmail());
		  
		   cell = row.createCell(3);
		  cell.setCellValue(user.getFirstName());
		  
		   cell = row.createCell(4);
		  cell.setCellValue(user.getLastName());
		  		  
		  cell = row.createCell(5);
		  cell.setCellValue(user.isActif());
		  
		   cell = row.createCell(6);
		  cell.setCellValue(user.getTelephone());
		  
		   cell = row.createCell(7);
		  cell.setCellValue(user.getUsername());
		  
	  }
	  
  }
  
  
public void export(HttpServletResponse response) throws IOException{
	  writeHeaderRow();
	  writeDataRows();
	 ServletOutputStream outputStream = response.getOutputStream();
	 workbook.write(outputStream);
	 //workbook.close();
	 outputStream.close();
	    
  }
}
