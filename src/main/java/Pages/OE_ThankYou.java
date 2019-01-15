package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OE_ThankYou {

    WebDriver driver;

    @FindBy(id = "thankyou-hero-title")
    WebElement titleBox;

    public OE_ThankYou(WebDriver driver){
        this.driver = driver;
    }

}
