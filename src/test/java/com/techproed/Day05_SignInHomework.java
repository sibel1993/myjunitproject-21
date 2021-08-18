package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class Day05_SignInHomework {

    // Go to http://automationpractice.com/index.php3.
    // Click on sign in button
    // 4.Send your email and click on create an account button
    //5.Verify the Text : CREATE AN ACCOUNT
    //6. Verify the Text : YOUR PERSONAL INFORMATION
    //7. Verify the Text : Title
    // 8. Select your title
    // 9. Enter your first name
    // 10. Enter your last name
    // 11. Enter your email
    // 12. Enter your password
    // 13. DO NOT ENTER DATE OF BIRTH-YOU DIDNT LEARN DROPDOWN YET
    // 14. Click on Sign up for our newsletter!
    // 15. Enter your first name
    // 16. Enter your last lane
    // 17. Enter your company
    // 18. Enter your Address
    // 19. Enter your City
    // 20. DO NOT SELECT STATE-YOU DIDNT LEARN DROPDOWN YET
    // 21. Enter Postal Code
    // 22.DO NOT SELECT COUNTRY-
    // 23. Enter additional information
    // 24. Enter home phone
    // 25. Enter mobile phone
    // 26. Enter reference name
    // 27. Click Register
    // 28. Then verify the error message CONTAINS ‘error'
    WebDriver driver ;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Go to http://automationpractice.com/index.php page
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void test1() throws InterruptedException {
        // Click on sign in button
        WebElement signInButton=driver.findElement(By.partialLinkText("Sign"));
        signInButton.click();
        // 4.Send your email and click on create an account button
       WebElement email=driver.findElement(By.id("email_create"));
        email.sendKeys("BenBilmem@gmail.com");
        //5.Verify the Text : CREATE AN ACCOUNT
        WebElement createAnAccount=driver.findElement(By.xpath("//button[@id='SubmitCreate']"));
        createAnAccount.click();
      ////6. Verify the Text : YOUR PERSONAL INFORMATION
        WebElement myPersonalInformation=driver.findElement(By.xpath("(//h3[@class='page-subheading'])[1]"));
        Assert.assertTrue(myPersonalInformation.isDisplayed());

        //7. Verify the Text : Title
        Thread.sleep(5000);
       WebElement title = driver.findElement(By.xpath("//div[@class='clearfix']/label"));//label[contains(text(), 'Title')]
       Assert.assertEquals("Title",title.getText());

        // 8. Select your title
    WebElement mytitle=driver.findElement(By.id("id_gender2"));
        if(!mytitle.isSelected()){
           mytitle.click();
        }
        // 9. Enter your first name
       driver.findElement(By.id("customer_firstname")).sendKeys("First name ");

        // 10. Enter your last name
       driver.findElement(By.id("customer_lastname")).sendKeys("Last name ");

       //11. Enter your email
        driver.findElement(By.id("email")).sendKeys("BenBilmem@gmail.com");

       // 12. Enter your password
        driver.findElement(By.name("passwd")).sendKeys("Password ");

        //13. DO NOT ENTER DATE OF BIRTH-YOU DIDNT LEARN DROPDOWN YET

        //// 14. Click on Sign up for our newsletter!
        WebElement newsLetterCheckbox = driver.findElement(By.name("newsletter"));
        if(!newsLetterCheckbox.isSelected()){
            newsLetterCheckbox.click();
        }
        // 15. Enter your first name
        driver.findElement(By.id("customer_firstname")).sendKeys("First name ");
        // 16. Enter your last lane
        driver.findElement(By.id("customer_lastname")).sendKeys("Last name ");
        // 17. Enter your company
        driver.findElement(By.id("company")).sendKeys("TechProed");
        // 18. Enter your Address
        driver.findElement(By.id("address1")).sendKeys("My Sweet Street");
        // 19. Enter your City
        driver.findElement(By.id("city")).sendKeys("Oklahoma");
        // 20. DO NOT SELECT STATE-YOU DIDNT LEARN DROPDOWN YET

        //21. Enter Postal Code
        driver.findElement(By.id("postcode")).sendKeys("12345");

        // 22.DO NOT SELECT COUNTRY-

        // 23. Enter additional information
        driver.findElement(By.id("other")).sendKeys("additional information");

        // 24. Enter home phone
        driver.findElement(By.id("phone")).sendKeys("0123456789");

        //// 25. Enter mobile phone
        driver.findElement(By.id("phone_mobile")).sendKeys("0987654321");

        // 26. Enter reference name
        driver.findElement(By.id("alias")).sendKeys("future time");

        // 27. Click Register
        driver.findElement(By.id("submitAccount")).click();

        // 28. Then verify the error message CONTAINS ‘error'
        WebElement errorMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-danger')]"));
        assertTrue(errorMessage.getText().contains("error"));

    }
 }



