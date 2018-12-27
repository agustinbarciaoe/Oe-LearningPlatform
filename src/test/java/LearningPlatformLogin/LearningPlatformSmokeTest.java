/*
package LearningPlatformLogin;

import BaseTest.BaseMain.BaseMethods;
import BaseTest.BaseMain.CustomTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomTestListener.class)
public class LearningPlatformSmokeTest extends BaseMethods {



    @Test(priority = 1)
    public void loginToPlatform() {

        setCaseID(22222);
        setCaseComment("Loggin in to OE Platform");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get("http://learningplatform.stg.openenglish.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email")));
        driver.findElement(By.id("login-email")).sendKeys("tester.openenglish+namehlxuig@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("morpheus110");
        driver.findElement(By.id("login-password")).sendKeys(Keys.RETURN);
        Assert.assertTrue(driver.findElement(By.id("level-progress")).isDisplayed());
    }

    @Test (priority = 2)
    public void verifyLesson() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 20);

        driver.get("http://learningplatform.stg.openenglish.com/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-email")));
        driver.findElement(By.id("login-email")).sendKeys("tester.openenglish+namehlxuig@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("morpheus110");
        driver.findElement(By.id("login-password")).sendKeys(Keys.RETURN);

        JavascriptExecutor js = (JavascriptExecutor) driver;



        String linkText ="How Are You";

        WebElement Element = driver.findElement(By.partialLinkText(linkText));
        js.executeScript("arguments[0].scrollIntoView();", Element);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(linkText)));
        Element.click();

       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[1]/div/div[1]/div/div/button")));

        driver.switchTo().frame(driver.findElement(By.id("lesson")));

        driver.findElement(By.cssSelector(".continue")).click();
        driver.findElement(By.id("mep_0")).click();
        Thread.sleep(1000);
        String tiempoTranscurrido = driver.findElement(By.id("player0")).getAttribute("currentTime");
        System.out.println(tiempoTranscurrido);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/lp2-study-bundle/div/lp2-live-class-carousel/div/lp2-carousel/div/div[1]/div/div[1]/lp2-live-class-tile/a/div[1]/div/div/button")));
        driver.findElement(By.xpath("/html/body/div[1]/lp2-study-bundle/div/lp2-live-class-carousel/div/lp2-carousel/div/div[1]/div/div[1]/lp2-live-class-tile/a/div[1]/div/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/lp2-study-bundle/div/lp2-live-class-carousel/div/lp2-carousel/div/div[1]/div/div[1]/lp2-live-class-tile/a/div[1]/div/div/div[2]/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/lp2-study-bundle/div/lp2-live-class-carousel/div/lp2-carousel/div/div[1]/div/div[1]/lp2-live-class-tile/a/div[1]/div/div/div/button")));
        driver.findElement(By.xpath("/html/body/div[1]/lp2-study-bundle/div/lp2-live-class-carousel/div/lp2-carousel/div/div[1]/div/div[1]/lp2-live-class-tile/a/div[1]/div/div/div/button"));
        driver.findElement(By.cssSelector(".confirm"));



    }

}

*/