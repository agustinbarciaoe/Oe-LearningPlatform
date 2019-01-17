package LeadForm;

import BaseMain.BaseMethods;
import BaseMain.CustomTestListener;

import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class HappyPathLeadSubmissionTest extends BaseMethods {

//    public static String nameRandom = "NAME" + randomEmail();
 //   public static String emailRandom = "tester.openenglish+" + nameRandom + "@gmail.com";


    //  WebDriverWait wait = new WebDriverWait(driver, 15);


    /*
    @Test
    public void A_leadSubmission() throws InterruptedException {



        if (!caseIDs.contains("39742")) throw new SkipException("Skipping this testCase: 39742");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);

            WebDriverWait wait = new WebDriverWait(driver, 30);

            setCaseID(39742);
            setCaseComment("Happy path lead submission");

            driver.get("https://www.stg.openenglish.com");
           /*
            if (driver.findElement(By.id("cn-accept-cookie")).isDisplayed())
                try {
                    driver.findElement(By.id("cn-accept-cookie")).click();
                } catch (Exception e) {
                    if (e.getMessage().contains("is not clickable at point")) {

                    }
                }
            */
/*
            driver.findElement(By.id("firstname-input")).sendKeys(nameRandom);
            driver.findElement(By.id("lastname-input")).sendKeys("TestName");
            driver.findElement(By.id("emailaddress-input")).clear();

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
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id("submit-button")));
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(250, 350)");
            driver.findElement(By.id("submit-button")).click();
            assertTrue(driver.findElement(By.id("thankyou-hero-title")).getText().contains("Gracias por dar el primer paso para lograr tu objetivo"));
            //driver.wait(10);
            // verifyMail(emailRandom,"trinity110","cómo funciona");

    }
    */

    @Test
    public void B_loginToSF(){
        if (!caseIDs.contains("41218")) throw new SkipException("Skipping this testCase: 41218");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
        setCaseID(41218);
        setCaseComment("Loggin in to SF");

        SF_Login objSF_Login = new SF_Login(driver);
        SF_Home objSF_Home = new SF_Home(driver);

        objSF_Login.loginToSF("martin.tellechea@openenglish.com.stg", "trinity112");
        System.out.println(objSF_Home.getProfileBox().getText());
        assertTrue(objSF_Home.getProfileBox().getText().contains("Martin Tellechea"));
  }

  @Test
  public void C_searchContact() throws InterruptedException {
      if (!caseIDs.contains("41219")) throw new SkipException("Skipping this testCase: 41219");
      setClassName(this.getClass().getSimpleName());
      setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
      System.out.println("Begin Test class: "+className+", Test Method: "+testName);
      setCaseID(41219);
      setCaseComment("Search Contact");

      SF_Home objSF_Home = new SF_Home(driver);
      SF_ContactPage objSF_ContactPage = new SF_ContactPage(driver);

      //nameRandom="NAMEGOLXCG";
      objSF_Home.searchContact(nameRandom);
      objSF_ContactPage.getContactHeader();
      assertTrue(objSF_ContactPage.getContactHeader().isDisplayed());

  }

  @Test
  public void D_purchaseSalesTool() throws InterruptedException {
      if (!caseIDs.contains("41158")) throw new SkipException("Skipping this testCase: 41158");

      setClassName(this.getClass().getSimpleName());
      setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
      System.out.println("Begin Test class: "+className+", Test Method: "+testName);
      setCaseID(41158);
      setCaseComment("Purchase in SalesTool");

      WebDriverWait wait = new WebDriverWait(driver, 60);

      //nameRandom="NAMETPTFSI";
      SF_ContactPage objSF_ContactPage = new SF_ContactPage(driver);
      SF_Home objSF_Home = new SF_Home(driver);

      objSF_Home.searchContact(nameRandom);

      objSF_ContactPage.goToSalesTool();
      objSF_ContactPage.makePurchase(nameRandom);


  }

/*
    @Test
    public void B_openSalesTool() throws InterruptedException {
        if (!caseIDs.contains("41158")) throw new SkipException("Skipping this testCase: 41158");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
            setCaseID(41158);
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
            //driver.findElement(By.id("phSearchInput")).sendKeys("NAMEEBIOSS");
            TimeUnit.SECONDS.sleep(5);
            try {
                Thread.sleep(15000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            //driver.findElement(By.id("phSearchInput")).click();
            driver.findElement(By.id("phSearchInput")).sendKeys(Keys.RETURN);
            while (isElementPresent(By.cssSelector(".messageText"))) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("secondSearchText")));
                driver.findElement(By.id("secondSearchText")).clear();
                driver.findElement(By.id("secondSearchText")).sendKeys(nameRandom);
//            driver.findElement(By.id("secondSearchButton")).click();
                driver.findElement(By.id("secondSearchText")).sendKeys(Keys.RETURN);
            }

         /*
        if (driver.findElement(By.cssSelector(".messageText"))) {
            while (driver.findElement(By.cssSelector(".messageText")).isEnabled()) {
                driver.findElement(By.id("secondSearchText")).sendKeys(nameRandom);
                driver.findElement(By.id("secondSearchButton")).click();
            }
        }
        */
/*
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dataCell")));
            //driver.findElement(By.id("phSearchButton")).click();
            //driver.findElement(By.id("phSearchButton")).click();
            // driver.findElement(By.xpath("//*[@id=\"phSearchButton\"]")).click();
            driver.findElement(By.className("dataCell")).click();
            driver.findElement(By.name("sales_tool")).click();
            driver.findElement(By.id("btnSelecta0D0t000000smvmEAA")).click(); //SELECT DISCOUNT
        driver.findElement(By.id("j_id0:frmConditions:cmdOrgOEBlue")).sendKeys(Keys.PAGE_DOWN);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id231:1:j_id248:0:cmdProcess")));
       driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id231:1:j_id248:0:cmdProcess")).click(); // ADD

            //driver.findElement(By.)
//        driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id338")).click(); // CHECKBOX "Assign a license to the buyer"
            if (!driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id355")).isSelected())

                driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id355")).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id372")));
            driver.findElement(By.id("j_id0:stco:j_id217:mainForm:j_id372")).click(); // CONFIRM

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
            Thread.sleep(10000);
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(250, 350)");
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector(".fa-check")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fa-check"))); // Checkbox OK
            //wait.until(driver.findElement(By.cssSelector(".success-poll")).isDisplayed());
            //String bodyText = driver.findElement(By.tagName("body")).getText();
            // Assert.assertTrue("Text not found!", bodyText.contains(text));

            //assertTrue(driver.findElement(By.id("submitBtn")).getText().contains("SUBMIT PAYMENT"));
            //driver.findElement(By.name("j_id0:stco:j_id217:mainForm:j_id370")).click();
            driver.switchTo().defaultContent();
            driver.findElement(By.name("j_id0:stco:j_id217:mainForm:j_id396")).click();// FINISH
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("zuora__sync_data_from_zbilling")));
            driver.findElement(By.name("zuora__sync_data_from_zbilling")).click();


    }
*/


        //List<String> testIDs = new ArrayList<String >();


        // return runID;


}

