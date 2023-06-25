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

public class testCase_03 {

    static WebDriver driver;
    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
     public void tearDowN(){
       // driver.close();

    }

    @Test
    public void test01(){

       // 1. Launch browser

        // 2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        homePage.isDisplayed();
        System.out.println(homePage.isDisplayed());

       // 4. Click on 'Signup / Login' button
        WebElement loginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        loginButton.click();

      //  5. Verify 'Login to your account' is visible
        WebElement loginButtonVis= driver.findElement(By.xpath("//*[contains(text(), 'Login to your account')]"));
        loginButtonVis.isDisplayed();
        System.out.println(loginButtonVis.isDisplayed());

        //6. Enter incorrect email address and password
        WebElement email = driver.findElement(By.xpath("//input[@type='email' and @data-qa='login-email']"));
        email.sendKeys("lok@gmail.com");

        WebElement password= driver.findElement(By.xpath("//input[@type='password' and @data-qa='login-password']"));
        password.sendKeys("12345");

        // 7. Click 'login' button
        WebElement loginLast= driver.findElement(By.xpath("//button[@type='submit' and @data-qa='login-button']"));
        loginLast.click();

        // 8. Verify error 'Your email or password is incorrect!' is visible
        WebElement verify= driver.findElement(By.xpath("//*[contains(text(),'Your email or password is incorrect!')]"));
        driver.findElement(By.xpath("//*[contains(text(),'Your email or password is incorrect!')]")).isDisplayed();
        //verify.isDisplayed();
        System.out.println(verify.isDisplayed());
        driver.close();
    }
}
