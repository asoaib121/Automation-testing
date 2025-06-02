package OrangeHRM.com.tmb.page;

import OrangeHRM.com.tmb.Enums.WaitStrategy;
import OrangeHRM.com.tmb.test.LoginPage;
import Orangepractice.reports.ExtentLogger;
import org.openqa.selenium.By;


public final class Home_page  extends BasePage{
    private final By linkWelcome= By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-buzz-widget-body']");
    private final By dashboard = By.xpath("//span[@class='oxd-userdropdown-tab']");
    private final By linkLogout =By.xpath("//div[@class='oxd-topbar-header-userarea']/ul//a[text()='Logout']");


    public Home_page clickWelcome() {
        click(linkWelcome, WaitStrategy.PRESENCE,"welcome");
        return this;
    }

    public Home_page clicks() {
        click(dashboard, WaitStrategy.CLICKABLE,"clicks before logout");
        ExtentLogger.pass("clicked");
        return this;

    }

    public LoginPage clickLogout() {
        click(linkLogout,WaitStrategy.CLICKABLE,"Logout Button");
        ExtentLogger.pass("logout clicked");
        return new LoginPage();
    }

// **   public String getTitle() {
// **       WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), TIMEOUT);
// **       wait.until(ExpectedConditions.titleIs("OrangeHRM"));
// **       return DriverManager.getDriver().getTitle();
// **  }
    //**wait.untill(d->d.findElement(link_logout).isEnabled()); //Java 8 way

}
