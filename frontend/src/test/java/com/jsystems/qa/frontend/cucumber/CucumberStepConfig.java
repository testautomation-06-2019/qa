package com.jsystems.qa.frontend.cucumber;

import com.jsystems.qa.frontend.Configuration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CucumberStepConfig {

    WebDriver driver;

    @Before
    public static void setUpAll() {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemClassLoader().getResource("driver/geckodriver.exe").getFile());
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("driver/chromedriver.exe").getFile());
    }



    public WebDriver setUp() {
        String browser = Configuration.getBROWSER();

        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        } else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }

        setDriver();
        return driver;
    }

    private void setDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {

        System.out.println("=========================== @After Cucumber Test  =======================================");
        String status;
        if(!scenario.isFailed()) {
            status = "( ͡° ͜ʖ ͡°)";
//            status = "++++++++++";
            scenario.write("Scenario passed");
        } else {
            status = "(✖╭╮✖)";
//            status = "-------------";
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"images/png");
            scenario.write("Scenario failed");
        }
        System.out.println("\n"+status+" End of: " + scenario.getName() + " scenario.");
        driver.quit();
        driver = null;
    }


}
