package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Day3 {
    @Test
    public void TC1() {
        WebElement mobile = Util.driver.findElement(By.className("level0"));
        mobile.click();
        WebElement sonyxImage = Util.driver.findElement(By.id("product-collection-image-1"));
        sonyxImage.click();
        WebElement AddButton = Util.driver.findElement(By.cssSelector("[title=\"Add to Cart\"]"));
        AddButton.click();
        // 4. Change QTY value to 1000 and click UPDATE button.
        //   Expected "The requested quantity for "Sony Xperia" is not available." error message is displayed.
        WebElement Additems = Util.driver.findElement(By.cssSelector("[title=\"Qty\"]"));
        Additems.clear();
        Additems.sendKeys("1000");
        WebElement UpdateButton = Util.driver.findElement(By.cssSelector("[title=\"Update\"]"));
        UpdateButton.click();
        String Expected_error = "* The requested Quantity for \"Sony Xperia\" is not available";
        String Actual_error = Util.driver.findElement(By.cssSelector("[class=\"item-msg error\"]")).getText();
        // Verify the error message
        try {
            assertEquals(Actual_error, Expected_error);
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
    @Test (dependsOnMethods = {"TC1"})

    public void TC2(){

        WebElement cartButton=Util.driver.findElement(By.cssSelector("[data-target-element=\"#header-cart\"]"));
        cartButton.click();
        //Verify cart is empty
        String Expected_Cart_Messg="SHOPPING CART IS EMPTY";
        String Actual_Cart_Messg=Util.driver.findElement(By.cssSelector("[id=\"header-cart\"]")).getText();
        try {
            assertEquals(Expected_Cart_Messg, Actual_Cart_Messg);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    @AfterTest
    public void tearDown() throws Exception {
        Util.driver.quit();

    }
}
