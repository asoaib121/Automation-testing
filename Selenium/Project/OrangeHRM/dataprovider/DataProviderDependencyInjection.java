package OrangeHRM.com.tmb.dataprovider.latest;
import org.testng.annotations.BeforeMethod;
import  org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class DataProviderDependencyInjection {

    @BeforeMethod
    public void setup(Object[] data){
        System.out.println(Arrays.toString(data));
    }

    @Test(dataProvider ="getData" )
    public void test1(String username,String password) {
        System.out.println(username +"in test method");
    }

    @DataProvider
    public Object[][] getData(){
            return new Object[][] {
                    {"amuthan","sakthivel"},
                    {"testing","minibytes"}
            };
    }
}
