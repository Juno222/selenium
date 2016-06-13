import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Juno on 2016/6/11.
 */
public class SearchTest {
    private String xmlName = "keywords.xml";
    @Test
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        List<String> keywords = getKeywords();
        for(String k : keywords){
            WebDriver wb = new ChromeDriver();
            wb.get("http://sshop.csqccr.com");
            WebElement we = wb.findElement(By.id("keyword"));
            we.sendKeys(k);
            we.submit();
            WebElement count = wb.findElement(By.className("normalsize"));
            String countText = count.getText();
            String result = getNum(countText);
            Integer resultInt = Integer.parseInt(result);
            Integer db_count = getCount(k);
            Assert.assertEquals(resultInt,db_count);
        }

    }
    private String getNum(String text){
        String num ;
        String temp = text.split("/")[1];
        temp = temp.trim();
        int index = 0;
        for (int i = 0; i < temp.length(); i++) {
            char linshi = temp.charAt(i);
            if(!(linshi>=48&&linshi<=57)){
                index = i;
                break;
            }
        }
        num = temp.substring(0,index);
        return num;
    }
    private Integer getCount(String search){
        String sql = "SELECT COUNT(*) account FROM ic_item WHERE item_name LIKE '%"+search+"%' AND shop_id = 2 AND is_marketable = 1";
        //String sql2 = "select count(*) from bug_info";
        JDBCCon jdbccon = new JDBCCon();
        System.out.println(sql);
        return jdbccon.selectCount(sql);
    }

    private List<String> getKeywords(){
        XmlReader xmlReader = new XmlReader();
        List<String> keywords = xmlReader.read(xmlName);
        return keywords;
    }
}
