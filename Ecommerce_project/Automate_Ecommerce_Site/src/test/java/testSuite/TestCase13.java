package testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase13 {
//Verify the product review mechanism
    private final String URL="http://live.techpanda.org/";
    private final String id="user01";
    private final String pass="guru99com";
    @BeforeTest
    public void OpenSite(){
        Utils.setupCredintials(URL);
    }
    @Test
    public void CheckReviewMechanism() throws InterruptedException {
       //Got to SONY XPERIA Page
        Utils.driver.get("http://live.techpanda.org/index.php/review/product/list/id/1/");

        //Enter the Review
        Utils.driver.findElement(By.xpath("//*[@id=\"Quality 1_3\"]")).click();
        Utils.driver.findElement(By.xpath("//*[@id=\"review_field\"]")).clear();
        Utils.driver.findElement(By.xpath("//*[@id=\"review_field\"]")).sendKeys("This is a good mobile");
        Utils.driver.findElement(By.xpath("//*[@id=\"summary_field\"]")).clear();
        Utils.driver.findElement(By.xpath("//*[@id=\"summary_field\"]")).sendKeys("this is good");
        Utils.driver.findElement(By.xpath("//*[@id=\"nickname_field\"]")).clear();
        Utils.driver.findElement(By.xpath("//*[@id=\"nickname_field\"]")).sendKeys("LALA");
        Utils.driver.findElement(By.xpath("//*[@id=\"review-form\"]/div[2]/button")).click();
         Thread.sleep(3000);
        //Go to backendlogin
       Utils.driver.get("http://live.techpanda.org/index.php/backendlogin");

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

      //Go to Catalogue -> Reviews and Ratings -> Customer Reviews ->Pending Reviews Menu

        Utils.driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/a/span")).click();
        Utils.driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li/a/span")).click();
        Utils.driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li/ul/li[1]/a/span")).click();
        Utils.driver.findElement(By.xpath("//*[@id=\"nav\"]/li[2]/ul/li/ul/li[1]/ul/li[1]/a/span")).click();

        System.out.println("Selected Reviews and Ratings -> Customer Reviews ->Pending Reviews Menu successfully ");


        //Select Edit Link
        Utils.driver.findElement(By.xpath("//*[@id=\"reviwGrid_table\"]/tbody/tr[1]/td[10]/a")).click();
         //Select Approved option
        new Select(Utils.driver.findElement(By.xpath("//*[@id=\"status_id\"]"))).selectByVisibleText("Approved");
        //save
        Utils.driver.findElement(By.xpath("//*[@id=\"save_button\"]")).click();

        System.out.println("Review is saved successfully");



        Utils.driver.get("http://live.techpanda.org/");

        Utils.driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[1]/a")).click();
        Utils.driver.findElement(By.xpath("//*[@id=\"product-collection-image-1\"]")).click();

        Utils.driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/ul/li[2]/span")).click();
      //Store all reviews
       String[] Reviews= new String[]{Utils.driver.findElement(By.xpath("//*[@id=\"customer-reviews\"]/dl")).getText()};
        for(String e:Reviews)
        { //Check my review is saves or not
             if(e.contains("This is a good mobile"))
            {
                System.out.println("Test Case Passed");
                break;
            }

        }



    }
    @Test
    public void teardown(){
        Utils.driver.close();
    }
}
