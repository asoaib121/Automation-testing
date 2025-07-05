package Amazon.utils;

/**
 * Utility class to generate dynamic  XPath by replacing placeholders with actual values.
 */
public final class DynamicXpathUtils {
    // Private constructor to prevent instantiation of the utility class.
    private DynamicXpathUtils() {}

    /**
     * Replace a single placeholder in the given XPath string with the provider value.
     *
     * @param xpath The XPath string with a single placeholder (e.g., "//a[text()='%s']")
     * @param value The value to replace the placeholder with
     * @return The final XPath string with the value inserted
     */
    public static String  getXpath(String xpath,String value){
        return String.format(xpath,value);
    }

    /**
     * Replace two placeholder in the given XPath string with the provided values.
     *
     * @param xpath The XPath string with two placeholders (e.g., "//a[@title='%s' and text()='%s']")
     * @param value1 The first values to insert into the XPath
     * @param value2 The second values to insert into the XPath
     * @return The final XPath string with both values inserted
     */
    public static String  getXpath(String xpath,String value1,String value2){
        return String.format(xpath,value1,value2);
    }

}
