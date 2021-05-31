package com.qa.testcases.home;

import com.qa.base.BaseClass;
import com.qa.scripts.HomePage;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class HomePageTest extends BaseClass {
    public static final  Logger logger = Logger.getLogger(HomePageTest.class.getName());


    @Test(description = "verify Aadhaar logo")
    public void verifyAadhaarLogo(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyAadhaarLogo();
    }

}
