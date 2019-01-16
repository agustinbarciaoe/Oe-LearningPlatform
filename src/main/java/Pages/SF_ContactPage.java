package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SF_ContactPage {

    WebDriver driver;

    // Elements
    @FindBy (id = "contactHeaderRow")
    WebElement contactHeader;
    @FindBy (name = "sales_tool")
    WebElement btnSalesTool;
    @FindBy (id = "btnSelecta0D0t000000smvmEAA")
    WebElement btnDiscount;
    @FindBy (id = "j_id0:stco:j_id217:mainForm:j_id231:1:j_id248:0:cmdProcess")
    WebElement btnAdd;
    @FindBy (id = "j_id0:stco:j_id217:mainForm:j_id355")
    WebElement chkAssignToBuyer;
    @FindBy (id = "j_id0:stco:j_id217:mainForm:j_id372")
    WebElement btnConfirm;
    @FindBy(name = "j_id0:stco:j_id217:mainForm:j_id396")
    WebElement btnFinish;
    @FindBy (name = "zuora__sync_data_from_zbilling")
    WebElement btnZuoraSync;
    @FindBy (id = "topButtonRow")
    WebElement menuButtonRow;
    // Elements of SalesTool iframe
    @FindBy (id = "numberInput")
    WebElement ccNumberInput;
    @FindBy (id = "expirationInput")
    WebElement ccExpirationInput;
    @FindBy (id = "nameInput")
    WebElement ccNameInput;
    @FindBy (id = "securityCodeInput")
    WebElement ccSecurityCodeInput;
    @FindBy (id = "documentNoInput")
    WebElement ccDocumentNoInput;
    @FindBy (id = "contractHolderNameInput")
    WebElement ccContractHolderNameInput;
    @FindBy (id = "submitBtn")
    WebElement btnSubmitBtn;
    @FindBy (css = ".fa-check")
    WebElement checkPaymentOK;


    // Initializer
    public SF_ContactPage(WebDriver driver){
        this.driver = driver;

        //This initElements method will create all WebElements
        PageFactory.initElements(driver,this);
    }
    // Actions
   public void goToSalesTool(){
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", this.menuButtonRow);
        this.btnSalesTool.click();
   }

   public void makePurchase(String nameRandom) throws InterruptedException {
       WebDriverWait wait = new WebDriverWait(driver, 60);




        this.btnDiscount.click(); // SELECT DISCOUNT
        driver.findElement(By.id("j_id0:frmConditions:cmdOrgOEBlue")).sendKeys(Keys.PAGE_DOWN);
        this.btnAdd.click(); // ADD

       if (!this.chkAssignToBuyer.isSelected()) // CHECKBOX "Assign a license to the buyer"
           this.chkAssignToBuyer.click();

       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", this.btnConfirm);
       this.btnConfirm.click();// CONFIRM

       driver.switchTo().frame(driver.findElement(By.id("immediateCapture_iframe")));
       wait.until(ExpectedConditions.visibilityOf(ccNumberInput));
       this.ccNumberInput.sendKeys("4012 8888 8888 1881");
       this.ccExpirationInput.sendKeys("01/2025");
       this.ccNameInput.sendKeys(nameRandom);
       this.ccSecurityCodeInput.sendKeys("888");
       this.ccDocumentNoInput.sendKeys("25598000");
       this.ccDocumentNoInput.sendKeys(Keys.TAB);
       this.ccContractHolderNameInput.sendKeys(nameRandom);

       driver.switchTo().defaultContent();
       driver.switchTo().frame(driver.findElement(By.id("immediateCapture_iframe")));

       try {
           Thread.sleep(20000);
       } catch (InterruptedException ex) {
           Thread.currentThread().interrupt();
       }

       // Checkboxes Contract & Terms
       WebElement checkbox1 = driver.findElement(By.cssSelector("#checkboxAgree"));
       WebElement checkbox2 = driver.findElement(By.cssSelector("#checkbox0"));
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].click()", checkbox1);
       js.executeScript("arguments[0].click()", checkbox2);

       Thread.sleep(5000);
       wait.until(ExpectedConditions.elementToBeClickable(this.btnSubmitBtn));
       js.executeScript("arguments[0].click()", this.btnSubmitBtn);
       Thread.sleep(10000);
       ((JavascriptExecutor) driver).executeScript("javascript:window.scrollBy(250, 350)");
       wait.until(ExpectedConditions.visibilityOf(this.checkPaymentOK)); // Checkbox OK


       driver.switchTo().defaultContent();
       this.btnFinish.click();// FINISH
       wait.until(ExpectedConditions.visibilityOf(this.btnZuoraSync));
       this.btnZuoraSync.click();
   }

   public WebElement getContactHeader(){
        return this.contactHeader;
   }
}
