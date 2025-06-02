package Orangepractice.reports;

import OrangeHRM.com.tmb.constants.FrameworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.awt.*;
import java.io.File;
import java.util.Objects;

public class ExtentReport {
    private ExtentReport() {}

    private static ExtentReports extent;
    public static ExtentTest test;

    //client or vendor A
    public static void initReports() throws Exception {
        if(Objects.isNull(extent)) {

            extent= new ExtentReports();
            ExtentSparkReporter spark =new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("TMB Report");
            spark.config().setReportName("Youtube Training");
        }
    }

    public static void flushReports() throws Exception {
        if(Objects.nonNull(extent)) {
            extent.flush();
        }
        ExtentManager.unload();
        Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
    }

    public static void createTest(String testcasename) {
      ExtentManager.setExtentTest(extent.createTest(testcasename));
    }
}
