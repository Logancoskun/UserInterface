package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class testCase_23 {
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

//        3. Verify that home page is visible successfully
       WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());
        String text1= homePage.getText();
        System.out.println(text1);

//        4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Logan H");
        driver.findElement(By.xpath("//input[@type='email' and @data-qa='signup-email']")).sendKeys("look@gmail.com");
        driver.findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']")).click();

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        Actions action = new Actions(driver);
        action.moveToElement(password)
                .click(password)
                .sendKeys("123")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .scrollByAmount(0, 300)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE)
                .sendKeys(Keys.TAB)
                .sendKeys("Logan")
                .sendKeys(Keys.TAB)
                .sendKeys("H")
                .sendKeys(Keys.TAB)
                .sendKeys("Hu")
                .sendKeys(Keys.TAB)
                .sendKeys("201")
                .sendKeys(Keys.TAB)
                .sendKeys("Gain")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys("Ontar")
                .sendKeys(Keys.TAB)
                .sendKeys("Kit")
                .sendKeys(Keys.TAB)
                .sendKeys("123")
                .sendKeys(Keys.TAB)
                .sendKeys("1234567")
                .sendKeys(Keys.ENTER)
               .perform();

//        6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
       WebElement accountCreated = driver.findElement(By.xpath("//*[contains(text(),'Account Created!')]"));
       Assert.assertTrue(accountCreated.isDisplayed());
       String text2= accountCreated.getText();
        System.out.println(text2);
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

//        7. Verify ' Logged in as username' at top
       WebElement verifyUserName = driver.findElement(By.xpath("//*[contains(text(),' Logged in as ')]"));
       Assert.assertTrue(verifyUserName.isDisplayed());
       String text3 = verifyUserName.getText();
        System.out.println(text3);

//        8. Add products to cart
        WebElement item1 = driver.findElement(By.xpath("//img[@src='/get_product_picture/1']"));
        action.scrollByAmount(0, 500)
                .moveToElement(item1)
                        .perform();

        driver.findElement(By.xpath("(//*[contains(text(),'Add to cart')])[1]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Continue Shopping')]")).click();

        //second item **************************************************
        WebElement item2 = driver.findElement(By.xpath("//img[@src='/get_product_picture/2']"));
        action.moveToElement(item2)
                        .perform();

        driver.findElement(By.xpath("(//*[contains(text(),'Add to cart')])[3]")).click();


//        9. Click 'Cart' button
        driver.findElement(By.xpath("//*[contains(text(),'View Cart')]")).click();

//        10. Verify that cart page is displayed
       WebElement cartPage = driver.findElement(By.xpath("//*[contains(text(),'Shopping Cart')]"));
       Assert.assertTrue(cartPage.isDisplayed());
       String text4 = cartPage.getText();
        System.out.println(text4);

//        11. Click Proceed To Checkout
        driver.findElement(By.xpath("//*[contains(text(),'Proceed To Checkout')]")).click();

//        12. Verify that the delivery address is same address filled at the time registration of account
        WebElement address =  driver.findElement(By.xpath("//ul[@class='address item box']"));
        Assert.assertTrue(address.isDisplayed());
        String text5 = address.getText();
        System.out.println(text5);

//        13. Verify tahat the billing address is same address filled at the time registration of account
        WebElement bill =  driver.findElement(By.xpath("//ul[@class='address alternate_item box']"));
        Assert.assertTrue(bill.isDisplayed());
        String text6 = bill.getText();
        System.out.println(text6);

//        14. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();

//        15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
       WebElement accountDeleted = driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]"));
       Assert.assertTrue(accountDeleted.isDisplayed());
       //String text7 = accountCreated.getText();
        System.out.println(accountDeleted.getText());
    }
}
