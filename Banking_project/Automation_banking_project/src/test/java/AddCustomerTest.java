

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;


public class AddCustomerTest {
    //String URL="https://www.demo.guru99.com/V4/manager/Managerhomepage.php";
    String URL="http://www.demo.guru99.com/V4/";

    @BeforeTest
    public void OpenSite(){
        Util.setupCredintials(URL);
    }


    @Test (dependsOnMethods = {"Util.managerLogin"})
    public void addNewCustomer() throws IOException {


        WebElement AddCcustomer=Util.driver.findElement(By.cssSelector(".menusubnav > li:nth-child(2) > a:nth-child(1)"));
        AddCcustomer.click();
        WebElement nameField=Util.driver.findElement(By.name("name"));
        nameField.sendKeys("Testfifteen ");
        WebElement SexType=Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
        SexType.click();
        Util.driver.findElement(By.xpath("//*[@id=\"dob\"]")).sendKeys("01252023");
        Util.driver.findElement(By.name("addr")).sendKeys("Maddi");
        Util.driver.findElement(By.name("city")).sendKeys("Cairo");
        Util.driver.findElement(By.name("state")).sendKeys("single");
        Util.driver.findElement(By.name("pinno")).sendKeys("123456");
        Util.driver.findElement(By.name("telephoneno")).sendKeys("01022336688");
        Util.driver.findElement(By.name("emailid")).sendKeys("Testagain15@gmail.com");
        Util.driver.findElement(By.name("password")).sendKeys("Test123");
        Util.driver.findElement(By.name("sub")).click();
        File fileSrc=((TakesScreenshot)Util.driver).getScreenshotAs(OutputType.FILE);
        String png = ("Image\\" + "DetailsScreenShot" + ".png");
        FileUtils.copyFile(fileSrc,new File(png));
        Util.driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[14]/td/a")).click();

    }
    @Test (dependsOnMethods = {"Util.managerLogin"})
    public void addNewAccount() throws IOException {
         Util.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[5]/a")).click();
         Util.driver.findElement(By.name("cusid")).sendKeys("47436");
        Select TypeOfAcount=new Select(Util.driver.findElement(By.name("selaccount")));
        TypeOfAcount.selectByVisibleText("Savings");
        Util.driver.findElement(By.name("inideposit")).sendKeys("500");
        Util.driver.findElement(By.name("button2")).click();
        File fileSrc=((TakesScreenshot)Util.driver).getScreenshotAs(OutputType.FILE);
        String png = ("Image\\" + "DetailsScreenShotForAccount2" + ".png");
        FileUtils.copyFile(fileSrc,new File(png));
    }

   @Test

    @AfterTest
    public void finishTesting() throws InterruptedException {

        Util.afterTesting();

    }

   }


