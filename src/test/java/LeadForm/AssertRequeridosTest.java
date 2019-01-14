
package LeadForm;

import BaseMain.BaseMethods;
import BaseMain.CustomTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class AssertRequeridosTest extends BaseMethods {




    @Test
    public void leadformtitle() throws InterruptedException{
        String caseID = "39729";
        if (!caseIDs.contains(caseID)) throw new SkipException("Skipping this testCase: "+caseID);

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
        setCaseID(39729);
        setCaseComment("Verificando que el titulo del leadform sea correcto");
        driver.get("https://www.stg.openenglish.com.rpg/");
        assertEquals(driver.findElement(By.id("leadform-title")).getText(), "Empieza a Aprender Inglés");

    }

    /*
    @Test
    public void requerido(){
        String caseID = "39730";
        if (!caseIDs.contains(caseID)) throw new SkipException("Skipping this testCase: "+caseID);

        setCaseID(39730);
        setCaseComment("Verificando que el div 'required' sea mostrado");
        //driver.get("https://www.stg.openenglish.com/");
        //driver.findElement(By.id("required-div"));
        assertTrue(driver.findElement(By.id("required-div")).getText().matches("^[\\s\\S]* Requerido$"));

    }
*/

    @Test
    public void nombreRequerido(){

        String caseID = "39731";
        if (!caseIDs.contains(caseID)) throw new SkipException("Skipping this testCase: "+caseID);

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
        setCaseID(39731);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible!!!!");
       driver.get("https://www.stg.openenglish.com/");
        //driver.findElement(By.id("firstname-input"));
        assertTrue(driver.findElement(By.id("firstname-input")).getAttribute("placeholder").contains("Nombre"));
    }

    @Test
    public void apellidoRequerido(){

        String caseID = "39732";
        if (!caseIDs.contains(caseID)) throw new SkipException("Skipping this testCase: "+caseID);

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
        setCaseID(39732);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");
        driver.get("https://www.stg.openenglish.com/");
        //driver.findElement(By.id("lastname-input"));
        assertTrue(driver.findElement(By.id("lastname-input")).getAttribute("placeholder").contains("Apellido"));
    }
    @Test
    public void correoRequerido(){

        String caseID = "39733";
        if (!caseIDs.contains(caseID)) throw new SkipException("Skipping this testCase: "+caseID);

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
        setCaseID(39733);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");
        driver.get("https://www.stg.openenglish.com/");
        //driver.findElement(By.id("emailaddress-input"));
        assertTrue(driver.findElement(By.id("emailaddress-input")).getAttribute("placeholder").contains("Correo"));
    }

    @Test
    public void regionRequerido(){

        String caseID = "39734";
        if (!caseIDs.contains(caseID)) throw new SkipException("Skipping this testCase: "+caseID);

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
        setCaseID(39734);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");

        driver.get("https://www.stg.openenglish.com/");
        Select regionDropdown= new Select(driver.findElement(By.id("state-select")));
        assertTrue(regionDropdown.getFirstSelectedOption().getText().contains("Región"));

    }

    @Test
    public void verifyMandatoryFields() {
        String caseID = "39730";
        if (!caseIDs.contains(caseID)) throw new SkipException("Skipping this testCase: "+caseID);

        setClassName(this.getClass().getSimpleName());
        setTestName(Thread.currentThread().getStackTrace()[1].getMethodName());
        System.out.println("Begin Test class: "+className+", Test Method: "+testName);
        setCaseID(39730);
        setCaseComment("Verifying all Required messages are shown");

        driver.get("https://www.stg.openenglish.com/");
        driver.findElement(By.id("submit-button")).click();
        assertTrue(
                driver.findElement(By.xpath("//*[@id=\"leadForm\"]/div[1]/div[2]/div/span")).isDisplayed()&&
                driver.findElement(By.xpath("//*[@id=\"leadForm\"]/div[1]/div[3]/div/span")).isDisplayed() &&
                driver.findElement(By.xpath("//*[@id=\"leadForm\"]/div[1]/div[4]/div/span")).isDisplayed() &&
                driver.findElement(By.xpath("//*[@id=\"leadForm\"]/div[1]/div[6]/div/span")).isDisplayed() &&
                driver.findElement(By.xpath("//*[@id=\"leadForm\"]/div[1]/div[9]/div/div[2]/span")).isDisplayed()
        );
    }
}
