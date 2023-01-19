package com.udemy.spring.springselenium.bdd;

import com.udemy.spring.springselenium.kelvin.annotation.LazyAutowired;
import com.udemy.spring.springselenium.page.google1.Google1Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.testng.Assert.assertTrue;

@SpringBootTest
@CucumberContextConfiguration
public class GoogleSteps {

    @LazyAutowired
    private Google1Page googlePage;

    @Given("I am on the google site")
    public void launchSite() {
        googlePage.goTo();
    }

    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
        googlePage.getSearchComponent().search(keyword);
    }

    @Then("I should see search results page")
    public void clickSearch() {
        assertTrue(googlePage.getSearchResult().isAt());
    }

    @Then("I should see at least {int} results")
    public void verifyResults(int count) {
        assertTrue(googlePage.getSearchResult().getCount() >= count);
    }
}
