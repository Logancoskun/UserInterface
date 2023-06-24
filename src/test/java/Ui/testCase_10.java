package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class testCase_10 {
    static WebDriver driver;
    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){

        // driver.close();
    }
    @Test
    public void test01() {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'

        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully

        // WebElement abc = driver.findElement(By.xpath(""));
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Scroll down to footer

        Actions action = new Actions(driver);
//        action.scrollByAmount(0, 9000)
//        .perform();

        //5. Verify text 'SUBSCRIPTION'
        WebElement subs = driver.findElement(By.xpath("//*[contains(text(),'Subscription')]"));
        action.scrollToElement(subs)
                        .perform();
        Assert.assertTrue(subs.isDisplayed());

        WebElement email = driver.findElement(By.xpath("//input[@id='susbscribe_email']"));
        email.sendKeys("loke@gmail.com");

        WebElement arrow = driver.findElement(By.id("subscribe"));
        arrow.submit();

        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(),'You have been successfully subscribed!')]"));
        Assert.assertTrue(successMessage.isDisplayed());
        System.out.println(successMessage.getText());
    }
}
