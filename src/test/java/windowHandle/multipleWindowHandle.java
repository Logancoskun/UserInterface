package windowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class multipleWindowHandle {

    static WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown() {

        // driver.close();
    }

    @Test
    public void test01() {

        // navigate to the starting web page
        driver.get("https://www.google.com");

        // open four tabs
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.amazon.com')");
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.twitter.com')");
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.facebook.com')");
        ((JavascriptExecutor) driver).executeScript("window.open('https://www.hotmail.com')");


        // switch to each tab

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver.switchTo().window(handle);
//            driver.get("https://www.amazon.com");
//            driver.get("https://www.twitter.com");
//            driver.get("https://www.facebook.com");
//            driver.get("https://www.hotmail.com");


        }

    }

}

