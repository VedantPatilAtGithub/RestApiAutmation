package utils;

public class ExcelTests {
    public static void main(String args []){
        ExcelDataReader excelDataReader = new ExcelDataReader("./ExcelData/TestData.xlsx","sheet1");
        excelDataReader.getRowCount();
        excelDataReader.getCellValue(1,0);
        excelDataReader.getCellValue(1,1);
        excelDataReader.getCellValue(1,2);
        excelDataReader.getCellValue(1,3);
    }
}
