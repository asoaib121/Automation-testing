package OrangeHRM.com.tmb.test;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.Test;
import org.assertj.core.api.Assertions;

import java.util.Map;

public final class OrangeHrmTest extends BaseTest{


    private OrangeHrmTest() { }

     @Test
    public void loginLogoutTest(Map<String,String> data){

        //ExtentReport.createTest("loginLogoutTest");
        String title=new LoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password"))
                .clickLogin()
                .clickWelcome().clicks()
                .clickLogout()
                .getTitle();

        Assertions.assertThat(title)
                .isEqualTo ("OrangeHRM");
    }

    @Test
    public void newTest(Map<String,String> data){

        String title=new LoginPage()
                .enterUserName(data.get("username")).enterPassword(data.get("password"))
                .clickLogin()
                .clickWelcome().clicks()
                .clickLogout()
                .getTitle();

        Assertions.assertThat(title)
                .isEqualTo ("OrangeHRM");
    }



//    @DataProvider(name="LoginTestDataProvider",parallel=true)
//    public Object[][] getData() {
//        return new Object[][] {
//                {"Admin","admin123"},
//                {"Admin123","admin123"}
////                {"Admin","admin123"},
////                {"Admin123","admin1234"}
//        };
 //   }
}
