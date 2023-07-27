package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class signInPage {
    WebDriver driver;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement SignIn;
    @FindBy(id = "ap_email")
    WebElement emailField;
    @FindBy(id = "ap_password")
    WebElement passwordField;
    @FindBy(id = "signInSubmit")
    WebElement signButton;
    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement continueButton;

    public signInPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setEmail(String email) {
        this.emailField.sendKeys(email);
    }

    public void clickContinueButton() {
        this.continueButton.click();
    }

    public void setPassword(String password) {
        this.passwordField.sendKeys(password);
         }

    public void clickButton() {
        this.signButton.click();
    }

    public String returnPageTitle() {
        return driver.getTitle();
    }

    public void signIn_Test(String email, String pass) {
        this.SignIn.click();
        this.setEmail(email);
        this.clickContinueButton();
        this.setPassword(pass);
        this.clickButton();

    }
}
