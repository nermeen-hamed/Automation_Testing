package testSuite;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class Day10 {
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
        Util.setupCredintials(URL);
    }
    @Test
    public void CreateReport() throws FileNotFoundException, InterruptedException {
          //login with the credentials provided in test data
            Util.driver.findElement(By.xpath("//input[@id=\"username\"]")).clear();
            Util.driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(id);
            Util.driver.findElement(By.xpath("//input[@id=\"login\"]")).clear();
            Util.driver.findElement(By.xpath("//input[@id=\"login\"]")).sendKeys(pass);
            Util.driver.findElement(By.xpath("//input[@class=\"form-button\"]")).click();

           //Close popup window
            Util.driver.findElement(By.xpath("//div[@id=\"message-popup-window\"]/div/a/span")).click();

           //From select -> orders
            Util.driver.findElement(By.xpath("//ul[@id=\"nav\"]/li/a/span")).click();
            Util.driver.findElement(By.xpath("//ul/li[@class=\"  level1\"]/a/span")).click();
           //Export CSV file
            new Select(Util.driver.findElement(By.id("sales_order_grid_export"))).selectByVisibleText("CSV");
            Util.driver.findElement(By.xpath("//button[@title=\"Export\"]")).click();

            Thread.sleep(10000);
            // Read csv file in console
            Util.readCSVFile(path);
            // Send File through email





    }
    @AfterTest
    public void teardown(){
        Util.sendEmail(to,passw,from,path);
    }
}
