package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContentEqual {
    public static void main(String[] args) {
        //Initialize the web driver
        WebDriver driver = new ChromeDriver();

        String baseurl="http://demo.guru99.com/test/newtours";
        String expectedTitle="Welcome: Mercury Tours";
        String actualTitle="";

        // launch Chrome and direct it to the Base URL
        driver.get(baseurl);

        //get the actual value of the title
        actualTitle= driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if(actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }

        //The Chrome browser is close
      //  driver.close();
    }
}
