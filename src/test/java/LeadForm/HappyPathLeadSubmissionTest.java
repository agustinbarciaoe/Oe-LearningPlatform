package LeadForm;

import BaseTest.BaseMain.BaseMethods;
import BaseTest.BaseMain.CustomTestListener;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class HappyPathLeadSubmissionTest extends BaseMethods {

    public String emailRandom;
    public static String nameRandom = "NAME"+randomEmail();
  //  WebDriverWait wait = new WebDriverWait(driver, 15);



    @Test (priority=0)
    public void leadSubmission() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        setCaseID(44787);
        setCaseComment("Happy path lead submission");

            driver.get("https://www.stg.openenglish.com/");
            if (driver.findElement(By.id("cn-accept-cookie")).isDisplayed())
                driver.findElement(By.id("cn-accept-cookie")).click();
            driver.findElement(By.id("firstname-input")).sendKeys(nameRandom);
            driver.findElement(By.id("lastname-input")).sendKeys("TestName");
            driver.findElement(By.id("emailaddress-input")).clear();
            emailRandom = "martin.tellechea+"+ nameRandom+ "@openenglish.com";
            //driver.findElement(By.id("emailaddress-input")).sendKeys("agustin.barcia+" + randomEmail() + "@openenglish.com");
            driver.findElement(By.id("emailaddress-input")).sendKeys(emailRandom);
            //driver.findElement(By.id("country-select"));
            dropdown = new Select(driver.findElement(By.id("country-select")));
            dropdown.selectByValue("ar");
            //driver.findElement(By.id("state-select"));
            dropdown = new Select(driver.findElement(By.id("state-select")));
            TimeUnit.SECONDS.sleep(3);
            dropdown.selectByValue("178");
            driver.findElement(By.id("city-select"));
            dropdown = new Select(driver.findElement(By.id("city-select")));
            TimeUnit.SECONDS.sleep(3);
            dropdown.selectByValue("245");
            driver.findElement(By.xpath("//*[@id=\"phone-format-selector\"]/label[1]")).click();
            driver.findElement(By.xpath("//*[@id=\"phone-inputs\"]/input[3]")).sendKeys("2222");
            driver.findElement(By.xpath("//*[@id=\"phone-inputs\"]/input[4]")).sendKeys("2222");
            driver.findElement(By.xpath("//*[@id=\"isforme-radio\"]/label[1]")).click();
            driver.findElement(By.id("agerange-select"));
            dropdown = new Select(driver.findElement(By.id("agerange-select")));
            dropdown.selectByValue("4");
           // if (driver.findElement(By.id("cn-accept-cookie")).isEnabled())
           //     driver.findElement(By.id("cn-accept-cookie")).click();
            TimeUnit.SECONDS.sleep(3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit-button")));
            driver.findElement(By.id("submit-button")).click();
            assertTrue(driver.findElement(By.id("thankyou-hero-title")).getText().contains("Gracias por dar el primer paso para lograr tu objetivo"));
            //driver.wait(10);
           // verifyMail(emailRandom,"trinity110","cómo funciona");
        }



    @Test (priority = 1)
    public void verifyRegistrationEmail() throws InterruptedException {
        setCaseID(44787);
        setCaseComment("Verifying Thank You email arrived");

        System.out.println(nameRandom);

        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        assertTrue((verifyMailSubject("martin.tellechea@openenglish.com","trinity110",nameRandom)));
    }

    @Test (priority = 2)
    public void openSalesTool() throws InterruptedException {
        setCaseID(11111);
        setCaseComment("Loggin in to SF and opening SalesTool until CC input");
        WebDriverWait wait = new WebDriverWait(driver, 60);

        driver.get("https://openeducation--stg.cs77.my.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("martin.tellechea@openenglish.com.stg");
        driver.findElement(By.id("password")).sendKeys("trinity112");
        driver.findElement(By.id("Login")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Lead_Tab")));
        //driver.findElement(By.id("Lead_Tab")).click();
        //dropdown = new Select(driver.findElement(By.id("fcf")));
        //dropdown.selectByValue("00Bi0000001HgOJ");
        //driver.findElement(By.name("go")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phSearchInput")));
        driver.findElement(By.id("phSearchInput")).sendKeys(nameRandom);
        TimeUnit.SECONDS.sleep(5);
        try { Thread.sleep(10000);}
            catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        //driver.findElement(By.id("phSearchInput")).click();
        driver.findElement(By.id("phSearchInput")).sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dataCell")));
        //driver.findElement(By.id("phSearchButton")).click();
        //driver.findElement(By.id("phSearchButton")).click();
        // driver.findElement(By.xpath("//*[@id=\"phSearchButton\"]")).click();
        driver.findElement(By.className("dataCell")).click();
          driver.findElement(By.name("sales_tool")).click();
        driver.findElement(By.id("btnSelecta0D0t000001mxWbEAI")).click(); //SELECT DISCOUNT
        driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id228:0:j_id245:0:cmdProcess")).click(); // ADD
//        driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id338")).click(); // CHECKBOX "Assign a license to the buyer"
        driver.findElement(By.id("j_id0:stco:j_id217:mainForm:cmdProcess")).click(); // CONFIRM

        driver.switchTo().frame(driver.findElement(By.id("immediateCapture_iframe")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("numberInput")));
        driver.findElement(By.id("numberInput")).sendKeys("4012 8888 8888 1881");
        driver.findElement(By.id("expirationInput")).sendKeys("01/2025");
        driver.findElement(By.id("nameInput")).sendKeys(nameRandom);
        driver.findElement(By.id("securityCodeInput")).sendKeys("888");
        driver.findElement(By.id("documentNoInput")).sendKeys("25598000");
        driver.findElement(By.id("documentNoInput")).sendKeys(Keys.TAB);
        driver.findElement(By.id("contractHolderNameInput")).sendKeys(nameRandom);

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.id("immediateCapture_iframe")));

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-binding")));
        try { Thread.sleep(20000);}
        catch(InterruptedException ex) {Thread.currentThread().interrupt();}
        //driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/div[2]/div[3]/div[1]/label")).click(); // Accept Terms
        //driver.findElement(By.xpath("//*[@id=\"contract-checkboxes\"]/div[1]/label")).click();
        driver.findElement(By.cssSelector("div.checkbox:nth-child(1) > label:nth-child(2)")).click();
        driver.findElement(By.cssSelector("div.checkbox:nth-child(2) > label:nth-child(2)")).click();
       // driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/div[2]/div[3]/div[2]/label")).click(); // Term of Course
        driver.findElement(By.id("submitBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa-check"))); // Checkbox OK
        //wait.until(driver.findElement(By.cssSelector(".success-poll")).isDisplayed());
        //String bodyText = driver.findElement(By.tagName("body")).getText();
       // Assert.assertTrue("Text not found!", bodyText.contains(text));

        //assertTrue(driver.findElement(By.id("submitBtn")).getText().contains("SUBMIT PAYMENT"));
        //driver.findElement(By.name("j_id0:stco:j_id217:mainForm:j_id370")).click();
        driver.switchTo().defaultContent();
    }

    @Test (priority = 3)
        public void verifyPurchaseEmail() throws InterruptedException {
            setCaseID(44789);
            setCaseComment("Verifying Purchase confirmation email arrived");
            System.out.println(nameRandom);

        try
        {
            Thread.sleep(30000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
            assertTrue((verifyMailContent("martin.tellechea@openenglish.com","trinity110","Hello "+nameRandom,"We are writing to confirm the purchase of your course")));
        }


    }

