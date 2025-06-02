package selenium_java;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Method1 {
    public static void main(String[] args) {
        ChromeOptions chromeoptions =new ChromeOptions();

        chromeoptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
        chromeoptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        chromeoptions.setImplicitWaitTimeout(Duration.ofSeconds(30));
        WebDriver driver=new ChromeDriver(chromeoptions);

        driver.get("https://lambdatest.com");
        driver.manage().window().maximize();

        //driver.findElement(By.xpath("//a[@href='/register']")).click();
       // driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Shoaib@gmail.com");
       // driver.findElement(By.xpath("//input[@name='password']")).sendKeys("kajw1234@#");
       // driver.findElement(By.xpath("//button[@type='submit']")).click();


//        Rectangle freesignupButtonreact= driver.findElement(By.xpath("//button[text()='SIGN UP']")).getRect();
//        System.out.println(freesignupButtonreact.getHeight());
//        System.out.println(freesignupButtonreact.getWidth());
//        System.out.println(freesignupButtonreact.getX());
//        System.out.println(freesignupButtonreact.getY());
//
//        String signUptext = driver.findElement(By.xpath("//button[text()='SIGN UP']")).getText();
//        System.out.println(signUptext);
//
//        String signUpClassAttribute = driver.findElement(By.xpath("//button[text()='SIGN UP']")).getText();
//        System.out.println( signUpClassAttribute);

        WebElement LogoPath= driver.findElement(By.xpath("//a [@target='_blank']/img[@alt='LambdaTest']"));
        Boolean isLogoDisplayed =LogoPath.isDisplayed();
        System.out.println("logo Displayed:"+isLogoDisplayed);

        Boolean isLogoEnable = LogoPath.isEnabled();
        System.out.println("logo Displayed:"+isLogoEnable);

       // WebElement isAgreecheckbox= driver.findElement(By.xpath());
        //isAgreecheckbox.click();
       // Boolean isAgreeCheckBosSelected= isAgreecheckbox.isSelected()
        driver.quit();
    }
}
