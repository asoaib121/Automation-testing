package OrangeHRM.com.tmb.Utils;

import OrangeHRM.com.tmb.constants.FrameworkConstants;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {
    private ExcelUtils(){}

    //try with resource

    public static List<Map<String,String>> getTestDetails(String sheetname){
        List<Map<String,String>> list=null;

        FileInputStream fs=null;

        DataFormatter formatter = new DataFormatter(); // Handles all cell types

        try {

            fs = new FileInputStream(FrameworkConstants.getExcelpath());
            XSSFWorkbook workbook= new XSSFWorkbook(fs);
           // String sheetname ="RUNMANAGER";
            XSSFSheet sheet=workbook.getSheet(sheetname);

            int lastrownum = sheet.getLastRowNum();
            int  lastcolnum = sheet.getRow(0).getLastCellNum();

            Map<String,String> map=null;
            list=new ArrayList<>();



            for(int i=0;i<=lastrownum;i++){
                map=new HashMap<>();
                for(int j=0;j<lastcolnum;j++){

                    String key = formatter.formatCellValue(sheet.getRow(0).getCell(j)); // Handles any cell type
                    String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
                  // String key=sheet.getRow(0).getCell(j).getStringCellValue();
                   //String value=sheet.getRow(i).getCell(j).getStringCellValue();
                   map.put(key,value);
                }
                list.add(map);
            }

        } catch (FileNotFoundException e1) {
        e1.printStackTrace();
        }catch (IOException e) {
        e.printStackTrace();
        }finally {
            try {
                if(Objects.nonNull(fs)){
                     fs.close();
                }
            } catch (IOException e) {
        e.printStackTrace();
            }
        }
        return list;

    }
}