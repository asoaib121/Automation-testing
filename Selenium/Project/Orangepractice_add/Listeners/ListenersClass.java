package Orangepractice.Listeners;

import Orangepractice.reports.ExtentLogger;
import Orangepractice.reports.ExtentReport;
import org.testng.*;

import java.util.Arrays;

public class ListenersClass implements ITestListener, ISuiteListener {

    //Runs before the entire test suite

    @Override
    public void onStart(ISuite suite) {
        try {
            ExtentReport.initReports();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Before Suite in Listener");
    }

    // Runs after the entire test suite
    @Override
    public void onFinish (ISuite suite) {
        try {
            ExtentReport.flushReports();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("after suite in Listener");
    }

    //Before each test method
    @Override
    public void onTestStart(ITestResult result){
        ExtentReport.createTest(result.getMethod().getMethodName());
        System.out.println("before method in listener");
    }

    //After a test passes
    @Override
    public void onTestSuccess(ITestResult result){
        ExtentLogger.pass(result.getMethod().getMethodName() +"is passed");
        System.out.println(" after method in listener: pass");
    }

    //After a test fails
    @Override
    public void onTestFailure(ITestResult result){
        try {
            ExtentLogger.fail(result.getMethod().getMethodName() +"is fail",true);
            ExtentLogger.fail(result.getThrowable().toString());
            ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("after method in listener : fail and I am attaching screenshots here");
    }

    //When a test is skipped
    @Override
    public void onTestSkipped(ITestResult result){
        ExtentLogger.skip(result.getMethod().getMethodName() +"is fail");
        System.out.println("after method in listener: skipped and ignored");
    }

    // For tests with success percentage thresholds
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){

        //for now, we are not using this.
    }

    //Before a group of tests under one <test>
    @Override
    public void onStart(ITestContext context){
    // We are having just one test in our suite.so we don't have any implementation as of now
    }

    @Override
    public void onFinish(ITestContext context) {
        // We are having just one test in our suite.so we don't have any special implementation as of now
    }
}
