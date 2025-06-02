package Orangepractice.Listeners;

import org.testng.Assert;
import org.testng.annotations.*;

public class Runner {

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("before suite in runner");
    }

    @AfterSuite
    public void tearDownSuite() {
        System.out.println("after suite in runner");
    }

    @BeforeMethod
    public void setUp () {
        System.out.println("Before method in runner");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("after method in runner");
    }

    @Test
    public void test1() {
        System.out.println("test1");
        Assert.assertTrue(false);
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Test
    public void test3() {
        System.out.println("test3");
    }
}
