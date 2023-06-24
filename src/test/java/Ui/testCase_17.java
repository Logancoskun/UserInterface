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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class testCase_17 {

    static WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown()  {

          //  driver.close();
        }

     @Test
     public void test01()   {
         Actions action = new Actions(driver);
//         2. Navigate to url 'http://automationexercise.com'
         driver.navigate().to("http://automationexercise.com");

//         3. Verify that home page is visible successfully
         WebElement verifyHomePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
         Assert.assertTrue(verifyHomePage.isDisplayed());
         String text = verifyHomePage.getText();
         System.out.println(text);

//         4. Add products to cart//
         //product 1
         driver.findElement(By.xpath("//a[@href='/products']")).click();
         action.pause(Duration.ofSeconds(3))
                 .perform();

         WebElement hoverOverPicture1 = driver.findElement(By.xpath("//img[@src='/get_product_picture/1']"));
         action.scrollByAmount(0, 500)
                 .moveToElement(hoverOverPicture1)
                 .pause(Duration.ofSeconds(2))
                 .perform();

         driver.findElement(By.xpath("(//a[@data-product-id='1'])[2]")).click();
         driver.findElement(By.xpath("//*[contains(text(),'Continue Shopping')]")).click();


         //product2
         WebElement hoverOverPicture2 = driver.findElement(By.xpath("//img[@src='/get_product_picture/2']"));
         action.moveToElement(hoverOverPicture2)
                 .pause(Duration.ofSeconds(2))
                 .perform();
         driver.findElement(By.xpath("(//a[@data-product-id='2'])[2]")).click();
         driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

         //product3
         WebElement picture3 = driver.findElement(By.xpath("//img[@src='/get_product_picture/3']"));
         action.moveToElement(picture3)
                 .pause(Duration.ofSeconds(2))
                 .perform();
         driver.findElement(By.xpath("(//a[@data-product-id='3'])[2]")).click();
         driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

         //product4
                  action.scrollByAmount(0, 300)
                 .perform();
         WebElement picture4 = driver.findElement(By.xpath("//img[@src='/get_product_picture/4']"));
         action.moveToElement(picture4)
                 .pause(Duration.ofSeconds(2))
                 .perform();
         driver.findElement(By.xpath("(//a[@data-product-id='4'])[2]")).click();
         driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

         //product5
         WebElement picture5 =  driver.findElement(By.xpath("//img[@src='/get_product_picture/5']"));
         action.moveToElement(picture5)
                 .pause(Duration.ofSeconds(2))
                 .perform();
         driver.findElement(By.xpath("(//a[@data-product-id='5'])[2]")).click();
         driver.findElement(By.xpath("//button[@class='btn btn-success close-modal btn-block']")).click();

         //product6
         WebElement picture6 = driver.findElement(By.xpath("//img[@src='/get_product_picture/6']"));
         action.moveToElement(picture6)
                 .pause(Duration.ofSeconds(2))
                 .perform();
         driver.findElement(By.xpath("(//a[@data-product-id='6'])[2]")).click();
         action.pause(Duration.ofSeconds(2))
                 .perform();

//         5. Click 'Cart' button
         action.pause(Duration.ofSeconds(2))
                 .perform();
         WebElement cart = driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]"));
         action.moveToElement(cart)
                 .click()
                 .perform();

//         6. Verify that cart page is displayed
         WebElement table = driver.findElement(By.xpath("//table[@id='cart_info_table']"));
         Assert.assertTrue(table.isDisplayed());
         String text3 = table.getText();
         System.out.println(text3);

         action.scrollByAmount(0, 500)
                 .perform();
//         7. Click 'X' button corresponding to particular product
         driver.findElement(By.xpath("(//i[@class='fa fa-times'])[5]")).click();

//         8. Verify that product is removed from the cart
         action.scrollByAmount(0, -300)
                 .perform();

         List<WebElement> verifythelist= driver.findElements(By.xpath("//tr"));

         for(WebElement element:verifythelist){

             System.out.println("These are the last list" + element.getSize());
         }
         }


    }

