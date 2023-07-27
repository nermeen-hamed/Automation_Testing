package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.omg.IOP.TAG_JAVA_CODEBASE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class TestCase3 {
    WebDriver driver;
    addItemToCartPage addObj;
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
    @Test
    public void addItemsToCart_Test() throws InterruptedException {
     setObj=new setLanguage(driver);
     setObj.setLanguageFunction();
     Thread.sleep(2000);
     addObj=new addItemToCartPage(driver);
     addObj.addSteps();
     assertEquals(addObj.returnName(),"Elsayaad cotton round neck sleeveless bodysuit for newborn kids - white");
     assertEquals(addObj.returnPrice(),52.00);
     assertEquals(addObj.returnTotalPrice(),52.00);

    }
}
