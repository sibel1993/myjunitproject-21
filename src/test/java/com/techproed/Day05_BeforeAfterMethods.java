package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day05_BeforeAfterMethods {
    // Create a class: BeforeAfterMethods 
    //  Then create 3 different test methods using the following names. And Go to google. 
    // titleTest =>Verify if google title = “Google” 
    // imageTest => Verify if google image displays or not 
    // gmailLinkTest => Verify if the Gmail link is displayed or not
    //  Close the browser after each test

    // need 3 different test cases .i will use 3 @Test annotation
    //what is repeating before each test case
    //create driver at the class level
    WebDriver driver;
    @Before
    public  void setUp(){
        //Setting up choreme driver
        WebDriverManager.chromedriver().setup();
        //creating driver
        driver = new ChromeDriver();
        //maximizing window
        driver.manage().window().maximize();
        //putting 5 second wait on the driver ,this wiill wait up to 5 second WHEN WE NEED this will NOT NEEDED
        //For example ,if the page is slow ,the driver will wait up to 5 seconds
        //IMPLICIT IS DYNAMIC WAIT AND WE SHOULD USE THIS
        //
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //Thread.sleep(5000); this will wait 5 seconds even if NOT NEEDED .it will always
        //put 5 seconds wait THIS IS HARD WAIT THAT WE SHOULD NOT USE IN OUR CODE
        //USING Thread.sleep makes execution longer due to the unnecessary extra waits
        driver.get("https://www.google.com");

    }
    @Test
    public void titleTest() throws InterruptedException {

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

      }
    @Test
    public void imageTest(){

        WebElement googleImage=driver.findElement(By.xpath("//a[@data-pid='23']"));
        Assert.assertTrue(googleImage.isDisplayed());


    }
    @Test
    public void gmaillinkset(){


        WebElement gmailLink=driver.findElement(By.xpath("(//a[@class='gb_f'])[1]"));
        Assert.assertTrue(gmailLink.isDisplayed());

    }
    //what is repeating after each method
    //we use @after method to move those repeated codes
    @After
    public void tearDown(){
        driver.quit();
    }

    }

