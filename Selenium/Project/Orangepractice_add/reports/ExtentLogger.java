package Orangepractice.reports;

import OrangeHRM.com.tmb.Enums.ConfigProperties;
import OrangeHRM.com.tmb.Utils.PropertyUtils;
import OrangeHRM.com.tmb.Utils.ScreenshotUtils;
import OrangeHRM.com.tmb.driver.DriverManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {
   private ExtentLogger() {}

    public static void pass(String message) {
      ExtentManager.getExtentTest().pass(message);
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().pass(message);
    }

    public static void pass(String message,boolean isScreenshotNeeded) throws Exception {
      if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
       ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
      }else {
          pass(message);
      }
   }

    public static void fail(String message,boolean isScreenshotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else {
            fail(message);
        }
    }

    public static void skip(String message,boolean isScreenshotNeeded) throws Exception {
        if(PropertyUtils.get(ConfigProperties.SKIPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else {
            skip(message);
        }
    }

//    public static String getBase64Image() {
//        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
//    }
}