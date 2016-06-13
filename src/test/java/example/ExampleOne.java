package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 2016/6/13.
 */
public class ExampleOne {
    @Test
    public void baiduTest(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        driver.get("http://www.google.com");
        driver.get("http://www.baidu.com");
        WebElement we = driver.findElement(By.id("kw"));
        we.sendKeys("胡琳琳");
        we.click();//在form内可用；
//        driver.findElement(By.id("lst-ib")).sendKeys("胡琳琳");
//        driver.findElement(By.name("btnK")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String aResult=driver.findElement(By.xpath(".//*[@id='4']/h3/a")).getText();
        assert aResult.contains("胡琳琳");
        driver.findElement(By.xpath(".//*[@id='4']/h3/a")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        for(String winHandle:driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        String aTitle=driver.getTitle();
        System.out.println("current widnow title is:"+aTitle);
        assert aTitle.contains("胡琳琳");
    }
}
