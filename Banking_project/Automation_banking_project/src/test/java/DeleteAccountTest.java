import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteAccountTest {
    String URL = "http://www.demo.guru99.com/V4/";
    String AccountID="123448";
    @BeforeTest
    public void OpenSite() {
        Util.setupCredintials(URL);
    }

    @Test(dependsOnMethods = {"Util.managerLogin"})
    public void DeleteAccount() {
        //Click on Delete Account Link
        Util.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[7]/a")).click();
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(AccountID);
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")).click();
        try {
            Alert alert =Util.driver.switchTo().alert();
            String ActualResult=alert.getText();
            String ExpectedResult="Do you really want to delete this Account?";
            if(ActualResult.contains(ExpectedResult)){
                System.out.println("Test Case is passed your account is deleted");
                alert.accept();
            }
            else
                System.out.println("Test Case is Failed");
        }
        catch (NoAlertPresentException e){
            e.printStackTrace();
        }


    }

@Test(dependsOnMethods = {"Util.managerLogin"})
public void CheckMiniStatement(){
        Util.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[13]/a")).click();
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(AccountID);
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")).click();
    try {
        Alert alert =Util.driver.switchTo().alert();
        String ActualResult=alert.getText();
        String ExpectedResult="Account does not exist";
        if(ActualResult.contains(ExpectedResult)){
            System.out.println("Test Case is passed ");
            alert.accept();
        }
        else
            System.out.println("Test Case is Failed");
    }
    catch (NoAlertPresentException e){
        e.printStackTrace();
    }


}
    @Test(dependsOnMethods = {"Util.managerLogin"})
    public void CheckBalanceOfDeletedAccount(){
        Util.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[12]/a")).click();
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(AccountID);
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[11]/td[2]/input[1]")).click();
        try {
            Alert alert =Util.driver.switchTo().alert();
            String ActualResult=alert.getText();
            String ExpectedResult="Account does not exist";
            if(ActualResult.contains(ExpectedResult)){
                System.out.println("Test Case is passed ");
                alert.accept();
            }
            else
                System.out.println("Test Case is Failed");
        }
        catch (NoAlertPresentException e){
            e.printStackTrace();
        }

    }
@Test(dependsOnMethods = {"Util.managerLogin"})

public void CheckCustomizedStatement(){

        Util.driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[14]/a")).click();
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[6]/td[2]/input")).sendKeys(AccountID);
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[7]/td[2]/input")).sendKeys("01112020");
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[8]/td[2]/input")).sendKeys("01122020");
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[9]/td[2]/input")).sendKeys("1");
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input")).sendKeys("1");
        Util.driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[10]/td[2]/input")).click();
    try {
        Alert alert =Util.driver.switchTo().alert();
        String ActualResult=alert.getText();
        String ExpectedResult="Account does not exist";
        if(ActualResult.contains(ExpectedResult)){
            System.out.println("Test Case is passed ");
            alert.accept();
        }
        else
            System.out.println("Test Case is Failed");
    }
    catch (NoAlertPresentException e){
        e.printStackTrace();
    }
 }


}