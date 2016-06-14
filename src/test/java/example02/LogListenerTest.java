package example02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by user on 2016/6/14.
 */
public class LogListenerTest {

    WebDriver driver = new EventFiringWebDriver(new ChromeDriver()).register(new LogListener());

}
