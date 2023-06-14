import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteCustomerTest {
    String URL="http://www.demo.guru99.com/V4/";
@BeforeTest
    public void openSite(){
    Util.setupCredintials(URL);
}
//Verify confirmation message is shown when customer is deleted
@Test(dependsOnMethods = {"Util.managerLogin"})
    public void TC1_DeleteCustomer(){
    Util.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[4]/a")).click();
    Util.driver.findElement(By.name("cusid")).sendKeys("71605");
    Util.driver.findElement(By.name("AccSubmit")).click();
    //Confirmation Message to delete the  customer
    try {
        Alert alert=Util.driver.switchTo().alert();
        String ActualResult=alert.getText();
        String ExpectedResult="Do you really want to delete this customer?";
        if(ActualResult.equalsIgnoreCase(ExpectedResult)){
            System.out.println("Test Case is Passed");
            alert.accept();
        }
       else
            System.out.println("Test Case is failed");
    }

    catch (NoAlertPresentException e){
        e.printStackTrace();
    }
    //Verify that customer should not be deleted if any account exists for that customer
    try {
        Alert alert=Util.driver.switchTo().alert();
        String ActualResult=alert.getText();
        String ExpectedResult="Customer could not be deleted!!. First delete all accounts of this customer then delete the customer";
        if(ActualResult.equalsIgnoreCase(ExpectedResult)){
            System.out.println("Test Case is Passed");
            alert.accept();
        }
        else
            System.out.println("Test Case is failed");
    }
    catch (NoAlertPresentException e){
        e.printStackTrace();

    }

}

//Verify that a Customer can be Deleted
@Test(dependsOnMethods = {"Util.managerLogin"})
public void TC2_DeleteCustomer(){
    Util.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[4]/a")).click();
    Util.driver.findElement(By.name("cusid")).sendKeys("5776");
    Util.driver.findElement(By.name("AccSubmit")).click();
    //Confirmation Message to delete the  customer
    try {
        Alert alert=Util.driver.switchTo().alert();
        String ActualResult=alert.getText();
        String ExpectedResult="Do you really want to delete this customer?";
        if(ActualResult.equalsIgnoreCase(ExpectedResult)){
            System.out.println("Test Case is Passed");
            alert.accept();
        }
        else
            System.out.println("Test Case is failed");
    }

    catch (NoAlertPresentException e){
        e.printStackTrace();
    }
    try {
        Alert alert=Util.driver.switchTo().alert();
        String ActualResult=alert.getText();
        String ExpectedResult="Customer deleted successfully";
        if(ActualResult.equalsIgnoreCase(ExpectedResult)){
            System.out.println("Test Case is Passed");
            alert.accept();
        }
        else
            System.out.println("Test Case is failed");
    }

    catch (NoAlertPresentException e){
        e.printStackTrace();
    }
}
//Verify deleted customer cannot be edited
    @Test(dependsOnMethods = {"Util.managerLogin"})
    public void TC3_DeleteCustomer(){
    Util.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/a")).click();
    Util.driver.findElement(By.name("cusid")).sendKeys("5776");
    Util.driver.findElement(By.name("AccSubmit")).click();

        try {
            Alert alert=Util.driver.switchTo().alert();
            String ActualResult=alert.getText();
            String ExpectedResult="Customer does not exist!!";
            if(ActualResult.equalsIgnoreCase(ExpectedResult)){
                System.out.println("Test Case is Passed");
                alert.accept();
            }
            else
                System.out.println("Test Case is failed");
        }

        catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

@Test
    public void afterTest() throws InterruptedException {
    Util.afterTesting();
}
}
