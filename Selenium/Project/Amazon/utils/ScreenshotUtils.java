package Amazon.utils;

import Amazon.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Utility class for capturing screenshots in Base64 format.
 * Designed to be used for embedding screenshots in reports (ExtentReport)
 */
public final class ScreenshotUtils {
    // Private constructor to prevent instantiation (utility class pattern)
    private  ScreenshotUtils() {}

    /**
     * Captures the current browser screenshot and returns it as a Base64 string.
     * This format is useful for embedding directly into HTML reports.
     *
     * @return Base64 encode screenshot string
     */
    public static String getBase64Image() {
        //Get the current WebDriver instance and cast it to TakeScreenshot
        //Then capture the screenshot in Base64 format.
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
