package Amazon.pages;

/**
 * This class is only used to retrieve the title of the laptop page.
 */

public class AmazonLaptopPage extends BasePage {
    public String getTitle() {
        return getPageTitle();
    }
}