package com.qa.testcases.aadhaar.home;

import com.qa.base.BaseClass;
import com.qa.scripts.aadhaar.HomePage;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class HomePageTest extends BaseClass {
    public static final  Logger logger = Logger.getLogger(HomePageTest.class.getName());


    @Test(description = "verify Aadhaar logo")
    public void verifyAadhaarLogo(){
        extentTest = extent.startTest("verifyAadhaarLogo","verify Aadhaar logo");
        extentTest.assignCategory("Aadhaar");

        HomePage homePage = new HomePage(driver);
        homePage.verifyAadhaarLogo();
    }

}
