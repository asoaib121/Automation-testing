package Amazon.pages;

import Amazon.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This class handles Amazons homepage interactions.
 * It clicks the hamburger and redirect to  AmazonHamburgerMenuPage.
 */
public final class AmazonHomePage  extends BasePage {
    //This Xpath load by linkHamburger
    @FindBy(xpath = "//div[@class='nav-left']/a")
    //Private keyword use because, Follow the Encapsulation rules
    private WebElement linkHamburger;

    /**
     * It sets up the page object model (POM) by linking the WebDriver to the elements in this class,
     * allowing Selenium to interact with them
     */
    public AmazonHomePage() {
        PageFactory.initElements(DriverManager.getDriver(),this);
    }

    public AmazonHamburgerMenuPage clickHamburger() {
        linkHamburger.click();
        return new AmazonHamburgerMenuPage();
    }
}
