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
import java.util.List;

public class testCase_12 {
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
          driver.close();

    }

    @Test
    public void test01() {
        Actions action = new Actions(driver);

//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png' and @alt='Website for automation practice']"));
        Assert.assertTrue(homePage.isDisplayed());

//        4. Click 'Products' button
        WebElement product = driver.findElement(By.xpath("//a[@href='/products']"));
        product.click();

        action.pause(Duration.ofSeconds(3))
                .scrollByAmount(0, 500)
                .perform();

//        5. Hover over first product and click 'Add to cart'
        WebElement firstProduct = driver.findElement(By.xpath("(//*[contains(text(),'Add to cart')])[2]"));

        WebElement hoverOver = driver.findElement(By.xpath("(//*[contains(text(),'Rs. 500')])[1]"));
        action.moveToElement(hoverOver)
                .pause(Duration.ofSeconds(2))
                .click(firstProduct)
                .pause(Duration.ofSeconds(1))
                .perform();


//        6. Click 'Continue Shopping' button
        WebElement continueShopping = driver.findElement(By.xpath("//*[contains(text(), 'Continue Shopping')]"));
        continueShopping.click();

//        7. Hover over second product and click 'Add to cart'
//
        WebElement hoverOver1 = driver.findElement(By.xpath("(//*[contains(text(),'Men Tshirt')])[1]"));
        WebElement secondProduct = driver.findElement(By.xpath("(//*[contains(text(), 'Add to cart')])[4]"));

        action.moveToElement(hoverOver1)
                .pause(Duration.ofSeconds(2))
                .click(secondProduct)
                .pause(Duration.ofSeconds(1))
                .perform();


//        8. Click 'View Cart' button
        WebElement viewcart = driver.findElement(By.xpath("//*[contains(text(), 'View Cart')]"));
        viewcart.click();

        action.scrollByAmount(0, 200)
                .perform();


//        9. Verify both products are added to Cart
        List<WebElement> bothProducts = driver.findElements(By.id("//tr[@id]"));
        System.out.println(bothProducts.size());

        for (WebElement each : bothProducts) {
            Assert.assertTrue(each.isDisplayed());

        }

//        10. Verify their prices, quantity and total price
        List<WebElement> price = driver.findElements(By.xpath("//p[@class='cart_total_price']"));
        List<WebElement> totalQuantity = driver.findElements(By.xpath("//button[@class='disabled']"));
        List<WebElement> totalPrice = driver.findElements(By.xpath("//td[@class='cart_price']"));
        System.out.println(price.size());

        for (WebElement each : price) {
            Assert.assertTrue(each.isDisplayed());
        }
        for (WebElement each : totalPrice) {
            Assert.assertTrue(each.isDisplayed());
        }
        for (WebElement each : totalQuantity) {
            Assert.assertTrue(each.isDisplayed());

        }

    }
}