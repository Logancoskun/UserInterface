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

public class testCase_08 {

    static WebDriver driver;
    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){

        // driver.close();
    }
    @Test
    public void test01(){

        driver.navigate().to("http://automationexercise.com");

       // WebElement abc = driver.findElement(By.xpath(""));

       WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());

        WebElement productsButton = driver.findElement(By.xpath("//a[@href='/products']"));
        productsButton.click();

        WebElement productLists = driver.findElement(By.xpath("//h2[contains(text(),'All Products')]"));
        Assert.assertTrue(productLists.isDisplayed());

        WebElement category = driver.findElement(By.xpath("//h2[contains(text(),'Category')]"));
        category.isDisplayed();
        System.out.println(category.isDisplayed());

        Actions action = new Actions(driver);
        action.scrollByAmount(0, 400)
                .perform();

        WebElement viewProduct = driver.findElement(By.xpath("(//*[contains(text(),'View Product')])[1]"));
        viewProduct.click();

        WebElement productDetailPage = driver.findElement(By.xpath("//*[contains(text(),'Blue Top')]"));
        productDetailPage.isDisplayed();
        System.out.println(productDetailPage.isDisplayed());
        String text = productDetailPage.getText();
        System.out.println(text);

        List<WebElement> productDetails = driver.findElements(By.xpath("//p"));
        System.out.println(productDetails.size());

        for(WebElement each:productDetails){
            Assert.assertTrue(each.isDisplayed());
            System.out.println(each.getText());
        }

        String abc = driver.getCurrentUrl();

        System.out.println(abc);

        String bc = driver.getTitle();

        System.out.println(bc);

        }




        }





