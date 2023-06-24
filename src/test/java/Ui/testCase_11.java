package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class testCase_11 {

    static WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown() {
        //  driver.close();

    }

    @Test
    public void test01() {


//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());

//        4. Click 'Cart' button
        WebElement cartButton = driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]"));
        cartButton.click();

//        5. Scroll down to footer
        WebElement scrollDown = driver.findElement(By.xpath("//*[contains(text(), 'Subscription')]"));
       Actions action = new Actions(driver);
       action.scrollToElement(scrollDown)
               .perform();

//        6. Verify text 'SUBSCRIPTION'
        Assert.assertTrue(scrollDown.isDisplayed());

//        7. Enter email address in input and click arrow button
        WebElement email = driver.findElement(By.id("susbscribe_email"));
        email.sendKeys("loke@gmail.com");

        WebElement subscribeButton = driver.findElement(By.xpath("//button[@id='subscribe']"));
        subscribeButton.click();

//        8. Verify success message 'You have been successfully subscribed!' is visible

        WebElement verifySuccessMessage = driver.findElement(By.xpath("//*[contains(text(), 'You have been successfully subscribed!')]"));
        Assert.assertTrue(verifySuccessMessage.isDisplayed());
        System.out.println(verifySuccessMessage.isDisplayed());
        String text = verifySuccessMessage.getText();
        System.out.println("This is a verify message: " +  text);


















    }
}
