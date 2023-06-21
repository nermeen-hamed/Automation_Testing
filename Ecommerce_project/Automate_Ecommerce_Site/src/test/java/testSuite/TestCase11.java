
package testSuite;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class TestCase11 {
    private String URL="http://live.techpanda.org/index.php/backendlogin";
    private final String id="user01";
    private final String pass="guru99com";
    @BeforeTest
    public void OpenSite(){
        Utils.setupCredintials(URL);
    }
//Verify invoice can be printed
    @Test
    public void PrintInvoiceTest() throws InterruptedException {
        //Enter login credentials
        Utils.driver.findElement(By.xpath("//input[@id=\"username\"]")).clear();
        Utils.driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(id);
        Utils.driver.findElement(By.xpath("//input[@id=\"login\"]")).clear();
        Utils.driver.findElement(By.xpath("//input[@id=\"login\"]")).sendKeys(pass);
        Utils.driver.findElement(By.xpath("//input[@class=\"form-button\"]")).click();

        System.out.println("Credentials entered successfully");

        //Close popup window
        Utils.driver.findElement(By.xpath("//div[@id=\"message-popup-window\"]/div/a/span")).click();
        System.out.println("Pop UP window closed successfully");

        //From select -> orders
        Utils.driver.findElement(By.xpath("//ul[@id=\"nav\"]/li/a/span")).click();
        Utils.driver.findElement(By.xpath("//ul/li[@class=\"  level1\"]/a/span")).click();
        System.out.println("From select -> orders selected successfully");

        //Select status filed -> Canceled option
        new Select(Utils.driver.findElement(By.xpath("//*[@id=\"sales_order_grid_massaction-select\"]"))).selectByVisibleText("Cancel");
        System.out.println("From Select status filed -> Canceled option selected successfully");

        Utils.driver.findElement(By.xpath("//button[@title=\"Search\"]")).click();
        System.out.println("Search button selected successfully");
        Thread.sleep(3000);
        Utils.driver.findElement(By.xpath("//table[@id=\"sales_order_grid_table\"]/tbody/tr[1]/td[1]/input")).click();

        //Select status filed -> Print Invoices option
        new Select(Utils.driver.findElement(By.xpath("//*[@id=\"sales_order_grid_massaction-select\"]"))).selectByVisibleText("Print Invoices");
        System.out.println("From Select status filed -> Print Invoices option selected successfully");
        //Click submit bitton

        Thread.sleep(3000);
        Utils.driver.findElement(By.xpath("//button[@title=\"Submit\"]")).click();

        String ActualErrorMessage=Utils.driver.findElement(By.xpath("//*[@id=\"messages\"]/ul/li")).getText();
        String ExpectedErrorMessage="There are no printable documents related to selected orders.";
        if(ActualErrorMessage.equalsIgnoreCase(ExpectedErrorMessage))
            System.out.println("Test Case is Passed "+ ActualErrorMessage);
        else
            System.out.println("Test Case is failed "+ActualErrorMessage );

        Thread.sleep(3000);
        new Select(Utils.driver.findElement(By.xpath("//select[@name=\"status\"]"))).selectByVisibleText("Complete");
        System.out.println("From Select status filed -> Complete option selected successfully");
       // Click Search Button
        Thread.sleep(3000);
        Utils.driver.findElement(By.xpath("//button[@title=\"Search\"]")).click();
        //Select the checkbox next to first order
        Thread.sleep(3000);
        Utils.driver.findElement(By.xpath("//*[@id=\"sales_order_grid_table\"]/tbody/tr/td[1]")).click();

        //Select status filed -> Print Invoices option
        Thread.sleep(3000);
        new Select(Utils.driver.findElement(By.xpath("//*[@id=\"sales_order_grid_massaction-select\"]"))).selectByVisibleText("Print Invoices");
        System.out.println("From Select status filed -> Print Invoices option selected successfully");

        Thread.sleep(3000);
        Utils.driver.findElement(By.xpath("//button[@title=\"Submit\"]")).click();
        // Verify that the file is downloaded successfully
        String Directory="C:\\Users\\Nermeen\\Downloads";
        String fileName="invoice2023-06-20_19-07-16.pdf";
        boolean CheckIsExist=new File(Directory,fileName).exists();
        if(CheckIsExist)
            System.out.println("File is downloaded successfully");
        else System.out.println("File can not be downloaded");
    }
    @AfterTest
    public void teardown(){
        Utils.driver.close();
    }


}

