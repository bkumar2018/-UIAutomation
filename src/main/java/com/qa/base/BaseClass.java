package com.qa.base;

import com.qa.constants.ConfigConstants;
import com.qa.io.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author Birender Kumar
 * This is a base of every test classes, all setup and teardown method are here.
 * Every test class must implement this class.
 */
public class BaseClass {

    public static final Logger logger = Logger.getLogger(BaseClass.class.getName());
    public static WebDriver driver;

    /**
     * This will get execute before suite start.
     * Start browser, initiate report.
     */
    @BeforeSuite
    public void setup(){
        logger.info("Inside setup.");
        DriverManager driverManager = new DriverManager();
        Properties prop = ConfigReader.readBaseConfig();
        driver = driverManager.getDriver(prop.getProperty(ConfigConstants.ApplicationConstants.BROWSER));

    }

    /**
     * This will execute before every Test class execution.
     * Login to application
     *
     */
    @BeforeClass
    public void beforeClass(){
        logger.info("Login to the application.");
        //Login login = new Login(driver);
        //login.loginToApp();
        //HomePage homePage = new HomePage(driver);
        //homePage.displayPage();

    }

    /**
     * Executes before every @Test method.
     *
     * @param method - Method name of current test case
     */
    @BeforeMethod
    public void setupBeforeMethod(Method method){

    }

    /**
     * This will get executed after every @Test method
     * Clean up method, Add test case to html report
     * Add failure along with exception in report.
     *
     * @param result - Result of current testcase execution
     * @param method - Method name of the current testcase.
     */
    @AfterMethod
    public void afterMethod(ITestResult result, Method method){

    }

    /**
     * This will get execute after every Test class execution.
     * Logout from the application
     */
    @AfterClass
    public void afterClass(){

    }

    /**
     * This will be executed after the suite is comepleted
     * quit the browser
     */
    @AfterSuite
    public void tearDown(){

    }
}
