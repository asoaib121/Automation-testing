package selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_Google {

    public static void main(String[] args) {
        //Initialize the webDriver
        WebDriver driver = new ChromeDriver();

        //Navigate to google
        driver.get("https://google.com");
        //Find the search box element and Enter the search query
        driver.findElement(By.name("q")).sendKeys("Testing mini bytes", Keys.ENTER);
       // driver.quit();
    }
}
