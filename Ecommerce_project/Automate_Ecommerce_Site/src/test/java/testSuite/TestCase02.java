package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCase02 {
    @Test
    public void TC1() {

        WebElement mobile = Utils.driver.findElement(By.className("level0"));
        mobile.click();

        String PriceInMobileList = Utils.driver.findElement(By.cssSelector("#product-price-1")).getText();
        WebElement sonyxImage = Utils.driver.findElement(By.id("product-collection-image-1"));
        sonyxImage.click();
        String PriceInDetailsPage = Utils.driver.findElement(By.cssSelector("#product-price-1")).getText();
        //System.out.println(PriceInMobileList.getText()+"  "+PriceInDetailsPage.getText());
        assertEquals(PriceInMobileList, PriceInDetailsPage);

        // System.out.println(PriceInDetailsPage.getText());
    }
    @AfterTest
    public void tearDown() throws Exception {
        Utils.driver.quit();

    }

}
