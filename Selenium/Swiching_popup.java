package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Swiching_popup {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String  AlertMessage="";

        driver.get("http://jsbin.com/usidix/1");
        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
        AlertMessage =driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        System.out.println(AlertMessage);
        driver.quit();
    }
}
