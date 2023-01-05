package com.udemy.spring.springselenium.resourceTest;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ResourceTest extends SpringBaseTestNGTest {

    @Value("classpath:data/testdata.csv")
    private Resource resource;

    @Value("https://www.w3.org/Consortium/mission.html#vision")
    private Resource internetResource;


    /**
     * Read from file in the framefork
     */
    @Test
    public void resourceTest() throws IOException {
        Files.readAllLines(resource.getFile().toPath())
                .forEach(System.out::println);
    }

    /**
     * Read from file in the internet
     */
    @Test
    public void internetResourceTest() throws IOException {
       new String(internetResource.getInputStream().readAllBytes());
    }
}
