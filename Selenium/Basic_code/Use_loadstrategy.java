package selenium_java;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Use_loadstrategy {
    public static void main(String[] args) {
        //declaration object
    //System.setProperty("webdriver.chrome.driver","\"D:\\Software\\Android Studio\\chrome\\ChromeSetup.exe\"");
        ChromeOptions chromeoptions =new ChromeOptions();

        //use loadstratigy function eger and none
        chromeoptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeoptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        WebDriver driver=new ChromeDriver();

        //get and navigate function both are work same
       // driver.get("www.google.com");
        driver.navigate().to("www.google.com");

        driver.quit();


    }
}
