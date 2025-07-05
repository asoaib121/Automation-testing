package Amazon.tests;

import Amazon.Enums.CategoryType;
import Amazon.annotations.FrameworkAnnotation;
import Amazon.pages.AmazonHomePage;
import Amazon.reports.ExtentManager;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import java.util.Map;
import java.util.Objects;

public final class AmazonDemoTest extends BaseTest {


    private AmazonDemoTest() {}
    //Input Writer and category Information.
    @FrameworkAnnotation(author={"Amuthan","Sachin"},category={CategoryType.REGRESSION,CategoryType.MINIREGRESSION})
    @Test //Testng detect testcase
    public void  amazonTest(Map<String,String>data) {//Amuthan,Sachin
        //Add metadata to the Extent Report
        ExtentManager.getExtentTest().assignAuthor("Amuthan").assignAuthor("Sachin")
                .assignCategory("Smoke").assignCategory("Regression");

        try {
            String title = Objects.requireNonNull(new AmazonHomePage().clickHamburger()
                    .clickComputer() //click Computer Menu
                    .clickOnSubMenuItem(data.get("menutext"))).getTitle(); //By clicking on a specific item in the submenu, then get page title
            Assertions.assertThat(title).isNotNull().isNotBlank();
        }catch(Exception e){
            System.out.println("Test failed with exception: " + e.getMessage()); //If we found Exception, then print it.
            throw e; //Throws that exception again
        }
    }
}