package Amazon.listeners;

import Amazon.utils.ExcelUtils;
import Amazon.constants.FrameworkConstants;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class implements TestNG's IMethodInterceptor to control which test methods are executed.
 * based on configuration from an external Excel sheet(RunManager)
 */
public class MethodInterceptor implements IMethodInterceptor {
    /**
     * This method is invoked by TestNG before executing any test methods.
     * It filters and modified test methods based on value from an Excel sheet.
     *
     * @param methods List of all test methods collected by TestNG
     * @param context TestNG context (not used in this implementation)
     * @return Filtered and modified list of test methods to be executed
     */
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context){

        //Read test configuration from the Excel RunManager sheet
        List<Map<String,String>> list= ExcelUtils.getTestDetails(FrameworkConstants.getRunmangersheet());
        //Store only those test methods which need to be executed
         List<IMethodInstance> result = new ArrayList<>();
         // Iterate through all test methods provided by TestNG
        for (int i = 0; i < methods.size(); i++) {
            //Iterate through each row from Excel RunManager data
            for (int j = 0; j < list.size(); j++) {
                // Check if the method name matches and it is marked as executable ("yes") in Excel
                if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname")) &&
                    list.get(j).get("execute").equalsIgnoreCase("yes")) {
                    // Set the description of the test method from Excel
                        methods.get(i).getMethod().setDescription((list.get(j).get("testdescription")));
                        //Set how many times the test should be invoked
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                        //Set the priority of the test execution
                        methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
                        // Add the configuration method to the final list of methods to run
                        result.add(methods.get(i));
                    }
                }
            }
        // Return the final filtered and configured list of test methods
        return result;
    }
}
