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

public class testCase_13 {

    /*

        Test Case 13: Verify Product quantity in Cart
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click 'View Product' for any product on home page
        5. Verify product detail is opened
        6. Increase quantity to 4
        7. Click 'Add to cart' button
        8. Click 'View Cart' button
        9. Verify that product is displayed in cart page with exact quantity

     */

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

        driver.close();

    }

    @Test
    public void test01() {
        Actions action = new Actions(driver);


        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());

        //4. Click 'View Product' for any product on home page
        WebElement viewProduct = driver.findElement(By.xpath("//a[@href='/product_details/2']"));
        viewProduct.click();
        action.pause(Duration.ofSeconds(1))
                .perform();

        //5. Verify product detail is opened
        WebElement productDetailsTab=driver.findElement(By.xpath("//div[@class='col-sm-7']"));
        Assert.assertTrue(productDetailsTab.isDisplayed());

        //6. Increase quantity to 4
        WebElement quantity=driver.findElement(By.xpath("//input[@type='number']"));
        action.moveToElement(quantity)
                .click(quantity)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("4")
                .perform();

        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();
        action.pause(Duration.ofSeconds(1))
                .perform();

        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//a[@href='/view_cart']) [2]")).click();

        //9. Verify that product is displayed in cart page with exact quantity
        WebElement displayVerification= driver.findElement(By.xpath("//div[@class='table-responsive cart_info']"));
        Assert.assertTrue(displayVerification.isDisplayed());










    }
}