package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class automationExerciseUiWithMainMethod {



    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.navigate().to("https://automationexercise.com/");

        WebElement homePagePicture = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        homePagePicture.isDisplayed();

       System.out.println(homePagePicture.isDisplayed());

    }

}


