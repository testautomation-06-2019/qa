package com.jsystems.qa.frontend.clasicfrontend.test;

import com.jsystems.qa.frontend.Configuration;
import com.jsystems.qa.frontend.clasicfrontend.page.LoginPage;
import com.jsystems.qa.frontend.clasicfrontend.page.MainWordporessPage;
import com.jsystems.qa.frontend.clasicfrontend.page.UserPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends ConfigFrontend {
    MainWordporessPage wordporessPage;
    LoginPage loginPage;
    UserPage userPage;

    @Test
    public void firstFrontTest() {
        wordporessPage = new MainWordporessPage(driver);
        assertTrue(wordporessPage.buildEWebsite.isDisplayed());
        assertEquals(wordporessPage.buildEWebsite.getText(), "Build a website,");
        assertTrue(wordporessPage.login.isDisplayed());
        assertEquals(wordporessPage.login.getText(), "Log In");
        wordporessPage.login.click();
    }

    @Test
    public void loginTest() {
        login();

        userPage = new UserPage(driver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);
        assertTrue(userPage.userAvatar.isDisplayed());

//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//        driver.switchTo().alert();

    }

    @DisplayName("Login action test")
    @Test
    public void loginActionTest() {

        wordporessPage = new MainWordporessPage(driver);
        wordporessPage.waitForVisibilityOfElement(wordporessPage.login, 30);
        wordporessPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);

        Actions action = new Actions(driver);
        action
                .moveToElement(loginPage.emailInput)
                .sendKeys(Configuration.LOGIN)
                .sendKeys(Keys.chord(Keys.ENTER))
                .build()
                .perform();

        loginPage.waitForVisibilityOfElement(loginPage.passwordInput, 30);
        assertTrue(loginPage.buttonContinue.getText().equals("Log In"));
    }

    private void login() {
        wordporessPage = new MainWordporessPage(driver);
        wordporessPage.waitForVisibilityOfElement(wordporessPage.login, 30);
        wordporessPage.login.click();
        loginPage = new LoginPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(Configuration.LOGIN);
        loginPage.buttonContinue.click();
        loginPage.waitForVisibilityOfElement(loginPage.passwordInput, 30);
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(Configuration.PASSWORD);
        loginPage.buttonContinue.click();
    }


}
