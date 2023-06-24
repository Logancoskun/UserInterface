package Ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class testCase_01_automationExerciseWithJUnit {

    //Launch browser  *************************************************************
    static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){

//        driver.close();
    }
    @Test
    public void test01(){

        //Navigate to url 'http://automationexercise.com' ****************************************************
        driver.navigate().to("https://automationexercise.com/");

        //Verify that home page is visible successfully **************************************************
        WebElement homePagePicture = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        homePagePicture.isDisplayed();
        System.out.println(homePagePicture.isDisplayed());

        //Click on 'Signup / Login' button  ***************************

        WebElement signupLogin = driver.findElement(By.xpath("//a[@href='/login']"));
        signupLogin.click();

        // Verify 'New User Signup!' is visible
        WebElement newuser= driver.findElement(By.xpath("//*[contains(text(),'New User Signup!')]"));
        newuser.isDisplayed();
        System.out.println(newuser.isDisplayed());
//        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'New User Signup!')]")).isDisplayed());

        //Enter name and email address  ******************************************************
        WebElement name = driver.findElement(By.xpath("//input[@type='text']"));
        name.sendKeys("Logan Happy");

        WebElement email = driver.findElement(By.xpath("//input[@type='email' and @data-qa='signup-email']"));
        email.sendKeys("loganco@gmail.com");

        //Click 'Signup' button****************************************************************
        WebElement signUp = driver.findElement(By.xpath("//button[@type='submit' and @data-qa='signup-button']"));
        signUp.click();

        //Verify that 'ENTER ACCOUNT INFORMATION' is visible*************************************
        WebElement enterAccount = driver.findElement(By.xpath("//*[contains(text(),'Enter Account Information')]"));
        enterAccount.isDisplayed();
        System.out.println(enterAccount.isDisplayed());

        //title
        WebElement mrButton = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        mrButton.click();

        //password
        WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
        passWord.sendKeys("123445");

        //Scroll down the page *************ACTION CLASS*******************************
        Actions action = new Actions(driver);
        action.scrollByAmount(0, 300).perform();

        //Day of birth****************DROPDOWN**************************************
        Select dateOfBirth = new Select(driver.findElement(By.xpath("//*[@id='days']")));
        dateOfBirth.selectByValue("3");

        //Month of birth***************DROPDOWN**************************************
        Select monthOfBirth = new Select(driver.findElement(By.xpath("//*[@id='months']")));
        monthOfBirth.selectByIndex(1);

        //year of birth***************DROPDOWN**************************************
        Select yearOfBirth = new Select(driver.findElement(By.xpath("//*[@id='years']")));
        yearOfBirth.selectByValue("1968");

        //Newsletter
        WebElement newsLetter = driver.findElement(By.xpath("//*[@id='newsletter']"));
        newsLetter.click();

        //special offer
        WebElement specialOffer = driver.findElement(By.xpath("//*[@id='optin']"));
        specialOffer.click();

        Actions action1 = new Actions(driver);
        action1.scrollByAmount(0, 350).perform();

        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys("Logan");

        WebElement lastName= driver.findElement(By.id("last_name"));
        lastName.sendKeys("Happy");

        WebElement companyName= driver.findElement(By.id("company"));
        companyName.sendKeys("Hypnotes");

        WebElement address1= driver.findElement(By.id("address1"));
        address1.sendKeys("Tall Grass");

        WebElement address2= driver.findElement(By.id("address2"));
        address2.sendKeys("Cress");

        Actions action2 = new Actions(driver);
        action2.scrollByAmount(0, 500).perform();

        WebElement country = driver.findElement(By.id("country"));
        Select select = new Select(country);
        select.selectByValue("Canada");

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Ontario");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Kitchener");

        WebElement zipcode = driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("N2P 4S7");

        WebElement mobile = driver.findElement(By.id("mobile_number"));
        mobile.sendKeys("1234567");

        WebElement createAccount = driver.findElement(By.xpath("//*[contains(text(), 'Create Account')]"));
        createAccount.click();

        WebElement accountCreated = driver.findElement(By.xpath("//*[contains(text(), 'Account Created!')]"));
        accountCreated.isDisplayed();

        WebElement continueT= driver.findElement(By.xpath("//*[contains(text(), 'Continue')]"));
        continueT.click();

        WebElement logan = driver.findElement(By.xpath("//*[contains(text(), 'Logan Happy')]"));
        logan.isDisplayed();

//        WebElement delete= driver.findElement(By.xpath("//a[@href='/delete_account']"));
//        delete.click();
//
//        WebElement verfiyDelete = driver.findElement(By.xpath("//*[contains(text(), 'Account Deleted!')]"));
//        verfiyDelete.isDisplayed();
//
//        WebElement continuel= driver.findElement(By.xpath("//*[contains(text(), 'Continue')]"));
//        continuel.click();

    }
}
