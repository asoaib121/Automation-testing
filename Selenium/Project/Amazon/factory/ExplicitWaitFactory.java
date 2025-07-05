package Amazon.factory;

import Amazon.Enums.WaitStrategy;
import Amazon.constants.FrameworkConstants;
import Amazon.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Factory class responsible for applying different types of explicit waits
 * before interacting with WebElements in the test automation framework.
 * This class helps improve reliability by waiting for conditions like
 * visibility, clickability, etc.
 */
public final class ExplicitWaitFactory {
    //Private constructor to prevent instantiation of utility class
    private ExplicitWaitFactory() {}

    /**
     * Applies an explicit wait based on the provided wait strategy
     * and returns the located WebElement once the condition is met.
     *
     * @param waitstrategy The waiting condition to apply like "CLICKABLE, VISIBLE"
     * @param by The locator used to find the WebElement
     * @return The WebElement after applying the wait
     */
    public static WebElement performExplicitWaitFactory(WaitStrategy waitstrategy, By by) {
        WebElement element=null;
        //Waits until the element is clickable
       if(waitstrategy==WaitStrategy.CLICKABLE){
          element = new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                   .until(ExpectedConditions.elementToBeClickable(by));

          //Waits until the element is present in the DOM
       }else if(waitstrategy==WaitStrategy.PRESENCE){
           element =new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                   .until(ExpectedConditions.presenceOfElementLocated(by));

           //Waits until the element is visible to the user
       }else  if(waitstrategy==WaitStrategy.VISIBLE){
          element= new WebDriverWait(DriverManager.getDriver(), FrameworkConstants.getExplicitwait())
                   .until(ExpectedConditions.visibilityOfElementLocated(by));

          //No explicit wait applied; finds the element directly
       }else  if(waitstrategy==WaitStrategy.NONE){
           element = DriverManager.getDriver().findElement(by);
       }
       //Return the located WebElement after applying the wait
       return element;
    }
}
