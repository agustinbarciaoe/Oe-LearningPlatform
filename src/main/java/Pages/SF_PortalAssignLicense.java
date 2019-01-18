package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SF_PortalAssignLicense {

    WebDriver driver;

    // Elements
    @FindBy (id = "j_id0:SubmitContactForm:j_id47:j_id48:0:assignBtn") // btn ASIGNAR A NUEVO ESTUDIANTE
    WebElement btnAssignNewStudent;
    @FindBy (id = "j_id0:SubmitContactForm:j_id38") // input Nombre
    WebElement inputName;
    @FindBy (id = "j_id0:SubmitContactForm:j_id42") // input Apellidos
    WebElement inputLastName;
    @FindBy (id = "j_id0:SubmitContactForm:j_id46") // input Email
    WebElement inputEmail;
    @FindBy (id = "j_id0:SubmitContactForm:j_id136") // btn Save
    WebElement btnSave;
    @FindBy (id = "j_id0:SubmitContactForm:j_id47:j_id48:0:j_id70") // txtAssignedTo
    WebElement txtAssignedTo;

    // Initializer
    public SF_PortalAssignLicense(WebDriver driver){
        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver,this);
    }

    // Setters and Getters
    public WebElement getTxtAssignedTo(){
        return this.txtAssignedTo;
    }

    // Actions
    public void assignNewStudent(String name, String lastname, String email){
        this.btnAssignNewStudent.click();
        this.inputName.sendKeys(name);
        this.inputLastName.sendKeys(lastname);
        this.inputEmail.sendKeys(email);
        this.btnSave.click();
    }

}
