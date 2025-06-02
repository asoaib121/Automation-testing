package OrangeHRM.com.tmb.dataprovider.latest;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//Error not solve 
public class DataProviderExcel {

    @Test(dataProvider="getData")
    public void test2(Map<String, String> map) {
        System.out.println(map.get("username"));
    }

    @DataProvider
    public Object[] getData() throws IOException {

        FileInputStream fs = new FileInputStream("D:\\Selenium\\New folder\\Java_Selenium\\Excel\\TestData.xlsx");


        // FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "\\Excel\\TestData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workbook.getSheet("Sheet");

        int rownum = sheet.getLastRowNum();
        System.out.println(rownum);
        int columnum = sheet.getRow(0).getLastCellNum();

        Object[] data = new Object[rownum];
        Map<String, String> map;

        for(int i = 1; i <= rownum; i++) {  // Changed to <= to include last row
            map = new HashMap<>();
            for(int j = 0; j < columnum; j++) {
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                map.put(key, value);
            }
            data[i-1] = map;  // Moved outside inner loop to prevent overwriting
        }
        workbook.close();  // Important: close the workbook to release resources
        return data;
    }
}