package Amazon.utils;

import Amazon.constants.FrameworkConstants;
import Amazon.exceptions.FrameworkException;
import Amazon.exceptions.InvalidPathForExcelException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {
    //Private constructor to prevent instantiation
    private ExcelUtils(){}

    /**
     * Reads the Excel file from the given sheet name and converts it to a List of Maps.
     * Each map represents a row with column headers as keys.
     *
     * @param sheetname The name of the Excel sheet to read from
     * @return A list of maps containing Excel data.
     */
    public static List<Map<String,String>> getTestDetails(String sheetname){
        List<Map<String,String>> list=null;
        // Formatter to convert any cell value to String (handles numeric, string, date etc.)
        DataFormatter formatter = new DataFormatter();
        // Try-with-resource ensure FileInputStream is automatically closed.
        try (FileInputStream fs= new FileInputStream(FrameworkConstants.getExcelpath())){

            //Create workbook and get the required sheet
            XSSFWorkbook workbook= new XSSFWorkbook(fs);
           // String sheetname ="RUNMANAGER";
            XSSFSheet sheet=workbook.getSheet(sheetname);

            // Get total rows and column (excluding empty trailing rows)
            int lastrownum = sheet.getLastRowNum();
            int  lastcolnum = sheet.getRow(0).getLastCellNum();

            Map<String,String> map=null;
            list=new ArrayList<>();

            //Iterate through each row (including the header)
            for(int i=0;i<=lastrownum;i++){
                map=new HashMap<>();

                //Iterate through each cell in the row
                for(int j=0;j<lastcolnum;j++){
                    // Gets the column name from the header row (0th row)
                    String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));
                    // Gets the actual cell value from the current row
                    String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                    // Put key-value pair in the map
                   map.put(key,value);
                }
                //Add the row data map to the list
                list.add(map);
            }

        } catch (FileNotFoundException e) {
            // Custom exception if file is not found
        throw new InvalidPathForExcelException("Excel File you trying to read is not found");
        }catch (IOException e) {
            // Custom exception for general I\O errors
       throw new FrameworkException("Some io exception happened while reading excel file");
        }
        // Return the full list of row maps
        return list;

    }
}
