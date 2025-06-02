package OrangeHRM.com.tmb.page;

import OrangeHRM.com.tmb.Enums.WaitStrategy;
import OrangeHRM.com.tmb.driver.DriverManager;
import OrangeHRM.com.tmb.factory.ExplicitWaitFactory;
import Orangepractice.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected void click(By by, WaitStrategy waitstrategy,String elementname){

        //we want to make sure user can only choose from list of predefined options
      WebElement element= ExplicitWaitFactory.performExplicitWaitFactory(waitstrategy, by);
      element.click();
        try {
            ExtentLogger.pass(elementname+ "is clicked",true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void sendKeys (By by,String value, WaitStrategy waitstrategy,String elementname)  {

      WebElement element=  ExplicitWaitFactory.performExplicitWaitFactory(waitstrategy, by);
      element.sendKeys(value);
        try {
            ExtentLogger.pass(value + "is entered successfully in"+elementname,true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }

}