package com.jsystems.qa.frontend.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "usernameOrEmail")
    public WebElement emailInput;
//    public WebElement emailInput = driver.findElement(By.id("usernameOrEmail"));
    @FindBy(css = ".button.form-button")
    public WebElement buttonContinue;
//    public WebElement buttonContinue = driver.findElement(By.cssSelector(".button.form-button"));

    @FindBy(id = "password")
    public WebElement passwordInput;



}
