package Amazon.listeners;

import Amazon.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * This class is used to dynamically modify TestNG @Test annotations at runtime.
 * It sets a common DataProvider and RetryAnalyzer for all test methods.
 */
public class AnnotationTransformers implements IAnnotationTransformer {

    /**
     * This method is automatically called by TestNG before any test method is invoked.
     * It allows changing the behavior of @Test annotations dynamically.
     *
     * @param annotation The annotation that was read from your test class.
     * @param testClass If the annotation was found on a class, this parameter represents this class
     *     (null otherwise).
     * @param testConstructor If the annotation was found on a constructor, this parameter represents
     *     this constructor (null otherwise).
     * @param testMethod If the annotation was found on a method, this parameter represents this
     *     method (null otherwise).
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        //Set a custom DataProvider method named "getData" from DataProviderUtils class.
        annotation.setDataProvider("getData");
        //Specify the class from where the DataProvider method should be taken.
        annotation.setDataProviderClass(DataProviderUtils.class);
        //Set a custom RetryAnalyzer class to retry failed tests based on configuration
        annotation.setRetryAnalyzer(RetryFailedTests.class);
    }
}

