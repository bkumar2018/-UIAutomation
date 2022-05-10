package com.qa.utils;

import com.qa.constants.FileConstants;
import com.qa.utils.dynamicParams.DataFactory;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import org.testng.Reporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Arrays;

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
            tabArray = new String[endRow - startRow][endCol - startCol - 1];
            ci = 0;
            for(int i= startRow + 1; i <= endRow ; ++i, ++ci){
                cj =0;
                for(int j = startCol + 1; j < endCol ; j++, cj++){
                    tabArray[ci][cj] = DataFactory.getData(sheet.getCell(j, i).getContents().trim()).toString();
                }
            }
            workbook.close();

        }catch (final Exception e){
            System.out.println("Table not found. Verify the start tag in the sheet :"+ tableName);
            System.out.println(e);
        }

        return tabArray;
    }


    public String getCellValueFromCSV(String file, String columnName) throws Exception {
        String colValues = "";

        try{
            @SuppressWarnings("resource")
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "0";
            int count = 0;
            int advIndex = 0;
            while((line = bufferedReader.readLine()) != null){
                String[] cols = line.split(",");
                if(count == 0){
                    advIndex = Arrays.asList(cols).indexOf(columnName);
                    if(advIndex < 0){
                        columnName = "\"" + columnName + "\"";
                        advIndex = Arrays.asList(cols).indexOf(columnName);
                    }
                }else{
                    if(advIndex != -1){
                        colValues = colValues.concat(cols[advIndex]).concat(";");
                    }
                }
                count++;
            }
            Reporter.log("Column Name: "+ columnName);
            Reporter.log("Column Value: "+ colValues);

        }catch (Exception e){
            e.printStackTrace();
        }

        return colValues;
    }
}
