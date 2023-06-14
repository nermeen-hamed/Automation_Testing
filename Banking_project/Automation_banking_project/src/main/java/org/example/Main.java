package org.example;


import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\Nermeen\\Documents\\mobile_data.xls";
        List<String> names=new ArrayList<String>();
        List<String> passwords=new ArrayList<String>();

        List<String> country=new ArrayList<String>();
         Workbook wbook;

        try {
            wbook= Workbook.getWorkbook(new File(path));
            Sheet shSheet=wbook.getSheet(0);
            for(int r=0;r<shSheet.getRows();r++) {
                names.add(shSheet.getCell(0, r).getContents());
                passwords.add(shSheet.getCell(1, r).getContents());


            }

        } catch (BiffException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    }
