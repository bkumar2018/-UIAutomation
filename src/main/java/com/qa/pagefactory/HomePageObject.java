package com.qa.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject {

    /**
     * @param driver - This driver will be used to look up the elements
     */
    public HomePageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = "//img[@class='logo-xs' and @alt='Aadhaar']")
    public WebElement logoAadhaar;


}
