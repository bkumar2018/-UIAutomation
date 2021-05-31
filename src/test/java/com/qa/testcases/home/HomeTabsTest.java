package com.qa.testcases.home;

import com.qa.base.BaseClass;
import com.qa.scripts.HomePage;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class HomeTabsTest extends BaseClass {
    public static final Logger logger = Logger.getLogger(HomeTabsTest.class.getName());


    @Test(description = "verify tabs")
    public void verifyMenuTabs(){
        HomePage homePage = new HomePage(driver);
        homePage.verifyMenuTabs();
    }
}
