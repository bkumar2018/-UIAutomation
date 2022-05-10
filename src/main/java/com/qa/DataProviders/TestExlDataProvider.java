package com.qa.DataProviders;

import com.qa.utils.ExcelUtilities;
import org.testng.annotations.DataProvider;

import java.io.File;

public class TestExlDataProvider {

    @DataProvider(name = "testExcelUtil")
    public static Object[][] getDataFromExcel(){
        final Object[][] objReturn = ExcelUtilities.getTableArray(System.getProperty("user.dir")
                + File.separator +"TestData" + File.separator + "testXlsData.xls", "sheetName1", "TestDataFeature1" );

        return objReturn;
    }
}
