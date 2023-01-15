package com.udemy.spring.springselenium.flight1;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.locale=en")
public class EnTest extends FlightTest {
    @TestPropertySource(properties = "app.locale=en")
    public static class EnTest extends FlightTest {
    }
}
