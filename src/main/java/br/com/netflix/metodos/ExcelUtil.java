package br.com.netflix.metodos;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
//	classe do excel onde estamos fazendo uma conexao com o excel, simulando uma model, é necessário passar o caminho que é uma constante.
	private static XSSFSheet excelWSheet;

	private static XSSFWorkbook excelWBook;

	private static XSSFCell cell;

	private static XSSFRow row;
	
	public static final String CAMINHO = "";
	
	public static void setExcelFile(String path, String sheetName) throws Exception {

		try {

			FileInputStream excelFile = new FileInputStream(path);

			excelWBook = new XSSFWorkbook(excelFile);

			excelWSheet = excelWBook.getSheet(sheetName);

		} catch (Exception e) {

			throw (e);

		}

	}

	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			cell = excelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}

	}

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

		try {

			row = excelWSheet.getRow(RowNum);

			cell = row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (cell == null) {

				cell = row.createCell(ColNum);

				cell.setCellValue(Result);

			} else {

				cell.setCellValue(Result);

			}

			FileOutputStream fileOut = new FileOutputStream(CAMINHO + "TestData.xlsx");

			excelWBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		} catch (Exception e) {

			throw (e);

		}

	}

}