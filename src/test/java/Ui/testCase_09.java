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

import java.time.Duration;
import java.util.List;

public class testCase_09 {

    static WebDriver driver;

    @Before
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() {

        // driver.close();
    }

    @Test
    public void test01() {

        driver.navigate().to("http://automationexercise.com");
        // WebElement abc = driver.findElement(By.xpath(""));


        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());
        String text = homePage.getText();
        System.out.println(text);

        WebElement products = driver.findElement(By.xpath("//a[@href='/products']"));
        products.click();

        WebElement allProducts = driver.findElement(By.xpath("(//*[contains(text(),'All Products')])[2]"));
        Assert.assertTrue(allProducts.isDisplayed());
        String text1 = allProducts.getText();
        System.out.println(text1);

        WebElement newProduct = driver.findElement(By.id("search_product"));
        newProduct.sendKeys("dress");

        WebElement newProductButton = driver.findElement(By.xpath("//button[@type='button' and @id='submit_search']"));
        newProductButton.click();

        WebElement searchedProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(searchedProducts.isDisplayed());
        String text2 = searchedProducts.getText();
        System.out.println(text2);

        String url = driver.getCurrentUrl();
        System.out.println(url);

        String title = driver.getTitle();
        System.out.println(title);


        //8. Verify all the products related to search are visible

        List<WebElement> productDetails = driver.findElements(By.xpath("//*[contains(text(),'View Product')]"));
        System.out.println(productDetails.size());

        for (WebElement each : productDetails) {
            Assert.assertTrue(each.isDisplayed());
            System.out.println(each.getText());

                  }
    }
}
