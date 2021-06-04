package com.qa.scripts.aadhaar;

import com.qa.constants.HomePageConstants;
import com.qa.pagefactory.aadhaar.HomePageObject;
import com.qa.utils.WaitExecuter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Arrays;
import java.util.logging.Logger;

/**
 * @author - Birender
 * This class contains all the activity peformed on the home page.
 */
public class HomePage {

    private final Logger logger = Logger.getLogger(HomePage.class.getName());
    private final WebDriver driver;
    private final HomePageObject homePageObject;
    private WaitExecuter waitExecuter;

    /**
     * This is constructor which will initialize all the necessary things to perform action
     *
     * @param driver - WebDriver instance on which action to be performed
     */
    public HomePage(WebDriver driver){
        this.driver = driver;
        homePageObject = new HomePageObject(driver);
        waitExecuter = new WaitExecuter(driver);
    }

    public void verifyAadhaarLogo(){
        logger.info("Verifying Aadhaar logo");
        Assert.assertTrue(homePageObject.logoAadhaar.isDisplayed());
        logger.info("Verified Aadhaar logo");
    }

    public void verifyMenuTabs(){
        logger.info("Verifying Menu Tabs");

        String[] expectedTabs = {HomePageConstants.MenuTabs.MYAADHAAR,HomePageConstants.MenuTabs.ABOUTUIDAI,
                HomePageConstants.MenuTabs.CONTACTNSUPPORT,
                HomePageConstants.MenuTabs.ECOSYSTEM, HomePageConstants.MenuTabs.MEDIANRESOURCES };

        Assert.assertFalse(homePageObject.list_we_megamenu.isEmpty(), "There are no Tabs available");
        for(WebElement e: homePageObject.list_we_megamenu){
            waitExecuter.waitUntilElementIsPresent(e);
            String tabName = e.getText();
            logger.info(" The tabs name is: "+tabName);
            Assert.assertTrue(Arrays.asList(expectedTabs).contains(tabName), "The tabName: "+ tabName+ " not matched.");
        }
    }

}
