package com.qa.scripts.cowin;

import com.qa.base.BaseClass;
import com.qa.constants.ConfigConstants;
import com.qa.constants.HomePageConstants;
import com.qa.pagefactory.cowin.HomePageObject;
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
public class HomePage extends BaseClass {

    private final Logger logger = Logger.getLogger(com.qa.scripts.aadhaar.HomePage.class.getName());
    private WebDriver driver;
    private HomePageObject homePageObject;
    private WaitExecuter waitExecuter;

    public HomePage(WebDriver driver){
        this.driver = driver;
        homePageObject = new HomePageObject(driver);
        waitExecuter = new WaitExecuter(driver);
    }

    public void verifyGovMoHFWText(){
        logger.info("verifyGovMoHFWText ");
        waitExecuter.waitUntilElementIsPresent(homePageObject.govindia_text);
        logger.info("Found text: "+homePageObject.govindia_text.getText());
        Assert.assertEquals(HomePageConstants.COWIN.GOVMoHFW_TEXT, homePageObject.govindia_text.getText(),
                "Mismatch GovMoHFW");
    }

    public void verifyTopLinks(){
        logger.info("verifyTopLinks ");

        String[] expected_topLinks = {HomePageConstants.COWIN.FAQ, HomePageConstants.COWIN.DASHBOARD,
                HomePageConstants.COWIN.OPENAPIS, HomePageConstants.COWIN.DEPARTMENT_LOGIN,
                HomePageConstants.COWIN.VACCINATOR, HomePageConstants.COWIN.VERIFY_CERTIFICATE };

        Assert.assertFalse(homePageObject.list_we_toptabs.isEmpty(), "Top Links tabs not found.");
        for(WebElement e: homePageObject.list_we_toptabs){
            waitExecuter.waitUntilElementIsPresent(e);
            String tabName = e.getText();
            logger.info(" The tab name is: "+tabName);
            Assert.assertTrue(Arrays.asList(expected_topLinks).contains(tabName), "Tab name: "+tabName+ " not macthed");
        }

    }


}
