package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class setLanguage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id=\"icp-nav-flyout\"]/span/span[2]")
    WebElement changeLanguage;
    @FindBy(xpath = "//*[@id=\"icp-language-settings\"]/div[3]/div/label/span")
    WebElement setEnglish;
    @FindBy(xpath = "//*[@id=\"icp-save-button\"]/span/input")
    WebElement saveButton;
    @FindBy(xpath = "//*[@id=\"icp-nav-flyout\"]")
    WebElement checkIcon;
    public setLanguage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public boolean checkChangeSuccessfully()
    {
        System.out.println(" what is that "+checkIcon.getText());
       return checkIcon.getText().contains("EN");
    }

    public void setLanguageFunction() {
        this.changeLanguage.click();
        this.setEnglish.click();
        this.saveButton.click();

    }
}
