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

public class testCase_07 {

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

        WebElement homepage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homepage.isDisplayed());

        WebElement testCases= driver.findElement(By.xpath("(//a[@href='/test_cases'])[1]"));
        testCases.click();

        WebElement textC= driver.findElement(By.xpath("//b[contains(text(),'Test Cases')]"));
        Assert.assertTrue(textC.isDisplayed());




    }
}
