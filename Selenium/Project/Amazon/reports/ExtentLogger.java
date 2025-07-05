package Amazon.reports;

import Amazon.Enums.ConfigProperties;
import Amazon.utils.PropertyUtils;
import Amazon.utils.ScreenshotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger {
   private ExtentLogger() {}

    public static void pass(String message) {
      ExtentManager.getExtentTest().pass(message); //Logs pass message without screenshot
    }

    public static void fail(String message) {
        ExtentManager.getExtentTest().fail(message); //Logs fail message without screenshot
    }

    public static void skip(String message) {
        ExtentManager.getExtentTest().skip(message); //Logs skip message without screenshot
    }

    public static void pass(String message,boolean isScreenshotNeeded)  {
       // Check if screenshot is enabled in config AND screenshot is requested.
      if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
          //Logs pass message with screenshot attached.
       ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
      }else {
          pass(message); //Calls simple pass log if screenshot not needed.
      }
   }

    public static void fail(String message,boolean isScreenshotNeeded)  {
       // Check config and flag to decide weather to attach screenshot.
        if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            //Logs fail message with screenshot.
            ExtentManager.getExtentTest().fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else {
            fail(message); //Logs without screenshot.
        }
    }

    public static void skip(String message,boolean isScreenshotNeeded)  {
       // Check if skip screenshot is enabled and needed.
        if(PropertyUtils.get(ConfigProperties.SKIPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded) {
            // Logs skipped step with screenshot.
            ExtentManager.getExtentTest().skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
        }else {
            skip(message); //Logs without screenshot.
        }
    }
}