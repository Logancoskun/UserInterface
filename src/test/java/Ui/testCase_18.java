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

public class testCase_18 {

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
    public void teardown() {

        //  driver.close();
    }

    @Test
    public void test01() {
        Actions action = new Actions(driver);

//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Verify that categories are visible on left side bar
        WebElement category = driver.findElement(By.xpath("//*[contains(text(),'Category')]"));
        Assert.assertTrue(category.isDisplayed());

//        4. Click on 'Women' category
        action.scrollByAmount(0, 300)
                        .perform();
        driver.findElement(By.xpath("//a[@href='#Women']")).click();

//        5. Click on any category link under 'Women' category, for example: Dress
        driver.findElement(By.xpath("//a[@href='/category_products/1']")).click();

//        6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        WebElement womenTopProducts = driver.findElement(By.xpath("/html/body/section/div/div[2]/div[2]/div/h2"));
        action.pause(Duration.ofSeconds(3))
                        .perform();
       Assert.assertTrue(womenTopProducts.isDisplayed());
        String text1 = womenTopProducts.getText();
        System.out.println(text1);
//        7. On left side bar, click on any sub-category link of 'Men' category
        driver.findElement(By.xpath("//a[@href='#Men']")).click();
        action.pause(Duration.ofSeconds(3))
                        .perform();

        driver.findElement(By.xpath("//a[@href='/category_products/3']")).click();

//        8. Verify that user is navigated to that category page
        WebElement menCategoryPage = driver.findElement(By.xpath("//*[contains(text(),'Men - Tshirts Products')]"));
        Assert.assertTrue(menCategoryPage.isDisplayed());
        String text2 = menCategoryPage.getText();
        System.out.println(text2);
    }
}