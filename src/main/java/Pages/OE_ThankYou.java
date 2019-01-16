package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OE_ThankYou {

    WebDriver driver;

    @FindBy(id = "thankyou-hero-title")
    WebElement titleBox;

    public OE_ThankYou(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getTitleBox(){
        return this.titleBox;
    }
}
