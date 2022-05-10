package com.qa.testcases.exceldemo;

import com.qa.DataProviders.TestExlDataProvider;
import org.testng.annotations.Test;

public class TestExcelDemo {

    @Test(priority = 0, dataProvider = "testExcelUtil", dataProviderClass = TestExlDataProvider.class)
    public void testExcelUtilDemo(String name, String age, String course, String city){
        System.out.println("name "+ name);
        System.out.println("age "+ age);
        System.out.println("course "+ course);
        System.out.println("city  "+ city);


    }
}
