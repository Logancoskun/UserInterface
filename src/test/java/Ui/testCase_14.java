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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class testCase_14 {

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
        // driver.close();

    }

    @Test
    public void test() {

        //1. Launch browser

        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Add products to cart
        Actions action = new Actions(driver);

        WebElement moveToImage1 = driver.findElement(By.xpath("//img[@src='/get_product_picture/1']"));
        WebElement addToCart1 = driver.findElement(By.xpath("(//a[@data-product-id='1'])[2]"));
        WebElement con = driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']"));

        action.scrollByAmount(0, 600)
                .moveToElement(moveToImage1)
                .pause(Duration.ofSeconds(1))
                .click(addToCart1)
                .pause(Duration.ofSeconds(1))
                .click(con)
                .perform();

        WebElement moveToImage2 = driver.findElement(By.xpath("//img[@src='/get_product_picture/2']"));
        WebElement addToCart2 = driver.findElement(By.xpath("(//a[@data-product-id='2'])[2]"));
        action.moveToElement(moveToImage2)
                .pause(Duration.ofSeconds(1))
                .click(addToCart2)
                .pause(Duration.ofSeconds(1))
                .click(con)
                .perform();

        WebElement moveToImage3 = driver.findElement(By.xpath("//img[@src='/get_product_picture/3']"));
        WebElement addToCart3 = driver.findElement(By.xpath("(//a[@data-product-id='3'])[2]"));
        action.moveToElement(moveToImage3)
                .pause(Duration.ofSeconds(1))
                .click(addToCart3)
                .pause(Duration.ofSeconds(1))
                .click(con)
                .perform();

        //5. Click 'Cart' button
        action.scrollByAmount(0, -600)
                .perform();
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();


//        6. Verify that cart page is displayed
        driver.findElement(By.xpath("(//div[@class='container'])[2]")).isDisplayed();

//        7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[contains(text(), 'Proceed To Checkout')]")).click();

//        8. Click 'Register / Login' button
        driver.findElement(By.xpath("//u[contains(text(), 'Register / Login')]")).click();

//        9. Fill all details in Signup and create account
        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        action.click(name)
                .sendKeys("Loke")
                .sendKeys(Keys.TAB)
                .sendKeys("telerimiziden@gmail.com")
                .sendKeys(Keys.TAB)
                .pause(Duration.ofSeconds(2))
                .sendKeys(Keys.ENTER)
                .perform();

        action.scrollByAmount(0, 300)
                .perform();

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("12345");

        WebElement day = driver.findElement(By.id("days"));
        Select select = new Select(day);
        select.selectByValue("19");

        WebElement month = driver.findElement(By.id("months"));
        Select select1 = new Select(month);
        select1.selectByValue("3");

        WebElement year = driver.findElement(By.id("years"));
        Select select2 = new Select(year);
        select2.selectByValue("1980");

        WebElement signUp= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        action.click(signUp)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys("Loke")
                .sendKeys(Keys.TAB)
                .sendKeys("cos")
                .sendKeys(Keys.TAB)
                .sendKeys("Hyp")
                .sendKeys(Keys.TAB)
                .sendKeys("2 tall")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys("Ontario")
                .sendKeys(Keys.TAB)
                .sendKeys("Montreal")
                .sendKeys(Keys.TAB)
                .sendKeys("J2G")
                .sendKeys(Keys.TAB)
                .sendKeys("2135467859")
                .sendKeys(Keys.TAB)
                .pause(Duration.ofSeconds(2))
                .sendKeys(Keys.ENTER)
                .perform();


//        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        WebElement accountCreated = driver.findElement(By.xpath("//*[contains(text(),'Account Created!')]"));
        Assert.assertTrue(accountCreated.isDisplayed());

        driver.findElement(By.xpath("//*[contains(text(),'Continue')]")).click();

//        11. Verify ' Logged in as username' at top
        WebElement user = driver.findElement(By.xpath("//*[contains(text(),' Logged in as ')]"));
        Assert.assertTrue(user.isDisplayed());

//        12.Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

//        13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[contains(text(),'Proceed To Checkout')]")).click();

//        14. Verify Address Details and Review Your Order

        List<WebElement> address = driver.findElements(By.xpath("//div[@class='checkout-information']"));
        address.size();
        System.out.println(address.size());

        for(WebElement each:address){

            System.out.println(each.getText());

        }

//        15. Enter description in comment text area and click 'Place Order'
        action.scrollByAmount(0, 800)
                .perform();

        WebElement abc = driver.findElement(By.xpath("//textarea[@class='form-control' and @name='message']"));
        abc.sendKeys("It was a good deal");

        driver.findElement(By.xpath("//*[contains(text(),'Place Order')]")).click();

//        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date,  17. Click 'Pay and Confirm Order' button
        WebElement pay = driver.findElement(By.xpath("//input[@class='form-control']"));

        action.moveToElement(pay)
                .click()
                .sendKeys("Lama")
                .sendKeys(Keys.TAB)
                .sendKeys("123454")
                .sendKeys(Keys.TAB)
                .sendKeys("123")
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("2024")
                .sendKeys(Keys.TAB)
                .pause(Duration.ofSeconds(2))
                .sendKeys(Keys.ENTER)
                .pause(Duration.ofSeconds(2))
                .perform();

//
//        18. Verify success message 'Your order has been placed successfully!'
        WebElement orderMessage = driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]"));
        Assert.assertTrue(orderMessage.isDisplayed());

//        19. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//        20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]"));
        Assert.assertTrue(accountDeleted.isDisplayed());
        String text = accountDeleted.getText();
        System.out.println(text);


    }
}
