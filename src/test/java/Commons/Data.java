package Commons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {
	public String DataExcel(String filename, String sheetname, int irow, int icol) {
		//load file
		File fi = new File(filename);
		FileInputStream fis;
		String Output_data="";
		try {
			fis = new FileInputStream(fi);
			Workbook wb = new XSSFWorkbook(fis);
			
			Sheet sh = wb.getSheet(sheetname);
			
			Row rw = sh.getRow(irow);
			if(rw!=null) {
				Cell cell = rw.getCell(icol);
				if(cell!=null) {
					Output_data = cell.getStringCellValue();
				}
				
			}
			
			
			
			wb.close();
			fis.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return Output_data;
	}

}
