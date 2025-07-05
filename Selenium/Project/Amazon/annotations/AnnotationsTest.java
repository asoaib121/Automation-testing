package Amazon.annotations;

import org.testng.annotations.Test;
import java.lang.reflect.Method;

public class AnnotationsTest {
    //This is a TestNG test method with a custom description
    @Test(description="checking whether the parameter is accessible via reflection at runtime")
    public void testingTest(Method m){
         //Using Java Reflection to fetch the @Test annotation from the current method
        // and printing its 'description' value to the console
        System.out.println(m.getAnnotation(Test.class).description());
    }
}
