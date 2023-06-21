package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase08 {
    String URL="http://live.techpanda.org/";
    @BeforeTest
    public void OpenSite(){
        Utils.setupCredintials(URL);
    }
    @Test
    public void ChangeOrderTest(){

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
        Utils.driver.findElement(By.linkText("MY ORDERS")).click();
        //Click on reorder link
        Utils.driver.findElement(By.xpath("//tr[@class=\"first odd\"]/td[6]/span/a[2]")).click();
        //Update quantity
        Utils.driver.findElement(By.xpath("//input[@class=\"input-text qty\"]")).clear();
        Utils.driver.findElement(By.xpath("//input[@class=\"input-text qty\"]")).sendKeys("10");
        Utils.driver.findElement(By.xpath("//button[@class=\"button btn-update\"]")).click();
     //Verify grand total is changed
        try {
            String ActualGrandTotla= Utils.driver.findElement(By.xpath("//tfoot/tr/td[@class=\"a-right\"]/strong/span")).getText();
            String ExpectedGrandTotal="$6,150";
            if(ActualGrandTotla.contains(ExpectedGrandTotal)){
                System.out.println("Test case is passed");
            }

            else
                System.out.println("Test case is failed" );
        }
        catch (Exception e){
            e.printStackTrace();
        }
        //Click checkout button to follow the purchase process
        Utils.driver.findElement(By.xpath("//button[@class=\"button btn-proceed-checkout btn-checkout\"]")).click();
        //Util.driver.findElement(By.xpath())

            new Select(Utils.driver.findElement(By.id("billing-address-select"))).selectByVisibleText("Test again, ABC, New York, New York 542896, United States");
            Utils.driver.findElement(By.cssSelector("[title=\"Continue\"]")).click();

            Utils.driver.findElement(By.xpath("//button[@title=\"Continue\"]")).click();
            Utils.driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();

        //chose shipping method
           Utils.driver.findElement(By.id("p_method_checkmo")).click();
           Utils.driver.findElement(By.xpath("//div[@id=\"payment-buttons-container\"]/button")).click();
            //Check Billing info

        //Check total price is 6,200

        /*String ActualTotalPrice=Util.driver.findElement(By.cssSelector("tr.last:nth-child(3) > td:nth-child(2)")).getText();
        String ExpectedTotalPrice="$6,200";

        if (ActualTotalPrice.contains(ExpectedTotalPrice))
            System.out.println("Test Case is Passed the price is matched");
        else
            System.out.println("Test Case is failed the price is not matched " +ActualTotalPrice );*/

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
}
