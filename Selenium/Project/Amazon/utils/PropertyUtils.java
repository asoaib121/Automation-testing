package Amazon.utils;

import Amazon.Enums.ConfigProperties;
import Amazon.constants.FrameworkConstants;
import Amazon.exceptions.InvalidPathForProertyFileException;
import Amazon.exceptions.PropertyFileUsageException;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Utility class to load configuration properties from config.properties file.
 * The value are cached into a map for fast access throughtout the framework.
 */
public final class PropertyUtils {

    //Property object to load key-value  pairs from the config file
    private static final Properties property =new Properties();
    //CONFIGMAP stores all properties in a HashMap for faster access
    private static final Map<String, String> CONFIGMAP =new HashMap<>();
    //Private constructor to prevent instantiation
    private PropertyUtils() {

    }
    //Static block executes only once when the class is loaded
    static {
        // Load the file from configured path
        try(FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath());
            //Use BufferedInputStream for better performance
            BufferedInputStream bfis =new BufferedInputStream(file);) {
            //Load the final content into 'project' object
            property.load(file);

            //Load through all the entries and add them to CONFIGMAP
            for(Map.Entry<Object,Object> entry: property.entrySet()){
                //Convert key and value to string and trim any extra spaces
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());//(trim)remove the trailling leading space
            }
        } catch ( IOException e) {
            //If file is missing or Unreadable, print error and exit the program.
            e.printStackTrace();
            System.out.println("File not found");
            System.exit(0);
        }
    }

    /**
     * Returns the value of the given config key from CONFIGMAP.
     * @param key the enum key (from ConfigProperties) to look up
     * @return The corresponding value as a String
     * @throws PropertyFileUsageException if the key is missing or null
     */

    public  static String get(ConfigProperties key)  {
        //Validate the key and its presence in CONFIGMAP
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("property name" +key +"is not found. please check config.propertise");
        }
        //Return the value from the map.
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
