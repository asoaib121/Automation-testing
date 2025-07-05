package Amazon.pages;

import Amazon.Enums.WaitStrategy;
import Amazon.driver.DriverManager;
import Amazon.factory.ExplicitWaitFactory;
import Amazon.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

/**
 * BasePage is a reusable superclass that provides common Selenium actions
 * like click, sendKeys, and getting the page title. Other Page classes extends this.
 */
public class BasePage {
    /**
     * Clicks on a web element using Actions class for better stability.
     * Wait explicitly based on the given wait strategy.
     *
     * @param by The locator for the element
     * @param waitstrategy The wait strategy to apply (presence, clickable)
     * @param elementname The name of the element (used for logging)
     */

    protected void click(By by, WaitStrategy waitstrategy,String elementname){

        //Perform explicit wait to locate the element reliably
        WebElement element= ExplicitWaitFactory.performExplicitWaitFactory(waitstrategy, by);

        //Use Actions class to click (instead of direct .click()) for better stability
        new Actions(DriverManager.getDriver())
                .moveToElement(element)
                .pause(Duration.ofMillis(300))
                .click(element)
                .pause(Duration.ofMillis(300))
                .perform();

        //Log the click action in the report with screenshot
        try {
            ExtentLogger.pass(elementname+ "is clicked",true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Sends text to a web element after applying the wait strategy.
     *
     * @param by The locator for the element
     * @param value The text to input
     * @param waitstrategy The wait strategy to apply
     * @param elementname The name of the element (used for logging)
     */
    protected void sendKeys (By by,String value, WaitStrategy waitstrategy,String elementname)  {
        //Perform explicit wait to locate the element
        WebElement element=  ExplicitWaitFactory.performExplicitWaitFactory(waitstrategy, by);
        // Send the input text to the element
        element.sendKeys(value);
        //Log the sendKeys actions in the report with screenshot
        try {
            ExtentLogger.pass(value + "is entered successfully in" +elementname,true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Return the current page title
     *
     * @return The title of the page as a String
     */
    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

}
