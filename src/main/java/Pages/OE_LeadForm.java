package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static BaseMain.BaseMethods.dropdown;

public class OE_LeadForm {

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
    @FindBy (id="city-select")
    WebElement citySelect;
    @FindBy (xpath="//*[@id=\"phone-format-selector\"]/label[1]")
    WebElement mobile;
    @FindBy (name="//*[@id=\"phone-format-selector\"]/label[1]")
    WebElement line;
    @FindBy (xpath = "//*[@id=\"phone-inputs\"]/input[3]")
    WebElement prefix3;
    @FindBy (xpath = "//*[@id=\"phone-inputs\"]/input[4]")
    WebElement prefix4;
    @FindBy (xpath="//*[@id=\"isforme-radio\"]/label[1]")
    WebElement isForMe;
    @FindBy (xpath="//*[@id=\"isforme-radio\"]/label[2]")
    WebElement isForMySon;
    @FindBy (id="agerange-select")
    WebElement ageRange;
    @FindBy (id="submit-button")
    WebElement submitButton;

    public OE_LeadForm(WebDriver driver){
        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver,this);
    }


    // Fill fields functions

    public void setUserName(String strUserName) {
        userName.sendKeys(strUserName);
    }

    public void setLastName(String strLastName) {
        lastName.sendKeys(strLastName);
    }

    public void setEmail (String strEmail){
        email.sendKeys(strEmail);
    }

    public void setCountrySelect (String strCountrySelect){
        dropdown = new Select(countrySelect);
        dropdown.selectByValue(strCountrySelect);
     }

    public void setStateSelect (String strStateSelect){
        dropdown = new Select(stateSelect);
        dropdown.selectByValue(strStateSelect);
    }

    public void setCitySelect (String strCitySelect){
        dropdown = new Select(citySelect);
        dropdown.selectByValue(strCitySelect);
    }

    public void setPrefix3 (String strPrefix3){ prefix3.sendKeys(strPrefix3);}

    public void setPrefix4 (String strPrefix4){ prefix4.sendKeys(strPrefix4);}

    public void setAgeRange (String strAgeRange){
        dropdown = new Select(ageRange);
        dropdown.selectByValue(strAgeRange);
    }

    // Actions
    public void submitLeadForm (String strUserName,
                                String strLastName,
                                String strEmail,
                                String strCountry,
                                String strState,
                                String strCity,
                                String strPrefix3,
                                String strPrefix4,
                                String strAgeRange,
                                boolean isForMe,
                                boolean isMobile) {
        driver.get("https://www.stg.openenglish.com");

        this.setUserName(strUserName);
        this.setLastName(strLastName);
        this.setEmail(strEmail);
        this.setCountrySelect(strCountry);
        this.setStateSelect(strState);
        this.setCitySelect(strCity);
        if (isMobile){
        this.mobile.click();} else {this.line.click();}
        if (isForMe) {
        this.isForMe.click();} else {this.isForMySon.click();}
        this.setPrefix3(strPrefix3);
        this.setPrefix4(strPrefix4);
        this.setAgeRange(strAgeRange);
        ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(250, 350)");
        this.submitButton.click();
    }



}
