package LearningPlatformLogin;

import BaseMain.BaseMethods;
import BaseTest.CustomTestListener;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomTestListener.class)
public class LearningPlatformLogin extends BaseMethods {

    @BeforeMethod
    public void setUp() throws Exception {

        inizialitation();

    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
        driver.quit();
    }

    @Test
    public void assertLoginForm(){

        setCaseID(44791);
        setCaseComment("Testing cookie values");
        driver.get("https://learningplatform.stg.openenglish.com/login.html");
        String Lang = driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Writing Tool'])[1]/following::h1[1]")).getText();
        System.out.println(Lang);
        String LangCompare = "Welcome";
        if(Lang.equals(LangCompare)){

            System.out.println("si funciono perro");

        }else{
            System.out.println(":( no funciono");
        }



    }



    }








