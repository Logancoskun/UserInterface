package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class testCase_19 {

    static WebDriver driver;
    @Before
    public void setup(){

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    public void teardown(){
        driver.close();
    }
    @Test
    public void test01(){

//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

//        4. Verify that Brands are visible on left side bar
        Actions action = new Actions(driver);
        action.scrollByAmount(0, 900);
        WebElement brand = driver.findElement(By.xpath("//*[contains(text(),'Category')]"));
        Assert.assertTrue(brand.isDisplayed());
        String text = brand.getText();
        System.out.println(text);

        // Create an instance of the JavascriptExecutor interface
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//
//          // Scroll down the page by 1000 pixels
//        js.executeScript("window.scrollBy(0,1800)");

////        5. Click on any brand name

         action.pause(Duration.ofSeconds(5))
        .scrollByAmount(0, 1300)
                 .perform();

        WebElement brand1 = driver.findElement(By.xpath("//a[@href='/brand_products/Babyhug']"));
         brand1.click();

//        6. Verify that user is navigated to brand page and brand products are displayed
        WebElement brandPage = driver.findElement(By.xpath("//*[contains(text(),'Brand - Babyhug Products')]"));
        Assert.assertTrue(brandPage.isDisplayed());
        String text1= brandPage.getText();
        System.out.println(text1);
//
//        7. On left side bar, click on any other brand link
        action.scrollByAmount(0, 200)
                        .perform();
        driver.findElement(By.xpath("//a[@href='/brand_products/Mast & Harbour']")).click();
//
////        8. Verify that user is navigated to that brand page and can see products
        WebElement brandPageLast = driver.findElement(By.xpath("//*[contains(text(),'Brand - Mast & Harbour Products')]"));
        Assert.assertTrue(brandPageLast.isDisplayed());
        String text2 = brandPageLast.getText();
        System.out.println(text2);




    }
}