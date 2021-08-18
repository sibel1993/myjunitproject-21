import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ComplateSignInHomework {
    //https://files.slack.com/files-pri/T01HX4GLWRM-F023H3N52TX/image.png
    //CLICK ON SIGN IN
    //ENTER EMAIL AND CLICK CREATE AN ACCOUNT
    //ENTER ALL REQUIRET FIELDS
    //THEN VERIFY "MY ACCOUNT" ON HOMEPAGE
    //USE FAKE DATA USING JAVAFAKER CLASS IF NEEDED
    WebDriver driver;
    Faker faker;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(500);

    }
    @Test
    public void SignIn() throws InterruptedException {
        Faker faker = new Faker();
        WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
        signIn.click();
        //ENTER EMAIL AND CLICK CREATE AN ACCOUNT
        WebElement createAccount=driver.findElement(By.id("email_create"));
        createAccount.sendKeys(faker.name().firstName()+ "@gggg.com");
        createAccount.submit();
        //ENTER ALL REQUIRET FIELDS
       //gender
        Thread.sleep(2000);
        WebElement yourTitle = driver.findElement(By.xpath("//input[@value='2']"));
        yourTitle.click();
        //firstname
        driver.findElement(By.id("customer_firstname")).sendKeys(faker.name().firstName());
        //lastname
        driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());
        //password
        driver.findElement(By.id("passwd")).sendKeys(faker.phoneNumber().cellPhone());
        //DAY
        //Day
        Thread.sleep(500);
        WebElement days = driver.findElement(By.id("days"));
        Select day = new Select(days);
        day.selectByValue("30");
        //month
        Thread.sleep(5000);
        WebElement months=driver.findElement(By.id("months"));
        Select month=new Select(months);
        month.selectByValue("10");
        //year
        WebElement years=driver.findElement(By.id("years"));
        Select year=new Select(years);
        year.selectByValue("1995");
        //FIRSTNAME
        driver.findElement(By.id("customer_firstname")).sendKeys(faker.name().firstName());
        //LASTNAME
        driver.findElement(By.id("customer_lastname")).sendKeys(faker.name().lastName());

        //ADDRESS
        driver.findElement(By.name("address1")).sendKeys(faker.address().fullAddress());

        //CITY
        driver.findElement(By.id("city")).sendKeys(faker.address().city());

        //STATE
        WebElement states = driver.findElement(By.id("id_state"));
        Select state = new Select(states);
        state.selectByValue("30");
        //ZIP CODE
        driver.findElement(By.id("postcode")).sendKeys("08976");
        //mobile Phone
        driver.findElement(By.name("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());
        //Register
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

        WebElement myaccount = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(myaccount.getText().contains("MY ACCOUNT"));
        System.out.println("We are all good");



    }

}
