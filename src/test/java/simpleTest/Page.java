package simpleTest;

import org.openqa.selenium.support.PageFactory;

import java.sql.DriverManager;

/**
 * Created by user on 2016/6/14.
 */
public class Page {
    public Page(){
        PageFactory.initElements(DriverManager.driver, this);
    }
}
