package OrangeHRM.com.tmb.test;

import OrangeHRM.com.tmb.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Map;


public class BaseTest {

    protected BaseTest() {

    }
//    @BeforeSuite
//    public  void beforeSuite() {
//
//    }
//
//    @AfterSuite
//    public void afterSuite() throws IOException {
////        ExtentReport.flushReports();
//    }

    @SuppressWarnings("unchecked")
    @BeforeMethod
    protected void setup(Object[] data) throws Exception {
        Map<String,String> map=(Map<String,String>)data[0];
       Driver.initDriver(map.get("browser"));
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
