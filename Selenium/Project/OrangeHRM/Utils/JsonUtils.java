//package OrangeHRM.com.tmb.Utils;
//
//import OrangeHRM.com.tmb.Enums.ConfigProperties;
//import OrangeHRM.com.tmb.constants.FrameworkConstants;
//import jdk.internal.org.objectweb.asm.TypeReference;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//import static java.util.logging.Level.CONFIG;
//
//// Use Json ..but json not setup in this Project..
//
//public class JsonUtils {
//
//    // Use Json ..but json not setup in this Project..
//
//    private static Map<String, String> CONFIGMAP;
//
//    private JsonUtils() {
//
//    }
//    static {
//        try {
//            CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonconfigfilepath()),
//                    new TypeReference <HashMap<String,String>>() {});
//        } catch (FileNotFoundException e){
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static String get (ConfigProperties key) throws Exception {
//        if (Object.isNull(key) || Objects.isNull(CONFIG.get(key.name().toLowerCase()))) {
//            throw new Exception ("Property name " + key + "is not found.Please check config properties");
//        }
//        return CONFIGMAP.get(key.name().toLowerCase());
//    }
//}
