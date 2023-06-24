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

public class testCase_22 {

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

        driver.navigate().to("http://automationexercise.com");

//    3. Scroll to bottom of page
        Actions action = new Actions(driver);
        action.scrollByAmount(0, 7500)
                .perform();

//    4. Verify 'RECOMMENDED ITEMS' are visible
        WebElement recommendedItems = driver.findElement(By.xpath("//*[contains(text(),'recommended items')]"));
        Assert.assertTrue(recommendedItems.isDisplayed());
        String text1 = recommendedItems.getText();
        System.out.println(text1);

//    5. Click on 'Add To Cart' on Recommended product
        driver.findElement(By.xpath("(//*[contains(text(),'Add to cart')])[1]")).click();

//    6. Click on 'View Cart' button
        driver.findElement(By.xpath("//*[contains(text(),'View Cart')]")).click();

//    7. Verify that product is displayed in cart page

        WebElement product = driver.findElement(By.xpath("//*[contains(text(),'Blue Top')]"));
        Assert.assertTrue(product.isDisplayed());
        String text2 = product.getText();
        System.out.println(text2);
    }
}
