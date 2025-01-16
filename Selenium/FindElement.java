package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //String baseurl=;
        String tagname="";

        driver.get("http://facebook.com");
        tagname=driver.findElement(By.id("Email")).getTagName();
        System.out.println(tagname);
        driver.close();
        System.exit(0);
    }
}
