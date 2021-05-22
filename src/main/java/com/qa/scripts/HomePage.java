package com.qa.scripts;

import com.qa.pagefactory.HomePageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.logging.Logger;

/**
 * @author - Birender
 * This class contains all the activity peformed on the home page.
 */
public class HomePage {

    private final Logger logger = Logger.getLogger(HomePage.class.getName());
    private final WebDriver driver;
    private final HomePageObject homePageObject;

    /**
     * This is constructor which will initialize all the necessary things to perform action
     *
     * @param driver - WebDriver instance on which action to be performed
     */
    public HomePage(WebDriver driver){
        this.driver = driver;
        homePageObject = new HomePageObject(driver);
    }

    public void verifyAadhaarLogo(){
        logger.info("Verifying Aadhaar logo");
        Assert.assertTrue(homePageObject.logoAadhaar.isDisplayed());
        logger.info("Verified Aadhaar logo");
    }


}
