package OrangeHRM.com.tmb.constants;

import OrangeHRM.com.tmb.Enums.ConfigProperties;
import OrangeHRM.com.tmb.Utils.PropertyUtils;

import java.nio.file.Paths;
import java.time.Duration;

public final class FrameworkConstants {

    private FrameworkConstants() {} // Private constructor to prevent instantiation

    private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output/index.html";
    private static String extentReportFilePath="";
    public static String EXCELPATH = Paths.get(
            System.getProperty("user.dir"),
            "src", "main", "java",
            "OrangeHRM", "com", "tmb", "Excel", "TestData.xlsx"
    ).toString();


    // Resource paths
    private static final String CONFIGFILEPATH = Paths.get(
            System.getProperty("user.dir"),
            "src", "main", "java",
            "OrangeHRM", "com", "tmb", "config", "config.properties"
    ).toString();

    private static final String CHROMEDRIVERPATH = Paths.get(
            System.getProperty("user.dir"),
            "src", "main", "java",
            "OrangeHRM", "com", "tmb", "executable",
            "chromedriver-win64","chromedriver.exe"
    ).toString();


    private static final String FIREFOXDRIVERPATH =Paths.get(
            System.getProperty("user.dir"),
            "src", "main", "java",
            "OrangeHRM", "com", "tmb", "executable","geckodriver-v0.34.0-win64","geckodriver.exe"
    ).toString();
    private static final String RUNMANGERSHEET="RUNMANAGER";
    private static final String ITERATIONDATASHEET="DATA";


    public static String getExcelpath() {
        return EXCELPATH;
    }

    public static String getExtentReportFilePath() throws Exception {
        if(extentReportFilePath.isEmpty()){
           extentReportFilePath= createReportPath();
        }
        return extentReportFilePath;
    }
    private static String createReportPath() throws Exception {
        if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
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

    // Add this method to get the EXPLICITWAIT value
    private static final Duration EXPLICIT_WAIT = Duration.ofSeconds(10);

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