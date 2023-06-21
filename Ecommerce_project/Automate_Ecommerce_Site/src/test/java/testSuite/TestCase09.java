package testSuite;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Verify that the discount works correctly
public class TestCase09 {
    private final String URL="http://live.techpanda.org/";
    private final String discountCode="GURU50";
    @BeforeTest
    public void OpenSite(){
        Utils.setupCredintials(URL);
    }
    @Test
    public void CheckDiscountTest(){
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

        //Click on mobile Link
        Utils.driver.findElement(By.linkText("MOBILE")).click();
        //Store price of IPhone
        String IPhonePrice= Utils.driver.findElement(By.xpath("//li[@class=\"item last\"]/div/div/span/span")).getText();
        String iphoneActualprice= IPhonePrice.replace("$"," ").trim();
        System.out.println("IPhonePrice is "+iphoneActualprice);
        double iphonefPrice=Double.parseDouble(iphoneActualprice);//500.00

        //Click on IPhone Item
        Utils.driver.findElement(By.xpath("//li[@class=\"item last\"]/div/div/button")).click();
        // send discount code GURU50
        WebElement discountField= Utils.driver.findElement(By.xpath("//div[@class=\"discount-form\"]/div/input"));
        discountField.clear();
        discountField.sendKeys(discountCode);
        //Click apply link
        Utils.driver.findElement(By.xpath("//div[@class=\"discount-form\"]/div/div/button")).click();
        //Chick that discount is played by 5%
        String discountCodeResult= Utils.driver.findElement(By.xpath("//tbody/tr[2]/td[@class=\"a-right\"][2]/span")).getText();//-$25.00
        String discountResult= discountCodeResult.replace("-","");//$25.00
        String fDiscountCode=discountResult.replace("$","").trim();//25.00
        System.out.println("fDiscountCode "+fDiscountCode);
        double actualdiscountCode=Double.parseDouble(fDiscountCode);
        double ExpecteddiscountCodeResult=25.00;

        if(actualdiscountCode==ExpecteddiscountCodeResult){
            System.out.println("Test case is Passed Discount code result is "+actualdiscountCode);
        }
        else
            System.out.println("Test case is Failed Discount code result is "+actualdiscountCode);
        String ActualGrandTotal= Utils.driver.findElement(By.xpath("//div/div/table[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]")).getText();//$475.00
        String ActualGrandTotalResult=ActualGrandTotal.replace("$","").trim();//475
        double ActualGrandTotalPrice=Double.parseDouble(ActualGrandTotalResult);
        double ExpectedGrandTotal=iphonefPrice-ExpecteddiscountCodeResult;//475.00

        if(ActualGrandTotalPrice==ExpectedGrandTotal){
            System.out.println("Test case is Passed Ground Total after applied discount code  "+ActualGrandTotal);
        }
        else
            System.out.println("Test case is Failed Ground Total after applied discount code is "+ActualGrandTotal +" not "+ExpectedGrandTotal);



    }
    @AfterTest
    public void AfterTesting(){
        Utils.driver.close();
    }

}
