package com.udemy.spring.springselenium.flights;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import com.udemy.spring.springselenium.page.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightsTest extends SpringBaseTestNGTest {

    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest() {
        flightPage.goTo(appDetails.getUrl());
        Assert.assertEquals(flightPage.getLabels(), appDetails.getLabels());
    }
}
