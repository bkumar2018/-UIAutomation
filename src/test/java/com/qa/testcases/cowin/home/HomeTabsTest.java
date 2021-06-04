package com.qa.testcases.cowin.home;

import com.qa.base.BaseClass;
import com.qa.scripts.cowin.HomePage;
import org.testng.annotations.Test;

import java.util.logging.Logger;


public class HomeTabsTest extends BaseClass {
    public static final Logger logger = Logger.getLogger(com.qa.testcases.aadhaar.home.HomeTabsTest.class.getName());

    @Test(description = "verifyHomeTabs")
    public void verifyHomeTabs(){
        logger.info("verifyHomeTabs");
        HomePage homePage = new HomePage(driver);
        homePage.verifyTopLinks();
    }

}
