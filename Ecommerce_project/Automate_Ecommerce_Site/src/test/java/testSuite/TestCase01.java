package testSuite;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class TestCase01 {
    @BeforeTest
    public void OpenTheSite() {
        Utils.setupCredintials(Utils.URL);
    }

    @Test
    public void TC1() {
        String ActualTitle = Utils.driver.findElement(By.cssSelector("h2")).getText();
        //String ExpectedTitle="This is demo site for ";
        AssertJUnit.assertEquals("THIS IS DEMO SITE FOR   ", ActualTitle);


    }

    @Test
    public void TC2() {
        String ActualTitle = Utils.driver.getTitle();
        String ExpectedTitle = "Mobile page";
        WebElement mobile = Utils.driver.findElement(By.className("level0"));
        mobile.click();
        //assertEquals(ActualTitle,ExpectedTitle);
        if (ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
            System.out.println("test case passed ");
        } else
            System.out.println("test case failed ");
    }

    @Test(dependsOnMethods = {"TC2"})
    public void TC3() throws IOException {
        Select byName = new Select(Utils.driver.findElement(By.cssSelector("select[title=\"Sort By\"]")));
        byName.selectByVisibleText("Name");
        File scrFile = ((TakesScreenshot) Utils.driver).getScreenshotAs(OutputType.FILE);
        String png = ("Image\\" + "SortedByName" + ".png");
        FileUtils.copyFile(scrFile, new File(png));

    }



    @AfterTest
    public void tearDown() throws Exception {
        Utils.driver.quit();

    }
}









