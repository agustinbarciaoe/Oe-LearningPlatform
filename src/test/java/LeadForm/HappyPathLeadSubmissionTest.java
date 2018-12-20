package LeadForm;

import BaseTest.BaseMain.BaseMethods;
import BaseTest.BaseMain.CustomTestListener;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import BaseTest.BaseMain.EmailUtils;

import javax.mail.Message;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class HappyPathLeadSubmissionTest extends BaseMethods {

    public String emailRandom;
    public static String nameRandom = "NAME" + randomEmail();
    //  WebDriverWait wait = new WebDriverWait(driver, 15);


    @Test(priority = 1)
    public void leadSubmission() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        setCaseID(44787);
        setCaseComment("Happy path lead submission");

        driver.get("https://www.stg.openenglish.com/");
        if (driver.findElement(By.id("cn-accept-cookie")).isDisplayed())
            try {
                driver.findElement(By.id("cn-accept-cookie")).click();
            } catch (Exception e) {
                if (e.getMessage().contains("is not clickable at point")) {

                }
            }


        driver.findElement(By.id("firstname-input")).sendKeys(nameRandom);
        driver.findElement(By.id("lastname-input")).sendKeys("TestName");
        driver.findElement(By.id("emailaddress-input")).clear();
        emailRandom = "tester.openenglish+" + nameRandom + "@gmail.com";
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

    @Test(priority = 2)
    public void openSalesTool() throws InterruptedException {
        setCaseID(11111);
        setCaseComment("Loggin in to SF and confirm license purchase");
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
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        //driver.findElement(By.id("phSearchInput")).click();
        driver.findElement(By.id("phSearchInput")).sendKeys(Keys.RETURN);
        while (isElementPresent(By.cssSelector(".messageText"))) {
            driver.findElement(By.id("secondSearchText")).sendKeys(nameRandom);
            driver.findElement(By.id("secondSearchButton")).click();
        }

         /*
        if (driver.findElement(By.cssSelector(".messageText"))) {
            while (driver.findElement(By.cssSelector(".messageText")).isEnabled()) {
                driver.findElement(By.id("secondSearchText")).sendKeys(nameRandom);
                driver.findElement(By.id("secondSearchButton")).click();
            }
        }
        */

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dataCell")));
        //driver.findElement(By.id("phSearchButton")).click();
        //driver.findElement(By.id("phSearchButton")).click();
        // driver.findElement(By.xpath("//*[@id=\"phSearchButton\"]")).click();
        driver.findElement(By.className("dataCell")).click();
        driver.findElement(By.name("sales_tool")).click();
        driver.findElement(By.id("btnSelecta0D0t000001mxWbEAI")).click(); //SELECT DISCOUNT
        driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id228:0:j_id245:0:cmdProcess")).click(); // ADD
//        driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id338")).click(); // CHECKBOX "Assign a license to the buyer"
        if (!driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id352")).isSelected())
            driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id352")).click();
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
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        //driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/div[2]/div[3]/div[1]/label")).click(); // Accept Terms
        //driver.findElement(By.xpath("//*[@id=\"contract-checkboxes\"]/div[1]/label")).click();
        //driver.findElement(By.cssSelector("#checkboxAgree")).click();

        //Actions actions = new Actions(driver);
        //actions.click(driver.findElement(By.cssSelector("#checkboxAgree"))).perform();
        //actions.click(driver.findElement(By.cssSelector("#checkbox0"))).perform();
        WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxAgree"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#checkbox0"));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", checkbox1);
        js.executeScript("arguments[0].click()", checkbox2);

        //WebElement element = driver.findElement(By.className("ng-binding"));//div[@class='blockUI blockOverlay']");
        //JavascriptExecutor js = (JavascriptExecutor)driver;
        //js.executeScript("arguments[0].style.visibility='hidden'", element);

        //driver.findElement(By.name("checkboxAgree")).click();
        //driver.findElement(By.cssSelector("div.checkbox:nth-child(2) > label:nth-child(2)")).click();
        // driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/form/div[2]/div[3]/div[2]/label")).click(); // Term of Course
        Thread.sleep(5000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("submitBtn")));
        js.executeScript("arguments[0].click()", driver.findElement(By.id("submitBtn")));
        //driver.findElement(By.id("submitBtn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa-check"))); // Checkbox OK
        //wait.until(driver.findElement(By.cssSelector(".success-poll")).isDisplayed());
        //String bodyText = driver.findElement(By.tagName("body")).getText();
        // Assert.assertTrue("Text not found!", bodyText.contains(text));

        //assertTrue(driver.findElement(By.id("submitBtn")).getText().contains("SUBMIT PAYMENT"));
        //driver.findElement(By.name("j_id0:stco:j_id217:mainForm:j_id370")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.name("j_id0:stco:j_id217:mainForm:j_id384")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("zuora__sync_data_from_zbilling")));
        driver.findElement(By.name("zuora__sync_data_from_zbilling")).click();
    }

    @Test(priority = 3)
    public void loginToPlatform() {

        setCaseID(22222);
        setCaseComment("Loggin in to OE Platform");
        //WebDriverWait wait = new WebDriverWait(driver, 60);

        driver.get("http://learningplatform.stg.openenglish.com/");
        driver.findElement(By.id("login-email")).sendKeys(emailRandom);


    }

    @Test(priority = 4)
    public void verifyRegistrationEmail() throws InterruptedException {
        setCaseID(44787);
        setCaseComment("Verifying Thank You email arrived");

        System.out.println(nameRandom);
/*
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        */
        assertTrue((verifyMailSubject("tester.openenglish@gmail.com", "trinity110", nameRandom)));
        //assertTrue((verifyMailSubject("pepe@mailsac.com", null, nameRandom)));

    }

    @Test(priority = 5)
    public void verifyPurchaseEmail() throws InterruptedException {
        setCaseID(44789);
        setCaseComment("Verifying Purchase confirmation email arrived");
        System.out.println(nameRandom);

        try { Thread.sleep(10000);}
        catch (InterruptedException ex) {Thread.currentThread().interrupt();        }

        assertTrue((verifyMailContent("tester.openenglish@gmail.com", "trinity110", "Hello " + nameRandom, "Congratulations on your purchase of Open English!")));
        //assertTrue((verifyMailContent("pepe@mailsac.com", null , "Hello " + nameRandom, "We are writing to confirm the purchase of your course")));
    }

    @Test(priority = 6)
    public void verifyActivationEmail() throws InterruptedException {
        setCaseID(44789);
        setCaseComment("Verifying Activation email arrived");
        System.out.println(nameRandom);

        try { Thread.sleep(10000);}
        catch (InterruptedException ex) {Thread.currentThread().interrupt();        }

        assertTrue((verifyMailContent("tester.openenglish@gmail.com", "trinity110", "Hola " + nameRandom, "Bienvenido a Open English")));
        //assertTrue((verifyMailContent("pepe@mailsac.com", null , "Hello " + nameRandom, "We are writing to confirm the purchase of your course")));
    }

    @Test (priority = 7)
    public void ActivateLicense() {
        setCaseID(33333);
        setCaseComment("Activating license using link from email");

        System.out.println(nameRandom);

        String activationLink = getActivationLink("tester.openenglish@gmail.com", "trinity110", "Hola " + nameRandom, "Bienvenido a Open English");

        System.out.println("Link de activación: "+activationLink);



        //assertTrue((verifyMailContent("tester.openenglish@gmail.com", "trinity110", "Hello " + nameRandom, "We are writing to confirm the purchase of your course")));
        //assertTrue((verifyMailContent("pepe@mailsac.com", null , "Hello " + nameRandom, "We are writing to confirm the purchase of your course")));

    }


}

