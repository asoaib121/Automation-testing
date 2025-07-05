package Amazon.constants;

import Amazon.Enums.ConfigProperties;
import Amazon.utils.PropertyUtils;
import java.nio.file.Paths;
import java.time.Duration;

/**
 * FrameworkConstants class contains all the constants values used through the framework.
 * It provides path to important files like config, excel, drivers and report folders.
 * Also contains constants for sheet names and wait times.
 *
 * Key Features:
 * -Singleton pattern enforced with private constructor
 * -Provides centralized location for all framework constants
 * -Dynamically generates report paths based on configuration
 * -Contain paths for different browser drivers
 * -Manage Excel file paths and sheet names
 *
 * Usage:
 * All constants can be accessed via static getter method.
 * Example: FrameworkConstants.getChromedriverpath()
 */

public final class FrameworkConstants {

    // Private constructor to prevent instantiation
    private FrameworkConstants() {} // Private constructor to prevent instantiation

    //path for Extent Report folder
    private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output/index.html";
    private static String extentReportFilePath="";

    //Excel file path
    public static String EXCELPATH = Paths.get(
            System.getProperty("user.dir"),
            "src","main","java","Amazon","Excel","TestData.xlsx"
    ).toString();


    // Path to configuration properties file
    private static final String CONFIGFILEPATH = Paths.get(
            System.getProperty("user.dir"),
            "src", "main", "java",
            "Amazon","config", "config.properties"
    ).toString();

    //Path to ChromeDriver executable (Windows version)
    private static final String CHROMEDRIVERPATH = Paths.get(
            System.getProperty("user.dir"),
            "src", "main", "java",
            "Amazon", "executable",
            "chromedriver-win64","chromedriver.exe"
    ).toString();

    //Path to GeckoDriver (Firefox) executable (Windows version).
    private static final String FIREFOXDRIVERPATH =Paths.get(
            System.getProperty("user.dir"),
            "src", "main", "java",
            "Amazon", "executable","geckodriver-v0.34.0-win64","geckodriver.exe"
    ).toString();

    //======================
    //Test Data Sheet Names
    //======================
    /**
     * Name of the RunManager sheet in Excel file controlling test execution.
     */
    private static final String RUNMANGERSHEET="RUNMANAGER";
    /**
     * Names of the sheet containing test iteration data.
     */
    private static final String ITERATIONDATASHEET="DATA";

    //=======================
    //Public Accessor Methods
    //=======================
    /**
     *Gets the Path to test data Excel file and
     * return Absolute path th Excel file.
     */
    public static String getExcelpath() {
        return EXCELPATH;
    }

    //Check extentReport file path and return
    public static String getExtentReportFilePath()  {
        if(extentReportFilePath.isEmpty()){
           extentReportFilePath= createReportPath();
        }
        return extentReportFilePath;
    }
    //When ExtentReport is Empty, then create new reportPath.
    private static String createReportPath()  {
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            //Append timestamp for unique report when override is disabled.
            return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
        } else {
            return EXTENTREPORTFOLDERPATH+"/index.html";
        }
    }

    public static String getConfigfilepath() {
        return CONFIGFILEPATH;
    }

    public static String getChromedriverpath() {
        return CHROMEDRIVERPATH;
    }

    //==========================
    // Wait time Configuration
    //==========================
    /**
     * Default explicit wait timeout for WebDriver operations
     */
    private static final Duration EXPLICIT_WAIT = Duration.ofSeconds(15);

    /**
     * Gets the configured explicit wait timeout
     * @return Duration object representing wait timeout.
     */
    public static Duration getExplicitwait() {
            return EXPLICIT_WAIT;
        }

    public static String getRunmangersheet() {
        return RUNMANGERSHEET;
    }

    public static String getIterationdatasheet() {
        return ITERATIONDATASHEET;
    }



    public static String getFirefoxdriverpath () {
        return FIREFOXDRIVERPATH ;
    }
}