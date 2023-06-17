package testSuite;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Verify that the discount works correctly
public class Day9 {
    private final String URL="http://live.techpanda.org/";
    private final String discountCode="GURU50";
    @BeforeTest
    public void OpenSite(){
        Util.setupCredintials(URL);
    }
    @Test
    public void CheckDiscountTest(){
        //Click on my account
        Util.driver.findElement(By.xpath("//*[@class=\"skip-link skip-account\"]")).click();
        Util.driver.findElement(By.cssSelector("[title=\"My Account\"]")).click();
        //Switch to login page
        for(String window:Util.driver.getWindowHandles())
            Util.driver.switchTo().window(window);
        // Enter Login credentials
        Util.driver.findElement(By.id("email")).sendKeys("m49125366@gmail.com");
        Util.driver.findElement(By.id("pass")).sendKeys("Test123");
        Util.driver.findElement(By.id("send2")).click();

        //Click on mobile Link
        Util.driver.findElement(By.linkText("MOBILE")).click();
        //Store price of IPhone
        String IPhonePrice= Util.driver.findElement(By.xpath("//li[@class=\"item last\"]/div/div/span/span")).getText();
        String iphoneActualprice= IPhonePrice.replace("$"," ").trim();
        System.out.println("IPhonePrice is "+iphoneActualprice);
        double iphonefPrice=Double.parseDouble(iphoneActualprice);//500.00

        //Click on IPhone Item
        Util.driver.findElement(By.xpath("//li[@class=\"item last\"]/div/div/button")).click();
        // send discount code GURU50
        WebElement discountField=Util.driver.findElement(By.xpath("//div[@class=\"discount-form\"]/div/input"));
        discountField.clear();
        discountField.sendKeys(discountCode);
        //Click apply link
        Util.driver.findElement(By.xpath("//div[@class=\"discount-form\"]/div/div/button")).click();
        //Chick that discount is played by 5%
        String discountCodeResult=Util.driver.findElement(By.xpath("//tbody/tr[2]/td[@class=\"a-right\"][2]/span")).getText();//-$25.00
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
        String ActualGrandTotal=Util.driver.findElement(By.xpath("//div/div/table[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]")).getText();//$475.00
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
        Util.driver.close();
    }

}
