package OrangeHRM.com.tmb.Utils;

import OrangeHRM.com.tmb.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataProviderUtils {
    private static List<Map<String,String>> list=new ArrayList<>();

    @DataProvider
    public static Object[] getData(Method m) {
    String testname= m.getName();
    if(list.isEmpty()) {
        list= ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
    }

    List<Map<String,String>>  smallist=new ArrayList<>();

    for(int i=0;i<list.size();i++){
        if(list.get(i).get("testname").equalsIgnoreCase(testname) &&
            list.get(i).get("execute").equalsIgnoreCase("yes")){
               smallist.add(list.get(i));
            }
        }


        list.removeAll(smallist);
        return smallist.toArray();
    }
}
