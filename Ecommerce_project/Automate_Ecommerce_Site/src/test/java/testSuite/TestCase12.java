package testSuite;

import net.bytebuddy.TypeCache;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

public class TestCase12 {
    //Verify Sort is working correctly
    private String URL="http://live.techpanda.org/index.php/backendlogin";
    private final String id="user01";
    private final String pass="guru99com";

   @BeforeTest
    public void OpenSite(){
        Utils.setupCredintials(URL);
    }
    @Test
    public void CheckSortFuc() throws InterruptedException {

        Utils.driver.findElement(By.xpath("//input[@id=\"username\"]")).clear();
        Utils.driver.findElement(By.xpath("//input[@id=\"username\"]")).sendKeys(id);
        Utils.driver.findElement(By.xpath("//input[@id=\"login\"]")).clear();
        Utils.driver.findElement(By.xpath("//input[@id=\"login\"]")).sendKeys(pass);
        Utils.driver.findElement(By.xpath("//input[@class=\"form-button\"]")).click();

        System.out.println("Credentials entered successfully");

        //Close popup window
        Utils.driver.findElement(By.xpath("//div[@id=\"message-popup-window\"]/div/a/span")).click();
        System.out.println("Pop UP window closed successfully");

        Utils.driver.findElement(By.xpath("//*[@id=\"nav\"]/li[1]/a/span")).click();
        Utils.driver.findElement(By.xpath("//*[@id=\"nav\"]/li[1]/ul/li[2]/a/span")).click();
        System.out.println("Invoice selected successfully");
        //Store items before being sorted
        List<String> itemsBeforeSort= new ArrayList();
        for (int i=1;i<=20;i++)
            itemsBeforeSort.add(Utils.driver.findElement(By.xpath("//*[@id=\"sales_invoice_grid_table\"]/tbody/tr["+i+"]/td[2]")).getText());
        itemsBeforeSort.sort(Collections.reverseOrder());//Sort the items
        Utils.driver.findElement(By.xpath("//*[@id=\"sales_invoice_grid_table\"]/thead/tr[1]/th[3]/span/a")).click();
        //Selected items to be sorted in dsc order
        List<String> itemsAfterSort= new ArrayList();
        for (int i=1;i<=20;i++){
            Thread.sleep(3000);
            itemsAfterSort.add(Utils.driver.findElement(By.xpath("//*[@id=\"sales_invoice_grid_table\"]/tbody/tr["+i+"]/td[2]")).getText());
        }

       if(itemsBeforeSort.equals(itemsBeforeSort))
           System.out.println("Items are sorted correctly");
       else
           System.out.println("Items are not sorted correctly");

    }
    @Test
    public void teardown(){
       Utils.driver.close();
    }
}
