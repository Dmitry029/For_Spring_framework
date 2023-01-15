package com.udemy.spring.springselenium.flights;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import com.udemy.spring.springselenium.page.flights.FlightPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Test class presenting reading property from property files
 */
public class FlightTest extends SpringBaseTestNGTest {
    @Autowired
    private FlightPage flightPage;

    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest(){
        this.flightPage.goTo(this.appDetails.getUrl());
        assertTrue(this.flightPage.isAt());
        assertEquals(this.flightPage.getLabels(), this.appDetails.getLabels());
    }
}
