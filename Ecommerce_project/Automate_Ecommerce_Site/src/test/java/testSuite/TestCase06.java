package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase06 {
    String URL="http://live.techpanda.org/";
    @BeforeTest
    public void OpenSite(){
        Utils.setupCredintials(URL);
    }

    @Test
    public void PurchaseProduct_WithChromeDriver(){
        //Click on my account
        Utils.driver.findElement(By.xpath("//*[@class=\"skip-link skip-account\"]")).click();
        Utils.driver.findElement(By.cssSelector("[title=\"My Account\"]")).click();
        //Switch to login page
        for(String window: Utils.driver.getWindowHandles())
            Utils.driver.switchTo().window(window);
        // Enter Login credentials
       Utils.driver.findElement(By.id("email")).sendKeys("m49125366@gmail.com");
       Utils.driver.findElement(By.id("pass")).sendKeys("Test123");
       Utils.driver.findElement(By.id("send2")).click();

       // Switch to home page
        for(String window: Utils.driver.getWindowHandles())
            Utils.driver.switchTo().window(window);
        //Click on wishList Link
        Utils.driver.findElement(By.linkText("MY WISHLIST")).click();
        //Switch to wishList Link
        for(String window: Utils.driver.getWindowHandles())
            Utils.driver.switchTo().window(window);
        //Click on Add to Card button
        Utils.driver.findElement(By.xpath("//button[@title=\"Add to Cart\"]")).click();
        //Switch to add card page
        for(String window: Utils.driver.getWindowHandles())
            Utils.driver.switchTo().window(window);
        //Click on proceed button
        //
        String ExpectedTVPrice="$615.00";
        String ActualTvPrice= Utils.driver.findElement(By.cssSelector("#shopping-cart-totals-table > tfoot > tr > td:nth-child(2) > strong > span")).getText();
        if(ExpectedTVPrice.equalsIgnoreCase(ActualTvPrice))
            System.out.println("Test Case is Passed "+ExpectedTVPrice);
        else
            System.out.println("Test Case is Failed "+ExpectedTVPrice);
        Utils.driver.findElement(By.xpath("//button[@title=\"Proceed to Checkout\"]")).click();
        //Switch to proceed purchase
        for(String window: Utils.driver.getWindowHandles())
            Utils.driver.switchTo().window(window);
        //Check customer already purchase before
        if(Utils.driver.getTitle().equalsIgnoreCase("CHECKOUT"))
        {
            new Select(Utils.driver.findElement(By.id("billing-address-select"))).selectByVisibleText("Test again, ABC, New York, New York 542896, United States");
            Utils.driver.findElement(By.cssSelector("[title=\"Continue\"]")).click();
        }
        else {
            //Complete purchase info
            /**/
            //new Select(Util.driver.findElement(By.id("billing-address-select"))).selectByVisibleText("New Address");
            Utils.driver.findElement(By.id("billing:street1")).clear();
            Utils.driver.findElement(By.id("billing:street1")).sendKeys("ABC");
            Utils.driver.findElement(By.id("billing:city")).clear();
            Utils.driver.findElement(By.id("billing:city")).sendKeys("New York");
            new Select(Utils.driver.findElement(By.id("billing:region_id"))).selectByVisibleText("New York");
            Utils.driver.findElement(By.id("billing:postcode")).clear();
            Utils.driver.findElement(By.id("billing:postcode")).sendKeys("542896");
            new Select(Utils.driver.findElement(By.id("billing:country_id"))).selectByVisibleText("United States");
            Utils.driver.findElement(By.id("billing:telephone")).clear();
            Utils.driver.findElement(By.id("billing:telephone")).sendKeys("12345678");
            Utils.driver.findElement(By.xpath("//button[@title=\"Continue\"]")).click();
            //Check Billing info

        }

        for(String window: Utils.driver.getWindowHandles())
            Utils.driver.switchTo().window(window);
        //check fixed price is equal ti 5.00
        String ActualPrice= Utils.driver.findElement(By.cssSelector("#checkout-shipping-method-load > dl:nth-child(1) > dd:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > label:nth-child(2) > span:nth-child(1)")).getText();
        String ExpectedPrice="$5.00";
        if (ActualPrice.equalsIgnoreCase(ExpectedPrice))
            System.out.println("Test Case is Passed the price is matched");
        else
            System.out.println("Test Case is failed the price is not matched");
        //continue purchase process
        Utils.driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
        for(String window: Utils.driver.getWindowHandles())
            Utils.driver.switchTo().window(window);
        //chose shipping method
        Utils.driver.findElement(By.id("p_method_checkmo")).click();
        Utils.driver.findElement(By.xpath("//div[@id=\"payment-buttons-container\"]/button")).click();
        //Check total price is 620.00

        String ActualTotalPrice= Utils.driver.findElement(By.cssSelector("tr.last:nth-child(3) > td:nth-child(2)")).getText();
        String ExpectedTotalPrice="$620.00";

        if (ActualTotalPrice.equalsIgnoreCase(ExpectedTotalPrice))
            System.out.println("Test Case is Passed the price is matched");
        else
            System.out.println("Test Case is failed the price is not matched");

        Utils.driver.findElement(By.xpath("//div[@id=\"review-buttons-container\"]/button")).click();
        //Verify that the purchase process is completed and id of the order is generated
        String ActualFinal = Utils.driver.findElement(By.cssSelector(".col-main > p:nth-child(3)")).getText();
        String StringExpectedFinal="Your order # is:";
        if (ActualFinal.contains(StringExpectedFinal)){
            System.out.println("Your order id is "+ActualFinal.split(":")[1]);
        }
        else
            System.out.println("Your id is not generated");
    }
@AfterTest
    public void AfterTesting(){
        Utils.driver.close();
}
}
