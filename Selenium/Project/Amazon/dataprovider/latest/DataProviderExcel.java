package Amazon.dataprovider.latest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//Main class for reading Excel data using Apache POI and providing it to TestNG tests.
public class DataProviderExcel {

    @Test(dataProvider="getData")  //This test method uses data from the getData() method
    public void test2(Map<String, String> map) {
        System.out.println(map.get("username")); //Prints the "username" value from the current row
    }

    @DataProvider //This method provides data to the test method above
    public Object[] getData() throws IOException {
        //Loads the Excel file from the specified path
        FileInputStream fs = new FileInputStream("D:\\Selenium\\Project\\Amazon\\src\\main\\java\\Amazon\\Excel\\TestData.xlsx");
        //Open the workbook and loaded
        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        //Accesses the sheet named
        XSSFSheet sheet = workbook.getSheet("Sheet");

        //Gets the last row index (number of rows - 1)
        int rownum = sheet.getLastRowNum();
        System.out.println(rownum);
        //Gets the number of columns from the header row (row 0)
        int columnum = sheet.getRow(0).getLastCellNum();

        // Create an Object array to hold each rows data as a map
        Object[] data = new Object[rownum];
        Map<String, String> map; //Declares a map for holding key-values pair of each row

        //Loops through each row starting from 1 (skipping the header row at index 0)
        for(int i = 1; i <= rownum; i++) {
            map = new HashMap<>(); //Creates a new map for each row.
            //Loops through each column in the current row
            for(int j = 0; j < columnum; j++) {
                //Gets the header name from row 0 to use as key
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                //Gets the value from the current row for the current column
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value); //Adds the key-value pair to the map
            }
            data[i-1] = map;  // Adds the map to the data array (i-1 because data array is 0-based)
        }
        workbook.close();  // Important: close the workbook to release memory
        return data; //Return the array of maps to be used in the test.
    }
}