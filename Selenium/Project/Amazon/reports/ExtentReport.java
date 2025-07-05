package Amazon.reports;

import Amazon.Enums.CategoryType;
import Amazon.constants.FrameworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ExtentReport {
    //Private constructor to prevent instantiation (utility class)
    private ExtentReport() {}

    private static ExtentReports extent; //Singleton instance of ExtentReports
    public static ExtentTest test; //Static reference to the current ExtentTest.

    //Initializes the ExtentReports instance and configures it
    public static void initReports()  {
        if(Objects.isNull(extent)) { //Only initialize if not already initialized

            extent= new ExtentReports(); //Create a new ExtentReports object
            //Creates a reporter that outputs the report to the specified file path
            ExtentSparkReporter spark =new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark); //Attach the SparkReporter to the ExtentReport instance.

            spark.config().setTheme(Theme.STANDARD); //Set the report theme to STANDARD
            spark.config().setDocumentTitle("TMB Report"); //Set the title of the generated HTML document
            spark.config().setReportName("Youtube Training"); //Sets the display name of the report
        }
    }
    //Flushes the report and opens it in the default browser
    public static void flushReports()  {
        if(Objects.nonNull(extent)) {
           extent.flush(); //Write all logs to the report file.
        }
        ExtentManager.unload(); //Clear thread-local date to avoid memory leaks.
        try {
            //Open the generated HTML report file in the system's default browser.
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e); //Rethrow exception if file fails to open
        }
    }
    //Create a new test case entry in the report
    public static void createTest(String testcasename) {
        ExtentManager.setExtentTest(extent.createTest(testcasename)); //Store the test in ExtentManager.
    }
    //Assign multiple authors to the current test.
    public static void addAuthors (String[] authors){
        for(String temp:authors) {
        ExtentManager.getExtentTest().assignAuthor(temp);  //Assign each author
        }
    }
    //Assign categories (smoke , Regression) to the current test.
    public static void addCategories (CategoryType[] categories){
        for(CategoryType temp:categories) {
        ExtentManager.getExtentTest().assignCategory(temp.toString()); //Convert enum to String and assign.
        }
    }
}
