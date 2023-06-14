package testSuite;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Util {
    public static String URL="http://live.techpanda.org/index.php/";
    public static WebDriver driver;
    public static void setupCredintials(String URL) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        /*WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();*/
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
