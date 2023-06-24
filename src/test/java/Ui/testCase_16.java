package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class testCase_16 {

    static  WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
      //  driver.close();
    }

    @Test
    public void test01(){
        Actions action = new Actions(driver);

//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        driver.findElement(By.className("col-sm-4")).isDisplayed();

//        4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. Fill email, password and click 'Login' button
        driver.findElement(By.xpath("//input[@type='email' and @data-qa='login-email']")).sendKeys("logancos@gmail.com");
        driver.findElement(By.xpath("//input[@type='password' and @data-qa='login-password']")).sendKeys("123445");
        driver.findElement(By.xpath("//button[@type='submit' and @data-qa='login-button']")).click();

//        6. Verify 'Logged in as username' at top
        WebElement loggedIn = driver.findElement(By.xpath("//*[contains(text(),'Logan Happy')]"));
        Assert.assertTrue(loggedIn.isDisplayed());

//        7. Add products to cart
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        action.scrollByAmount(0, 700)
                .pause(Duration.ofSeconds(5))
                .perform();

        //first product/////////////////////////////////
        WebElement hoverOverPicture1 = driver.findElement(By.xpath("//img[@src='/get_product_picture/1']"));
        action.scrollByAmount(0, 400)
                .moveToElement(hoverOverPicture1)
                .pause(Duration.ofSeconds(2))
                .perform();
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[2]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Continue Shopping')]")).click();

        action.scrollByAmount(0, 200)
                .pause(Duration.ofSeconds(5))
                .perform();

        //second product/////////////////////////////////////////////
        WebElement hoverOverPicture2 = driver.findElement(By.xpath("//img[@src='/get_product_picture/2']"));
                       action.moveToElement(hoverOverPicture2)
                .pause(Duration.ofSeconds(2))
                .perform();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[2]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Continue Shopping')]")).click();

        //third product/////////////////////////////////////////
        WebElement hoverOverPicture3 = driver.findElement(By.xpath("//img[@src='/get_product_picture/3']"));
        action.moveToElement(hoverOverPicture3)
                .pause(Duration.ofSeconds(2))
                .perform();
        driver.findElement(By.xpath("(//a[@data-product-id='3'])[2]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Continue Shopping')]")).click();

        //fourth product//////////////////////////////////////////////////////
        WebElement hoverOverPicture4 = driver.findElement(By.xpath("//img[@src='/get_product_picture/4']"));
        action.moveToElement(hoverOverPicture4)
                .scrollByAmount(0, 200)
                .pause(Duration.ofSeconds(2))
                .perform();

//        8. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@data-product-id='4'])[2]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'View Cart')]")).click();

//        9. Verify that cart page is displayed
        WebElement verify = driver.findElement(By.xpath("//li[@class='active']"));
        Assert.assertTrue(verify.isDisplayed());

//        10. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[contains(text(),'Proceed To Checkout')]")).click();

//        11. Verify Address Details and Review Your Order
        List<WebElement> addressDetail = driver.findElements(By.xpath("//table"));

        for(WebElement element:addressDetail){
            System.out.println(element.getText());
        }

//        12. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("it was a nice buy");
        driver.findElement(By.xpath("//a[@href='/payment']")).click();

//        13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.name("name_on_card")).sendKeys("Loku");
        driver.findElement(By.name("card_number")).sendKeys("123445");
        driver.findElement(By.name("cvc")).sendKeys("123");
        driver.findElement(By.name("expiry_month")).sendKeys("07");
        driver.findElement(By.name("expiry_year")).sendKeys("2024");

//        14. Click 'Pay and Confirm Order' button
        driver.findElement(By.id("submit")).click();

//        15. Verify success message 'Your order has been placed successfully!'
        WebElement successMessage = driver.findElement(By.cssSelector("div[id='success-subscribe']"));
        action.pause(Duration.ofSeconds(2))
                .perform();
                Assert.assertTrue(successMessage.isSelected());

        action.sendKeys(Keys.ESCAPE)
                .perform();
       // Assert.assertTrue(successMessage.isDisplayed());
       String text1 = successMessage.getText();
        System.out.println(text1);

//        16. Click 'Delete Account' button
        driver.findElement(By.xpath("//i[@class='fa fa-trash-o']")).click();

//        17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]"));
        String text = accountDeleted.getText();
        System.out.println(text);

        driver.findElement(By.xpath("//*[contains(text(),'Continue')]")).click();
    }
}
