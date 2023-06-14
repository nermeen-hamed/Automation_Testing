package testSuite;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Day7 {
    String URL="http://live.techpanda.org/";
    @BeforeTest
    public void OpenSite(){
        Util.setupCredintials(URL);
    }

    @Test

    public void SavePlaceOrderAsPDF() throws IOException, InterruptedException {

        Util.driver.findElement(By.xpath("//*[@class=\"skip-link skip-account\"]")).click();
        Util.driver.findElement(By.cssSelector("[title=\"My Account\"]")).click();
        //Switch to login page
        for(String window:Util.driver.getWindowHandles())
            Util.driver.switchTo().window(window);
        // Enter Login credentials
        Util.driver.findElement(By.id("email")).sendKeys("m49125366@gmail.com");
        Util.driver.findElement(By.id("pass")).sendKeys("Test123");
        Util.driver.findElement(By.id("send2")).click();
        // Switch to home page
        for(String window:Util.driver.getWindowHandles())
            Util.driver.switchTo().window(window);


        Util.driver.findElement(By.linkText("MY ORDERS")).click();
        //Check status of order
        String ActualStatus=Util.driver.findElement(By.cssSelector("tr.odd:nth-child(1) > td:nth-child(5) > em:nth-child(1)")).getText();
        System.out.println("Actual status "+ActualStatus);
        String ExpectedStatus="Pending";
        try {
                assertEquals(ActualStatus,ExpectedStatus);
                System.out.println("Test case is Passed the status is pending");
            }
        catch (Exception e){
                e.printStackTrace();
        }
        //View Order
        Util.driver.findElement(By.xpath("//tr[@class=\"first odd\"]/td[6]/span/a")).click();
        String Actualstatus =Util.driver.findElement(By.xpath("//div[@class=\"page-title title-buttons\"]/h1")).getText();
        String Expectedstatus ="pending";
        if(Actualstatus.toLowerCase().contains(Expectedstatus.toLowerCase())){
            System.out.println(Actualstatus);
            System.out.println("Test case is Passed the status is pending");
        }
        else
            System.out.println("Test case is False ");
        System.out.println(Actualstatus);
        //Print order
        Util.driver.findElement(By.xpath("//div[@class=\"page-title title-buttons\"]/a[2]")).click();
        for(String window :Util.driver.getWindowHandles())
            Util.driver.switchTo().window(window);
        System.out.println(Util.driver.getTitle());
       //save as pdf
        Thread.sleep(3000);
        File scrFile = ((TakesScreenshot) Util.driver).getScreenshotAs(OutputType.FILE);
        String pdf = ("Image\\" + "reset" +".pdf");
        FileUtils.copyFile(scrFile, new File(pdf));








    }

}
