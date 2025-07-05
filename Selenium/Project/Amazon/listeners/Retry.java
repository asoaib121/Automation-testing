package Amazon.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class implements TestNG's IRetryAnalyzer interface.
 * It is used to automatically retry a failed test method up to a certain limit.
 */
public class Retry implements IRetryAnalyzer {
    // Counter to track how many times the test has been retried
    int counter=0;
    //Maximum number of retry attempts allowed (2 times)
    int limit=2;

    /**
     * This method is called by TestNG when a test fails.
     * It decides whether the test should be retried.
     *
     * @param result The result of the test method that just ran.
     * @return true if the test should be retried, false otherwise
     */
    @Override
    public boolean retry (ITestResult result) {
        // Check if current retry count is less than the retry limit
        if(counter<limit){
            counter++; //Increment retry counter
            return true; //Retry the test
        }
        return false; //Do not retry after is reached
    }

}
