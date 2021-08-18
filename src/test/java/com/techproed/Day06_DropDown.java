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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day06_DropDown {
    //Go to https://the-internet.herokuapp.com/dropdown
//1.Create method selectByIndexTest and Select and Print Option 1 using index
//2.Create method selectByValueTest Select and Print Option 2 by value
//3.Create method selectByVisibleTextTest Select and Print Option 1 value by visible text
//4.Create method printAllTest Print all dropdown value
//5.Create method printFirstSelectedOptionTest Print first selected option
//6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.

    WebDriver driver;
   @Before
   public void setUp() {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       //Go to http://automationpractice.com/index.php page
       driver.get("https://the-internet.herokuapp.com/dropdown");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }
   @Test
    public void selectByIndexTest(){
       //locating the select the dropdown element
       WebElement dropDownElement=driver.findElement(By.id("dropdown"));
       //step2:use select class to control the dropdown object
       Select select=new Select(dropDownElement);
       //step3: i can now select any option by three different ways
       //selectByValue,selectByIndex,selectByVisibleText()
       select.selectByIndex(1);


   }
   @Test
    public void selectByValueTest() throws InterruptedException {
       //2.Create method selectByValueTest Select and Print Option 2 by value
       //locating the select the dropdown element
       WebElement dropDownElement=driver.findElement(By.id("dropdown"));
       //step2:use select class to control the dropdown object
       Select select=new Select(dropDownElement);
       Thread.sleep(50000);
       select.selectByValue("2");
       Thread.sleep(5000);



   }
   @Test
   public void selectByVisibleText() throws InterruptedException {
       //3.Create method selectByVisibleTextTest Select and Print Option 1 value by visible text
       //locating the select the dropdown element
       WebElement dropDownElement=driver.findElement(By.id("dropdown"));
       //step2:use select class to control the dropdown object
       Select select=new Select(dropDownElement);
       Thread.sleep(50000);
       select.selectByVisibleText("Option 1");
       Thread.sleep(50000);

   }
   @Test
   public  void printAll(){
       //4.Create method printAllTest Print all dropdown value
       //locating the select the dropdown element
       WebElement dropDownElement=driver.findElement(By.id("dropdown"));
       //step2:use select class to control the dropdown object
       Select select=new Select(dropDownElement);

      List<WebElement> allOptions=select.getOptions();
      for(WebElement each: allOptions){
          System.out.println(each.getText());
      }

   }
   @Test
   public void printFirstSelectedOptions(){
       //5.Create method printFirstSelectedOptionTest Print first selected option
       //locating the select the dropdown element
       WebElement dropDownElement=driver.findElement(By.id("dropdown"));
       //step2:use select class to control the dropdown object
       Select select=new Select(dropDownElement);
     String selectedOption=select.getFirstSelectedOption().getText();
       //getFirstSelectedOption(); returns selected option as web element
       System.out.println(selectedOption);

   }
   @Test
   public void dropDownSizeTest(){
       //6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.
       //locating the select the dropdown element
       WebElement dropDownElement=driver.findElement(By.id("dropdown"));
       //step2:use select class to control the dropdown object
       Select select=new Select(dropDownElement);
       int numberOfOptions=select.getOptions().size();
       Assert.assertEquals("Expected is not equal actual",4,numberOfOptions);

   }
   @After
    public void tearDown(){
       driver.quit();
   }
   /*
   *FLOW
   * @Before  -> selectByVisibleText->@After
   * ->@Before ->selectByIndexText
   *
    */
}
