package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class automationExerciseWithTestNG {

    //Launch browser  *************************************************************
    static WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public void tearDown() {

//        driver.close();
    }

    @Test
    public void test01() {

        //Navigate to url 'http://automationexercise.com' ****************************************************
        driver.navigate().to("https://automationexercise.com/");
    }


    @Test(dependsOnMethods = "test01")
    public void test02() {

        //Navigate to url 'http://automationexercise.com' ****************************************************
        driver.navigate().to("https://amazon.com/");
    }

    @Test(priority = 01)
    public void test03() {

        //Navigate to url 'http://automationexercise.com' ****************************************************
        driver.navigate().to("https://facebook.com/");


    }
}