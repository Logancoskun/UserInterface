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

import java.time.Duration;

public class testCase_21 {

    static WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    public void teardown() {
        //driver.close();
    }

    @Test
    public void test01() {

//    2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");


//    3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

//    4. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProducts = driver.findElement(By.xpath("(//*[contains(text(),'All Products')])[2]"));
        Assert.assertTrue(allProducts.isDisplayed());
        String text = allProducts.getText();
        System.out.println(text);

//    5. Click on 'View Product' button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        driver.findElement(By.xpath("//a[@href='/product_details/1']")).click();

//    6. Verify 'Write Your Review' is visible
        WebElement productOne = driver.findElement(By.xpath("//*[contains(text(),'Blue Top')]"));
        Assert.assertTrue(productOne.isDisplayed());
        String text1 = productOne.getText();
        System.out.println(text1);

//    7. Enter name, email and review
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Logan Happy");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("loganco@gmail.com");
        driver.findElement(By.xpath("//textarea[@name='review']")).sendKeys("This is a new buy");

//    8. Click 'Submit' button
        // Create an instance of the JavascriptExecutor interface
        js.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("//button[@id='button-review']")).click();

//    9. Verify success message 'Thank you for your review.'
        WebElement thankYou = driver.findElement(By.xpath("//*[contains(text(),'Thank you for your review.')]"));
        Assert.assertTrue(thankYou.isDisplayed());
        String text2 = thankYou.getText();
        System.out.println(text2);


    }
}
