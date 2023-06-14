package testSuite;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day5 {
    String URL="http://live.techpanda.org/";
    @BeforeTest
    public void OpenSite(){
        Util.setupCredintials(URL);
    }
@Test
    public void CreateEcomerceAccount(){
        Util.driver.findElement(By.xpath("/html/body/div/div/header/div/div[2]/div/a/span[2]")).click();
        Util.driver.findElement(By.cssSelector("[title=\"My Account\"]")).click();
        Util.driver.findElement(By.cssSelector("[title=\"Create an Account\"]")).click();
        Util.driver.findElement(By.id("firstname")).sendKeys("Test");
        Util.driver.findElement(By.id("lastname")).sendKeys("again");
        Util.driver.findElement(By.id("email_address")).sendKeys("m49125366@gmail.com");
        Util.driver.findElement(By.id("password")).sendKeys("Test123");
        Util.driver.findElement(By.id("confirmation")).sendKeys("Test123");
        Util.driver.findElement(By.id("is_subscribed")).click();
        Util.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[2]/button")).click();
        String ActualResult=Util.driver.findElement(By.cssSelector(".success-msg > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1)")).getText();
        String ExpectedResult="Thank you for registering with Main Website Store.";
        if(ActualResult.equalsIgnoreCase(ExpectedResult))
            System.out.println("Test Case is Passed");
        else
            System.out.println("Test Case is Failed");
        Util.driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[2]/a")).click();
        Util.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")).click();
        Util.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/div/button[1]")).click();
        Util.driver.findElement(By.id("email_address")).sendKeys("mennahamed157@gmail.com");
        Util.driver.findElement(By.id("message")).sendKeys("this TV is very good I wish I could buy it");
        Util.driver.findElement(By.cssSelector(".buttons-set > button:nth-child(3)")).click();
        String ACtualConfirmationMessg=Util.driver.findElement(By.cssSelector(".buttons-set > button:nth-child(3)")).getText();
        String EXConfirmationMessag="Your Wishlist has been shared";
    if(ACtualConfirmationMessg.equalsIgnoreCase(EXConfirmationMessag))
        System.out.println("Test Case is Passed");
    else
        System.out.println("Test Case is Failed");




}

}
