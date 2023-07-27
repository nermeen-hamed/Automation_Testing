package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase2 {
    org.openqa.selenium.WebDriver driver;
    signInPage SignInObj;
    setLanguage setObj;



    @BeforeClass
    public void openSite() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.eg/");
        System.out.println("Url has been opened successfully");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 0)
    public void signTest() throws InterruptedException {
        setObj=new setLanguage(driver);
        setObj.setLanguageFunction();
        Thread.sleep(2000);
        SignInObj=new signInPage(driver);
        SignInObj.signIn_Test("Test123@gmail.com","Test123@@");
        Assert.assertTrue(SignInObj.returnPageTitle().contains("Sign In"));
    }

   @AfterClass
    public void terminate() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
