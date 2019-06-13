package com.jsystems.qa.qaapi.frontend.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage extends BasePage {

    public UserProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement buttonSave;

    @FindBy(css = ".material-icon.material-icon-notifications")
    public WebElement notification;
// mvn clean install -Dcucumber.options="--tags @wordpress --tags @login"
}
