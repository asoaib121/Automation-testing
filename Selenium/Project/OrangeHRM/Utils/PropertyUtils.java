package OrangeHRM.com.tmb.Utils;

import OrangeHRM.com.tmb.Enums.ConfigProperties;
import OrangeHRM.com.tmb.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    //add final
    private static final Properties property =new Properties();
    private static final Map<String, String> CONFIGMAP =new HashMap<>();

    private PropertyUtils() {

    }

    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath());
            property.load(file);

            for(Map.Entry<Object,Object> entry: property.entrySet()){
                CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue()).trim());//remove the trailling leading space
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  static String get(ConfigProperties key) throws Exception {
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new Exception("property name" +key +"is not found. please check config.propertise");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
