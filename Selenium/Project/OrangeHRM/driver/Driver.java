package OrangeHRM.com.tmb.driver;

import OrangeHRM.com.tmb.Enums.ConfigProperties;
import OrangeHRM.com.tmb.Utils.PropertyUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import OrangeHRM.com.tmb.constants.FrameworkConstants;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public final class Driver {


      public static WebDriver driver;

    public static void initDriver(String browser) throws Exception   {
        if(Objects.isNull(DriverManager.getDriver())) {
            if(browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromedriverpath());
                //  WebDriverManager.chromedriver().setup();

                // Initialize ChromeDriver
                DriverManager.setDriver(new ChromeDriver());


                // Configure browser
                //DriverManager.getDriver().manage().window().maximize();
            }else if(browser.equalsIgnoreCase("firefox")){
                System.setProperty("Webdriver.firefox.driver",FrameworkConstants.getFirefoxdriverpath());
                DriverManager.setDriver(new FirefoxDriver());
            }
            // DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
          DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
        }
    }

    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}