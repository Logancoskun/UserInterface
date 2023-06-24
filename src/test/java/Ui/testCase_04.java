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

public class testCase_04 {

    static  WebDriver driver;
    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){
      //  driver.close();

    }
    @Test
    public void test01(){
        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
         */
        driver.navigate().to("http://automationexercise.com");

        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        homePage.isDisplayed();
        System.out.println(homePage.isDisplayed());

        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();

        WebElement logVisible = driver.findElement(By.xpath("//*[contains(text(),'Login to your account')]"));
        logVisible.isDisplayed();
        System.out.println(logVisible.isDisplayed());


        WebElement email = driver.findElement(By.xpath("//input[@type='email' and @data-qa='login-email']"));
        email.sendKeys("logancos@gmail.com");

        WebElement passWord = driver.findElement(By.xpath("//input[@type='password' and @data-qa='login-password']"));
        passWord.sendKeys("123445");

        WebElement login1 = driver.findElement(By.xpath("//button[@type='submit' and @data-qa='login-button']"));
        login1.click();

        WebElement logInVisible= driver.findElement(By.xpath("//*[contains(text(), 'Logan Happy')]"));
        logInVisible.isDisplayed();
        System.out.println(logInVisible.isDisplayed());

        WebElement logOut= driver.findElement(By.xpath("//a[@href='/logout']"));
        logOut.click();

        WebElement userNavigatedPage= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        userNavigatedPage.isDisplayed();
        System.out.println( userNavigatedPage.isDisplayed());




    }
}
