package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataReader {

    static XSSFSheet sheet;
    static XSSFWorkbook workbook;

    public ExcelDataReader(String excelPath, String sheetName) {
        try {
            workbook = new XSSFWorkbook(excelPath);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }
        public static void getCellValue(int rowNum, int cellnum){
                DataFormatter formatter = new DataFormatter();
                Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(cellnum));
                System.out.println(value);
        }

        public static void getRowCount() {
                int rowCount = sheet.getPhysicalNumberOfRows();
                System.out.println("no. of rows : " + rowCount);

        }
    }

