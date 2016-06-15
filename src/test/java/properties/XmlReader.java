package properties;

import java.io.InputStream;
import java.util.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

/**
 * Created by user on 2016/6/12.
 */
public class XmlReader {

    public List<String> read(String xmlName){
        List<String> keywords = new ArrayList<String>();
        try {
            InputStream is=this.getClass().getResourceAsStream(xmlName);
            Document doc = new SAXReader().read(is);
            Element rootElm = doc.getRootElement();
            List<Element> itemList=rootElm.elements("k");
            for (Iterator<Element> iter = itemList.iterator(); iter.hasNext();){
                Element element = iter.next();
                keywords.add(element.getText());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return keywords;

    }

        @Test
        public void xmlReaderTest(){
            String xmlName = "keywords.xml";
            List<String> keywords = read(xmlName);
            for(String keyword:keywords){
                System.out.println("keyword -> "+keyword);
            }
        }
}
