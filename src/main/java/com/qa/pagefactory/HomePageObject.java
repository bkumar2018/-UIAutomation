package com.qa.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageObject {

    /**
     * @param driver - This driver will be used to look up the elements
     */
    public HomePageObject(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = "//img[@class='logo-xs' and @alt='Aadhaar']")
    public WebElement logoAadhaar;

    @FindBy(xpath="//ul[@class='megamenu level0']/li/a/span")
    public List<WebElement> list_we_megamenu;



}
