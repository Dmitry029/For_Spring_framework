package com.udemy.spring.springselenium.flight;

import com.udemy.spring.springselenium.flights.FlightTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.locale=en")
public class EnTest extends FlightTest {
}
