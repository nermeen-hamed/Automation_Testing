package testSuite;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class TestCase04 {
    @Test
    public void TC1Day_4() throws IOException, InterruptedException {
        //Chose mobile
        String ExpectedTitle = "Mobile page";
        WebElement mobile = Utils.driver.findElement(By.className("level0"));
        mobile.click();
        // in details page choose sony xperia and iphone to be compared between them
        WebElement Sony_Xperia_item = Utils.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a"));
        Sony_Xperia_item.click();
        WebElement iphone_item = Utils.driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[3]/div/div[3]/ul/li[2]/a"));
        iphone_item.click();
        //click compare button
        WebElement compareButton = Utils.driver.findElement(By.cssSelector("[title=\"Compare\"]"));
        compareButton.click();
        //switch to popup window
        String MainWindow = Utils.driver.getWindowHandle();
        // To handle all new opened window.
        Set<String> s1 = Utils.driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        WebDriverWait wait = new WebDriverWait(Utils.driver, Duration.ofSeconds(3));
        while (i1.hasNext()) {
            String ChildWindow = i1.next();
            // Switching to popup window
            if (!MainWindow.equalsIgnoreCase(ChildWindow))//if Id of main page equals to id of child page ignored
            {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[title=\"Close Window\"]")));
                File scrFile = ((TakesScreenshot) Utils.driver).getScreenshotAs(OutputType.FILE);
                String png = ("Image\\" + "CompareWindow" + ".png");
                FileUtils.copyFile(scrFile, new File(png));
                Utils.driver.findElement(By.cssSelector("[title=\"Close Window\"]")).click();
            }
        }
        Utils.driver.switchTo().window(MainWindow);
    }
    @AfterTest
    public void tearDown() throws Exception {
        Utils.driver.quit();

    }
}
