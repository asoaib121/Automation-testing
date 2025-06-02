package selenium_java;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class Xpath {
    public static void main(String[] args) {
        ChromeOptions chromeoptions =new ChromeOptions();

        chromeoptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeoptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeoptions.setImplicitWaitTimeout(Duration.ofSeconds(30));
        WebDriver driver=new ChromeDriver(chromeoptions);

        driver.get("https://accounts.lambdatest.com/login");
        driver.manage().window().maximize();
       // driver.findElement(By.xpath("//a[text()='Login']")).click();
        // //a[text()='Sign up']
        driver.findElement(By.xpath("//a[@href='/register']")).click();
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Shoaib@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("kajw1234@#");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement orgsize= driver.findElement(By.xpath(""));
        //left click
        orgsize.click();

        /*  right click 
        Actions performAction = new Actions(driver);
        performAction.contextClick(orgsize).build().perform();
        performAction.doubleClick(orgsize).build().perform();  */

        driver.quit();
    }
}
