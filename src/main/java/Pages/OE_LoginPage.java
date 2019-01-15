package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OE_LoginPage {

    WebDriver driver;

    @FindBy (id="firstname-input")
    WebElement userName;

    @FindBy (id="lastname-input")
    WebElement lastName;

    @FindBy (id="emailaddress-input")
    WebElement email;

    @FindBy (id="country-select")
    WebElement countrySelect;

    @FindBy (id="state-select")
    WebElement stateSelect;

    @FindBy (name="isForMe")
    WebElement isForMe;

    @FindBy (id="agerange-select")
    WebElement ageRange;

    @FindBy (id="submit-button")
    WebElement submitButton;

}
