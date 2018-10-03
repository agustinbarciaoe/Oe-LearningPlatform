package LeadForm;

import BaseTest.BaseMain.BaseMethods;
import BaseTest.BaseMain.CustomTestListener;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(CustomTestListener.class)
public class AssertRequeridosTest extends BaseMethods {

/*
    @BeforeClass
    public void setUp() throws Exception {

        inizialitation();

    }

    @AfterClass
    public void tearDown() throws Exception {
      //  driver.close();
      //  driver.quit();
    }
    */

    @Test
    public void leadformtitle(){

        setCaseID(45668);
        setCaseComment("Verificando que el titulo del leadform sea correcto");
        driver.get("https://www.stg.openenglish.com/");
        assertEquals(driver.findElement(By.id("leadform-title")).getText(), "Empieza a Aprender Inglés");

    }

    @Test
    public void requerido(){

        setCaseID(45679);
        setCaseComment("Verificando que el div 'required' sea mostrado");
        driver.get("https://www.stg.openenglish.com/");
        driver.findElement(By.id("required-div"));
        assertTrue(driver.findElement(By.id("required-div")).getText().matches("^[\\s\\S]* Requerido$"));

    }

    @Test
    public void nombreRequerido(){

        setCaseID(45669);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible!!!!");
        driver.get("https://www.stg.openenglish.com/");
        driver.findElement(By.id("firstname-input"));
        assertTrue(driver.findElement(By.id("firstname-input")).getAttribute("placeholder").contains("Nombre"));
    }

    @Test
    public void apellidoRequerido(){

        setCaseID(45670);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");
        driver.get("https://www.stg.openenglish.com/");
        driver.findElement(By.id("lastname-input"));
        assertTrue(driver.findElement(By.id("lastname-input")).getAttribute("placeholder").contains("Apellido"));
    }
    @Test
    public void correoRequerido(){

        setCaseID(45671);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");
        driver.get("https://www.stg.openenglish.com/");
        //driver.findElement(By.id("emailaddress-input"));
        assertTrue(driver.findElement(By.id("emailaddress-input")).getAttribute("placeholder").contains("Correo"));
    }

    @Test
    public void regionRequerido(){

        setCaseID(45672);
        setCaseComment("Verificando que el place holder para para el caso exista y sea visible");

        driver.get("https://www.stg.openenglish.com/");
        driver.findElement(By.id("lastname-input"));
        assertTrue(driver.findElement(By.id("state-select")).getAttribute("placeholder").contains("Region"));
    }
}
