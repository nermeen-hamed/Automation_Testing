package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase1 {
    WebDriver driver;
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
    public void change_Language_Test() throws java.lang.InterruptedException {
        setObj=new setLanguage(driver);
        setObj.setLanguageFunction();
        Thread.sleep(2000);
        boolean checkTheChange=setObj.checkChangeSuccessfully();
        Assert.assertTrue(checkTheChange);
    }

    @AfterClass
    public void terminate() throws java.lang.InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
