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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class testCase_15 {
    static WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {

         driver.close();

    }

    @Test
    public void test() {
//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());

//        4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. Fill all details in Signup and create account
        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys("Lokku");

        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("kumam@gmail.com");

        driver.findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']")).click();

//        6. Verify 'ACCOUNT CREATED!' and click 'Continue' button

        Actions action = new Actions(driver);
        action.scrollByAmount(0, 500)
                        .perform();
        WebElement gender= driver.findElement(By.xpath("//input[@type='radio' and @id='id_gender1']"));
        gender.click();

        driver.findElement(By.xpath("//input[@type='password' and @class='form-control']"))  .sendKeys("12345");

        WebElement day = driver.findElement(By.xpath("//div[@class='selector' and @id='uniform-days']"));
        action.moveToElement(day)
                .click()
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(" Lokkku")
                .sendKeys(Keys.TAB)
                .sendKeys("Coss")
                .sendKeys(Keys.TAB)
                .sendKeys("Hoper")
                .sendKeys(Keys.TAB)
                .sendKeys("Tall")
                .sendKeys(Keys.TAB)
                .sendKeys("Water")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys("123")
                .sendKeys(Keys.TAB)
                .sendKeys("1234567")
                .sendKeys(Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.TAB)
                .sendKeys("1234567")
                .perform();

       driver.findElement(By.xpath("//button[@type='submit' and @data-qa='create-account']")).click();
       driver.findElement(By.xpath("//a[@href='/view_cart']")).click();

//        7. Verify ' Logged in as username' at top
        WebElement verifyUsername= driver.findElement(By.xpath("//a[contains(text(),' Logged in as')]"));
        Assert.assertTrue(verifyUsername.isDisplayed());
        String text= verifyUsername.getText();
        System.out.println(text);

//        8. Add products to cart
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        action.scrollByAmount(0, 500)
                .perform();

//        9. Click 'Cart' button
//        10. Verify that cart page is displayed
//        11. Click Proceed To Checkout
        //driver.findElement(By.xpath("")).click();

        WebElement hoverOverPicture1 = driver.findElement(By.xpath("//img[@src='/get_product_picture/1']"));
        action.scrollByAmount(0, 400)
        .moveToElement(hoverOverPicture1)
                .pause(Duration.ofSeconds(2))
                .perform();
        driver.findElement(By.xpath("(//a[@data-product-id='1'])[2]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Continue Shopping')]")).click();

        WebElement hoverOverPicture2 = driver.findElement(By.xpath("//img[@src='/get_product_picture/2']"));
                action.moveToElement(hoverOverPicture2)
                .pause(Duration.ofSeconds(2))
                .perform();
        driver.findElement(By.xpath("(//a[@data-product-id='2'])[2]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Continue Shopping')]")).click();

        WebElement hoverOverPicture3 = driver.findElement(By.xpath("//img[@src='/get_product_picture/3']"));
                action.moveToElement(hoverOverPicture3)
                .pause(Duration.ofSeconds(2))
                .perform();
        driver.findElement(By.xpath("(//a[@data-product-id='3'])[2]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'View Cart')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Proceed To Checkout')]")).click();
//
//        12. Verify Address Details and Review Your Order
       WebElement items = driver.findElement(By.xpath("//section[@id='cart_items']"));
       Assert.assertTrue(items.isDisplayed());
        System.out.println(items.getText());

//        13. Enter description in comment text area and click 'Place Order'

        action.scrollByAmount(0, 300)
                .perform();

        driver.findElement(By.xpath("//textarea[@class='form-control']")).sendKeys("It was a nice buy");
        driver.findElement(By.xpath("//a[@href='/payment']")).click();

//        14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Ll");
        driver.findElement(By.xpath("//input[@name='card_number']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@name='cvc']")).sendKeys("123");
        driver.findElement(By.xpath("//input[@class='form-control card-expiry-month']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@name='expiry_year']")).sendKeys("2024");
//        15. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[@class='form-control btn btn-primary submit-button']")).click();

        action.pause(Duration.ofSeconds(1))
                .perform();

//        16. Verify success message 'Your order has been placed successfully!'
//        driver.findElement(By.id("success_message")).isDisplayed();
//        Assert.assertTrue(message.isDisplayed());
//        String text3 = message.getText();
//        System.out.println(text3);

//        17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
//        18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//b[contains(text(),'Account Deleted!')]"));
        Assert.assertTrue(accountDeleted.isDisplayed());
        String text2= accountDeleted.getText();
        System.out.println(text2);






















    }
}
