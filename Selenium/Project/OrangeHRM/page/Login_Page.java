package OrangeHRM.com.tmb.page;

import OrangeHRM.com.tmb.Enums.WaitStrategy;
import Orangepractice.reports.ExtentLogger;
import org.openqa.selenium.By;


public final class Login_Page extends BasePage{


    private  final By textboxUsername = By.xpath("//input[@name='username']");
    private final By textboxPassword = By.xpath("//input[@type='password']");
    private final By buttonLogin = By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']/button");


    public  Login_Page enterUserName (String username) {

        sendKeys(textboxUsername,username,WaitStrategy.PRESENCE,"username");
        return this;
    }

    public Login_Page enterPassWord (String password) {
        sendKeys(textboxPassword,password,WaitStrategy.PRESENCE,"password" );
       return this;
    }

    public Home_page clickLogin() {
        click(buttonLogin,WaitStrategy.PRESENCE,"Login Button");
      return new Home_page();
    }

    public String getTitle() {
           return getPageTitle();
    }

// **   public void click(By by){
//**        click(buttonLogin);
//**       }
}
