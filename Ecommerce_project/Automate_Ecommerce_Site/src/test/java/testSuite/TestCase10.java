package testSuite;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class TestCase10 {
    private final String URL="http://live.techpanda.org/index.php/backendlogin/";
    private final String id="***";
    private final String pass="*****";

    private final String path="C:\\Users\\Nermeen\\Downloads\\orders.csv";

    private final String to="***********";
    private final String passw="************";
    private final String from="****************";
    @BeforeTest
    public void OpenSite(){
        //Open site by clicking on URL
        Utils.setupCredintials(URL);
    }
    @Test
    public void CreateReport() throws FileNotFoundException, InterruptedException {
          //login with the credentials provided in test data
            Utils.driver.findElement(By.xpath("//input[@id=\"username\"]")).clear();
            Utils.driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(id);
            Utils.driver.findElement(By.xpath("//input[@id=\"login\"]")).clear();
            Utils.driver.findElement(By.xpath("//input[@id=\"login\"]")).sendKeys(pass);
            Utils.driver.findElement(By.xpath("//input[@class=\"form-button\"]")).click();

           //Close popup window
            Utils.driver.findElement(By.xpath("//div[@id=\"message-popup-window\"]/div/a/span")).click();

           //From select -> orders
            Utils.driver.findElement(By.xpath("//ul[@id=\"nav\"]/li/a/span")).click();
            Utils.driver.findElement(By.xpath("//ul/li[@class=\"  level1\"]/a/span")).click();
           //Export CSV file
            new Select(Utils.driver.findElement(By.id("sales_order_grid_export"))).selectByVisibleText("CSV");
            Utils.driver.findElement(By.xpath("//button[@title=\"Export\"]")).click();

            Thread.sleep(10000);
            // Read csv file in console
            Utils.readCSVFile(path);
            // Send File through email





    }
    @AfterTest
    public void teardown(){
        Utils.sendEmail(to,passw,from,path);
    }
}
