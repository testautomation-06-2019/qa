package com.jsystems.qa.frontend;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends ConfigFrontend {

    @Test
    public void firstFrontTest() {

        WebElement login = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in" +
                " a.x-nav-link.x-link"));
        WebElement buildEWebsite = driver.findElement(By.cssSelector("#lpc-headline " +
                ".lpc-headline-container.lp-headline-container h1 span:nth-child(1)"));
        assertTrue(buildEWebsite.isDisplayed());
        assertEquals(buildEWebsite.getText(), "Build a website,");

        assertTrue(login.isDisplayed());
        assertEquals(login.getText(), "Log In");
        login.click();

    }



}
