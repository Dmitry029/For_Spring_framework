package com.udemy.spring.springselenium.flights;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.locale=id")
public class IdTest extends FlightsTest{
}
