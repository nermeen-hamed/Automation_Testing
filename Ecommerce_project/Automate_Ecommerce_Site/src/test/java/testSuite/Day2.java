package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Day2 {
    @Test
    public void TC1() {

        WebElement mobile = Util.driver.findElement(By.className("level0"));
        mobile.click();

        String PriceInMobileList = Util.driver.findElement(By.cssSelector("#product-price-1")).getText();
        WebElement sonyxImage = Util.driver.findElement(By.id("product-collection-image-1"));
        sonyxImage.click();
        String PriceInDetailsPage = Util.driver.findElement(By.cssSelector("#product-price-1")).getText();
        //System.out.println(PriceInMobileList.getText()+"  "+PriceInDetailsPage.getText());
        assertEquals(PriceInMobileList, PriceInDetailsPage);

        // System.out.println(PriceInDetailsPage.getText());
    }
    @AfterTest
    public void tearDown() throws Exception {
        Util.driver.quit();

    }

}
