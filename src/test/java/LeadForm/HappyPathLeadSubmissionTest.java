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

        setCaseID(44787);
        setCaseComment("Happy path lead submission");

            //driver.get("https://www.stg.openenglish.com/");
            driver.findElement(By.id("firstname-input")).sendKeys(nameRandom);
            driver.findElement(By.id("lastname-input")).sendKeys("placement");
            driver.findElement(By.id("emailaddress-input")).clear();
            emailRandom = "martin.tellechea+"+ randomEmail()+ "@openenglish.com";
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
        assertTrue((verifyMail("martin.tellechea@openenglish.com","trinity110",nameRandom)));
    }

    @Test (priority = 2)
    public void openSalesTool() {
        setCaseID(11111);
        setCaseComment("Loggin in to SF and opening SalesTool");
        driver.get("https://openeducation--stg.cs77.my.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("martin.tellechea@openenglish.com.stg");
        driver.findElement(By.id("password")).sendKeys("trinity112");
        driver.findElement(By.id("Login")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Lead_Tab")));
        //driver.findElement(By.id("Lead_Tab")).click();
        //dropdown = new Select(driver.findElement(By.id("fcf")));
        //dropdown.selectByValue("00Bi0000001HgOJ");
        //driver.findElement(By.name("go")).click();
        driver.findElement(By.id("phSearchInput")).sendKeys("NAMEJSWMII");
        //driver.findElement(By.id("phSearchInput")).click();
        driver.findElement(By.id("phSearchInput")).sendKeys(Keys.RETURN);
        //driver.findElement(By.id("phSearchButton")).click();
        //driver.findElement(By.id("phSearchButton")).click();
       // driver.findElement(By.xpath("//*[@id=\"phSearchButton\"]")).click();
        driver.findElement(By.className("dataCell")).click();


    }
}
