
package LearningPlatformLogin;

import BaseMain.BaseMethods;
import BaseMain.CustomTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomTestListener.class)
public class LearningPlatformLoginTest extends BaseMethods {


    @Test
    public void assertEnLoginForm(){
        String caseID = "41201";
        if (!caseIDs.contains(caseID)) throw new SkipException("Skipping this testCase: "+caseID);

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
        setCaseID(41201);
        setCaseComment("Testing cookie values");
        setLangCookieName("NLS");
        setLangCookieValue("en");
        Cookie ck = new Cookie(ckName, ckValue);
        driver.get("https://learningplatform.stg.openenglish.com/login.html");
        driver.manage().addCookie(ck);
        driver.get("https://learningplatform.stg.openenglish.com/login.html");

            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login-holder\"]/lp2-login-page/lp2-login-box/div/div/h1")).getText(), "Welcome");
            Assert.assertTrue(driver.findElement(By.id("login-email")).getAttribute("placeholder").contains("Email"));
            Assert.assertTrue(driver.findElement(By.id("login-password")).getAttribute("placeholder").contains("Password"));
            Assert.assertTrue(driver.findElement(By.id("login-submit")).getText().matches("Log In"));
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login-holder\"]/lp2-login-page/lp2-login-box/div/div/div/form/div[3]/div/label")).getText(), "Remember Me");
            Assert.assertTrue(driver.findElement(By.linkText("Password Reset")).getText().contains("Password Reset"));
            Assert.assertEquals(driver.findElement(By.linkText("Password Reset")).getAttribute("href"), "https://learningplatform.stg.openenglish.com/recovery.html");
            Assert.assertTrue(driver.findElement(By.linkText("Sign Up")).getText().matches("Sign Up"));
            Assert.assertTrue(driver.findElement(By.linkText("Sign Up")).getAttribute("href").matches("http://www.openenglish.com/en"));

        }
    @Test
    public void assertEsLoginForm(){
        String caseID = "41202";
        if (!caseIDs.contains(caseID)) throw new SkipException("Skipping this testCase: "+caseID);

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
        setCaseID(41202);
        setCaseComment("Testing cookie values");
        setLangCookieName("NLS");
        setLangCookieValue("es");
        Cookie ck = new Cookie(ckName, ckValue);
        driver.get("https://learningplatform.stg.openenglish.com/login.html");
        driver.manage().addCookie(ck);
        driver.get("https://learningplatform.stg.openenglish.com/login.html");

            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login-holder\"]/lp2-login-page/lp2-login-box/div/div/h1")).getText(), "Bienvenido");
            Assert.assertTrue(driver.findElement(By.id("login-email")).getAttribute("placeholder").contains("Email"));
            Assert.assertTrue(driver.findElement(By.id("login-password")).getAttribute("placeholder").contains("Contraseña"));
            Assert.assertTrue(driver.findElement(By.id("login-submit")).getText().matches("Iniciar sesión"));
            Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login-holder\"]/lp2-login-page/lp2-login-box/div/div/div/form/div[3]/div/label")).getText(), "Recordar mis datos");
            Assert.assertEquals(driver.findElement(By.linkText("Reestablecer contraseña")).getAttribute("href"), "https://learningplatform.stg.openenglish.com/recovery.html");
            Assert.assertTrue(driver.findElement(By.linkText("Inscríbete")).getText().matches("Inscríbete"));
            Assert.assertTrue(driver.findElement(By.linkText("Inscríbete")).getAttribute("href").matches("http://www.openenglish.com/es/"));

    }







    }












