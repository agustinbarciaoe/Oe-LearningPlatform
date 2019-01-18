package LeadForm;

import BaseMain.BaseMethods;
import BaseMain.CustomTestListener;

import Pages.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class SalesforceTest extends BaseMethods {


    @Test
    public void B_loginToSF_C41218(){
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
  public void C_searchContact_C41219() throws InterruptedException {
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
    public void D_purchaseSalesTool_C41158() throws InterruptedException {
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
        objSF_ContactPage.makePurchase(nameRandom, true);

    }

    @Test
    public void D_purchaseSalesTool_C41258() throws InterruptedException {
        if (!caseIDs.contains("41258")) throw new SkipException("Skipping this testCase: 41258");
        setCaseID(41258);
        setCaseComment("Purchase in SalesTool");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);

        WebDriverWait wait = new WebDriverWait(driver, 60);

        //nameRandom="NAMETPTFSI";
        SF_ContactPage objSF_ContactPage = new SF_ContactPage(driver);
        SF_Home objSF_Home = new SF_Home(driver);

        objSF_Home.searchContact(nameRandom);

        objSF_ContactPage.goToSalesTool();
        objSF_ContactPage.makePurchase(nameRandom, false);

    }
}

