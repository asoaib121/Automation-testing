package Amazon.utils;

import Amazon.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {
    //Static list to store all data from the Excel sheet
    private static List<Map<String,String>> list=new ArrayList<>();

    //DataProvider method to supply data to test methods
    @DataProvider
    public static Object[] getData(Method m) {
        //Get the name of the test method currently being executed
    String testname= m.getName();
    //If the list is empty, read data from Excel only once
    if(list.isEmpty()) {
        list= ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
    }
   //Create a new list to store data specified to the current test method
    List<Map<String,String>>  smallist=new ArrayList<>();

    //Loop through the master list and filter data based on method name and execute flag
    for(int i=0;i<list.size();i++){
        if(list.get(i).get("testname").equalsIgnoreCase(testname) &&
            list.get(i).get("execute").equalsIgnoreCase("yes")){
            // Add matching data to the filtered list
               smallist.add(list.get(i));
            }
        }
        //Remove the filtered data from the master list to avoid reusing it for others tests
        list.removeAll(smallist);
        // Convert the list to an array and return it as required by TestNG DataProvider
        return smallist.toArray();
    }
}
