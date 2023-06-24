package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class testCase_06 {

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
        /*
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Contact Us' button
    5. Verify 'GET IN TOUCH' is visible
    6. Enter name, email, subject and message
    7. Upload file
    8. Click 'Submit' button
    9. Click OK button
    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    11. Click 'Home' button and verify that landed to home page successfully
         */

        driver.navigate().to("https://automationexercise.com/");
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());


        WebElement contactUs = driver.findElement(By.xpath("//a[@href='/contact_us']"));
        contactUs.click();

        WebElement getInTouch = driver.findElement(By.xpath("(//h2[@class='title text-center'])[2]"));
        Assert.assertTrue(getInTouch.isDisplayed());

        WebElement name = driver.findElement(By.xpath("//input[@type='text' and @name='name']"));
        Actions action = new Actions(driver);
        action.click(name)
               .sendKeys("Loke")
                .sendKeys(Keys.TAB)
                .sendKeys("cos@loke.com")
                .sendKeys(Keys.TAB)
               .sendKeys("resim")
                .sendKeys(Keys.TAB)
                .sendKeys("Today is nice")
                .perform();

        WebElement chooseFile = driver.findElement(By.xpath("//input[@type='file']"));
        chooseFile.sendKeys("C:\\Users\\lokma\\OneDrive\\Desktop\\Jira calismasi-01.docx");

        WebElement submit= driver.findElement(By.xpath("//input[@type='submit']"));
        action.scrollByAmount(0, 300)
                .click(submit)
                .perform();

        driver.switchTo().alert().accept();

        WebElement successMessage=driver.findElement(By.xpath("//div[@class='status alert alert-success']"));

        Assert.assertTrue(successMessage.isDisplayed());

        WebElement homepageButton=driver.findElement(By.xpath("//i[@class='fa fa-angle-double-left']"));
        homepageButton.click();


        WebElement homePage1 = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        homePage1.isDisplayed();


         }
}
