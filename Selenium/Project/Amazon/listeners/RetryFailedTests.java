package Amazon.listeners;

import Amazon.Enums.ConfigProperties;
import Amazon.utils.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is used to retry failed tests.
 * It implements the IRetryAnalyzer interface from TestNG.
 */
public class RetryFailedTests implements IRetryAnalyzer {
    //Tracks the current retry count for a tests
    private int count=0;
    //Maximum number of retries allowed (default is 1)
    private int retries=1;

    /**
     * This method is invoked by TestNG whenever a test fails.
     * It will determine whether the test should be retries or not.
     *
     * @param result The result of the test method that just ran.
     * @return true if the test needs to be retries, false otherwise
     */
    @Override
    public boolean retry (ITestResult result) {
        boolean value =false;
            //Check if retries are enabled in the config file
            if(PropertyUtils.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
                //If retry count is within the limit, set value to true
             value = count<retries ;
             //Increment the retry counter
                count++;
            }
            //Return whether the test should be retries
            return value;
    }
}
