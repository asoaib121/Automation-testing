package Amazon.driver;

import Amazon.Enums.ConfigProperties;
import Amazon.utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Objects;

/**
 * Driver class is responsible for invoking and closing the browser.
 *
 * <p>
 * It is also responsible for
 * setting the driver variable to DriverManager which handles the thread safety for the
 * webdriver instance.<p>
 *
 * <pre>Checking Whether it is formatted correctly </pre>
 *
 * Jan 20, 2021 <p>
 * @author Amuthan Sakthivel
 * @version 1.0
 * @since 1.0
 * @see DriverManager
 * @see Amazon.tests.BaseTest
 */

public final class Driver {

    /**
     * Private constructor to avoid external instantiation
     */
     private Driver() {}

    /**
     * Gets the browser value and initialise the browser based on that
     *
     * @author Amuthan Sakthivel
     * Jan 20,2021
     * @param browser Value will be passed from{@link Amazon.tests.BaseTest}. Values can be chrome and firefox
     * TODO WebDriverManager implementation
     */

    public static void initDriver(String browser)   {
        //Check create driver or not
        //When driver is null, then setup Browser.
        if(Objects.isNull(DriverManager.getDriver())) {
            if(browser.equalsIgnoreCase("chrome")) {
                //Use WebDriver Manager and automatically chrome driver setup adn download.
                  WebDriverManager.chromedriver().setup();

                // Create new ChromeDriver object and sets it to DriverManager
                DriverManager.setDriver(new ChromeDriver());

            }
            //interface open dual browser
            else if(browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
            }
            // DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
          DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    //These methods work stop browser and cleanup driver
    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}