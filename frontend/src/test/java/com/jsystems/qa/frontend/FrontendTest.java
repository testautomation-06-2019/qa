package com.jsystems.qa.frontend;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest {

    @BeforeAll
    public static void setUpAll() {
//        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:/firefox/geckodriver.exe");
    }

    WebDriver driver;

    @Test
    public void firstFrontTest() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        driver.get("https://wordpress.com/");
//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        WebElement login = driver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in" +
                " a.x-nav-link.x-link"));
        WebElement buildEWebsite = driver.findElement(By.cssSelector("#lpc-headline " +
                ".lpc-headline-container.lp-headline-container h1 span:nth-child(1)"));
        assertTrue(buildEWebsite.isDisplayed());
        assertEquals(buildEWebsite.getText(), "Build a website,");

        assertTrue(login.isDisplayed());
        assertEquals(login.getText(), "Log In");
        login.click();


        driver.quit();
    }

}
