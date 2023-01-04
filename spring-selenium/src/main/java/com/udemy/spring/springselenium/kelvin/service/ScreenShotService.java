package com.udemy.spring.springselenium.kelvin.service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Lazy
@Service
public class ScreenShotService {
    private static final AtomicLong atomicCounter = new AtomicLong(0);

    @Autowired
    private ApplicationContext ctx;

    @Value("${screenshot.path}")
    private Path path;


    private String getImageName(){
        String imageName = new SimpleDateFormat("yyyyMMddHHmm'.png'").format(new Date());
        return atomicCounter.getAndIncrement() + "_" + imageName;
    }

    public void takeScreenshot() throws IOException {
        File sourceFile = ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        FileCopyUtils.copy(sourceFile, this.path.resolve(getImageName()).toFile());
    }
}
