//package Amazon.webdrivermanager;
//
//import org.apache.commons.lang3.SystemUtils;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class WebDriverManagerTest {
//
//    public static void main(String[] args) {
//
//        String osname = System.getProperty("os.name");
//        System.out.println(osname);
//
//        if(SystemUtils.IS_OS_WINDOWS) {
//            System.setProperty("webdriver.chrome.driver",
//                    System.getProperty("user.dir") + "src/main/java/Amazon/executable/chromedriver-win64/chromedriver.exe");
//        }else if(osname.contains("Mac")) {
//
//            System.setProperty("webdriver.chrome.driver",
//                    System.getProperty("user.dir") + "src/main/java/Amazon/executable/chromedriver-win64/chromedriver.exe");
//        }
//        WebDriver driver=new ChromeDriver();
//    }
//}
