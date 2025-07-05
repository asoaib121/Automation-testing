package Amazon.pages;

import Amazon.driver.DriverManager;
import Amazon.utils.DynamicXpathUtils;
import Amazon.Enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * This class models the behavior and elements of the Hamburger Menu on Amazon.
 * It extends BasePage to reuse common Selenium interaction methods.
 */
public final class AmazonHamburgerMenuPage extends BasePage {

    //XPath for the "Mobiles, Computer" main category
    private String linkComputer ="//div[text()='Mobiles, Computers']/parent::a";
    //XPath template for dynamic sub-menu item like Tablet,Laptops.
    private String linkSubMenu="//a[text()='%s']";
    //Timeout duration for waiting on elements
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);

    /**
     * Clicks on the "Mobiles and Computer" category in the hamburger menu.
     *
     * @return current instance of AmazonHamburgerMenuPage for method chaining
     */
    public AmazonHamburgerMenuPage clickComputer() {
        click(By.xpath(linkComputer),WaitStrategy.CLICKABLE,"Mobiles and Computer");
        return this;
    }

    /**
     * clicks on a given sub-menu item under the "Mobiles and Computer" category.
     * Handles dynamic xpath generations, scrolling into view, waiting, and clicking.
     *
     * @param menutext The visible text of the submenu item to click like "Tablets"
     * @return AmazonLaptopPage if submenu is "Tablets", otherwise null
     */
    public AmazonLaptopPage clickOnSubMenuItem(String menutext){
        // Generate dynamic XPath by replacing %s with actual menu text
        String newxpath= DynamicXpathUtils.getXpath(linkSubMenu,menutext);


        //Find the submenu element using dynamic XPath
        WebElement element = DriverManager.getDriver().findElement(By.xpath(newxpath));
        //Scroll to the element and hover over it to ensure it's visible/clickable
        new Actions(DriverManager.getDriver())
                .moveToElement(element)
                .pause(Duration.ofSeconds(2))
                .perform();

        //Wait until the element is clickable before interacting
        new WebDriverWait(DriverManager.getDriver(), WAIT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));

        //Perform the click using the BasePage's reusable click method
        click(By.xpath(newxpath), WaitStrategy.CLICKABLE,menutext);
        //Return the next page object based on the selected submenu item
        if(menutext.equalsIgnoreCase("Tablets")){
            return new AmazonLaptopPage();
        }
        return null; // For other submenus, nothing is returned (can be extended later)
    }

}
