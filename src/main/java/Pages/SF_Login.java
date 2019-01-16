package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SF_Login {

    WebDriver driver;

    // Elements
    @FindBy (id="username")
    WebElement username;

    @FindBy (id="password")
    WebElement password;

    @FindBy (id="Login")
    WebElement btnLogin;

    // Initializer
    public SF_Login(WebDriver driver){
        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver,this);
    }

    // Fill fields functions
    public void setUsername(String strUsername){ username.sendKeys(strUsername);  }
    public void setPassword(String strPassword){ password.sendKeys(strPassword);  }

    // Actions
    public void loginToSF (String strUsername, String strPassword){
        driver.get("https://openeducation--stg.cs77.my.salesforce.com/");
        this.setUsername(strUsername);
        this.setPassword(strPassword);
        this.btnLogin.click();
    }
}
