package com.udemy.spring.springselenium;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = "com.udemy.spring.springselenium.bdd",
        //tags =  "@visa",
        plugin = {
                "pretty",
                "html:src\\test\\resources\\screenshots2\\temp"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
