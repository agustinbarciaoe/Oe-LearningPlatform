package LeadForm;

import BaseMain.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class EmailValidations extends BaseMethods {

    @Test
    public void E_verifyThankYouEmail_C39743() throws InterruptedException {

        if (!caseIDs.contains("39743")) throw new SkipException("Skipping this testCase: 39743");
        setCaseID(39743);
        setCaseComment("Verifying Thank You email arrived");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);


        System.out.println(nameRandom);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        assertTrue((verifyMailSubject("tester.openenglish@gmail.com", "trinity110", nameRandom + ", cómo funciona Open English")));
        //assertTrue((verifyMailSubject("pepe@mailsac.com", null, nameRandom)));


    }


    @Test
    public void E_verifyThankYouEmail_C41228() throws InterruptedException {

        if (!caseIDs.contains("41228")) throw new SkipException("Skipping this testCase: 41228");
        setCaseID(41228);
        setCaseComment("Verifying Thank You email arrived");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);

        System.out.println(nameRandom);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        assertTrue((verifyMailContent("tester.openenglish@gmail.com", "trinity110", nameRandom,"Parece que aún no tienes la edad mínima")));

    }

    @Test
    public void E_verifyThankYouEmail_C41229() throws InterruptedException {

        if (!caseIDs.contains("41229")) throw new SkipException("Skipping this testCase: 41229");
        setCaseID(41229);
        setCaseComment("Verifying Thank You email arrived");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);

        System.out.println(nameRandom);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        //assertTrue((verifyMailSubject("tester.openenglish@gmail.com", "trinity110", "gracias por tu interés en Open English Junior.")));
        assertTrue((verifyMailContent("tester.openenglish@gmail.com", "trinity110", "Ahora, necesitamos la ayuda de uno de tus padres", nameRandom + ", gracias por tu interés en Open English Junior.")));

    }

    @Test
    public void E_verifyThankYouEmail_C41230() throws InterruptedException {

        if (!caseIDs.contains("41230")) throw new SkipException("Skipping this testCase: 41230");
        setCaseID(41230);
        setCaseComment("Verifying Thank You email arrived");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);

        System.out.println(nameRandom);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        //assertTrue((verifyMailSubject("tester.openenglish@gmail.com", "trinity110", "gracias por tu interés en Open English Junior.")));
        assertTrue((verifyMailContent("tester.openenglish@gmail.com", "trinity110", "Al parecer aún eres menor de edad.", nameRandom + ", gracias por completar el formulario")));

    }


    @Test
    public void G_verifyPurchaseEmail_C41159() throws InterruptedException {
        if (!caseIDs.contains("41159")) throw new SkipException("Skipping this testCase: 41159");
        setCaseID(41159);
        setCaseComment("Verifying Purchase confirmation email arrived");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);

        System.out.println(nameRandom);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        assertTrue((verifyMailContent("tester.openenglish@gmail.com", "trinity110", "Hello " + nameRandom, "Congratulations on your purchase of Open English!")));
        //assertTrue((verifyMailContent("pepe@mailsac.com", null , "Hello " + nameRandom, "We are writing to confirm the purchase of your course")));

    }

    @Test
    public void F_ActivateLicenseFromActivationEmail_C41160()  throws InterruptedException {
        if (!caseIDs.contains("41160")) throw new SkipException("Skipping this testCase: 41160");

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
        setCaseID(41160);
        setCaseComment("Activating license using link from email");

        //nameRandom = "NAMEMDNSKE";

        System.out.println(nameRandom);

        String activationLink = getActivationLink("tester.openenglish@gmail.com", "trinity110", nameRandom, "Bienvenido a Open English");

        System.out.println("Link de activación: " + activationLink);

        driver.get(activationLink);

        System.out.println(emailRandom);
        driver.findElement(By.xpath("//*[@id=\"credentials\"]/div[1]/input")).sendKeys(emailRandom);// pantalla Activación - Email
        driver.findElement(By.xpath("//*[@id=\"credentials\"]/div[2]/input")).sendKeys(emailRandom);// pantalla Activacion - Confirm Email
        driver.findElement(By.xpath("//*[@id=\"credentials\"]/div[3]/input")).sendKeys("morpheus110");// pantalla Activación - Password
        driver.findElement(By.xpath("//*[@id=\"credentials\"]/div[4]/input")).sendKeys("morpheus110");// pantalla Activación - Confirm Password
        driver.findElement(By.xpath("//*[@id=\"credentials\"]/button")).click(); // botón Next

        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        dropdown = new Select(driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-student-info/div/div[2]/div[2]/div[2]/form/div[3]/lp3-birthdate-picker/form/fieldset/div/div[2]/select")));
        dropdown.selectByValue("05");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        dropdown = new Select(driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-student-info/div/div[2]/div[2]/div[2]/form/div[3]/lp3-birthdate-picker/form/fieldset/div/div[3]/select")));
        dropdown.selectByValue("05");

        dropdown = new Select(driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-student-info/div/div[2]/div[2]/div[2]/form/div[3]/lp3-birthdate-picker/form/fieldset/div/div[4]/select")));
        dropdown.selectByValue("1940");

        dropdown = new Select(driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-student-info/div/div[2]/div[2]/div[2]/form/div[4]/select")));
        dropdown.selectByValue("M");

        driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-student-info/div/div[2]/div[2]/div[2]/form/div[7]/lp3-phone-input/form/div[2]/div/input[3]")).sendKeys("2222");// PHONE PREFIX 1
        driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-student-info/div/div[2]/div[2]/div[2]/form/div[7]/lp3-phone-input/form/div[2]/div/input[4]")).sendKeys("3333");// PHONE PREFIX 2

        driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-student-info/div/div[2]/div[2]/div[2]/form/button")).click();// CONTINUAR

        driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-placement-quiz/div/div[2]/div[3]/div[2]/div[1]/div/table/tbody/p[1]/tbody/tr/a")).click();// Nivel NO ENGLISH

        driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-placement-quiz/div/div[2]/div[3]/div[2]/div[2]/button[2]")).click();// NEXT

        driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-placement-quiz/div/div[2]/div[3]/div[2]/div[1]/div/div/p[2]/a")).click();//1-2 Years

        driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-placement-quiz/div/div[2]/div[3]/div[2]/div[2]/button[2]")).click();// NEXT
        driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-placement-quiz-results/div/div[2]/div[3]/div[2]/button")).click();// SHOW ME THE TIPS
        driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-success-tips/div/div[2]/div[4]/div[2]/label/input")).click();//Got It!
        driver.findElement(By.xpath("/html/body/lp3-app/lp3-activation/lp3-success-tips/div/div[2]/div[4]/div[2]/button")).click();//START YOUR COURSE NOW

        Boolean popUpBolivares = false;


        /*
        try {


            wait.until(ExpectedConditions.visibilityOfElementLocated(((By.xpath("//*[@id=\"angular-body\"]/div[4]/div/div[1]/div/div[3]/div[3]"))))); // POPUP Bolivares

               popUpBolivares = true;

        }
        catch (InterruptedException ex) {
            popUpBolivares=false;}

*/


        Assert.assertTrue(driver.findElement(By.id("level-progress")).isDisplayed());


        //assertTrue((verifyMailContent("tester.openenglish@gmail.com", "trinity110", "Hello " + nameRandom, "We are writing to confirm the purchase of your course")));
        //assertTrue((verifyMailContent("pepe@mailsac.com", null , "Hello " + nameRandom, "We are writing to confirm the purchase of your course")));



    }


}
