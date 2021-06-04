package com.qa.base;

import com.qa.constants.ConfigConstants;
import com.qa.constants.DirectoryConstants;
import com.qa.io.ConfigReader;
import com.qa.utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;

import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is to get driver for all different type of browser drivers.
 * @author Birender
 */
public class DriverManager {
    public static final Logger logger = Logger.getLogger(DriverManager.class.getName());
    WebDriver driver;
    Properties prop = ConfigReader.readBaseConfig();

    /**
     * This method is to get driver for browser
     * @param browser
     * @return driver - WebDriver for browser
     */
    public WebDriver getDriver(String browser){
        if(driver == null ) {
            driver = initializeDriver(browser);
        }
        return  driver;
    }

    /**
     * This is method initilize the driver for specified browser
      * @param browser
     * @return driver - WebDriver
     */
    public WebDriver initializeDriver(String browser){
        String test_env = ConfigReader.readBaseConfig().getProperty(ConfigConstants.ApplicationConstants.TESTENVIRONMENT);
        String url = ConfigReader.readConfig(DirectoryConstants.getConfigDir()+test_env+".properties")
                .getProperty(ConfigConstants.ApplicationConstants.URL);
        System.out.print("Testing Environment url : "+url);
        if(browser.equalsIgnoreCase("chrome")){
            logger.info("Using chrome browser.");
            driver = new ChromeDriver(getChromeOptionsWithNetworkEnable());
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(BrowserUtils.IMPLICT_WAIT, TimeUnit.SECONDS);
            //driver.get(ConfigReader.readBaseConfig().getProperty(ConfigConstants.ApplicationConstants.URL));
            driver.get(url);
        }else if(browser.equalsIgnoreCase("Firefox")){
            logger.info("Using Firefox browser.");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(BrowserUtils.IMPLICT_WAIT, TimeUnit.SECONDS);
            //driver.get(ConfigConstants.ApplicationConstants.URL);
            driver.get(url);
        }else{
            System.out.println("Application does not support for "+ browser + " browser.");
            logger.info("Application does not support for "+ browser + " browser.");
        }
        return driver;
    }

    /**
     *
     * @return Chrome options with customized configurations
     */
    public ChromeOptions getChromeOptionsWithNetworkEnable(){
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.ALL);

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:loggingPrefs", logPrefs);
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setCapability(ChromeOptions.CAPABILITY, options);
        return options;
    }

}
