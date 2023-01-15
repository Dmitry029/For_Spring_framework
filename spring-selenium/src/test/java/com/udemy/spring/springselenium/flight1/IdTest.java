package com.udemy.spring.springselenium.flight1;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = {"app.locale=id", "browser=firefox"})
public class IdTest extends FlightTest{
}
