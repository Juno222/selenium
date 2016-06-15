package properties;

import java.io.BufferedInputStream;
import java.io.File;
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
    //private static Map<String,String> prop = null;
    private static Map<String,Map<String,String>> prop = new HashMap<String, Map<String, String>>();

    public static Map<String,String> getProp(String name){

        if(prop.get(name) != null){
            return prop.get(name);
        }else{
            java.util.Properties properties = new java.util.Properties();
            Map<String,String> singleProp = new HashMap<String, String>();
            try{
                //包内的配置
                InputStream in = MyProperties.class.getClass().getResourceAsStream("/properties/"+name);
                properties.load(in);
                Enumeration en = properties.propertyNames();
                while(en.hasMoreElements()){
                    String key = en.nextElement().toString().trim();
                    String value = properties.getProperty(key).trim();

                    singleProp.put(key,value);
                }
                //本地的配置
                File localFile = new File("d:/"+name);
                InputStream localIn = new FileInputStream(localFile);
                properties.load(localIn);
                Enumeration localEn = properties.propertyNames();
                while(localEn.hasMoreElements()){
                    String key = localEn.nextElement().toString().trim();
                    String value = properties.getProperty(key).trim();

                    singleProp.put(key,value);
                }

                prop.put(name,singleProp);
            }catch (Exception e){
                e.printStackTrace();
            }
            return prop.get(name);
        }

    }
}
