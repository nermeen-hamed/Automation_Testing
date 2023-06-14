


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.*;





public class loginTest {
    private static final String NAME = "Data\\loginData.xlsx";
     String URL="http://www.demo.guru99.com/V4/";
    @BeforeTest

    public void setup(){

        Util.setupCredintials(URL);

    }
//
    @Test (dataProvider = "loginData",dataProviderClass = Util.class)
    public void Login_testcases(String name,String password){


           String EXPECT_ERROR = "User or Password is not valid";

            Util.driver.findElement(By.name("uid")).clear();
            Util.driver.findElement(By.name("uid")).sendKeys(name);

            Util.driver.findElement(By.name("password")).clear();
            Util.driver.findElement(By.name("password")).sendKeys(password);
           System.out.println("Manager ID is "+password);

            Util.driver.findElement(By.name("btnLogin")).click();
        try{
            Alert alt = Util.driver.switchTo().alert();
            String  actualBoxMsg = alt.getText(); // get content of the Alter Message
            alt.accept();

            if(actualBoxMsg.equalsIgnoreCase(EXPECT_ERROR))

            {
                System.out.println("test case number  is Passed");
                Util.driver.navigate().back();
            }
            else
                System.out.println("test case number  is Failed");
        }
        catch (NoAlertPresentException Ex){
            String Expected_Title = "Guru99 Bank Manager HomePage";
            String actualTitle = Util.driver.getTitle();
            if(actualTitle.equalsIgnoreCase(Expected_Title))

            {
                System.out.println("test case number  is Passed");
                Util.driver.navigate().back();
            }
            else
                System.out.println("test case number  is Failed");

        }



    }


    @Test

    @AfterTest
    public void finishTesting() throws InterruptedException {

       Util.afterTesting();

  }
}
