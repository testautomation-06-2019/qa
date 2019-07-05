package com.jsystems.qa.frontend.clasicfrontend.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static java.lang.Thread.sleep;

public class WindowsTest extends ConfigFrontend {

    @Test
    public void testWindows() {
        String firstPageWindowHandle;
        String secondTestWindowHandle = null;

        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

        By byMywindowframe = By.id("mywindowframe");

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(byMywindowframe));

        WebElement windowFrame = driver.findElement(byMywindowframe);

        firstPageWindowHandle = driver.getWindowHandle();

        int hyperlinkYCoordinate = windowFrame.getLocation().getY();
        int hyperlinkXCoordinate = windowFrame.getLocation().getX();

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", windowFrame);


        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.visibilityOf(windowFrame));
        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.elementToBeClickable(windowFrame));

        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        windowFrame.click();

        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> testPageWindowHandle = driver.getWindowHandles();

        for (String windowHandle : testPageWindowHandle) {
            if (!firstPageWindowHandle.equals(windowHandle)) {
                secondTestWindowHandle = windowHandle;
            }
        }

        driver.switchTo().window(secondTestWindowHandle);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));

        driver.switchTo().window(secondTestWindowHandle).close();

        driver.switchTo().window(firstPageWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(byMywindowframe));

    }

    @Test
    public void frameTest(){
        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("testframe")));

        WebElement testframe = driver.findElement(By.name("testframe"));

        driver.switchTo().frame(testframe);

        String expectedFrameText =driver.findElement(By.id("testpagelink")).getText();
        String actualFrameText = "My frame text";

        if(actualFrameText.equals(expectedFrameText)){
            System.out.println("Found my frame text");
        }
        else {
            System.out.println("Did not find my frame text");
        }

        driver.switchTo().parentFrame();
    }
}
