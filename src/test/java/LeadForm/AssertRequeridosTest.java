/*
package LeadForm;

import BaseMethods;
import CustomTestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class AssertRequeridosTest extends BaseMethods {


    @BeforeClass
    public void setUp() throws Exception {

        inizialitation();

    }

    @AfterClass
    public void tearDown() throws Exception {
      //  driver.close();
      //  driver.quit();
    }


    @Test
    public void leadformtitle(){

        setCaseID(46858);
        setCaseComment("Verificando que el titulo del leadform sea correcto");
        //driver.get("https://www.stg.openenglish.com/");
        assertEquals(driver.findElement(By.id("leadform-title")).getText(), "Empieza a Aprender Inglés");

    }

    @Test
    public void requerido(){

        setCaseID(46859);
        setCaseComment("Verificando que el div 'required' sea mostrado");
        //driver.get("https://www.stg.openenglish.com/");
        //driver.findElement(By.id("required-div"));
        assertTrue(driver.findElement(By.id("required-div")).getText().matches("^[\\s\\S]* Requerido$"));

    }

    @Test
    public void nombreRequerido(){

        setCaseID(46860);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible!!!!");
       //driver.get("https://www.stg.openenglish.com/");
        //driver.findElement(By.id("firstname-input"));
        assertTrue(driver.findElement(By.id("firstname-input")).getAttribute("placeholder").contains("Nombre"));
    }

    @Test
    public void apellidoRequerido(){

        setCaseID(46861);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");
        //driver.get("https://www.stg.openenglish.com/");
        //driver.findElement(By.id("lastname-input"));
        assertTrue(driver.findElement(By.id("lastname-input")).getAttribute("placeholder").contains("Apellido"));
    }
    @Test
    public void correoRequerido(){

        setCaseID(46862);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");
        //driver.get("https://www.stg.openenglish.com/");
        //driver.findElement(By.id("emailaddress-input"));
        assertTrue(driver.findElement(By.id("emailaddress-input")).getAttribute("placeholder").contains("Correo"));
    }

    @Test
    public void regionRequerido(){

        setCaseID(46863);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");

        //driver.get("https://www.stg.openenglish.com/");
        Select regionDropdown= new Select(driver.findElement(By.id("state-select")));
        assertTrue(regionDropdown.getFirstSelectedOption().getText().contains("Región"));

    }

    @Test
    public void verifyMandatoryFields() {
        setCaseID(46862);
        setCaseComment("Verificando que todos los mensajes de Requerido se visualicen");

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
*/