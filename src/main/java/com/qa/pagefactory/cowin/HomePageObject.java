package com.qa.pagefactory.cowin;

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


    @FindBy (xpath = "//div[@class='govindia']/span[2]/a")
    public WebElement govindia_text;

    @FindBy(xpath="//ul[@class='topnavlinks']//li/a")
    public List<WebElement> list_we_toptabs;



}
