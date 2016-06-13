package properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Juno on 2016/06/13.
 */
public class MyProperties {
    private static Map<String,String> prop = null;

    public static Map<String,String> getProp(String name){
        if(prop != null){
            return prop;
        }else{
            java.util.Properties properties = new java.util.Properties();
            prop = new HashMap<String, String>();
            try{
                InputStream in = MyProperties.class.getClass().getResourceAsStream("/properties/"+name);
                properties.load(in);
                Enumeration en = properties.propertyNames();
                while(en.hasMoreElements()){
                    String key = en.nextElement().toString().trim();
                    String value = properties.getProperty(key).trim();

                    prop.put(key,value);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return prop;
        }

    }
}
