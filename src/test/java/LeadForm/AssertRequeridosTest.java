package LeadForm;

import BaseMain.BaseMethods;
import BaseTest.CustomTestListener;
import org.openqa.selenium.By;
import org.testng.annotations.*;

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
    public void requerido(){

        setCaseID(44788);
        setCaseComment("Verificando que el div 'required' sea mostrado");
        driver.get("https://www.stg.openenglish.com/");
        driver.findElement(By.id("required-div"));
        assertTrue(driver.findElement(By.id("required-div")).getText().matches("^[\\s\\S]* Requerido$"));

    }

    @Test
    public void nombreRequerido(){

        setCaseID(44790);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");
        driver.get("https://www.stg.openenglish.com/");
        driver.findElement(By.id("firstname-input"));
        assertTrue(driver.findElement(By.id("firstname-input")).getAttribute("placeholder").contains("Nombre"));
    }

    @Test
    public void apellidoRequerido(){

        setCaseID(44790);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");
        driver.get("https://www.stg.openenglish.com/");
        driver.findElement(By.id("lastname-input"));
        assertTrue(driver.findElement(By.id("lastname-input")).getAttribute("placeholder").contains("Apellido"));
    }
    @Test
    public void correoRequerido(){

        setCaseID(44790);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");
        driver.get("https://www.stg.openenglish.com/");
        driver.findElement(By.id("lastname-input"));
        assertTrue(driver.findElement(By.id("lastname-input")).getAttribute("placeholder").contains("Correo"));
    }

    @Test
    public void regionRequerido(){

        setCaseID(44790);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");

        driver.get("https://www.stg.openenglish.com/");
        driver.findElement(By.id("lastname-input"));
        assertTrue(driver.findElement(By.id("state-select")).getAttribute("placeholder").contains("Correo"));
    }
}
