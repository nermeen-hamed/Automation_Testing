package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addItemToCartPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"nav-hamburger-menu\"]")
    WebElement allTab;
    @FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul[1]/li[17]/a")
    WebElement TodayTab;
    @FindBy(xpath = "//*[@id=\"grid-main-container\"]/div[2]/span[3]/ul/li[2]/label/span")
    WebElement secCategory;
    @FindBy(xpath = "//*[@id=\"grid-main-container\"]/div[3]/div/div[1]/div/div/a/div/div/img")
    WebElement firstItem;
    @FindBy(xpath = "//*[@id=\"octopus-dlp-asin-stream\"]/ul/li[4]/span/div/div[1]/a/div")
    WebElement fourthItem;
    @FindBy(xpath = "//*[@id=\"quantity\"]")
    WebElement Qty;
    @FindBy(id="add-to-cart-button")
    WebElement addToCartButton;
    @FindBy(xpath = "//*[@id=\"nav-cart\"]")
    WebElement CartIcon;

    @FindBy(xpath = "/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/li[1]/span/a/span[1]/span/span[2]")
    WebElement checkName;
    @FindBy(xpath = "/html/body/div[1]/div[1]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[3]/div[4]/div/div[2]/ul/div/div/div/p/span")
    WebElement checkPrice;
    @FindBy(xpath = "//*[@id=\"sc-subtotal-amount-activecart\"]/span")
    WebElement checkTotalPrice;

    public addItemToCartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    public void clickOnAllTab(){
        this.allTab.click();
    }
    public void ClickOnTodayTab(){
        this.TodayTab.click();
    }
    public void ClickOnSecCategory(){
        this.secCategory.click();
    }
    public void ClickOnFirstItem(){
        this.firstItem.click();
    }
    public void ClickOnFourthItem(){
        this.fourthItem.click();
    }

    public void ClickOnAddButton(){
        this.addToCartButton.click();
    }
    public void ClickOnCartIcon(){
        this.CartIcon.click();
    }
    public double returnPrice(){
        String price=this.checkPrice.getText().split(" ")[1];
        return Double.parseDouble(price);
    }
    public String returnName(){
        String name=this.checkName.getText();
        return name;
    }
    public double returnTotalPrice(){
        String subtotal=this.checkTotalPrice.getText().split(" ")[1];
        return Double.parseDouble(subtotal);
    }

    public void addSteps(){
        this.clickOnAllTab();
        this.ClickOnTodayTab();
        this.ClickOnSecCategory();
        this.ClickOnFirstItem();
        this.ClickOnFourthItem();
        this.ClickOnAddButton();
        this.ClickOnCartIcon();
    }

}
