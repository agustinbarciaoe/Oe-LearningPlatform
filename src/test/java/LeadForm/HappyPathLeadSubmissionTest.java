package LeadForm;

import BaseTest.BaseMain.BaseMethods;
import BaseTest.BaseMain.CustomTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class HappyPathLeadSubmissionTest extends BaseMethods {

    public String emailRandom;
    public static String nameRandom = "NAME"+randomEmail();



    @Test
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
    @Test
    public void verifyRegistrationEmail() throws InterruptedException {
        System.out.println(nameRandom);
        assertTrue((verifyMail("martin.tellechea@openenglish.com","trinity110",nameRandom)));
    }
}
