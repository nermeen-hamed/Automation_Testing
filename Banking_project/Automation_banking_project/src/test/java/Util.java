import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Util {
    public static WebDriver driver;
    private static final String NAME = "Data\\loginData.xlsx";



    public static void setupCredintials(String URL) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

@DataProvider(name ="loginData")
public static Object [][]getData() throws FileNotFoundException {

    File excelFile = new File(NAME);
    try {
        FileInputStream file = new FileInputStream(excelFile);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    XSSFWorkbook wb = null;
    try {
        wb = new XSSFWorkbook(excelFile);
    } catch (IOException | InvalidFormatException e) {
        e.printStackTrace();
    }
    XSSFSheet sheet = wb.getSheet("Sheet1");
    int rowsCount = sheet.getPhysicalNumberOfRows();
    int colsCounts = sheet.getRow(0).getLastCellNum();
    Object[][] data = new Object[rowsCount][colsCounts];
    for (int r = 0; r < rowsCount; r++) {
        XSSFRow row = sheet.getRow(r);
        for (int c = 0; c < colsCounts; c++) {
            XSSFCell cell = row.getCell(c);
            CellType cellType=cell.getCellType();
            switch (cellType){
                case STRING :
                    data[r][c] = cell.getStringCellValue().trim();
                    break;

            }

        }
    }
    return  data;
}
    @Test
    public void managerLogin(){
        driver.findElement(By.name("uid")).clear();
        driver.findElement(By.name("uid")).sendKeys("mngr506610");

        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("vYhedAg");

       driver.findElement(By.name("btnLogin")).click();
    }

public static void TakeScreenshot(String name) throws IOException {
    File fileSrc=((TakesScreenshot)Util.driver).getScreenshotAs(OutputType.FILE);
    String png = ("Image\\" + "["+name+"]" + ".png");
    FileUtils.copyFile(fileSrc,new File(png));
    //Util.driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[11]/td/a")).click();
}
    public static void afterTesting () throws InterruptedException {
            Util.driver.quit();
        }
    }


