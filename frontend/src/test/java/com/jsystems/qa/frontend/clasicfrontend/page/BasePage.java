package com.jsystems.qa.frontend.clasicfrontend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibilityOfElement(WebElement element, int maxWaitTime) {
        WebDriverWait wait = new WebDriverWait(driver, maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
