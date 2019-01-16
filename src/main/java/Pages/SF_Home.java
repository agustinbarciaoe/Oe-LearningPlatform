package Pages;

import BaseMain.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SF_Home {

    WebDriver driver;

    // Elements
    @FindBy (id = "globalHeaderNameMink")
    WebElement profileBox;
    @FindBy (id ="phSearchInput")
    WebElement searchInput;
    @FindBy (css = ".messageText")
    WebElement messageNotFound;
    @FindBy (id = "secondSearchText")
    WebElement secondSearchInput;
    @FindBy (className = "dataCell")
    WebElement contactLink;
    @FindBy(name = "sales_tool")
    WebElement btnSalesTool;

    // Initializer
    public SF_Home(WebDriver driver){
        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver,this);
    }

    // Setters and Getters
    public WebElement getProfileBox() {
        return this.profileBox;
    }

    //Actions
    public void searchContact (String strSearchContact) throws InterruptedException {
        // Login to SF
        SF_Login objSF_Login = new SF_Login(driver);
        objSF_Login.loginToSF("martin.tellechea@openenglish.com.stg", "trinity112");

        WebDriverWait wait = new WebDriverWait(driver, 60);

        this.searchInput.sendKeys(strSearchContact);
        TimeUnit.SECONDS.sleep(5);
        try {
            Thread.sleep(15000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        this.searchInput.sendKeys(Keys.RETURN);

        while ((Boolean) BaseMethods.isElementPresent(By.cssSelector(".messageText"))) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            wait.until(ExpectedConditions.visibilityOf(this.secondSearchInput));
            this.secondSearchInput.clear();
            this.secondSearchInput.sendKeys(strSearchContact);
            this.secondSearchInput.sendKeys(Keys.RETURN);

        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dataCell")));
        this.contactLink.click();


    }
}
