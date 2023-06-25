package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class testCase_02 {


    static WebDriver driver;
    @Before
    public void setUp() {

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
    public void test02(){
        driver.navigate().to("https://automationexercise.com/");

         WebElement homePage= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        // homePage.isDisplayed();

         driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']")).isDisplayed();
         System.out.println(homePage.isDisplayed());

         WebElement signupButton= driver.findElement(By.xpath("//a[@href='/login']"));
         signupButton.click();

         WebElement loginAccount= driver.findElement(By.xpath("//*[contains(text(), 'Login to your account')]"));
         loginAccount.isDisplayed();

         WebElement email = driver.findElement(By.xpath("(//input[@type='email'])[1]"));
         email.sendKeys("logancos@gmail.com");

         WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
         password.sendKeys("123445");

         WebElement loginButton= driver.findElement(By.xpath("(//button[@type='submit'])[1]"));
         loginButton.click();

         WebElement loginName= driver.findElement(By.xpath("//*[contains(text(),'Logan Happy')]"));
         loginName.isDisplayed();

         WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));
         deleteAccount.click();

         WebElement accountVisible = driver.findElement(By.xpath("//*[contains(text(), 'Account Deleted!')]"));
         accountVisible.isDisplayed();
         driver.close();
    }
}
