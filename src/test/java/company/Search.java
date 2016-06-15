package company;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by user on 2016/6/12.
 */
public class Search {
    @Test
    public void  a() {
        System.out.println("!!");
        Scanner sca = new Scanner(System.in);
        String a = sca.nextLine();
        System.out.println(a);
//		WebDriver wb = new FirefoxDriver();
//		wb.get("http://pch.qccr.com");//跳转至页面
//		WebElement wbe1 = wb.findElement(By.id("keyword"));//找到页面元素
//		wbe1.sendKeys("轮胎");//输入关键字
//		//WebElement click = wb.findElement(By.tagName("button"));
//		wbe1.submit();
//		//click.click();//点击
    }
}
