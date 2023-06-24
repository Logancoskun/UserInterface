package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class testCase_20 {
    static WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    public void teardown() {
        driver.close();
    }

    @Test
    public void test01() {

//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        // Create an instance of the JavascriptExecutor interface
       JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollBy(0,1500)");
//

//        3. Click on 'Products' button
        driver.findElement(By.xpath("//i[@class='material-icons card_travel']")).click();

//        4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(allProducts.isDisplayed());
        String text1 = allProducts.getText();
        System.out.println(text1);

//        5. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("blue" +
                "");

        driver.findElement(By.xpath("//button[@id='submit_search']")).click();

//        6. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProducts = driver.findElement(By.xpath("//*[contains(text(),'Searched Products')]"));
        Assert.assertTrue(searchedProducts.isDisplayed());
        String text2 = searchedProducts.getText();
        System.out.println(text2);

//        7. Verify all the products related to search are visible
        WebElement relevantProducts = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(relevantProducts.isDisplayed());
        String text3 = relevantProducts.getText();
        System.out.println(text3);

//        8. Add those products to cart
        //          // Scroll down the page by 1000 pixels

         //FIRST ITEM*********************************************
        WebElement picture1 = driver.findElement(By.xpath("//div[@class='productinfo text-center']"));

         Actions action = new Actions(driver);
         action.scrollByAmount(0, 500)
                 .pause(Duration.ofSeconds(5))
                 .moveToElement(picture1)
                 .perform();

        WebElement cart1= driver.findElement(By.xpath("(//a[@data-product-id='1'])[2]"));
         cart1.click();

         driver.findElement(By.xpath("//*[contains(text(),'Continue Shopping')]")).click();

        //SECOND ITEM****************************************************
         WebElement picture2 = driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[2]"));
         action.pause(Duration.ofSeconds(5))
                .moveToElement(picture2)
                .perform();

        WebElement cart2= driver.findElement(By.xpath("(//a[@data-product-id='16'])[2]"));
        cart2.click();


//        9. Click 'Cart' button and verify that products are visible in cart
        driver.findElement(By.xpath("//*[contains(text(),'View Cart')]")).click();

//        10. Click 'Signup / Login' button and submit login details
        driver.findElement(By.xpath("//*[contains(text(),' Signup / Login')]")).click();
        driver.findElement(By.xpath("//input[@type='email' and @data-qa='login-email']")).sendKeys("loganco@gmail.com");
        driver.findElement(By.xpath("//input[@type='password' and @data-qa='login-password']")).sendKeys("123445");
        driver.findElement(By.xpath("//button[@type='submit' and @data-qa='login-button']")).click();

//        11. Again, go to Cart page
        driver.findElement(By.xpath("(//a[@href='/view_cart'])[1]")).click();

//        12. Verify that those products are visible in cart after login as well
        WebElement thoseProducts = driver.findElement(By.xpath("//table[@class='table table-condensed']"));
        Assert.assertTrue(thoseProducts.isDisplayed());
        String text4 = thoseProducts.getText();
        System.out.println("this is the item list *********************************************************:" + text4);
    }
}