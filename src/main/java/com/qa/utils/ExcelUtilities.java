package com.qa.utils;

import com.qa.constants.FileConstants;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import org.testng.Reporter;

import java.io.File;

public class ExcelUtilities {

    public static String[][] getTableArray(String xlsFilePath, String sheetName, String tableName){
        String[][] tabArray = null;

        try{
            final WorkbookSettings settings = new WorkbookSettings();
            settings.setSuppressWarnings(true);
            //xlsFilePath = FileConstants.getTestXlsDataFile();
            final Workbook workbook = Workbook.getWorkbook(new File(xlsFilePath), settings);
            Reporter.log("Accessing file: "+ xlsFilePath);
            final Sheet sheet = workbook.getSheet(sheetName);
            Reporter.log("Accessing worksheet :"+ sheetName);
            int startRow, startCol, endRow, endCol, ci, cj;
            final Cell tableStart = sheet.findCell(tableName);
            Reporter.log("Looking for prefix: "+ tableName);
            startRow = tableStart.getRow() + 1;
            startCol = tableStart.getColumn();
            final Cell tableEnd = sheet.findCell(tableName,startCol+1,startRow+1, 100,64000,false);
            endRow = tableEnd.getRow();
            endCol = tableEnd.getColumn();
            tabArray = new String[endRow -startRow][endCol-startCol-1];
            ci=0;


        }catch (Exception e){
            System.out.println("Table not found. Verify the start tag in the sheet :"+ tableName);
            System.out.println(e);
        }

        return tabArray;
    }

}
