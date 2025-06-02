package OrangeHRM.com.tmb.factory;

import OrangeHRM.com.tmb.Enums.WaitStrategy;
import OrangeHRM.com.tmb.constants.FrameworkConstants;
import OrangeHRM.com.tmb.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitFactory {


    public static WebElement performExplicitWaitFactory(WaitStrategy waitstrategy, By by) {
        WebElement element=null;
       if(waitstrategy==WaitStrategy.CLICKABLE){
          element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                   .until(ExpectedConditions.elementToBeClickable(by));
       }else if(waitstrategy==WaitStrategy.PRESENCE){
           element =new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                   .until(ExpectedConditions.presenceOfElementLocated(by));
       }else  if(waitstrategy==WaitStrategy.VISIBLE){
          element= new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                   .until(ExpectedConditions.visibilityOfElementLocated(by));
       }else  if(waitstrategy==WaitStrategy.NONE){
           element = DriverManager.getDriver().findElement(by);
       }
       return element;
    }
}
