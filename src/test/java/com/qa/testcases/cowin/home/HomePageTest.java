package com.qa.testcases.cowin.home;

import com.qa.base.BaseClass;
import com.qa.scripts.cowin.HomePage;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class HomePageTest extends BaseClass {
    public static final  Logger logger = Logger.getLogger(HomePageTest.class.getName());


    @Test(description = "verify Cowin Gov Text")
    public void verifyGovMoHFWText(){
        extentTest = extent.startTest("verifyGovMoHFWText","verify Cowin Gov Text");
        extentTest.assignCategory("Cowin");
        HomePage homePage = new HomePage(driver);
        homePage.verifyGovMoHFWText();
    }

}
