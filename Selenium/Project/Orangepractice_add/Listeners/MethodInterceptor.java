package Orangepractice.Listeners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {

    // List of all test methods TestNG plans to execute
   @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
       //List will contain all the test that testng going to execute test1,test2,test3,test4

       //At run time disable few tests.Creates an empty list to store modified test methods.
       List<IMethodInstance> result = new ArrayList<IMethodInstance>();

       Map<String, String> test1 = new HashMap<>();
       test1.put("name", "test1");
       test1.put("count", "5");

       Map<String, String> test2 = new HashMap<>();
       test2.put("name", "test2");
       test2.put("count", "2");

       List<Map<String, String>> list = new ArrayList<>();
       list.add(test1);
       list.add(test2);

       for (int i = 0; i < methods.size(); i++) {
           for (int j = 0; j < list.size(); j++) {
               if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("name"))) {
                   methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                   result.add(methods.get(i));
               }
           }
       }
       return result;
   }

}
