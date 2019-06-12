package com.jsystems.qa.frontend.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWordporessPage extends BasePage {

    public MainWordporessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in a.x-nav-link.x-link")
    public WebElement login;

//    public WebElement login = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in" +
//            " a.x-nav-link.x-link"));

    @FindBy(css = "#lpc-headline .lpc-headline-container.lp-headline-container h1 span:nth-child(1)")
    public WebElement buildEWebsite;
//    public WebElement buildEWebsite = driver.findElement(By.cssSelector("#lpc-headline " +
//            ".lpc-headline-container.lp-headline-container h1 span:nth-child(1)"));
}
