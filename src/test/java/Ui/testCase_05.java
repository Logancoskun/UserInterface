package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testCase_05 {

    static WebDriver driver;
    @Before
    public void setUp (){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    public void tearDown(){

       // driver.close();
    }
    @Test
    public void test01(){

        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
         */

        driver.navigate().to("https://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        homePage.isDisplayed();
        System.out.println(homePage.isDisplayed());

        WebElement loginSignUpButton= driver.findElement(By.xpath("//a[@href='/login']"));
        loginSignUpButton.click();

        WebElement newUserVisible= driver.findElement(By.xpath("//*[contains(text(),'New User Signup!')]"));
        newUserVisible.isDisplayed();
        System.out.println( newUserVisible.isDisplayed());

        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("Logan happy");

        WebElement email = driver.findElement(By.xpath("//input[@type='email' and @data-qa='signup-email']"));
        email.sendKeys("lok@gmail.com");

        WebElement signUpButton = driver.findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']"));
        signUpButton.click();

        WebElement existingEmailAddress= driver.findElement(By.xpath("//*[contains(text(),'Email Address already exist!')]"));
        existingEmailAddress.isDisplayed();
        System.out.println(existingEmailAddress.isDisplayed());

    }
}
