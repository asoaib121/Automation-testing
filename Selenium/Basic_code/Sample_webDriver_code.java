package selenium_java;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample_webDriver_code {
    public static void main(String[] args) {
        // declaration objects
      //  System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //launch Chrome and direct in to the base URL
        driver.get("http.google.com");

        //close singal tab in chrome
       // driver.close();
        //close  all chrome windows
        driver.quit();
    }
}
