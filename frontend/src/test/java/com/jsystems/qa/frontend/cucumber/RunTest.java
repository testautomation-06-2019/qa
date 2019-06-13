package com.jsystems.qa.frontend.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "classpath:com.jsystems.qa.frontend.cucumber",
        plugin = {"html:target/cucumber-html-report", "rerun:target/rerun.txt"},
        tags = {
//                "@wordpress",
//                "@login",
//                "@userProfile",
                "@notification"
        }
)
public class RunTest {
}
