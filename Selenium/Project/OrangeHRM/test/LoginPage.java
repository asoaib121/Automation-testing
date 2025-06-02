package OrangeHRM.com.tmb.test;

import OrangeHRM.com.tmb.driver.DriverManager;
import OrangeHRM.com.tmb.page.Home_page;
import OrangeHRM.com.tmb.page.Login_Page;

public class LoginPage {

    public LoginPage enterUserName(String username) {
        new Login_Page().enterUserName(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        new Login_Page().enterPassWord(password);
        return this;
    }

    public Home_page clickLogin() {

        return new Login_Page().clickLogin();
    }
    public String getTitle() {
        return DriverManager.getDriver().getTitle(); // Return the page title
    }
}