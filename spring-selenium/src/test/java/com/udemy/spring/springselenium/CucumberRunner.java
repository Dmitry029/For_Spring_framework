package com.udemy.spring.springselenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

/**
 * For run from maven use:
 * clean test -Dbrowser=firefox
 * clean test -Dcucumber.filter.tags=@google
 */
@CucumberOptions(
        features = "classpath:features",
        glue = "com.udemy.spring.springselenium.bdd",
        tags = "@visa",
        plugin = {
                "pretty",
                "html:src\\test\\resources\\cucumber-report.html"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
