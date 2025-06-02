package OrangeHRM.com.tmb.test;

import OrangeHRM.com.tmb.driver.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Objects;

public class HomePageTest extends BaseTest {
    private HomePageTest(){
    }

    @Test
    public void test3() {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini bytes - Youtube", Keys.ENTER);

        String title = DriverManager.getDriver().getTitle();

        Assert.assertTrue("Title is null", Objects.nonNull(title));

        //noinspection MismatchedStringCase
        Assert.assertTrue(title.toLowerCase().contains("Google Search"));
        Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"Google Search"));
        Assert.assertTrue(title.length()>15);
        Assert.assertTrue( title.length()<100);

                List<WebElement>  elements = DriverManager.getDriver().findElements(By.xpath("//h3/span"));
                Assert.assertEquals(elements.size(),10);

                boolean isElementpresent =false;
                for(WebElement element: elements) {
                    if(element.getText().equalsIgnoreCase("Testing mini bytes")){
                        isElementpresent=true;
                        break;
                    }
                }
                Assert.assertTrue("Testing mini bytes not found", isElementpresent);
    }
}
