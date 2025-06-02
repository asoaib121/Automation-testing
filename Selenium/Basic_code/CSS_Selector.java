package selenium_java;

//import com.sun.tools.javac.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.List;

public class CSS_Selector {

    public static void main(String[] args) {
        //declaration object
       // System.setProperty("webdriver.chrome.driver","\"D:\\Software\\Android Studio\\chrome\\ChromeSetup.exe\"");
        ChromeOptions chromeoptions =new ChromeOptions();

        //use loadstratigy function eger and none
        chromeoptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeoptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeoptions.setImplicitWaitTimeout(Duration.ofSeconds(30));
        WebDriver driver=new ChromeDriver(chromeoptions);

        //get and navigate function both are work same
        // driver.get("www.google.com");
        driver.get("https://www.daraz.com.bd");
        driver.manage().window().maximize();



        WebElement searchBox=driver.findElement(By.cssSelector("input#q"));
        searchBox.sendKeys("camera");
        WebElement searchButton= driver.findElement(By.cssSelector("a.search-box__button--1oH7"));
        searchButton.click();

       //brief it
        List<WebElement> serviceList =driver.findElements(By.cssSelector("div.Ms6aG div.qmXQo div.ICdUp div._95X4G a"));
       System.out.println("The size of service list is="+serviceList.size());

       if(!serviceList.isEmpty()) {
           serviceList.get(6).click();
       }

        driver.quit();


    }
}
