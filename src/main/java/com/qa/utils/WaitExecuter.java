package com.qa.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitExecuter {

    private WebDriver driver;
    private WebDriverWait wait;
    private final Integer MAXTIME = 60;

    public WaitExecuter(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, MAXTIME);
    }

    public void sleep(int milisecs){
        try {
            Thread.sleep(milisecs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitUntilElementIsPresent(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilAllElementIsPresent(List<WebElement> webElementList){
        wait.until(ExpectedConditions.visibilityOfAllElements(webElementList));
    }

    public void waitUntilElementIsClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }



    public void waiUntilUrlContains(String urlFraction){
        wait.until(ExpectedConditions.urlContains(urlFraction));
    }

    public void waitUntilPageIsFullyLoaded(){
        wait.until(
            wedDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitUntilTextToBeInElement(WebElement element, String textValue){
        wait.until(ExpectedConditions.textToBePresentInElement(element, textValue));
    }

    public void waitUntilTextNotToBeInWebElement(WebElement element, String textValue){
        int timer = 0;
        final int pollInterval = 500;
        while(timer < MAXTIME*1000) {
            if(element.getText().contains(textValue)) {
                sleep(500);
                timer += pollInterval;
            }else {
                return;
            }
        }
        throw new TimeoutException("Maximum time exceeded.");
    }
}
