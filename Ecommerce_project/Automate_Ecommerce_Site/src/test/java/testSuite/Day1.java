package testSuite;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import static org.testng.Assert.assertEquals;


public class Day1 {
    @BeforeTest
    public void OpenTheSite() {
        Util.setupCredintials(Util.URL);
    }

    @Test
    public void TC1() {
        String ActualTitle = Util.driver.findElement(By.cssSelector("h2")).getText();
        //String ExpectedTitle="This is demo site for ";
        AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", ActualTitle);


    }

    @Test
    public void TC2() {
        String ActualTitle = Util.driver.getTitle();
        String ExpectedTitle = "Mobile page";
        WebElement mobile = Util.driver.findElement(By.className("level0"));
        mobile.click();
        //assertEquals(ActualTitle,ExpectedTitle);
        if (ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
            System.out.println("test case passed ");
        } else
            System.out.println("test case failed ");
    }

    @Test(dependsOnMethods = {"TC2"})
    public void TC3() throws IOException {
        Select byName = new Select(Util.driver.findElement(By.cssSelector("select[title=\"Sort By\"]")));
        byName.selectByVisibleText("Name");
        File scrFile = ((TakesScreenshot) Util.driver).getScreenshotAs(OutputType.FILE);
        String png = ("Image\\" + "SortedByName" + ".png");
        FileUtils.copyFile(scrFile, new File(png));

    }



    @AfterTest
    public void tearDown() throws Exception {
        Util.driver.quit();

    }
}









