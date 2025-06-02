package OrangeHRM.com.tmb.Listeners;

import OrangeHRM.com.tmb.Enums.ConfigProperties;
import OrangeHRM.com.tmb.Utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

    private int count=0;
    private int retries=1;

    @Override
    public boolean retry (ITestResult result) {
        boolean value =false;
        try {
            if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
             value = count<retries ;
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
}
