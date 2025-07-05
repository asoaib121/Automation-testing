package Amazon.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    //Private constructor to prevent instance of this utility class.
    private ExtentManager() {
    }
    //ThreadLocal variable to ensure each thread has its own instance of ExtentTest
    private static ThreadLocal<ExtentTest> extTest= new ThreadLocal<> ();
    //Public method to get the ExtentTest instance specific to the current thread.
   public static ExtentTest getExtentTest() {
        return extTest.get();//Return the current thread's ExtentTest
    }
    //package-private method to set the ExtentTest instance for the current thread
    static void setExtentTest(ExtentTest test) {
        extTest.set(test);  //Stores the ExtentTest instance for the current thread
    }
    //Package-private method to remove the ExtentTest instance from Threadlocal (to prevent memory leaks)
    static void unload() {
        extTest.remove();  // Clear the Threadlocal data for the current thread.
    }
}
