package com.udemy.spring.springselenium.googletest;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import com.udemy.spring.springselenium.page.google.GooglePage;
import com.udemy.spring.springselenium.kelvin.service.ScreenShotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.*;

public class Google1Test extends SpringBaseTestNGTest {
    @Autowired
    private GooglePage googlePage;

    @Autowired
    private ScreenShotService screenShotService;

    @Test
    public void googleTest() throws IOException {
        this.googlePage.goTo();
        assertTrue(this.googlePage.isAt());
        this.googlePage.getSearchComponent().search("spring boot");
        assertTrue(this.googlePage.getSearchResult().isAt());
        assertTrue(this.googlePage.getSearchResult().getCount() > 2);
        screenShotService.takeScreenshot();
        this.googlePage.close();
    }
}
